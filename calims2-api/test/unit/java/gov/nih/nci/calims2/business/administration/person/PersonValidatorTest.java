/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.Person;

/**
 * @author connollym@moxieinformatics.com
 *
 */

public class PersonValidatorTest {
  
    private PersonValidator personValidator = new PersonValidator();
    private ValidatorFactoryMockup mockupValidatorFactory;
    
    
    /**
     * Tests the PersonValidator. The validator should throw an exception.
     */
    @Test
    public void testValidatePersonFalse() {
      mockupValidatorFactory = new ValidatorFactoryMockup();
      mockupValidatorFactory.setValidator(new PersonValidatorMockup());
      personValidator.setValidatorFactory(mockupValidatorFactory);
      Person person = new Person();
      try {
      personValidator.validate(person, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
      } catch (ValidationException ex) {
        ConstraintViolation<?> violation = ex.getViolations().iterator().next();
        assertEquals("Not a valid Person.", violation.getMessage(), "Family name required");
      }
    }
    
   /**
    *  Tests the PersonValidator. The validator should not throw an exception.
    */
    @Test
  public void testValidatePersonTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new PersonValidatorMockup());
    
    personValidator.setValidatorFactory(mockupValidatorFactory);
    Person person = new Person();
    person.setFamilyName("JOE");
    try {
          personValidator.validate(person, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator no have thrown an exception");
    }
    }
}
