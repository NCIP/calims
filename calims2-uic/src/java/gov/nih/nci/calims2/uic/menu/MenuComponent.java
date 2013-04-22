/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.menu;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for dynamic menu components.
 * 
 * This inerface uses the composite design pattern and is implemented by single menu item components as well as composite submenus.
 * 
 * @author viseem
 * 
 */
public interface MenuComponent extends Serializable {
  /**
   * Return the name displayed for this menu item.
   * 
   * @return the name displayed for this menu item.
   */
  String getDisplayName();

  /**
   * Return the children components for this menu item. (Only valid for composite components)
   * 
   * @return the children components for this menu item.
   */
  List<MenuComponent> getChildren();
  
  /**
   * Adds a child to this component. (Only valid for composite components)
   * @param <T> The type of child added
   * 
   * @param child The child component to add
   * @return The component just added.
   */
  <T extends MenuComponent> T addChild(T child);

  /**
   * Test if this item is composite (can have children).
   * 
   * @return true if this item is composite.
   */
  boolean isComposite();

  /**
   * Test if this item is enabled. (Only used for leaf components)
   * 
   * @return true if this item is enabled
   */
  boolean isEnabled();

  /**
   * Set the enabled flag for this item.
   * 
   * @param enabled the new enabled flag
   */
  void setEnabled(boolean enabled);
  
  /**
   * Accepts the given MenuVisitor.
   * @param visitor the MenuVisitor to accept
   */
  void accept(MenuVisitor visitor);

}
