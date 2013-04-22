/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.customerservice.service;

import org.springframework.beans.BeanUtils;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.generic.GenericServiceImpl;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceItemStatus;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceStatus;

/**
 * @author connollym
 *
 */
public class ServiceServiceImpl extends GenericServiceImpl<Service> implements ServiceService {
  
 

  
  private static final String[] SERVICE_EXCLUDED_PROPERTIES = new String[] {"id", "isTemplate", "dateCreated", "createdBy", 
    "dateModified", "modifiedBy", "documentCollection", "notesCollection", "serviceItemCollection" };
  
  private static final String[] SERVICEITEM_EXCLUDED_PROPERTIES = new String[] {"id", "dateCreated", "createdBy", "dateModified",
  "modifiedBy", "accountNumberCollection", "billingInformation", "notesCollection", "quotationCollection", "service", 
  "specimenCollection"};
  
  private GenericService<ServiceItem> serviceItemService;
  
  /**
   * {@inheritDoc}
   */
  public Service createClone(Long customerRequestId, Long templateId) throws ValidationException {
    CustomerRequest customerRequest = getGenericDao().findById(CustomerRequest.class, customerRequestId);
    Service template = getGenericDao().findById(Service.class, templateId);
    Service clone = new Service();
    BeanUtils.copyProperties(template, clone, SERVICE_EXCLUDED_PROPERTIES);
    clone.setIsTemplate(false);
    clone.setCustomerRequest(customerRequest);
    clone.setStatus(ServiceStatus.DEFAULT);
    Service result = create(clone);
    if (template.getServiceItemCollection() != null) {
      for (ServiceItem item : template.getServiceItemCollection()) {
        ServiceItem itemClone = new ServiceItem();
        BeanUtils.copyProperties(item, itemClone, SERVICEITEM_EXCLUDED_PROPERTIES);
        itemClone.setService(result);
        itemClone.setStatus(ServiceItemStatus.DEFAULT);
        serviceItemService.create(itemClone);
      }
    }
    return result;
  }

  /**
   * @param serviceItemService the serviceItemService to set
   */
  public void setServiceItemService(GenericService<ServiceItem> serviceItemService) {
    this.serviceItemService = serviceItemService;
  }

  

}
