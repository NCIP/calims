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
public class UrlItemTest {
  
  /**
   * Test the default constructor.
   */
  @Test
  public void testDefaultConstructor() {
    UrlItem item = new UrlItem();
    assertNull("Display name not set correctly", item.getDisplayName());
    assertTrue("Enabled flag not set correctly", item.isEnabled());
    assertNull("Url not set correctly", item.getUrl());
    assertFalse("Composite flag not set correctly", item.isComposite());
    assertNull("Children collection not null", item.getChildren());
  }

  /**
   * Test the 2 parameter constructor.
   */
  @Test
  public void test2ParamConstructor() {
    UrlItem item = new UrlItem("dn", "url");
    assertEquals("Display name not set correctly", "dn", item.getDisplayName());
    assertTrue("Enabled flag not set correctly", item.isEnabled());
    assertEquals("Url not set correctly", "url", item.getUrl());
    assertFalse("Composite flag not set correctly", item.isComposite());
    assertNull("Children collection not null", item.getChildren());
  }

  /**
   * Test the 3 parameter constructor.
   */
  @Test
  public void test3ParamConstructor() {
    UrlItem item = new UrlItem("dn", false, "url");
    assertEquals("Display name not set correctly", "dn", item.getDisplayName());
    assertFalse("Enabled flag not set correctly", item.isEnabled());
    assertEquals("Url not set correctly", "url", item.getUrl());
    assertFalse("Composite flag not set correctly", item.isComposite());
    assertNull("Children collection not null", item.getChildren());
  }

  /**
   * Test the url getter and setter.
   */
  @Test
  public void testJavaScriptFunctionSetter() {
    UrlItem item = new UrlItem();
    item.setUrl("jf");
    assertEquals("Url not set correctly", "jf", item.getUrl());
  }

  /**
   * Test the accept method.
   */
  @Test
  public void testAccept() {
    UrlItem item = new UrlItem();
    MenuVisitorMockUp visitor = new MenuVisitorMockUp();
    item.accept(visitor);
    assertEquals("Wrong UrlItem", item, visitor.getUrlItem());
  }
}
