/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.namingconvention;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class NamingConventionControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    NamingConventionController controller = new NamingConventionController();
    CRUDAssert.assertControllerConstructor(controller, NamingConventionController.URL_PREFIX, "administration.namingconvention.",
        "name", NamingConvention.class, NamingConventionForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    NamingConventionController controller = new NamingConventionController();
    GenericServiceMockup<Laboratory> labService = new GenericServiceMockup<Laboratory>();
    controller.setLaboratoryService(labService);
    GenericServiceMockup<Person> personService = new GenericServiceMockup<Person>();
    controller.setPersonService(personService);
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertFindAll(labService, Laboratory.class, "name", "laboratories", result);
    CRUDAssert.assertEnumerationCollection(result, "namingConventionStatuses", NamingConventionStatus.class);
    CRUDAssert.assertEnumerationCollection(result, "namingConventionTypes", NamingConventionType.class);
    CRUDAssert.assertFindAll(personService, Person.class, "familyName", "persons", result);
  }
}
