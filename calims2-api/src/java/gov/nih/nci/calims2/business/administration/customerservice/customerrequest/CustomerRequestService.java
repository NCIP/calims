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

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.CustomerRequestStatus;

/**
 * @author connollym
 *
 */
public interface CustomerRequestService extends GenericService<CustomerRequest> {
  
  /**
   * Creates children containers automatically according to a given specification. The specification tells what the parents are,
   * what container type, layout and name to use for the children
   * 
   * @param customerRequestId The id of the CustomerRequest entity to update.
   * @param status The value of the status to update.
   * @throws ValidationException if the data is not valid.
   * @return The updated CustomerRequest
   */
  CustomerRequest updateCustomerRequestStatus(Long customerRequestId, CustomerRequestStatus status) throws ValidationException;
  

}
