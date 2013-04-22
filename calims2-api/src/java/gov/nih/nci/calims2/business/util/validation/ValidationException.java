/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.util.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.validation.ConstraintViolation;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public class ValidationException extends Exception {
  
/**
 * 
 */
private static final long serialVersionUID = 1L;

private static final String DEFAULT_MESSAGE = "Validation Exception";
  
 
  
  @SuppressWarnings("unchecked")
  private Collection violations;
  /**
   * Constructs a new ValidationException with a default detail message.
   */
  public ValidationException() {
    
    this(DEFAULT_MESSAGE);
  }

  /**
   * Constructs a new ValidationException with the specified detail message.
   * @param message the detail message.
   * @param <T> Type of ValidatonException
   */
  public <T>ValidationException(String message) {
    this(message, null, (Collection<ConstraintViolation <T>>) null);
  }

  /**
   * Constructs a new ValidationException with a default detail message and the given list of violations.
   * @param violations the list of violations that have been detected.
   * @param <T> Type of ValidatonException
   */
  public <T>ValidationException(Collection<ConstraintViolation <T>> violations) {
    this(DEFAULT_MESSAGE, null, violations);
  }
  
  /**
   * Constructs a new ValidationException with a default detail message and the given violation.
   * @param violation the violation that have been detected.
   * @param <T> Type of ValidatonException
   */
  public <T>ValidationException(ConstraintViolation<T> violation) {
    this(DEFAULT_MESSAGE, null, violation);
  }

  /**
   * Constructs a new ValidationException with the specified detail message and the given list of violations.
   * @param message the detail message.
   * @param violation the violation that have been detected.
   * @param <T> Type of ValidatonException
   */
  public <T>ValidationException(String message, ConstraintViolation<T> violation) {
    this(message, null, violation);
  }

  /**
   * Constructs a new ValidationException with the specified detail message, cause and
   * list of violations.
   * @param message the detail message.
   * @param cause the cause
   * @param violations the list of violations that have been detected.
   * @param <T> Type of ValidatonException
   */
  public <T>ValidationException(String message, Throwable cause, Collection<ConstraintViolation<T>> violations) {
    super(message, cause);
    this.violations = violations;
  }
  
  /**
   * Constructs a new ValidationException with the specified detail message, cause and
   * list of violations.
   * @param message the detail message.
   * @param cause the cause
   * @param violation the violation that have been detected.
   * @param <T> Type of ValidatonException
   */
  @SuppressWarnings("unchecked")
  public <T>ValidationException(String message, Throwable cause, ConstraintViolation<T> violation) {
    super(message, cause);
    violations = new ArrayList<ConstraintViolation<T>>();
    violations.add(violation);
  }

  /**
   * @param message the detail message.
   * @param constraintViolations the violations that have been detected.
   * @param <T> Type of ValidatonException
   */
  public <T>ValidationException(String message, Collection<ConstraintViolation<T>> constraintViolations) {
    this(message, null, constraintViolations);
  }

  /**
   * Gets the List of violations of this ValidationException.
   * @return the List of violations of this ValidationException.
   * @param <T> Type of ValidatonException
   */
  @SuppressWarnings("unchecked")
  public <T>Collection<ConstraintViolation<T>> getViolations() {
    if (violations == null) {
      return Collections.emptySet();
    }
    return violations;
  }
}
