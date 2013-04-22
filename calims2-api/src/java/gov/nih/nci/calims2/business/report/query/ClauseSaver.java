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
import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.domain.report.Restriction;
import gov.nih.nci.calims2.domain.report.visitor.ClauseVisitor;

/**
 * ClauseVisitor that saves the whole clause hierarchy of a query.
 * 
 * @author viseem
 * 
 */
public class ClauseSaver implements ClauseVisitor {

  private GenericDao genericDao;
  private Query query;

  /**
   * Constructor.
   * 
   * @param genericDao The genericDao
   * @param query The query to which the where clause belongs
   */
  public ClauseSaver(GenericDao genericDao, Query query) {
    this.genericDao = genericDao;
    this.query = query;
  }

  /**
   * {@inheritDoc}
   */
  public void visitClause(Clause clause) {
    clause.setQuery(query);
    genericDao.create(clause);
  }

  /**
   * saves a composite clause.
   * 
   * @param clause The clause
   * @param subClauses Its sub clauses
   */
  public void visitCompositeClause(Clause clause, Collection<Clause> subClauses) {
    visitClause(clause);
    for (Clause subClause : subClauses) {
      subClause.accept(this);
    }
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
    negation.getClause().accept(this);
    visitClause(negation);
  }

  /**
   * {@inheritDoc}
   */
  public void visitRestriction(Restriction restriction) {
    visitClause(restriction);
  }

  /**
   * Saves the clause for the given query.
   * 
   * @param genericDao The genericDao
   * @param query The query to which te where clause belongs
   * @param rootClause The root clause of the query
   */
  public static void saveClause(GenericDao genericDao, Query query, Clause rootClause) {
    ClauseSaver saver = new ClauseSaver(genericDao, query);
    rootClause.accept(saver);
  }
}
