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
import java.util.Map;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * @author connollym
 * @param <T> The type of entity to process
 * 
 */
public class GenericServiceMockup<T extends EntityWithId> implements GenericService<T> {
  
  private boolean throwsExceptions;

  private Class<T> createDefaultClass;
  private T createDefaultResult;
  private T createResult;
  private T updateResult;
  private Class<T> deleteClass;
  private Long deleteId;
  private T deleteResult;
  private Class<T> findByIdClass;
  private Long findByIdId;
  private T findByIdResult;
  private Class<T> findAllClass;
  private String findAllOrderByClause;
  private List<T> findAllResult;
  
  
  private String findByQueryName;
  private Map<String, Object> findByQueryNameParameterValues;
  private List<T> findByQueryNameResult;
  
  private T relatedEntity;
  
  /**
   * {@inheritDoc}
   */
  public T createDefault(Class<T> clazz) {
    createDefaultClass = clazz;
    createDefaultResult = createEntityWithId(clazz);
    return createDefaultResult;
  }
  
  /**
   * {@inheritDoc}
   */
  public T copy(T entity)  {
    createResult = entity;
    return createResult;
  }
  
  /**
   * {@inheritDoc}
   */
  public T create(T entity) throws ValidationException {
    createResult = entity;
    if (throwsExceptions) {
      throw new ValidationException();
    }
    return createResult;
  }

  /**
   * {@inheritDoc}
   */
  public T update(T entity) throws ValidationException {
    updateResult = entity;
    if (throwsExceptions) {
      throw new ValidationException();
    }
    return updateResult;
  }
  
  /**
   * {@inheritDoc}
   */
  public T delete(Class<T> clazz, Long id) throws ValidationException {
    deleteClass = clazz;
    deleteId = id;
    if (throwsExceptions) {
      throw new ValidationException();
    }
    return deleteResult;
  }
  
  /**
   * {@inheritDoc}
   */
  public T findById(Class<T> clazz, Long id) {
    findByIdClass = clazz;
    findByIdId = id;
    findByIdResult = createEntityWithId(clazz);
    findByIdResult.setId(id);
    return findByIdResult;
  }

  /**
   * {@inheritDoc}
   */
  public List<T> findAll(Class<T> clazz, String orderBy) {
    findAllClass = clazz;
    findAllOrderByClause = orderBy;
    findAllResult = new ArrayList<T>();
    //findAllResult.add(createEntityWithId(clazz));
    return findAllResult;
  }

  /**
   * {@inheritDoc}
   */
  public T findEntityByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public List<T> findByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    findByQueryName = queryName;
    findByQueryNameParameterValues = parameterValues;
    
    findByQueryNameResult = new ArrayList<T>();
    if (queryName.equals("gov.nih.nci.calims2.domain.administration.Organization.findByName")) {
      try {
        relatedEntity = (T) Organization.class.newInstance();
        findByQueryNameResult.add(relatedEntity);
      } catch (InstantiationException e) {
        throw new InternalError("Cannot happen - EntityWithId classes have a public contructor");
      } catch (IllegalAccessException e) {
        throw new InternalError("Cannot happen - EntityWithId classes have a public contructor");
      }
    }
    return findByQueryNameResult;
  }

  /**
   * @param throwsExceptions the throwsExceptions to set
   */
  public void setThrowsExceptions(boolean throwsExceptions) {
    this.throwsExceptions = throwsExceptions;
  }

  /**
   * @return the createDefaultClass
   */
  public Class<T> getCreateDefaultClass() {
    return createDefaultClass;
  }

  /**
   * @return the createDefaultResult
   */
  public T getCreateDefaultResult() {
    return createDefaultResult;
  }

  /**
   * @return the createResult
   */
  public T getCreateResult() {
    return createResult;
  }

  /**
   * @return the updateResult
   */
  public T getUpdateResult() {
    return updateResult;
  }
  
  /**
   * @return the deleteClass
   */
  public Class<T> getDeleteClass() {
    return deleteClass;
  }

  /**
   * @return the deleteId
   */
  public Long getDeleteId() {
    return deleteId;
  }
  
  /**
   * @return the deleteResult
   */
  public T getDeleteResult() {
    return deleteResult;
  }

  /**
   * @param deleteResult the deleteResult to set
   */
  public void setDeleteResult(T deleteResult) {
    this.deleteResult = deleteResult;
  }
  
  /**
   * @return the findByIdClass
   */
  public Class<T> getFindByIdClass() {
    return findByIdClass;
  }
  
  /**
   * @return the findByIdId
   */
  public Long getFindByIdId() {
    return findByIdId;
  }

  /**
   * @return the findByIdResult
   */
  public T getFindByIdResult() {
    return findByIdResult;
  }

  /**
   * @return the findAllClass
   */
  public Class<T> getFindAllClass() {
    return findAllClass;
  }

  /**
   * @return the findAllOrderByClause
   */
  public String getFindAllOrderByClause() {
    return findAllOrderByClause;
  }

  /**
   * @return the findAllResult
   */
  public List<T> getFindAllResult() {
    return findAllResult;
  }
  

  /**
   * @return the relatedEntity
   */
  public T getRelatedEntity() {
    return relatedEntity;
  }

  private T createEntityWithId(Class<T> clazz) {
    try {
      T result = clazz.newInstance();
      result.setId(1L);
      return result;
    } catch (InstantiationException e) {
      throw new InternalError("Cannot happen - EntityWithId classes have a public contructor");
    } catch (IllegalAccessException e) {
      throw new InternalError("Cannot happen - EntityWithId classes have a public contructor");
    }
  }

  /**
   * @return the findByQueryName
   */
  public String getFindByQueryName() {
    return findByQueryName;
  }

  /**
   * @return the findByQueryNameParameterValues
   */
  public Map<String, Object> getFindByQueryNameParameterValues() {
    return findByQueryNameParameterValues;
  }

  /**
   * @return the findByQueryNameResult
   */
  public List<T> getFindByQueryNameResult() {
    return findByQueryNameResult;
  }
  
}
