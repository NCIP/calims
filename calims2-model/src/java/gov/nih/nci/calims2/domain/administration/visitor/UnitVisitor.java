/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.domain.administration.visitor;

import gov.nih.nci.calims2.domain.administration.BaseUnit;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.administration.Unit;

/**
 * @author connollym
 *
 */
public interface UnitVisitor {
  
  /**
   * Visits the BaseUnit subclass.
   * @param baseUnit the baseUnit to visit.
   */
  void visitBaseUnit(BaseUnit baseUnit);
  
  /**
   * Visits the StandardUnit subclass.
   * @param standardUnit the standardUnit to visit.
   */
  void visitStandardUnit(StandardUnit standardUnit);
  
  /**
   * Visits the Unit subclass.
   * @param Unit the Unit to visit.
   */
  void visitUnit(Unit unit);

}
