/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.containersubcategory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;

/**
 * @author connollym
 *
 */
public class ContainerSubcategoryValidatorTest {
  
private ContainerSubcategoryValidator containerSubcategoryValidator = new ContainerSubcategoryValidator();
private ValidatorFactoryMockup mockupValidatorFactory;


/**
 * Tests the ContainerSubcategoryValidator. The validator should throw an exception.
 */
@Test
public void testValidateContainerSubcategoryFalse() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new ContainerSubcategoryValidatorMockup());
  containerSubcategoryValidator.setValidatorFactory(mockupValidatorFactory);
  ContainerSubcategory containerSubcategory = new ContainerSubcategory();
  try {
  containerSubcategoryValidator.validate(containerSubcategory, ValidationOperation.CREATE);
  fail("Validator should have thrown an exception");
  } catch (ValidationException ex) {
    ConstraintViolation<?> violation = ex.getViolations().iterator().next();
    assertEquals("Not a valid ContainerSubcategory.", violation.getMessage(), "Name required.");
  }
}

/**
*  Tests the ContainerSubcategoryValidator. The validator should not throw an exception.
*/
@Test
public void testValidateContainerSubcategoryTrue() {
mockupValidatorFactory = new ValidatorFactoryMockup();
mockupValidatorFactory.setValidator(new ContainerSubcategoryValidatorMockup());

containerSubcategoryValidator.setValidatorFactory(mockupValidatorFactory);
ContainerSubcategory containerSubcategory = new ContainerSubcategory();
containerSubcategory.setName("JOE");
try {
      containerSubcategoryValidator.validate(containerSubcategory, ValidationOperation.CREATE);
} catch (ValidationException ex) {
  fail("Validator no have thrown an exception");
}
}
}
