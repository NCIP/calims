/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.workflow.l10n;

import java.util.ListResourceBundle;

import gov.nih.nci.calims2.business.workflow.taskclient.TaskStatus;


/**
 * @author viseem
 *
 */
public class TaskStatusBundle extends ListResourceBundle {
  private static final Object[][] CONTENTS = {
    {TaskStatus.COMPLETED.name(), "Completed"},
    {TaskStatus.CREATED.name(), "Created"},
    {TaskStatus.ERROR.name(), "Error"},
    {TaskStatus.EXITED.name(), "Exited"},
    {TaskStatus.FAILED.name(), "Failed"},
    {TaskStatus.INPROGRESS.name(), "InProgress"},
    {TaskStatus.OBSOLETE.name(), "Obsolete"},
    {TaskStatus.READY.name(), "Ready"},
    {TaskStatus.RESERVED.name(), "Reserved"},
    {TaskStatus.SUSPENDED.name(), "Suspended"}
    };

  /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }

}
