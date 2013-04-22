/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.descriptor.table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.form.HiddenField;

/**
 * Description of a table for list pages.
 * 
 * A table as a collection of columns, a collection of global commands and a collection of per row commands.
 * 
 * @author viseem
 * 
 */
public class Table implements Cloneable, Serializable {

  private static final long serialVersionUID = 4813083813337856798L;
  
  private String id;
  private List<Column> columns = new ArrayList<Column>();
  private List<Command> commands = new ArrayList<Command>();
  private List<Command> itemCommands = new ArrayList<Command>();
  private List<HiddenField> hiddenFields = new ArrayList<HiddenField>();

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * @return the columns
   */
  public List<Column> getColumns() {
    return columns;
  }

  /**
   * @param columns the columns to set
   */
  public void setColumns(List<Column> columns) {
    this.columns = columns;
  }

  /**
   * Add a column to the table.
   * 
   * @param column The column to add
   * @return The column just added.
   */
  public Column addColumn(Column column) {
    columns.add(column);
    return column;
  }

  /**
   * @return the commands
   */
  public List<Command> getCommands() {
    return commands;
  }

  /**
   * @param commands the commands to set
   */
  public void setCommands(List<Command> commands) {
    this.commands = commands;
  }

  /**
   * Add a command to the table.
   * 
   * @param command The command to add
   * @return The command just added.
   */
  public Command addCommand(Command command) {
    commands.add(command);
    return command;
  }

  /**
   * @return the itemCommands
   */
  public List<Command> getItemCommands() {
    return itemCommands;
  }

  /**
   * @param itemCommands the itemCommands to set
   */
  public void setItemCommands(List<Command> itemCommands) {
    this.itemCommands = itemCommands;
  }

  /**
   * Add an item command to the table.
   * 
   * @param command The command to add
   * @return The command just added.
   */
  public Command addItemCommand(Command command) {
    itemCommands.add(command);
    return command;
  }
  
  /**
   * @return the hiddenFields
   */
  public List<HiddenField> getHiddenFields() {
    return hiddenFields;
  }

  /**
   * @param hiddenFields the hiddenFields to set
   */
  public void setHiddenFields(List<HiddenField> hiddenFields) {
    this.hiddenFields = hiddenFields;
  }

  /**
   * {@inheritDoc}
   */
  public Table clone() {
    try {
      return (Table) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new InternalError("Can not happen. Subclasses supports clone.");
    }
  }

}
