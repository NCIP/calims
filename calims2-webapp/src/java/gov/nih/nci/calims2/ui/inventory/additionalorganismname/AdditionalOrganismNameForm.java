/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.additionalorganismname;

import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.AdditionalOrganismName;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;

/**
 * @author connollym
 *
 */
public class AdditionalOrganismNameForm extends CRUDForm<AdditionalOrganismName> {

  private static final long serialVersionUID = -6010765931860899363L;
  
  private Long typeId;

  /**
   * Default constructor.
   */
  public AdditionalOrganismNameForm() {
    setEntity(new AdditionalOrganismName());
  }

  /**
   * {@inheritDoc}
   */
  public AdditionalOrganismName getSubmittedEntity() {
    AdditionalOrganismName additionalOrganismName = getEntity();
    additionalOrganismName.setIsCurrentName(checkBoolean(additionalOrganismName.getIsCurrentName()));
    additionalOrganismName.setNotesCollection(getNotesCollection());
    additionalOrganismName.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return additionalOrganismName;
  }

  /**
   * @return the typeId
   */
  public Long getTypeId() {
    return typeId;
  }

  /**
   * @param typeId the typeId to set
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

}
