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
 *@param <T> The type of persistent entity processed.
 * 
 */
public class CRUDControllerMockupForSubFlow<T extends EntityWithId> extends CRUDControllerMockupForCreateAndEdit<T> {

  private ModelAndView doReturnModel;
  private int doReturnSubFlowId;
  private Long doReturnEntityId;
  private boolean doReturnCalled;
  private String listReturnView;
  private Long listQueryId;
  private Locale listLocale;
  private ModelAndView listModel;

  /**
   * @param urlPrefix the url prefix
   * @param viewPrefix the view prefix
   * @param pClass the persistent class to process
   * @param fClass the form class
   */
  public CRUDControllerMockupForSubFlow(String urlPrefix, String viewPrefix, Class<T> pClass,
      Class<? extends CRUDForm<T>> fClass) {
    super(urlPrefix, viewPrefix, pClass, fClass);
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    doReturnCalled = true;
    doReturnModel = model;
    doReturnSubFlowId = subFlowId;
    doReturnEntityId = entityId;
  }
  
  /**
   * {@inheritDoc}
   */
  public ModelAndView list(String returnView, Long queryId, Locale locale) {
    listReturnView = returnView;
    listQueryId = queryId;
    listLocale = locale;
    listModel = new ModelAndView();
    return listModel;
  }

  /**
   * @return the doReturnModel
   */
  public ModelAndView getDoReturnModel() {
    return doReturnModel;
  }

  /**
   * @return the doReturnSubFlowId
   */
  public int getDoReturnSubFlowId() {
    return doReturnSubFlowId;
  }

  /**
   * @return the doReturnEntityId
   */
  public Long getDoReturnEntityId() {
    return doReturnEntityId;
  }

  /**
   * @return the doReturnCalled
   */
  public boolean isDoReturnCalled() {
    return doReturnCalled;
  }

  /**
   * @return the listReturnView
   */
  public String getListReturnView() {
    return listReturnView;
  }

  /**
   * @return the listLocale
   */
  public Locale getListLocale() {
    return listLocale;
  }

  /**
   * @return the listModel
   */
  public ModelAndView getListModel() {
    return listModel;
  }

  /**
   * @return the listQueryId
   */
  public Long getListQueryId() {
    return listQueryId;
  }
}
