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
import java.util.HashSet;
import java.util.Set;

import gov.nih.nci.calims2.domain.report.Clause;
import gov.nih.nci.calims2.domain.report.Conjunction;
import gov.nih.nci.calims2.domain.report.Disjunction;
import gov.nih.nci.calims2.domain.report.Negation;
import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.domain.report.Restriction;
import gov.nih.nci.calims2.domain.report.visitor.ClauseVisitor;

/**
 * Clause visitor that search for the root clause of a query.
 * 
 * @author viseem
 * 
 */
public class RootClauseSearch implements ClauseVisitor {

  private Set<Clause> orphanClauses;

  /**
   * {@inheritDoc}
   */
  public void visitClause(Clause clause) {
    // nothing to do
  }

  private void visitCompositeClause(Collection<Clause> subClauses) {
    for (Clause subClause : subClauses) {
      orphanClauses.remove(subClause);
      subClause.accept(this);
    }
  }

  /**
   * {@inheritDoc}
   */
  public void visitConjunction(Conjunction conjunction) {
    visitCompositeClause(conjunction.getClauseCollection());
  }

  /**
   * {@inheritDoc}
   */
  public void visitDisjunction(Disjunction disjunction) {
    visitCompositeClause(disjunction.getClauseCollection());
  }

  /**
   * {@inheritDoc}
   */
  public void visitNegation(Negation negation) {
    // Nothing to do
  }

  /**
   * {@inheritDoc}
   */
  public void visitRestriction(Restriction restriction) {
    // Nothing to do
  }

  /**
   * Gets the root clause of the given query.
   * 
   * @param query The query to process
   * @return The root clause of the given query.
   */
  public static Clause getRootClause(Query query) {
    if (query.getClauseCollection() == null || query.getClauseCollection().isEmpty()) {
      return null;
    }
    RootClauseSearch searchVisitor = new RootClauseSearch();
    searchVisitor.orphanClauses = new HashSet<Clause>(query.getClauseCollection());
    for (Clause clause : query.getClauseCollection()) {
      clause.accept(searchVisitor);
    }
    if (searchVisitor.orphanClauses.size() != 1) {
      throw new IllegalArgumentException("Invalid query structure");
    }
    return searchVisitor.orphanClauses.iterator().next();
  }

}
