/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.select;

import java.io.Serializable;

/**
 * Description of an option for select tags.
 * 
 * @author viseem
 * 
 */
public class Option implements Cloneable, Serializable {

  private static final long serialVersionUID = 1527561028515982844L;
  
  private String id;
  private String label;
  private String labelKey;
  private boolean selected;

  /**
   * @param id The id of the option
   * @param label label of the option
   */
  public Option(String id, String label) {
    this.id = id;
    this.label = label;
  }

  /**
   * @param id The id of the option
   * @param label label of the option
   * @param selected The selected flag of the option
   */
  public Option(String id, String label, boolean selected) {
    this.id = id;
    this.label = label;
    this.selected = selected;
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @return the label
   */
  public String getLabel() {
    return label;
  }

  /**
   * @param label the label to set
   */
  public void setLabel(String label) {
    this.label = label;
  }

  /**
   * @return the labelKey
   */
  public String getLabelKey() {
    return labelKey;
  }

  /**
   * @param labelKey the labelKey to set
   */
  public void setLabelKey(String labelKey) {
    this.labelKey = labelKey;
  }

  /**
   * @return the selected
   */
  public boolean isSelected() {
    return selected;
  }

  /**
   * @param selected the selected to set
   */
  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  /**
   * {@inheritDoc}
   */
  public Option clone() {
    try {
      return (Option) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new InternalError("Can not happen - Supports cloning");
    }
  }
}
