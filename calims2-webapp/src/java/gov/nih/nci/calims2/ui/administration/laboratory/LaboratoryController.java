/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.laboratory;

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

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.LaboratoryStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
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
@RequestMapping(LaboratoryController.URL_PREFIX)
public class LaboratoryController extends CRUDController<Laboratory> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/laboratory";

  /** Create person subflow id.*/ 
  static final int PERSON_SUBFLOW_ID = 0;
  /** Create location subflow id.*/
  static final int LOCATION_SUBFLOW_ID = 1;
  /** Create organization subflow id.*/
  static final int ORGANIZATION_SUBFLOW_ID = 2;
  /** Create role subflow id.*/
  static final int ROLE_SUBFLOW_ID = 3;

  private GenericService<Location> locationService;
  private GenericService<Organization> organizationService;
  private GenericService<Person> personService;
  private GenericService<Role> roleService;

  /**
   * Default constructor.
   */
  public LaboratoryController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/person/create.do",
                                        "/administration/location/create.do",
                                        "/administration/organization/create.do",
                                        "/administration/role/create.do?roleType=" + RoleType.LABORATORY,
                                        "/administration/contactinformation/enterList.do"});
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
  public ModelAndView call(@ModelAttribute("form") LaboratoryForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    
    model.addObject("laboratoryStatuses", I18nEnumerationHelper.getLocalizedValues(LaboratoryStatus.class, locale));
    List<Location> locations = locationService.findAll(Location.class, "name");
    model.addObject("locations", locations);
    List<Organization> organizations = organizationService.findAll(Organization.class, "name");
    model.addObject("organizations", organizations);
    List<Person> persons = personService.findAll(Person.class, "familyName");
    model.addObject("persons", persons);
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("roleType", RoleType.LABORATORY);
    List<Role> roles = roleService.findByNamedQuery(Role.class.getName() + ".findByRoleType", params);
    model.addObject("roles", roles);
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Laboratory laboratory = ((LaboratoryForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case PERSON_SUBFLOW_ID: {
          laboratory.getPersonCollection().add(EntityWithIdHelper.createEntity(Person.class, entityId));
          break;
        }
        case LOCATION_SUBFLOW_ID: {
          laboratory.setLocation(EntityWithIdHelper.createEntity(Location.class, entityId));
          break;
        }
        case ORGANIZATION_SUBFLOW_ID: {
          laboratory.getOrganizationCollection().add(EntityWithIdHelper.createEntity(Organization.class, entityId));
          break;
        }
        case ROLE_SUBFLOW_ID: {
          laboratory.getRoleCollection().add(EntityWithIdHelper.createEntity(Role.class, entityId));
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
  public ModelAndView save(@ModelAttribute("form") LaboratoryForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param laboratoryService the laboratoryService to set
   */

  @Resource(name = "laboratoryService")
  public void setLaboratoryService(GenericService<Laboratory> laboratoryService) {
    super.setMainService(laboratoryService);
  }

  /**
   * @param location the locationService to set
   */
  @Resource(name = "locationService")
  public void setLocationService(GenericService<Location> location) {
    locationService = location;
  }

  /**
   * @param person the personService to set
   */
  @Resource(name = "personService")
  public void setPersonService(GenericService<Person> person) {
    personService = person;
  }

  /**
   * @param organizationService the organizationService to set
   */
  @Resource(name = "organizationService")
  public void setOrganizationService(GenericService<Organization> organizationService) {
    this.organizationService = organizationService;
  }

  /**
   * @param roleService the roleService to set
   */
  @Resource(name = "roleService")
  public void setRoleService(GenericService<Role> roleService) {
    this.roleService = roleService;
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "laboratoryFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "laboratoryTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
