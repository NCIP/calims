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

import java.util.List;
import java.util.Map;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * @author viseem
 * @param <T> The type of entity to process
 */
public class GenericServiceMockupWithData<T extends EntityWithId> implements GenericService<T> {

  private Class<T> findByIdClass;
  private Long findByIdId;
  private T findByIdResult;
  private String findByNamedQueryName;
  private Map<String, Object> findByNamedQueryParams;
  private List<T> findByNamedQueryResult;

  /**
   * {@inheritDoc}
   */
  public T copy(T entity) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public T create(T entity) throws ValidationException {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public T createDefault(Class<T> clazz) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public T delete(Class<T> clazz, Long id) throws ValidationException {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public List<T> findAll(Class<T> clazz, String orderByClause) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public T findById(Class<T> clazz, Long id) {
    findByIdClass = clazz;
    findByIdId = id;
    return findByIdResult;
  }

  /**
   * {@inheritDoc}
   */
  public List<T> findByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    findByNamedQueryName = queryName;
    findByNamedQueryParams = parameterValues;
    return findByNamedQueryResult;
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
  public T update(T entity) throws ValidationException {
    return null;
  }

  /**
   * @return the findByIdResult
   */
  public T getFindByIdResult() {
    return findByIdResult;
  }

  /**
   * @param findByIdResult the findByIdResult to set
   */
  public void setFindByIdResult(T findByIdResult) {
    this.findByIdResult = findByIdResult;
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
   * @return the findByNamedQueryResult
   */
  public List<T> getFindByNamedQueryResult() {
    return findByNamedQueryResult;
  }

  /**
   * @param findByNamedQueryResult the findByNamedQueryResult to set
   */
  public void setFindByNamedQueryResult(List<T> findByNamedQueryResult) {
    this.findByNamedQueryResult = findByNamedQueryResult;
  }

  /**
   * @return the findByNamedQueryName
   */
  public String getFindByNamedQueryName() {
    return findByNamedQueryName;
  }

  /**
   * @return the findByNamedQueryParams
   */
  public Map<String, Object> getFindByNamedQueryParams() {
    return findByNamedQueryParams;
  }
}
