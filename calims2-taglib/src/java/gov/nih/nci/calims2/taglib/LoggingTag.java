/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.taglib;

import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author viseem
 * 
 */
public class LoggingTag extends TagSupport {

  private static final long serialVersionUID = 9223066785091490078L;

  private static Logger log = LoggerFactory.getLogger(LoggingTag.class);

  private String message;

  /**
   * {@inheritDoc}
   */
  public int doEndTag() {
    log.debug(message);
    return EVAL_PAGE;
  }

  /**
   * @param message the message to set
   */
  public void setMessage(String message) {
    this.message = message;
  }

}
