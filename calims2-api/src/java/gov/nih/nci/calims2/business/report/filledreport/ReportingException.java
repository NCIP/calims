/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.filledreport;


/**
 * @author connollym
 *
 */
public class ReportingException extends Exception {
  private static final long serialVersionUID = 1L;

  private static final String DEFAULT_MESSAGE = "Filled Report Service Exception";
  
  /**
   * Constructs a new ValidationException with a default detail message.
   */
  public ReportingException() {
    super(DEFAULT_MESSAGE);
  }
  
  /**
   * @param message The message to send.
   */
  public ReportingException(String message) {
    super(message);
  }

  /**
   * @param message The message.
   * @param cause The cause of the exception.
   */
  public ReportingException(String message, Throwable cause) {
    super(message, cause);
  }
  
}