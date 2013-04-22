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

import gov.nih.nci.calims2.uic.html.BaseTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;

/**
 * @author connollym
 *
 */
public class FileInputTag extends FormWidgetTag {
  
  private static final long serialVersionUID = -8680550549427026171L;
  
  private String invalidKey;
  private String invalidMessage;
  private Integer maxLength;
  private String promptKey;
  private String promptMessage;
  private String toolTipPosition;

  /**
   * {@inheritDoc}
   */
  protected Tag createTag() {
    Tag tag = new BaseTag(HtmlElement.INPUT);
    tag.addAttribute("type", "file");
    addAttributes(tag);
    if (maxLength != null) {
      tag.addAttribute("maxLength", maxLength.toString());
    }
    return tag;
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
