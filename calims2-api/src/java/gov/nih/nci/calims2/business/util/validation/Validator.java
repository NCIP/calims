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

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * @author connollym@moxieinformatics.com
 *
 */

/**
 * Interface for validating persistent objects.
 * 
 * @param <T>
 */
public interface Validator<T extends EntityWithId> {

  /**
   * Validates The given entity for the given operation.
   * 
   * @param entity The entity being validated.
   * @param operation The operation the entity is being validated against.
   * @throws ValidationException The exception thrown if the validation fails.
   */
  void validate(T entity, ValidationOperation operation) throws ValidationException;

  /**
   * Validates The given entity for the given operation.
   * 
   * @param entity The entity being validated.
   * @param operation The operation the entity is being validated against.
   * @return The collection of violations found by the validation.
   */
  Collection<ConstraintViolation<T>> doValidate(T entity, ValidationOperation operation);

}
