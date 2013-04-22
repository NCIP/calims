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
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Person;


/**
 * @author connollym
 *
 */
public class DefaultValidatorTest {
  
    private DefaultValidator<Person> defaultValidator = new DefaultValidator<Person>();
    private ValidatorFactoryMockup mockupValidatorFactory;
    
    
    /**
     * Tests the DefaultValidator. The validator should throw an exception.
     */
    @Test
    public void testValidatePersonFalse() {
      mockupValidatorFactory = new ValidatorFactoryMockup();
      mockupValidatorFactory.setValidator(new ValidatorMockup());
      defaultValidator.setValidatorFactory(mockupValidatorFactory);
      Person person = new Person();
      try {
      defaultValidator.validate(person, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
      } catch (ValidationException ex) {
        ConstraintViolation<?> violation = ex.getViolations().iterator().next();
        assertEquals("Not a valid Person.", violation.getMessage(), "Family name required");
      }
    }
    
   /**
    *  Tests the DefaultValidator. The validator should not throw an exception.
    */
    @Test
  public void testValidatePersonTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new ValidatorMockup());
    
    defaultValidator.setValidatorFactory(mockupValidatorFactory);
    Person person = new Person();
    person.setFamilyName("JOE");
    try {
          defaultValidator.validate(person, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
    }
}
