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
public class FileInputField extends BaseField {

/**
   * 
   */
  private static final long serialVersionUID = -800147232919344267L;
  private static final int DEFAULT_MAX_LENGTH = 100;
  private int maxLength = DEFAULT_MAX_LENGTH;

  /**
   * @return the maxLength
   */
  public int getMaxLength() {
    return maxLength;
  }

  /**
   * @param maxLength the maxLength to set
   */
  public void setMaxLength(int maxLength) {
    this.maxLength = maxLength;
  }  
  
/**
 * {@inheritDoc}
 */
  public FieldType getType() {
    return FieldType.FILE_INPUT;
  }
  
  /**
   * {@inheritDoc}
   */
  public FileInputField clone() {
    return (FileInputField) super.clone();
  }

}
