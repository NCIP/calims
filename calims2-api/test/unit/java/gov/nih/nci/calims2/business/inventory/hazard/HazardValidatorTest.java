/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.hazard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.Hazard;

/**
 * @author viseem
 *
 */
public class HazardValidatorTest {

  private HazardValidator hazardValidator = new HazardValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the HazardValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateHazardFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new HazardValdiatorMockup());
    hazardValidator.setValidatorFactory(mockupValidatorFactory);
    Hazard hazard = new Hazard();
    try {
      hazardValidator.validate(hazard, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Hazard.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the HazardValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateHazardTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new HazardValdiatorMockup());

    hazardValidator.setValidatorFactory(mockupValidatorFactory);
    Hazard hazard = new Hazard();
    hazard.setName("JOE");
    try {
      hazardValidator.validate(hazard, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator no have thrown an exception");
    }
  }
}
