/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.html;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * @author viseem
 *
 */
public class BaseTagTest {
  
  /**
   * Test constructor taking a String.
   */
  @Test
  public void testStringConstructor() {
    Tag result = new BaseTag("div");
    assertEquals("Wrong tag name", "div", result.getTagName());
  }
  
  /**
   * Test constructor taking a HtmlElement.
   */
  @Test
  public void testHtmlElementConstructor() {
    Tag result = new BaseTag(HtmlElement.DIV);
    assertEquals("Wrong tag name", "div", result.getTagName());
  }
  
  /**
   * Test the addChild method.
   */
  @Test
  public void testAddChild() {
    Tag tag = new BaseTag();
    Tag child = new BaseTag();
    Tag result = tag.addChild(child);
    assertEquals("Wrong child returned from addChild", child, result);
    assertNull("Wrong children collection", tag.getChildren());
  }
  
  /**
   * Test the isComposite method.
   */
  @Test
  public void testIsComposite() {
    Tag tag = new BaseTag();
    assertFalse("BaseTag reported as composite", tag.isComposite());
  }
  
  /**
   * Test the attribute management methods.
   */
  @Test
  public void testAttributeManagement() {
    Tag tag = new BaseTag("testtag");
    String attributeName = "testAttr";
    String attributeValue = "testValue";
    tag.addAttribute(attributeName, attributeValue);
    assertEquals("Wrong attribute value returned", attributeValue, tag.getAttribute(attributeName));
    assertNotNull("No attribute map", tag.getAttributes());
    assertEquals("Wrong attribute map size", 1, tag.getAttributes().size());
    assertEquals("Wrong attribute in map", attributeValue, tag.getAttributes().get(attributeName));
    tag.removeAttribute(attributeName);
    assertNull("Attribute was not removed", tag.getAttribute(attributeName));
  }
  
  /**
   * Test the addition of a null attribute.
   */
  @Test
  public void testAddNullAttribute() {
    Tag tag = new BaseTag("testtag");
    String attributeName = "testAttr";
    tag.addAttribute(attributeName, null);
    assertNull("Wrong attribute value returned", tag.getAttribute(attributeName));
    assertNotNull("No attribute map", tag.getAttributes());
    assertEquals("Wrong attribute map size", 0, tag.getAttributes().size());
  }
  
  /**
   * Test the accept method.
   */
  @Test
  public void testAccept() {
    Tag tag = new BaseTag(HtmlElement.DIV);
    TagVisitorMockup visitor = new TagVisitorMockup();
    tag.accept(visitor);
    assertEquals("Wrong CompositeTag", tag, visitor.getBaseTag());
  }
  
}
