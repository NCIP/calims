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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.uic.descriptor.ColumnVisibility;
import gov.nih.nci.calims2.uic.descriptor.CommandVisibility;
import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.table.Column;
import gov.nih.nci.calims2.uic.descriptor.table.Table;

/**
 * @author viseem
 * 
 */
public class CrudTableDecoratorTest {

  /**
   * test the getDisplayableColumns method.
   */
  @Test
  public void testGetDisplayableColumns() {
    CRUDTableDecoratorListMockup<Person> tableDecorator = initMockupForListTests();
    List<Column> columns = tableDecorator.getDisplayableColumns();
    assertNotNull("No result returned", columns);
    assertEquals("Wrong result size", 1, columns.size());
    assertEquals("Wrong column returned", tableDecorator.getTable().getColumns().get(0), columns.get(0));
    assertEquals("Wrong columns tested", tableDecorator.getTable().getColumns(), tableDecorator.getColumns());
  }

  /**
   * test the getActiveCommands method.
   */
  @Test
  public void testGetActiveCommands() {
    CRUDTableDecoratorListMockup<Person> tableDecorator = initMockupForListTests();
    List<Command> commands = tableDecorator.getActiveCommands();
    assertNotNull("No result returned", commands);
    assertEquals("Wrong result size", 1, commands.size());
    assertEquals("Wrong command returned", tableDecorator.getTable().getCommands().get(0), commands.get(0));
    assertEquals("Wrong commands tested", tableDecorator.getTable().getCommands(), tableDecorator.getCommands());
  }

  private <T extends EntityWithId> CRUDTableDecoratorListMockup<T> initMockupForListTests() {
    CRUDTableDecoratorListMockup<T> mockup = new CRUDTableDecoratorListMockup<T>();
    Table table = new Table();
    mockup.setTable(table);
    table.addColumn(new Column());
    Column col2 = table.addColumn(new Column());
    col2.setVisibility(ColumnVisibility.ALWAYS_INVISIBLE);
    table.addCommand(new Command());
    Command com2 = table.addCommand(new Command());
    com2.setAccess("no access");
    return mockup;
  }

  /**
   * test the getColumnVisibility method. This test checks that the getColumnVisibility correctly calls the
   * getDefaultColumnVisibility method
   */
  @Test
  public void testGetColumnVisibility() {
    CRUDTableDecoratorMockup<Person> mockup = initMockupForVisibilityTests();
    Column column = new Column();
    ColumnVisibility visibility = mockup.getColumnVisibility(column);
    assertEquals("Wrong result", ColumnVisibility.INITIALLY_VISIBLE, visibility);
    assertEquals("Wrong column passed to default method", column, mockup.getColumn());
  }

  /**
   * test the getCommandVisibility method. This test checks that the getCommandVisibility correctly calls the
   * getDefaultCommandVisibility method
   */
  @Test
  public void testGetCommandVisibility() {
    CRUDTableDecoratorMockup<Person> mockup = initMockupForVisibilityTests();
    Command command = new Command();
    CommandVisibility visibility = mockup.getCommandVisibility(command);
    assertEquals("Wrong result", CommandVisibility.ACTIVE, visibility);
    assertEquals("Wrong command passed to default method", command, mockup.getCommand());
  }

  private <T extends EntityWithId> CRUDTableDecoratorMockup<T> initMockupForVisibilityTests() {
    CRUDTableDecoratorMockup<T> mockup = new CRUDTableDecoratorMockup<T>();
    return mockup;
  }

  /**
   * test the getDefaultColumnVisibility method for a column with no specified visibility.
   */
  @Test
  public void testgetDefaultColumnVisibilityNoSpecificationC() {
    testGetDefaultColumnVisibility(new Column(), ColumnVisibility.INITIALLY_VISIBLE);
  }

  /**
   * test the getDefaultColumnVisibility method for a column with a specified visibility.
   */
  @Test
  public void testgetDefaultColumnVisibilityWithSpecificationC() {
    Column column = new Column();
    column.setVisibility(ColumnVisibility.ALWAYS_INVISIBLE);
    testGetDefaultColumnVisibility(column, ColumnVisibility.ALWAYS_INVISIBLE);
  }

  private void testGetDefaultColumnVisibility(Column column, ColumnVisibility expectedResult) {
    CRUDTableDecorator<Person> tableDecorator = new CRUDTableDecorator<Person>();
    ColumnVisibility result = tableDecorator.getDefaultColumnVisibility(column);
    assertEquals("Wrong result from getDefaultColumnVisibility", expectedResult, result);
  }

  /**
   * test the getDefaultCommandVisibility method when the url is forbidden.
   */
  @Test
  public void testGetDefaultCommandVisibilityForbidden() {
    Command command = new Command();
    command.setUrl("url");
    testGetDefaultCommandVisibility(command, false, CommandVisibility.INVISIBLE);
  }

  /**
   * test the getDefaultCommandVisibility method when the url is allowed.
   */
  @Test
  public void testGetDefaultCommandVisibilityAllowed() {
    Command command = new Command();
    command.setUrl("url");
    testGetDefaultCommandVisibility(command, true, CommandVisibility.ACTIVE);
  }

  private void testGetDefaultCommandVisibility(Command command, boolean urlAllowed, CommandVisibility expedtedResult) {
    CRUDTableDecorator<Person> tableDecorator = new CRUDTableDecorator<Person>();
    PrivilegeEvaluatorMockup privilegeEvaluator = new PrivilegeEvaluatorMockup(urlAllowed);
    tableDecorator.setPrivilegeEvaluator(privilegeEvaluator);
    CommandVisibility visibility = tableDecorator.getCommandVisibility(command);
    assertEquals("Wrong result from getDefaultCommandVisibility", expedtedResult, visibility);
  }

}
