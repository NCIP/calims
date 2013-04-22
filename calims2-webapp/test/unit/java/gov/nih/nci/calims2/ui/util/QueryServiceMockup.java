/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.util;

import java.util.ArrayList;
import java.util.List;

import gov.nih.nci.calims2.business.report.query.QueryService;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.report.Query;

/**
 * @author connollym
 *
 */
public class QueryServiceMockup extends GenericServiceMockup<Query> implements QueryService {
  
  private Query findByQueryQuery;
  private List<?extends EntityWithId> findByQueryResult;

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public <T extends EntityWithId> List<T> findByQuery(Query query) {
    findByQueryQuery = query;
    findByQueryResult = new ArrayList<T>();
    return (List<T>) findByQueryResult;
  }

  /**
   * @return the findByQueryQuery
   */
  public Query getFindByQueryQuery() {
    return findByQueryQuery;
  }

  /**
   * @return the findByQueryResult
   */
  public List<? extends EntityWithId> getFindByQueryResult() {
    return findByQueryResult;
  }

}
