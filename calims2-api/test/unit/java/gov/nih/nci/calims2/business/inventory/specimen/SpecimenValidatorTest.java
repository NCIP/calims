/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.specimen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.Specimen;

/**
 * @author connollym
 *
 */
public class SpecimenValidatorTest {
  
  private SpecimenValidator specimenValidator = new SpecimenValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the SpecimenValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateSpecimenFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new SpecimenValidatorMockup());
    specimenValidator.setValidatorFactory(mockupValidatorFactory);
    Specimen specimen = new Specimen();
    try {
    specimenValidator.validate(specimen, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Specimen.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the SpecimenValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateSpecimenTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new SpecimenValidatorMockup());
  
  specimenValidator.setValidatorFactory(mockupValidatorFactory);
  Specimen specimen = new Specimen();
  specimen.setName("JOE");
  try {
        specimenValidator.validate(specimen, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}

