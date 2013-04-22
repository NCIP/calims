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

import java.util.ArrayList;
import java.util.List;


/**
 * @author viseem
 * 
 */
public class CompositeFormElement implements Cloneable, FormElement {

  private static final long serialVersionUID = -8016630976346972680L;
  
  private List<FormElement> children = new ArrayList<FormElement>();

  /**
   * {@inheritDoc}
   */
  public <T extends FormElement> T addChild(T child) {
    children.add(child);
    return child;
  }

  /**
   * {@inheritDoc}
   */
  public List<FormElement> getChildren() {
    return children;
  }

  /**
   * @param children the children to set
   */
  public void setChildren(List<FormElement> children) {
    this.children = children;
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
  public FieldType getType() {
    return FieldType.FORM;
  }

  /**
   * {@inheritDoc}
   */
  public CompositeFormElement clone() {
    try {
      CompositeFormElement clone = (CompositeFormElement) super.clone();
      clone.children = new ArrayList<FormElement>();
      for (FormElement child : children) {
        clone.addChild(child.clone());
      }
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new InternalError("Can not happen. Subclasses supports clone.");
    }
  }

}
