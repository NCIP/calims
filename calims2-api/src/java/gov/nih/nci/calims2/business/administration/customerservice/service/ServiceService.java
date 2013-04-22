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

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;

/**
 * @author connollym
 *
 */
public interface ServiceService extends GenericService<Service> {
  /**
   * 
   * @param customerRequestId The id of the CustomerRequest object.
   * @param templateId The id of the Template Service to clone.
   * @return The cloned Service.
   * @throws ValidationException The exception to throw if the id is not valid.
   */
  Service createClone(Long customerRequestId, Long templateId) throws ValidationException;

}
