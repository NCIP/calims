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

import java.util.ArrayList;
import java.util.List;

import gov.nih.nci.calims2.uic.descriptor.CommandVisibility;
import gov.nih.nci.calims2.uic.descriptor.FieldVisibility;
import gov.nih.nci.calims2.uic.descriptor.FormDecorator;
import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.form.FieldType;
import gov.nih.nci.calims2.uic.descriptor.form.Form;
import gov.nih.nci.calims2.uic.descriptor.form.FormElement;
import gov.nih.nci.calims2.uic.descriptor.form.FormTab;
import gov.nih.nci.calims2.uic.descriptor.form.HiddenField;
import gov.nih.nci.calims2.uic.descriptor.form.StandaloneFormElement;
import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * Default form decorator to be used in CRUD use cases that do not need any special behavior for the form. The default behavior
 * implemented by this decorator is the following:<br/>
 * 
 * Fields and hidden fields are visible if they have no selector or if their selector matches the form required selector.
 * Commands are visible if they have no selector or if their selector matches the form required selector and if the user
 * is allowed to access the url of the command.
 * 
 * @author viseem
 * 
 */
public class CRUDFormDecorator implements FormDecorator {

  private Form form;
  private PrivilegeEvaluator privilegeEvaluator;
  private CRUDControllerConfig config;

  /**
   * @return the form
   */
  public Form getForm() {
    return form;
  }

  /**
   * @param form the form to set
   */
  public void setForm(Form form) {
    this.form = form;
  }

  /**
   * {@inheritDoc}
   */
  public FieldVisibility getHiddenFieldVisibility(HiddenField field, String requiredSelector) {
    return getDefaultFieldVisibility(field.getSelector(), requiredSelector);
  }

  /**
   * {@inheritDoc}
   */
  public List<HiddenField> getVisibleHiddenFields(String requiredSelector) {
    List<HiddenField> fields = new ArrayList<HiddenField>();
    for (HiddenField field : form.getHiddenFields()) {
      if (getHiddenFieldVisibility(field, requiredSelector) == FieldVisibility.VISIBLE) {
        fields.add(field);
      }
    }
    return fields;
  }

  /**
   * {@inheritDoc}
   */
  public FieldVisibility getFieldVisibility(StandaloneFormElement field, String requiredSelector) {
    return getDefaultFieldVisibility(field.getSelector(), requiredSelector);
  }

  /**
   * {@inheritDoc}
   */
  public List<StandaloneFormElement> getVisibleFields(FormTab tab, String requiredSelector) {
    List<StandaloneFormElement> fields = new ArrayList<StandaloneFormElement>();
    for (FormElement element : tab.getChildren()) {
      if (element instanceof StandaloneFormElement
          && getFieldVisibility((StandaloneFormElement) element, requiredSelector) == FieldVisibility.VISIBLE) {
        fields.add((StandaloneFormElement) element);
      }
    }
    return fields;
  }
  
  /**
   * {@inheritDoc}
   */
  public List<StandaloneFormElement> getAllVisibleFields(String requiredSelector) {
    List<StandaloneFormElement> fields = new ArrayList<StandaloneFormElement>();
    for (FormElement tabElement : form.getChildren()) {
      for (FormElement element : tabElement.getChildren()) {
        if (element instanceof StandaloneFormElement
            && getFieldVisibility((StandaloneFormElement) element, requiredSelector) == FieldVisibility.VISIBLE) {
          fields.add((StandaloneFormElement) element);
        }
      }
    }
    return fields;
  }

  /**
   * Default calculation of the visibility of a field. This method is used by this decorator and is intended to be used in
   * subclasses for fields that have no special behavior.
   * 
   * @param fieldSelector The value of the field selector
   * @param requiredSelector The form selector
   * @return The visibility of the field.
   */
  protected FieldVisibility getDefaultFieldVisibility(String fieldSelector, String requiredSelector) {
    return (selectorMatch(fieldSelector, requiredSelector)) ? FieldVisibility.VISIBLE : FieldVisibility.INVISIBLE;
  }
  
  /**
   * Test if the selector of an element matches the required selector of the form. 
   * @param selector The selector to test
   * @param requiredSelector The form selector
   * @return true if the selector matches the required selector. 
   */
  protected boolean selectorMatch(String selector, String requiredSelector) {
    return selector == null || selector.indexOf(requiredSelector) >= 0;
  }

  /**
   * {@inheritDoc}
   */
  public CommandVisibility getCommandVisibility(Command command, String requiredSelector) {
    return getDefaultCommandVisibility(command, requiredSelector);
  }

  /**
   * Default calculation of the visibility of a command. This method is used by this decorator and is intended to be used in
   * subclasses for commands that have no special behavior.
   * 
   * @param command The command to evaluate
   * @param requiredSelector The form selector
   * @return The visibility of the field.
   */
  protected CommandVisibility getDefaultCommandVisibility(Command command, String requiredSelector) {
    if (!selectorMatch(command.getSelector(), requiredSelector)) {
      return CommandVisibility.INVISIBLE;
    }
    String url = config.getSubflowUrlFromCall(command.getUrl());
    if (privilegeEvaluator.isAllowed(url)) {
      return CommandVisibility.ACTIVE;
    }
    return CommandVisibility.INVISIBLE;
  }

  /**
   * {@inheritDoc}
   */
  public List<Command> getActiveCommands(FormTab tab, String requiredSelector) {
    List<Command> commands = new ArrayList<Command>();
    for (Command command : form.getCommands()) {
      if (command.getTab() == null || command.getTab().indexOf(tab.getName()) >= 0) {
        CommandVisibility visibility = getCommandVisibility(command, requiredSelector);
        if (visibility == CommandVisibility.ACTIVE) {
          commands.add(command);
        }
      }
    }
    return commands;
  }
  
  /**
   * {@inheritDoc}
   */
  public int getSeparatorCount(FormTab tab) {
    int count = 0;
    for (FormElement child : tab.getChildren()) {
      if (child.getType() == FieldType.SEPARATOR) {
        count++;
      }
    }
    return count;
  }

  /**
   * {@inheritDoc}
   */
  public int getTabCount() {
    int count = 0;
    for (FormElement child : form.getChildren()) {
      if (child.getType() == FieldType.FORM_TAB) {
        count++;
      }
    }
    return count;
  }
  
  /**
   * @return the privilegeEvaluator
   */
  public PrivilegeEvaluator getPrivilegeEvaluator() {
    return privilegeEvaluator;
  }

  /**
   * @param privilegeEvaluator the privilegeEvaluator to set
   */
  public void setPrivilegeEvaluator(PrivilegeEvaluator privilegeEvaluator) {
    this.privilegeEvaluator = privilegeEvaluator;
  }

  /**
   * @param config the config to set
   */
  public void setConfig(CRUDControllerConfig config) {
    this.config = config;
  }

}
