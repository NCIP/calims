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

import gov.nih.nci.calims2.taglib.page.PageDojoManager;
import gov.nih.nci.calims2.uic.dojo.DojoType;
import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.ContentTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.html.ContentTag.ContentType;

/**
 * @author viseem
 *
 */
public class TextAreaTag extends FormWidgetTag {
  
  private static final long serialVersionUID = 8958549870155330178L;
  
  private Integer cols;
  private Integer rows;
  
  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    super.reset();
    cols = null;
    rows = null;
  }  
  
  /**
   * {@inheritDoc}
   */
  protected void registerTypes(PageDojoManager dojoManager) {
    dojoManager.addDojoType(DojoType.DIJIT_FORM_TEXTAREA.getTypeName());
  }

  /**
   * {@inheritDoc}
   */
  protected Tag createTag() {
    setPrettyRendering(false);
    Tag tag = new CompositeTag(HtmlElement.TEXTAREA);
    tag.addAttribute("dojoType", DojoType.DIJIT_FORM_TEXTAREA.getTypeName());
    addAttributes(tag);
    tag.removeAttribute("value");
    String value = (getValue() != null) ? getValue().toString() : "";
    ContentTag contentTag = tag.addChild(new ContentTag(value));
    contentTag.setContentType(ContentType.TEXT);
    if (cols != null) {
      tag.addAttribute("cols", cols.toString());
    }
    if (rows != null) {
      tag.addAttribute("rows", rows.toString());
    }
    return tag;
  }
  
  /**
   * @return the cols
   */
  public int getCols() {
    return cols;
  }

  /**
   * @param cols the cols to set
   */
  public void setCols(int cols) {
    this.cols = cols;
  }

  /**
   * @return the rows
   */
  public int getRows() {
    return rows;
  }

  /**
   * @param rows the rows to set
   */
  public void setRows(int rows) {
    this.rows = rows;
  }

}
