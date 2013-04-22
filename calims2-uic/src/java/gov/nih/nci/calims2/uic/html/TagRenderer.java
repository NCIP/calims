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

import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * @author viseem
 *
 */
public class TagRenderer implements TagVisitor {
  
  private boolean pretty = true;
  private String prefix = "";
  private StringBuilder markup = new StringBuilder();
  
  /**
   * Default constructor.
   */
  public TagRenderer() {
    super();
  }

  /**
   * Constructor.
   * @param pretty True for pretty printing.
   */
  public TagRenderer(boolean pretty) {
    this.pretty = pretty;
  }
  
  /**
   * {@inheritDoc}
   */
  public void visitBaseTag(BaseTag baseTag) {
    appendPrefix();
    markup.append(getStartTag(baseTag, true));
    appendEol();
  }

  /**
   * {@inheritDoc}
   */
  public void visitCompositeTag(CompositeTag compositeTag) {
    appendPrefix();
    markup.append(getStartTag(compositeTag, false));
    appendEol();
    prefix += "  ";
    for (Tag child : compositeTag.getChildren()) {
      child.accept(this);
    }
    prefix = prefix.substring(2);
    appendPrefix();
    markup.append(getEndTag(compositeTag));
    appendEol();
  }

  /**
   * {@inheritDoc}
   */
  public void visitContentTag(ContentTag contentTag) {
    appendPrefix();
    markup.append(getFormattedContent(contentTag));
    appendEol();
  }
  
  private String getFormattedContent(ContentTag contentTag) {
    switch (contentTag.getContentType()) {
      case CDATA: {
        return "<![CDATA[" + contentTag.getContent() + "]]>";
      }
      case COMMENTED_CDATA: {
        return "//<![CDATA[\n" + contentTag.getContent() + "\n//]]>";
      }
      case HTML: {
        return StringEscapeUtils.escapeHtml(contentTag.getContent());
      }
      case TEXT: {
        return contentTag.getContent();
      }
      default: {
        throw new IllegalArgumentException("Missing contentType");
      }
    }
  }

  private String getStartTag(Tag tag, boolean closed) {
    StringBuilder buf = new StringBuilder();
    buf.append("<");
    if (tag.getPrefix() != null) {
      buf.append(tag.getPrefix());
      buf.append(":");
    }
    buf.append(tag.getTagName());
    for (Map.Entry<String, String> entry : tag.getAttributes().entrySet()) {
      buf.append(" ");
      buf.append(entry.getKey());
      buf.append("=\"");
      buf.append(StringEscapeUtils.escapeHtml(entry.getValue()));
      buf.append("\"");
    }
    if (closed) {
      buf.append("/");
    }
    buf.append(">");
    return buf.toString();
  }
  
  private String getEndTag(Tag tag) {
    return "</" + tag.getTagName() + ">";
  }
  
  private void appendPrefix() {
    if (pretty) {
      markup.append(prefix);
    }
  }
  
  private void appendEol() {
    if (pretty) {
      markup.append("\n");
    }
  }

  /**
   * Gets the markup a String.
   * @return the markup
   */
  public String getMarkup() {
    return markup.toString();
  }

}
