/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.customerservice.billinginformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation;

/**
 * @author katariap
 * 
 */
public class BillingInformationValidatorTest {
  private BillingInformationValidator billingInformationValidator = new BillingInformationValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the BillingInformationValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new BillingInformationValidatorMockup());
    billingInformationValidator.setValidatorFactory(mockupValidatorFactory);
    BillingInformation billingInformation = new BillingInformation();
    try {
      billingInformationValidator.validate(billingInformation, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid BillingInformation.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the BillingInformationValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateTypeTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new BillingInformationValidatorMockup());
    billingInformationValidator.setValidatorFactory(mockupValidatorFactory);
    BillingInformation billingInformation = new BillingInformation();
    billingInformation.setName("DISPLAYNAME");
    try {
      billingInformationValidator.validate(billingInformation, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
  }
}
