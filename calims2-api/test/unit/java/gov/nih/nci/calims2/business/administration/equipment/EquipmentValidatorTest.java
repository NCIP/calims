/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.equipment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.Equipment;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public class EquipmentValidatorTest {
  private EquipmentValidator equipmentValidator = new EquipmentValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the EquipmentValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new EquipmentValidatorMockup());
    equipmentValidator.setValidatorFactory(mockupValidatorFactory);
    Equipment equipment = new Equipment();
    try {
      equipmentValidator.validate(equipment, ValidationOperation.CREATE);
       fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Equipment.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the EquipmentValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateTypeTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new EquipmentValidatorMockup());
  equipmentValidator.setValidatorFactory(mockupValidatorFactory);
  Equipment equipment = new Equipment();
  equipment.setName("DISPLAYNAME");
  try {
    equipmentValidator.validate(equipment, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator should have thrown an exception");
  }
  }
}

