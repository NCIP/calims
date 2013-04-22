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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.taglib.page.PageDojoManager;
import gov.nih.nci.calims2.uic.dojo.DojoType;
import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;

/**
 * @author viseem
 *
 */
public class NumberTag extends ValidationTextBoxTag {
  
  private static final long serialVersionUID = -2139617105422546556L;

  private static final String DEFAULT_NUMBER_TYPE = "decimal";
  
  private String min;
  private String max;
  private String numberType = DEFAULT_NUMBER_TYPE;
  private Integer places;
  
  
  /**
   * Resets the attributes to their default values.
   */
  public void reset() {
    super.reset();
    min = null;
    max = null;
    numberType = DEFAULT_NUMBER_TYPE;
    places = null;
  }

  /**
   * {@inheritDoc}
   */
  protected void registerTypes(PageDojoManager dojoManager) {
    dojoManager.addDojoType(DojoType.DIJIT_FORM_NUMBER_TEXTBOX.getTypeName());
  }
  
  /**
   * {@inheritDoc}
   */
  protected Tag createTag() {
    Tag tag = new CompositeTag(HtmlElement.DIV);
    tag.addAttribute("dojoType", DojoType.DIJIT_FORM_NUMBER_TEXTBOX.getTypeName());
    addAttributes(tag);
    addConstraints(tag);
    tag.addAttribute("trim", "true");
    addMessages(tag);
    return tag;
  }

  /**
   * {@inheritDoc}
   */
  protected void addConstraints(Tag tag) {
    if (getConstraints() != null) {
      tag.addAttribute("constraints", getConstraints());
    } else {
      List<String> constraints = new ArrayList<String>();
      if (min != null) {
        constraints.add("min:" + min);
      }
      if (max != null) {
        constraints.add("max:" + max);
      }
      if (getPattern() != null) {
        constraints.add("pattern:'" + getPattern() + "'");
      }
      if (places != null) {
        constraints.add("places:" + places);
      }
//      if (numberType != null) {
//        constraints.add("type:" + numberType);
//      }
      if (!constraints.isEmpty()) {
        StringBuilder constraint = new StringBuilder("{");
        for (int i = 0; i < constraints.size(); i++) {
          if (i > 0) {
            constraint.append(", ");
          }
          constraint.append(constraints.get(i));
        }
        constraint.append("}");
        tag.addAttribute("constraints", constraint.toString());
      }
    }
    tag.addAttribute("required", Boolean.toString(isRequired()));
    if (getMaxLength() != null) {
      tag.addAttribute("maxLength", getMaxLength().toString());
    }
  }

  /**
   * @return the min
   */
  public String getMin() {
    return min;
  }

  /**
   * @param min the min to set
   */
  public void setMin(String min) {
    this.min = StringUtils.stripToNull(min);
  }

  /**
   * @return the max
   */
  public String getMax() {
    return max;
  }

  /**
   * @param max the max to set
   */
  public void setMax(String max) {
    this.max = StringUtils.stripToNull(max);
  }

  /**
   * @return the numberType
   */
  public String getNumberType() {
    return numberType;
  }

  /**
   * @param numberType the numberType to set
   */
  public void setNumberType(String numberType) {
    this.numberType = StringUtils.stripToNull(numberType);
  }

  /**
   * @return the places
   */
  public Integer getPlaces() {
    return places;
  }

  /**
   * @param places the places to set
   */
  public void setPlaces(Integer places) {
    this.places = places;
  }

}
