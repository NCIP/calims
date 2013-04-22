/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.telephonenumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.TelephoneNumber;

/**
 * @author katariap
 * 
 */
public class TelephoneNumberValidatorTest {
  private TelephoneNumberValidator telephoneNumberValidator = new TelephoneNumberValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the TelephoneNumberValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new TelephoneNumberValidatorMockup());
    telephoneNumberValidator.setValidatorFactory(mockupValidatorFactory);
    TelephoneNumber telephoneNumber = new TelephoneNumber();
    try {
      telephoneNumberValidator.validate(telephoneNumber, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid TelephoneNumber.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the TelephoneNumberValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateTypeTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new TelephoneNumberValidatorMockup());
    telephoneNumberValidator.setValidatorFactory(mockupValidatorFactory);
    TelephoneNumber telephoneNumber = new TelephoneNumber();
    telephoneNumber.setName("DISPLAYNAME");
    try {
      telephoneNumberValidator.validate(telephoneNumber, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
  }
}
