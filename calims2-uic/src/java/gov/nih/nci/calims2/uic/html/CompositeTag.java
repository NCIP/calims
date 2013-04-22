/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.html;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Composite Tag.
 * 
 * @author viseem
 * 
 */
public class CompositeTag extends BaseTag {

  private static final long serialVersionUID = -726470989074024795L;
  
  private List<Tag> children = new ArrayList<Tag>();
  
  /**
   * Constructor.
   * 
   * @param tagName The name of the tag.
   */
  public CompositeTag(String tagName) {
    super(tagName);
  }
  
  /**
   * Constructor.
   * 
   * @param htmlElement The HtmlElement for this tag.
   */
  public CompositeTag(HtmlElement htmlElement) {
    super(htmlElement.getTagName());
  }

  /**
   * {@inheritDoc}
   */
  public List<Tag> getChildren() {
    return children;
  }

  /**
   * {@inheritDoc}
   */
  public <T extends Tag> T addChild(T child) {
    children.add(child);
    return child;
  }
  
  /**
   * {@inheritDoc}
   */
  public <T extends Tag> void addChildren(Collection<T> childrenToAdd) {
    if (childrenToAdd != null) {
      children.addAll(childrenToAdd);
    }
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
  public void accept(TagVisitor visitor) {
    visitor.visitCompositeTag(this);
  }

}
