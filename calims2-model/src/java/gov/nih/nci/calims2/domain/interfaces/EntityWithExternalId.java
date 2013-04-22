/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.domain.interfaces;

import java.util.Set;

/**
 * @author connollym
 *
 */
public interface EntityWithExternalId extends EntityWithId {
  
  /**
   * @return return
   */
  Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> getExternalIdentifierCollection();
  
  /**
   * @param extenalIdentifierCollection
   */
  void setExternalIdentifierCollection(Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> extenalIdentifierCollection);

}
