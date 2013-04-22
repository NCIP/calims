/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.accountnumber;

import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountNumberStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
public class AccountNumberForm extends CRUDForm<AccountNumber> {

  private static final long serialVersionUID = -4085612068276779884L;

  private String status;
  private Long typeId;

  /**
   * Default constructor.
   */
  public AccountNumberForm() {
    setEntity(new AccountNumber());
  }

  /**
   * {@inheritDoc}
   */
  public AccountNumber getSubmittedEntity() {
    AccountNumber accountNumber = getEntity();
    Long accountId = (Long) (FlowContextHolder.getContext().peek()).getAttribute("id");
    accountNumber.setAccount(EntityWithIdHelper.createEntity(Account.class, accountId));
    accountNumber.setNotesCollection(getNotesCollection());
    accountNumber.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    accountNumber.setStatus(I18nEnumerationHelper.getByName(AccountNumberStatus.class, status));
    return accountNumber;
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
}
