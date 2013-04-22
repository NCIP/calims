/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.unit;

import java.util.List;
import java.util.Map;

import gov.nih.nci.calims2.dao.GenericDao;
import gov.nih.nci.calims2.domain.administration.StandardUnit;

/**
 * @author viseem
 * 
 */
public class UnitDaoMockup implements GenericDao {
  private String queryName;
  private Map<String, Object> parameterValues;
  private List<StandardUnit> result;

  /**
   * {@inheritDoc}
   */
  public <T> T create(T entity) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T delete(T entity) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T> List<T> findAll(Class<T> clazz, String orderByClause) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T findById(Class<T> clazz, Long id) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public <T> List<T> findByNamedQuery(String query, Map<String, Object> params) {
    queryName = query;
    parameterValues = params;
    return (List<T>) result;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T findEntityByNamedQuery(String query, Map<String, Object> params) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T update(T entity) {
    return null;
  }

  /**
   * @param result the result to set
   */
  public void setResult(List<StandardUnit> result) {
    this.result = result;
  }

  /**
   * @return the queryName
   */
  protected String getQueryName() {
    return queryName;
  }

  /**
   * @return the parameterValues
   */
  protected Map<String, Object> getParameterValues() {
    return parameterValues;
  }

  /**
   * {@inheritDoc}
   */
  public long getNextValue(String sequenceName) {
    return 0;
  }

  /**
   * {@inheritDoc}
   */
  public <T> List<T> findByHQLQuery(String query, Map<String, Object> parameters) {
    return null;
  }

}
