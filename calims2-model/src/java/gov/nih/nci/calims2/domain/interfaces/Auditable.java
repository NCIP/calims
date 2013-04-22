/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.domain.interfaces;

import org.joda.time.DateTime;

/**
 * Interface to be implemented by all the persistent classes that need to be audited.
 * 
 * @author viseem
 *
 */
public interface Auditable extends EntityWithId {
  /**
   * Get the date at which the entity was created.
   * 
   * @return The date at which the entity was created.
   */
  DateTime getDateCreated();

  /**
   * Set the date at which the entity was created.
   * 
   * @param dateCreated The date at which the entity was created.
   * 
   */
  void setDateCreated(DateTime dateCreated);

  /**
   * Get the creator of the entity.
   * 
   * @return The creator of the entity.
   */
  String getCreatedBy();

  /**
   * Set the creator of the entity.
   * 
   * @param createdBy The creator of the entity.
   */
  void setCreatedBy(String createdBy);

  /**
   * Get the date at which the entity was last modified.
   * 
   * @return The date at which the entity was last modified.
   */
  DateTime getDateModified();

  /**
   * Set the date at which the entity was last modified.
   * 
   * @param dateModified The date at which the entity was last modified.
   */
  void setDateModified(DateTime dateModified);

  /**
   * Get the last modifier of the entity.
   * 
   * @return The the last modifier of the entity.
   */
  String getModifiedBy();

  /**
   * Set the last modifier of the entity.
   * 
   * @param modifiedBy The the last modifier of the entity.
   */
  void setModifiedBy(String modifiedBy);
}
