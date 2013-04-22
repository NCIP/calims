/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.antigen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.Antigen;

/**
 * @author connollym
 *
 */
public class AntigenValidatorTest {
  
  private AntigenValidator antigenValidator = new AntigenValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the AntigenValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateAntigenFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new AntigenValidatorMockup());
    antigenValidator.setValidatorFactory(mockupValidatorFactory);
    Antigen antigen = new Antigen();
    try {
    antigenValidator.validate(antigen, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Antigen.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the AntigenValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateAntigenTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new AntigenValidatorMockup());
  
  antigenValidator.setValidatorFactory(mockupValidatorFactory);
  Antigen antigen = new Antigen();
  antigen.setName("JOE");
  try {
        antigenValidator.validate(antigen, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}
