/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.location;

import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.enumeration.LocationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 */
public class LocationForm extends CRUDForm<Location> {

  private static final long serialVersionUID = 7790745036529234042L;

  private Long typeId;
  private Long[] contactInformationIds;
  private String status;
  private Long parentLocationId;

  /**
   * Default constructor.
   */
  public LocationForm() {
    setEntity(new Location());
  }

  /**
   * {@inheritDoc}
   */

  public Location getSubmittedEntity() {
    Location location = getEntity();
    location.setContactInformationCollection(EntityWithIdHelper.createEntities(ContactInformation.class, contactInformationIds));
    location.setParentLocation(EntityWithIdHelper.createEntity(Location.class, parentLocationId));
    location.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    location.setStatus(I18nEnumerationHelper.getByName(LocationStatus.class, status));
    return location;
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
   * @return the contactInformationIds
   */
  public Long[] getContactInformationIds() {
    return contactInformationIds;
  }

  /**
   * @param contactInformationIds the contactInformationIds to set
   */
  public void setContactInformationIds(Long[] contactInformationIds) {
    this.contactInformationIds = contactInformationIds;
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
   * @return the parentLocationId
   */
  public Long getParentLocationId() {
    return parentLocationId;
  }

  /**
   * @param parentLocationId the parentLocationId to set
   */
  public void setParentLocationId(Long parentLocationId) {
    this.parentLocationId = parentLocationId;
  }

}
