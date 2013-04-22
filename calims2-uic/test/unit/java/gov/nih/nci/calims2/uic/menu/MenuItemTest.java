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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author viseem
 * 
 */
public class MenuItemTest {

  /**
   * Test the default constructor.
   */
  @Test
  public void testDefaultConstructor() {
    MenuItem item = new TestItem();
    assertNull("Display name not set correctly", item.getDisplayName());
    assertTrue("Enabled flag not set correctly", item.isEnabled());
    assertFalse("Composite flag not set correctly", item.isComposite());
    assertNull("Wrong children collection", item.getChildren());
  }

  /**
   * Test the 1 parameter constructor.
   */
  @Test
  public void test1ParamConstructor() {
    MenuItem item = new TestItem("dn");
    assertEquals("Display name not set correctly", "dn", item.getDisplayName());
    assertTrue("Enabled flag not set correctly", item.isEnabled());
    assertFalse("Composite flag not set correctly", item.isComposite());
    assertNull("Wrong children collection", item.getChildren());
  }

  /**
   * Test the 2 parameters constructor.
   */
  @Test
  public void test2ParamConstructor() {
    MenuItem item = new TestItem("dn", false);
    assertEquals("Display name not set correctly", "dn", item.getDisplayName());
    assertFalse("Enabled flag not set correctly", item.isEnabled());
    assertFalse("Composite flag not set correctly", item.isComposite());
    assertNull("Wrong children collection", item.getChildren());
  }

  /**
   * Test the addChild method.
   */
  @Test
  public void testAddChild() {
    MenuItem item = new TestItem();
    MenuItem child = new TestItem("child", true);
    MenuItem result = item.addChild(child);
    assertEquals("Wrong child returned from addChild", child, result);
    assertNull("Wrong children collection", item.getChildren());
  }
  
  /**
   * Test the isComposite method.
   */
  @Test
  public void testIsComposite() {
    MenuItem item = new TestItem();
    assertFalse("MenuItem reported as composite", item.isComposite());
  }

  /**
   * Test the enabled getter/setter methods.
   */
  @Test
  public void testEnabled() {
    MenuItem item = new TestItem();
    item.setEnabled(false);
    assertFalse("Enabled flag not set correctly", item.isEnabled());
  }

  /**
   * Static subclass of MenuItem to test the default implementations.
   * 
   * @author viseem
   * 
   */
  private class TestItem extends MenuItem {

    private static final long serialVersionUID = -5746212522924772465L;

    /**
     * Constructor.
     */
    public TestItem() {
      super();
    }

    /**
     * Constructor.
     * 
     * @param displayName The display name of the item
     */
    public TestItem(String displayName) {
      super(displayName);
    }

    /**
     * Constructor.
     * 
     * @param displayName The display name of the item
     * @param enabled true if enabled
     */
    public TestItem(String displayName, boolean enabled) {
      super(displayName, enabled);
    }

    /**
     * {@inheritDoc}
     */
    public void accept(MenuVisitor visitor) {
      // Nothing to do
    }

  }

}
