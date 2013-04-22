/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.generic.crud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import gov.nih.nci.calims2.domain.common.Notes;
import gov.nih.nci.calims2.domain.common.enumeration.NotesStatus;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;

/**
 * Helper class for testing notes in CRUD forms.
 * 
 * @author viseem
 * 
 */
public class CRUDFormTestHelper {

  private static final String NOTE = "note";
  private static final NotesStatus NOTE_STATUS = NotesStatus.REQUIRED;

  /**
   * Sets the necessary data in the form.
   * 
   * @param form The form to process
   */
  public static void setNotes(CRUDForm<?> form) {
    form.setNewNote(NOTE);
    form.setNewNoteStatus(NOTE_STATUS.name());
  }

  /**
   * test the entity for the form submission of notes.
   * 
   * @param entity The entity to test
   */
  public static void assertNotes(EntityWithNotes entity) {
    Set<Notes> notes = entity.getNotesCollection();
    assertNotNull("No Collection returned", notes);
    assertEquals("Wrong number of notes", 1, notes.size());
    Notes note = notes.iterator().next();
    assertEquals("Wrong note status", NOTE_STATUS, note.getStatus());
    assertEquals("Wrong note content", NOTE, note.getContent());
  }

}
