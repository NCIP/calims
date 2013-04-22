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
public abstract class BaseField extends StandaloneFormElement {

  private static final long serialVersionUID = -1767716581540197718L;
  
  private String disabled;
  private boolean invalidMessage;
  private String readOnly;
  private boolean required;
  private Integer tabIndex;
  private String value;

  /**
   * @return the disabled
   */
  public String getDisabled() {
    return disabled;
  }

  /**
   * @param disabled the disabled to set
   */
  public void setDisabled(String disabled) {
    this.disabled = disabled;
  }

  /**
   * @return the invalidMessage
   */
  public boolean isInvalidMessage() {
    return invalidMessage;
  }

  /**
   * @param invalidMessage the invalidMessage to set
   */
  public void setInvalidMessage(boolean invalidMessage) {
    this.invalidMessage = invalidMessage;
  }

  /**
   * @return the readOnly
   */
  public String getReadOnly() {
    return readOnly;
  }

  /**
   * @param readOnly the readOnly to set
   */
  public void setReadOnly(String readOnly) {
    this.readOnly = readOnly;
  }

  /**
   * @return the required
   */
  public boolean isRequired() {
    return required;
  }

  /**
   * @param required the required to set
   */
  public void setRequired(boolean required) {
    this.required = required;
  }

  /**
   * @return the tabIndex
   */
  public Integer getTabIndex() {
    return tabIndex;
  }

  /**
   * @param tabIndex the tabIndex to set
   */
  public void setTabIndex(Integer tabIndex) {
    this.tabIndex = tabIndex;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * {@inheritDoc}
   */
  public BaseField clone() {
    return (BaseField) super.clone();
  }

}
