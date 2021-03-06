/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.strain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.Strain;

/**
 * @author connollym
 *
 */
public class StrainValidatorTest {
  
  private StrainValidator strainValidator = new StrainValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the StrainValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateStrainFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new StrainValidatorMockup());
    strainValidator.setValidatorFactory(mockupValidatorFactory);
    Strain strain = new Strain();
    try {
    strainValidator.validate(strain, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Strain.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the StrainValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateStrainTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new StrainValidatorMockup());
  
  strainValidator.setValidatorFactory(mockupValidatorFactory);
  Strain strain = new Strain();
  strain.setName("JOE");
  try {
        strainValidator.validate(strain, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}
