/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.home;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author viseem
 *
 */
public class HomeControllerTest {

  private HomeController homeController = new HomeController();
  private PrivilegeEvaluatorMockup mockup = new PrivilegeEvaluatorMockup();
 
  
  /**
   * Test the home page controller.
   */
  @Test
  public void testHome() {
    GenericServiceMockup<Person> personService = new GenericServiceMockup<Person>();
    homeController.setPrivilegeEvaluator(mockup);
    homeController.setPersonBean(personService);
    ModelAndView result = homeController.home();
    assertEquals("Wrong view name for exception page", HomeController.HOME_VIEW, result.getViewName());
  }
}
