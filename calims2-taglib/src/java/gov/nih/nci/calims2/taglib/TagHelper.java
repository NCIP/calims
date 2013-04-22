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

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.springframework.web.servlet.support.JspAwareRequestContext;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.html.TagRenderer;

/**
 * Helper class used for common tasks in custom tags.
 * 
 * @author viseem
 *
 */
public class TagHelper {
  
  /**
   * RequestContext resolution method for all related tags.
   * @param context The page context of the page.
   * 
   * @return The current RequestContext;
   */
  public static RequestContext getRequestContext(PageContext context) {
    RequestContext requestContext = (RequestContext) context.getAttribute(RequestContextAwareTag.REQUEST_CONTEXT_PAGE_ATTRIBUTE);
    if (requestContext == null) {
      requestContext = new JspAwareRequestContext(context);
      context.setAttribute(RequestContextAwareTag.REQUEST_CONTEXT_PAGE_ATTRIBUTE, requestContext);
    }
    return requestContext;
  }
  
  /**
   * Output the given tag.
   * @param context The page context of the page.
   * @param tag The tag to output
   * @param pretty True for pretty rendering.
   * @throws JspException If an IO error occurs.
   */
  public static void outputTag(PageContext context, Tag tag, boolean pretty) throws JspException {
    TagRenderer renderer = new TagRenderer(pretty);
    tag.accept(renderer);
    try {
      context.getOut().print(renderer.getMarkup());
    } catch (IOException e) {
      throw new JspException("Writing error in custom Tag", e);
    }
  }
  
}
