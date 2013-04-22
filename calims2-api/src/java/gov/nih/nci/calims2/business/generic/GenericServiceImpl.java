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

import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;

import gov.nih.nci.calims2.business.util.validation.ConstraintViolationImpl;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationOperation;
import gov.nih.nci.calims2.business.util.validation.Validator;
import gov.nih.nci.calims2.dao.GenericDao;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * This class implements the GenericService interface and represents a set of methods for operating on GenericBeans.
 * 
 * @author connollym@moxieinformatics.com
 * @param <T> GenericService
 */
public class GenericServiceImpl<T extends EntityWithId> implements GenericService<T> {
  
  private String allowedQueryNamePrefix;
  private CRUDEventListener<T> crudEventListener;
  private GenericDao genericDao;
  private Validator<T> validator;

  /**
   * {@inheritDoc}
   */
  public T createDefault(Class<T> clazz) {
    try {
      T entity = clazz.newInstance();
      entity = crudEventListener.afterCreateDefault(entity);
      return entity;
    } catch (InstantiationException e) {
      throw new InternalError("Cannot happen.");
    } catch (IllegalAccessException e) {
      throw new InternalError("Cannot happen.");
    }
  }

  /**
   * {@inheritDoc}
   */
  public T create(T entity) throws ValidationException {
    validator.validate(entity, ValidationOperation.CREATE);
    T savedEntity = genericDao.create(crudEventListener.beforeCreate(entity));
    crudEventListener.afterCreate(entity, savedEntity);
    return savedEntity;
  }

  /**
   * {@inheritDoc}
   */
  public T copy(T entity) {
    return crudEventListener.beforeCopy(entity);
  }

  /**
   * {@inheritDoc}
   */

  @SuppressWarnings("unchecked")
  public T update(T entity) throws ValidationException {
    validator.validate(entity, ValidationOperation.UPDATE);
    T existingEntity = genericDao.findById((Class<T>) entity.getClass(), entity.getId());
    if (existingEntity == null) {
      ConstraintViolation<T> violation = new ConstraintViolationImpl(entity.getClass(), GenericViolation.ORIGINAL_NOT_FOUND);
      throw new ValidationException(violation);
    }
    T updatedEntity = genericDao.update(crudEventListener.beforeUpdate(entity, existingEntity));
    crudEventListener.afterUpdate(updatedEntity);
    return updatedEntity;
  }

  /**
   * {@inheritDoc}
   */
  public T delete(Class<T> clazz, Long id) throws ValidationException {
    T existingEntity = genericDao.findById(clazz, id);
    if (existingEntity == null) {
      ConstraintViolation<T> violation = new ConstraintViolationImpl<T>(clazz, GenericViolation.ORIGINAL_NOT_FOUND);
      throw new ValidationException(violation);
    }
    validator.validate(existingEntity, ValidationOperation.DELETE);
    crudEventListener.beforeDelete(existingEntity);
    genericDao.delete(existingEntity);
    crudEventListener.afterDelete(existingEntity);
    return existingEntity;
  }

  /**
   * {@inheritDoc}
   */
  public T findById(Class<T> clazz, Long id) {
    return genericDao.findById(clazz, id);
  }

  /**
   * {@inheritDoc}
   */
  public List<T> findAll(Class<T> clazz, String orderByClause) {
    return genericDao.findAll(clazz, orderByClause);
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public T findEntityByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    checkQueryName(queryName);
    return (T) genericDao.findEntityByNamedQuery(queryName, parameterValues);
  }

  /**
   * {@inheritDoc}
   */
  public List<T> findByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    checkQueryName(queryName);
    return genericDao.findByNamedQuery(queryName, parameterValues);
  }

  /**
   * Checks if a queryName is allowed.
   * 
   * @param queryName The queryName to check.
   */
  private void checkQueryName(String queryName) {
    if (queryName == null || !queryName.startsWith(allowedQueryNamePrefix)) {
      throw new IllegalArgumentException("Query not allowed in this service");
    }
  }

  /**
   * @param allowedQueryNamePrefix the allowedQueryNamePrefix to set
   */
  public void setAllowedQueryNamePrefix(String allowedQueryNamePrefix) {
    this.allowedQueryNamePrefix = allowedQueryNamePrefix;
  }

  /**
   * @param crudEventListener the crudEventListener to set
   */
  public void setCrudEventListener(CRUDEventListener<T> crudEventListener) {
    this.crudEventListener = crudEventListener;
  }

  /**
   * @return the genericDao
   */
  protected GenericDao getGenericDao() {
    return genericDao;
  }

  /**
   * @param genericDao the genericDao to set
   */
  public void setGenericDao(GenericDao genericDao) {
    this.genericDao = genericDao;
  }

  /**
   * @param validator the validator to set
   */
  public void setValidator(Validator<T> validator) {
    this.validator = validator;
  }
}