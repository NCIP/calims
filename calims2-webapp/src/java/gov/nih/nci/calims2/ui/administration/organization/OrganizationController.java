/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.organization;

import java.util.ArrayList;
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
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.OrganizationStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
import gov.nih.nci.calims2.domain.common.Type;
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
@RequestMapping(OrganizationController.URL_PREFIX)
public class OrganizationController extends CRUDController<Organization> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/organization";

  /** Create location sub flow. */
  static final int LOCATION_SUBFLOW_ID = 0;
  
  /** Create role sub flow. */
  static final int ROLE_SUBFLOW_ID = 1;
  
  /** Create organization sub flow. */
  static final int ORGANIZATION_SUBFLOW_ID = 2;
  
  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 3;
  
  private GenericService<Location> locationService;
  private GenericService<Role> roleService;
  private GenericService<Type> typeService;

  /**
   * Default constructor.
   */

  public OrganizationController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/location/create.do",
                                        "/administration/role/create.do?roleType=" + RoleType.ORGANIZATION,
                                        "/administration/organization/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.ORGANIZATION,
                                        "/administration/contactinformation/enterList.do",
                                        "/common/document/enterList.do"});
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
  public ModelAndView call(@ModelAttribute("form") OrganizationForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    Map<String, Object> params1 = new HashMap<String, Object>();
    params1.put("dataElementCollection", TypeEnumeration.ORGANIZATION.name());
    List<Type> types = typeService.findByNamedQuery("gov.nih.nci.calims2.domain.common.Type.findByDataElementCollection", params1);
    model.addObject("types", types);
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("roleType", RoleType.ORGANIZATION);
    List<Role> roles = roleService.findByNamedQuery(Role.class.getName() + ".findByRoleType", params);
    model.addObject("roles", roles);
    List<Location> locations = locationService.findAll(Location.class, "name");
    model.addObject("locations", locations);
    List<Organization> parentOrganizations = getMainService().findAll(Organization.class, "name");
    Organization organization = ((OrganizationForm) model.getModel().get("form")).getEntity();
    model.addObject("parentOrganizations", filterDescendents(parentOrganizations, organization));
    model.addObject("organizationStatuses", I18nEnumerationHelper.getLocalizedValues(OrganizationStatus.class, locale));
    return model;
  }
  
  /**
   * filters the descendants of the given organization from the list of organizations.
   * 
   * @param organizations The list of organizations to filter
   * @param organization The organization to filter from the list (with all its descendants)
   * @return The filtered list.
   */
  List<Organization> filterDescendents(List<Organization> organizations, Organization organization) {
    if (organization.getId() == null) {
      return organizations;
    }
    List<Organization> result = new ArrayList<Organization>();
    for (Organization candidate : organizations) {
      Organization currentOrganization = candidate;
      while (currentOrganization != null && !currentOrganization.getId().equals(organization.getId())) {
        currentOrganization = currentOrganization.getParentOrganization();
      }
      if (currentOrganization == null) {
        result.add(candidate);
      }
    }
    return result;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Organization organization = ((OrganizationForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case LOCATION_SUBFLOW_ID: {
          organization.setLocation(EntityWithIdHelper.createEntity(Location.class, entityId));
          break;
        }
        case ROLE_SUBFLOW_ID: {
          organization.getRoleCollection().add(EntityWithIdHelper.createEntity(Role.class, entityId));
          break;
        }
        case ORGANIZATION_SUBFLOW_ID: {
          organization.setParentOrganization(EntityWithIdHelper.createEntity(Organization.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          organization.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
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
   * @return The list type view.
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") OrganizationForm form, Locale locale) {
    return doSave(form, locale);

  }

  /**
   * @param organizationService the organizationService to set
   */
  @Resource(name = "organizationService")
  public void setOrganizationService(GenericService<Organization> organizationService) {
    super.setMainService(organizationService);
  }

  /**
   * @param locationService the locationService to set
   */
  @Resource(name = "locationService")
  public void setLocationService(GenericService<Location> locationService) {
    this.locationService = locationService;
  }

  /**
   * @param roleService the roleService to set
   */
  @Resource(name = "roleService")
  public void setRoleService(GenericService<Role> roleService) {
    this.roleService = roleService;
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
  @Resource(name = "organizationFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "organizationTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
