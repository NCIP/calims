/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import gov.nih.nci.calims2.dao.GenericDao;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * @author connollym@moxieinformatics.com
 */
public class DaoMockup implements GenericDao {

  private boolean returnObject;
  private Object entityFoundById;
  private EntityWithId entityFoundByQuery;
  private Class<?> findAllClass;
  private String orderByClause;
  private String queryName;
  private Map<String, Object> parameterValues;
  private List<EntityWithId> queryResult;

  /**
   * {@inheritDoc}
   */
  public <T> T create(T entity) {
    T entityToSave = null;
    if (returnObject) {
      entityToSave = entity;
    }
    return entityToSave;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T update(T entity) {
    T entityToUpdate = null;
    if (returnObject) {
      entityToUpdate = entity;
    }
    return entityToUpdate;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T delete(T entity) {
    T entityToDelete = null;
    if (returnObject) {
      entityToDelete = entity;
    }
    return entityToDelete;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T findById(Class<T> clazz, Long id) {
    T entity = null;
    if (returnObject) {
      try {
        entity = clazz.newInstance();
      } catch (InstantiationException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
      if (entity instanceof EntityWithId) {
        ((EntityWithId) entity).setId(id);
      }
      setEntityFoundById(entity);
    }
    return entity;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public <T> List<T> findAll(Class<T> clazz, String orderBy) {
    findAllClass = clazz;
    orderByClause = orderBy;
    queryResult = new ArrayList<EntityWithId>();
    return (List<T>) queryResult;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public <T> T findEntityByNamedQuery(String name, Map<String, Object> parameters) {
    findByNamedQuery(name, parameters);
    return (T) entityFoundByQuery;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public <T> List<T> findByNamedQuery(String name, Map<String, Object> parameters) {
    queryName = name;
    parameterValues = parameters;
    queryResult = new ArrayList<EntityWithId>();
    return (List<T>) queryResult;
  }

  /**
   * @return returnOject true if findById must return an object
   */
  public boolean isReturnOject() {
    return returnObject;
  }

  /**
   * @param returnOject true if findById must return an object
   */
  public void setReturnOject(boolean returnOject) {
    this.returnObject = returnOject;
  }

  /**
   * @return the entityFoundById
   */
  public Object getEntityFoundById() {
    return entityFoundById;
  }

  /**
   * @param entityFoundById the entityFoundById to set
   */
  public void setEntityFoundById(Object entityFoundById) {
    this.entityFoundById = entityFoundById;
  }

  /**
   * @return the entityFoundByQuery
   */
  public EntityWithId getEntityFoundByQuery() {
    return entityFoundByQuery;
  }

  /**
   * @param entityFoundByQuery the entityFoundByQuery to set
   */
  public void setEntityFoundByQuery(EntityWithId entityFoundByQuery) {
    this.entityFoundByQuery = entityFoundByQuery;
  }

  /**
   * @return the findAllClass
   */
  public Class<?> getFindAllClass() {
    return findAllClass;
  }

  /**
   * @return the orderByClause
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * @return the queryName
   */
  public String getQueryName() {
    return queryName;
  }

  /**
   * @return the parameterValues
   */
  public Map<String, Object> getParameterValues() {
    return parameterValues;
  }

  /**
   * @return the queryResult
   */
  public List<EntityWithId> getQueryResult() {
    return queryResult;
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
