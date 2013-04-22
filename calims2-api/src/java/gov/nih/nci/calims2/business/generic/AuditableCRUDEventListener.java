/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.generic;

import org.joda.time.DateTime;

import gov.nih.nci.calims2.domain.interfaces.Auditable;
import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * @author viseem
 * @param <T> The type of Entity being processed.
 */
public class AuditableCRUDEventListener<T extends Auditable> extends NullCRUDEventListener<T> {

  private static final String[] DEFAULT_EXCLUDED_PROPERTIES = new String[] {"dateCreated", "createdBy", "dateModified",
      "modifiedBy" };

  private PrivilegeEvaluator privilegeEvaluator;

  /**
   * Default constructor.
   */
  public AuditableCRUDEventListener() {
    setAdditionalExcludedProperties(DEFAULT_EXCLUDED_PROPERTIES);
  }

  /**
   * {@inheritDoc}
   */
  public T beforeCreate(T inputEntity) {
    T entity = super.beforeCreate(inputEntity);
    entity.setDateCreated(new DateTime());
    entity.setCreatedBy(privilegeEvaluator.getCurrentUsername());
    return entity;
  }

  /**
   * {@inheritDoc}
   */
  public T beforeUpdate(T inputEntity, T existingEntity) {
    T entity = super.beforeUpdate(inputEntity, existingEntity);
    entity.setDateModified(new DateTime());
    entity.setModifiedBy(privilegeEvaluator.getCurrentUsername());
    return entity;
  }

  /**
   * @return the privilegeEvaluator
   */
  protected PrivilegeEvaluator getPrivilegeEvaluator() {
    return privilegeEvaluator;
  }

  /**
   * @param privilegeEvaluator the privilegeEvaluator to set
   */
  public void setPrivilegeEvaluator(PrivilegeEvaluator privilegeEvaluator) {
    this.privilegeEvaluator = privilegeEvaluator;
  }
}
