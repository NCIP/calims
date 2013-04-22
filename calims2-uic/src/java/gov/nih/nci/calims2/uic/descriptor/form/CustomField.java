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
public class CustomField extends StandaloneFormElement {

  private static final long serialVersionUID = -4279187494392534746L;
  
  private String customSelector;

  /**
   * @return the customSelector
   */
  public String getCustomSelector() {
    return customSelector;
  }

  /**
   * @param customSelector the customSelector to set
   */
  public void setCustomSelector(String customSelector) {
    this.customSelector = customSelector;
  }

  /**
   * {@inheritDoc}
   */
  public FieldType getType() {
    return FieldType.CUSTOM;
  }

  /**
   * {@inheritDoc}
   */
  public CustomField clone() {
    return (CustomField) super.clone();
  }

}
