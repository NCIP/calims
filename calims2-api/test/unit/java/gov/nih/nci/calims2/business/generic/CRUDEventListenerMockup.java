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
 * @author viseem
 * @param <T> The type of entity processed
 * 
 */
public class CRUDEventListenerMockup<T extends EntityWithId> extends NullCRUDEventListener<T> {

  private T inputEntity;
  private T existingEntity;
  private T createDefaultResult;
  private T createResult;
  private T copyResult;
  private T updateResult;
  private T afterCreateDefaultEntity;
  private T afterCreateEntity;
  private T afterUpdateEntity;
  private T afterDeleteEntity;
  
  /**
   * {@inheritDoc}
   */
  public T afterCreateDefault(T input) {
    afterCreateDefaultEntity = input;
    createDefaultResult = super.afterCreateDefault(input);
    return createDefaultResult;
  }

  /**
   * {@inheritDoc}
   */
  public T beforeCreate(T input) {
    inputEntity = input;
    createResult = super.beforeCreate(input);
    return createResult;
  }
  
  /**
   * {@inheritDoc}
   */
  public T beforeCopy(T input) {
    inputEntity = input;
    copyResult = super.beforeCopy(input);
    return copyResult;
  }
  
  /**
   * {@inheritDoc}
   */
  public void afterCreate(T input, T savedEntity) {
    afterCreateEntity = savedEntity;
    super.afterCreate(inputEntity, savedEntity);
  }

  /**
   * {@inheritDoc}
   */
  public T beforeUpdate(T input, T existing) {
    inputEntity = input;
    existingEntity = existing;
    updateResult = super.beforeUpdate(input, existing);
    return updateResult;
  }
  
  /**
   * {@inheritDoc}
   */
  public void afterUpdate(T updatedEntity) {
    afterUpdateEntity = updatedEntity;
    super.afterUpdate(updatedEntity);
  }
  
  /**
   * {@inheritDoc}
   */
  public void beforeDelete(T existing) {
    existingEntity = existing;
    super.beforeDelete(existing);
  }
  
  /**
   * {@inheritDoc}
   */
  public void afterDelete(T deletedEntity) {
    afterDeleteEntity = deletedEntity;
    super.afterDelete(deletedEntity);
  }

  /**
   * @return the inputEntity
   */
  public T getInputEntity() {
    return inputEntity;
  }

  /**
   * @return the existingEntity
   */
  public T getExistingEntity() {
    return existingEntity;
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
   * @return the copyResult
   */
  public T getCopyResult() {
    return copyResult;
  }

  /**
   * @return the updateResult
   */
  public T getUpdateResult() {
    return updateResult;
  }

  /**
   * @return the afterCreateDefaultEntity
   */
  public T getAfterCreateDefaultEntity() {
    return afterCreateDefaultEntity;
  }

  /**
   * @return the afterCreateEntity
   */
  public T getAfterCreateEntity() {
    return afterCreateEntity;
  }

  /**
   * @return the afterUpdateEntity
   */
  public T getAfterUpdateEntity() {
    return afterUpdateEntity;
  }

  /**
   * @return the afterDeleteEntity
   */
  public T getAfterDeleteEntity() {
    return afterDeleteEntity;
  }
}
