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
 * Representation of a separator in the field list. The form generator can uses this to specify a separation between groups of
 * field.
 * 
 * @author viseem
 * 
 */
public class FieldSeparator extends StandaloneFormElement {

  private static final long serialVersionUID = 3249130945395442319L;

  /**
   * {@inheritDoc}
   */
  public FieldType getType() {
    return FieldType.SEPARATOR;
  }

  /**
   * {@inheritDoc}
   */
  public FieldSeparator clone() {
    return (FieldSeparator) super.clone();
  }
}
