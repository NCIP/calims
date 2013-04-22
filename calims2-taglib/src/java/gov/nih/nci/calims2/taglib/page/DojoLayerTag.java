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
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Tag that manages the inclusion of dojo layers in the page.
 * 
 * @author viseem
 *
 */
public class DojoLayerTag extends TagSupport {
  
  private static final long serialVersionUID = 7369120467291792685L;
  
  private String name;

  /**
   * {@inheritDoc}
   */
  public int doEndTag() throws JspException {
    PageDojoManager dojoManager = PageTag.getPageTagLocator().getTag(pageContext, this).getDojoManager();
    dojoManager.addLayer(name);
    return EVAL_PAGE;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

}
