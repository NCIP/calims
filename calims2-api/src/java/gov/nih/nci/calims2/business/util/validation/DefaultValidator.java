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

import java.util.Collection;

import javax.validation.ConstraintViolation;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * @author connollym@moxieinformatics.com
 * 
 *         DefaultValidator for validating persistent objects.
 * @param <T> The entity being validated
 */
public class DefaultValidator<T extends EntityWithId> implements gov.nih.nci.calims2.business.util.validation.Validator<T> {

  private static Logger log = LoggerFactory.getLogger(DefaultValidator.class);
  private ValidatorFactory validatorFactory;

  /**
   * @return the validatorFactory
   */
  public ValidatorFactory getValidatorFactory() {
    return validatorFactory;
  }

  /**
   * {@inheritDoc}
   */

  public void validate(T entity, ValidationOperation operation) throws ValidationException {
    Collection<ConstraintViolation<T>> constraintViolations = doValidate(entity, operation);
    if (!constraintViolations.isEmpty()) {
      throw new ValidationException("Entity Not Valid.", constraintViolations);
    }
  }

  /**
   * {@inheritDoc}
   */
  public Collection<ConstraintViolation<T>> doValidate(T entity, ValidationOperation operation) {
    Collection<ConstraintViolation<T>> violations = validatorFactory.getValidator().validate(entity);
    if (!violations.isEmpty()) {
      for (ConstraintViolation<T> violation : violations) {
        log.debug("Constraint Violation: " + violation.getMessage());
      }
    }
    return violations;
  }

  /**
   * @param validatorFactory the validatorFactory to set
   */
  public void setValidatorFactory(ValidatorFactory validatorFactory) {
    this.validatorFactory = validatorFactory;
  }

}
