/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.descriptor.form;

import java.util.ArrayList;
import java.util.List;

import gov.nih.nci.calims2.uic.descriptor.command.Command;

/**
 * Description of a form.
 * 
 * action, enctype and id are the usual attributes of a form. hidden is the collection of hidden fields. Children is the
 * collection of fields that are input. commands is the collection of commands associated with this form.
 * 
 * The script property specifies the name of a jsp that is used to generate a javascript validation script.
 * 
 * @author viseem
 * 
 */
public class Form extends CompositeFormElement {

  private static final long serialVersionUID = 2894759876712653208L;
  
  private String action;
  private String enctype;
  private String id;
  private String validateFunction;
  private String script;
  private List<HiddenField> hiddenFields = new ArrayList<HiddenField>();
  private List<Command> commands = new ArrayList<Command>();

  /**
   * @return the action
   */
  public String getAction() {
    return action;
  }

  /**
   * @param action the action to set
   */
  public void setAction(String action) {
    this.action = action;
  }

  /**
   * @return the enctype
   */
  public String getEnctype() {
    return enctype;
  }

  /**
   * @param enctype the enctype to set
   */
  public void setEnctype(String enctype) {
    this.enctype = enctype;
  }
  
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
   * @return the validateFunction
   */
  public String getValidateFunction() {
    return validateFunction;
  }

  /**
   * @param validateFunction the validateFunction to set
   */
  public void setValidateFunction(String validateFunction) {
    this.validateFunction = validateFunction;
  }

  /**
   * @return the script
   */
  public String getScript() {
    return script;
  }

  /**
   * @param script the script to set
   */
  public void setScript(String script) {
    this.script = script;
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
   * Adds a hidden field to this form.
   * @param field The field to add
   * @return The field just added
   */
  public HiddenField addHiddenField(HiddenField field) {
    hiddenFields.add(field);
    return field;
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
   * Adds a command to this form.
   * @param command The command to add
   * @return The command just added
   */
  public Command addCommand(Command command) {
    commands.add(command);
    return command;
  }

  /**
   * {@inheritDoc}
   */
  public Form clone() {
    Form clone = (Form) super.clone();
    clone.hiddenFields = new ArrayList<HiddenField>();
    for (HiddenField hiddenField : hiddenFields) {
      clone.hiddenFields.add(hiddenField.clone());
    }
    clone.commands = new ArrayList<Command>();
    for (Command command : commands) {
      clone.commands.add(command.clone());
    }
    return clone();
  }

 

}
