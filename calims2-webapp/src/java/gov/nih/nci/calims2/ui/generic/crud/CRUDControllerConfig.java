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

/**
 * @author viseem
 * 
 */
public class CRUDControllerConfig {
  /** Prefix for redirect urls. */
  public static final String REDIRECT_PREFIX = "redirect:";
  /** standard cancel save command. */
  public static final String STD_CANCEL_SAVE_COMMAND = "/cancelSave.do";
  /** standard call subflow command. */
  public static final String STD_CALL_COMMAND = "/call.do";
  /** standard call subflow from list command. */
  public static final String STD_CALL_FROM_LIST_COMMAND = "/callFromList.do";
  /** standard copy command. */
  public static final String STD_COPY_COMMAND = "/copy.do";
  /** standard create command. */
  public static final String STD_CREATE_COMMAND = "/create.do";
  /** standard delete command. */
  public static final String STD_DELETE_COMMAND = "/delete.do";
  /** standard details command. */
  public static final String STD_DETAILS_COMMAND = "/details.do";
  /** standard edit command. */
  public static final String STD_EDIT_COMMAND = "/edit.do";
  /** standard list command. */
  public static final String STD_LIST_COMMAND = "/list.do";
  /** standard manage command. */
  public static final String STD_MANAGE_COMMAND = "/manage.do";
  /** standard return from subflow command. */
  public static final String STD_RETURN_COMMAND = "/return.do";
  /** standard return from subflow command. */
  public static final String STD_RETURN_GENERIC_COMMAND = "/genericReturn.do";
  /** standard save command. */
  public static final String STD_SAVE_COMMAND = "/save.do";

  /** standard details view name. */
  public static final String STD_DETAILS_VIEW = "detailsstandard";
  /** standard edit view name. */
  public static final String STD_EDIT_VIEW = "editstandard";
  /** standard list view name. */
  public static final String STD_LIST_VIEW = "liststandard";
  /** standard manage view name. */
  public static final String STD_MANAGE_VIEW = "managestandard";

  private String callCommand = STD_CALL_COMMAND;
  private String callFromListCommand = STD_CALL_FROM_LIST_COMMAND;
  private String cancelSaveCommand = STD_CANCEL_SAVE_COMMAND;
  private String copyCommand = STD_COPY_COMMAND;
  private String createCommand = STD_CREATE_COMMAND;
  private String deleteCommand = STD_DELETE_COMMAND;
  private String detailsCommand = STD_DETAILS_COMMAND;
  private String editCommand = STD_EDIT_COMMAND;
  private String listCommand = STD_LIST_COMMAND;
  private String manageCommand = STD_MANAGE_COMMAND;
  private String returnCommand = STD_RETURN_COMMAND;
  private String returnGenericCommand = STD_RETURN_GENERIC_COMMAND;
  private String saveCommand = STD_SAVE_COMMAND;
  private String detailsView = STD_DETAILS_VIEW;
  private String editView = STD_EDIT_VIEW;
  private String listView = STD_LIST_VIEW;
  private String manageView = STD_MANAGE_VIEW;
  private String urlPrefix;
  private String viewPrefix;
  private String orderByClause;
  private String[] subFlowUrls;
  private boolean advancedSearch;

  /**
   * @return the callCommand
   */
  public String getCallCommand() {
    return callCommand;
  }

  /**
   * @param callCommand the callCommand to set
   */
  public void setCallCommand(String callCommand) {
    this.callCommand = callCommand;
  }

  /**
   * @return the callFromListCommand
   */
  public String getCallFromListCommand() {
    return callFromListCommand;
  }

  /**
   * @param callFromListCommand the callFromListCommand to set
   */
  public void setCallFromListCommand(String callFromListCommand) {
    this.callFromListCommand = callFromListCommand;
  }

  /**
   * @return the cancelSaveCommand
   */
  public String getCancelSaveCommand() {
    return cancelSaveCommand;
  }

  /**
   * @param cancelSaveCommand the cancelSaveCommand to set
   */
  public void setCancelSaveCommand(String cancelSaveCommand) {
    this.cancelSaveCommand = cancelSaveCommand;
  }

  /**
   * @return the copyCommand
   */
  public String getCopyCommand() {
    return copyCommand;
  }

  /**
   * @param copyCommand the copyCommand to set
   */
  public void setCopyCommand(String copyCommand) {
    this.copyCommand = copyCommand;
  }

  /**
   * @return the createCommand
   */
  public String getCreateCommand() {
    return createCommand;
  }

  /**
   * @param createCommand the createCommand to set
   */
  public void setCreateCommand(String createCommand) {
    this.createCommand = createCommand;
  }

  /**
   * @return the deleteCommand
   */
  public String getDeleteCommand() {
    return deleteCommand;
  }

  /**
   * @param deleteCommand the deleteCommand to set
   */
  public void setDeleteCommand(String deleteCommand) {
    this.deleteCommand = deleteCommand;
  }

  /**
   * @return the detailsCommand
   */
  public String getDetailsCommand() {
    return detailsCommand;
  }

  /**
   * @param detailsCommand the detailsCommand to set
   */
  public void setDetailsCommand(String detailsCommand) {
    this.detailsCommand = detailsCommand;
  }

  /**
   * @return the editCommand
   */
  public String getEditCommand() {
    return editCommand;
  }

  /**
   * @param editCommand the editCommand to set
   */
  public void setEditCommand(String editCommand) {
    this.editCommand = editCommand;
  }

  /**
   * @return the listCommand
   */
  public String getListCommand() {
    return listCommand;
  }

  /**
   * @param listCommand the listCommand to set
   */
  public void setListCommand(String listCommand) {
    this.listCommand = listCommand;
  }

  /**
   * @return the manageCommand
   */
  public String getManageCommand() {
    return manageCommand;
  }

  /**
   * @param manageCommand the manageCommand to set
   */
  public void setManageCommand(String manageCommand) {
    this.manageCommand = manageCommand;
  }

  /**
   * @return the returnCommand
   */
  public String getReturnCommand() {
    return returnCommand;
  }

  /**
   * @param returnCommand the returnCommand to set
   */
  public void setReturnCommand(String returnCommand) {
    this.returnCommand = returnCommand;
  }

  /**
   * @return the returnGenericCommand
   */
  public String getReturnGenericCommand() {
    return returnGenericCommand;
  }

  /**
   * @param returnGenericCommand the returnGenericCommand to set
   */
  public void setReturnGenericCommand(String returnGenericCommand) {
    this.returnGenericCommand = returnGenericCommand;
  }

  /**
   * @return the saveCommand
   */
  public String getSaveCommand() {
    return saveCommand;
  }

  /**
   * @param saveCommand the saveCommand to set
   */
  public void setSaveCommand(String saveCommand) {
    this.saveCommand = saveCommand;
  }

  /**
   * @return the detailsView
   */
  public String getDetailsView() {
    return detailsView;
  }

  /**
   * @param detailsView the detailsView to set
   */
  public void setDetailsView(String detailsView) {
    this.detailsView = detailsView;
  }

  /**
   * @return the editView
   */
  public String getEditView() {
    return editView;
  }

  /**
   * @param editView the editView to set
   */
  public void setEditView(String editView) {
    this.editView = editView;
  }

  /**
   * @return the listView
   */
  public String getListView() {
    return listView;
  }

  /**
   * @param listView the listView to set
   */
  public void setListView(String listView) {
    this.listView = listView;
  }

  /**
   * @return the manageView
   */
  public String getManageView() {
    return manageView;
  }

  /**
   * @param manageView the manageView to set
   */
  public void setManageView(String manageView) {
    this.manageView = manageView;
  }

  /**
   * @return the urlPrefix
   */
  public String getUrlPrefix() {
    return urlPrefix;
  }

  /**
   * @param urlPrefix the urlPrefix to set
   */
  public void setUrlPrefix(String urlPrefix) {
    this.urlPrefix = urlPrefix;
  }

  /**
   * @return the viewPrefix
   */
  public String getViewPrefix() {
    return viewPrefix;
  }

  /**
   * @param viewPrefix the viewPrefix to set
   */
  public void setViewPrefix(String viewPrefix) {
    this.viewPrefix = viewPrefix;
  }

  /**
   * @return the orderByClause
   */
  public String getOrderByClause() {
    return orderByClause;
  }

  /**
   * @param orderByClause the orderByClause to set
   */
  public void setOrderByClause(String orderByClause) {
    this.orderByClause = orderByClause;
  }

  /**
   * @return the subFlowUrls
   */
  public String[] getSubFlowUrls() {
    return subFlowUrls;
  }

  /**
   * @param subFlowUrls the subFlowUrls to set
   */
  public void setSubFlowUrls(String[] subFlowUrls) {
    this.subFlowUrls = subFlowUrls;
  }
  
  /**
   * Return the full forward url for the given command.
   * 
   * @param command The command
   * @return the full redirect url for the given command.
   */
  public String getForwardUrl(String command) {
    return  urlPrefix + command;
  }
  
  /**
   * Return the full redirect url for the given command.
   * 
   * @param command The command
   * @return the full redirect url for the given command.
   */
  public String getRedirectUrl(String command) {
    return REDIRECT_PREFIX + getForwardUrl(command);
  }

  /**
   * Return the full view name for the given view name.
   * 
   * @param viewName the view name
   * @return the full view name for the given view name.
   */
  public String getFullViewName(String viewName) {
    return viewPrefix + viewName;
  }
  
  /**
   * Sets the url and view prefixes. The view prefix is calculated from the url prefix according to the naming conventions
   * @param newUrlPrefix The url prefix to set
   */
  public void setUrlAndViewPrefixes(String newUrlPrefix) {
    setUrlPrefix(newUrlPrefix);
    setViewPrefix(newUrlPrefix.substring(1).replace('/', '.') + '.');
  }
  
  /**
   * Gets the target url of a subflow given a command url.
   * 
   * @param url The url of a command
   * @return the target url of a subflow given a command url
   */
  public String getSubflowUrlFromCall(String url) {
    if (url.contains(getCallCommand())) {
      int pos = url.indexOf('=');
      int subFlowId = Integer.valueOf(url.substring(pos + 1));
      return getSubFlowUrls()[subFlowId];
    }
    return url;
  }

  /**
   * @return the advancedSearch
   */
  public boolean isAdvancedSearch() {
    return advancedSearch;
  }

  /**
   * @param advancedSearch the advancedSearch to set
   */
  public void setAdvancedSearch(boolean advancedSearch) {
    this.advancedSearch = advancedSearch;
  }
}
