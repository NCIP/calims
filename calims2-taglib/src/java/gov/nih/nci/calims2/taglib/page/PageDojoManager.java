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
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.ContentTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.html.ContentTag.ContentType;

/**
 * Helper class to manage dojo include and imports in the PageTag.
 * 
 * @author viseem
 * 
 */
public class PageDojoManager implements Serializable {

  private static final long serialVersionUID = 5853094421029044359L;
  
  private boolean includeDojo = false;
  private String config;
  private Set<String> dojoTypes = new TreeSet<String>();
  private Set<String> layers = new LinkedHashSet<String>();

  /**
   * Adds a type to the collection of dojo types to require.
   * 
   * @param type The dojo type to require
   */
  public void addDojoType(String type) {
    dojoTypes.add(type);
  }

  /**
   * Adds a collection of types to the collection of dojo types to require.
   * 
   * @param types The collection of dojo types to require
   */
  public void addDojoTypes(Collection<String> types) {
    dojoTypes.addAll(types);
  }

  /**
   * Adds a layer to the collection of layers to load.
   * 
   * @param layer The name of the layer
   */
  public void addLayer(String layer) {
    layers.add(layer);
  }

  /**
   * Renders the scripts in the given head tag.
   * 
   * @param headTag The head tag in which the rendering must be included.
   * @param context The name of the application context.
   * @param dojoPath The path to the dojo folder in the application
   */
  public void renderDojo(Tag headTag, String context, String dojoPath) {
    if (includeDojo) {
      renderScript(headTag, context, dojoPath);
      renderLayers(headTag, context, dojoPath);
      renderRequire(headTag);
    }
  }

  /**
   * Adds the script that include dojo.
   * 
   * @param headTag The head tag in which the rendering must be included.
   * @param context The name of the application context.
   * @param dojoPath The path to the dojo folder in the application
   */
  private void renderScript(Tag headTag, String context, String dojoPath) {
    Tag scriptTag = headTag.addChild(new CompositeTag(HtmlElement.SCRIPT));
    scriptTag.addAttribute("type", "text/javascript");
    scriptTag.addAttribute("src", context + dojoPath + "/dojo/dojo.js");
    scriptTag.addAttribute("djConfig", config);
  }

  /**
   * Adds the scripts that load the layers.
   * 
   * @param headTag The head tag in which the rendering must be included.
   * @param context The name of the application context.
   * @param dojoPath The path to the dojo folder in the application
   */
  private void renderLayers(Tag headTag, String context, String dojoPath) {
    for (String layer : layers) {
      Tag scriptTag = headTag.addChild(new CompositeTag(HtmlElement.SCRIPT));
      scriptTag.addAttribute("type", "text/javascript");
      scriptTag.addAttribute("src", context + dojoPath + "/" + layer);
    }
  }

  /**
   * Generates the dojo.require statements.
   * 
   * @param headTag The head tag in which the rendering must be included.
   */
  private void renderRequire(Tag headTag) {
    if (!dojoTypes.isEmpty()) {
      Tag scriptTag = headTag.addChild(new CompositeTag(HtmlElement.SCRIPT));
      scriptTag.addAttribute("type", "text/javascript");
      StringBuilder body = new StringBuilder();
      for (String type : dojoTypes) {
        body.append("  dojo.require(\"");
        body.append(type);
        body.append("\");\n");
      }
      ContentTag contentTag = scriptTag.addChild(new ContentTag(body.toString()));
      contentTag.setContentType(ContentType.COMMENTED_CDATA);
    }
  }

  /**
   * @param includeDojo the includeDojo to set
   */
  public void setIncludeDojo(boolean includeDojo) {
    this.includeDojo = includeDojo;
  }

  /**
   * @param config the config to set
   */
  public void setConfig(String config) {
    this.config = config;
  }

}
