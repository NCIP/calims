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
public class DateTimeField extends TextField {

  private static final long serialVersionUID = -6531713290121215349L;
  
  private String formatLength;
  private boolean strict;

  /**
   * @return the formatLength
   */
  public String getFormatLength() {
    return formatLength;
  }

  /**
   * @param formatLength the formatLength to set
   */
  public void setFormatLength(String formatLength) {
    this.formatLength = formatLength;
  }

  /**
   * @return the strict
   */
  public boolean isStrict() {
    return strict;
  }

  /**
   * @param strict the strict to set
   */
  public void setStrict(boolean strict) {
    this.strict = strict;
  }

  /**
   * {@inheritDoc}
   */
  public FieldType getType() {
    return FieldType.DATETIME;
  }

  /**
   * {@inheritDoc}
   */
  public DateTimeField clone() {
    return (DateTimeField) super.clone();
  }

}
