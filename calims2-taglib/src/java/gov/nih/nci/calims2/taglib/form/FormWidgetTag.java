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

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.support.RequestContext;

import gov.nih.nci.calims2.taglib.TagHelper;
import gov.nih.nci.calims2.taglib.page.PageDojoManager;
import gov.nih.nci.calims2.taglib.page.PageTag;
import gov.nih.nci.calims2.uic.html.Tag;

/**
 * @author viseem
 * 
 */
public abstract class FormWidgetTag extends BodyTagSupport implements TryCatchFinally {

  private static final long serialVersionUID = 2532774710798856014L;
  
  private String alt;
  private String altKey;
  private boolean disabled;
  private String id;
  private String name;
  private boolean readOnly;
  private boolean required;
  private String style;
  private String styleClass;
  private Integer tabIndex;
  private String type;
  private Object value;
  
  private boolean prettyRendering = true;

  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    alt = null;
    altKey = null;
    disabled = false;
    id = null;
    name = null;
    readOnly = false;
    required = false;
    style = null;
    styleClass = null;
    tabIndex = null;
    type = null;
    value = null;
    prettyRendering = true;
  }

  /**
   * {@inheritDoc}
   */
  public void doCatch(Throwable throwable) throws Throwable {
    throw throwable;
  }

  /**
   * {@inheritDoc}
   */
  public void doFinally() {
    reset();
  }

  /**
   * {@inheritDoc}
   */
  public int doEndTag() throws JspException {
    PageTag pageTag = PageTag.getPageTagLocator().getTag(pageContext, this);
    registerTypes(pageTag.getDojoManager());
    Tag tag = createTag();
    TagHelper.outputTag(pageContext, tag, prettyRendering);
    return EVAL_PAGE;
  }

  /**
   * Register the dojo types with the PageTag.
   * 
   * @param dojoManager The dojoManager on which types should be registered
   */
  protected void registerTypes(PageDojoManager dojoManager) {
    // Nothing to do
  }

  /**
   * Creates the tag to output.
   * 
   * @return The Tag to output
   * @throws JspException If an error occurs
   */
  protected abstract Tag createTag() throws JspException;

  /**
   * @return the alt
   */
  public String getAlt() {
    return alt;
  }

  /**
   * @param alt the alt to set
   */
  public void setAlt(String alt) {
    this.alt = StringUtils.stripToNull(alt);
  }

  /**
   * @return the altKey
   */
  public String getAltKey() {
    return altKey;
  }

  /**
   * @param altKey the altKey to set
   */
  public void setAltKey(String altKey) {
    this.altKey = StringUtils.stripToNull(altKey);
  }

  /**
   * @return the disabled
   */
  public boolean isDisabled() {
    return disabled;
  }

  /**
   * @param disabled the disabled to set
   */
  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = StringUtils.stripToNull(id);
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = StringUtils.stripToNull(name);
  }

  /**
   * @return the readOnly
   */
  public boolean isReadOnly() {
    return readOnly;
  }

  /**
   * @param readOnly the readOnly to set
   */
  public void setReadOnly(boolean readOnly) {
    this.readOnly = readOnly;
  }
  
  /**
   * @return the required
   */
  public boolean isRequired() {
    return required;
  }

  /**
   * @param required the required to set
   */
  public void setRequired(boolean required) {
    this.required = required;
  }

  /**
   * @return the style
   */
  public String getStyle() {
    return style;
  }

  /**
   * @param style the style to set
   */
  public void setStyle(String style) {
    this.style = StringUtils.stripToNull(style);
  }

  /**
   * @return the styleClass
   */
  public String getStyleClass() {
    return styleClass;
  }

  /**
   * @param styleClass the styleClass to set
   */
  public void setStyleClass(String styleClass) {
    this.styleClass = StringUtils.stripToNull(styleClass);
  }

  /**
   * @return the tabIndex
   */
  public Integer getTabIndex() {
    return tabIndex;
  }

  /**
   * @param tabIndex the tabIndex to set
   */
  public void setTabIndex(Integer tabIndex) {
    this.tabIndex = tabIndex;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = StringUtils.stripToNull(type);
  }

  /**
   * @return the value
   */
  public Object getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(Object value) {
    this.value = value;
  }

  /**
   * Adds the attributes to the given tag.
   * 
   * @param tag The Tag on which the attributes must be set.
   */
  protected void addAttributes(Tag tag) {
    if (altKey != null) {
      RequestContext rc = TagHelper.getRequestContext(pageContext);
      tag.addAttribute("alt", rc.getMessage(altKey, null, false));
    } else {
      tag.addAttribute("alt", alt);
    }
    tag.addAttribute("class", styleClass);
    if (disabled) {
      tag.addAttribute("disabled", "true");
    }
    tag.addAttribute("id", id);
    tag.addAttribute("name", name);
    if (readOnly) {
      tag.addAttribute("readOnly", "true");
    }
    tag.addAttribute("style", style);
    if (tabIndex != null) {
      tag.addAttribute("tabIndex", tabIndex.toString());
    }
    tag.addAttribute("type", type);
    if (value != null) {
      tag.addAttribute("value", value.toString());
    }
  }

  /**
   * @return the prettyRendering
   */
  protected boolean isPrettyRendering() {
    return prettyRendering;
  }

  /**
   * @param prettyRendering the prettyRendering to set
   */
  protected void setPrettyRendering(boolean prettyRendering) {
    this.prettyRendering = prettyRendering;
  }

}
