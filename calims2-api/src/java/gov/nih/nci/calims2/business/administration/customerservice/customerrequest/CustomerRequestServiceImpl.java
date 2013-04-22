/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.customerservice.customerrequest;

import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;

import gov.nih.nci.calims2.business.generic.GenericServiceImpl;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.CustomerRequestStatus;

/**
 * @author connollym
 *
 */
public class CustomerRequestServiceImpl extends GenericServiceImpl<CustomerRequest> implements CustomerRequestService {

  
  private static final String[] NOCOPY_PROPERTIES = new String[] {"notesCollection" };
  
  /**
   * {@inheritDoc}
   */
  public CustomerRequest updateCustomerRequestStatus(Long customerRequestId, CustomerRequestStatus status) 
  throws ValidationException {
    CustomerRequest request = getGenericDao().findById(CustomerRequest.class, customerRequestId);
    CustomerRequest updated = new CustomerRequest();
    BeanUtils.copyProperties(request, updated, NOCOPY_PROPERTIES);
    updated.setStatus(status);
    if (updated.getStatus() == CustomerRequestStatus.SUBMITTED) {
      updated.setSubmissionDate(new DateTime());
      
    }
    if (updated.getStatus() == CustomerRequestStatus.APPROVED) {
      updated.setLaboratoryFinalApproveDate(new DateTime());
      
    }
    CustomerRequest result = update(updated);
    return result;
  }
}
