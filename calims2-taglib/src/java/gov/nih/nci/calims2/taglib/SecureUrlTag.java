/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.taglib;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * Tag to test a url for security.
 * The privilegeEvaluator must be present in the servlet contex.
 * @author viseem
 * 
 */
public class SecureUrlTag extends BodyTagSupport implements TryCatchFinally {

  private static final long serialVersionUID = 701409615258778212L;

  private static final String EVALUATOR_ATTR = "privilegeEvaluator";

  private String name;
  private int scope = PageContext.PAGE_SCOPE;
  private String url;

  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    name = null;
    scope = PageContext.PAGE_SCOPE;
    url = null;
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
   * {@inheritDoc}
   */
  public int doStartTag() {
    PrivilegeEvaluator privilegeEvaluator = (PrivilegeEvaluator) pageContext.findAttribute(EVALUATOR_ATTR);
    boolean rendering = privilegeEvaluator.isAllowed(url);
    if (name != null) {
      pageContext.setAttribute(name, rendering, scope);
    }
    return (rendering) ? EVAL_BODY_INCLUDE : SKIP_BODY;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @param scope the scope to set
   */
  public void setScope(int scope) {
    this.scope = scope;
  }

  /**
   * @param url the url to set
   */
  public void setUrl(String url) {
    this.url = url;
  }

}
