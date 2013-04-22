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

import org.drools.task.service.TaskClient;

/**
 * Callback interface for TaskClient code. To be used with TaskClientTemplate.
 * 
 * @author viseem
 * @param <T> The type of result returned by this Callback.
 * 
 */
public interface TaskClientCallback<T> {
  /**
   * Gets called by TaskClientTemplate.execute with an active TaskClient. Does not need to care about connecting or disconnecting
   * the TaskClient.
   * 
   * @param client The TaskClient
   * @return a result object ot null if none.
   */
  T doInTaskClient(TaskClient client);

}
