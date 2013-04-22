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

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.uic.descriptor.ColumnVisibility;
import gov.nih.nci.calims2.uic.descriptor.CommandVisibility;
import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.table.Column;

/**
 * Mockup used for the test of the methods that call the default implementation.
 * 
 * @author viseem
 * @param <T> The type of entity to process
 * 
 */
public class CRUDTableDecoratorMockup<T extends EntityWithId> extends CRUDTableDecorator<T> {
  private Column column;
  private Command command;

  /**
   * {@inheritDoc}
   */
  protected ColumnVisibility getDefaultColumnVisibility(Column columnAttr) {
    column = columnAttr;
    return ColumnVisibility.INITIALLY_VISIBLE;
  }

  /**
   * {@inheritDoc}
   */
  protected CommandVisibility getDefaultCommandVisibility(Command commandAttr) {
    command = commandAttr;
    return CommandVisibility.ACTIVE;
  }

  /**
   * @return the column
   */
  public Column getColumn() {
    return column;
  }

  /**
   * @return the command
   */
  public Command getCommand() {
    return command;
  }
}
