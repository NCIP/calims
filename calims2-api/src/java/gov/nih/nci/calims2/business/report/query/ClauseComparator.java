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

import java.util.Comparator;

import gov.nih.nci.calims2.domain.report.Clause;

/**
 * @author viseem
 *
 */
public class ClauseComparator implements Comparator<Clause> {

  /**
   * {@inheritDoc}
   */
  public int compare(Clause clause1, Clause clause2) {
    return clause1.getClauseIndex().compareTo(clause2.getClauseIndex());
  }

}
