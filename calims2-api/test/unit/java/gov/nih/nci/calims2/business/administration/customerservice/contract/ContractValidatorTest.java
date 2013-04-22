/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.customerservice.contract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.customerservice.Contract;

/**
 * @author katariap
 * 
 */
public class ContractValidatorTest {
  private ContractValidator contractValidator = new ContractValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the ContractValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new ContractValidatorMockup());
    contractValidator.setValidatorFactory(mockupValidatorFactory);
    Contract contract = new Contract();
    try {
      contractValidator.validate(contract, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Contract.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the ContractValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateTypeTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new ContractValidatorMockup());
    contractValidator.setValidatorFactory(mockupValidatorFactory);
    Contract contract = new Contract();
    contract.setName("DISPLAYNAME");
    try {
      contractValidator.validate(contract, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
  }
}
