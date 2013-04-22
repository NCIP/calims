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

/**
 * @author viseem
 * 
 */
public class TagVisitorMockup implements TagVisitor {

  private BaseTag baseTag;
  private CompositeTag compositeTag;
  private ContentTag contentTag;

  /**
   * {@inheritDoc}
   */
  public void visitBaseTag(BaseTag tag) {
    baseTag = tag;
  }

  /**
   * {@inheritDoc}
   */
  public void visitCompositeTag(CompositeTag tag) {
    compositeTag = tag;
  }

  /**
   * {@inheritDoc}
   */
  public void visitContentTag(ContentTag tag) {
    contentTag = tag;
  }

  /**
   * @return the baseTag
   */
  public BaseTag getBaseTag() {
    return baseTag;
  }

  /**
   * @return the compositeTag
   */
  public CompositeTag getCompositeTag() {
    return compositeTag;
  }

  /**
   * @return the contentTag
   */
  public ContentTag getContentTag() {
    return contentTag;
  }

}
