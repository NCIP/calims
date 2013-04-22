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
public interface MenuVisitor {
  /**
   * Visit a JavaScriptItem instance.
   * 
   * @param javaScriptItem The JavaScriptItem instance to visit.
   */
  void visitJavaScriptItem(JavaScriptItem javaScriptItem);

  /**
   * Visit a SubMenu instance.
   * 
   * @param subMenu The SubMenu instance to visit.
   */
  void visitSubMenu(SubMenu subMenu);

  /**
   * Visit a UrlItem instance.
   * 
   * @param urlItem The UrlItem instance to visit.
   */
  void visitUrlItem(UrlItem urlItem);

}
