/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.customerservice.rate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public class RateValidatorTest {
  private RateValidator rateValidator = new RateValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the RateValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new RateValidatorMockup());
    rateValidator.setValidatorFactory(mockupValidatorFactory);
    Rate rate = new Rate();
    try {
      rateValidator.validate(rate, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Rate.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the RateValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateTypeTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new RateValidatorMockup());
    rateValidator.setValidatorFactory(mockupValidatorFactory);
    Rate rate = new Rate();
    rate.setName("DISPLAYNAME");
    try {
      rateValidator.validate(rate, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
  }
}
