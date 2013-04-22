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

import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.ContentTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.html.ContentTag.ContentType;

/**
 * Helper class to manage scripts in the PageTag.
 * 
 * @author viseem
 *
 */
class PageScriptManager implements Serializable {
  
  private static final long serialVersionUID = -8055340745547362981L;
  
  private List<ScriptDescriptor> descriptors = new ArrayList<ScriptDescriptor>();
  
  /**
   * Adds a script to the page if it does not exist yet.
   * 
   * @param type The type of script
   * @param source The source of the script
   * @param body The body of the script
   */
  public void addScript(String type, String source, String body) {
    ScriptDescriptor newDescriptor = new ScriptDescriptor(type, source, body);
    if (source != null) {
      for (ScriptDescriptor descriptor : descriptors) {
        if (source.equals(descriptor.getSource())) {
          return;
        }
      }
    }
    descriptors.add(newDescriptor);
  }
  
  /**
   * Renders the scripts in the given head tag.
   * @param headTag The head tag in which the rendering must be included.
   * @param context The name of the application context.
   */
  public void renderScripts(Tag headTag, String context) {
    for (ScriptDescriptor descriptor : descriptors) {
      Tag scriptTag = headTag.addChild(new CompositeTag(HtmlElement.SCRIPT));
      scriptTag.addAttribute("type", descriptor.getType());
      String source = descriptor.getSource();
      if (source != null) {
        scriptTag.addAttribute("src", (source.startsWith("/")) ? context + source : source);
      } else {
        ContentTag bodyTag = scriptTag.addChild(new ContentTag(descriptor.getBody()));
        bodyTag.setContentType(ContentType.COMMENTED_CDATA);
      }
    }

  }
}
