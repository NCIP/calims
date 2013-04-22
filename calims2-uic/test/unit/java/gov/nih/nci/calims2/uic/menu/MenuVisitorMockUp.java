/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.menu;

/**
 * @author viseem
 * 
 */
public class MenuVisitorMockUp implements MenuVisitor {

  private JavaScriptItem javaScriptItem;
  private SubMenu subMenu;
  private UrlItem urlItem;

  /**
   * {@inheritDoc}
   */
  public void visitJavaScriptItem(JavaScriptItem item) {
    javaScriptItem = item;
  }

  /**
   * {@inheritDoc}
   */
  public void visitSubMenu(SubMenu item) {
    subMenu = item;
  }

  /**
   * {@inheritDoc}
   */
  public void visitUrlItem(UrlItem item) {
    urlItem = item;
  }

  /**
   * @return the javaScriptItem
   */
  public JavaScriptItem getJavaScriptItem() {
    return javaScriptItem;
  }

  /**
   * @return the subMenu
   */
  public SubMenu getSubMenu() {
    return subMenu;
  }

  /**
   * @return the urlItem
   */
  public UrlItem getUrlItem() {
    return urlItem;
  }

}
