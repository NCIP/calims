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

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author viseem
 *
 */
public interface Tag {
  /**
   * Get the prefix of the tag.
   * @return the prefix of the tag.
   */
  String getPrefix();
  
  /**
   * Get the tag name.
   * @return the tag name.
   */
  String getTagName();
  
  /**
   * Return the children tags for this tag. (Only valid for composite tags)
   * 
   * @return the children tags for this tag.
   */
  List<Tag> getChildren();
  
  /**
   * Adds a child to this tag. (Only valid for composite components)
   * @param <T> The type of child added
   * 
   * @param child The child tag to add
   * @return The tag just added.
   */
  <T extends Tag> T addChild(T child);
  
  /**
   * Adds a collection of children to this tag. (Only valid for composite components)
   * @param <T> The type of children added
   * @param children The collection of children to add.
   */
  <T extends Tag> void addChildren(Collection<T> children);

  /**
   * Test if this tag is composite (can have children).
   * 
   * @return true if this tag is composite.
   */
  boolean isComposite();

  /**
   * Adds an attribute to the tag.
   * 
   * @param name The attribute name.
   * @param value The attribute value. If the value provided is null, the attribute is not added.
   * @return The current tag.
   */

  Tag addAttribute(String name, String value);
  
  /**
   * Get the Map of attributes.
   * @return the Map of attributes.
   */
  Map<String, String> getAttributes();

  /**
   * Gets the value of an attribute.
   * 
   * @param name The attribute name.
   * @return The attribute value or null if the attribute has not been set
   */
  String getAttribute(String name);
  
  /**
   * Removes an attribute.
   * 
   * @param name The attribute name.
   * @return The attribute value or null if the attribute has not been set
   */
  String removeAttribute(String name);
  
  /**
   * Accepts the given TagVisitor.
   * 
   * @param visitor the TagVisitor to accept
   */
  void accept(TagVisitor visitor);

}
