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
public class NumberField extends TextField {

  private static final long serialVersionUID = 7203688139825213272L;

  private static final String DEFAULT_NUMBER_TYPE = "decimal";

  private String min;
  private String max;
  private String numberType = DEFAULT_NUMBER_TYPE;
  private Integer places;

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
    this.max = max;
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
    this.numberType = numberType;
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
    this.min = min;
  }

  /**
   * {@inheritDoc}
   */
  public FieldType getType() {
    return FieldType.NUMBER;
  }

  /**
   * {@inheritDoc}
   */
  public NumberField clone() {
    return (NumberField) super.clone();
  }

}
