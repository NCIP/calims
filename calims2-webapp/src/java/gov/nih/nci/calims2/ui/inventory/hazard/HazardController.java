/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.hazard;

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
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Hazard;
import gov.nih.nci.calims2.domain.inventory.LabSupply;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;

/**
 * @author viseem
 *
 */
@Controller
@RequestMapping(HazardController.URL_PREFIX)
public class HazardController extends CRUDController<Hazard> {

  /** Prefix of urls of this module. */
  public static final String URL_PREFIX = "/inventory/hazard";
  
  /** Create type subflow id.   */
  static final int TYPE_SUBFLOW_ID = 0;
  
  /** Create lab supply subflow id.   */
  static final int LABSUPPLY_SUBFLOW_ID = 1;
  
  /** Create lab hazard container subflow id.   */
  static final int HAZARDCONTAINER_SUBFLOW_ID = 2;
  
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";
  
  private GenericService<Container> containerService;
  private GenericService<LabSupply> labSupplyService;
  private GenericService<Specimen> specimenService;
  private GenericService<Type> typeService;

  /**
   * Default constructor.
   */
  public HazardController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/common/type/create.do?dataElementCollection=" + TypeEnumeration.HAZARD,
            "/inventory/labsupply/create.do",
            "/inventory/container/create.do" });
    config.setAdvancedSearch(true);
  }

  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") HazardForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<Container> containers = containerService.findAll(Container.class, "name");
    model.addObject("containers", containers);

    List<LabSupply> labSupplies = labSupplyService.findAll(LabSupply.class, "name");
    model.addObject("labSupplies", labSupplies);
    
    List<Specimen> specimens = specimenService.findAll(Specimen.class, "name");
    model.addObject("specimens", specimens);

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.HAZARD.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);
    
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Hazard hazard = ((HazardForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case TYPE_SUBFLOW_ID: {
          hazard.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
          break;
        }
        case LABSUPPLY_SUBFLOW_ID: {
          hazard.setLabSupply(EntityWithIdHelper.createEntity(LabSupply.class, entityId));
          break;
        }
        case HAZARDCONTAINER_SUBFLOW_ID: {
          hazard.setContainer(EntityWithIdHelper.createEntity(Container.class, entityId));
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
  public ModelAndView save(@ModelAttribute("form") HazardForm form, Locale locale) {
    return doSave(form, locale);
  }
  
  /**
   * @param container the containerService to set
   */
  @Resource(name = "containerService")
  public void setContainerService(GenericService<Container> container) {
    containerService = container;
  }

  /**
   * @param hazardService the hazardService to set
   */
  @Resource(name = "hazardService")
  public void setMainService(GenericService<Hazard> hazardService) {
    super.setMainService(hazardService);
  }
  
  /**
   * @param labSupply the labSupplyService to set
   */
  @Resource(name = "labSupplyService")
  public void setLabSupplyService(GenericService<LabSupply> labSupply) {
    labSupplyService = labSupply;
  }
  
  /**
   * @param specimen the specimenService to set
   */
  @Resource(name = "specimenService")
  public void setSpecimenService(GenericService<Specimen> specimen) {
    specimenService = specimen;
  }

  /**
   * @param type the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> type) {
    typeService = type;
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "hazardFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "hazardTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

}
