/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.person;

import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.PersonStatus;
import gov.nih.nci.calims2.domain.common.ExternalIdentifier;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class PersonForm extends CRUDForm<Person> {

  private static final long serialVersionUID = -6010765931860899363L;

  private Long[] organizationIds;
  private Long[] contactInformationIds;
  private Long externalIdentifierId;
  private Long[] roleIds;
  private String status;

  /**
   * Default constructor.
   */
  public PersonForm() {
    setEntity(new Person());
  }

  /**
   * {@inheritDoc}
   */
  public Person getSubmittedEntity() {
    Person person = getEntity();
    person.setContactInformationCollection(EntityWithIdHelper.createEntities(ContactInformation.class, contactInformationIds));
    person.setExternalIdentifier(EntityWithIdHelper.createEntity(ExternalIdentifier.class, externalIdentifierId));
    person.setOrganizationCollection(EntityWithIdHelper.createEntities(Organization.class, organizationIds));
    person.setRoleCollection(EntityWithIdHelper.createEntities(Role.class, roleIds));
    person.setStatus(I18nEnumerationHelper.getByName(PersonStatus.class, status));

    return person;
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
   * @return the externalIdentifierId
   */
  public Long getExternalIdentifierId() {
    return externalIdentifierId;
  }

  /**
   * @param externalIdentifierId the externalIdentifierId to set
   */
  public void setExternalIdentifierId(Long externalIdentifierId) {
    this.externalIdentifierId = externalIdentifierId;
  }
  
}
