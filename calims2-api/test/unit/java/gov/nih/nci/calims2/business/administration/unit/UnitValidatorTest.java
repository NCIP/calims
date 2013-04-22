/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.Unit;

/**
 * @author katariap
 * 
 */
public class UnitValidatorTest {

  private UnitValidator unitValidator = new UnitValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the UnitValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new UnitValidatorMockup());
    unitValidator.setValidatorFactory(mockupValidatorFactory);
    Unit unit = new Unit();
    try {
      unitValidator.validate(unit, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Unit.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the UnitValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateTypeTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new UnitValidatorMockup());

    unitValidator.setValidatorFactory(mockupValidatorFactory);
    Unit unit = new Unit();
    unit.setName("DISPLAYNAME");
    try {
      unitValidator.validate(unit, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
  }
}
