/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.containertype;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.ContainerType;

/**
 * @author connollym
 *
 */
public class ContainerTypeValidatorTest {
  
  private ContainerTypeValidator containerTypeValidator = new ContainerTypeValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the ContainerTypeValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateContainerTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new ContainerTypeValidatorMockup());
    containerTypeValidator.setValidatorFactory(mockupValidatorFactory);
    ContainerType containerType = new ContainerType();
    try {
    containerTypeValidator.validate(containerType, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid ContainerType.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the ContainerTypeValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateContainerTypeTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new ContainerTypeValidatorMockup());
  
  containerTypeValidator.setValidatorFactory(mockupValidatorFactory);
  ContainerType containerType = new ContainerType();
  containerType.setName("JOE");
  try {
        containerTypeValidator.validate(containerType, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}

