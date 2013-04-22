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
import java.util.Collection;
import java.util.Iterator;

import javax.validation.ConstraintViolation;

/**
 * @author connollym
 *
 */
public class ValidationMessageHelper {
  
  /**
   * @param <T> The generic type of ConstraintViolation.
   * @param exception The exception containing violations to be converted to a String.
   * @return String The violations converted to String format.
   */ 
  
  public static <T> String getErrors(ValidationException exception) {
    
    StringBuilder messages = new StringBuilder();
    Collection <ConstraintViolation<T>> constraintViolations = exception.getViolations();
    Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
    if (iterator.hasNext()) {
      ConstraintViolation<T> violation = iterator.next();
      messages.append("<BR> " + violation.getMessage() + "</BR>");
    }
    return messages.toString();
  }
}
