/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.word;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.ValidatorFactoryMockup;
import gov.nih.nci.calims2.domain.administration.Word;

/**
 * @author katariap
 * 
 */
public class WordValidatorTest {
  private WordValidator wordValidator = new WordValidator();
  private ValidatorFactoryMockup mockupValidatorFactory;

  /**
   * Tests the WordValidator. The validator should throw an exception.
   */
  @Test
  public void testValidateTypeFalse() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new WordValidatorMockup());
    wordValidator.setValidatorFactory(mockupValidatorFactory);
    Word word = new Word();
    try {
      wordValidator.validate(word, ValidationOperation.CREATE);
      fail("Validator should have thrown an exception");
    } catch (ValidationException ex) {
      ConstraintViolation<?> violation = ex.getViolations().iterator().next();
      assertEquals("Not a valid Word.", violation.getMessage(), "Name required.");
    }
  }

  /**
   * Tests the WordValidator. The validator should not throw an exception.
   */
  @Test
  public void testValidateTypeTrue() {
    mockupValidatorFactory = new ValidatorFactoryMockup();
    mockupValidatorFactory.setValidator(new WordValidatorMockup());

    wordValidator.setValidatorFactory(mockupValidatorFactory);
    Word word = new Word();
    word.setName("DISPLAYNAME");
    try {
      wordValidator.validate(word, ValidationOperation.CREATE);
    } catch (ValidationException ex) {
      fail("Validator should have thrown an exception");
    }
  }
}
