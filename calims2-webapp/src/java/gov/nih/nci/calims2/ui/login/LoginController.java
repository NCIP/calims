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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author viseem
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
  
  /** Name of the login view. */
  static final String LOGIN_VIEW = "login.login";
  /** Name of the logout view. */
  static final String LOGOUT_VIEW = "login.logout";
  /** Name of the timeout view. */
  static final String TIMEOUT_VIEW = "login/sessionTimeout";
  
  /**
   * Generates the login page.
   * @return The name of the login view
   */
  @RequestMapping("/login.do")
  public String login() {
    return LOGIN_VIEW;
  }
  
  /**
   * Generates the logout page.
   * @return The name of the logout view
   */
  @RequestMapping("/logout.do")
  public String logout() {
    return LOGOUT_VIEW;
  }
  
  /**
   * Generates the login page with an error message.
   * @return The model with the loginError flag
   */
  @RequestMapping("/loginError.do")
  public ModelAndView loginError() {
    ModelAndView model = new ModelAndView();
    model.addObject("loginError", true);
    model.setViewName(LOGIN_VIEW);
    return model;
  }
  
  /**
   * Generates the session timeout page.
   * @return The name of the session timeout view
   */
  @RequestMapping("/sessionTimeout.do")
  public String sessionTimeout() {
    return TIMEOUT_VIEW;
  }
}
