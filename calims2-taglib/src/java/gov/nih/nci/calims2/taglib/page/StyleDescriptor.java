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
 * @author viseem
 * 
 */
public class StyleDescriptor implements Serializable {
  
  private static final long serialVersionUID = -1188172333181617186L;

  private String type;
  private String source;
  private String body;
  private String media;

  /**
   * @param type The type of script
   * @param source The url of the script
   * @param body The body of the script
   * @param media The media to which the style applies
   */
  public StyleDescriptor(String type, String source, String body, String media) {
    this.type = type;
    this.source = source;
    this.body = body;
    this.media = media;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * @return the body
   */
  public String getBody() {
    return body;
  }

  /**
   * @return the media
   */
  public String getMedia() {
    return media;
  }
}
