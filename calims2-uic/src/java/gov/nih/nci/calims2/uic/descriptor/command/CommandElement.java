/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.descriptor.command;

import java.io.Serializable;
import java.util.List;

/**
 * Composite interface for cammand objects.
 * 
 * Commands are usually represented as single buttons Composite commands are usually represented as combo box button or contextual
 * menus.
 * 
 * @author viseem
 * 
 */
public interface CommandElement extends Cloneable, Serializable {
  /**
   * Return the children element for this element. (Only valid for composite elements)
   * 
   * @return the children tags for this tag.
   */
  List<CommandElement> getChildren();

  /**
   * Adds a child to this element. (Only valid for composite elements)
   * 
   * @param <T> The type of child added
   * 
   * @param child The child element to add
   * @return The element just added.
   */
  <T extends CommandElement> T addChild(T child);

  /**
   * Test if this tag is composite (can have children).
   * 
   * @return true if this tag is composite.
   */
  boolean isComposite();

  /**
   * clone this CommandElement.
   * 
   * @return A new clone of this CommandElement
   */
  CommandElement clone();

}
