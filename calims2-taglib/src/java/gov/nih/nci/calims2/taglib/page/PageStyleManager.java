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
import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.ContentTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.html.ContentTag.ContentType;

/**
 * Helper class to manage styles in the PageTag.
 * 
 * @author viseem
 * 
 */
class PageStyleManager implements Serializable {
  
  private static final long serialVersionUID = 8698481699552050277L;
  
  private List<StyleDescriptor> descriptors = new ArrayList<StyleDescriptor>();

  /**
   * @param type The type of script
   * @param source The url of the script
   * @param body The body of the script
   * @param media The media to which the style applies
   */
  public void addStyle(String type, String source, String body, String media) {
    StyleDescriptor newDescriptor = new StyleDescriptor(type, source, body, media);
    if (source != null) {
      for (StyleDescriptor descriptor : descriptors) {
        if (source.equals(descriptor.getSource())) {
          return;
        }
      }
    }
    descriptors.add(newDescriptor);
  }
  
  /**
   * Renders the styles in the given head tag.
   * @param headTag The head tag in which the rendering must be included.
   * @param context The name of the application context.
   */
  public void renderStyles(Tag headTag, String context) {
    for (StyleDescriptor descriptor : descriptors) {
      String source = descriptor.getSource();
      if (source != null) {
        Tag linkTag = headTag.addChild(new BaseTag(HtmlElement.LINK));
        linkTag.addAttribute("href", (source.startsWith("/")) ? context + source : source);
        linkTag.addAttribute("rel", "stylesheet");
        linkTag.addAttribute("type", descriptor.getType());
        linkTag.addAttribute("media", descriptor.getMedia());
      } else {
        Tag styleTag = headTag.addChild(new CompositeTag(HtmlElement.STYLE));
        styleTag.addAttribute("rel", "stylesheet");
        styleTag.addAttribute("type", descriptor.getType());
        styleTag.addAttribute("media", descriptor.getMedia());
        ContentTag contentTag = styleTag.addChild(new ContentTag(descriptor.getBody()));
        contentTag.setContentType(ContentType.TEXT);
      }
    }
  }
}
