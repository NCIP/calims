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

import org.drools.audit.WorkingMemoryLogger;
import org.drools.audit.event.LogEvent;
import org.drools.audit.event.RuleFlowLogEvent;
import org.drools.audit.event.RuleFlowNodeLogEvent;
import org.drools.event.KnowledgeRuntimeEventManager;
import org.drools.process.audit.NodeInstanceLog;
import org.drools.process.audit.ProcessInstanceLog;

/**
 * @author viseem
 * 
 */
public class WorkingMemoryDatabaseLogger extends WorkingMemoryLogger {

  private BamLogger bamLogger;

  /**
   * Constructor.
   * 
   * @param session The drools session to log
   * @param bamLogger The bamLogger. It should be configured for REQUIRE_NEW transactions.
   */
  public WorkingMemoryDatabaseLogger(KnowledgeRuntimeEventManager session, BamLogger bamLogger) {
    super(session);
    this.bamLogger = bamLogger;
  }

  /**
   * 
   * {@inheritDoc}
   */
  public void logEventCreated(LogEvent logEvent) {
    switch (logEvent.getType()) {
      case LogEvent.BEFORE_RULEFLOW_CREATED: {
        RuleFlowLogEvent processEvent = (RuleFlowLogEvent) logEvent;
        ProcessInstanceLog log = new ProcessInstanceLog(processEvent.getProcessInstanceId(), processEvent.getProcessId());
        bamLogger.createProcessInstanceLog(log);
        break;
      }
      case LogEvent.AFTER_RULEFLOW_COMPLETED: {
        RuleFlowLogEvent processEvent = (RuleFlowLogEvent) logEvent;
        bamLogger.updateProcessInstanceLog(processEvent.getProcessInstanceId());
        break;
      }
      case LogEvent.BEFORE_RULEFLOW_NODE_TRIGGERED: {
        RuleFlowNodeLogEvent nodeEvent = (RuleFlowNodeLogEvent) logEvent;
        NodeInstanceLog log = new NodeInstanceLog(NodeInstanceLog.TYPE_ENTER, nodeEvent.getProcessInstanceId(), nodeEvent
            .getProcessId(), nodeEvent.getNodeInstanceId(), nodeEvent.getNodeId());
        bamLogger.createNodeInstanceLog(log);
        break;
      }
      case LogEvent.BEFORE_RULEFLOW_NODE_EXITED: {
        RuleFlowNodeLogEvent nodeEvent = (RuleFlowNodeLogEvent) logEvent;
        NodeInstanceLog log = new NodeInstanceLog(NodeInstanceLog.TYPE_EXIT, nodeEvent.getProcessInstanceId(), nodeEvent
            .getProcessId(), nodeEvent.getNodeInstanceId(), nodeEvent.getNodeId());
        bamLogger.createNodeInstanceLog(log);
        break;
      }
      default: {
        // ignore all other events
        break;
      }
    }

  }
}
