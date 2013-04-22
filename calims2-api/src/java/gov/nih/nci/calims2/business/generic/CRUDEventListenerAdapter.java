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

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * Empty implementation of CRUDEventListener. To be used as a super class for non empty implementations.
 * 
 * @author viseem
 * 
 * @param <T> The type of Entity being processed.
 */
public class CRUDEventListenerAdapter<T extends EntityWithId> implements CRUDEventListener<T> {

  /**
   * {@inheritDoc}
   */
  public T afterCreateDefault(T inputEntity) {
    return inputEntity;
  }

  /**
   * {@inheritDoc}
   */
  public T beforeCreate(T inputEntity) {
    return inputEntity;
  }

  /**
   * {@inheritDoc}
   */
  public void afterCreate(T inputEntity, T savedEntity) {
    // Nothing to do by default
  }

  /**
   * {@inheritDoc}
   */
  public T beforeCopy(T inputEntity) {
    return inputEntity;
  }

  /**
   * {@inheritDoc}
   */
  public T beforeUpdate(T inputEntity, T existingEntity) {
    return existingEntity;
  }

  /**
   * {@inheritDoc}
   */
  public void afterUpdate(T updatedEntity) {
    // Nothing to do by default
  }

  /**
   * {@inheritDoc}
   */
  public void beforeDelete(T existingEntity) {
    // Nothing to do by default
  }

  /**
   * {@inheritDoc}
   */
  public void afterDelete(T deletedEntity) {
    // Nothing to do by default
  }

}
