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
import gov.nih.nci.calims2.business.workflow.taskclient.TaskTransition;
import gov.nih.nci.calims2.uic.descriptor.command.Command;

/**
 * @author viseem
 * 
 */
public class DefaultCommandFilter implements CommandFilter {

  /**
   * {@inheritDoc}
   */
  public boolean getCommandFlag(boolean flag, Command command, TaskListItem item) {
    String commandName = command.getName();
    if ("skip".equals(commandName) && !item.isSkipable()) {
      return false;
    }
    TaskTransition transition = TaskTransition.valueOf(commandName.toUpperCase());
    return transition.isAuthorizedForStatus(item.getStatus());
  }

}
