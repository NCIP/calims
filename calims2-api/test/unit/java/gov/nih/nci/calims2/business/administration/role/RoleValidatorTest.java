/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.role;

/**
 * @author connollym
 *
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.Role;

/**
 * @author katariap
 * 
 */
public class RoleValidatorTest {
  private RoleValidator roleValidator = new RoleValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the RoleValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new RoleValidatorMockup());
    roleValidator.setValidatorFactory(mockupValidatorFactory);
    Role role = new Role();
    try {
      roleValidator.validate(role, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Role.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the RoleValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateTypeTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new RoleValidatorMockup());

    roleValidator.setValidatorFactory(mockupValidatorFactory);
    Role role = new Role();
    role.setName("DISPLAYNAME");
    try {
      roleValidator.validate(role, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
  }
}
