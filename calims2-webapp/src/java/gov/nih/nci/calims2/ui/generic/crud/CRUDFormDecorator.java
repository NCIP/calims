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
import gov.nih.nci.calims2.uic.descriptor.FormDecorator;
import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.form.FieldType;
import gov.nih.nci.calims2.uic.descriptor.form.Form;
import gov.nih.nci.calims2.uic.descriptor.form.FormElement;
import gov.nih.nci.calims2.uic.descriptor.form.FormTab;
import gov.nih.nci.calims2.uic.descriptor.form.HiddenField;
import gov.nih.nci.calims2.uic.descriptor.form.StandaloneFormElement;
import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * Default form decorator to be used in CRUD use cases that do not need any special behavior for the form. The default behavior
 * implemented by this decorator is the following:<br/>
 * 
 * Fields and hidden fields are visible if they have no selector or if their selector matches the form required selector.
 * Commands are visible if they have no selector or if their selector matches the form required selector and if the user
 * is allowed to access the url of the command.
 * 
 * @author viseem
 * 
 */
public class CRUDFormDecorator implements FormDecorator {

  private Form form;
  private PrivilegeEvaluator privilegeEvaluator;
  private CRUDControllerConfig config;

  /**
   * @return the form
   */
  public Form getForm() {
    return form;
  }

  /**
   * @param form the form to set
   */
  public void setForm(Form form) {
    this.form = form;
  }

  /**
   * {@inheritDoc}
   */
  public FieldVisibility getHiddenFieldVisibility(HiddenField field, String requiredSelector) {
    return getDefaultFieldVisibility(field.getSelector(), requiredSelector);
  }

  /**
   * {@inheritDoc}
   */
  public List<HiddenField> getVisibleHiddenFields(String requiredSelector) {
    List<HiddenField> fields = new ArrayList<HiddenField>();
    for (HiddenField field : form.getHiddenFields()) {
      if (getHiddenFieldVisibility(field, requiredSelector) == FieldVisibility.VISIBLE) {
        fields.add(field);
      }
    }
    return fields;
  }

  /**
   * {@inheritDoc}
   */
  public FieldVisibility getFieldVisibility(StandaloneFormElement field, String requiredSelector) {
    return getDefaultFieldVisibility(field.getSelector(), requiredSelector);
  }

  /**
   * {@inheritDoc}
   */
  public List<StandaloneFormElement> getVisibleFields(FormTab tab, String requiredSelector) {
    List<StandaloneFormElement> fields = new ArrayList<StandaloneFormElement>();
    for (FormElement element : tab.getChildren()) {
      if (element instanceof StandaloneFormElement
          && getFieldVisibility((StandaloneFormElement) element, requiredSelector) == FieldVisibility.VISIBLE) {
        fields.add((StandaloneFormElement) element);
      }
    }
    return fields;
  }
  
  /**
   * {@inheritDoc}
   */
  public List<StandaloneFormElement> getAllVisibleFields(String requiredSelector) {
    List<StandaloneFormElement> fields = new ArrayList<StandaloneFormElement>();
    for (FormElement tabElement : form.getChildren()) {
      for (FormElement element : tabElement.getChildren()) {
        if (element instanceof StandaloneFormElement
            && getFieldVisibility((StandaloneFormElement) element, requiredSelector) == FieldVisibility.VISIBLE) {
          fields.add((StandaloneFormElement) element);
        }
      }
    }
    return fields;
  }

  /**
   * Default calculation of the visibility of a field. This method is used by this decorator and is intended to be used in
   * subclasses for fields that have no special behavior.
   * 
   * @param fieldSelector The value of the field selector
   * @param requiredSelector The form selector
   * @return The visibility of the field.
   */
  protected FieldVisibility getDefaultFieldVisibility(String fieldSelector, String requiredSelector) {
    return (selectorMatch(fieldSelector, requiredSelector)) ? FieldVisibility.VISIBLE : FieldVisibility.INVISIBLE;
  }
  
  /**
   * Test if the selector of an element matches the required selector of the form. 
   * @param selector The selector to test
   * @param requiredSelector The form selector
   * @return true if the selector matches the required selector. 
   */
  protected boolean selectorMatch(String selector, String requiredSelector) {
    return selector == null || selector.indexOf(requiredSelector) >= 0;
  }

  /**
   * {@inheritDoc}
   */
  public CommandVisibility getCommandVisibility(Command command, String requiredSelector) {
    return getDefaultCommandVisibility(command, requiredSelector);
  }

  /**
   * Default calculation of the visibility of a command. This method is used by this decorator and is intended to be used in
   * subclasses for commands that have no special behavior.
   * 
   * @param command The command to evaluate
   * @param requiredSelector The form selector
   * @return The visibility of the field.
   */
  protected CommandVisibility getDefaultCommandVisibility(Command command, String requiredSelector) {
    if (!selectorMatch(command.getSelector(), requiredSelector)) {
      return CommandVisibility.INVISIBLE;
    }
    String url = config.getSubflowUrlFromCall(command.getUrl());
    if (privilegeEvaluator.isAllowed(url)) {
      return CommandVisibility.ACTIVE;
    }
    return CommandVisibility.INVISIBLE;
  }

  /**
   * {@inheritDoc}
   */
  public List<Command> getActiveCommands(FormTab tab, String requiredSelector) {
    List<Command> commands = new ArrayList<Command>();
    for (Command command : form.getCommands()) {
      if (command.getTab() == null || command.getTab().indexOf(tab.getName()) >= 0) {
        CommandVisibility visibility = getCommandVisibility(command, requiredSelector);
        if (visibility == CommandVisibility.ACTIVE) {
          commands.add(command);
        }
      }
    }
    return commands;
  }
  
  /**
   * {@inheritDoc}
   */
  public int getSeparatorCount(FormTab tab) {
    int count = 0;
    for (FormElement child : tab.getChildren()) {
      if (child.getType() == FieldType.SEPARATOR) {
        count++;
      }
    }
    return count;
  }

  /**
   * {@inheritDoc}
   */
  public int getTabCount() {
    int count = 0;
    for (FormElement child : form.getChildren()) {
      if (child.getType() == FieldType.FORM_TAB) {
        count++;
      }
    }
    return count;
  }
  
  /**
   * @return the privilegeEvaluator
   */
  public PrivilegeEvaluator getPrivilegeEvaluator() {
    return privilegeEvaluator;
  }

  /**
   * @param privilegeEvaluator the privilegeEvaluator to set
   */
  public void setPrivilegeEvaluator(PrivilegeEvaluator privilegeEvaluator) {
    this.privilegeEvaluator = privilegeEvaluator;
  }

  /**
   * @param config the config to set
   */
  public void setConfig(CRUDControllerConfig config) {
    this.config = config;
  }

}
