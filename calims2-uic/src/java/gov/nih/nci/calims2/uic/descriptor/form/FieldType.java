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
public enum FieldType {
  /** Checkbox field. */
  CHECKBOX,
  /** Custom field. */
  CUSTOM,
  /** Date field. */
  DATE,
  /** DateTime field. */
  DATETIME,
  /** Form tab element.*/
  FORM_TAB,
  /** File Input element. */
  FILE_INPUT,
  /** Form element. */
  FORM,
  /** hidden field. */
  HIDDEN,
  /** multi select field. */
  MULTI_SELECT,
  /** Number field. */
  NUMBER,
  /** single select field. */
  SELECT,
  /** separator field. */
  SEPARATOR,
  /** single select field. */
  SINGLE_SELECT,
  /** text field. */
  TEXT,
  /** text field. */
  TEXTAREA,
  /** time field. */
  TIME;
  
  /**
   * Return the name of the value.
   * 
   * @return The name of the value.
   */
  public String getName() {
    return name();
  }
}
