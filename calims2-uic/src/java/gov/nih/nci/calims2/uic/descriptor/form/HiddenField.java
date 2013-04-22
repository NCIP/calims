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
 * Representation of a hidden input in a form.
 * 
 * The id property is the id of the input. The name property is the name of the input. The value property is the jstl expression
 * that will be evaluated to generate the value of the input.
 * 
 * @author viseem
 * 
 */
public class HiddenField extends BaseField {

  private static final long serialVersionUID = 2271861112352684408L;

  /**
   * {@inheritDoc}
   */
  public FieldType getType() {
    return FieldType.HIDDEN;
  }

  /**
   * {@inheritDoc}
   */
  public HiddenField clone() {
    return (HiddenField) super.clone();
  }

}
