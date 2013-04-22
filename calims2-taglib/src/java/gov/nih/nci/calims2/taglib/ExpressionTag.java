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

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.el.ELException;
import javax.servlet.jsp.el.ExpressionEvaluator;
import javax.servlet.jsp.el.VariableResolver;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.springframework.web.util.TagUtils;

/**
 * Tag that evaluates a given jstl expression and puts it in an attribute of the specified scope.
 * 
 * @author viseem
 */
public class ExpressionTag extends TagSupport implements TryCatchFinally {

  private static final long serialVersionUID = 4946583165901861136L;
  
  private String expression;
  private Class<?> expectedType;
  private String name;
  private int scope = PageContext.PAGE_SCOPE;
  /**
   * Reset all the attributes to their default values.
   */
  private void reset() {
    expression = null;
    expectedType = null;
    name = null;
    scope = PageContext.PAGE_SCOPE;
  }
  
  /**
   * {@inheritDoc}
   */
  public int doEndTag() throws JspException {
    ExpressionEvaluator evaluator = pageContext.getExpressionEvaluator();
    VariableResolver resolver = pageContext.getVariableResolver();
    try {
      Object result = evaluator.evaluate("${" + expression + "}", expectedType, resolver, null);
      pageContext.setAttribute(name, result, scope);
    } catch (ELException e) {
      throw new JspException(e);
    }
    return EVAL_PAGE;
  }
  
  /**
   * @param expression the expression to set
   */
  public void setExpression(String expression) {
    this.expression = expression;
  }
  /**
   * @param expectedType the expectedType to set
   */
  public void setExpectedType(String expectedType) {
    try {
      this.expectedType = Class.forName(expectedType);
    } catch (ClassNotFoundException e) {
      throw new IllegalArgumentException(e);
    }
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
  public void setScope(String scope) {
    this.scope = TagUtils.getScope(scope);
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

}
