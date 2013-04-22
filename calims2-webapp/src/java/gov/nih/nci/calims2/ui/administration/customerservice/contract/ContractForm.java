/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.contract;

import gov.nih.nci.calims2.domain.administration.customerservice.Contract;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ContractStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap@moxieinformatics.com
 * 
 */
public class ContractForm extends CRUDForm<Contract> {

  private static final long serialVersionUID = -2288138504211791868L;

  private String status;

  /**
   * Default constructor.
   */
  public ContractForm() {
    setEntity(new Contract());
  }

  /**
   * {@inheritDoc}
   */

  public Contract getSubmittedEntity() {
    Contract contract = getEntity();
    contract.setStatus(I18nEnumerationHelper.getByName(ContractStatus.class, status));
    return contract;
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

}
