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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author viseem
 * 
 */
public class JavaScriptItemTest {

  /**
   * Test the default constructor.
   */
  @Test
  public void testDefaultConstructor() {
    JavaScriptItem item = new JavaScriptItem();
    assertNull("Display name not set correctly", item.getDisplayName());
    assertTrue("Enabled flag not set correctly", item.isEnabled());
    assertNull("JavascriptFunction not set correctly", item.getJavascriptFunction());
    assertFalse("Composite flag not set correctly", item.isComposite());
    assertNull("Children collection not null", item.getChildren());
  }

  /**
   * Test the 2 parameters constructor.
   */
  @Test
  public void test2ParamConstructor() {
    JavaScriptItem item = new JavaScriptItem("dn", "jf");
    assertEquals("Display name not set correctly", "dn", item.getDisplayName());
    assertTrue("Enabled flag not set correctly", item.isEnabled());
    assertEquals("JavascriptFunction not set correctly", "jf", item.getJavascriptFunction());
    assertFalse("Composite flag not set correctly", item.isComposite());
    assertNull("Children collection not null", item.getChildren());
  }

  /**
   * Test the 3 parameters constructor.
   */
  @Test
  public void test3ParamConstructor() {
    JavaScriptItem item = new JavaScriptItem("dn", false, "jf");
    assertEquals("Display name not set correctly", "dn", item.getDisplayName());
    assertFalse("Enabled flag not set correctly", item.isEnabled());
    assertEquals("JavascriptFunction not set correctly", "jf", item.getJavascriptFunction());
    assertFalse("Composite flag not set correctly", item.isComposite());
    assertNull("Children collection not null", item.getChildren());
  }

  /**
   * Test the javascript function getter and setter.
   */
  @Test
  public void testJavaScriptFunctionSetter() {
    JavaScriptItem item = new JavaScriptItem();
    item.setJavascriptFunction("jf");
    assertEquals("JavascriptFunction not set correctly", "jf", item.getJavascriptFunction());
  }

  /**
   * Test the accept method.
   */
  @Test
  public void testAccept() {
    JavaScriptItem item = new JavaScriptItem();
    MenuVisitorMockUp visitor = new MenuVisitorMockUp();
    item.accept(visitor);
    assertEquals("Wrong JavaScriptItem", item, visitor.getJavaScriptItem());
  }

}
