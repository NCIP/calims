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

import gov.nih.nci.calims2.domain.administration.BaseUnit;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.administration.Unit;
import gov.nih.nci.calims2.domain.administration.visitor.UnitVisitor;

/**
 * @author katariap
 * 
 */
public class UnitHierarchyValidator implements UnitVisitor {

  @SuppressWarnings("unused")
  private Collection<ConstraintViolation<Unit>> violations;

  /**
   * {@inheritDoc}
   */
  public void visitUnit(Unit unit) {
    // Nothing to do
  }

  /**
   * {@inheritDoc}
   */
  public void visitBaseUnit(BaseUnit baseUnit) {
    visitUnit(baseUnit);
  }

  /**
   * {@inheritDoc}
   */
  public void visitStandardUnit(StandardUnit standardUnit) {
    visitUnit(standardUnit);
  }

  /**
   * The violations to be set.
   * 
   * @param violations the violations to be set.
   */
  public void setViolations(Collection<ConstraintViolation<Unit>> violations) {
    this.violations = violations;
  }

}
