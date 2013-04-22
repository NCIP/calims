/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.report;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.report.Report;

/**
 * @author connollym
 *
 */
public class ReportValidatorTest {
  
  private ReportValidator reportValidator = new ReportValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;
  
  
  /**
   * Tests the ReportValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateReportFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new ReportValidatorMockup());
    reportValidator.setValidatorFactory(mockupValidatorFactory);
    Report report = new Report();
    try {
    reportValidator.validate(report, ValidationOperation.CREATE);
    fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Report.", violation.getMessage(), "Name required.");
    }
  }
  
 /**
  *  Tests the ReportValidator. The validator should not throw an exception.
  */
  @Test
public void testValidateReportTrue() {
  mockupValidatorFactory = new ValidatorFactoryMockup();
  mockupValidatorFactory.setValidator(new ReportValidatorMockup());
  
  reportValidator.setValidatorFactory(mockupValidatorFactory);
  Report report = new Report();
  report.setName("JOE");
  try {
        reportValidator.validate(report, ValidationOperation.CREATE);
  } catch (ValidationException ex) {
    fail("Validator no have thrown an exception");
  }
  }
}

