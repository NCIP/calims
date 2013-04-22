/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.collaboration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Collaboration;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.CollaborationStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class CollaborationControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    CollaborationController controller = new CollaborationController();
    CRUDAssert.assertControllerConstructor(controller, CollaborationController.URL_PREFIX, "administration.collaboration.", "name",
        Collaboration.class, CollaborationForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    CollaborationController controller = new CollaborationController();
    GenericServiceMockup<Laboratory> labService = new GenericServiceMockup<Laboratory>();
    controller.setLaboratoryService(labService);

    GenericServiceMockup<Role> roleService = new GenericServiceMockup<Role>();
    controller.setRoleService(roleService);
    GenericServiceMockup<Organization> organizationService = new GenericServiceMockup<Organization>();
    controller.setOrganizationService(organizationService);
    GenericServiceMockup<Person> personService = new GenericServiceMockup<Person>();
    controller.setPersonService(personService);
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertFindAll(labService, Laboratory.class, "name", "laboratories", result);
    CRUDAssert.assertEnumerationCollection(result, "collaborationStatuses", CollaborationStatus.class);
    CRUDAssert.assertFindAll(personService, Person.class, "familyName", "persons", result);

    CRUDAssert.assertFindAll(organizationService, Organization.class, "name", "organizations", result);
    assertEquals("Wrong query Name for Roles", Role.class.getName() + ".findByRoleType", roleService.getFindByQueryName());
    assertNotNull("No paramters passed to query.", roleService.getFindByQueryNameParameterValues());
    assertEquals("Wrong paramter passed to query.", RoleType.COLLABORATION, roleService.getFindByQueryNameParameterValues().get(
        "roleType"));
    assertEquals("Wrong result returned from role query.", roleService.getFindByQueryNameResult(), result.getModel().get("roles"));
    CRUDAssert.assertTypes(typeService, TypeEnumeration.COLLABORATION, "types", result);
  }

}
