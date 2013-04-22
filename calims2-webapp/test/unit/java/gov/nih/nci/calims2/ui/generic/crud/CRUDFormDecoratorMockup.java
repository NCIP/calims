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

import gov.nih.nci.calims2.uic.descriptor.CommandVisibility;
import gov.nih.nci.calims2.uic.descriptor.FieldVisibility;
import gov.nih.nci.calims2.uic.descriptor.command.Command;

/**
 * 
 * Mockup used for the test of the methods that call the default implementation.
 * 
 * @author viseem
 * 
 */
public class CRUDFormDecoratorMockup extends CRUDFormDecorator {

  private String fieldSelector;
  private String fieldrequiredSelector;
  private Command command;
  private String commandRequiredSelector;

  /**
   * {@inheritDoc}
   */
  protected FieldVisibility getDefaultFieldVisibility(String selector, String requiredSelector) {
    fieldSelector = selector;
    fieldrequiredSelector = requiredSelector;
    return FieldVisibility.VISIBLE;
  }

  /**
   * {@inheritDoc}
   */
  protected CommandVisibility getDefaultCommandVisibility(Command co, String requiredSelector) {
    command = co;
    commandRequiredSelector = requiredSelector;
    return CommandVisibility.ACTIVE;
  }

  /**
   * @return the fieldSelector
   */
  public String getFieldSelector() {
    return fieldSelector;
  }

  /**
   * @return the fieldrequiredSelector
   */
  public String getFieldrequiredSelector() {
    return fieldrequiredSelector;
  }

  /**
   * @return the command
   */
  public Command getCommand() {
    return command;
  }

  /**
   * @return the commandRequiredSelector
   */
  public String getCommandRequiredSelector() {
    return commandRequiredSelector;
  }
}
