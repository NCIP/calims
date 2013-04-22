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

import java.util.Comparator;

import gov.nih.nci.calims2.domain.common.Notes;

/**
 * Comparator that sort notes according to their creation timestamps.
 * 
 * @author viseem
 *
 */
public class NotesComparator implements Comparator<Notes> {

  /**
   * {@inheritDoc}
   */
  public int compare(Notes note1, Notes note2) {
    return note1.getDateCreated().compareTo(note2.getDateCreated());
  }

}
