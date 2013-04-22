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

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import gov.nih.nci.calims2.domain.common.Notes;
import gov.nih.nci.calims2.domain.interfaces.Auditable;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;

/**
 * Crud event listener for Auditable classes with notes.
 * 
 * On creation or update, it allows to add one note to the collection of notes.
 * 
 * @author viseem
 * @param <T> The type of Entity being processed.
 * 
 */
public class NotesCRUDEventListener<T extends Auditable & EntityWithNotes> extends AuditableCRUDEventListener<T> {
  private static final String[] DEFAULT_EXCLUDED_PROPERTIES = new String[] {"notesCollection" };

  /**
   * Default constructor.
   */
  public NotesCRUDEventListener() {
    setAdditionalExcludedProperties(DEFAULT_EXCLUDED_PROPERTIES);
  }
  
  private Notes copyNote(Notes note, DateTime dateCreated, String userName) {
    Notes newNote = new Notes();
    newNote.setContent(note.getContent());
    newNote.setCreatedBy(userName);
    newNote.setDateCreated(dateCreated);
    newNote.setStatus(note.getStatus());
    return newNote;
  }

  /**
   * {@inheritDoc}
   */
  public T beforeCreate(T inputEntity) {
    T entity = super.beforeCreate(inputEntity);
    if (inputEntity.getNotesCollection() != null && !inputEntity.getNotesCollection().isEmpty()) {
      Set<Notes> notes = new HashSet<Notes>();
      DateTime dateCreated = new DateTime();
      String userName = getPrivilegeEvaluator().getCurrentUsername();
      for (Notes note : inputEntity.getNotesCollection()) {
        notes.add(copyNote(note, dateCreated, userName));
      }
      entity.setNotesCollection(notes);
    }
    return entity;
  }

  /**
   * {@inheritDoc}
   */
  public T beforeUpdate(T inputEntity, T existingEntity) {
    T entity = super.beforeUpdate(inputEntity, existingEntity);
    if (inputEntity.getNotesCollection() != null && !inputEntity.getNotesCollection().isEmpty()) {
      Set<Notes> existingNotes = existingEntity.getNotesCollection();
      DateTime dateCreated = new DateTime();
      String userName = getPrivilegeEvaluator().getCurrentUsername();
      for (Notes note : inputEntity.getNotesCollection()) {
        existingNotes.add(copyNote(note, dateCreated, userName));
      }
    }
    return entity;
  }
}
