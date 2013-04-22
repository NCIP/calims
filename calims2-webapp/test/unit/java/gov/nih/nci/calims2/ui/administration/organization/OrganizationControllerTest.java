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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.OrganizationStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class OrganizationControllerTest {

  private static final Long[] ORG_IDS = new Long[] {1L, 5L, 6L };

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    OrganizationController controller = new OrganizationController();
    CRUDAssert.assertControllerConstructor(controller, OrganizationController.URL_PREFIX, "administration.organization.", "name",
        Organization.class, OrganizationForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    OrganizationController controller = new OrganizationController();
    GenericServiceMockup<Location> locationService = new GenericServiceMockup<Location>();
    controller.setLocationService(locationService);
    GenericServiceMockup<Organization> organizationService = new GenericServiceMockup<Organization>();
    controller.setMainService(organizationService);
    GenericServiceMockup<Role> roleService = new GenericServiceMockup<Role>();
    controller.setRoleService(roleService);
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);

    ModelAndView model = new ModelAndView();
    OrganizationForm form = new OrganizationForm();
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);

    CRUDAssert.assertFindAll(locationService, Location.class, "name", "locations", result);
    CRUDAssert.assertFindAll(organizationService, Organization.class, "name", "parentOrganizations", result);
    assertEquals("Wrong query Name for Roles", Role.class.getName() + ".findByRoleType", roleService.getFindByQueryName());
    assertNotNull("No paramters passed to query.", roleService.getFindByQueryNameParameterValues());
    assertEquals("Wrong paramter passed to query.", RoleType.ORGANIZATION, roleService.getFindByQueryNameParameterValues().get(
        "roleType"));
    assertEquals("Wrong result returned from role query.", roleService.getFindByQueryNameResult(), result.getModel().get("roles"));
    CRUDAssert.assertTypes(typeService, TypeEnumeration.ORGANIZATION, "types", result);
    CRUDAssert.assertEnumerationCollection(result, "organizationStatuses", OrganizationStatus.class);
  }

  /**
   * Test the controller filterDescendants method.
   */
  @Test
  public void tesFilterDescendants() {
    int[] parent = new int[] {-1, 0, 1, 1, 0, -1 };
    List<Organization> organizations = new ArrayList<Organization>();
    for (int i = 1; i <= parent.length; i++) {
      Organization organization = new Organization();
      organization.setId(new Long(i));
      organizations.add(organization);
    }
    for (int i = 0; i < organizations.size(); i++) {
      if (parent[i] >= 0) {
        organizations.get(i).setParentOrganization(organizations.get(parent[i]));
      }
    }
    OrganizationController controller = new OrganizationController();
    List<Organization> result = controller.filterDescendents(organizations, organizations.get(1));
    assertNotNull("No result returned", result);
    assertEquals("Result has the wrong size", ORG_IDS.length, result.size());
    for (int i = 0; i < result.size(); i++) {
      assertEquals("Wrong organization returned", ORG_IDS[i], result.get(i).getId());
    }
  }

}
