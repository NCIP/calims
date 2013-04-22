/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.customerservice.quotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.administration.customerservice.invoice.InvoiceValidator;
import gov.nih.nci.calims2.business.administration.customerservice.invoice.InvoiceValidatorMockup;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.customerservice.Invoice;

/**
 * @author connollym
 *
 */
public class QuotationValidatorTest {
  private InvoiceValidator invoiceValidator = new InvoiceValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the InvoiceValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new InvoiceValidatorMockup());
    invoiceValidator.setValidatorFactory(mockupValidatorFactory);
    Invoice invoice = new Invoice();
    try {
      invoiceValidator.validate(invoice, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Invoice.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the InvoiceValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateTypeTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new InvoiceValidatorMockup());
    invoiceValidator.setValidatorFactory(mockupValidatorFactory);
    Invoice invoice = new Invoice();
    invoice.setName("DISPLAYNAME");
    try {
      invoiceValidator.validate(invoice, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
  }
}
