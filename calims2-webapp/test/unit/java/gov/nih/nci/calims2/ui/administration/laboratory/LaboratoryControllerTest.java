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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;
import java.util.Set;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.LaboratoryStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class LaboratoryControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    LaboratoryController controller = new LaboratoryController();
    CRUDAssert.assertControllerConstructor(controller, LaboratoryController.URL_PREFIX, "administration.laboratory.", "name",
        Laboratory.class, LaboratoryForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    LaboratoryController controller = new LaboratoryController();
    GenericServiceMockup<Person> personService = new GenericServiceMockup<Person>();
    GenericServiceMockup<Location> locationService = new GenericServiceMockup<Location>();
    GenericServiceMockup<Role> roleService = new GenericServiceMockup<Role>();
    controller.setRoleService(roleService);
    controller.setPersonService(personService);
    controller.setLocationService(locationService);
    GenericServiceMockup<Organization> organizationService = new GenericServiceMockup<Organization>();
    controller.setOrganizationService(organizationService);
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertFindAll(personService, Person.class, "familyName", "persons", result);
    CRUDAssert.assertFindAll(locationService, Location.class, "name", "locations", result);
    CRUDAssert.assertFindAll(organizationService, Organization.class, "name", "organizations", result);
    assertEquals("Wrong query Name for Roles", Role.class.getName() + ".findByRoleType",
        roleService.getFindByQueryName());
    assertNotNull("No paramters passed to query.", roleService.getFindByQueryNameParameterValues());
    assertEquals("Wrong paramter passed to query.", RoleType.LABORATORY, 
        roleService.getFindByQueryNameParameterValues().get("roleType"));
    assertEquals("Wrong result returned from role query.", roleService.getFindByQueryNameResult(), result.getModel().get("roles"));
    CRUDAssert.assertEnumerationCollection(result, "laboratoryStatuses", LaboratoryStatus.class);
  }

  /**
   * Test the controller doReturnFromFlow method.
   */
  @Test
  public void testDoReturnFromFlow() {
    LaboratoryController controller = new LaboratoryController();
    ModelAndView model = new ModelAndView();
    LaboratoryForm form = new LaboratoryForm();
    form.setEntity(new Laboratory());
    model.addObject("form", form);
    controller.doReturnFromFlow(model, 0, 1L);
    Set<Person> persons = form.getEntity().getPersonCollection();
    assertNotNull("No person collection in the laboratory");
    assertEquals("Wrong size of the person collection", 1, persons.size());
    assertEquals("Wrong person Id", new Long(1), persons.iterator().next().getId());
  }

}
