/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.containertype;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym
 * 
 */
@Controller
@RequestMapping(ContainerTypeController.URL_PREFIX)
public class ContainerTypeController extends CRUDController<ContainerType> {

  /** Prefix of urls of this module. */
  public static final String URL_PREFIX = "/inventory/containertype";

  /** Create container subcategory subflow id. */
  static final int CONTAINERSUBCATEGORY_SUBFLOW_ID = 0;

  /** Create container type subflow id. */
  static final int CONTAINERTYPE_SUBFLOW_ID = 1;

  /** Create layout subflow id. */
  static final int LAYOUT_SUBFLOW_ID = 2;
  
  /** Create Category subflow id. */
  static final int CATEGORY_SUBFLOW_ID = 3;
  
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";

  private GenericService<ContainerSubcategory> containerSubcategoryService;
  private GenericService<Layout> layoutService;
  private GenericService<Type> typeService;

  /**
   * Default constructor.
   */
  public ContainerTypeController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/inventory/containersubcategory/create.do", 
                                        "/inventory/containertype/create.do",
                                        "/inventory/layout/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.CONTAINER});
    config.setAdvancedSearch(true);
  }

  /**
   * Adds the category to the model.
   * @param model The model to which the categories must be added.
   */
  void addCategories(ModelAndView model) {
    ContainerType containerType = ((ContainerTypeForm) model.getModel().get("form")).getEntity();
    if (containerType.getContainerSubcategory() != null) {
      Long subcategoryId = containerType.getContainerSubcategory().getId();
      ContainerSubcategory subCategory = containerSubcategoryService.findById(ContainerSubcategory.class, subcategoryId);
      model.addObject("category", subCategory.getType());
    } 
  }

  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") ContainerTypeForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeDetailsModel(ModelAndView model, Locale locale) {
    addCategories(model);
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    model.addObject("compositions", I18nEnumerationHelper.getLocalizedValues(ContainerComposition.class, locale));
    
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.CONTAINER.name());
    List<Type> containerCategories = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("containerCategories", containerCategories);
    
    List<ContainerSubcategory> containerSubcategories = containerSubcategoryService.findAll(ContainerSubcategory.class, "name");
    model.addObject("containerSubcategories", containerSubcategories);

    List<ContainerType> containerTypes = super.getMainService().findAll(ContainerType.class, "name");
    model.addObject("containerTypes", containerTypes);

    List<Layout> layouts = layoutService.findAll(Layout.class, "name");
    model.addObject("layouts", layouts);

    addCategories(model);
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      ContainerType containerType = ((ContainerTypeForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case CONTAINERSUBCATEGORY_SUBFLOW_ID: {
          containerType.setContainerSubcategory(EntityWithIdHelper.createEntity(ContainerSubcategory.class, entityId));
          break;
        }
        case CONTAINERTYPE_SUBFLOW_ID: {
          containerType.setChildContainerType(EntityWithIdHelper.createEntity(ContainerType.class, entityId));
          break;
        }
        case LAYOUT_SUBFLOW_ID: {
          containerType.getLayoutCollection().add(EntityWithIdHelper.createEntity(Layout.class, entityId));
          break;
        }
        case CATEGORY_SUBFLOW_ID : {
          containerType.setContainerSubcategory(null);
          model.addObject("category", typeService.findById(Type.class, entityId));
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @return The list view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") ContainerTypeForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param containerSubcategory the containerSubcategoryService to set
   */
  @Resource(name = "containerSubcategoryService")
  public void setContainerSubcategoryService(GenericService<ContainerSubcategory> containerSubcategory) {
    containerSubcategoryService = containerSubcategory;
  }

  /**
   * @param containerTypeService the containerTypeService to set
   */
  @Resource(name = "containerTypeService")
  public void setContainerTypeService(GenericService<ContainerType> containerTypeService) {
    super.setMainService(containerTypeService);
  }

  /**
   * @param layoutService the layoutService to set
   */
  @Resource(name = "layoutService")
  public void setLayoutService(GenericService<Layout> layoutService) {
    this.layoutService = layoutService;
  }
  
  /**
   * @param typeService the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> typeService) {
    this.typeService = typeService;
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "containerTypeFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "containerTypeTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

}
