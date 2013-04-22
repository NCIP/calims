/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.chemicalcompound;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.ChemicalCompound;

/**
 * @author connollym
 *
 */
public class ChemicalCompoundValidatorTest {
  
  private ChemicalCompoundValidator chemicalCompoundValidator = new ChemicalCompoundValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the ChemicalCompoundValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateChemicalCompoundFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new ChemicalCompoundValidatorMockup());
    chemicalCompoundValidator.setValidatorFactory(mockupValidatorFactory);
    ChemicalCompound chemicalCompound = new ChemicalCompound();
    try {
    chemicalCompoundValidator.validate(chemicalCompound, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid ChemicalCompound.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the ChemicalCompoundValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateChemicalCompoundTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new ChemicalCompoundValidatorMockup());
  
  chemicalCompoundValidator.setValidatorFactory(mockupValidatorFactory);
  ChemicalCompound chemicalCompound = new ChemicalCompound();
  chemicalCompound.setName("JOE");
  try {
        chemicalCompoundValidator.validate(chemicalCompound, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}
