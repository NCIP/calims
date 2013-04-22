/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.invoice;

import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.Invoice;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.InvoiceStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap@moxieinforamtics.com
 * 
 */
public class InvoiceForm extends CRUDForm<Invoice> {

  private static final long serialVersionUID = 9088782580547930564L;

  private Long[] customerRequestIds;
  private String status;
  private Long typeId;

  /**
   * Default constructor.
   */

  public InvoiceForm() {
    setEntity(new Invoice());
  }

  /**
   * {@inheritDoc}
   */
  public Invoice getSubmittedEntity() {
    Invoice invoice = getEntity();
    invoice.setCustomerRequestCollection(EntityWithIdHelper.createEntities(CustomerRequest.class, customerRequestIds));
    invoice.setNotesCollection(getNotesCollection());
    invoice.setStatus(I18nEnumerationHelper.getByName(InvoiceStatus.class, status));
    invoice.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return invoice;
  }

  /**
   * @return the customerRequestIds
   */
  public Long[] getCustomerRequestIds() {
    return customerRequestIds;
  }

  /**
   * @param customerRequestIds the customerRequestIds to set
   */
  public void setCustomerRequestIds(Long[] customerRequestIds) {
    this.customerRequestIds = customerRequestIds;
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
