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
 * @author connollym
 * 
 */
public class CheckBoxField extends BaseField {

  /**
   * 
   */
  private static final long serialVersionUID = 1684768333643410772L;

  /**
   * {@inheritDoc}
   */
  public FieldType getType() {
    return FieldType.CHECKBOX;
  }

  /**
   * {@inheritDoc}
   */
  public CheckBoxField clone() {
    return (CheckBoxField) super.clone();
  }

}
