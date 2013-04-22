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
import java.util.Map;

import gov.nih.nci.calims2.business.generic.GenericServiceImpl;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.report.Query;

/**
 * @author viseem
 * 
 */
public class QueryServiceImpl extends GenericServiceImpl<Query> implements QueryService {
  
  private MetadataService metadataService;

  /**
   * {@inheritDoc}
   */
  
  
  public <T extends EntityWithId> List<T> findByQuery(Query query) {
    EntityDescriptor descriptor;
    try {
      descriptor = metadataService.getEntityDescriptor(Class.forName(query.getMainEntity()));
    } catch (ClassNotFoundException e) {
      throw new IllegalArgumentException("Persistent class not found", e);
    }
    HQLQueryBuilder queryBuilder = new HQLQueryBuilder(query, descriptor);
    String queryString = queryBuilder.getHQLQuery();
    Map<String, Object> parameters = queryBuilder.getParameters();
    return getGenericDao().findByHQLQuery(queryString, parameters);
  }

  /**
   * @param metadataService the metadataService to set
   */
  public void setMetadataService(MetadataService metadataService) {
    this.metadataService = metadataService;
  }

}
