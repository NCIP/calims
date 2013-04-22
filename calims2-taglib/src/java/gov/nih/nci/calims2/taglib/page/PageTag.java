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

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;

import gov.nih.nci.calims2.taglib.TagLocator;
import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.ContentTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.HtmlVersion;
import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.html.TagRenderer;
import gov.nih.nci.calims2.uic.html.ContentTag.ContentType;

/**
 * Tag that generates an entire page.
 * 
 * This tag generate an entire page based on state that was set by other included tags.
 * 
 * This tag also solves the buffer overflow problem by buffering the content of the page before sending it to the client.
 * 
 * @author viseem
 * 
 */
public class PageTag extends BodyTagSupport implements TryCatchFinally {

  private static final long serialVersionUID = -8512628641586676258L;

  private static final HtmlVersion DEFAULT_HTML_VERSION = HtmlVersion.XHTML10_STRICT;
  
  private static TagLocator<PageTag> pageTagLocator = new TagLocator<PageTag>(PageTag.class.getName());
  
  private HtmlVersion version = DEFAULT_HTML_VERSION;

  private String title;
  
  private PageMetaManager metaManager = new PageMetaManager();
  
  private PageLinkManager linkManager = new PageLinkManager();

  private PageScriptManager scriptManager = new PageScriptManager();
  
  private PageStyleManager styleManager = new PageStyleManager();
  
  private PageDojoManager dojoManager = new PageDojoManager();
  
  /**
   * @return the pageTagLocator
   */
  public static TagLocator<PageTag> getPageTagLocator() {
    return pageTagLocator;
  }

  /**
   * @param pageTagLocator the pageTagLocator to set
   */
  public static void setPageTagLocator(TagLocator<PageTag> pageTagLocator) {
    PageTag.pageTagLocator = pageTagLocator;
  }
  
  /**
   * Reset all the attributes to their default values.
   */
  private void reset() {
    version = DEFAULT_HTML_VERSION;
    title = null;
    metaManager = new PageMetaManager();
    linkManager = new PageLinkManager();
    scriptManager = new PageScriptManager();
    styleManager = new PageStyleManager();
    dojoManager = new PageDojoManager();
  }
  
  /**
   * {@inheritDoc}
   */
  public int doStartTag() throws JspException {
    pageTagLocator.saveTag(pageContext, this);
    return EVAL_BODY_BUFFERED;
  }

  /**
   * {@inheritDoc}
   */
  public int doEndTag() throws JspException {
    StringBuilder html = new StringBuilder();
    html.append(version.getDtd());
    html.append("\n");
    Tag htmlTag = new CompositeTag(HtmlElement.HTML);
    htmlTag.addChild(renderHeader());
    BodyContent content = getBodyContent();
    ContentTag contentTag = htmlTag.addChild(new ContentTag(content.getString()));
    contentTag.setContentType(ContentType.TEXT);
    TagRenderer renderer = new TagRenderer();
    htmlTag.accept(renderer);
    html.append(renderer.getMarkup());
    try {
      content.getEnclosingWriter().print(html.toString());
    } catch (IOException e) {
      throw new JspException(e);
    }
    pageTagLocator.removeTag(pageContext);
    return EVAL_PAGE;
  }

  private Tag renderHeader() {
    HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
    String context = request.getContextPath();
    Tag headTag = new CompositeTag(HtmlElement.HEAD);
    renderTitle(headTag);
    metaManager.renderMetas(headTag);
    linkManager.renderLinks(headTag);
    styleManager.renderStyles(headTag, context);
    dojoManager.renderDojo(headTag, context, (String) pageContext.findAttribute("dojoPath"));
    scriptManager.renderScripts(headTag, context);
    return headTag;
  }

  private void renderTitle(Tag headTag) {
    if (title != null) {
      Tag titleTag = headTag.addChild(new CompositeTag(HtmlElement.TITLE));
      titleTag.addChild(new ContentTag(title));
    }
  }
  
  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @param version the version to set
   */
  public void setVersion(String version) {
    this.version = HtmlVersion.valueOf(version);
  }

  /**
   * @return the metaManager
   */
  public PageMetaManager getMetaManager() {
    return metaManager;
  }

  /**
   * @return the linkManager
   */
  public PageLinkManager getLinkManager() {
    return linkManager;
  }

  /**
   * @return the scriptManager
   */
  public PageScriptManager getScriptManager() {
    return scriptManager;
  }

  /**
   * @return the styleManager
   */
  public PageStyleManager getStyleManager() {
    return styleManager;
  }

  /**
   * @return the dojoManager
   */
  public PageDojoManager getDojoManager() {
    return dojoManager;
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
}
