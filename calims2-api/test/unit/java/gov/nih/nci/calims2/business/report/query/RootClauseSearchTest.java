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

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import gov.nih.nci.calims2.domain.report.Clause;
import gov.nih.nci.calims2.domain.report.Conjunction;
import gov.nih.nci.calims2.domain.report.Disjunction;
import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.domain.report.Restriction;

/**
 * @author viseem
 * 
 */
public class RootClauseSearchTest {
  /**
   * Test the getRootClause method.
   */
  @Test
  public void testGetRootClause() {
    Query query = createQuery();
    Clause clause = RootClauseSearch.getRootClause(query);
    assertEquals("Wrong clause id returned", new Long(1), clause.getId());
  }

  private Query createQuery() {
    Query query = new Query();
    Disjunction clause1 = new Disjunction();
    clause1.setId(1L);
    Conjunction clause2 = new Conjunction();
    Restriction clause3 = new Restriction();
    Restriction clause4 = new Restriction();
    Restriction clause5 = new Restriction();
    Set<Clause> clause2SubClauses = new HashSet<Clause>();
    clause2SubClauses.add(clause4);
    clause2SubClauses.add(clause5);
    clause2.setClauseCollection(clause2SubClauses);
    Set<Clause> clause1SubClauses = new HashSet<Clause>();
    clause1SubClauses.add(clause2);
    clause1SubClauses.add(clause3);
    clause1.setClauseCollection(clause1SubClauses);
    Set<Clause> clauses = new HashSet<Clause>();
    clauses.add(clause1);
    clauses.add(clause2);
    clauses.add(clause3);
    clauses.add(clause4);
    clauses.add(clause5);
    query.setClauseCollection(clauses);
    return query;
  }

}
