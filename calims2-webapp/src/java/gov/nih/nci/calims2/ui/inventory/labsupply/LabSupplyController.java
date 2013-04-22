/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.labsupply;

import java.util.HashMap;
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
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.LabSupply;
import gov.nih.nci.calims2.domain.inventory.enumeration.LabSupplyStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelper;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
@Controller
@RequestMapping(LabSupplyController.URL_PREFIX)
public class LabSupplyController extends CRUDController<LabSupply> {

  /** Prefix of urls of this module. */
  public static final String URL_PREFIX = "/inventory/labsupply";

  /** Create type subflow id.*/ 
  static final int TYPE_SUBFLOW_ID = 0;
  /** Create organization subflow id. */
  static final int ORGANIZATION_SUBFLOW_ID = 1;
  /** Create standard unit subflow id.*/ 
  static final int STANDARD_UNIT_SUBFLOW_ID = 2;
  /** Create specimen subflow id.*/ 
  static final int CONTAINER_SUBFLOW_ID = 3;
  /** Create specimen subflow id.*/ 
  static final int PERSON_SUBFLOW_ID = 4;
  
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";
  
  private GenericService<Organization> organizationService;
  private QuantityHelper quantityHelper;
  private GenericService<Type> typeService;
  private GenericService<StandardUnit> unitService;
  private GenericService<Container> containerService;
  private GenericService<Person> personService;

  /**
   * Default constructor.
   */
  public LabSupplyController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/common/type/create.do?dataElementCollection=" + TypeEnumeration.LABSUPPLY,
                                        "/administration/organization/create.do",
                                        "/administration/standardunit/create.do",
                                        "/inventory/container/create.do",
                                        "/administration/person/create.do",
                                        "/common/externalidentifier/enterList.do"});
    config.setAdvancedSearch(true);
  }
  
  /**
   * 
   * @param model The model to which the quantities must be added.
   * @param createMissing True if quantities missing in the container class must be added.
   */
  void addQuantities(ModelAndView model, boolean createMissing) {
    Set<Quantity> quantities = ((LabSupplyForm) model.getModel().get("form")).getEntity().getQuantityCollection();
    model.addObject("quantities", quantityHelper.getQuantities(TypeEnumeration.LABSUPPLY_QUANTITY, quantities, createMissing));
  }

  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") LabSupplyForm form, @RequestParam("subFlowId") int subFlowId) {
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

    model.addObject("labSupplyStatuses", I18nEnumerationHelper.getLocalizedValues(LabSupplyStatus.class, locale));
    List<Container> containers = containerService.findAll(Container.class, "name");
    model.addObject("containers", containers);

    List<Organization> organizations = organizationService.findAll(Organization.class, "name");
    model.addObject("organizations", organizations);

    List<Person> persons = personService.findAll(Person.class, "familyName");
    model.addObject("persons", persons);

    addQuantities(model, true);

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.LABSUPPLY.getName());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);

    List<StandardUnit> units = unitService.findAll(StandardUnit.class, "name");
    model.addObject("standardUnits", units);
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      LabSupply labSupply = ((LabSupplyForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case ORGANIZATION_SUBFLOW_ID: {
          labSupply.getOrganizationCollection().add(EntityWithIdHelper.createEntity(Organization.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          labSupply.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
          break;
        }
        case STANDARD_UNIT_SUBFLOW_ID: {
          break;
        }
        case CONTAINER_SUBFLOW_ID: {
          labSupply.setContainer(EntityWithIdHelper.createEntity(Container.class, entityId));
          break;
        }
        case PERSON_SUBFLOW_ID: {
          labSupply.getPersonCollection().add(EntityWithIdHelper.createEntity(Person.class, entityId));
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
  public ModelAndView save(@ModelAttribute("form") LabSupplyForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param labSupplyService the labSupplyService to set
   */
  @Resource(name = "labSupplyService")
  public void setMainService(GenericService<LabSupply> labSupplyService) {
    super.setMainService(labSupplyService);
  }

  /**
   * @param organization the organizationService to set
   */
  @Resource(name = "organizationService")
  public void setOrganizationService(GenericService<Organization> organization) {
    organizationService = organization;
  }

  /**
   * @param person the personService to set
   */
  @Resource(name = "personService")
  public void setPersonService(GenericService<Person> person) {
    personService = person;
  }

  /**
   * @param quantityHelper the quantityHelper to set
   */
  @Resource(name = "quantityHelper")
  public void setQuantityHelper(QuantityHelper quantityHelper) {
    this.quantityHelper = quantityHelper;
  }

  /**
   * @param container the containerService to set
   */
  @Resource(name = "containerService")
  public void setContainerService(GenericService<Container> container) {
    containerService = container;
  }

  /**
   * @param type the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> type) {
    typeService = type;
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
  @Resource(name = "labSupplyFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "labSupplyTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
