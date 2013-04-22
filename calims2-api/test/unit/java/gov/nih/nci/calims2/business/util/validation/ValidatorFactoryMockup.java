/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.util.validation;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.MessageInterpolator;
import javax.validation.TraversableResolver;
import javax.validation.Validator;
import javax.validation.ValidatorContext;
import javax.validation.ValidatorFactory;

/**
 * @author connollym
 *
 */
public class ValidatorFactoryMockup implements ValidatorFactory {

  private Validator validator;

  /**
   * {@inheritDoc}
   */
  public ConstraintValidatorFactory getConstraintValidatorFactory() {
   
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public MessageInterpolator getMessageInterpolator() {
   
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public TraversableResolver getTraversableResolver() {
   
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public Validator getValidator() {
   
    return validator;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T unwrap(Class<T> type) {
   
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public ValidatorContext usingContext() {
  
    return null;
  }

  /**
   * @param validator the validator to set
   */
  public void setValidator(Validator validator) {
    this.validator = validator;
  }

}
