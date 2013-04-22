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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.common.Notes;
import gov.nih.nci.calims2.domain.common.enumeration.NotesStatus;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * Helper class for entity with notes controllers.
 * 
 * @author viseem
 * 
 */
public class NotesHelper {
  /**
   * Adds the notes collection to the details model.
   * 
   * @param model The model
   * @param <T> The type of Entity processed.
   */
  @SuppressWarnings("unchecked")
  public <T extends EntityWithNotes> void completeDetailsModel(ModelAndView model) {
    CRUDForm<T> form = (CRUDForm<T>) model.getModel().get("form");
    List<Notes> notes = new ArrayList<Notes>(form.getEntity().getNotesCollection());
    Collections.sort(notes, Collections.reverseOrder(new NotesComparator()));
    model.addObject("notes", notes);
  }

  /**
   * Adds the notes collection and statuses to the edit model.
   * 
   * @param model The model
   * @param locale The current Locale
   * @param service The main service
   * @param persistentClass The persistent class
   * @param <T> The type of Entity processed.
   */
  @SuppressWarnings("unchecked")
  public <T extends EntityWithNotes> void completeEditModel(ModelAndView model, Locale locale, GenericService<T> service,
      Class<T> persistentClass) {
    CRUDForm<T> form = (CRUDForm<T>) model.getModel().get("form");
    if (form.isEditMode()) {
      EntityWithNotes entity = service.findById(persistentClass, form.getEntity().getId());
      List<Notes> notes = new ArrayList<Notes>(entity.getNotesCollection());
      Collections.sort(notes, Collections.reverseOrder(new NotesComparator()));
      model.addObject("notes", notes);
    }
    model.addObject("noteStatuses", I18nEnumerationHelper.getLocalizedValues(NotesStatus.class, locale));
  }
}
