/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.reportdesign;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.report.ReportDesign;

/**
 * @author connollym
 *
 */
public class ReportDesignValidatorTest {
  
  private ReportDesignValidator strainValidator = new ReportDesignValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the ReportDesignValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateReportDesignFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new ReportDesignValidatorMockup());
    strainValidator.setValidatorFactory(mockupValidatorFactory);
    ReportDesign strain = new ReportDesign();
    try {
    strainValidator.validate(strain, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid ReportDesign.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the ReportDesignValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateReportDesignTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new ReportDesignValidatorMockup());
  
  strainValidator.setValidatorFactory(mockupValidatorFactory);
  ReportDesign strain = new ReportDesign();
  strain.setName("JOE");
  try {
        strainValidator.validate(strain, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}

