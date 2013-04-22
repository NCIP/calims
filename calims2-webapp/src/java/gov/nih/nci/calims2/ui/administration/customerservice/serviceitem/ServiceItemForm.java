/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.serviceitem;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceItemStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.enumeration.SpecimenType;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class ServiceItemForm extends CRUDForm<ServiceItem> {

  private static final long serialVersionUID = -2369733877389828885L;

  private static final Long EACH_UNIT_ID = 199402L;

  private Long[] accountNumberIds;
  private String quantity;
  private Long rateId;
  private String specimenType;
  private String status;
  private Long typeId;

  /**
   * Default constructor.
   */
  public ServiceItemForm() {
    setEntity(new ServiceItem());
  }

  /**
   * {@inheritDoc}
   */
  public ServiceItem getSubmittedEntity() {
    ServiceItem serviceItem = getEntity();
    Long serviceId = (Long) (FlowContextHolder.getContext().peek()).getAttribute("id");
    serviceItem.setService(EntityWithIdHelper.createEntity(Service.class, serviceId));
    serviceItem.setAccountNumberCollection(EntityWithIdHelper.createEntities(AccountNumber.class, accountNumberIds));
    serviceItem.setNotesCollection(getNotesCollection());
    serviceItem.setServiceItemRate(EntityWithIdHelper.createEntity(Rate.class, rateId));
    serviceItem.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    serviceItem.setStatus(I18nEnumerationHelper.getByName(ServiceItemStatus.class, status));
    serviceItem.setSpecimenType(I18nEnumerationHelper.getByName(SpecimenType.class, specimenType));
    if (StringUtils.isNotBlank(quantity)) {
      Quantity quantityObject = new Quantity();
      quantityObject.setValue(quantity);
      StandardUnit unit = new StandardUnit();
      unit.setId(EACH_UNIT_ID);
      quantityObject.setStandardUnit(unit);
      serviceItem.setQuantity(quantityObject);
    }
    return serviceItem;
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
   * @return the quantity
   */
  public String getQuantity() {
    return quantity;
  }

  /**
   * @param quantity the quantity to set
   */
  public void setQuantity(String quantity) {
    this.quantity = quantity;
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
   * @return the specimenType
   */
  public String getSpecimenType() {
    return specimenType;
  }

  /**
   * @param specimenType the specimenType to set
   */
  public void setSpecimenType(String specimenType) {
    this.specimenType = specimenType;
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
