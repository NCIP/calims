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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.ui.administration.customerservice.serviceitem.ServiceItemHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.uic.descriptor.CommandVisibility;
import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.table.Column;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author connollym
 * 
 */
public class ServiceTableDecorator extends CRUDTableDecorator<Service> {

  /**
   * {@inheritDoc}
   */
  public CommandVisibility getCommandVisibility(Command command) {
    StackFrame frame = FlowContextHolder.getContext().peek();
    boolean template = frame.getAttribute("template") != null;
    
    if ("back".equals(command.getName()) && template) {
      return CommandVisibility.INVISIBLE;
    }
    if ("select".equals(command.getName()) && template) {
      return CommandVisibility.INVISIBLE;
    }
    if ("create".equals(command.getName()) && !template) {
      return CommandVisibility.INVISIBLE;
    }
    if ("manage".equals(command.getName()) && !template) {
      return CommandVisibility.INVISIBLE;
    }
    return getDefaultCommandVisibility(command);
  }

  /**
   * {@inheritDoc}
   */
  public String getValue(Service row, Column column, Object value) {
    if ("subtotal".equals(column.getName())) {
      BigDecimal subtotal = ServiceItemHelper.getServiceTotal(row);
      return "$" + subtotal.toPlainString();
    }
    return getDefaultValue(row, column, value);
  }
  
  protected List<Boolean> getItemCommandFlags(List<Boolean> flags, Service row) {
    List<Boolean> result = new ArrayList<Boolean>();
    boolean hasDocuments = true;
    if (row.getDocumentCollection().size() == 0) {
      hasDocuments = false;
    }
    int i = 0;
    for (Command command : getTable().getItemCommands()) {
      boolean flag = flags.get(i);
      i++;
      String commandName = command.getName();
    
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
