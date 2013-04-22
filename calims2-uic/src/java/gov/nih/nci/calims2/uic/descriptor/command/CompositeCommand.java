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

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Composite command implementation.
 * 
 * Composite commands are usually represented as combobox buttons or contextual menus.
 * 
 * @author viseem
 * 
 */
public class CompositeCommand implements CommandElement {

  private static final long serialVersionUID = 2782125256015641013L;
  
  private List<CommandElement> children = new ArrayList<CommandElement>();

  /**
   * {@inheritDoc}
   */
  public List<CommandElement> getChildren() {
    return children;
  }

  /**
   * {@inheritDoc}
   */
  public <T extends CommandElement> T addChild(T child) {
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
  public CompositeCommand clone() {
    try {
      CompositeCommand clone = (CompositeCommand) super.clone();
      clone.children = new ArrayList<CommandElement>();
      for (CommandElement child : children) {
        clone.addChild(child.clone());
      }
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new InternalError("Can not happen. Subclasses supports clone.");
    }
  }
}
