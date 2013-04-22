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
 * Tag that manages the inclusion of dojo.require statements in the page.
 * 
 * @author viseem
 * 
 */
public class DojoRequireTag extends TagSupport {

  private static final long serialVersionUID = 1065607818609620908L;
  
  private String dojoType;

  /**
   * {@inheritDoc}
   */
  public int doEndTag() throws JspException {
    PageDojoManager dojoManager = PageTag.getPageTagLocator().getTag(pageContext, this).getDojoManager();
    dojoManager.addDojoType(dojoType);
    return EVAL_PAGE;
  }

  /**
   * @return the dojoType
   */
  public String getDojoType() {
    return dojoType;
  }

  /**
   * @param dojoType the dojoType to set
   */
  public void setDojoType(String dojoType) {
    this.dojoType = dojoType;
  }

}
