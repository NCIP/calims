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
import javax.servlet.jsp.tagext.TryCatchFinally;

/**
 * Tag that include mata tags in the page header.
 * 
 * @author viseem
 * 
 */
public class MetaTag extends TagSupport implements TryCatchFinally {

  private static final long serialVersionUID = -7498527926331549530L;
  
  private String content;
  private String httpEquiv;
  private String name;
  private String scheme;

  /**
   * Reset all the attributes to their default values.
   */
  private void reset() {
    content = null;
    name = null;
    scheme = null;
    httpEquiv = null;
  }

  /**
   * {@inheritDoc}
   */
  public int doEndTag() throws JspException {
    PageTag pageTag = PageTag.getPageTagLocator().getTag(pageContext, this);
    pageTag.getMetaManager().addMeta(content, httpEquiv, name, scheme);
    return EVAL_PAGE;
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
   * @param content the content to set
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * @param httpEquiv the httpEquiv to set
   */
  public void setHttpEquiv(String httpEquiv) {
    this.httpEquiv = httpEquiv;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @param scheme the scheme to set
   */
  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

}
