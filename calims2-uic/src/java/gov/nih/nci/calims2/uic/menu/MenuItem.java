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

import java.util.List;

/**
 * Abstract base implementation of MenuComponent.
 * 
 * It contains the data that is common to composite and leaf components.
 * 
 * @author viseem
 * 
 */
public abstract class MenuItem implements MenuComponent {

  private static final long serialVersionUID = -7844885095511366833L;
  
  private String displayName;
  private boolean enabled = true;
  
  /**
   * Default constructor.
   */
  public MenuItem() {
    super();
  }

  /**
   * Constructor.
   * 
   * @param displayName The display name of the item
   */
  public MenuItem(String displayName) {
    this.displayName = displayName;
  }

  /**
   *  Constructor.
   * 
   * @param displayName The display name of the item
   * @param enabled true if enabled
   */
  public MenuItem(String displayName, boolean enabled) {
    this.displayName = displayName;
    this.enabled = enabled;
  }

  /**
   * {@inheritDoc}
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * {@inheritDoc}
   */
  public List<MenuComponent> getChildren() {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T extends MenuComponent> T addChild(T child) {
    return child;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isComposite() {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * {@inheritDoc}
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

}
