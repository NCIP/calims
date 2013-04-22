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

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.domain.common.Notes;
import gov.nih.nci.calims2.domain.common.enumeration.NotesStatus;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * Base form for the edit view in CRUD used cases.
 * 
 * @author viseem
 * @param <T> The type of Entity processed with the form.
 * 
 */
public class CRUDForm<T extends EntityWithId> implements Serializable {

  private static final long serialVersionUID = -445418445028142814L;
  
  private T entity;
  private boolean editMode;
  private boolean viewMode;
  private String currentView;
  private String returnView;
  private String newNote;
  private String newNoteStatus;

  /**
   * @return the entity
   */
  public T getEntity() {
    return entity;
  }

  /**
   * @param entity the entity to set
   */
  public void setEntity(T entity) {
    this.entity = entity;
  }

  /**
   * @return the editMode
   */
  public boolean isEditMode() {
    return editMode;
  }

  /**
   * @param editMode the editMode to set
   */
  public void setEditMode(boolean editMode) {
    this.editMode = editMode;
  }

  /**
   * @return the viewMode
   */
  public boolean isViewMode() {
    return viewMode;
  }

  /**
   * @param viewMode the viewMode to set
   */
  public void setViewMode(boolean viewMode) {
    this.viewMode = viewMode;
  }

  /**
   * @return the currentView
   */
  public String getCurrentView() {
    return currentView;
  }

  /**
   * @param currentView the currentView to set
   */
  public void setCurrentView(String currentView) {
    this.currentView = currentView;
  }

  /**
   * @return the returnView
   */
  public String getReturnView() {
    return returnView;
  }

  /**
   * @param returnView the returnView to set
   */
  public void setReturnView(String returnView) {
    this.returnView = returnView;
  }

  /**
   * @return the newNote
   */
  public String getNewNote() {
    return newNote;
  }

  /**
   * @param newNote the newNote to set
   */
  public void setNewNote(String newNote) {
    this.newNote = newNote;
  }

  /**
   * @return the newNoteStatus
   */
  public String getNewNoteStatus() {
    return newNoteStatus;
  }

  /**
   * @param newNoteStatus the newNoteStatus to set
   */
  public void setNewNoteStatus(String newNoteStatus) {
    this.newNoteStatus = newNoteStatus;
  }
  
  /**
   * Gets the new notes status as an enumeration.
   * @return The new notes status as an enumeration
   */
  public NotesStatus getCurrentNoteStatus() {
    if (StringUtils.isNotBlank(newNoteStatus)) {
      return NotesStatus.valueOf(newNoteStatus);
    }
    return NotesStatus.DEFAULT;
  }

  /**
   * Returns the submitted entity already prepared for submission to the main service.
   * 
   * @return the submitted entity already prepared for submission to the main service.
   */
  public T getSubmittedEntity() {
    return getEntity();
  }

  /**
   * Check a Boolean value for checkboxes and radio buttons.
   * 
   * @param input The input filed (possibly null)
   * @return The value to set in the submitted entity
   */
  public Boolean checkBoolean(Boolean input) {
    return (input == null) ? Boolean.FALSE : input;
  }
  
  /**
   * Gets the notes input as a Set<Notes> to put in the submittedEntity.
   * @return The notes input as a Set<Notes> to put in the submittedEntity
   */
  public Set<Notes> getNotesCollection() {
    String content = StringUtils.stripToNull(newNote);
    if (content != null) {
      Set<Notes> notes = new HashSet<Notes>();
      Notes note = new Notes();
      note.setContent(content);
      note.setStatus(I18nEnumerationHelper.getByName(NotesStatus.class, newNoteStatus));
      notes.add(note);
      return notes;
    }
    return null;
  }
}
