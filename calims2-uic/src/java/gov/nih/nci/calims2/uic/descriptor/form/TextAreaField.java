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
public class TextAreaField extends BaseField {

  private static final long serialVersionUID = 2749183694998369917L;
  
  private static final int DEFAULT_MAX_LENGTH = 250;
  private static final int DEFAULT_COLS = 80;
  private static final int DEFAULT_ROWS = 5;
  private int cols = DEFAULT_COLS;
  private int maxLength = DEFAULT_MAX_LENGTH;
  private int rows = DEFAULT_ROWS;

  /**
   * @return the cols
   */
  public int getCols() {
    return cols;
  }

  /**
   * @param cols the cols to set
   */
  public void setCols(int cols) {
    this.cols = cols;
  }

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
   * @return the rows
   */
  public int getRows() {
    return rows;
  }

  /**
   * @param rows the rows to set
   */
  public void setRows(int rows) {
    this.rows = rows;
  }

  /**
   * {@inheritDoc}
   */
  public FieldType getType() {
    return FieldType.TEXTAREA;
  }

  /**
   * {@inheritDoc}
   */
  public TextAreaField clone() {
    return (TextAreaField) super.clone();
  }
}
