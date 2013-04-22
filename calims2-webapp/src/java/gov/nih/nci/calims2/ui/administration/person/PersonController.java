/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.person;

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
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.PersonStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxienformatics.com
 * 
 */
@Controller
@RequestMapping(PersonController.URL_PREFIX)
public class PersonController extends CRUDController<Person> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/person";
  /** Create organization sub flow. */
  static final int ORGANIZATION_SUBFLOW_ID = 0;
  
  /** Create role sub flow. */
  static final int ROLE_SUBFLOW_ID = 1;

  private GenericService<Organization> organizationService;
  private GenericService<Role> roleService;
  
  /**
   * Default constructor.
   */
  public PersonController() {
    super(URL_PREFIX, "familyName");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/organization/create.do",
                                        "/administration/role/create.do?roleType=" + RoleType.PERSON,
                                        "/common/document/enterList.do", 
                                        "/administration/contactinformation/enterList.do",
                                        "/common/externalidentifier/enterList.do"});
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
  public ModelAndView call(@ModelAttribute("form") PersonForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<Organization> organizations = organizationService.findAll(Organization.class, "name");
    model.addObject("organizations", organizations);
   
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("roleType", RoleType.PERSON);
    List<Role> roles = roleService.findByNamedQuery(Role.class.getName() + ".findByRoleType", params);
    model.addObject("roles", roles);
    model.addObject("personStatuses", I18nEnumerationHelper.getLocalizedValues(PersonStatus.class, locale));
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Person person = ((PersonForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case ORGANIZATION_SUBFLOW_ID: {
          person.getOrganizationCollection().add(EntityWithIdHelper.createEntity(Organization.class, entityId));
          break;
        }
        case ROLE_SUBFLOW_ID: {
          person.getRoleCollection().add(EntityWithIdHelper.createEntity(Role.class, entityId));
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
  public ModelAndView save(@ModelAttribute("form") PersonForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param personService the personService to set
   */
  @Resource(name = "personService")
  public void setMainService(GenericService<Person> personService) {
    super.setMainService(personService);
  }

  /**
   * @param organizationService the organiizationService to set
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
  @Resource(name = "personFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "personTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
