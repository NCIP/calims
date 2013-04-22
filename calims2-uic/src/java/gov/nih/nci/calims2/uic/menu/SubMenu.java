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

import java.util.ArrayList;
import java.util.List;

/**
 * Composite MnuComponent for SubMenu.
 * 
 * @author viseem
 * 
 */
public class SubMenu extends MenuItem {

  private static final long serialVersionUID = -8614177820852836344L;
  
  private List<MenuComponent> children = new ArrayList<MenuComponent>();
  
  /**
   * Default constructor.
   */
  public SubMenu() {
    super();
  }

  /**
   * Constructor.
   * 
   * @param displayName The display name of the item
   */
  public SubMenu(String displayName) {
    super(displayName);
  }

  /**
   * Constructor.
   * 
   * @param displayName The display name of the item
   * @param enabled true if enabled
   */
  public SubMenu(String displayName, boolean enabled) {
    super(displayName, enabled);
  }

  /**
   * {@inheritDoc}
   */
  public List<MenuComponent> getChildren() {
    return children;
  }

  /**
   * {@inheritDoc}
   */
  public <T extends MenuComponent> T addChild(T child) {
    children.add(child);
    return child;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isComposite() {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  public void accept(MenuVisitor visitor) {
    visitor.visitSubMenu(this);
  }

}
