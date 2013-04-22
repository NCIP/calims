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
import static org.junit.Assert.assertNull;

import java.util.Set;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.common.Notes;
import gov.nih.nci.calims2.domain.common.enumeration.NotesStatus;

/**
 * @author viseem
 * 
 */
public class CRUDFormTest {
  /**
   * test the checkBoolean for null input.
   */
  @Test
  public void testCheckBooleanNull() {
    testCheckBoolean(null, false);
  }

  /**
   * test the checkBoolean for false input.
   */
  @Test
  public void testCheckBooleanFalse() {
    testCheckBoolean(false, false);
  }

  /**
   * test the checkBoolean for true input.
   */
  @Test
  public void testCheckBooleanTrue() {
    testCheckBoolean(true, true);
  }

  private void testCheckBoolean(Boolean input, Boolean expected) {
    CRUDForm<Person> form = new CRUDForm<Person>();
    Boolean result = form.checkBoolean(input);
    assertNotNull("No result returned", result);
    assertEquals("Wrong result returned", expected, result);
  }

  /**
   * test the getCurrentNoteStatus for a given input.
   */
  @Test
  public void testGetCurrentNoteStatusInput() {
    testGetCurrentNoteStatus(NotesStatus.REQUIRED.name(), NotesStatus.REQUIRED);
  }

  /**
   * test the getCurrentNoteStatus for no input.
   */
  @Test
  public void testGetCurrentNoteStatusNull() {
    testGetCurrentNoteStatus(null, NotesStatus.DEFAULT);
  }

  private void testGetCurrentNoteStatus(String input, NotesStatus expected) {
    CRUDForm<Person> form = new CRUDForm<Person>();
    form.setNewNoteStatus(input);
    NotesStatus result = form.getCurrentNoteStatus();
    assertNotNull("No result returned", result);
    assertEquals("Wrong result returned", expected, result);
  }

  /**
   * test the getNotesCollection method with no note.
   */
  @Test
  public void testGetNotesCollectionNoNote() {
    CRUDForm<Person> form = new CRUDForm<Person>();
    Set<Notes> result = form.getNotesCollection();
    assertNull("Wrong result returned", result);
  }

  /**
   * test the getNotesCollection method with one note.
   */
  @Test
  public void testGetNotesCollection() {
    CRUDForm<Person> form = new CRUDForm<Person>();
    form.setNewNoteStatus("REQUIRED");
    form.setNewNote("note");
    Set<Notes> result = form.getNotesCollection();
    assertNotNull("Wrong result returned", result);
    assertEquals("Wrong size of the result", 1, result.size());
    Notes note = result.iterator().next();
    assertEquals("Wrong note status", NotesStatus.REQUIRED, note.getStatus());
    assertEquals("Wrong note content", "note", note.getContent());
  }

}
