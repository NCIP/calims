/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.container;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.Container;

/**
 * @author connollym
 *
 */
public class ContainerValidatorTest {
  
  private ContainerValidator containerValidator = new ContainerValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the ContainerValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateContainerFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new ContainerValidatorMockup());
    containerValidator.setValidatorFactory(mockupValidatorFactory);
    Container container = new Container();
    try {
    containerValidator.validate(container, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Container.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the ContainerValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateContainerTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new ContainerValidatorMockup());
  
  containerValidator.setValidatorFactory(mockupValidatorFactory);
  Container container = new Container();
  container.setName("JOE");
  try {
        containerValidator.validate(container, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}
