/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.customerrequest;

import java.util.ArrayList;
import java.util.List;

import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.CustomerRequestStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.uic.descriptor.command.Command;

/**
 * @author connollym
 *
 */
public class CustomerRequestTableDecorator extends CRUDTableDecorator<CustomerRequest> {
  
  /**
   * {@inheritDoc}
   */
  protected List<Boolean> getItemCommandFlags(List<Boolean> flags, CustomerRequest row) {
    List<Boolean> result = new ArrayList<Boolean>();
    boolean isValid = true;
    boolean hasDocuments = true;
    if (row.getDocumentCollection().size() == 0) {
      hasDocuments = false;
    }
    if (row.getServiceCollection().size() == 0) {
      isValid = false;
    } else {
      for (Service service : row.getServiceCollection()) {
        if (service.getServiceItemCollection().size() == 0) {
          isValid = false;
        }
      }
    }
    int i = 0;
    for (Command command : getTable().getItemCommands()) {
      boolean flag = flags.get(i);
      i++;
      String commandName = command.getName();
    
      if ("customerresponse".equals(commandName)) {
        result.add(flag && row.getStatus() == CustomerRequestStatus.LABRESPONSE);
        continue;
      }
      if ("labresponse".equals(commandName)) {
        result.add(flag && (row.getStatus() == CustomerRequestStatus.INQUIRY 
            || row.getStatus() == CustomerRequestStatus.CUSTOMERRESPONSE));
        continue;
      }
      if ("disapprove".equals(commandName)) {
        result.add(flag && row.getStatus() == CustomerRequestStatus.SUBMITTED);
        continue;
      }
      if ("delete".equals(commandName)) {
        result.add(flag && (row.getStatus() != CustomerRequestStatus.APPROVED 
            || row.getStatus() == CustomerRequestStatus.COMPLETED));
        continue;
      }
      if ("approve".equals(commandName)) {
        result.add(flag && row.getStatus() == CustomerRequestStatus.SUBMITTED);
        continue;
      }     
      if ("submit".equals(commandName)) {
        result.add(flag && row.getStatus() == CustomerRequestStatus.LABRESPONSE && row.getCustomerAccount() != null && isValid);
        continue;
      }
      if ("document".equals(commandName)) {
        result.add(flag && hasDocuments);
        continue;
      }
      if ("nodocument".equals(commandName)) {
        result.add(flag && !hasDocuments);
        continue;
      }
      result.add(flag);
    }
    return result;
  }
  
  
  }
