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

import java.util.List;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.report.Query;

/**
 * @author viseem
 *
 */
public interface QueryService extends GenericService<Query> {
  /**
   * Executes the given query.
   * @param <T> The type of entity returned
   * @param query The query to execute
   * @return The List of objects returned by the query
   */
  <T extends EntityWithId> List<T> findByQuery(Query query);
}
