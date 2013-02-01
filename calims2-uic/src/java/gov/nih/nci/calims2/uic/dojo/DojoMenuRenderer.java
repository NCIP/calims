/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The caLIMS2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This caLIMS2 Software License (the License) is between NCI and You. You (or 
 * Your) shall mean a person or an entity, and all other entities that control, 
 * are controlled by, or are under common control with the entity. Control for 
 * purposes of this definition means (i) the direct or indirect power to cause 
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares, 
 * or (iii) beneficial ownership of such entity. 
 *
 * This License is granted provided that You agree to the conditions described 
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up, 
 * no-charge, irrevocable, transferable and royalty-free right and license in 
 * its rights in the caLIMS2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the caLIMS2 Software; (ii) distribute and 
 * have distributed to and by third parties the caLIMS2 Software and any 
 * modifications and derivative works thereof; and (iii) sublicense the 
 * foregoing rights set out in (i) and (ii) to third parties, including the 
 * right to license such rights to further third parties. For sake of clarity, 
 * and not by way of limitation, NCI shall have no right of accounting or right 
 * of payment from You or Your sub-licensees for the rights granted under this 
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the 
 * above copyright notice, this list of conditions and the disclaimer and 
 * limitation of liability of Article 6, below. Your redistributions in object 
 * code form must reproduce the above copyright notice, this list of conditions 
 * and the disclaimer of Article 6 in the documentation and/or other materials 
 * provided with the distribution, if any. 
 *
 * Your end-user documentation included with the redistribution, if any, must 
 * include the following acknowledgment: This product includes software 
 * developed by Moxie Informatics and the National Cancer Institute. If You do not include 
 * such end-user documentation, You shall include this acknowledgment in the 
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "Moxie Informatics" 
 * to endorse or promote products derived from this Software. This License does 
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or Moxie Informatics, except as required to comply with the 
 * terms of this License. 
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this 
 * Software into Your proprietary programs and into any third party proprietary 
 * programs. However, if You incorporate the Software into third party 
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software 
 * into such third party proprietary programs and for informing Your 
 * sub-licensees, including without limitation Your end-users, of their 
 * obligation to secure any required permissions from such third parties before 
 * incorporating the Software into such third party proprietary software 
 * programs. In the event that You fail to obtain such permissions, You agree 
 * to indemnify NCI for any claims against NCI by such third parties, except to 
 * the extent prohibited by law, resulting from Your failure to obtain such 
 * permissions. 
 *
 * For sake of clarity, and not by way of limitation, You may add Your own 
 * copyright statement to Your modifications and to the derivative works, and 
 * You may provide additional or different license terms and conditions in Your 
 * sublicenses of modifications of the Software, or any derivative works of the 
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, 
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, 
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO 
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, MOXIE INFORMATICS OR THEIR 
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
