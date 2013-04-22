/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.billinginformation;

import gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.BillingInformationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class BillingInformationForm extends CRUDForm<BillingInformation> {

  private static final long serialVersionUID = -8677478917754844020L;

  private String status;
  private Long typeId;

  /**
   * Default constructor.
   */
  public BillingInformationForm() {
    setEntity(new BillingInformation());
  }

  /**
   * {@inheritDoc}
   */
  public BillingInformation getSubmittedEntity() {
    BillingInformation billingInformation = getEntity();
    billingInformation.setNotesCollection(getNotesCollection());
    billingInformation.setStatus(I18nEnumerationHelper.getByName(BillingInformationStatus.class, status));
    billingInformation.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return billingInformation;
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
