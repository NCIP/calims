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
