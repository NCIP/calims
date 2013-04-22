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

import java.io.Serializable;
import java.util.List;


/**
 * @author viseem
 * 
 */
public interface FormElement extends Cloneable, Serializable {
  /**
   * Return the children element for this element. (Only valid for composite elements)
   * 
   * @return the children tags for this tag.
   */
  List<FormElement> getChildren();

  /**
   * Adds a child to this element. (Only valid for composite elements)
   * 
   * @param <T> The type of child added
   * 
   * @param child The child element to add
   * @return The element just added.
   */
  <T extends FormElement> T addChild(T child);

  /**
   * Test if this tag is composite (can have children).
   * 
   * @return true if this tag is composite.
   */
  boolean isComposite();

  /**
   * Get the type of element.
   * 
   * @return the type of element.
   */
  FieldType getType();

  /**
   * clone this FormElement.
   * 
   * @return A new clone of this FormElement
   */
  FormElement clone();
}
