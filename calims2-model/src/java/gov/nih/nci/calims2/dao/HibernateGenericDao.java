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

import org.hibernate.Query;
import org.hibernate.dialect.Dialect;
import org.hibernate.impl.SessionFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * @author connollym@moxieinformatics.com
 */
public class HibernateGenericDao extends HibernateDaoSupport implements GenericDao {

  private static Logger log = LoggerFactory.getLogger(HibernateGenericDao.class);

  /**
   * {@inheritDoc}
   */
  public <T> T findById(Class<T> clazz, Long id) {
    return getHibernateTemplate().load(clazz, id);
  }

  /**
   * {@inheritDoc}
   */
  public <T> T create(T entity) {
    getHibernateTemplate().save(entity);
    return entity;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T update(T entity) {
    getHibernateTemplate().update(entity);
    return entity;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T delete(T entity) {
    getHibernateTemplate().delete(entity);
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
    return getHibernateTemplate().find(query);
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
    log.debug("Executing query {}", queryName);
    if (parameterValues == null || parameterValues.isEmpty()) {
      return getHibernateTemplate().findByNamedQuery(queryName);
    }
    String[] paramNames = new String[parameterValues.size()];
    Object[] paramValues = new Object[parameterValues.size()];
    int i = 0;
    for (Map.Entry<String, Object> entry : parameterValues.entrySet()) {
      paramNames[i] = entry.getKey();
      paramValues[i] = entry.getValue();
      log.debug("parameter {} : {} = {}", new Object[] {i, paramNames[i], paramValues[i] });
      i++;
    }
    return getHibernateTemplate().findByNamedQueryAndNamedParam(queryName, paramNames, paramValues);
  }
  
  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public <T> List<T> findByHQLQuery(String query, Map<String, Object> parameterValues) {
    log.debug("Executing query {}", query);
    if (parameterValues == null || parameterValues.isEmpty()) {
      return getHibernateTemplate().find(query);
    }
    String[] paramNames = new String[parameterValues.size()];
    Object[] paramValues = new Object[parameterValues.size()];
    int i = 0;
    for (Map.Entry<String, Object> entry : parameterValues.entrySet()) {
      paramNames[i] = entry.getKey();
      paramValues[i] = entry.getValue();
      log.debug("parameter {} : {} = {}", new Object[] {i, paramNames[i], paramValues[i] });
      i++;
    }
    return getHibernateTemplate().findByNamedParam(query, paramNames, paramValues);
  }

  /**
   * {@inheritDoc}
   */
  public long getNextValue(String sequenceName) {
    Query query = getSession().createSQLQuery(getDialect().getSequenceNextValString(sequenceName));
    return ((Number) query.uniqueResult()).longValue();
  }

  /**
   * Gets the dialect of the current Session.
   * 
   * @return The Dialect of the current Session
   */
  private Dialect getDialect() {
    SessionFactoryImpl sessionFactory = (SessionFactoryImpl) getSessionFactory();
    return sessionFactory.getDialect();
  }

  
}
