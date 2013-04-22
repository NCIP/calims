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

import java.io.Serializable;

import org.drools.task.query.TaskSummary;
import org.joda.time.DateTime;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * @author viseem
 * 
 */
public class TaskListItem implements EntityWithId, Serializable {

  private static final long serialVersionUID = 5777048194553035277L;
  
  private TaskSummary summary;

  /**
   * Adapter constructor.
   * 
   * @param summary The summary from whic the item will be created.
   */
  public TaskListItem(TaskSummary summary) {
    this.summary = summary;

  }

  /**
   * @return the id
   */
  public Long getId() {
    return summary.getId();
  }

  /**
   * {@inheritDoc}
   */
  public void setId(Long id) {
    // Nothing to do. This is an immutable class
  }

  /**
   * @return the name
   */
  public String getName() {
    return summary.getName();
  }

  /**
   * @return the subject
   */
  public String getSubject() {
    return summary.getSubject();
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return summary.getDescription();
  }

  /**
   * @return the status
   */
  public TaskStatus getStatus() {
    return (summary.getStatus() != null) ? TaskStatus.getTaskStatus(summary.getStatus()) : null;
  }

  /**
   * @return the priority
   */
  public int getPriority() {
    return summary.getPriority();
  }

  /**
   * @return the skipable
   */
  public boolean isSkipable() {
    return summary.isSkipable();
  }

  /**
   * @return the actualOwner
   */
  public String getActualOwner() {
    return (summary.getActualOwner() != null) ? summary.getActualOwner().getId() : null;
  }

  /**
   * @return the createdBy
   */
  public String getCreatedBy() {
    return (summary.getCreatedBy() != null) ? summary.getCreatedBy().getId() : null;
  }

  /**
   * @return the createdOn
   */
  public DateTime getCreatedOn() {
    return (summary.getCreatedOn() != null) ? new DateTime(summary.getCreatedOn()) : null;
  }

  /**
   * @return the activationTime
   */
  public DateTime getActivationTime() {
    return (summary.getActivationTime() != null) ? new DateTime(summary.getActivationTime()) : null;
  }

  /**
   * @return the expirationTime
   */
  public DateTime getExpirationTime() {
    return (summary.getExpirationTime() != null) ? new DateTime(summary.getExpirationTime()) : null;
  }

}
