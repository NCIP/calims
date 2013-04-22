/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Helper class to store tags in the request scope for subtags.
 * @author viseem
 * @param <T> The type of tag to store.
 *
 */
public class TagLocator<T extends Tag> {
  
  private String attributeName;
  
  /**
   * Constructor.
   * @param attributeName The attribute name used to save the tag
   */
  public TagLocator(String attributeName) {
    this.attributeName = attributeName;
  }
  
  /**
   * Gets the enclosing tag.
   * 
   * @param pageContext The pageContext of the calling tag
   * @param tag The descendant tag instance
   * @return The enclosing Tag.
   * @throws JspTagException If no Tag is found
   */
  @SuppressWarnings("unchecked")
  public T getTag(PageContext pageContext, TagSupport tag) throws JspTagException {
    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    T parentTag = (T) request.getAttribute(attributeName);
    if (parentTag == null) {
      throw new JspTagException("Enclosing tag not found");
    }
    return parentTag;
  }

  /**
   * Stores the give tag in the request.
   * 
   * @param pageContext The page context
   * @param tag The tag to store
   * @throws JspTagException if a tag is already in the request
   */
  public void saveTag(PageContext pageContext, Tag tag) throws JspTagException {
    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    if (request.getAttribute(attributeName) != null) {
      throw new JspTagException("Tag can not be nested.");
    }
    request.setAttribute(attributeName, tag);
  }
  
  /**
   * Removes the tag attribute from the request.
   * @param pageContext The page context.
   */
  public void removeTag(PageContext pageContext) {
    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    request.removeAttribute(attributeName);
  }
}
