/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.collaboration;

import gov.nih.nci.calims2.domain.administration.Collaboration;
import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.CollaborationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class CollaborationForm extends CRUDForm<Collaboration> {

  private static final long serialVersionUID = 8180709986773304294L;

  private Long[] contactInformationIds;
  private Long[] laboratoryIds;
  private Long[] organizationIds;
  private Long[] personIds;
  private Long roleId;
  private Long typeId;
  private String status;

  /**
   * Default constructor.
   */
  public CollaborationForm() {
    setEntity(new Collaboration());
  }

  /**
   * @return the collaboration
   */
  public Collaboration getSubmittedEntity() {
    Collaboration collaboration = getEntity();
    collaboration.setContactInformationCollection(EntityWithIdHelper.createEntities(ContactInformation.class, 
                                                  contactInformationIds));
    collaboration.setLaboratoryCollection(EntityWithIdHelper.createEntities(Laboratory.class, laboratoryIds));
    collaboration.setOrganizationCollection(EntityWithIdHelper.createEntities(Organization.class, organizationIds));
    collaboration.setPersonCollection(EntityWithIdHelper.createEntities(Person.class, personIds));
    collaboration.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    collaboration.setRole(EntityWithIdHelper.createEntity(Role.class, roleId));
    collaboration.setStatus(I18nEnumerationHelper.getByName(CollaborationStatus.class, status));
    return collaboration;
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
   * @return the laboratoryIds
   */
  public Long[] getLaboratoryIds() {
    return laboratoryIds;
  }

  /**
   * @param laboratoryIds the laboratoryIds to set
   */
  public void setLaboratoryIds(Long[] laboratoryIds) {
    this.laboratoryIds = laboratoryIds;
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
   * @return the roleId
   */
  public Long getRoleId() {
    return roleId;
  }

  /**
   * @param roleId the roleId to set
   */
  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

}
