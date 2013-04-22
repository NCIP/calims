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

import org.drools.KnowledgeBase;
import org.drools.runtime.Environment;
import org.drools.runtime.StatefulKnowledgeSession;

/**
 * @author viseem
 *
 */
public interface SessionLoader {
  StatefulKnowledgeSession loadSession(KnowledgeBase kbase, Environment environment);
}
