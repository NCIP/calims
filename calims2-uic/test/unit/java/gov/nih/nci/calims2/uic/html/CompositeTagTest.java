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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * @author viseem
 * 
 */
public class CompositeTagTest {

  /**
   * Test constructor taking a String.
   */
  @Test
  public void testStringConstructor() {
    Tag tag = new CompositeTag("div");
    assertEquals("Display name not set correctly", "div", tag.getTagName());
    assertTrue("Composite flag not set correctly", tag.isComposite());
    assertNotNull("Wrong children collection", tag.getChildren());
    assertEquals("Wrong size of the children collection", 0, tag.getChildren().size());
  }

  /**
   * Test constructor taking a HtmlElement.
   */
  @Test
  public void testHtmlElementConstructor() {
    Tag tag = new CompositeTag(HtmlElement.DIV);
    assertEquals("Display name not set correctly", "div", tag.getTagName());
    assertTrue("Composite flag not set correctly", tag.isComposite());
    assertNotNull("Wrong children collection", tag.getChildren());
    assertEquals("Wrong size of the children collection", 0, tag.getChildren().size());
  }

  /**
   * Test the addChild method.
   */
  @Test
  public void testAddChild() {
    Tag parent = new CompositeTag(HtmlElement.DIV);
    Tag child = new BaseTag("child");
    Tag result = parent.addChild(child);
    assertEquals("Wrong child returned from addChild", child, result);
    List<Tag> children = parent.getChildren();
    assertNotNull("Wrong children collection", children);
    assertEquals("Wrong size of the children collection", 1, children.size());
    assertEquals("Wrong child put in children collection", child, children.get(0));
  }

  /**
   * Test the isComposite method.
   */
  @Test
  public void testIsComposite() {
    Tag tag = new CompositeTag(HtmlElement.DIV);
    assertTrue("BaseTag reported as not composite", tag.isComposite());
  }

  /**
   * Test the accept method.
   */
  @Test
  public void testAccept() {
    Tag tag = new CompositeTag(HtmlElement.DIV);
    TagVisitorMockup visitor = new TagVisitorMockup();
    tag.accept(visitor);
    assertEquals("Wrong CompositeTag", tag, visitor.getCompositeTag());
  }

}
