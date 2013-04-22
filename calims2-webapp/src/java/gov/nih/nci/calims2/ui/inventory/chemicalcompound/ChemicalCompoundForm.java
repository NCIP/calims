/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.chemicalcompound;

import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.ChemicalCompound;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Nanomaterial;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;

/**
 * @author connollym
 *
 */
public class ChemicalCompoundForm extends CRUDForm<ChemicalCompound> {

  private static final long serialVersionUID = -6010765931860899363L;

  private Long nanomaterialId;
  private Long containerId;
  /**
   * Default constructor.
   */
  public ChemicalCompoundForm() {
    setEntity(new ChemicalCompound());
  }

  /**
   * {@inheritDoc}
   */
  public ChemicalCompound getSubmittedEntity() {
    ChemicalCompound strain = getEntity();
    strain.setNanomaterial(EntityWithIdHelper.createEntity(Nanomaterial.class, nanomaterialId));
    strain.setContainer(EntityWithIdHelper.createEntity(Container.class, containerId));
    return strain;
  }

  /**
   * @return the nanomaterialId
   */
  public Long getNanomaterialId() {
    return nanomaterialId;
  }

  /**
   * @param nanomaterialId the nanomaterialId to set
   */
  public void setNanomaterialId(Long nanomaterialId) {
    this.nanomaterialId = nanomaterialId;
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

}
