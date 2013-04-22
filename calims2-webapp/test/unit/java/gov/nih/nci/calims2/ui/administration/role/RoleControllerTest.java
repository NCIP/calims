/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.role;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class RoleControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    RoleController controller = new RoleController();
    CRUDAssert.assertControllerConstructor(controller, RoleController.URL_PREFIX, "administration.role.",
        "name", Role.class, RoleForm.class, CRUDTableDecorator.class);
  }
  
  /**
   * Test the controller completeDetailsModel method.
   */
  @Test
  public void testCompleteDetailsModel() {
    RoleController controller = new RoleController();
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeDetailsModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
  }
  
  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    RoleController controller = new RoleController();
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertEnumerationCollection(result, "roleStatuses", RoleStatus.class);
    CRUDAssert.assertEnumerationCollection(result, "roleTypes", RoleType.class);
  }
}
