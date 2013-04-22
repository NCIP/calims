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
import static org.junit.Assert.assertEquals;
import java.util.Collection;
import java.util.Collections;

import javax.validation.ConstraintViolation;
import org.junit.Test;
import gov.nih.nci.calims2.business.generic.GenericViolation;
import gov.nih.nci.calims2.domain.administration.Person;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public class ValidationExceptionTest {
  private Collection<ConstraintViolation <Person>> violations;
  private ValidationException exception;
  
  /**
   * Test the ValidationException getViolations method. 
   * In this case it should return an empty collection.
   */
  @Test
  public void testGetValidationExceptionsEmptySet() {
    violations = Collections.emptySet();
    exception = new ValidationException("Test", violations);
    assertEquals("Violations collection should be empty!", violations.size(), exception.getViolations().size());
  }
  
  /**
   * Test the ValidationException getViolations method. 
   * In this case it should return one violation.
   */
  @Test
  public void testGetValidationExceptionsNonEmptySet() {
    ConstraintViolationImpl <Person>violation = new ConstraintViolationImpl<Person>(Person.class, 
        GenericViolation.ORIGINAL_NOT_FOUND);
    exception = new <Person>ValidationException(violation);
    assertEquals("Violations collection should have one violation!", 1, exception.getViolations().size());
  }

}
