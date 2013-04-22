/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.dojo;

import java.util.HashSet;
import java.util.Set;

import gov.nih.nci.calims2.uic.html.CompositeTag;
import gov.nih.nci.calims2.uic.html.ContentTag;
import gov.nih.nci.calims2.uic.html.HtmlElement;
import gov.nih.nci.calims2.uic.html.Tag;
import gov.nih.nci.calims2.uic.html.TagRenderer;
import gov.nih.nci.calims2.uic.menu.JavaScriptItem;
import gov.nih.nci.calims2.uic.menu.MenuComponent;
import gov.nih.nci.calims2.uic.menu.MenuItem;
import gov.nih.nci.calims2.uic.menu.MenuVisitor;
import gov.nih.nci.calims2.uic.menu.SubMenu;
import gov.nih.nci.calims2.uic.menu.UrlItem;

/**
 * @author viseem
 * 
 */
public class DojoMenuRenderer implements MenuVisitor {

  private static final String HEADER_SCRIPT = "  dojo.require(\"dijit.MenuBar\");\n"
      + "  dojo.require(\"dijit.PopupMenuBarItem\");\n" 
      + "  dojo.require(\"dijit.Menu\");\n"
      + "  dojo.require(\"dijit.MenuItem\");\n" 
      + "  dojo.require(\"dijit.MenuBarItem\");\n" 
      + "  dojo.require(\"dijit.PopupMenuItem\");\n\n";

  private static final String GOTO_URL = "  function goToUrl(url) {\n" 
                                       + "    location.href = url;\n" 
                                       + "  }\n";

  private String id;
  private boolean renderScript;
  private String context;

  private int depth;
  private StringBuilder html = new StringBuilder();
  private Tag parent;

  /**
   * Constructor.
   * 
   * @param id The id to give to the root element of the menu.
   * @param renderScript true if the header script must be rendered
   * @param context The name of the application context for generating the URLs
   */
  public DojoMenuRenderer(String id, boolean renderScript, String context) {
    this.id = id;
    this.renderScript = renderScript;
    this.context = context;
  }

  /**
   * {@inheritDoc}
   */
  public void visitJavaScriptItem(JavaScriptItem javaScriptItem) {
    String onClick = null;
    if (javaScriptItem.isEnabled()) {
      onClick = javaScriptItem.getJavascriptFunction();
    }
    renderItem(javaScriptItem, onClick);
  }

  /**
   * {@inheritDoc}
   */
  public void visitSubMenu(SubMenu subMenu) {
    if (depth == 0) {
      renderMenuBar(subMenu);
      return;
    }
    if (depth == 1) {
      renderSubMenu(subMenu, DojoType.DIJIT_POPUP_MENUBARITEM);
    } else {
      renderSubMenu(subMenu, DojoType.DIJIT_POPUP_MENUITEM);
    }
  }

  private void renderMenuBar(SubMenu subMenu) {
    TagRenderer tagRenderer = new TagRenderer();
    renderHeaderScript(tagRenderer);
    renderJavaScript(tagRenderer);
    Tag menuBar = new CompositeTag(HtmlElement.DIV);
    menuBar.addAttribute("id", id);
    menuBar.addAttribute("dojoType", DojoType.DIJIT_MENUBAR.getTypeName());
    renderChildren(subMenu, menuBar);
    menuBar.accept(tagRenderer);
    html.append(tagRenderer.getMarkup());
  }

  private void renderHeaderScript(TagRenderer tagRenderer) {
    if (renderScript) {
      Tag script = new CompositeTag(HtmlElement.SCRIPT);
      script.addAttribute("type", "text/javascript");
      script.addChild(new ContentTag(HEADER_SCRIPT));
      script.accept(tagRenderer);
    }
  }

  private void renderJavaScript(TagRenderer tagRenderer) {
    Tag script = new CompositeTag(HtmlElement.SCRIPT);
    script.addAttribute("type", "text/javascript");
    script.addChild(new ContentTag(GOTO_URL));
    script.accept(tagRenderer);
  }

  private void renderSubMenu(SubMenu subMenu, DojoType menuType) {
    Tag subMenuTag = parent.addChild(new CompositeTag(HtmlElement.DIV));
    subMenuTag.addAttribute("dojoType", menuType.getTypeName());
    Tag spanTag = subMenuTag.addChild(new CompositeTag(HtmlElement.SPAN));
    spanTag.addChild(new ContentTag(subMenu.getDisplayName()));
    Tag menuTag = subMenuTag.addChild(new CompositeTag(HtmlElement.DIV));
    menuTag.addAttribute("dojoType", DojoType.DIJIT_MENU.getTypeName());
    renderChildren(subMenu, menuTag);
  }

  /**
   * Renders the children of the given SubMenu.
   * 
   * @param subMenu
   */
  private void renderChildren(SubMenu subMenu, Tag newParent) {
    Tag savedParent = parent;
    parent = newParent;
    depth++;
    for (MenuComponent child : subMenu.getChildren()) {
      child.accept(this);
    }
    depth--;
    parent = savedParent;
  }

  /**
   * {@inheritDoc}
   */
  public void visitUrlItem(UrlItem urlItem) {
    String onClick = null;
    if (urlItem.isEnabled()) {
      String url = (urlItem.getUrl().startsWith("/")) ? context + urlItem.getUrl() : urlItem.getUrl();
      onClick = "goToUrl('" + url + "');";
    }
    renderItem(urlItem, onClick);
  }

  private void renderItem(MenuItem item, String onClick) {
    Tag tag = parent.addChild(new CompositeTag(HtmlElement.DIV));
    DojoType itemType = (depth == 1) ? DojoType.DIJIT_MENUBARITEM : DojoType.DIJIT_MENUITEM;
    tag.addAttribute("dojoType", itemType.getTypeName());
    tag.addAttribute("onclick", onClick);
    tag.addChild(new ContentTag(item.getDisplayName()));
  }

  /**
   * Get the html result as a String.
   * 
   * @return the html result as a String.
   */
  public String getHtml() {
    return html.toString();
  }

  /**
   * Gets the set of required types.
   * 
   * @return the set of required types.
   */
  public Set<String> getRequiredTypes() {
    Set<String> types = new HashSet<String>();
    types.add(DojoType.DIJIT_MENU.getTypeName());
    types.add(DojoType.DIJIT_MENUBAR.getTypeName());
    types.add(DojoType.DIJIT_MENUITEM.getTypeName());
    types.add(DojoType.DIJIT_POPUP_MENUBARITEM.getTypeName());
    types.add(DojoType.DIJIT_POPUP_MENUITEM.getTypeName());
    return types;
  }
}
