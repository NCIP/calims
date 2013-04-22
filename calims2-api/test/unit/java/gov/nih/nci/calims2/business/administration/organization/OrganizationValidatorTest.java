/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.organization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.Organization;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public class OrganizationValidatorTest {
  private OrganizationValidator organizationValidator = new OrganizationValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the OrganizationValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateOrganizationFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new OrganizationValidatorMockup());
    organizationValidator.setValidatorFactory(mockupValidatorFactory);
    Organization organization = new Organization();
    try {
       organizationValidator.validate(organization, ValidationOperation.CREATE);
       fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a validOrganization.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the OrganizationValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateOrganizationTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new OrganizationValidatorMockup());
  
  organizationValidator.setValidatorFactory(mockupValidatorFactory);
  Organization organization = new Organization();
  organization.setName("DISPLAYNAME");
  try {
        organizationValidator.validate(organization, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator should have thrown an exception");
  }
  }
}

