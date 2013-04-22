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

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

import gov.nih.nci.calims2.taglib.page.PageDojoManager;
import gov.nih.nci.calims2.uic.dojo.DojoType;
import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;

/**
 * @author viseem
 *
 */
public class DateTextBoxTag extends ValidationTextBoxTag {
  
  private static final long serialVersionUID = -6872357289449809819L;
  
  private String formatLength;
  private boolean strict;
  
  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    super.reset();
    formatLength = null;
    strict = false;
  }
  
  /**
   * {@inheritDoc}
   */
  protected void registerTypes(PageDojoManager dojoManager) {
    dojoManager.addDojoType(DojoType.DIJIT_FORM_DATE_TEXTBOX.getTypeName());
  }

  /**
   * {@inheritDoc}
   */
  protected Tag createTag() {
    Tag tag = new CompositeTag(HtmlElement.DIV);
    tag.addAttribute("dojoType", DojoType.DIJIT_FORM_DATE_TEXTBOX.getTypeName());
    addAttributes(tag);
    addMessages(tag);
    tag.addAttribute("constraints", getConstraints());
    tag.addAttribute("required", Boolean.toString(isRequired()));
    tag.addAttribute("formatLength", formatLength);
    tag.addAttribute("datePattern", getPattern());
    tag.addAttribute("strict", Boolean.toString(strict));
    tag.addAttribute("value", getIsoValue());
    return tag;
  }
  
  private String getIsoValue() {
    Object value = getValue();
    if (value == null) {
      return null;
    }
    DateTime date = null;
    if (value instanceof Calendar || value instanceof Date) {
      date = new DateTime(value);
    }
    if (value instanceof DateTime) {
      date = (DateTime) value;
    }
    return (date != null) ? date.toString() : null;
  }

  /**
   * @param formatLength the formatLength to set
   */
  public void setFormatLength(String formatLength) {
    this.formatLength = StringUtils.stripToNull(formatLength);
  }

  /**
   * @param strict the strict to set
   */
  public void setStrict(boolean strict) {
    this.strict = strict;
  }

}
