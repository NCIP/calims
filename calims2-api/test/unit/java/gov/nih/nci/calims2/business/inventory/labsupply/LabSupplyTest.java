/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.labsupply;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.LabSupply;

/**
 * @author katariap
 * 
 */
public class LabSupplyTest {

  private LabSupplyValidator labSupplyValidator = new LabSupplyValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the AntigenValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateAntigenFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new LabSupplyValidatorMockup());
    labSupplyValidator.setValidatorFactory(mockupValidatorFactory);
    LabSupply labSupply = new LabSupply();
    try {
      labSupplyValidator.validate(labSupply, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Antigen.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the LabSupplyValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateLabSupplyTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new LabSupplyValidatorMockup());

    labSupplyValidator.setValidatorFactory(mockupValidatorFactory);
    LabSupply labSupply = new LabSupply();
    labSupply.setName("JOE");
    try {
      labSupplyValidator.validate(labSupply, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator no have thrown an exception");
    }
  }
}