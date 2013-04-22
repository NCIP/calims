/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.storagespace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.StorageSpace;

/**
 * @author katariap
 *
 */
public class StorageSpaceValidatorTest {
  private StorageSpaceValidator storageSpaceValidator = new StorageSpaceValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  /**
   * Tests the StorageSpaceValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new StorageSpaceValidatorMockup());
    storageSpaceValidator.setValidatorFactory(mockupValidatorFactory);
    StorageSpace storageSpace = new StorageSpace();
    try {
      storageSpaceValidator.validate(storageSpace, ValidationOperation.CREATE);
       fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid StorageSpace.", violation.getMessage(), "Name required.");
    }
  }

   /**
    *  Tests the StorageSpaceValidator. The validator should not throw an exception.
    */
  @Test
  public void testValidateTypeTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new StorageSpaceValidatorMockup());
    
    storageSpaceValidator.setValidatorFactory(mockupValidatorFactory);
    StorageSpace storageSpace = new StorageSpace();
    storageSpace.setName("DISPLAYNAME");
    try {
      storageSpaceValidator.validate(storageSpace, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
  }
}
