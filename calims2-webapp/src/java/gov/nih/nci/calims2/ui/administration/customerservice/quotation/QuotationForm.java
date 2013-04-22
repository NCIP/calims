/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.quotation;

import java.util.Set;

import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.customerservice.Quotation;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.QuotationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityFormHelper;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class QuotationForm extends CRUDForm<Quotation> {

  private static final long serialVersionUID = 6143811207596789735L;

  private QuantityFormHelper quantities = new QuantityFormHelper();
  private Long rateId;
  private String status;
  private Long typeId;

  /**
   * Default constructor.
   */
  public QuotationForm() {
    setEntity(new Quotation());
  }

  /**
   * {@inheritDoc}
   */
  public Quotation getSubmittedEntity() {
    Quotation quotation = getEntity();
    quotation.setNotesCollection(getNotesCollection());
    Set<Quantity> quantitySet = quantities.getQuantities();
    if (!quantitySet.isEmpty()) {
      quotation.setQuantity(quantities.getQuantities().iterator().next());
    }
    quotation.setRate(EntityWithIdHelper.createEntity(Rate.class, rateId));
    quotation.setStatus(I18nEnumerationHelper.getByName(QuotationStatus.class, status));
    quotation.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return quotation;
  }

  /**
   * @return the quantities
   */
  public QuantityFormHelper getQuantities() {
    return quantities;
  }

  /**
   * @param quantities the quantities to set
   */
  public void setQuantities(QuantityFormHelper quantities) {
    this.quantities = quantities;
  }

  /**
   * @return the rateId
   */
  public Long getRateId() {
    return rateId;
  }

  /**
   * @param rateId the rateId to set
   */
  public void setRateId(Long rateId) {
    this.rateId = rateId;
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
