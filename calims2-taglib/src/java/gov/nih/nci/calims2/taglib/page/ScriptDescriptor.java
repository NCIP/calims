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
 * Information about a script.
 * 
 * @author viseem
 * 
 */
public class ScriptDescriptor implements Serializable {

  private static final long serialVersionUID = -685036418245201120L;
  
  private String type;
  private String source;
  private String body;

  /**
   * @param type The type of script
   * @param source The url of the script
   * @param body The body of the script
   */
  public ScriptDescriptor(String type, String source, String body) {
    this.type = type;
    this.source = source;
    this.body = body;
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

}
