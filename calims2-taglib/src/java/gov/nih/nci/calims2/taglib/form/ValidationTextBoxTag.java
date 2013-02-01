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
package gov.nih.nci.calims2.taglib.form;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.support.RequestContext;

import gov.nih.nci.calims2.taglib.TagHelper;
import gov.nih.nci.calims2.taglib.page.PageDojoManager;
import gov.nih.nci.calims2.uic.dojo.DojoType;
import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;

/**
 * @author viseem
 * 
 */
public class ValidationTextBoxTag extends FormWidgetTag {

  private static final long serialVersionUID = -8139779577941945735L;
  
  private static final String TRIM_FORMAT = "trim";
  private static final String UPPER_FORMAT = "uppercase";
  private static final String LOWER_FORMAT = "lowercase";
  private static final String PROPER_FORMAT = "propercase";
  private static final String[] FORMAT_NAMES = new String[] {TRIM_FORMAT, UPPER_FORMAT, LOWER_FORMAT, PROPER_FORMAT };

  private String constraints;
  private String format = TRIM_FORMAT;
  private String invalidKey;
  private String invalidMessage;
  private Integer maxLength;
  private String pattern;
  private String promptKey;
  private String promptMessage;
  private String toolTipPosition;

  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    super.reset();
    constraints = null;
    format = TRIM_FORMAT;
    invalidKey = null;
    invalidMessage = null;
    maxLength = null;
    pattern = null;
    promptKey = null;
    promptMessage = null;
    toolTipPosition = null;
  }

  /**
   * {@inheritDoc}
   */
  protected void registerTypes(PageDojoManager dojoManager) {
    dojoManager.addDojoType(DojoType.DIJIT_FORM_VALIDATION_TEXTBOX.getTypeName());
  }

  /**
   * {@inheritDoc}
   */
  protected Tag createTag() {
    Tag tag = new CompositeTag(HtmlElement.DIV);
    tag.addAttribute("dojoType", DojoType.DIJIT_FORM_VALIDATION_TEXTBOX.getTypeName());
    addAttributes(tag);
    addConstraints(tag);
    addFormat(tag);
    addMessages(tag);
    return tag;
  }

  private void addFormat(Tag tag) {
    if (format != null) {
      for (String formatName : FORMAT_NAMES) {
        if (format.contains(formatName)) {
          tag.addAttribute(formatName, "true");
        }
      }
    }
  }
  
  /**
   * Adds the invalid and prompt message to the current tag.
   * @param tag The tag to which the messages must be added.
   */
  protected void addMessages(Tag tag) {
    RequestContext rc = TagHelper.getRequestContext(pageContext);
    if (invalidKey != null) {
      tag.addAttribute("invalidMessage", rc.getMessage(invalidKey, null, false));
    } else {
      if (invalidMessage != null) {
        tag.addAttribute("invalidMessage", invalidMessage);
      }
    }
    if (promptKey != null) {
      tag.addAttribute("promptMessage", rc.getMessage(promptKey, null, false));
    } else {
      if (promptMessage != null) {
        tag.addAttribute("promptMessage", promptMessage);
      }
    }
    tag.addAttribute("toolTipPosition", toolTipPosition);
  }

  /**
   * Adds the constraints.
   * @param tag The tag to which the constraints must be added.
   */
  protected void addConstraints(Tag tag) {
    tag.addAttribute("constraints", constraints);
    tag.addAttribute("regExp", pattern);
    tag.addAttribute("required", Boolean.toString(isRequired()));
    if (maxLength != null) {
      tag.addAttribute("maxLength", maxLength.toString());
    }
  }

  /**
   * @return the constraints
   */
  public String getConstraints() {
    return constraints;
  }

  /**
   * @param constraints the constraints to set
   */
  public void setConstraints(String constraints) {
    this.constraints = StringUtils.stripToNull(constraints);
  }

  /**
   * @return the format
   */
  public String getFormat() {
    return format;
  }

  /**
   * @param format the format to set
   */
  public void setFormat(String format) {
    this.format = StringUtils.stripToNull(format);
  }

  /**
   * @return the invalidKey
   */
  public String getInvalidKey() {
    return invalidKey;
  }

  /**
   * @param invalidKey the invalidKey to set
   */
  public void setInvalidKey(String invalidKey) {
    this.invalidKey = StringUtils.stripToNull(invalidKey);
  }

  /**
   * @return the invalidMessage
   */
  public String getInvalidMessage() {
    return invalidMessage;
  }

  /**
   * @param invalidMessage the invalidMessage to set
   */
  public void setInvalidMessage(String invalidMessage) {
    this.invalidMessage = StringUtils.stripToNull(invalidMessage);
  }

  /**
   * @return the maxLength
   */
  public Integer getMaxLength() {
    return maxLength;
  }

  /**
   * @param maxLength the maxLength to set
   */
  public void setMaxLength(Integer maxLength) {
    this.maxLength = maxLength;
  }

  /**
   * @return the pattern
   */
  public String getPattern() {
    return pattern;
  }

  /**
   * @param pattern the pattern to set
   */
  public void setPattern(String pattern) {
    this.pattern = StringUtils.stripToNull(pattern);
  }

  /**
   * @return the promptKey
   */
  public String getPromptKey() {
    return promptKey;
  }

  /**
   * @param promptKey the promptKey to set
   */
  public void setPromptKey(String promptKey) {
    this.promptKey = StringUtils.stripToNull(promptKey);
  }

  /**
   * @return the promptMessage
   */
  public String getPromptMessage() {
    return promptMessage;
  }

  /**
   * @param promptMessage the promptMessage to set
   */
  public void setPromptMessage(String promptMessage) {
    this.promptMessage = StringUtils.stripToNull(promptMessage);
  }

  /**
   * @return the toolTipPosition
   */
  public String getToolTipPosition() {
    return toolTipPosition;
  }

  /**
   * @param toolTipPosition the toolTipPosition to set
   */
  public void setToolTipPosition(String toolTipPosition) {
    this.toolTipPosition = StringUtils.stripToNull(toolTipPosition);
  }
}
