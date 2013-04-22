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

import java.util.Map;

import org.drools.process.instance.WorkItem;


/**
 * @author viseem
 *
 */
public interface ProcessEngine {

  /**
   * Start a process. 
   * @param pid The id of the process.
   * @param parameters The Map of process parameters
   */
  void startProcess(String pid, Map<String, Object> parameters);
  
  /**
   * Gets a workItem by id.
   * @param workItemId The id of the workItem
   * @return The workItem withthe given id
   */
  WorkItem findWorkItemById(long workItemId);
  
}
