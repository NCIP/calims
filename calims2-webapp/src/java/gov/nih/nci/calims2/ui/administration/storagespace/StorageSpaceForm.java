/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.storagespace;

import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.StorageSpace;
import gov.nih.nci.calims2.domain.administration.enumeration.StorageSpaceStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap@moxieinformatics.com
 * 
 */
public class StorageSpaceForm extends CRUDForm<StorageSpace> {

  private static final long serialVersionUID = 1016872104752254458L;
  
  private Long typeId;
  private Long[] organizationIds;
  private String status;
  private Long locationId;
  private Long personId;
  //private Long[] electronicDocumentIds;
  private Long layoutId;
  

  /**
   * Default constructor.
   */
  public StorageSpaceForm() {
    setEntity(new StorageSpace());
  }

  /**
   * {@inheritDoc}
   */
  public StorageSpace getSubmittedEntity() {
    StorageSpace storageSpace = getEntity();
    storageSpace.setOrganizationCollection(EntityWithIdHelper.createEntities(Organization.class, organizationIds));
    storageSpace.setInternalLocation(EntityWithIdHelper.createEntity(Location.class, locationId));
    storageSpace.setContactPerson(EntityWithIdHelper.createEntity(Person.class, personId));
    storageSpace.setLayout(EntityWithIdHelper.createEntity(Layout.class, layoutId));
   // storageSpace.setManualCollection(EntityWithIdHelper.createEntities(ElectronicDocument.class, electronicDocumentIds));
    storageSpace.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    storageSpace.setStatus(I18nEnumerationHelper.getByName(StorageSpaceStatus.class, status));
 
    return storageSpace;
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
   * @return the electronicDocumentIds
   */
 // public Long[] getElectronicDocumentIds() {
 //   return electronicDocumentIds;
 // }

  /**
   * @param electronicDocumentIds the electronicDocumentIds to set
   */
 // public void setElectronicDocumentIds(Long[] electronicDocumentIds) {
  //  this.electronicDocumentIds = electronicDocumentIds;
 // }

  /**
   * @return the layoutId
   */
  public Long getLayoutId() {
    return layoutId;
  }

  /**
   * @param layoutId the layoutId to set
   */
 public void setLayoutId(Long layoutId) {
    this.layoutId = layoutId;
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

}
