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

import javax.persistence.EntityManagerFactory;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.persistence.processinstance.VariablePersistenceStrategyFactory;
import org.drools.persistence.processinstance.WorkItemInfo;
import org.drools.process.instance.WorkItem;
import org.drools.process.workitem.wsht.CommandBasedWSHumanTaskHandler;
import org.drools.runtime.Environment;
import org.drools.runtime.EnvironmentName;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import gov.nih.nci.calims2.dao.GenericDao;

/**
 * @author viseem
 *
 */
public class ProcessEngineImpl implements ProcessEngine {
  
  private static Logger log = LoggerFactory.getLogger(ProcessEngineImpl.class);
  
  private BamLogger bamLogger;
  private GenericDao bpmGenericDao; 
  private EntityManagerFactory entityManagerFactory;
  private StatefulKnowledgeSession session;
  private SessionLoader sessionLoader;
  private PlatformTransactionManager transactionManager;
  
  /**
   * Initialization method.
   */
  public void init() {
    log.debug("ProcessEngineImpl init");
    KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
    // //File file = new File("/Users/viseem/drools/sample2.bpmn");
    kbuilder.add(ResourceFactory.newClassPathResource("sample1.bpmn"), ResourceType.BPMN2);
    kbuilder.add(ResourceFactory.newClassPathResource("sample2.bpmn"), ResourceType.BPMN2);
    kbuilder.add(ResourceFactory.newClassPathResource("sample3.bpmn"), ResourceType.BPMN2);
    kbuilder.add(ResourceFactory.newClassPathResource("sample4.bpmn"), ResourceType.BPMN2);
    kbuilder.add(ResourceFactory.newClassPathResource("sample5.bpmn"), ResourceType.BPMN2);
    KnowledgeBase kbase = kbuilder.newKnowledgeBase();

    Environment environment = KnowledgeBaseFactory.newEnvironment();
    environment.set(EnvironmentName.ENTITY_MANAGER_FACTORY, entityManagerFactory);
    environment.set(EnvironmentName.TRANSACTION_MANAGER, ((JtaTransactionManager) transactionManager).getTransactionManager());
    VariablePersistenceStrategyFactory.getVariablePersistenceStrategy().setPersister("java.io.Serializable",
        "org.drools.persistence.processinstance.persisters.SerializableVariablePersister");
    session = sessionLoader.loadSession(kbase, environment);
    WorkItemManager workItemManager = session.getWorkItemManager();
    workItemManager.registerWorkItemHandler("TestWorkItem", new TestWorkItemHandler());
    CommandBasedWSHumanTaskHandler humanTaskHandler =  new CommandBasedWSHumanTaskHandler(session);
    workItemManager.registerWorkItemHandler("Human Task", humanTaskHandler);
    humanTaskHandler.connect();
    new WorkingMemoryDatabaseLogger(session, bamLogger);
  }

  /**
   * Termination method.
   */
  public void destroy() {
    log.debug("ProcessEngineImpl destroy");
    session.dispose();
  }

  /**
   * {@inheritDoc}
   */
  public void startProcess(String pid, Map<String, Object> variables) {
    log.debug("ProcessEngineImpl startProcess");
    log.debug("pid = {}", pid);
    session.startProcess(pid, variables);
  }
  
  /**
   * {@inheritDoc}
   */
  public WorkItem findWorkItemById(long workItemId) {
    WorkItemInfo workItemInfo = bpmGenericDao.findById(WorkItemInfo.class, workItemId);
    Environment environment = KnowledgeBaseFactory.newEnvironment();
    environment.set(EnvironmentName.ENTITY_MANAGER_FACTORY, entityManagerFactory);
    environment.set(EnvironmentName.TRANSACTION_MANAGER, ((JtaTransactionManager) transactionManager).getTransactionManager());
    WorkItem workItem = workItemInfo.getWorkItem(environment);
    return workItem;
  }

  /**
   * @param bamLogger the bamLogger to set
   */
  public void setBamLogger(BamLogger bamLogger) {
    this.bamLogger = bamLogger;
  }

  /**
   * @param bpmGenericDao the bpmGenericDao to set
   */
  public void setBpmGenericDao(GenericDao bpmGenericDao) {
    this.bpmGenericDao = bpmGenericDao;
  }

  /**
   * @param entityManagerFactory the entityManagerFactory to set
   */
  public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  /**
   * @param sessionLoader the sessionLoader to set
   */
  public void setSessionLoader(SessionLoader sessionLoader) {
    this.sessionLoader = sessionLoader;
  }

  /**
   * @param transactionManager the transactionManager to set
   */
  public void setTransactionManager(PlatformTransactionManager transactionManager) {
    this.transactionManager = transactionManager;
  }

  

}
