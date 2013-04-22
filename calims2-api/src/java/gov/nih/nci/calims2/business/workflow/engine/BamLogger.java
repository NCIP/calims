/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.workflow.engine;

import org.drools.process.audit.NodeInstanceLog;
import org.drools.process.audit.ProcessInstanceLog;

/**
 * @author viseem
 * 
 */
public interface BamLogger {
  /**
   * Creates a new ProcessInstanceLog.
   * 
   * @param log The ProcessInstanceLog to save
   */
  void createProcessInstanceLog(ProcessInstanceLog log);

  /**
   * Updates the process log for the given process instance.
   * @param processInstanceId The process instance id
   */
  void updateProcessInstanceLog(long processInstanceId);

  /**
   * Creates a new NodeInstanceLog.
   * 
   * @param log The NodeInstanceLog to save
   */
  void createNodeInstanceLog(NodeInstanceLog log);

}
