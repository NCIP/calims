/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.namingconvention;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.NamingConvention;

/**
 * @author katariap
 * 
 */
public class NamingConventionValidatorTest {
  private NamingConventionValidator namingConventionValidator = new NamingConventionValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the NamingConventionValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new NamingConventionValidatorMockup());
    namingConventionValidator.setValidatorFactory(mockupValidatorFactory);
    NamingConvention namingConvention = new NamingConvention();
    try {
      namingConventionValidator.validate(namingConvention, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid NamingConvention.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the NamingConventionValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateTypeTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new NamingConventionValidatorMockup());

    namingConventionValidator.setValidatorFactory(mockupValidatorFactory);
    NamingConvention namingConvention = new NamingConvention();
    namingConvention.setName("DISPLAYNAME");
    try {
      namingConventionValidator.validate(namingConvention, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
  }
}
