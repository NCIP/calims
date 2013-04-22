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

/**
 * @author viseem
 *
 */
public class TaskClientSupport {
  
  private TaskClientTemplate taskClientTemplate;

  /**
   * @return the taskClientTemplate
   */
  public TaskClientTemplate getTaskClientTemplate() {
    return taskClientTemplate;
  }

  /**
   * @param taskClientTemplate the taskClientTemplate to set
   */
  public void setTaskClientTemplate(TaskClientTemplate taskClientTemplate) {
    this.taskClientTemplate = taskClientTemplate;
  }

}
