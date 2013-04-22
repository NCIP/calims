/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.common.document;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.common.Document;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public class DocumentValidatorTest {
  private DocumentValidator documentValidator = new DocumentValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the DocumentValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateDocumentFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new DocumentValidatorMockup());
    documentValidator.setValidatorFactory(mockupValidatorFactory);
    Document document = new Document();
    try {
       documentValidator.validate(document, ValidationOperation.CREATE);
       fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a validDocument.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the DocumentValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateDocumentTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new DocumentValidatorMockup());
  
  documentValidator.setValidatorFactory(mockupValidatorFactory);
  Document document = new Document();
  document.setName("DISPLAYNAME");
  try {
        documentValidator.validate(document, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator should have thrown an exception");
  }
  }
}

