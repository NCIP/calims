/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.postaladdress;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.PostalAddress;

/**
 * @author connollym
 *
 */
public class PostalAddressValidatorTest {
  private PostalAddressValidator postalAddressValidator = new PostalAddressValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the PostalAddressValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new PostalAddressValidatorMockup());
    postalAddressValidator.setValidatorFactory(mockupValidatorFactory);
    PostalAddress postalAddress = new PostalAddress();
    try {
       postalAddressValidator.validate(postalAddress, ValidationOperation.CREATE);
       fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a validPostalAddress.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the PostalAddressValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateTypeTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new PostalAddressValidatorMockup());
  
  postalAddressValidator.setValidatorFactory(mockupValidatorFactory);
  PostalAddress postalAddress = new PostalAddress();
  postalAddress.setName("DISPLAYNAME");
  try {
        postalAddressValidator.validate(postalAddress, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator should have thrown an exception");
  }
  }
}
