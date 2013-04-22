/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import gov.nih.nci.calims2.business.report.query.ClauseComparator;
import gov.nih.nci.calims2.domain.report.Clause;
import gov.nih.nci.calims2.domain.report.Conjunction;
import gov.nih.nci.calims2.domain.report.Disjunction;
import gov.nih.nci.calims2.domain.report.Negation;
import gov.nih.nci.calims2.domain.report.Restriction;
import gov.nih.nci.calims2.domain.report.visitor.ClauseVisitor;

/**
 * Clause visitor that converts a query clause into a list of Clause Rows for the UI.
 * @author viseem
 * 
 */
public class QueryRowRenderer implements ClauseVisitor {

  private List<ClauseRow> rows = new ArrayList<ClauseRow>();

  /**
   * {@inheritDoc}
   */
  public void visitClause(Clause clause) {
    // Nothing to do.
  }

  private void buildSubClauses(Collection<Clause> clauses, LogicalConnector connector) {
    List<Clause> sortedClauses = new ArrayList<Clause>(clauses);
    Collections.sort(sortedClauses, new ClauseComparator());
    for (Clause subClause : sortedClauses) {
      if (!rows.isEmpty()) {
        rows.get(rows.size() - 1).setConnector(connector);
      }
      rows.addAll(QueryRowRenderer.renderClause(subClause));
    }
  }

  /**
   * {@inheritDoc}
   */
  public void visitConjunction(Conjunction conjunction) {
    buildSubClauses(conjunction.getClauseCollection(), LogicalConnector.AND);
  }

  /**
   * {@inheritDoc}
   */
  public void visitDisjunction(Disjunction disjunction) {
    buildSubClauses(disjunction.getClauseCollection(), LogicalConnector.OR);
  }

  /**
   * {@inheritDoc}
   */
  public void visitNegation(Negation negation) {
    // Nothing to do right now.
  }

  /**
   * {@inheritDoc}
   */
  public void visitRestriction(Restriction restriction) {
    ClauseRow row = new ClauseRow();
    row.setPropertyName(restriction.getPropertyName());
    row.setOperator(restriction.getOperator());
    row.setValue(restriction.getValue());
    rows.add(row);
  }

  /**
   * @return the rows
   */
  public List<ClauseRow> getRows() {
    return rows;
  }
  
  /**
   * Get the clause rows for the given clause.
   * 
   * @param clause The clause to process
   * @return the rows for this clause
   */
  public static List<ClauseRow> renderClause(Clause clause) {
    if (clause != null) {
      QueryRowRenderer renderer = new QueryRowRenderer();
      clause.accept(renderer);
      return renderer.getRows();
    }
    return new ArrayList<ClauseRow>();
  }
  
  /**
   * Renders the given list of clauses in a simple string according to the given locale.
   * 
   * @param clauses The list of clauses to render
   * @param locale The locale to use for rendering
   * @return the list of clauses as a string
   */
  public static String getWhereClauseAsString(List<ClauseRow> clauses, Locale locale) {
    StringBuilder builder = new StringBuilder();
    for (ClauseRow clause : clauses) {
      builder.append(clause.getPropertyName());
      builder.append(" ");
      builder.append(clause.getOperator().getLocalizedValue(locale));
      builder.append(" ");
      builder.append(clause.getValue());
      if (clause.getConnector() != null) {
        builder.append(" ");
        builder.append(clause.getConnector().getLocalizedValue(locale));
      }
      builder.append(" ");
    }
    return builder.toString();
  }

}
