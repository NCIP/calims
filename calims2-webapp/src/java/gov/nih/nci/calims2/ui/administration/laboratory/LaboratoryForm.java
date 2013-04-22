/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.laboratory;

import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.LaboratoryStatus;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class LaboratoryForm extends CRUDForm<Laboratory> {

  private static final long serialVersionUID = -5040776685758770632L;

  private Long[] personIds;
  private Long[] organizationIds;
  private Long[] contactInformationIds;
  private Long[] roleIds;
  private Long locationId;
  private String status;

  /**
   * Default constructor.
   */
  public LaboratoryForm() {
    setEntity(new Laboratory());
  }

  /**
   * {@inheritDoc}
   */
  public Laboratory getSubmittedEntity() {
    Laboratory laboratory = getEntity();
    laboratory.setPersonCollection(EntityWithIdHelper.createEntities(Person.class, personIds));
    laboratory.setContactInformationCollection(EntityWithIdHelper.createEntities(ContactInformation.class, contactInformationIds));
    laboratory.setOrganizationCollection(EntityWithIdHelper.createEntities(Organization.class, organizationIds));
    laboratory.setRoleCollection(EntityWithIdHelper.createEntities(Role.class, roleIds));
    laboratory.setLocation(EntityWithIdHelper.createEntity(Location.class, locationId));
    laboratory.setStatus(I18nEnumerationHelper.getByName(LaboratoryStatus.class, status));
    return laboratory;
  }

  /**
   * @return the personIds
   */
  public Long[] getPersonIds() {
    return personIds;
  }

  /**
   * @param personIds personIds to set
   */
  public void setPersonIds(Long[] personIds) {
    this.personIds = personIds;
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
   * @return the roleIds
   */
  public Long[] getRoleIds() {
    return roleIds;
  }

  /**
   * @param roleIds the roleIds to set
   */
  public void setRoleIds(Long[] roleIds) {
    this.roleIds = roleIds;
  }

}
