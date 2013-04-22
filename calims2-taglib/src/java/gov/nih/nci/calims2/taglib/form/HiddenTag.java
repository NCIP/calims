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

import gov.nih.nci.calims2.uic.html.BaseTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;

/**
 * Tag that generates an input hidden field.
 * 
 * @author viseem
 */
public class HiddenTag extends FormWidgetTag {
  
  private static final long serialVersionUID = -8592788296050727581L;

  /**
   * {@inheritDoc}
   */
  protected Tag createTag() {
    Tag inputTag = new BaseTag(HtmlElement.INPUT);
    inputTag.addAttribute("id", getId());
    inputTag.addAttribute("name", getName());
    inputTag.addAttribute("type", "hidden");
    if (getValue() != null) {
      inputTag.addAttribute("value", getValue().toString());
    }
    return inputTag;
  }
}
