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
import gov.nih.nci.calims2.uic.descriptor.form.Form;
import gov.nih.nci.calims2.uic.descriptor.form.FormTab;
import gov.nih.nci.calims2.uic.descriptor.form.HiddenField;
import gov.nih.nci.calims2.uic.descriptor.form.StandaloneFormElement;

/**
 * This is a form decorator interface that is used in the form generation. Its function is to determine the visibility of the
 * various form elements (hidden fields, fields and commands)
 * 
 * @author viseem
 */
public interface FormDecorator {

  /**
   * Get the form object.
   * 
   * @return The form object
   */
  Form getForm();

  /**
   * Get the visibility of a hidden field.
   * 
   * @param field The hidden field.
   * @param requiredSelector The required selector name
   * @return The visibility of the given hidden field for the given required selector
   */
  FieldVisibility getHiddenFieldVisibility(HiddenField field, String requiredSelector);

  /**
   * Gets the list of visible hidden fields.
   * 
   * @param requiredSelector The required selector name
   * @return The list of visible hidden fields for the given required selector
   */
  List<HiddenField> getVisibleHiddenFields(String requiredSelector);

  /**
   * Get the visibility of a field.
   * 
   * @param field The field.
   * @param requiredSelector The required selector name
   * @return The visibility of the given field for the given required selector
   */
  FieldVisibility getFieldVisibility(StandaloneFormElement field, String requiredSelector);

  /**
   * Gets the list of visible fields for a given tab of the form.
   * 
   * @param tab The tab for which the fields are requested
   * @param requiredSelector The required selector name
   * @return The list of visible fields for the given required selector
   */
  List<StandaloneFormElement> getVisibleFields(FormTab tab, String requiredSelector);
  
  /**
   * Gets the list of all visible fields of the form.
   * 
   * @param requiredSelector The required selector name
   * @return The list of visible fields for the given required selector
   */
  List<StandaloneFormElement> getAllVisibleFields(String requiredSelector);

  /**
   * Get the visibility of a command.
   * 
   * @param command The command.
   * @param requiredSelector The required selector name
   * @return The visibility of the given command for the given required selector
   */
  CommandVisibility getCommandVisibility(Command command, String requiredSelector);

  /**
   * Get the list of active commands.
   * 
   * @param tab he tab for which the commands are requested
   * @param requiredSelector The required selector name
   * @return The list of active commands for the given required selector
   */
  List<Command> getActiveCommands(FormTab tab, String requiredSelector);

  /**
   * Get the number of separators in the list of fields.
   * 
   * @param tab he tab for which the number of separator is requested
   * @return The number of separators in the list of fields
   */
  int getSeparatorCount(FormTab tab);

  /**
   * Get the number of tabs of this form.
   * 
   * @return The number of tabs of this form.
   */
  int getTabCount();

}
