/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.organization;

import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.OrganizationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class OrganizationForm extends CRUDForm<Organization> {

  private static final long serialVersionUID = 9036160990128738301L;

  private Long typeId;
  private Long locationId;
  private Long[] roleIds;
  private String status;
  private Long parentOrganizationId;

  /**
   * Default constructor.
   */
  public OrganizationForm() {
    setEntity(new Organization());
  }

  /**
   * {@inheritDoc}
   */
  public Organization getSubmittedEntity() {
    Organization org = getEntity();
    org.setIsTaxExempt(checkBoolean(org.getIsTaxExempt()));
    org.setRoleCollection(EntityWithIdHelper.createEntities(Role.class, roleIds));
    org.setLocation(EntityWithIdHelper.createEntity(Location.class, locationId));
    org.setParentOrganization(EntityWithIdHelper.createEntity(Organization.class, parentOrganizationId));
    org.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    org.setStatus(I18nEnumerationHelper.getByName(OrganizationStatus.class, status));
    return org;
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
   * @return the parentOrganizationId
   */
  public Long getParentOrganizationId() {
    return parentOrganizationId;
  }

  /**
   * @param parentOrganizationId the parentOrganizationId to set
   */
  public void setParentOrganizationId(Long parentOrganizationId) {
    this.parentOrganizationId = parentOrganizationId;
  }

}