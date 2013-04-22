/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.collaboration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.Collaboration;

/**
 * @author connollym
 *
 */
public class CollaborationValidatorTest {
  
  private CollaborationValidator collaborationValidator = new CollaborationValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the CollaborationValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateCollaborationFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new CollaborationValidatorMockup());
    collaborationValidator.setValidatorFactory(mockupValidatorFactory);
    Collaboration collaboration = new Collaboration();
    try {
    collaborationValidator.validate(collaboration, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Collaboration.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the CollaborationValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateCollaborationTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new CollaborationValidatorMockup());
  
  collaborationValidator.setValidatorFactory(mockupValidatorFactory);
  Collaboration collaboration = new Collaboration();
  collaboration.setName("JOE");
  try {
        collaborationValidator.validate(collaboration, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}
