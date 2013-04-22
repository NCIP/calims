/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author viseem
 * 
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

  private static Logger log = LoggerFactory.getLogger(ExceptionController.class);
  
  /** Name of the exception view. */
  static final String EXCEPTION_VIEW = "exception.exception";

  /** Name of the access denied view. */
  static final String ACCESS_DENIED_VIEW = "exception.accessDenied";

  /** Name of the access denied view. */
  static final String NOT_FOUND_VIEW = "exception.notFound";

  /**
   * Go to the generic exception page.
   * 
   * @return The name of the generic exception view
   */
  @RequestMapping("/exception.do")
  public String exception() {
    log.debug("Entering ExceptionController.exception");
    return EXCEPTION_VIEW;
  }

  /**
   * Go to the accessDenied page.
   * 
   * @return The name of the access denied view
   */
  @RequestMapping("/accessDenied.do")
  public String accessDenied() {
    log.debug("Entering ExceptionController.accessDenied");
    return ACCESS_DENIED_VIEW;
  }

  /**
   * Go to the notFound page.
   * 
   * @return The name of the notFound view
   */
  @RequestMapping("/notFound.do")
  public String notFound() {
    log.debug("Entering ExceptionController.notFound");
    return NOT_FOUND_VIEW;
  }

}
