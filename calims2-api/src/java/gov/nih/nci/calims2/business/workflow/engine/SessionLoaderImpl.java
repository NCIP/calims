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

import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.persistence.jpa.JPAKnowledgeService;
import org.drools.persistence.session.SessionInfo;
import org.drools.runtime.Environment;
import org.drools.runtime.StatefulKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.nih.nci.calims2.dao.GenericDao;

/**
 * @author viseem
 *
 */
public class SessionLoaderImpl implements SessionLoader {
  private static Logger log = LoggerFactory.getLogger(SessionLoaderImpl.class);
  
  private GenericDao bpmGenericDao; 
  
  public StatefulKnowledgeSession loadSession(KnowledgeBase kbase, Environment environment) {
    log.debug("loadSession");
    List<SessionInfo> sessions = bpmGenericDao.findAll(SessionInfo.class, "id desc");
    if (sessions == null || sessions.isEmpty()) {
      log.debug("new StatefulKnowledgeSession");
      return JPAKnowledgeService.newStatefulKnowledgeSession(kbase, null, environment);
    }
    log.debug("Existing StatefulKnowledgeSession with id {}", sessions.get(0).getId());
    return JPAKnowledgeService.loadStatefulKnowledgeSession(sessions.get(0).getId(), kbase, null, environment);
  }

  /**
   * @param bpmGenericDao the bpmGenericDao to set
   */
  public void setBpmGenericDao(GenericDao bpmGenericDao) {
    this.bpmGenericDao = bpmGenericDao;
  }

}
