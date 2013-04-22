/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.service;

import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class ServiceForm extends CRUDForm<Service> {

  private static final long serialVersionUID = 5637789216781944980L;

  private String status;
  private Long typeId;
  private Boolean isTemplate;
  private Long customerRequestId;

  /**
   * Default constructor.
   */
  public ServiceForm() {
    setEntity(new Service());
  }

  /**
   * {@inheritDoc}
   */
  public Service getSubmittedEntity() {
    Service service = getEntity();
    service.setCustomerRequest(EntityWithIdHelper.createEntity(CustomerRequest.class, customerRequestId));
    service.setNotesCollection(getNotesCollection());
    service.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    service.setStatus(I18nEnumerationHelper.getByName(ServiceStatus.class, status));
    service.setIsTemplate(customerRequestId == null);
    return service;
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
   * @return the isTemplate
   */
  public Boolean getIsTemplate() {
    return isTemplate;
  }

  /**
   * @param isTemplate the isTemplate to set
   */
  public void setIsTemplate(Boolean isTemplate) {
    this.isTemplate = isTemplate;
  }

  /**
   * @return the customerRequestId
   */
  public Long getCustomerRequestId() {
    return customerRequestId;
  }

  /**
   * @param customerRequestId the customerRequestId to set
   */
  public void setCustomerRequestId(Long customerRequestId) {
    this.customerRequestId = customerRequestId;
  }

}
