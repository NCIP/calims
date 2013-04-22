/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.standardunit;

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
import gov.nih.nci.calims2.domain.administration.BaseUnit;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;

/**
 * @author katariap
 *
 */
@Controller
@RequestMapping(StandardUnitController.URL_PREFIX)
public class StandardUnitController extends CRUDController<StandardUnit> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/standardunit";
  
  /** Create baseunit subflow id.*/ 
  static final int BASEUNIT_SUBFLOW_ID = 0;
  
  /** Create type subflow id.*/ 
  static final int TYPE_SUBFLOW_ID = 1;
  
  private GenericService<Type> typeService;
  
  /**
   * Default constructor.
   */
  public StandardUnitController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/baseunit/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.UNIT});
    config.setAdvancedSearch(true);
  }
  
  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
   
    List<BaseUnit> baseunits = ((GenericService) super.getMainService()).findAll(BaseUnit.class, "name");
    model.addObject("baseunits", baseunits);
    Map<String, Object> params1 = new HashMap<String, Object>();
    params1.put("dataElementCollection", TypeEnumeration.UNIT.name());
    List<Type> types = typeService.findByNamedQuery(Type.class.getName() + ".findByDataElementCollection", params1);
    model.addObject("types", types);
    return model;
  }
  
  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") StandardUnitForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      StandardUnit standardUnit = ((StandardUnitForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case TYPE_SUBFLOW_ID: {
          standardUnit.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
          break;
        }
        case BASEUNIT_SUBFLOW_ID: {
          standardUnit.setBaseUnit(EntityWithIdHelper.createEntity(BaseUnit.class, entityId));
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
  public ModelAndView save(@ModelAttribute("form") StandardUnitForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param unitService the unitService to set
   */
  @Resource(name = "unitService")
  public void setUnitService(GenericService<StandardUnit> unitService) {
    super.setMainService(unitService);
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
  @Resource(name = "standardUnitFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "standardUnitTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
