/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.storagespace;

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
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.StorageSpace;
import gov.nih.nci.calims2.domain.administration.enumeration.EquipmentStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap@moxieinformatics.com
 * 
 */
@Controller
@RequestMapping(StorageSpaceController.URL_PREFIX)
public class StorageSpaceController extends CRUDController<StorageSpace> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/storagespace";

  /** Create organization sub flow. */
  static final int ORGANIZATION_SUBFLOW_ID = 0;
  
  /** Create location sub flow. */
  static final int LOCATION_SUBFLOW_ID = 1;
  
  /** Create person sub flow. */
  static final int PERSON_SUBFLOW_ID = 2;
  
  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 3;
  
  /** Create type sub flow. */
  static final int LAYOUT_SUBFLOW_ID = 4;
  
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";
  
  // private GenericService<ElectronicDocument> electronicDocumentService;
  private GenericService<Layout> layoutService;
  private GenericService<Location> locationService;
  private GenericService<Organization> organizationService;
  private GenericService<Person> personService;
  private GenericService<Type> typeService;

  /**
   * Default constructor.
   */
  public StorageSpaceController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/organization/create.do",
                                        "/administration/location/create.do",
                                        "/administration/person/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.STORAGESPACE,
                                        "/inventory/layout/create.do"});
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
  public ModelAndView call(@ModelAttribute("form") StorageSpaceForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<Layout> layouts = layoutService.findAll(Layout.class, "name");
    model.addObject("layouts", layouts);
    
    List<Location> locations = locationService.findAll(Location.class, "name");
    model.addObject("locations", locations);
    
    List<Organization> organizations = organizationService.findAll(Organization.class, "name");
    model.addObject("organizations", organizations);
    // List<ElectronicDocument> electronicDocuments = electronicDocumentService.findAll(ElectronicDocument.class, "name");
    // model.addObject("electronicDocuments", electronicDocuments);
    
    List<Person> persons = personService.findAll(Person.class, "familyName");
    model.addObject("persons", persons);
    
    model.addObject("storageSpaceStatuses", I18nEnumerationHelper.getLocalizedValues(EquipmentStatus.class, locale));
    
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.STORAGESPACE.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      StorageSpace storageSpace = ((StorageSpaceForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case PERSON_SUBFLOW_ID: {
          storageSpace.setContactPerson(EntityWithIdHelper.createEntity(Person.class, entityId));
          break;
        }
        case LOCATION_SUBFLOW_ID: {
          storageSpace.setInternalLocation(EntityWithIdHelper.createEntity(Location.class, entityId));
          break;
        }
        case ORGANIZATION_SUBFLOW_ID: {
          storageSpace.getOrganizationCollection().add(EntityWithIdHelper.createEntity(Organization.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          storageSpace.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
          break;
        }
        case LAYOUT_SUBFLOW_ID: {
          storageSpace.setLayout(EntityWithIdHelper.createEntity(Layout.class, entityId));
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
  public ModelAndView save(@ModelAttribute("form") StorageSpaceForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param storageSpaceService the storageSpaceService to set
   */
  @Resource(name = "storageSpaceService")
  public void setStorageSpaceService(GenericService<StorageSpace> storageSpaceService) {
    super.setMainService(storageSpaceService);
  }

  /**
   * @param organization the organizationService to set
   */
  @Resource(name = "organizationService")
  public void setOrganizationService(GenericService<Organization> organization) {
    organizationService = organization;
  }

  /**
   * @param personService the personService to set
   */
  @Resource(name = "personService")
  public void setPersonService(GenericService<Person> personService) {
    this.personService = personService;
  }

  /**
   * @param locationService the locationService to set
   */
  @Resource(name = "locationService")
  public void setLocationService(GenericService<Location> locationService) {
    this.locationService = locationService;
  }

  /**
   * @param electronicDocumentService the electronicDocumentService to set
   */
  // @Resource(name = "electronicDocumentService")
  // public void setElectronicDocumentService(GenericService<ElectronicDocument> electronicDocumentService) {
  // this.electronicDocumentService = electronicDocumentService;
  // }
  
  /**
   * @param layoutService the layoutService to set
   */
   @Resource(name = "layoutService")
   public void setLayoutService(GenericService<Layout> layoutService) {
   this.layoutService = layoutService;
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
  @Resource(name = "storageSpaceFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "storageSpaceTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
