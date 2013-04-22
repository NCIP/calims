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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.taglib.TagLocator;
import gov.nih.nci.calims2.taglib.page.PageDojoManager;
import gov.nih.nci.calims2.uic.dojo.DojoType;
import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.ContentTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.html.ContentTag.ContentType;

/**
 * Tag generating a form for validation.
 * 
 * @author viseem
 *
 */
public class FormTag extends FormWidgetTag {

  private static final long serialVersionUID = -6497808750695692891L;
  
  private static final String DEFAULT_METHOD = "post";
  private static final String ON_SUBMIT_SCRIPT = "var currentForm = dijit.byNode(evt.currentTarget);\n"
      + "return !currentForm.validateFlag || currentForm.validate();";

  private static TagLocator<FormTag> formTagLocator = new TagLocator<FormTag>(FormTag.class.getName());
  
  private String action;
  private String enctype;
  private String method = DEFAULT_METHOD;
  private boolean validate;
  
  /**
   * @return the formTagLocator
   */
  public static TagLocator<FormTag> getFormTagLocator() {
    return formTagLocator;
  }

  /**
   * @param formTagLocator the formTagLocator to set
   */
  public static void setFormTagLocator(TagLocator<FormTag> formTagLocator) {
    FormTag.formTagLocator = formTagLocator;
  }
  
  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    super.reset();
    action = null;
    enctype = null;
    method = DEFAULT_METHOD;
    validate = false;
  }
  
  /**
   * {@inheritDoc}
   */
  public int doStartTag() throws JspException {
    formTagLocator.saveTag(pageContext, this);
    return EVAL_BODY_BUFFERED;
  }
  
  /**
   * {@inheritDoc}
   */
  public int doEndTag() throws JspException {
    int result = super.doEndTag();
    formTagLocator.removeTag(pageContext);
    return result;
  }

  /**
   * {@inheritDoc}
   */
  protected void registerTypes(PageDojoManager dojoManager) {
    dojoManager.addDojoType(DojoType.DIJIT_FORM_FORM.getTypeName());
  }
  
  /**
   * {@inheritDoc}
   */
  protected Tag createTag() {
    Tag formTag = new CompositeTag(HtmlElement.FORM);
    formTag.addAttribute("dojoType", DojoType.DIJIT_FORM_FORM.getTypeName());
    addAttributes(formTag);
    addBody(formTag);
    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    String fullAction = (action != null && action.startsWith("/")) ? request.getContextPath() + action : action;
    formTag.addAttribute("action", fullAction);
    formTag.addAttribute("enctype", enctype);
    formTag.addAttribute("method", method);
    return formTag;
  }
  
  private void addBody(Tag tag) {
    BodyContent content = getBodyContent();
    if (content != null) {
      ContentTag contentTag = tag.addChild(new ContentTag(content.getString()));
      contentTag.setContentType(ContentType.TEXT);
    }
    if (validate) {
      Tag scriptTag = tag.addChild(new CompositeTag(HtmlElement.SCRIPT));
      scriptTag.addAttribute("args", "evt");
      scriptTag.addAttribute("event", "onSubmit");
      scriptTag.addAttribute("type", "dojo/method");
      ContentTag contentTag = scriptTag.addChild(new ContentTag(ON_SUBMIT_SCRIPT));
      contentTag.setContentType(ContentType.TEXT);
    }
  }

  /**
   * @return the action
   */
  public String getAction() {
    return action;
  }

  /**
   * @param action the action to set
   */
  public void setAction(String action) {
    this.action = StringUtils.stripToNull(action);
  }

  /**
   * @return the enctype
   */
  public String getEnctype() {
    return enctype;
  }

  /**
   * @param enctype the enctype to set
   */
  public void setEnctype(String enctype) {
    this.enctype = StringUtils.stripToNull(enctype);
  }

  /**
   * @return the method
   */
  public String getMethod() {
    return method;
  }

  /**
   * @param method the method to set
   */
  public void setMethod(String method) {
    this.method = StringUtils.stripToNull(method);
  }

  /**
   * @return the validate
   */
  public boolean isValidate() {
    return validate;
  }

  /**
   * @param validate the validate to set
   */
  public void setValidate(boolean validate) {
    this.validate = validate;
  }

 

}
