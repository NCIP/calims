/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.storage;



/**
 * @author connollym
 *
 */
public class StorageServiceException extends Exception {
  
  private static final long serialVersionUID = 1L;

  private static final String DEFAULT_MESSAGE = "Storage Service Exception";
  
  /**
   * Constructs a new ValidationException with a default detail message.
   */
  public StorageServiceException() {
    super(DEFAULT_MESSAGE);
  }
  
  /**
   * @param message The message to send.
   */
  public StorageServiceException(String message) {
    super(message);
  }

}
