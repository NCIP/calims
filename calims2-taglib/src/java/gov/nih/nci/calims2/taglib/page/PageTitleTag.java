/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.taglib.page;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Tag that include the title of the page.
 * 
 * @author viseem
 *
 */
public class PageTitleTag extends BodyTagSupport {

  private static final long serialVersionUID = 7056208203635984773L;

  /**
   * {@inheritDoc}
   */
  public int doEndTag() throws JspException {
    PageTag pageTag = PageTag.getPageTagLocator().getTag(pageContext, this);
    pageTag.setTitle(getBodyContent().getString());
    return EVAL_PAGE;
  }
}
