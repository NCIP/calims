/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.layout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.Layout;

/**
 * @author connollym
 *
 */
public class LayoutValidatorTest {
  
  private LayoutValidator layoutValidator = new LayoutValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the LayoutValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateLayoutFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new LayoutValidatorMockup());
    layoutValidator.setValidatorFactory(mockupValidatorFactory);
    Layout layout = new Layout();
    try {
    layoutValidator.validate(layout, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Layout.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the LayoutValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateLayoutTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new LayoutValidatorMockup());
  
  layoutValidator.setValidatorFactory(mockupValidatorFactory);
  Layout layout = new Layout();
  layout.setName("JOE");
  try {
        layoutValidator.validate(layout, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}
