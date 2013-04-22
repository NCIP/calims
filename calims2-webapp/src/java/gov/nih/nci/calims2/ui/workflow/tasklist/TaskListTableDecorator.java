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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import gov.nih.nci.calims2.business.workflow.taskclient.TaskListItem;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.uic.descriptor.command.Command;

/**
 * @author viseem
 *
 */
public class TaskListTableDecorator extends CRUDTableDecorator<TaskListItem> {
  
  private CommandFilter defaultFilter = new DefaultCommandFilter();
  private Map<String, CommandFilter> taskCommandFilters;
  
  /**
   * {@inheritDoc}
   */
  protected List<Boolean> getItemCommandFlags(List<Boolean> flags, TaskListItem item) {
    List<Boolean> result = new ArrayList<Boolean>();
    int i = 0;
    for (Command command : getTable().getItemCommands()) {
      boolean flag = flags.get(i);
      i++;
      if (command.getSelector() == null) {
        flag = defaultFilter.getCommandFlag(flag, command, item);
      } else {
        CommandFilter filter = taskCommandFilters.get(command.getSelector());
        flag = (filter == null) ? false : filter.getCommandFlag(flag, command, item);
      }
      result.add(flag);
    }
    return result;
  }

  /**
   * @param taskCommandFilters the taskCommandFilters to set
   */
  public void setTaskCommandFilters(Map<String, CommandFilter> taskCommandFilters) {
    this.taskCommandFilters = taskCommandFilters;
  }
}
