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

import gov.nih.nci.calims2.uic.descriptor.CommandVisibility;
import gov.nih.nci.calims2.uic.descriptor.FieldVisibility;
import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.form.HiddenField;
import gov.nih.nci.calims2.uic.descriptor.form.StandaloneFormElement;

/**
 * 
 * Mockup used for the test of the methods that return list of visible elements.
 * 
 * @author viseem
 * 
 */
public class CRUDFormDecoratorListMockup extends CRUDFormDecorator {

  private List<HiddenField> hiddenFields = new ArrayList<HiddenField>();
  private List<String> hiddenSelectors = new ArrayList<String>();
  private List<StandaloneFormElement> fields = new ArrayList<StandaloneFormElement>();
  private List<String> selectors = new ArrayList<String>();
  private List<Command> commands = new ArrayList<Command>();
  private List<String> commandSelectors = new ArrayList<String>();

  /**
   * {@inheritDoc}
   */
  public FieldVisibility getHiddenFieldVisibility(HiddenField field, String requiredSelector) {
    hiddenFields.add(field);
    hiddenSelectors.add(requiredSelector);
    return super.getHiddenFieldVisibility(field, requiredSelector);
  }

  /**
   * {@inheritDoc}
   */
  public FieldVisibility getFieldVisibility(StandaloneFormElement field, String requiredSelector) {
    fields.add(field);
    selectors.add(requiredSelector);
    return super.getFieldVisibility(field, requiredSelector);
  }
  
  /**
   * {@inheritDoc}
   */
  public CommandVisibility getCommandVisibility(Command command, String requiredSelector) {
    commands.add(command);
    commandSelectors.add(requiredSelector);
    return (command.getSelector() == null) ? CommandVisibility.ACTIVE : CommandVisibility.INVISIBLE;
  }

  /**
   * @return the hiddenFields
   */
  public List<HiddenField> getHiddenFields() {
    return hiddenFields;
  }

  /**
   * @return the hiddenSelectors
   */
  public List<String> getHiddenSelectors() {
    return hiddenSelectors;
  }

  /**
   * @return the fields
   */
  public List<StandaloneFormElement> getFields() {
    return fields;
  }

  /**
   * @return the selectors
   */
  public List<String> getSelectors() {
    return selectors;
  }

  /**
   * @return the commands
   */
  public List<Command> getCommands() {
    return commands;
  }

  /**
   * @return the commandSelectors
   */
  public List<String> getCommandSelectors() {
    return commandSelectors;
  }
}
