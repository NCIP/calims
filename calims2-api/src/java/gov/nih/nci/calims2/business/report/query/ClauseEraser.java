/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.query;

import java.util.Collection;

import gov.nih.nci.calims2.dao.GenericDao;
import gov.nih.nci.calims2.domain.report.Clause;
import gov.nih.nci.calims2.domain.report.Conjunction;
import gov.nih.nci.calims2.domain.report.Disjunction;
import gov.nih.nci.calims2.domain.report.Negation;
import gov.nih.nci.calims2.domain.report.Restriction;
import gov.nih.nci.calims2.domain.report.visitor.ClauseVisitor;

/**
 * ClauseVisitor that deletes a whole clause hierarchy.
 * 
 * @author viseem
 * 
 */
public class ClauseEraser implements ClauseVisitor {

  private GenericDao genericDao;

  /**
   * Constructor.
   * 
   * @param genericDao The genericDao
   */
  public ClauseEraser(GenericDao genericDao) {
    this.genericDao = genericDao;
  }

  /**
   * {@inheritDoc}
   */
  public void visitClause(Clause clause) {
    genericDao.delete(clause);
  }

  /**
   * deletes a composite clause.
   * 
   * @param clause The clause
   * @param subClauses Its sub clauses
   */
  public void visitCompositeClause(Clause clause, Collection<Clause> subClauses) {
    for (Clause subClause : subClauses) {
      subClause.accept(this);
    }
    visitClause(clause);
  }

  /**
   * {@inheritDoc}
   */
  public void visitConjunction(Conjunction conjunction) {
    visitCompositeClause(conjunction, conjunction.getClauseCollection());
  }

  /**
   * {@inheritDoc}
   */
  public void visitDisjunction(Disjunction disjunction) {
    visitCompositeClause(disjunction, disjunction.getClauseCollection());
  }

  /**
   * {@inheritDoc}
   */
  public void visitNegation(Negation negation) {
    visitClause(negation);
    negation.getClause().accept(this);
  }

  /**
   * {@inheritDoc}
   */
  public void visitRestriction(Restriction restriction) {
    visitClause(restriction);
  }

  /**
   * Deletes the clause for a query.
   * 
   * @param genericDao The genericDao
   * @param rootClause The root clause of the query
   */
  public static void deleteClause(GenericDao genericDao, Clause rootClause) {
    ClauseEraser eraser = new ClauseEraser(genericDao);
    rootClause.accept(eraser);
  }

}
