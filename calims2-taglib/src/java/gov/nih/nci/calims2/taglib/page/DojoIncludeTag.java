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
 * Tag that includes dojo in the page.
 * 
 * @author viseem
 * 
 */
public class DojoIncludeTag extends TagSupport {

  private static final long serialVersionUID = 4959496508988914568L;
  
  private String config;

  /**
   * {@inheritDoc}
   */
  public int doEndTag() throws JspException {
    PageDojoManager dojoManager = PageTag.getPageTagLocator().getTag(pageContext, this).getDojoManager();
    dojoManager.setConfig(config);
    dojoManager.setIncludeDojo(true);
    return EVAL_PAGE;
  }

  /**
   * @return the config
   */
  public String getConfig() {
    return config;
  }

  /**
   * @param config the config to set
   */
  public void setConfig(String config) {
    this.config = config;
  }

}
