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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.drools.task.Status;

import gov.nih.nci.calims2.business.workflow.l10n.TaskStatusBundle;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author viseem
 *
 */
public enum TaskStatus implements I18nEnumeration {
  /** Completed taskStatus. */
  COMPLETED, 
  /** Created taskStatus. */
  CREATED, 
  /** Error taskStatus. */
  ERROR, 
  /** Exited taskStatus. */
  EXITED, 
  /** Failed taskStatus. */
  FAILED,
  /** In progress taskStatus. */
  INPROGRESS,
  /** Obsolete taskStatus. */
  OBSOLETE,
  /** Ready taskStatus. */
  READY, 
  /** Reserved taskStatus. */
  RESERVED,  
  /** Suspended taskStatus. */
  SUSPENDED;
  
  private static Map<Status, TaskStatus> conversionMap = loadConverstionMap();
  
  private static Map<Status, TaskStatus> loadConverstionMap() {
    Map<Status, TaskStatus> map = new HashMap<Status, TaskStatus>();
    map.put(Status.Completed, COMPLETED);
    map.put(Status.Created, CREATED);
    map.put(Status.Error, ERROR);
    map.put(Status.Exited, EXITED);
    map.put(Status.Failed, FAILED);
    map.put(Status.InProgress, INPROGRESS);
    map.put(Status.Obsolete, OBSOLETE);
    map.put(Status.Ready, READY);
    map.put(Status.Reserved, RESERVED);
    map.put(Status.Suspended, SUSPENDED);
    return map;
  }
  /**
   * Converts the Drools status to this TaskStatus.
   * @param status The status to convert
   * @return The converted status.
   */
 public static TaskStatus getTaskStatus(Status status) {
   return conversionMap.get(status);  
 }
 
  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(TaskStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {
    return name();
  }
}
