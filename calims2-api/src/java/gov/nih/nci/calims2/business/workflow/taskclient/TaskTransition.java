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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author viseem
 * 
 */
public enum TaskTransition {
  /** Claim transition. */
  CLAIM("claim", new TaskStatus[] {TaskStatus.READY }),
  /** Complete transition. */
  COMPLETE("complete", new TaskStatus[] {TaskStatus.INPROGRESS }),
  /** Fail transition. */
  FAIL("fail", new TaskStatus[] {TaskStatus.INPROGRESS }),
  /** Release transition. */
  RELEASE("release", new TaskStatus[] {TaskStatus.RESERVED, TaskStatus.INPROGRESS }),
  /** Resume transition. */
  RESUME("resume", new TaskStatus[] {TaskStatus.SUSPENDED }),
  /** Start transition. */
  START("start", new TaskStatus[] {TaskStatus.READY, TaskStatus.RESERVED }),
  /** Stop transition. */
  STOP("stop", new TaskStatus[] {TaskStatus.INPROGRESS }),
  /** Skip transition. */
  SKIP("skip", new TaskStatus[] {TaskStatus.INPROGRESS }),
  /** Suspend transition. */
  SUSPEND("suspend", new TaskStatus[] {TaskStatus.READY, TaskStatus.RESERVED, TaskStatus.INPROGRESS });

  private String methodName;
  private Set<TaskStatus> authorizedStatuses = new HashSet<TaskStatus>();

  private TaskTransition(String methodName, TaskStatus[] statuses) {
    this.methodName = methodName;
    this.authorizedStatuses.addAll(Arrays.asList(statuses));
  }

  /**
   * @return the methodName
   */
  public String getMethodName() {
    return methodName;
  }

  /**
   * Test if this transition is possible in the given task status.
   * 
   * @param taskStatus The task status to test
   * @return true if this transition is possible in the given task status.
   */
  public boolean isAuthorizedForStatus(TaskStatus taskStatus) {
    return authorizedStatuses.contains(taskStatus);
  }

}
