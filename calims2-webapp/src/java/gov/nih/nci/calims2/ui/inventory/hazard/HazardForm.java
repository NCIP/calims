/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.hazard;

import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Hazard;
import gov.nih.nci.calims2.domain.inventory.LabSupply;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;

/**
 * @author viseem
 * 
 */
public class HazardForm extends CRUDForm<Hazard> {

  private static final long serialVersionUID = 3471053523248030297L;
  
  private Long containerId;
  private Long labSupplyId;
  private Long specimenId;
  private Long typeId;

  /**
   * Default constructor.
   */
  public HazardForm() {
    setEntity(new Hazard());
  }

  /**
   * {@inheritDoc}
   */
  public Hazard getSubmittedEntity() {
    Hazard hazard = getEntity();
    hazard.setContainer(EntityWithIdHelper.createEntity(Container.class, containerId));
    hazard.setLabSupply(EntityWithIdHelper.createEntity(LabSupply.class, labSupplyId));
    hazard.setNotesCollection(getNotesCollection());
    hazard.setSpecimen(EntityWithIdHelper.createEntity(Specimen.class, specimenId));
    hazard.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return hazard;
  }

  /**
   * @return the containerId
   */
  public Long getContainerId() {
    return containerId;
  }

  /**
   * @param containerId the containerId to set
   */
  public void setContainerId(Long containerId) {
    this.containerId = containerId;
  }

  /**
   * @return the labSupplyId
   */
  public Long getLabSupplyId() {
    return labSupplyId;
  }

  /**
   * @param labSupplyId the labSupplyId to set
   */
  public void setLabSupplyId(Long labSupplyId) {
    this.labSupplyId = labSupplyId;
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
