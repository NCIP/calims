/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.workflow.taskserver;

import javax.persistence.EntityManagerFactory;

import org.drools.SystemEventListenerFactory;
import org.drools.task.service.TaskService;
import org.drools.task.service.mina.MinaTaskServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.nih.nci.calims2.business.workflow.taskclient.TaskServerHostConfiguration;

/**
 * @author viseem
 * 
 */
public class TaskServer {
  private static Logger log = LoggerFactory.getLogger(TaskServer.class);

  private EntityManagerFactory entityManagerFactory;
  private MinaTaskServer server;
  private TaskServerHostConfiguration taskServerHostConfiguration;

  /**
   * Initialisation method.
   */
  public void init() {
    log.debug("TaskServer init");
    TaskService taskService = new TaskService(entityManagerFactory, SystemEventListenerFactory.getSystemEventListener());
    server = new MinaTaskServer(taskService, taskServerHostConfiguration.getPort());
    Thread thread = new Thread(server);
    thread.start();
  }

  /**
   * Shutdown method.
   */
  public void destroy() {
    log.debug("TaskServer destroy");
    server.stop();
  }

  /**
   * @param entityManagerFactory the entityManagerFactory to set
   */
  public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  /**
   * @param taskServerHostConfiguration the taskServerHostConfiguration to set
   */
  public void setTaskServerHostConfiguration(TaskServerHostConfiguration taskServerHostConfiguration) {
    this.taskServerHostConfiguration = taskServerHostConfiguration;
  }

}
