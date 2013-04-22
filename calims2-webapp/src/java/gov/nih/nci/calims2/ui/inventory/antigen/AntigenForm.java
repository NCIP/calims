/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.antigen;

import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Antigen;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;

/**
 * @author connollym
 *
 */
public class AntigenForm extends CRUDForm<Antigen> {

  private static final long serialVersionUID = -6010765931860899363L;

  private Long specimenId;
  private Long typeId;
  /**
   * Default constructor.
   */
  public AntigenForm() {
    setEntity(new Antigen());
  }

  /**
   * {@inheritDoc}
   */
  public Antigen getSubmittedEntity() {
    Antigen antigen = getEntity();
    antigen.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    antigen.setSpecimen(EntityWithIdHelper.createEntity(Specimen.class, specimenId));
    return antigen;
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

  /**
   * @return the specimenId
   */
  public Long getSpecimenId() {
    return specimenId;
  }

  /**
   * @param specimenId the specimenId to set
   */
  public void setSpecimenId(Long specimenId) {
    this.specimenId = specimenId;
  }

}

