/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.rate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.RateStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelper;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
@Controller
@RequestMapping(RateController.URL_PREFIX)
public class RateController extends CRUDController<Rate> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/customerservice/rate";
  
  /** Create person sub flow. */
  static final int PERSON_SUBFLOW_ID = 0;
  
  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 1;
  
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";

  private GenericService<Person> personService;
  private GenericService<Type> typeService;
  private GenericService<StandardUnit> unitService;
  
  private QuantityHelper quantityHelper;

  /**
   * Default constructor.
   */
  public RateController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/person/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.RATE });
    config.setAdvancedSearch(true);
  }
  
  
  /**
   * 
   * @param model The model to which the quantities must be added.
   * @param createMissing True if quantities missing in the container class must be added.
   */
  void addQuantities(ModelAndView model, boolean createMissing) {
    Set<Quantity> quantities = new HashSet<Quantity>();
    Object obj = ((RateForm) model.getModel().get("form")).getEntity().getQuantity();
    if (obj != null) {
      quantities.add(((RateForm) model.getModel().get("form")).getEntity().getQuantity());
    }
    model.addObject("quantities", quantityHelper.getQuantities(TypeEnumeration.RATE_QUANTITY, quantities, createMissing));
  }
  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") RateForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeDetailsModel(ModelAndView model, Locale locale) {
    addQuantities(model, false);
    return model;
  }
  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    model.addObject("rateStatuses", I18nEnumerationHelper.getLocalizedValues(RateStatus.class, locale));
    
    List<Person> persons = personService.findAll(Person.class, "familyName");
    model.addObject("persons", persons);
    
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.RATE.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);
    List<StandardUnit> units = unitService.findAll(StandardUnit.class, "name");
    model.addObject("standardUnits", units);
    addQuantities(model, true);
    
    
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Rate rate = ((RateForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case PERSON_SUBFLOW_ID: {
          rate.setContactPerson(EntityWithIdHelper.createEntity(Person.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          rate.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
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
   * @return The list type view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") RateForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param rateService the rateService to set
   */

  @Resource(name = "rateService")
  public void setRateService(GenericService<Rate> rateService) {
    super.setMainService(rateService);
  }
  
  /**
   * @param quantityHelper the quantityHelper to set
   */
  @Resource(name = "quantityHelper")
  public void setQuantityHelper(QuantityHelper quantityHelper) {
    this.quantityHelper = quantityHelper;
  }

  /**
   * @param type the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> type) {
    typeService = type;
  }

  /**
   * @param person the personService to set
   */
  @Resource(name = "personService")
  public void setPersonService(GenericService<Person> person) {
    personService = person;
  }
  /**
   * @param unitService the unitService to set
   */
  @Resource(name = "unitService")
  public void setUnitService(GenericService<StandardUnit> unitService) {
    this.unitService = unitService;
  }
  
  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "rateFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "rateTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
