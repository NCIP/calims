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

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * @author viseem
 * 
 */
@Controller
@RequestMapping("/home")
public class HomeController {

  private static final String ACCESSIBILITY_CLASS = "dijit_a11y";

  /** Name of the Home view. */
  static final String HOME_VIEW = "home.home";
  /** Name of the under construction view. */
  static final String UNDER_CONSTRUCTION_VIEW = "home.underConstruction";

  private PrivilegeEvaluator privilegeEvaluator;
  private GenericService<Person> personService;

  /**
   * Go to the user home page.
   * 
   * @return The model for the user home page
   */
  @RequestMapping("/home.do")
  public ModelAndView home() {
    ModelAndView model = new ModelAndView();
    model.setViewName(HOME_VIEW);
    String userName = privilegeEvaluator.getCurrentUsername();
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("userName", userName);
    Person person = personService.findEntityByNamedQuery(Person.class.getName() + ".findByUserName", params);
    model.addObject("person", person);
    return model;
  }

  /**
   * Changes the accessibility setting.
   * 
   * @param request The current web request
   * @return The model for the user home page
   */
  @RequestMapping("/changeAccess.do")
  public ModelAndView changeAccess(WebRequest request) {
    String dojoAccess = (String) request.getAttribute("dojoAccess", RequestAttributes.SCOPE_SESSION);
    dojoAccess = (ACCESSIBILITY_CLASS.equals(dojoAccess)) ? "" : ACCESSIBILITY_CLASS;
    request.setAttribute("dojoAccess", dojoAccess, RequestAttributes.SCOPE_SESSION);
    return home();
  }

  /**
   * Changes the current user dojo theme.
   * 
   * @param theme The name of the new theme
   * @param request The current web request
   * @return The model for the user home page
   */
  @RequestMapping("/changeTheme.do")
  public ModelAndView changeTheme(@RequestParam("theme") String theme, WebRequest request) {
    request.setAttribute("dojoTheme", theme, RequestAttributes.SCOPE_SESSION);
    return home();
  }
  
  /**
   * Go to the under construction page.
   * @return The under construction view
   */
  @RequestMapping("/underConstruction.do")
  public String underConstruction() {
    return UNDER_CONSTRUCTION_VIEW;
  }

  /**
   * @param privilegeEvaluator the privilegeEvaluator to set
   */
  @Resource
  public void setPrivilegeEvaluator(PrivilegeEvaluator privilegeEvaluator) {
    this.privilegeEvaluator = privilegeEvaluator;
  }

  /**
   * @param service the service to set
   */
  @Resource(name = "personService")
  public void setPersonBean(GenericService<Person> service) {
    this.personService = service;
  }
}
