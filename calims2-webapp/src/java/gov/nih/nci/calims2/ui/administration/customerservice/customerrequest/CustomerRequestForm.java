/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.customerrequest;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.CustomerRequestStatus;
import gov.nih.nci.calims2.domain.common.ExternalIdentifier;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class CustomerRequestForm extends CRUDForm<CustomerRequest> {

  private static final long serialVersionUID = 2034866113610413476L;
  
  private Long personId;
  private Long accountId;
  private Long typeId;
  private Long[] externalIdentifierIds;
  private Long[] serviceIds;
  private String status;

  /**
   * Default constructor.
   */
  public CustomerRequestForm() {
    setEntity(new CustomerRequest());
  }

  /**
   * {@inheritDoc}
   */
  public CustomerRequest getSubmittedEntity() {
    CustomerRequest customerRequest = getEntity();
    customerRequest.setCustomerAccount(EntityWithIdHelper.createEntity(Account.class, accountId));
    customerRequest.setCustomerName(EntityWithIdHelper.createEntity(Person.class, personId));
    customerRequest.setExternalIdentifierCollection(EntityWithIdHelper.createEntities(ExternalIdentifier.class, 
        externalIdentifierIds));
    customerRequest.setNotesCollection(getNotesCollection());
    customerRequest.setServiceCollection(EntityWithIdHelper.createEntities(Service.class, serviceIds));
    customerRequest.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    if (isEditMode()) {
      customerRequest.setStatus(I18nEnumerationHelper.getByName(CustomerRequestStatus.class, status));
    } else {
      customerRequest.setStatus(CustomerRequestStatus.INQUIRY);
    }
    return customerRequest;
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
   * @return the accountId
   */
  public Long getAccountId() {
    return accountId;
  }

  /**
   * @param accountId the accountId to set
   */
  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  /**
   * @return the serviceIds
   */
  public Long[] getServiceIds() {
    return serviceIds;
  }

  /**
   * @param serviceIds the serviceIds to set
   */
  public void setServiceIds(Long[] serviceIds) {
    this.serviceIds = serviceIds;
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
