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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * @author viseem
 * 
 */
public class SubMenuTest {

  /**
   * Test the default constructor.
   */
  @Test
  public void testDefaultConstructor() {
    SubMenu item = new SubMenu();
    assertNull("Display name not set correctly", item.getDisplayName());
    assertTrue("Enabled flag not set correctly", item.isEnabled());
    assertTrue("Composite flag not set correctly", item.isComposite());
    assertNotNull("Wrong children collection", item.getChildren());
    assertEquals("Wrong size of the children collection", 0, item.getChildren().size());
  }

  /**
   * Test the 1 parameter constructor.
   */
  @Test
  public void test1ParamConstructor() {
    SubMenu item = new SubMenu("dn");
    assertEquals("Display name not set correctly", "dn", item.getDisplayName());
    assertTrue("Enabled flag not set correctly", item.isEnabled());
    assertTrue("Composite flag not set correctly", item.isComposite());
    assertNotNull("Wrong children collection", item.getChildren());
    assertEquals("Wrong size of the children collection", 0, item.getChildren().size());
  }

  /**
   * Test the 2 parameters constructor.
   */
  @Test
  public void test2ParamConstructor() {
    SubMenu item = new SubMenu("dn", false);
    assertEquals("Display name not set correctly", "dn", item.getDisplayName());
    assertFalse("Enabled flag not set correctly", item.isEnabled());
    assertTrue("Composite flag not set correctly", item.isComposite());
    assertNotNull("Wrong children collection", item.getChildren());
    assertEquals("Wrong size of the children collection", 0, item.getChildren().size());
  }
  
  /**
   * Test the addChild method.
   */
  @Test
  public void testAddChild() {
    SubMenu menuItem = new SubMenu("display", true);
    MenuItem child = new UrlItem("child", true, "");
    MenuItem result = menuItem.addChild(child);
    assertEquals("Wrong child returned from addChild", child, result);
    List<MenuComponent> children = menuItem.getChildren();
    assertNotNull("Wrong children collection", children);
    assertEquals("Wrong size of the children collection", 1, children.size());
    assertEquals("Wrong child put in children collection", child, children.get(0));
  }
  
  /**
   * Test the accept method.
   */
  @Test
  public void testSubMenuAccept() {
    SubMenu item = new SubMenu();
    MenuVisitorMockUp visitor = new MenuVisitorMockUp();
    item.accept(visitor);
    assertEquals("Wrong SubMenu", item, visitor.getSubMenu());
  }
}
