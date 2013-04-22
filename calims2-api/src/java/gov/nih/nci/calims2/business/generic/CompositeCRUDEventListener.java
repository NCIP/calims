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

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * @author viseem
 * @param <T> The type of Entity being processed.
 */
public class CompositeCRUDEventListener<T extends EntityWithId> extends CRUDEventListenerAdapter<T> {

  private List<CRUDEventListener<T>> listeners;

  /**
   * {@inheritDoc}
   */
  public T afterCreateDefault(T inputEntity) {
    T currentEntity = inputEntity;
    for (CRUDEventListener<T> listener : listeners) {
      currentEntity = listener.afterCreateDefault(currentEntity);
    }
    return currentEntity;
  }

  /**
   * {@inheritDoc}
   */
  public T beforeCreate(T inputEntity) {
    T currentEntity = inputEntity;
    for (CRUDEventListener<T> listener : listeners) {
      currentEntity = listener.beforeCreate(currentEntity);
    }
    return currentEntity;
  }

  /**
   * {@inheritDoc}
   */
  public T beforeCopy(T inputEntity) {
    T currentEntity = inputEntity;
    for (CRUDEventListener<T> listener : listeners) {
      currentEntity = listener.beforeCopy(currentEntity);
    }
    return currentEntity;
  }

  /**
   * {@inheritDoc}
   */
  public void afterCreate(T inputEntity, T savedEntity) {
    for (CRUDEventListener<T> listener : listeners) {
      listener.afterCreate(inputEntity, savedEntity);
    }
  }

  /**
   * {@inheritDoc}
   */
  public T beforeUpdate(T inputEntity, T existingEntity) {
    T currentExistingEntity = existingEntity;
    for (CRUDEventListener<T> listener : listeners) {
      currentExistingEntity = listener.beforeUpdate(inputEntity, currentExistingEntity);
    }
    return currentExistingEntity;
  }

  /**
   * {@inheritDoc}
   */
  public void afterUpdate(T updatedEntity) {
    for (CRUDEventListener<T> listener : listeners) {
      listener.afterUpdate(updatedEntity);
    }
  }

  /**
   * {@inheritDoc}
   */
  public void beforeDelete(T existingEntity) {
    for (CRUDEventListener<T> listener : listeners) {
      listener.beforeDelete(existingEntity);
    }
  }

  /**
   * {@inheritDoc}
   */
  public void afterDelete(T deletedEntity) {
    for (CRUDEventListener<T> listener : listeners) {
      listener.afterDelete(deletedEntity);
    }
  }

  /**
   * @param listeners the listeners to set
   */
  public void setListeners(List<CRUDEventListener<T>> listeners) {
    this.listeners = listeners;
  }

}
