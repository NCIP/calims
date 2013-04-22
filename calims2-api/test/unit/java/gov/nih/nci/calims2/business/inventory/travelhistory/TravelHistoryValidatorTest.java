/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.travelhistory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.inventory.characteristics.TravelHistory;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public class TravelHistoryValidatorTest {
  private TravelHistoryValidator travelHistory = new TravelHistoryValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the TravelHistory. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new TravelHistoryValidatorMockup());
    travelHistory.setValidatorFactory(mockupValidatorFactory);
    TravelHistory antibody = new TravelHistory();
    try {
      travelHistory.validate(antibody, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid TravelHistory.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the TravelHistory. The validator should not throw an exception.
   */
  @Test
  public void testValidateTypeTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new TravelHistoryValidatorMockup());
    travelHistory.setValidatorFactory(mockupValidatorFactory);
    TravelHistory antibody = new TravelHistory();
    antibody.setName("DISPLAYNAME");
    try {
      travelHistory.validate(antibody, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
  }

}
