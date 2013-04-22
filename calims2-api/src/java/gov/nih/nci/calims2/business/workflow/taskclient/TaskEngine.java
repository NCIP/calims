/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.workflow.taskclient;

import java.util.List;

import org.drools.task.Task;

/**
 * @author viseem
 * 
 */
public interface TaskEngine {
  /**
   * Gets the list of tasks for the given user.
   * 
   * @param userName The user name
   * @return The list of tasks for the given user.
   */
  List<TaskListItem> getTasksForUser(String userName);

  /**
   * Execute a task transition for a given task.
   * 
   * @param userName The user name
   * @param transition The transition to execute
   * @param taskId The task id
   */
  void executeTaskTransition(String userName, TaskTransition transition, Long taskId);

  /**
   * Completes a task.
   * 
   * @param userName The user name
   * @param taskId The task id
   */
  void completeTask(String userName, Long taskId);

  /**
   * Fails a task.
   * 
   * @param userName The user name
   * @param taskId The task id
   */
  void failTask(String userName, Long taskId);

  /**
   * Gets the task with the given task id.
   * 
   * @param taskId the task id
   * @return The task with the given task id.
   */
  Task getTask(long taskId);

}
