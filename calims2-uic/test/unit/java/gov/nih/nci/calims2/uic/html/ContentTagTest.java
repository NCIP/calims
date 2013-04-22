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

import org.junit.Test;

/**
 * @author viseem
 * 
 */
public class ContentTagTest {
  
  /**
   * Test constructor taking a String.
   */
  @Test
  public void testStringConstructor() {
    ContentTag result = new ContentTag("content");
    assertEquals("Wrong content", "content", result.getContent());
  }
  
  /**
   * Test the accept method.
   */
  @Test
  public void testAccept() {
    Tag tag = new ContentTag("");
    TagVisitorMockup visitor = new TagVisitorMockup();
    tag.accept(visitor);
    assertEquals("Wrong CompositeTag", tag, visitor.getContentTag());
  }
}
