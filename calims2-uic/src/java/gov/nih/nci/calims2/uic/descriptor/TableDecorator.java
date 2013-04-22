/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.descriptor;

import java.util.List;

import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.table.Column;
import gov.nih.nci.calims2.uic.descriptor.table.Table;

/**
 * This is a table decorator interface that is used in the table generation. Its function is to determine the visibility of the
 * various table elements (columns, commands, etc)
 * 
 * @author viseem
 * @param <T> The type of the rows of the table
 * 
 */
public interface TableDecorator<T> {
  /**
   * Get the table object.
   * 
   * @return the table object.
   */
  Table getTable();

  /**
   * Get the visibility of a column.
   * 
   * @param column The column
   * @return The visibility of the given column
   */
  ColumnVisibility getColumnVisibility(Column column);
  
  /**
   * Gets the applicable length of the column.
   * @param column The column
   * @return the applicable length of the column.
   */
  int getColumnLength(Column column);

  /**
   * Get the list of displayable columns(non invisible columns).
   * 
   * @return The visibility of the given column
   */
  List<Column> getDisplayableColumns();

  /**
   * Gets the value of a cell.
   * 
   * @param row The data of the row of the cell.
   * @param column The column of the cell.
   * @param value The value calculated from the value JSTL expression
   * @return The value to use for the cell
   */
  String getValue(T row, Column column, Object value);

  /**
   * Gets the json representation of the data store of the grid.
   * 
   * @return The json representation of the data store of the grid.
   */
  String getDataStore();
  
  /**
   * Get the visibility of a command.
   * 
   * @param command The command.
   * @return The visibility of the given command 
   */
  CommandVisibility getCommandVisibility(Command command);

  /**
   * Get the list of active commands.
   * 
   * @return The list of active commands
   */
  List<Command> getActiveCommands();

}
