/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.common.environmentalcondition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.common.environmentalcondition.EnvironmentalCondition;

/**
 * @author connollym
 *
 */
public class EnvironmentalConditionValidatorTest {
  
  private EnvironmentalConditionValidator environmentalConditionValidator = new EnvironmentalConditionValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the EnvironmentalConditionValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateEnvironmentalConditionFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new EnvironmentalConditionValidatorMockup());
    environmentalConditionValidator.setValidatorFactory(mockupValidatorFactory);
    EnvironmentalCondition environmentalCondition = new EnvironmentalCondition();
    try {
    environmentalConditionValidator.validate(environmentalCondition, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid EnvironmentalCondition.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the EnvironmentalConditionValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateEnvironmentalConditionTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new EnvironmentalConditionValidatorMockup());
  
  environmentalConditionValidator.setValidatorFactory(mockupValidatorFactory);
  EnvironmentalCondition environmentalCondition = new EnvironmentalCondition();
  environmentalCondition.setName("JOE");
  try {
        environmentalConditionValidator.validate(environmentalCondition, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}

