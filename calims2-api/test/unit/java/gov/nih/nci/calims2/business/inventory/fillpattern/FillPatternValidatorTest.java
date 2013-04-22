/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.fillpattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.FillPattern;

/**
 * @author connollym
 *
 */
public class FillPatternValidatorTest {
  
  private FillPatternValidator fillPatternValidator = new FillPatternValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the FillPatternValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateFillPatternFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new FillPatternValidatorMockup());
    fillPatternValidator.setValidatorFactory(mockupValidatorFactory);
    FillPattern fillPattern = new FillPattern();
    try {
    fillPatternValidator.validate(fillPattern, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid FillPattern.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the FillPatternValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateFillPatternTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new FillPatternValidatorMockup());
  
  fillPatternValidator.setValidatorFactory(mockupValidatorFactory);
  FillPattern fillPattern = new FillPattern();
  fillPattern.setName("JOE");
  try {
        fillPatternValidator.validate(fillPattern, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}

