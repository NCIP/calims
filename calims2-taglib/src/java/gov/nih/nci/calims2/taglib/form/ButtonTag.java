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
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyContent;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.support.RequestContext;

import gov.nih.nci.calims2.taglib.TagHelper;
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
public class ButtonTag extends FormWidgetTag {
  
  private static final long serialVersionUID = -2769163376721633692L;
  
  private static final String CHECKBOX_TYPE = "checkbox";
  private static final String RADIO_TYPE = "radio";
  private static final String SUBMIT_TYPE = "submit";
  
  private boolean checked;
  private String iconClass;
  private String labelKey;
  private String label;
  private String url;
  private boolean validate;
  private DojoType dojoType;
  
  /**
   * Default constructor.
   */
  public ButtonTag() {
    setType(SUBMIT_TYPE);
  }

  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    super.reset();
    iconClass = null;
    labelKey = null;
    label = null;
    url = null;
    validate = false;
    setType(SUBMIT_TYPE);
    dojoType = null;
  }

  /**
   * {@inheritDoc}
   */
  protected void registerTypes(PageDojoManager dojoManager) {
    dojoType = getDojoType();
    dojoManager.addDojoType(dojoType.getTypeName());
  }
  
  private DojoType getDojoType() {
    if (getType() == null) {
      return DojoType.DIJIT_FORM_BUTTON;
    }
    String givenType = getType().toLowerCase().trim();
    if (CHECKBOX_TYPE.equals(givenType)) {
      return DojoType.DIJIT_FORM_CHECKBOX;
    }
    if (RADIO_TYPE.equals(givenType)) {
      return DojoType.DIJIT_FORM_RADIO_BUTTON;
    }
    return DojoType.DIJIT_FORM_BUTTON;
  }

  /**
   * {@inheritDoc}
   */
  protected Tag createTag() throws JspTagException {
    Tag buttonTag = new CompositeTag(HtmlElement.DIV);
    buttonTag.addAttribute("dojoType", dojoType.getTypeName());
    buttonTag.addAttribute("iconClass", iconClass);
    addAttributes(buttonTag);
    addBody(buttonTag);
    addLabel(buttonTag);
    addUrl(buttonTag);
    if (dojoType != DojoType.DIJIT_FORM_BUTTON) {
      buttonTag.addAttribute("checked", Boolean.toString(checked));
    }
    return buttonTag;
  }

  private void addBody(Tag tag) {
    BodyContent content = getBodyContent();
    if (content != null) {
      ContentTag contentTag = tag.addChild(new ContentTag(content.getString()));
      contentTag.setContentType(ContentType.TEXT);
    }
  }

  private void addLabel(Tag tag) {
    if (labelKey != null) {
      RequestContext rc = TagHelper.getRequestContext(pageContext);
      tag.addAttribute("label", rc.getMessage(labelKey, null, false));
    } else {
      if (label != null) {
        tag.addAttribute("label", label);
      } else {
        tag.addAttribute("showLabel", "false");
      }
    }
  }
  
  private void addUrl(Tag tag) throws JspTagException {
    if (url != null) {
      HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
      String fullUrl = (url.startsWith("/")) ? request.getContextPath() + url : url;
      Tag scriptTag = tag.addChild(new CompositeTag(HtmlElement.SCRIPT));
      scriptTag.addAttribute("args", "evt");
      scriptTag.addAttribute("event", "onClick");
      scriptTag.addAttribute("type", "dojo/method");
      FormTag formTag = FormTag.getFormTagLocator().getTag(pageContext, this);
      String setAction = "dojo.byId(\"" + formTag.getId() + "\").action = \"" + fullUrl + "\";\ndijit.byId(\"" + formTag.getId()
          + "\").validateFlag = " + validate + ";";
      ContentTag contentTag = scriptTag.addChild(new ContentTag(setAction));
      contentTag.setContentType(ContentType.TEXT);
    }
  }

  /**
   * @param checked the checked to set
   */
  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  /**
   * @param iconClass the iconClass to set
   */
  public void setIconClass(String iconClass) {
    this.iconClass = StringUtils.stripToNull(iconClass);
  }
  
  /**
   * @param labelKey the labelKey to set
   */
  public void setLabelKey(String labelKey) {
    this.labelKey = StringUtils.stripToNull(labelKey);
  }

  /**
   * @param label the label to set
   */
  public void setLabel(String label) {
    this.label = StringUtils.stripToNull(label);
  }

  /**
   * @param url the url to set
   */
  public void setUrl(String url) {
    this.url = StringUtils.stripToNull(url);
  }

  /**
   * @param validate the validate to set
   */
  public void setValidate(boolean validate) {
    this.validate = validate;
  }

}
