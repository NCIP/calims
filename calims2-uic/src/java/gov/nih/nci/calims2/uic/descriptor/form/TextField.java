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
public class TextField extends BaseField {

  private static final long serialVersionUID = -8574863760466242773L;
  
  private static final String DEFAULT_FORMAT = "trim";
  private static final int DEFAULT_MAX_LENGTH = 100;

  private String constraints;
  private String format = DEFAULT_FORMAT;
  private int maxLength = DEFAULT_MAX_LENGTH;
  private String pattern;

  /**
   * @return the constraints
   */
  public String getConstraints() {
    return constraints;
  }

  /**
   * @param constraints the constraints to set
   */
  public void setConstraints(String constraints) {
    this.constraints = constraints;
  }

  /**
   * @return the format
   */
  public String getFormat() {
    return format;
  }

  /**
   * @param format the format to set
   */
  public void setFormat(String format) {
    this.format = format;
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
   * @return the pattern
   */
  public String getPattern() {
    return pattern;
  }

  /**
   * @param pattern the pattern to set
   */
  public void setPattern(String pattern) {
    this.pattern = pattern;
  }
  
  /**
   * {@inheritDoc}
   */
  public FieldType getType() {
    return FieldType.TEXT;
  }

  /**
   * {@inheritDoc}
   */
  public TextField clone() {
    return (TextField) super.clone();
  }
}
