/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The calims2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This calims2 Software License (the License) is between NCI and You. You (or 
 * Your) shall mean a person or an entity, and all other entities that control, 
 * are controlled by, or are under common control with the entity. Control for 
 * purposes of this definition means (i) the direct or indirect power to cause 
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares, 
 * or (iii) beneficial ownership of such entity. 
 *
 * This License is granted provided that You agree to the conditions described 
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up, 
 * no-charge, irrevocable, transferable and royalty-free right and license in 
 * its rights in the calims2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the calims2 Software; (ii) distribute and 
 * have distributed to and by third parties the calims2 Software and any 
 * modifications and derivative works thereof; and (iii) sublicense the 
 * foregoing rights set out in (i) and (ii) to third parties, including the 
 * right to license such rights to further third parties. For sake of clarity, 
 * and not by way of limitation, NCI shall have no right of accounting or right 
 * of payment from You or Your sub-licensees for the rights granted under this 
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the 
 * above copyright notice, this list of conditions and the disclaimer and 
 * limitation of liability of Article 6, below. Your redistributions in object 
 * code form must reproduce the above copyright notice, this list of conditions 
 * and the disclaimer of Article 6 in the documentation and/or other materials 
 * provided with the distribution, if any. 
 *
 * Your end-user documentation included with the redistribution, if any, must 
 * include the following acknowledgment: This product includes software 
 * developed by Moxie Informatics and the National Cancer Institute. If You do not include 
 * such end-user documentation, You shall include this acknowledgment in the 
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "Moxie Informatics" 
 * to endorse or promote products derived from this Software. This License does 
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or Moxie Informatics, except as required to comply with the 
 * terms of this License. 
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this 
 * Software into Your proprietary programs and into any third party proprietary 
 * programs. However, if You incorporate the Software into third party 
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software 
 * into such third party proprietary programs and for informing Your 
 * sub-licensees, including without limitation Your end-users, of their 
 * obligation to secure any required permissions from such third parties before 
 * incorporating the Software into such third party proprietary software 
 * programs. In the event that You fail to obtain such permissions, You agree 
 * to indemnify NCI for any claims against NCI by such third parties, except to 
 * the extent prohibited by law, resulting from Your failure to obtain such 
 * permissions. 
 *
 * For sake of clarity, and not by way of limitation, You may add Your own 
 * copyright statement to Your modifications and to the derivative works, and 
 * You may provide additional or different license terms and conditions in Your 
 * sublicenses of modifications of the Software, or any derivative works of the 
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, 
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, 
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO 
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, MOXIE INFORMATICS OR THEIR 
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
