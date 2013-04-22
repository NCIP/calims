/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.descriptor.form;



/**
 * @author viseem
 * 
 */
public class SelectField extends BaseField {

  private static final long serialVersionUID = 8925048596300603998L;
  
  private String idProperty;
  private String labelProperty;
  private boolean multiple;
  private String optionCreatorCallback;
  private String options;
  private String selected;
  private String selectKey;
  private Integer size;

  /**
   * @return the idProperty
   */
  public String getIdProperty() {
    return idProperty;
  }

  /**
   * @param idProperty the idProperty to set
   */
  public void setIdProperty(String idProperty) {
    this.idProperty = idProperty;
  }

  /**
   * @return the labelProperty
   */
  public String getLabelProperty() {
    return labelProperty;
  }

  /**
   * @param labelProperty the labelProperty to set
   */
  public void setLabelProperty(String labelProperty) {
    this.labelProperty = labelProperty;
  }

  /**
   * @return the multiple
   */
  public boolean isMultiple() {
    return multiple;
  }

  /**
   * @param multiple the multiple to set
   */
  public void setMultiple(boolean multiple) {
    this.multiple = multiple;
  }

  /**
   * @return the optionCreatorCallback
   */
  public String getOptionCreatorCallback() {
    return optionCreatorCallback;
  }

  /**
   * @param optionCreatorCallback the optionCreatorCallback to set
   */
  public void setOptionCreatorCallback(String optionCreatorCallback) {
    this.optionCreatorCallback = optionCreatorCallback;
  }

  /**
   * @return the options
   */
  public String getOptions() {
    return options;
  }

  /**
   * @param options the options to set
   */
  public void setOptions(String options) {
    this.options = options;
  }

  /**
   * @return the selected
   */
  public String getSelected() {
    return selected;
  }

  /**
   * @param selected the selected to set
   */
  public void setSelected(String selected) {
    this.selected = selected;
  }

  /**
   * @return the selectKey
   */
  public String getSelectKey() {
    return selectKey;
  }

  /**
   * @param selectKey the selectKey to set
   */
  public void setSelectKey(String selectKey) {
    this.selectKey = selectKey;
  }

  /**
   * @return the size
   */
  public Integer getSize() {
    return size;
  }

  /**
   * @param size the size to set
   */
  public void setSize(Integer size) {
    this.size = size;
  }

  /**
   * @return the type
   */
  public FieldType getType() {
    return (multiple) ? FieldType.MULTI_SELECT : FieldType.SELECT;
  }

  /**
   * {@inheritDoc}
   */
  public SelectField clone() {
    return (SelectField) super.clone();
  }
}
