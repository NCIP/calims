/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The calims2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This calims2 Software License (the License) is between NCI and You. You (or 
 * Your) shall mean a person or an entity, and all other entities that control, 
 * are controlled by, or are under common control with the entity. Control for 
 * purposes of this definition means (i) the direct or indirect power to cause 
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares, 
 * or (iii) beneficial ownership of such entity. 
 *
 * This License is granted provided that You agree to the conditions described 
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up, 
 * no-charge, irrevocable, transferable and royalty-free right and license in 
 * its rights in the calims2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the calims2 Software; (ii) distribute and 
 * have distributed to and by third parties the calims2 Software and any 
 * modifications and derivative works thereof; and (iii) sublicense the 
 * foregoing rights set out in (i) and (ii) to third parties, including the 
 * right to license such rights to further third parties. For sake of clarity, 
 * and not by way of limitation, NCI shall have no right of accounting or right 
 * of payment from You or Your sub-licensees for the rights granted under this 
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the 
 * above copyright notice, this list of conditions and the disclaimer and 
 * limitation of liability of Article 6, below. Your redistributions in object 
 * code form must reproduce the above copyright notice, this list of conditions 
 * and the disclaimer of Article 6 in the documentation and/or other materials 
 * provided with the distribution, if any. 
 *
 * Your end-user documentation included with the redistribution, if any, must 
 * include the following acknowledgment: This product includes software 
 * developed by Moxie Informatics and the National Cancer Institute. If You do not include 
 * such end-user documentation, You shall include this acknowledgment in the 
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "Moxie Informatics" 
 * to endorse or promote products derived from this Software. This License does 
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or Moxie Informatics, except as required to comply with the 
 * terms of this License. 
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this 
 * Software into Your proprietary programs and into any third party proprietary 
 * programs. However, if You incorporate the Software into third party 
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software 
 * into such third party proprietary programs and for informing Your 
 * sub-licensees, including without limitation Your end-users, of their 
 * obligation to secure any required permissions from such third parties before 
 * incorporating the Software into such third party proprietary software 
 * programs. In the event that You fail to obtain such permissions, You agree 
 * to indemnify NCI for any claims against NCI by such third parties, except to 
 * the extent prohibited by law, resulting from Your failure to obtain such 
 * permissions. 
 *
 * For sake of clarity, and not by way of limitation, You may add Your own 
 * copyright statement to Your modifications and to the derivative works, and 
 * You may provide additional or different license terms and conditions in Your 
 * sublicenses of modifications of the Software, or any derivative works of the 
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, 
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, 
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO 
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, MOXIE INFORMATICS OR THEIR 
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
