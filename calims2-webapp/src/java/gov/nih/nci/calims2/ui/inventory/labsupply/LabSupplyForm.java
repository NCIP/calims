/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.labsupply;

import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.LabSupply;
import gov.nih.nci.calims2.domain.inventory.enumeration.LabSupplyStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityFormHelper;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
public class LabSupplyForm extends CRUDForm<LabSupply> {

  private static final long serialVersionUID = 487944283522510518L;

  private Long containerId;
  private Long[] organizationIds;
  private Long[] personIds;
  private QuantityFormHelper quantities = new QuantityFormHelper();
  private String status;
  private Long typeId;

  /**
   * Default constructor.
   */
  public LabSupplyForm() {
    setEntity(new LabSupply());
  }

  /**
   * {@inheritDoc}
   */
  public LabSupply getSubmittedEntity() {
    LabSupply labSupply = getEntity();
    labSupply.setContainer(EntityWithIdHelper.createEntity(Container.class, containerId));
    labSupply.setNotesCollection(getNotesCollection());
    labSupply.setOrganizationCollection(EntityWithIdHelper.createEntities(Organization.class, organizationIds));
    labSupply.setPersonCollection(EntityWithIdHelper.createEntities(Person.class, personIds));
    labSupply.setQuantityCollection(quantities.getQuantities());
    labSupply.setStatus(I18nEnumerationHelper.getByName(LabSupplyStatus.class, status));
    labSupply.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return labSupply;
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
   * @return the organizationIds
   */
  public Long[] getOrganizationIds() {
    return organizationIds;
  }

  /**
   * @param organizationIds the organizationIds to set
   */
  public void setOrganizationIds(Long[] organizationIds) {
    this.organizationIds = organizationIds;
  }

  /**
   * @return the personIds
   */
  public Long[] getPersonIds() {
    return personIds;
  }

  /**
   * @param personIds the personIds to set
   */
  public void setPersonIds(Long[] personIds) {
    this.personIds = personIds;
  }

  /**
   * @return the quantities
   */
  public QuantityFormHelper getQuantities() {
    return quantities;
  }

  /**
   * @param quantities the quantities to set
   */
  public void setQuantities(QuantityFormHelper quantities) {
    this.quantities = quantities;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
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
