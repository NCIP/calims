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
 * ClauseVisitor that copies the whole clause hierarchy of a query into another query.
 * 
 * @author viseem
 * 
 */
public class ClauseCopier implements ClauseVisitor {

  private Set<Clause> copies = new HashSet<Clause>();
  private Clause copy;
  private Query query;

  /**
   * Constructor.
   * 
   * @param query The query to associate to the clause copies.
   */
  public ClauseCopier(Query query) {
    this.query = query;
  }

  /**
   * {@inheritDoc}
   */
  public void visitClause(Clause clause) {
    // Nothing to do
  }
  
  /**
   * Adds a new clause to the collection .
   * @param clause The new clause to add.
   */
  void addClause(Clause clause) {
    copy = clause;
    copies.add(clause);
  }

  /**
   * Sets the clause fields in the target clause.
   * 
   * @param source The original clause
   * @param target The new clause
   */
  void setClauseFields(Clause source, Clause target) {
    target.setClauseIndex(source.getClauseIndex());
    target.setQuery(query);
  }

  /**
   * Copy the given collection of clauses.
   * 
   * @param subClauses The clauses to copy
   * @return The collection of copies
   */
  Set<Clause> copySubClauses(Collection<Clause> subClauses) {
    Set<Clause> clauses = new HashSet<Clause>();
    if (subClauses != null) {
      for (Clause subClause : subClauses) {
        subClause.accept(this);
        clauses.add(copy);
      }
    }
    return clauses;
  }

  /**
   * {@inheritDoc}
   */
  public void visitConjunction(Conjunction conjunction) {
    Conjunction newConjunction = new Conjunction();
    setClauseFields(conjunction, newConjunction);
    newConjunction.setClauseCollection(copySubClauses(conjunction.getClauseCollection()));
    addClause(newConjunction);
  }

  /**
   * {@inheritDoc}
   */
  public void visitDisjunction(Disjunction disjunction) {
    Disjunction newDisjunction = new Disjunction();
    setClauseFields(disjunction, newDisjunction);
    newDisjunction.setClauseCollection(copySubClauses(disjunction.getClauseCollection()));
    addClause(newDisjunction);
  }

  /**
   * {@inheritDoc}
   */
  public void visitNegation(Negation negation) {
    Negation newNegation = new Negation();
    setClauseFields(negation, newNegation);
    negation.getClause().accept(this);
    newNegation.setClause(copy);
    addClause(negation);
  }

  /**
   * {@inheritDoc}
   */
  public void visitRestriction(Restriction restriction) {
    Restriction newRestriction = new Restriction();
    setClauseFields(restriction, newRestriction);
    newRestriction.setPropertyName(restriction.getPropertyName());
    newRestriction.setPropertyType(restriction.getPropertyType());
    newRestriction.setOperator(restriction.getOperator());
    newRestriction.setValue(restriction.getValue());
    addClause(newRestriction);
  }

  /**
   * @return the copies
   */
  public Set<Clause> getCopies() {
    return copies;
  }

}
