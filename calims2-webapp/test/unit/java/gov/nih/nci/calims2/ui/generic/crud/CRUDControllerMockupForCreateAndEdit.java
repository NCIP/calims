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

import java.util.Locale;

import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * @author viseem
 * @param <T> The type of persistent entity processed.
 * 
 */
public class CRUDControllerMockupForCreateAndEdit<T extends EntityWithId> extends CRUDController<T> {
  private T entityToEdit;
  private String currentView;
  private ModelAndView editModel;

  /**
   * @param urlPrefix the url prefix
   * @param viewPrefix the view prefix
   * @param pClass the persistent class to process
   * @param fClass the form class
   */
  public CRUDControllerMockupForCreateAndEdit(String urlPrefix, String viewPrefix, Class<T> pClass,
      Class<? extends CRUDForm<T>> fClass) {
    CRUDControllerConfig config = getConfig();
    config.setUrlAndViewPrefixes(urlPrefix);
    setPersistentClass(pClass);
    setFormClass(fClass);
    config.setViewPrefix(viewPrefix);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView createEditModel(T entity, String view, Locale locale) {
    entityToEdit = entity;
    currentView = view;
    editModel = new ModelAndView();
    return editModel;
  }

  /**
   * @return the entityToEdit
   */
  public T getEntityToEdit() {
    return entityToEdit;
  }

  /**
   * @return the currentView
   */
  public String getCurrentView() {
    return currentView;
  }

  /**
   * @return the editModel
   */
  public ModelAndView getEditModel() {
    return editModel;
  }
 
}
