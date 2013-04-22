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

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

import gov.nih.nci.calims2.taglib.TagHelper;
import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.ContentTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.select.OptionCreatorCallback;

/**
 * A tag that renders a single select view.
 * @author viseem
 * 
 */
public class SelectViewTag extends TagSupport implements TryCatchFinally {

  private static final long serialVersionUID = 8154718964476833410L;
  
  private OptionManager optionManager = new OptionManager(false);
  private String styleClass;

  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    optionManager = new OptionManager(false);
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
  protected Tag createTag() {
    Tag spanTag = new CompositeTag(HtmlElement.SPAN);
    spanTag.addAttribute("class", styleClass);
    spanTag.addChild(new ContentTag(optionManager.getSelectedOptionForView(TagHelper.getRequestContext(pageContext)).getLabel()));
    return spanTag;
  }

  /**
   * @param idProperty the idProperty to set
   */
  public void setIdProperty(String idProperty) {
    optionManager.setIdProperty(idProperty);
  }

  /**
   * @param labelProperty the labelProperty to set
   */
  public void setLabelProperty(String labelProperty) {
    optionManager.setLabelProperty(labelProperty);
  }

  /**
   * @param optionCreatorCallback the optionCreatorCallback to set
   */
  public void setOptionCreatorCallback(OptionCreatorCallback<?> optionCreatorCallback) {
    optionManager.setOptionCreatorCallback(optionCreatorCallback);
  }

  /**
   * @param selectedOption the selectedOption to set
   */
  public void setSelectedOption(Object selectedOption) {
    optionManager.setSelectedOption(selectedOption);
  }

  /**
   * @param styleClass the styleClass to set
   */
  public void setStyleClass(String styleClass) {
    this.styleClass = styleClass;
  }
}
