/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.storagedevice;

import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Software;
import gov.nih.nci.calims2.domain.administration.StorageDevice;
import gov.nih.nci.calims2.domain.administration.StorageSpace;
import gov.nih.nci.calims2.domain.administration.enumeration.EquipmentStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinforamtics.com
 * 
 */
public class StorageDeviceForm extends CRUDForm<StorageDevice> {

  private static final long serialVersionUID = -7521730241257056750L;
  private Long laboratoryId;
  private Long typeId;
  private Long locationId;
  private Long[] personIds;
  private Long[] organizationIds;
  private Long[] storageSpaceIds;
  // private Long[] electronicDocumentIds;
  // private Long[] hazardIds;
  private Long[] softwareIds;
  private String status;

  /**
   * Default constructor.
   */
  public StorageDeviceForm() {
    setEntity(new StorageDevice());
  }

  /**
   * {@inheritDoc}
   */
  public StorageDevice getSubmittedEntity() {
    StorageDevice storageDevice = getEntity();
    storageDevice.setLaboratory(EntityWithIdHelper.createEntity(Laboratory.class, laboratoryId));
    storageDevice.setLocation(EntityWithIdHelper.createEntity(Location.class, locationId));
    storageDevice.setOrganizationCollection(EntityWithIdHelper.createEntities(Organization.class, organizationIds));
    storageDevice.setPersonCollection(EntityWithIdHelper.createEntities(Person.class, personIds));
    storageDevice.setStorageSpaceCollection(EntityWithIdHelper.createEntities(StorageSpace.class, storageSpaceIds));
    // storageDevice.setHazardCollection(EntityWithIdHelper.createEntities(Hazard.class, hazardIds));
    storageDevice.setSoftwareCollection(EntityWithIdHelper.createEntities(Software.class, softwareIds));
    // storageDevice.setManualCollection(EntityWithIdHelper.createEntities(ElectronicDocument.class, electronicDocumentIds));
    storageDevice.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    storageDevice.setStatus(I18nEnumerationHelper.getByName(EquipmentStatus.class, status));
    return storageDevice;
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
   * @return the locationId
   */
  public Long getLocationId() {
    return locationId;
  }

  /**
   * @param locationId the locationId to set
   */
  public void setLocationId(Long locationId) {
    this.locationId = locationId;
  }

  /**
   * @return the storageSpaceIds
   */
  public Long[] getStorageSpaceIds() {
    return storageSpaceIds;
  }

  /**
   * @param storageSpaceIds the storageSpaceIds to set
   */
  public void setStorageSpaceIds(Long[] storageSpaceIds) {
    this.storageSpaceIds = storageSpaceIds;
  }
  
  /**
   * @return the electronicDocumentIds
   */
  // public Long[] getElectronicDocumentIds() {
  // return electronicDocumentIds;
  // }

  /**
   * @param electronicDocumentIds the electronicDocumentIds to set
   */
  // public void setElectronicDocumentIds(Long[] electronicDocumentIds) {
  // this.electronicDocumentIds = electronicDocumentIds;
  // }

  /**
   * @return the hazardIds
   */
  // public Long[] getHazardIds() {
  // return hazardIds;
  // }

  /**
   * @param hazardIds the hazardIds to set
   */
  // public void setHazardIds(Long[] hazardIds) {
  // this.hazardIds = hazardIds;
  // }

  /**
   * @return the softwareIds
   */
  public Long[] getSoftwareIds() {
    return softwareIds;
  }

  /**
   * @param softwareIds the softwareIds to set
   */
  public void setSoftwareIds(Long[] softwareIds) {
    this.softwareIds = softwareIds;
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
   * @return the laboratoryId
   */
  public Long getLaboratoryId() {
    return laboratoryId;
  }

  /**
   * @param laboratoryId the laboratoryId to set
   */
  public void setLaboratoryId(Long laboratoryId) {
    this.laboratoryId = laboratoryId;
  }
}
