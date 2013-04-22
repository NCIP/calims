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
import javax.servlet.jsp.tagext.TryCatchFinally;

/**
 * Tag that include scripts in the page header.
 * 
 * @author viseem
 * 
 */
public class ScriptTag extends BodyTagSupport implements TryCatchFinally {

  private static final long serialVersionUID = 7928315693132736130L;

  private static final String DEFAULT_TYPE = "text/javascript";

  private String type = DEFAULT_TYPE;
  private String src;

  /**
   * Reset all the attributes to their default values.
   */
  private void reset() {
    type = DEFAULT_TYPE;
    src = null;
  }

  /**
   * {@inheritDoc}
   */
  public int doEndTag() throws JspException {
    PageTag pageTag = PageTag.getPageTagLocator().getTag(pageContext, this);
    String body = (bodyContent != null) ? bodyContent.getString() : null;
    pageTag.getScriptManager().addScript(type, src, body);
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
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the src
   */
  public String getSrc() {
    return src;
  }

  /**
   * @param src the src to set
   */
  public void setSrc(String src) {
    this.src = src;
  }

}
