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
public interface TagVisitor {
  /**
   * Visit a BaseTag instance.
   * 
   * @param baseTag The instance to visit.
   */
  void visitBaseTag(BaseTag baseTag);

  /**
   * Visit a CompositeTag instance.
   * 
   * @param compositeTag The instance to visit.
   */
  void visitCompositeTag(CompositeTag compositeTag);

  /**
   * Visit a BaseTag instance.
   * 
   * @param contentTag The instance to visit.
   */
  void visitContentTag(ContentTag contentTag);

}
