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

import java.util.Collection;

import javax.servlet.jsp.JspException;

import gov.nih.nci.calims2.taglib.TagHelper;
import gov.nih.nci.calims2.taglib.page.PageDojoManager;
import gov.nih.nci.calims2.uic.dojo.DojoType;
import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.ContentTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.select.Option;
import gov.nih.nci.calims2.uic.select.OptionCreatorCallback;

/**
 * @author viseem
 * 
 */
public class FilteringSelectTag extends ValidationTextBoxTag {

  private static final long serialVersionUID = 2653068411478916653L;
  
  private OptionManager optionManager = new OptionManager(false);
  private Integer size;

  /**
   * {@inheritDoc}
   */
  public int doStartTag() throws JspException {
    int result = super.doStartTag();
    optionManager.wrapOptions(isReadOnly(), TagHelper.getRequestContext(pageContext));
    return result;
  }

  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    super.reset();
    optionManager = new OptionManager(false);
    size = null;
  }

  /**
   * {@inheritDoc}
   */
  protected void registerTypes(PageDojoManager dojoManager) {
    dojoManager.addDojoType(DojoType.DIJIT_FORM_FILTERINGSELECT.getTypeName());
  }

  /**
   * {@inheritDoc}
   */
  protected Tag createTag() {
    Tag tag = new CompositeTag(HtmlElement.SELECT);
    addAttributes(tag);
    tag.addAttribute("dojoType", DojoType.DIJIT_FORM_FILTERINGSELECT.getTypeName());
    tag.addAttribute("required", Boolean.toString(isRequired()));
    if (size != null) {
      tag.addAttribute("size", size.toString());
    }
    addOptions(tag);
    return tag;
  }

  private void addOptions(Tag tag) {
    for (Option option : optionManager.getOptionsForRendering(TagHelper.getRequestContext(pageContext))) {
      Tag optionTag = tag.addChild(new CompositeTag(HtmlElement.OPTION));
      if (option.isSelected()) {
        optionTag.addAttribute("selected", "selected");
      }
      optionTag.addAttribute("value", option.getId());
      optionTag.addChild(new ContentTag(option.getLabel()));
    }
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
   * @param options the options to set
   */
  public void setOptions(Collection<?> options) {
    optionManager.setOptions(options);
  }

  /**
   * @param selectedOption the selectedOption to set
   */
  public void setSelectedOption(Object selectedOption) {
    optionManager.setSelectedOption(selectedOption);
  }

  /**
   * @param optionCreatorCallback the optionCreatorCallback to set
   */
  public void setOptionCreatorCallback(OptionCreatorCallback<?> optionCreatorCallback) {
    optionManager.setOptionCreatorCallback(optionCreatorCallback);
  }

  /**
   * @param selectKey the selectKey to set
   */
  public void setSelectKey(String selectKey) {
    optionManager.setSelectKey(selectKey);
  }

  /**
   * @param size the size to set
   */
  public void setSize(Integer size) {
    this.size = size;
  }
}
