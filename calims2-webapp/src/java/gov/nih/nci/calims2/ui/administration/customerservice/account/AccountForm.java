/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.account;

import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountStatus;
import gov.nih.nci.calims2.domain.common.ExternalIdentifier;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class AccountForm extends CRUDForm<Account> {

  private static final long serialVersionUID = 3249488316958041732L;

  private Long[] accountNumberIds;
  private Long[] externalIdentifierIds;
  private Long laboratoryId;
  private Long organizationId;
  private Long typeId;
  private String status;

  /**
   * Default constructor.
   */
  public AccountForm() {
    setEntity(new Account());
  }

  /**
   * {@inheritDoc}
   */
  public Account getSubmittedEntity() {
    Account account = getEntity();
    account.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    account.setAccountNumberCollection(EntityWithIdHelper.createEntities(AccountNumber.class, accountNumberIds));
    account.setExternalIdentifierCollection(EntityWithIdHelper.createEntities(ExternalIdentifier.class, externalIdentifierIds));
    account.setLaboratory(EntityWithIdHelper.createEntity(Laboratory.class, laboratoryId));
    account.setNotesCollection(getNotesCollection());
    account.setOrganization(EntityWithIdHelper.createEntity(Organization.class, organizationId));
    account.setStatus(I18nEnumerationHelper.getByName(AccountStatus.class, status));
    return account;
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
   * @return the accountNumberIds
   */
  public Long[] getAccountNumberIds() {
    return accountNumberIds;
  }

  /**
   * @param accountNumberIds the accountNumberIds to set
   */
  public void setAccountNumberIds(Long[] accountNumberIds) {
    this.accountNumberIds = accountNumberIds;
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

  /**
   * @return the organizationId
   */
  public Long getOrganizationId() {
    return organizationId;
  }

  /**
   * @param organizationId the organizationId to set
   */
  public void setOrganizationId(Long organizationId) {
    this.organizationId = organizationId;
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
