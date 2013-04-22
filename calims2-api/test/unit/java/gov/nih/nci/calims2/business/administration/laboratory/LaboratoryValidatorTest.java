/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.laboratory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.Laboratory;

/**
 * @author connollym@moxieinformaticas.com
 *
 */
public class LaboratoryValidatorTest {
  private LaboratoryValidator laboratoryValidator = new LaboratoryValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the LaboratoryValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new LaboratoryValidatorMockup());
    laboratoryValidator.setValidatorFactory(mockupValidatorFactory);
    Laboratory laboratory = new Laboratory();
    try {
       laboratoryValidator.validate(laboratory, ValidationOperation.CREATE);
       fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a validLaboratory.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the LaboratoryValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateTypeTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new LaboratoryValidatorMockup());
  
  laboratoryValidator.setValidatorFactory(mockupValidatorFactory);
  Laboratory laboratory = new Laboratory();
  laboratory.setName("DISPLAYNAME");
  try {
        laboratoryValidator.validate(laboratory, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator should have thrown an exception");
  }
  }
}
