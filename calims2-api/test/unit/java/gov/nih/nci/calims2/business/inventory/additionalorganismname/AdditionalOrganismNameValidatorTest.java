/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.additionalorganismname;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.AdditionalOrganismName;

/**
 * @author connollym
 * 
 */
public class AdditionalOrganismNameValidatorTest {

  private AdditionalOrganismNameValidator additionalOrganismNameValidator = new AdditionalOrganismNameValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the AdditionalOrganismNameValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateAdditionalOrganismNameFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new AdditionalOrganismNameValidatorMockup());
    additionalOrganismNameValidator.setValidatorFactory(mockupValidatorFactory);
    AdditionalOrganismName additionalOrganismName = new AdditionalOrganismName();
    try {
      additionalOrganismNameValidator.validate(additionalOrganismName, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid AdditionalOrganismName.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the AdditionalOrganismNameValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateAdditionalOrganismNameTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new AdditionalOrganismNameValidatorMockup());

    additionalOrganismNameValidator.setValidatorFactory(mockupValidatorFactory);
    AdditionalOrganismName additionalOrganismName = new AdditionalOrganismName();
    additionalOrganismName.setName("JOE");
    try {
      additionalOrganismNameValidator.validate(additionalOrganismName, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator no have thrown an exception");
    }
  }
}
