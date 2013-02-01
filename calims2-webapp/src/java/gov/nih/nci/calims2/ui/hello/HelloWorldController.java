/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The caLIMS
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This caLIMS Software License (the License) is between NCI and You. You (or 
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
 * its rights in the caLIMS Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the caLIMS Software; (ii) distribute and 
 * have distributed to and by third parties the caLIMS Software and any 
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
package gov.nih.nci.calims2.ui.hello;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.report.query.EntityDescriptor;
import gov.nih.nci.calims2.business.report.query.MetadataService;
import gov.nih.nci.calims2.business.report.query.PropertyDescriptor;
import gov.nih.nci.calims2.business.report.query.QueryService;
import gov.nih.nci.calims2.business.report.query.RelationshipDescriptor;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.inventory.Container;

/**
 * @author viseem
 * 
 */
@Controller
@RequestMapping("/hello")
public class HelloWorldController {
  
  private static Logger log = LoggerFactory.getLogger(HelloWorldController.class);
  
  private SessionFactory sessionFactory;
  private MetadataService metadataService;
  private String tempfiledir;
   private QueryService queryService;
 //  private ProcessEngine processEngineService;
 //  private TaskEngine taskEngine;
  
  /**
   * Example of indexed properties.
   * @return The name of the view for example1
   */
  @RequestMapping("/example1.do")
  public String viewExample1() {
    log.debug("viewExample1");
    return "hello.example1";
  }
  
  /**
   * Example of indexed properties.
   * @param form The submitted form
   * @return The name of the view for example2
   */
  @RequestMapping("/example2.do")
  public ModelAndView viewExample2(@ModelAttribute("form")ExampleForm form) {
    log.debug("viewExample2");
    ModelAndView model = new ModelAndView();
    model.addObject("names", form.getName());
    model.setViewName("hello.example2");
    return model;
  }
  
  /**
   * Example of indexed properties.
   * @param model The model
   * @return The name of the view for example2
   */
  
  @RequestMapping("/viewForm.do")
      public ModelAndView getUploadForm() {
       ModelAndView model = new ModelAndView();
       model.addObject("form" , new UploadItem());
       model.setViewName("hello.uploadForm");
       return model;
      }
  
  /**
   * Example of indexed properties.
   * @param uploadItem The file.
   * @param result The bindingresult.
   * @return The name of the view for example2
   * @throws NamingException 
   */   
  @RequestMapping("/uploadForm.do")
      public ModelAndView create(UploadItem uploadItem, BindingResult result) throws NamingException {
        ModelAndView model = new ModelAndView();
        if (result.hasErrors()) {
          for (ObjectError error : result.getAllErrors()) {
            log.debug("Error: " + error.getCode() +  " - " + error.getDefaultMessage());
            model.setViewName("hello.loadFailed");
          }
        } else {
          MultipartFile file = uploadItem.getFileData();  
          File dir = new File(tempfiledir);
          try {
            
            File tempFile = File.createTempFile("xasdfasfd","yasdfasfd", dir);
            file.transferTo(tempFile);
            log.debug("ABSOLUTE PATH TO file: " + tempFile.getAbsolutePath());
            log.debug("CANONICAL PATH TO file: " + tempFile.getCanonicalPath());
            log.debug("CANONICAL PATH TO file: " + tempFile.getName());
            log.debug("PATH TO file: " + tempFile.getPath());
            log.debug("***********************************************************************");
            log.debug("***********************************************************************");
            log.debug("***********************************************************************");
            log.debug("***********************************************************************");
            log.debug("***********************************************************************");
            log.debug("***********************************************************************");
            log.debug("***********************************************************************");
            log.debug("***********************************************************************");
            
          } catch (IllegalStateException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
          }
        model.setViewName("hello.loadSucceeded");
      }
      return model;
}
  
  
  /**
   * Example of report.
   * @param response The Http response
   */
  @RequestMapping("/viewReport.do")
  public void viewReport(HttpServletResponse response) {
    log.debug("viewReport");
    Session session = sessionFactory.getCurrentSession();
    try {
      ServletOutputStream servletOutputStream = response.getOutputStream();
      //need to get the path to the jrxml
      //
      
      JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/ContainerReport.jrxml"));
      Map<String, Object> parameterMap = new HashMap<String, Object>();
      parameterMap.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION, session);
      response.setContentType("application/pdf");    
      byte [] reportResult = JasperRunManager.runReportToPdf(report, parameterMap);
      servletOutputStream.write(reportResult);
      servletOutputStream.flush();
      servletOutputStream.close();
    } catch (JRException e) {
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      response.setContentType("text/plain");
      try {
        response.getOutputStream().print(stringWriter.toString());
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      e.printStackTrace();
    } catch (IOException e) {
      
      e.printStackTrace();
    }
  }
  
  /**
   * Example of report.
   * 
   * @param response The Http response
   */
  @RequestMapping("/viewReport1.do")
  public void viewReport1(HttpServletResponse response) {
    log.debug("viewReport");
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Collection<Container> list = session.createQuery("from gov.nih.nci.calims2.domain.inventory.Container ").list();
    JRBeanCollectionDataSource dataSource;
    dataSource = new JRBeanCollectionDataSource(list);
    session.getTransaction().commit();
    try {
      ServletOutputStream servletOutputStream = response.getOutputStream();
      JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/ContainerReport1.jrxml"));
      Map<String, Object> parameterMap = new HashMap<String, Object>();
      response.setContentType("application/pdf");
      byte[] reportResult = JasperRunManager.runReportToPdf(report, parameterMap, dataSource);
      servletOutputStream.write(reportResult);

      servletOutputStream.flush();
      servletOutputStream.close();
    } catch (JRException e) {
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      response.setContentType("text/plain");
      try {
        response.getOutputStream().print(stringWriter.toString());
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      e.printStackTrace();
    } catch (IOException e) {

      e.printStackTrace();
    }
  }
  /**
   * Example of indexed properties.
   * @return The name of the view for example2
   */
  @RequestMapping("/example3.do")
  public ModelAndView viewExample3() {
    log.debug("viewExample3");
    ModelAndView model = new ModelAndView();
    EntityDescriptor desc = metadataService.getEntityDescriptor(Account.class);
    logDescriptor(desc);
    desc = metadataService.getEntityDescriptor(Container.class);
    logDescriptor(desc);
    /*desc = metadataService.getEntityDescriptor(Protein.class);
    logDescriptor(desc);
    Query query = queryService.findById(Query.class, queryId);
    List<Container> containers = queryService.findByQuery(query);
    for (Container container : containers) {
      log.debug("Container name = {}", container.getName());
    }*/
    model.setViewName("hello.example3");
    return model;
  }
  
  private void logDescriptor(EntityDescriptor desc) {
    log.debug("Class = {}", desc.getPersistentClass().getName());
    for (PropertyDescriptor pdesc : desc.getProperties()) {
      log.debug("property name {} - Type {}", pdesc.getName(), pdesc.getType());
    }
    for (RelationshipDescriptor rdesc : desc.getRelationships()) {
      log.debug("relationship name {} - type {}", rdesc.getName(), rdesc.getPersistentClass().getName());
      for (PropertyDescriptor pdesc : rdesc.getProperties()) {
        log.debug("property name {} - Type {}", pdesc.getName(), pdesc.getType());
      }
    }
  }
  
  /**
   * Example of indexed properties.
   * 
   * @return The name of the view for example2
   */
  @RequestMapping("/example4.do")
  public ModelAndView viewExample4(@RequestParam(value = "pid", defaultValue = "com.sample.bpmn.sample4") String pid) {
    log.debug("viewExample4");
    ModelAndView model = new ModelAndView();
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("testVariable", "This is the testVariable");
    params.put("term1", new Long(1));
    params.put("term2", new Long(2));
    //processEngineService.startProcess(pid, params);
    model.setViewName("hello.example3");
    return model;
  }

/*  *//**
   * Example of indexed properties.
   * 
   * @return The name of the view for example2
   *//*
  @RequestMapping("/example5.do")
  public ModelAndView viewExample5() {
    log.debug("viewExample5");
    ModelAndView model = new ModelAndView();
    List<TaskListItem> tasks = taskEngine.getTasksForUser("adminuser");
    for (TaskListItem summary : tasks) {
      log.debug("**************************************************");
      log.debug("name = {}", summary.getName());
      log.debug("subject = {}", summary.getSubject());
      log.debug("description = {}", summary.getDescription());
      log.debug("status = {}", summary.getStatus());
     // Task task = taskEngine.getTask(summary.getId());
     // log.debug("workitemId = {}", task.getTaskData().getWorkItemId());
     // for(I18NText text  : task.getNames()) {
     ///   log.debug("name = {}", text.getText());
     // }
//      WorkItem workItem = processEngineService.findWorkItemById(task.getTaskData().getWorkItemId());
//      for (Map.Entry<String, Object> entry : workItem.getParameters().entrySet()) {
//        log.debug("Paramater {} = {}", entry.getKey(), entry.getValue());
//      }
      log.debug("**************************************************");
    }
    model.setViewName("hello.example3");
    return model;
  }
*/
  /**
   * @param sessionFactory the sessionFactory to set
   */
  @Resource(name = "sessionFactory")
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  /**
   * @param metadataService the metadataService to set
   */
  @Resource(name = "metadataService")
  public void setMetadataService(MetadataService metadataService) {
    this.metadataService = metadataService;
  }
 /**
   * @param queryService the queryService to set
   */
  @Resource(name = "queryService")
  public void setQueryService(QueryService queryService) {
    this.queryService = queryService;
  }
  /**
   * @param tempfiledir the tempfiledir to set
   */
  @Resource(name = "tempfiledir")
  public void setTempfiledir(String tempfiledir) {
    this.tempfiledir = tempfiledir;
    log.debug("TempFileDir" + tempfiledir);
    log.debug("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    log.debug("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    log.debug("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    log.debug("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    log.debug("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
  }
 /* 
  *//**
   * @param processEngineService the processEngineService to set
   *//*
  @Resource(name  = "processEngineService")
  public void setProcessEngineService(ProcessEngine processEngineService) {
    this.processEngineService = processEngineService;
  }*/
/*
  *//**
   * @param taskEngine the taskService to set
   *//*
  @Resource(name  = "taskEngine")
  public void setTaskEngine(TaskEngine taskEngine) {
    this.taskEngine = taskEngine;
  }*/

  

}
