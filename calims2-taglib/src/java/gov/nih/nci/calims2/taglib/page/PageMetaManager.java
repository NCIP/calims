/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.taglib.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gov.nih.nci.calims2.uic.html.BaseTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;

/**
 * Helper class to manage meta tags in the PageTag.
 * 
 * @author viseem
 * 
 */
public class PageMetaManager implements Serializable {

  private static final long serialVersionUID = 1761158223173264837L;
  
  private List<Tag> metaTags = new ArrayList<Tag>();

  /**
   * Add a new meta tag to the page.
   * 
   * @param content The content attribute value.
   * @param httpEquiv The http-equiv attribute value.
   * @param name The name attribute value.
   * @param scheme The scheme attribute value.
   */
  public void addMeta(String content, String httpEquiv, String name, String scheme) {
    Tag metaTag = new BaseTag(HtmlElement.META);
    metaTag.addAttribute("content", content);
    metaTag.addAttribute("http-equiv", httpEquiv);
    metaTag.addAttribute("name", name);
    metaTag.addAttribute("scheme", scheme);
    metaTags.add(metaTag);
  }

  /**
   * Renders the scripts in the given head tag.
   * 
   * @param headTag The head tag in which the rendering must be included.
   */
  public void renderMetas(Tag headTag) {
    headTag.addChildren(metaTags);
  }

}
