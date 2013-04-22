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
 * Event listener interface for entity CRUD operations.
 * 
 * @author viseem
 * @param <T> The type of Entity being processed.
 * 
 */
public interface CRUDEventListener<T extends EntityWithId> {
  
  /**
   * Event listener called just before default entity creation.
   * 
   * @param inputEntity The default entity to create.
   * @return The default entity to create
   */
  T afterCreateDefault(T inputEntity);
  
  /**
   * Event listener called just before entity creation.
   * 
   * @param inputEntity The entity to create. The provided entity has already been validated when reaching this method
   * @return The entity to create
   */
  T beforeCreate(T inputEntity);

  /**
   * Event listener called just after entity creation.
   * 
   * @param inputEntity The entity to create. The provided entity has already been validated when reaching this method
   * @param savedEntity The entity just saved
   */
  void afterCreate(T inputEntity, T savedEntity);
  
  /**
   * Event listener called just before entity copy.
   * 
   * @param inputEntity The entity being copied.
   * @return The entity being copied.
   */
  T beforeCopy(T inputEntity);

  /**
   * Event listener called just before entity update.
   * 
   * @param inputEntity The entity to update. The provided entity has already been validated when reaching this method
   * @param existingEntity The entity that already exist in the database.
   * @return The entity to update
   */
  T beforeUpdate(T inputEntity, T existingEntity);

  /**
   * Event listener called just after entity update.
   * 
   * @param updatedEntity The entity just updated
   */
  void afterUpdate(T updatedEntity);

  /**
   * Event listener called just before entity deletion.
   * 
   * @param existingEntity The entity to delete. The provided entity has already been validated when reaching this method
   */
  void beforeDelete(T existingEntity);

  /**
   * Event listener called just after entity deletion.
   * 
   * @param deletedEntity The entity just deleted
   */
  void afterDelete(T deletedEntity);
}
