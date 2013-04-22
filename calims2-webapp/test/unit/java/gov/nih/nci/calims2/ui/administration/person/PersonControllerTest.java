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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.PersonStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class PersonControllerTest {
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    PersonController controller = new PersonController();
    CRUDAssert.assertControllerConstructor(controller, PersonController.URL_PREFIX, "administration.person.", "familyName",
        Person.class, PersonForm.class, CRUDTableDecorator.class);
  }
  
  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    PersonController controller = new PersonController();
    GenericServiceMockup<Role> roleService = new GenericServiceMockup<Role>();
    controller.setRoleService(roleService);
    GenericServiceMockup<Organization> organizationService = new GenericServiceMockup<Organization>();
    controller.setOrganizationService(organizationService);
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertFindAll(organizationService, Organization.class, "name", "organizations", result);
    assertEquals("Wrong query Name for Roles", Role.class.getName() + ".findByRoleType",
        roleService.getFindByQueryName());
    assertNotNull("No paramters passed to query.", roleService.getFindByQueryNameParameterValues());
    assertEquals("Wrong paramter passed to query.", RoleType.PERSON, 
        roleService.getFindByQueryNameParameterValues().get("roleType"));
    assertEquals("Wrong result returned from role query.", roleService.getFindByQueryNameResult(), result.getModel().get("roles"));
    CRUDAssert.assertEnumerationCollection(result, "personStatuses", PersonStatus.class);
  }
  
}
