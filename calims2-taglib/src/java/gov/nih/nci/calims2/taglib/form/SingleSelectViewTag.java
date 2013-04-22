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

import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.commons.lang.StringUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import gov.nih.nci.calims2.taglib.TagHelper;
import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.ContentTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.select.OptionCreatorCallback;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author viseem
 * 
 */
public class SingleSelectViewTag extends TagSupport implements TryCatchFinally {

  private static final long serialVersionUID = 8072379223311479769L;
  
  private SelectCollectionType collectionType = SelectCollectionType.ENTITIES;
  private OptionCreatorCallback<?> optionCreatorCallback;
  private String properties;
  private Object selected;
  private String style;
  private String styleClass;

  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    collectionType = SelectCollectionType.ENTITIES;
    optionCreatorCallback = null;
    properties = null;
    selected = null;
    style = null;
    styleClass = null;
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
  public int doEndTag() throws JspException {
    Tag tag = createTag();
    TagHelper.outputTag(pageContext, tag, true);
    return EVAL_PAGE;
  }

  /**
   * Creates the view rendering.
   * 
   * @return The Tag to render
   */
  private Tag createTag() {
    Tag spanTag = new CompositeTag(HtmlElement.SPAN);
    spanTag.addAttribute("style", style);
    spanTag.addAttribute("class", styleClass);
    spanTag.addChild(new ContentTag(getSelectedOptionForView()));
    return spanTag;
  }

  /**
   * Gets the value of the selected option.
   * 
   * @return the value of the selected option.
   */
  @SuppressWarnings("unchecked")
  private String getSelectedOptionForView() {
    if (selected == null) {
      return "";
    }
    if (collectionType == SelectCollectionType.ENUMERATIONS) {
      I18nEnumeration enumValue = (I18nEnumeration) selected;
      return enumValue.getLocalizedValue(TagHelper.getRequestContext(pageContext).getLocale());
    }
    if (optionCreatorCallback != null) {
      OptionCreatorCallback<Object> callback = (OptionCreatorCallback<Object>) optionCreatorCallback;
      return callback.getLabel(selected);
    }
    Map<String, Expression> propertyMap = SingleSelectHelper.getPropertyMap(properties);
    Expression labelProperty = propertyMap.get("label");
    EvaluationContext context = new StandardEvaluationContext(selected);
    return SingleSelectHelper.evaluateExpression(labelProperty, context);
  }

  /**
   * @param collectionType the collectionType to set
   */
  public void setCollectionType(String collectionType) {
    this.collectionType = SelectCollectionType.valueOf(collectionType);
  }

  /**
   * @param optionCreatorCallback the optionCreatorCallback to set
   */
  public void setOptionCreatorCallback(OptionCreatorCallback<?> optionCreatorCallback) {
    this.optionCreatorCallback = optionCreatorCallback;
  }

  /**
   * @param properties the properties to set
   */
  public void setProperties(String properties) {
    this.properties = StringUtils.stripToNull(properties);
  }

  /**
   * @param selected the selected to set
   */
  public void setSelected(Object selected) {
    this.selected = selected;
  }

  /**
   * @param style the style to set
   */
  public void setStyle(String style) {
    this.style = StringUtils.stripToNull(style);
  }

  /**
   * @param styleClass the styleClass to set
   */
  public void setStyleClass(String styleClass) {
    this.styleClass = StringUtils.stripToNull(styleClass);
  }
}
