/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.generic.crud;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * @author viseem
 * @param <T> The type of persistent entity processed.
 */
public class CRUDFormMockup<T extends EntityWithId> extends CRUDForm<T> {
  
  private static final long serialVersionUID = 1841499977757821807L;
  
  private boolean submittedEntityCalled;

  /**
   * @return the submittedEntityCalled
   */
  public boolean isSubmittedEntityCalled() {
    return submittedEntityCalled;
  }
  
  /**
   * 
   * {@inheritDoc}
   */
  public T getSubmittedEntity() {
    submittedEntityCalled = true;
    return super.getSubmittedEntity();
  }
}
