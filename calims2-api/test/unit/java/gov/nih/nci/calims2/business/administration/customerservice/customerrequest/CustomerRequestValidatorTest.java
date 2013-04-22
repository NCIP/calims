/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.customerservice.customerrequest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;

/**
 * @author katariap
 * 
 */
public class CustomerRequestValidatorTest {
  private CustomerRequestValidator customerRequestValidator = new CustomerRequestValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the CustomerRequestValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new CustomerRequestValidatorMockup());
    customerRequestValidator.setValidatorFactory(mockupValidatorFactory);
    CustomerRequest customerRequest = new CustomerRequest();
    try {
      customerRequestValidator.validate(customerRequest, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid CustomerRequest.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the CustomerRequestValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateTypeTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new CustomerRequestValidatorMockup());
    customerRequestValidator.setValidatorFactory(mockupValidatorFactory);
    CustomerRequest customerRequest = new CustomerRequest();
    customerRequest.setName("DISPLAYNAME");
    try {
      customerRequestValidator.validate(customerRequest, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
  }
}
