/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.storagedevice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.StorageDevice;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public class StorageDeviceValidatorTest {
  private StorageDeviceValidator storageDeviceValidator = new StorageDeviceValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the StorageDeviceValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new StorageDeviceValidatorMockup());
    storageDeviceValidator.setValidatorFactory(mockupValidatorFactory);
    StorageDevice storageDevice = new StorageDevice();
    try {
      storageDeviceValidator.validate(storageDevice, ValidationOperation.CREATE);
       fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid StorageDevice.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the StorageDeviceValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateTypeTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new StorageDeviceValidatorMockup());
  storageDeviceValidator.setValidatorFactory(mockupValidatorFactory);
  StorageDevice storageDevice = new StorageDevice();
  storageDevice.setName("DISPLAYNAME");
  try {
    storageDeviceValidator.validate(storageDevice, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator should have thrown an exception");
  }
  }
}

