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

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

/**
 * Tag that include links in the page header.
 * 
 * @author viseem
 *
 */
public class LinkTag extends TagSupport implements TryCatchFinally {
  
  private static final long serialVersionUID = 4286339928742650433L;
  
  private static final String DEFAULT_TYPE = "text/css";
  private static final String DEFAULT_REL = "stylesheet";
  
  private String type = DEFAULT_TYPE;
  private String href;
  private String rel = DEFAULT_REL;
  private String media;
  
  /**
   * Reset all the attributes to their default values.
   */
  private void reset() {
    type = DEFAULT_TYPE;
    href = null;
    rel = DEFAULT_REL;
    media = null;
  }

  /**
   * {@inheritDoc}
   */
  public int doEndTag() throws JspException {
    PageTag pageTag = PageTag.getPageTagLocator().getTag(pageContext, this);
    pageTag.getLinkManager().addLink(type, href, rel, media);
    return EVAL_PAGE;
  }

  /**
   * {@inheritDoc}
   */
  public void doCatch(Throwable throwable) throws Throwable {
    throw throwable;
  }

  /**
   * {@inheritDoc}
   */
  public void doFinally() {
    reset();
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * @param href the href to set
   */
  public void setHref(String href) {
    this.href = href;
  }

  /**
   * @return the rel
   */
  public String getRel() {
    return rel;
  }

  /**
   * @param rel the rel to set
   */
  public void setRel(String rel) {
    this.rel = rel;
  }

  /**
   * @return the media
   */
  public String getMedia() {
    return media;
  }

  /**
   * @param media the media to set
   */
  public void setMedia(String media) {
    this.media = media;
  }

}
