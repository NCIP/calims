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

/**
 * Information about a link.
 * 
 * @author viseem
 * 
 */
public class LinkDescriptor implements Serializable {

  private static final long serialVersionUID = 6854108077369495779L;
  
  private String type;
  private String href;
  private String rel;
  private String media;

  /**
   * Constructor.
   * 
   * @param type The type of link
   * @param href The target of the link
   * @param rel The type of relationship the link represents.
   * @param media The media to which the link applies.
   */
  public LinkDescriptor(String type, String href, String rel, String media) {
    this.type = type;
    this.href = href;
    this.rel = rel;
    this.media = media;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * @return the rel
   */
  public String getRel() {
    return rel;
  }

  /**
   * @return the media
   */
  public String getMedia() {
    return media;
  }
}
