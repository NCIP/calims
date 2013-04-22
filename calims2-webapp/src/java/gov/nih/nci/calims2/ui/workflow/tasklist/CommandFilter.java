/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.workflow.tasklist;

import gov.nih.nci.calims2.business.workflow.taskclient.TaskListItem;
import gov.nih.nci.calims2.uic.descriptor.command.Command;

/**
 * @author viseem
 * 
 */
public interface CommandFilter {

  /**
   * Computes the command flags telling if the given command is accessible for the given TaskListItem.
   * 
   * @param flag true if security allows the command
   * @param command The command to test
   * @param item The item to which the command would apply if accessible.
   * @return true if the command is accessible.
   */
  boolean getCommandFlag(boolean flag, Command command, TaskListItem item);
}
