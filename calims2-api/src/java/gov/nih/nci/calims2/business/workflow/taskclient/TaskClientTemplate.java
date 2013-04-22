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

import org.drools.SystemEventListenerFactory;
import org.drools.task.service.TaskClient;
import org.drools.task.service.mina.MinaTaskClientConnector;
import org.drools.task.service.mina.MinaTaskClientHandler;

/**
 * Template class that simplifies TaskClient code.
 * 
 * It provides client connection and disconnection.
 * 
 * @author viseem
 * 
 */
public class TaskClientTemplate {

  private TaskServerHostConfiguration taskServerHostConfiguration;

  /**
   * Execute the given callback.
   * 
   * @param <T> The type of result.
   * @param action The callback to execute
   * @return The result returned by the callback.
   */
  public <T> T execute(TaskClientCallback<T> action) {
    TaskClient client = new TaskClient(new MinaTaskClientConnector("calims", new MinaTaskClientHandler(SystemEventListenerFactory
        .getSystemEventListener())));
    boolean connected = client.connect(taskServerHostConfiguration.getHostName(), taskServerHostConfiguration.getPort());
    if (connected) {
      try {
        T result = action.doInTaskClient(client);
        return result;
      } finally {
        try {
          client.disconnect();
        } catch (Exception e) {
          throw new RuntimeException(e);
        }
      }
    }
    throw new RuntimeException("Can not connect to TaskService");
  }

  /**
   * @param taskServerHostConfiguration the taskServerHostConfiguration to set
   */
  public void setTaskServerHostConfiguration(TaskServerHostConfiguration taskServerHostConfiguration) {
    this.taskServerHostConfiguration = taskServerHostConfiguration;
  }
}
