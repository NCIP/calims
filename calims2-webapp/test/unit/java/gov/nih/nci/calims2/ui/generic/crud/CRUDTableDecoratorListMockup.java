/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.generic.crud;

import java.util.ArrayList;
import java.util.List;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.uic.descriptor.ColumnVisibility;
import gov.nih.nci.calims2.uic.descriptor.CommandVisibility;
import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.table.Column;

/**
 * Mockup used for the test of the methods that return list of visible elements.
 * 
 * @author viseem
 *  @param <T> The type of entity to process
 * 
 */
public class CRUDTableDecoratorListMockup<T extends EntityWithId> extends CRUDTableDecorator<T> {

  private List<Column> columns = new ArrayList<Column>();
  private List<Command> commands = new ArrayList<Command>();

  /**
   * {@inheritDoc}
   */
  public ColumnVisibility getColumnVisibility(Column column) {
    columns.add(column);
    return super.getColumnVisibility(column);
  }

  /**
   * {@inheritDoc}
   */
  public CommandVisibility getCommandVisibility(Command command) {
    commands.add(command);
    return (command.getAccess() != null) ? CommandVisibility.INVISIBLE : CommandVisibility.ACTIVE;
  }

  /**
   * @return the columns
   */
  public List<Column> getColumns() {
    return columns;
  }

  /**
   * @return the commands
   */
  public List<Command> getCommands() {
    return commands;
  }
}
