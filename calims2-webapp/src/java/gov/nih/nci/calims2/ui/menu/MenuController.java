/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */

package gov.nih.nci.calims2.ui.menu;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * Controller class for the menu generation.
 * 
 * @author viseem
 * 
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

  /** Name of the menu view. */
  static final String MENU_VIEW = "menu/menu";
  
  private MessageSource messageSource;
  private PrivilegeEvaluator privilegeEvaluator;

  /**
   * Generates the menu page.
   * 
   * @param locale The locale of the user
   * 
   * @return The name of the menu view
   */
  @RequestMapping("/menu.do")
  public ModelAndView menu(Locale locale) {
    ModelAndView model = new ModelAndView();
    model.setViewName(MENU_VIEW);
    MenuBuilder builder = new MenuBuilder(locale, messageSource, privilegeEvaluator);
    model.addObject("menu", builder.getMenu());
    return model;
  }

  /**
   * @param messageSource the messageSource to set
   */
  @Resource
  public void setMessageSource(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  /**
   * @param privilegeEvaluator the privilegeEvaluator to set
   */
  @Resource
  public void setPrivilegeEvaluator(PrivilegeEvaluator privilegeEvaluator) {
    this.privilegeEvaluator = privilegeEvaluator;
  }
}
