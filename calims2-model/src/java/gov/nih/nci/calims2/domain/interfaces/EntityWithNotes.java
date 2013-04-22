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

import java.util.Set;

import gov.nih.nci.calims2.domain.common.Notes;

/**
 * @author viseem
 * 
 */
public interface EntityWithNotes extends EntityWithId {
  /**
   * Gets the collection of notes.
   * 
   * @return The collection of notes.
   */
  Set<Notes> getNotesCollection();

  /**
   * Sets the collection of notes.
   * 
   * @param notesCollection The collection of notes
   */
  void setNotesCollection(Set<Notes> notesCollection);

}
