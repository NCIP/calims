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
 * Helper class to manage links in the PageTag.
 * 
 * @author viseem
 *
 */
class PageLinkManager implements Serializable {
  
  private static final long serialVersionUID = 8556450939118219385L;
  
  private List<LinkDescriptor> descriptors = new ArrayList<LinkDescriptor>();
  
  /**
   * Adds a link to the page if it does not exist yet.
   * 
   * @param type The type of link
   * @param href The target of the link
   * @param rel The type of relationship the link represents.
   * @param media The media to which the link applies.
   */
  public void addLink(String type, String href, String rel, String media) {
    LinkDescriptor newDescriptor = new LinkDescriptor(type, href, rel, media);
    for (LinkDescriptor descriptor : descriptors) {
      if (href.equals(descriptor.getHref())) {
        return;
      }
    }
    descriptors.add(newDescriptor);
  }
  
  /**
   * Renders the links in the given head tag.
   * @param headTag The head tag in which the rendering must be included.
   */
  public void renderLinks(Tag headTag) {
    for (LinkDescriptor descriptor : descriptors) {
      Tag linkTag = headTag.addChild(new BaseTag(HtmlElement.LINK));
      linkTag.addAttribute("type", descriptor.getType());
      linkTag.addAttribute("href", descriptor.getHref());
      linkTag.addAttribute("rel", descriptor.getRel());
      linkTag.addAttribute("media", descriptor.getMedia());
    }
  }
}
