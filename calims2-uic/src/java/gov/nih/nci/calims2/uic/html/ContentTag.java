/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.html;

/**
 * Tag class representing a string of content.
 * 
 * @author viseem
 *
 */
public class ContentTag extends BaseTag {

  private static final long serialVersionUID = 821213455795411960L;
  
  private String content;
  private ContentType contentType = ContentType.HTML;

  /**
   * Constructor.
   * @param content The content string.
   */
  public ContentTag(String content) {
    super();
    this.content = content;
  }

  /**
   * @return the content
   */
  public String getContent() {
    return content;
  }
  
  /**
   * @param content the content to set
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * @return the contentType
   */
  public ContentType getContentType() {
    return contentType;
  }

  /**
   * @param contentType the contentType to set
   */
  public void setContentType(ContentType contentType) {
    this.contentType = contentType;
  }

  /**
   * {@inheritDoc}
   */
  public void accept(TagVisitor visitor) {
    visitor.visitContentTag(this);
  }
  
  /**
   * Enumeration of content types.
   * @author viseem
   *
   */
  public static enum ContentType {
    /** CDATA content. */
    CDATA,
    /** Commented CDATA for scripts. */
    COMMENTED_CDATA,
    /** HTML content. */
    HTML,
    /** Raw text content. */
    TEXT;
  }

}
