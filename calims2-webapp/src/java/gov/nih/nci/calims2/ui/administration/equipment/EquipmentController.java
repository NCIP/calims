/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.equipment;

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
import gov.nih.nci.calims2.domain.administration.Equipment;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Software;
import gov.nih.nci.calims2.domain.administration.enumeration.EquipmentStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.administration.namingconvention.NamingConventionHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
@Controller
@RequestMapping(EquipmentController.URL_PREFIX)
public class EquipmentController extends CRUDController<Equipment> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/equipment";

   /** Create person sub flow. */
  static final int PERSON_SUBFLOW_ID = 0;
  
  /** Create location sub flow. */
  static final int LOCATION_SUBFLOW_ID = 1;
  
  /** Create software sub flow. */
  static final int SOFTWARE_SUBFLOW_ID = 2;
  
  /** Create organization sub flow. */
  static final int ORGANIZATION_SUBFLOW_ID = 3;
  
  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 4;
  
  /** Create laboratory sub flow. */
  static final int LABORATORY_SUBFLOW_ID = 5;
  
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";

  // private GenericService<ElectronicDocument> electronicDocumentService;
  // private GenericService<Hazard> hazardService;
  private GenericService<Laboratory> laboratoryService;
  private GenericService<Location> locationService;
  private NamingConventionHelper namingConventionHelper;
  private GenericService<Organization> organizationService;
  private GenericService<Person> personService;
  private GenericService<Software> softwareService;
  private GenericService<Type> typeService;
  

  /**
   * Default constructor.
   */

  public EquipmentController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/person/create.do", 
                                        "/administration/location/create.do",
                                        "/administration/software/create.do", 
                                        "/administration/organization/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.EQUIPMENT, 
                                        "/administration/laboratory/create.do",
                                        "/common/document/enterList.do" });
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
  public ModelAndView call(@ModelAttribute("form") EquipmentForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    model.addObject("equipmentStatuses", I18nEnumerationHelper.getLocalizedValues(EquipmentStatus.class, locale));
    
    List<Laboratory> laboratories = laboratoryService.findAll(Laboratory.class, "name");
    model.addObject("laboratories", laboratories);
    
    List<Location> locations = locationService.findAll(Location.class, "name");
    model.addObject("locations", locations);
    model.addObject("namingConventions", namingConventionHelper.getNamingConventions(NamingConventionType.EQUIPMENTNAME));
    List<Organization> organizations = organizationService.findAll(Organization.class, "name");
    model.addObject("organizations", organizations);
    List<Person> persons = personService.findAll(Person.class, "familyName");
    model.addObject("persons", persons);
    List<Software> softwares = softwareService.findAll(Software.class, "name");
    model.addObject("softwares", softwares);

    // List<Hazard> hazards = hazardService.findAll(Hazard.class, "name");
    // model.addObject("hazards", hazards);

    // List<ElectronicDocument> electronicDocuments = electronicDocumentService.findAll(ElectronicDocument.class, "name");
    // model.addObject("electronicDocuments", electronicDocuments);

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.EQUIPMENT.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Equipment equipment = ((EquipmentForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case LABORATORY_SUBFLOW_ID: {
          equipment.setLaboratory(EntityWithIdHelper.createEntity(Laboratory.class, entityId));
          break;
        }
        case PERSON_SUBFLOW_ID: {
          equipment.getPersonCollection().add(EntityWithIdHelper.createEntity(Person.class, entityId));
          break;
        }
        case LOCATION_SUBFLOW_ID: {
          equipment.setLocation(EntityWithIdHelper.createEntity(Location.class, entityId));
          break;
        }
        case SOFTWARE_SUBFLOW_ID: {
          equipment.getSoftwareCollection().add(EntityWithIdHelper.createEntity(Software.class, entityId));
          break;
        }
        case ORGANIZATION_SUBFLOW_ID: {
          equipment.getOrganizationCollection().add(EntityWithIdHelper.createEntity(Organization.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          equipment.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  public List<Equipment> createDefaultList() {
    Map<String, Object> params = new HashMap<String, Object>();
    return getMainService().findByNamedQuery(Equipment.class.getName() + ".findByName", params);
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @return The list type view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") EquipmentForm form, Locale locale) {
    return doSave(form, locale);

  }

  /**
   * @param equipmentService the equipmentService to set
   */
  @Resource(name = "equipmentService")
  public void setEquipmentService(GenericService<Equipment> equipmentService) {
    super.setMainService(equipmentService);
  }

  /**
   * @param electronicDocument the electronicDocumentService to set
   */
  // @Resource(name = "electronicDocumentService")
  // public void setElectronicDocumentService(GenericService<ElectronicDocument> electronicDocument) {
  // electronicDocumentService = electronicDocument;
  // }

  /**
   * @param hazard the hazardService to set
   */
  // @Resource(name = "hazardService")
  // public void setHazardService(GenericService<Hazard> hazard) {
  // hazardService = hazard;
  // }

  /**
   * @param laboratoryService the laboratoryService to set
   */
  @Resource(name = "laboratoryService")
  public void setLaboratoryService(GenericService<Laboratory> laboratoryService) {
    this.laboratoryService = laboratoryService;
  }

  /**
   * @param location the locationService to set
   */
  @Resource(name = "locationService")
  public void setLocationService(GenericService<Location> location) {
    locationService = location;
  }

  /**
   * @param namingConventionHelper the namingConventionHelper to set
   */
  @Resource(name = "namingConventionHelper")
  public void setNamingConventionHelper(NamingConventionHelper namingConventionHelper) {
    this.namingConventionHelper = namingConventionHelper;
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
   * @param software the softwareService to set
   */
  @Resource(name = "softwareService")
  public void setSoftwareService(GenericService<Software> software) {
    softwareService = software;
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
  @Resource(name = "equipmentFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "equipmentTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
