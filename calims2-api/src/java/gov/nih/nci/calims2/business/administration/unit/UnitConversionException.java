/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.unit;

/**
 * Unit conversion exception.
 * 
 * @author viseem
 */
public class UnitConversionException extends RuntimeException {
  private static final long serialVersionUID = 4221469573347293535L;

  /**
   * Constructs a new UnitConversionException with null as its detail message.
   */
  public UnitConversionException() {
    super();
  }

  /**
   * Constructs a new UnitConversionException with the specified detail message.
   * 
   * @param message the detail message. The detail message is saved for later retrieval by the Throwable.getMessage() method.
   */
  public UnitConversionException(String message) {
    super(message);
  }

  /**
   * Constructs a new UnitConversionException with the specified detail message and cause.
   * 
   * @param message the detail message. The detail message is saved for later retrieval by the Throwable.getMessage() method.
   * @param cause the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and
   *          indicates that the cause is nonexistent or unknown.)
   */
  public UnitConversionException(String message, Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a new UnitConversionException with the specified cause and a detail message of (cause==null ? null :
   * cause.toString()) (which typically contains the class and detail message of cause).
   * 
   * @param cause the cause (which is saved for later retrieval by the Throwable.getCause() method). (A null value is permitted, and
   *          indicates that the cause is nonexistent or unknown.)
   */
  public UnitConversionException(Throwable cause) {
    super(cause);
  }

}
