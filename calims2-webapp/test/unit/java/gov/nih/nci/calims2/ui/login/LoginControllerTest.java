/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.login;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author viseem
 * 
 */
public class LoginControllerTest {

  private LoginController loginController = new LoginController();

  /**
   * Test the login page controller.
   */
  @Test
  public void testLogin() {
    String result = loginController.login();
    assertEquals("Wrong view name for login page", LoginController.LOGIN_VIEW, result);
  }
  
  /**
   * Test the logout page controller.
   */
  @Test
  public void testLogout() {
    String result = loginController.logout();
    assertEquals("Wrong view name for logout page", LoginController.LOGOUT_VIEW, result);
  }

  /**
   * Test the login page controller.
   */
  @Test
  public void testLoginError() {
    ModelAndView model = loginController.loginError();
    assertNotNull("Model object is null", model);
    assertEquals("Wrong view name for login error page", LoginController.LOGIN_VIEW, model.getViewName());
    Object loginError = model.getModel().get("loginError");
    assertNotNull("login error flag is missing", model);
    assertTrue("login error flag is not boolean", loginError instanceof Boolean);
    assertTrue("login error flag is false", ((Boolean) loginError));
  }
  
  /**
   * Test the session timeout page controller.
   */
  @Test
  public void testSessionTimeout() {
    String result = loginController.sessionTimeout();
    assertEquals("Wrong view name for session timeout page", LoginController.TIMEOUT_VIEW, result);
  }
}
