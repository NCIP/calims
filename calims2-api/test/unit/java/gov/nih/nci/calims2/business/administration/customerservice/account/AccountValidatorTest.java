/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.customerservice.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public class AccountValidatorTest {
  private AccountValidator accountValidator = new AccountValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the AccountValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new AccountValidatorMockup());
    accountValidator.setValidatorFactory(mockupValidatorFactory);
    Account account = new Account();
    try {
      accountValidator.validate(account, ValidationOperation.CREATE);
       fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Account.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the AccountValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateTypeTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new AccountValidatorMockup());
  accountValidator.setValidatorFactory(mockupValidatorFactory);
  Account account = new Account();
  account.setName("DISPLAYNAME");
  try {
    accountValidator.validate(account, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator should have thrown an exception");
  }
  }
}

