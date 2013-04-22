/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.customerservice.accountnumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber;

/**
 * @author connollym
 *
 */
public class AccountNumberValidatorTest {
  private AccountNumberValidator accountNumberValidator = new AccountNumberValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the AccountNumberValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new AccountNumberValidatorMockup());
    accountNumberValidator.setValidatorFactory(mockupValidatorFactory);
    AccountNumber accountNumber = new AccountNumber();
    try {
      accountNumberValidator.validate(accountNumber, ValidationOperation.CREATE);
       fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid AccountNumber.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the AccountNumberValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateTypeTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new AccountNumberValidatorMockup());
  accountNumberValidator.setValidatorFactory(mockupValidatorFactory);
  AccountNumber accountNumber = new AccountNumber();
  accountNumber.setName("DISPLAYNAME");
  try {
    accountNumberValidator.validate(accountNumber, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator should have thrown an exception");
  }
  }
}

