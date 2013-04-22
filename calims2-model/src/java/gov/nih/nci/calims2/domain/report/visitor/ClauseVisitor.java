/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.domain.report.visitor;

import gov.nih.nci.calims2.domain.report.Clause;
import gov.nih.nci.calims2.domain.report.Conjunction;
import gov.nih.nci.calims2.domain.report.Disjunction;
import gov.nih.nci.calims2.domain.report.Negation;
import gov.nih.nci.calims2.domain.report.Restriction;

/**
 * @author viseem
 * 
 */
public interface ClauseVisitor {
  /**
   * visit a clause.
   * 
   * @param clause The clause to visit
   */
  void visitClause(Clause clause);

  /**
   * visit a conjunction.
   * 
   * @param conjunction The conjunction to visit
   */
  void visitConjunction(Conjunction conjunction);

  /**
   * visit a disjunction.
   * 
   * @param disjunction The disjunction to visit
   */
  void visitDisjunction(Disjunction disjunction);

  /**
   * visit a negation.
   * 
   * @param negation The negation to visit
   */
  void visitNegation(Negation negation);

  /**
   * visit a restriction.
   * 
   * @param restriction The restriction to visit
   */
  void visitRestriction(Restriction restriction);
}
