/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.taxon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.Taxon;

/**
 * @author connollym
 *
 */
public class TaxonValidatorTest {
  
  private TaxonValidator taxonValidator = new TaxonValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the TaxonValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTaxonFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new TaxonValidatorMockup());
    taxonValidator.setValidatorFactory(mockupValidatorFactory);
    Taxon taxon = new Taxon();
    try {
    taxonValidator.validate(taxon, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Taxon.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the TaxonValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateTaxonTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new TaxonValidatorMockup());
  
  taxonValidator.setValidatorFactory(mockupValidatorFactory);
  Taxon taxon = new Taxon();
  taxon.setName("JOE");
  try {
        taxonValidator.validate(taxon, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}
