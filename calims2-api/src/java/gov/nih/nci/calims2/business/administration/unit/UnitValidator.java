/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.unit;

import java.util.Collection;

import javax.validation.ConstraintViolation;

import gov.nih.nci.calims2.business.util.validation.DefaultValidator;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.domain.administration.Unit;

/**
 * @author katariap
 *
 */
public class UnitValidator extends DefaultValidator<Unit> {

  /**
   * {@inheritDoc}
   */
  public Collection<ConstraintViolation<Unit>> doValidate(Unit entity, ValidationOperation operation) {
    Collection<ConstraintViolation<Unit>> violations = super.doValidate(entity, operation);
    UnitHierarchyValidator validator = new UnitHierarchyValidator();
    validator.setViolations(violations);
    entity.accept(validator);
    return violations;
  }
 

}
