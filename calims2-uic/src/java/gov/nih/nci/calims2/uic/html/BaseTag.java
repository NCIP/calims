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

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author viseem
 * 
 */
public class BaseTag implements Tag, Serializable {

  private static final long serialVersionUID = -5064234952845944297L;

  private String prefix;
  private String tagName;
  private Map<String, String> attributes = new TreeMap<String, String>();

  /**
   * Default constructor.
   */
  public BaseTag() {
    // Nothing to do
  }

  /**
   * Constructor.
   * 
   * @param tagName The name of the tag.
   */
  public BaseTag(String tagName) {
    this.tagName = tagName;
  }

  /**
   * Constructor.
   * 
   * @param htmlElement The HtmlElement for this tag.
   */
  public BaseTag(HtmlElement htmlElement) {
    this(htmlElement.getTagName());
  }

  /**
   * {@inheritDoc}
   */
  public String getPrefix() {
    return prefix;
  }

  /**
   * {@inheritDoc}
   */
  public String getTagName() {
    return tagName;
  }

  /**
   * {@inheritDoc}
   */
  public List<Tag> getChildren() {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T extends Tag> T addChild(T child) {
    return child;
  }
  
  /**
   * {@inheritDoc}
   */
  public <T extends Tag> void addChildren(Collection<T> children) {
    // Nothing to do
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
  public Tag addAttribute(String name, String value) {
    if (value != null) {
      attributes.put(name, value);
    }
    return this;
  }

  /**
   * {@inheritDoc}
   */
  public Map<String, String> getAttributes() {
    return attributes;
  }

  /**
   * {@inheritDoc}
   */
  public String getAttribute(String name) {
    return attributes.get(name);
  }

  /**
   * {@inheritDoc}
   */
  public String removeAttribute(String name) {
    return attributes.remove(name);
  }

  /**
   * {@inheritDoc}
   */
  public void accept(TagVisitor visitor) {
    visitor.visitBaseTag(this);
  }
}
