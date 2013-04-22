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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.uic.descriptor.CommandVisibility;
import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.table.Column;

/**
 * @author connollym
 * 
 */
public class ServiceItemTableDecorator extends CRUDTableDecorator<ServiceItem> {

  private Service service;

  /**
   * {@inheritDoc}
   */
  protected List<Boolean> getItemCommandFlags(List<Boolean> flags, ServiceItem row) {
    List<Boolean> result = new ArrayList<Boolean>();
    int i = 0;
    for (Command command : getTable().getItemCommands()) {
      boolean flag = flags.get(i);
      i++;
      String commandName = command.getName();
      if ("addSpecimen".equals(commandName)) {
        boolean isTemplate = row.getService().getIsTemplate();
        boolean hasSpecimenType = row.getSpecimenType() != null;
        result.add(flag && !isTemplate && hasSpecimenType);
        continue;
      }
      result.add(flag);
    }
    return result;
  }

  /**
   * {@inheritDoc}
   */
  public String getValue(ServiceItem row, Column column, Object value) {
    if ("rate".equals(column.getName())) {
      Quantity cost = row.getServiceItemRate().getQuantity();
      return cost.getStandardUnit().getDisplayName() + " " + cost.getValue();
    }
    if ("subtotal".equals(column.getName())) {
      BigDecimal subtotal = ServiceItemHelper.getsubTotalValue(row);
      return row.getServiceItemRate().getQuantity().getStandardUnit().getDisplayName() + subtotal.toPlainString();
    }
    return getDefaultValue(row, column, value);
  }
 
  /**
   * {@inheritDoc}
   */
  public CommandVisibility getCommandVisibility(Command command) {
    if ("create".equals(command.getName()) && !service.getIsTemplate()) {
      return CommandVisibility.INVISIBLE;
    }
    return getDefaultCommandVisibility(command);
  }

  /**
   * @param service the service to set
   */
  public void setService(Service service) {
    this.service = service;
  }
}
