/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * @author viseem
 *
 */
public class JPAGenericDao extends JpaDaoSupport implements GenericDao {
  
  private static Logger log = LoggerFactory.getLogger(JPAGenericDao.class);
  
  /**
   * {@inheritDoc}
   */
  public <T> T findById(Class<T> clazz, Long id) {
    return getJpaTemplate().getReference(clazz, id);
  }

  /**
   * {@inheritDoc}
   */
  public <T> T create(T entity) {
    getJpaTemplate().persist(entity);
    return entity;
  }
  
  /**
   * {@inheritDoc}
   */
  public <T> T update(T entity) {
    return entity;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T delete(T entity) {
    getJpaTemplate().remove(entity);
    return entity;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public <T> List<T> findAll(Class<T> clazz, String orderByClause) {
    String query = "from " + clazz.getName();
    if (orderByClause != null) {
      query += " order by " + orderByClause;
    }
    return getJpaTemplate().find(query);
  }
  
  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public <T> T findEntityByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    return (T) DataAccessUtils.uniqueResult(findByNamedQuery(queryName, parameterValues));
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public <T> List<T> findByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    log.debug("Executing named query {}", queryName);
    if (parameterValues == null || parameterValues.isEmpty()) {
      return getJpaTemplate().findByNamedQuery(queryName);
    }
    logParameters(parameterValues);
    return getJpaTemplate().findByNamedQueryAndNamedParams(queryName, parameterValues);
  }
  
  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public <T> List<T> findByHQLQuery(String query, Map<String, Object> parameterValues) {
    log.debug("Executing query {}", query);
    if (parameterValues == null || parameterValues.isEmpty()) {
      return getJpaTemplate().find(query);
    }
    logParameters(parameterValues);
    return getJpaTemplate().findByNamedParams(query, parameterValues);
  }
  /**
   * Logs the parameters.
   * @param parameterValues The map of parameter values
   */
  private void logParameters(Map<String, Object> parameterValues) {
    for (Map.Entry<String, Object> entry : parameterValues.entrySet()) {
      log.debug("parameter : {} = {}", new Object[] {entry.getKey(), entry.getValue() });
    }
  }

  /**
   * {@inheritDoc}
   */
  public long getNextValue(String sequenceName) {
    throw new UnsupportedOperationException();
  }

  

}
