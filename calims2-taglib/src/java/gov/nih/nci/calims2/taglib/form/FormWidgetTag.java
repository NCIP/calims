/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
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
