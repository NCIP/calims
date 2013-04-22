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

import org.drools.process.instance.WorkItemHandler;
import org.drools.runtime.process.WorkItem;
import org.drools.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author viseem
 *
 */
public class TestWorkItemHandler implements WorkItemHandler {
  
  private static Logger log = LoggerFactory.getLogger(TestWorkItemHandler.class);

  /**
   * {@inheritDoc}
   */
  public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
    // Nothing to do

  }

  /**
   * {@inheritDoc}
   */
  public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
    log.debug("start of TestWorkItemHandler executeWorkItem");
    Long term1 = (Long) workItem.getParameter("term1");
    Long term2 = (Long) workItem.getParameter("term2");
    String message = (String) workItem.getParameter("message");
    log.debug("term1 = {}", term1);
    log.debug("term2 = {}", term2);
    log.debug("message = {}", message);
    if (term1 != null && term2 != null) {
      Long result = term1 + term2;
      workItem.getResults().put("result", result);
    }
    manager.completeWorkItem(workItem.getId(), null);
  }

}
