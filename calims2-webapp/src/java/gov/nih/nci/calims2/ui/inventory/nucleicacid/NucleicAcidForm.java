/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.nucleicacid;

import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem;
import gov.nih.nci.calims2.domain.common.ExternalIdentifier;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.NucleicAcid;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityFormHelper;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author connollym
 *
 */
public class NucleicAcidForm extends CRUDForm<NucleicAcid> {

  private static final long serialVersionUID = -6010765931860899363L;

  private Long containerId;
  private Long containerCategoryId;
  private Long containerSubcategoryId;
  private Long containerTypeId;
  private Long[] externalIdentifierIds;
  private Long fillPatternId;
  private Long[] locationIds;
  private Long[] organizationIds;
  private Long personId;
  private QuantityFormHelper quantities = new QuantityFormHelper();
  private Long specimenId;
  private Long taxonId;
  private Long typeId;
  
  
  

  /**
   * Default constructor.
   */
  public NucleicAcidForm() {
    setEntity(new NucleicAcid());
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public NucleicAcid getSubmittedEntity() {
    NucleicAcid nucleicAcid = getEntity();
    StackFrame frame = FlowContextHolder.getContext().peek();
    Class<? extends EntityWithId> persistentClass = (Class<? extends EntityWithId>) frame.getAttribute("persistentClass");
    Long id = (Long) frame.getAttribute("id");
    if (persistentClass == ServiceItem.class) {
      nucleicAcid.setServiceItem(EntityWithIdHelper.createEntity(ServiceItem.class, id));
    }
    nucleicAcid.setContainer(EntityWithIdHelper.createEntity(Container.class, containerId));
    nucleicAcid.setContactPerson(EntityWithIdHelper.createEntity(Person.class, personId));
    nucleicAcid.setExternalIdentifierCollection(EntityWithIdHelper.createEntities(ExternalIdentifier.class, 
        externalIdentifierIds));
    nucleicAcid.setIsAvailable(checkBoolean(nucleicAcid.getIsAvailable()));
    nucleicAcid.setNotesCollection(getNotesCollection());
    nucleicAcid.setOrganizationCollection(EntityWithIdHelper.createEntities(Organization.class, organizationIds));
    nucleicAcid.setParentSpecimen(EntityWithIdHelper.createEntity(Specimen.class, specimenId));
    nucleicAcid.setQuantityCollection(quantities.getQuantities());
    nucleicAcid.setSamplingLocationCollection(EntityWithIdHelper.createEntities(Location.class, locationIds));
    nucleicAcid.setTaxon(EntityWithIdHelper.createEntity(Taxon.class, taxonId));
    nucleicAcid.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return nucleicAcid;
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
   * @return the containerCategoryId
   */
  public Long getContainerCategoryId() {
    return containerCategoryId;
  }

  /**
   * @param containerCategoryId the containerCategoryId to set
   */
  public void setContainerCategoryId(Long containerCategoryId) {
    this.containerCategoryId = containerCategoryId;
  }

  /**
   * @return the containerSubcategoryId
   */
  public Long getContainerSubcategoryId() {
    return containerSubcategoryId;
  }

  /**
   * @param containerSubcategoryId the containerSubcategoryId to set
   */
  public void setContainerSubcategoryId(Long containerSubcategoryId) {
    this.containerSubcategoryId = containerSubcategoryId;
  }

  /**
   * @return the containerTypeId
   */
  public Long getContainerTypeId() {
    return containerTypeId;
  }

  /**
   * @param containerTypeId the containerTypeId to set
   */
  public void setContainerTypeId(Long containerTypeId) {
    this.containerTypeId = containerTypeId;
  }

  /**
   * @return the fillPatternId
   */
  public Long getFillPatternId() {
    return fillPatternId;
  }

  /**
   * @param fillPatternId the fillPatternId to set
   */
  public void setFillPatternId(Long fillPatternId) {
    this.fillPatternId = fillPatternId;
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
   * @return the locationIds
   */
  public Long[] getLocationIds() {
    return locationIds;
  }

  /**
   * @param locationIds the locationIds to set
   */
  public void setLocationIds(Long[] locationIds) {
    this.locationIds = locationIds;
  }

  /**
   * @return the taxonId
   */
  public Long getTaxonId() {
    return taxonId;
  }

  /**
   * @param taxonId the taxonId to set
   */
  public void setTaxonId(Long taxonId) {
    this.taxonId = taxonId;
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

  /**
   * @return the personId
   */
  public Long getPersonId() {
    return personId;
  }

  /**
   * @param personId the personId to set
   */
  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  /**
   * @return the externalIdentifierIds
   */
  public Long[] getExternalIdentifierIds() {
    return externalIdentifierIds;
  }

  /**
   * @param externalIdentifierIds the externalIdentifierIds to set
   */
  public void setExternalIdentifierIds(Long[] externalIdentifierIds) {
    this.externalIdentifierIds = externalIdentifierIds;
  }
}
