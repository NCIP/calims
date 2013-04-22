/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.workflow.tasklist;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import gov.nih.nci.calims2.business.workflow.taskclient.TaskEngine;
import gov.nih.nci.calims2.business.workflow.taskclient.TaskListItem;
import gov.nih.nci.calims2.business.workflow.taskclient.TaskTransition;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.util.interceptor.FlowContextInterceptor;
import gov.nih.nci.calims2.uic.descriptor.TableDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * @author viseem
 *
 */
//@Controller
@RequestMapping(TaskListController.URL_PREFIX)
public class TaskListController {
  
  private static Logger log = LoggerFactory.getLogger(TaskListController.class);
  
  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/workflow/tasklist";
  
  private CRUDControllerConfig config = new CRUDControllerConfig();
  private Map<String, CommandFilter> taskCommandFilters;
  private MessageSource messageSource;
  private PrivilegeEvaluator privilegeEvaluator;
  private Table listTable;
  private TaskEngine taskEngine;
  
  /**
   * Default constructor.
   */
  public TaskListController() {
    config.setUrlAndViewPrefixes(URL_PREFIX);
  }
  
  /**
   * Executes a transition on a given task.
   * 
   * @param model The current model
   * @param locale The current locale
   * @param transition The transition name
   * @param id The id of the task.
   * @return The list view name
   */
  @RequestMapping("/{transition}Task.do")
  public String executeTaskTransition(Model model, Locale locale, @PathVariable("transition") String transition,
      @RequestParam("id") Long id) {
    logMethod("executeTaskTransition");
    taskEngine.executeTaskTransition(privilegeEvaluator.getCurrentUsername(), TaskTransition.valueOf(transition.toUpperCase()), id);
    return list(model, locale);
  }
  
  /**
   * Completes a given task.
   * 
   * @param model The current model
   * @param locale The current locale
   * @param id The id of the task to complete.
   * @return The list view name
   */
  @RequestMapping("/complete.do")
  public String complete(Model model, Locale locale, @RequestParam("id") Long id) {
    logMethod("complete");
    taskEngine.completeTask(privilegeEvaluator.getCurrentUsername(), id);
    return list(model, locale);
  }

  /**
   * Fails a given task.
   * 
   * @param model The current model
   * @param locale The current locale
   * @param id The id of the task to fail.
   * @return The list view name
   */
  @RequestMapping("/fail.do")
  public String fail(Model model, Locale locale, @RequestParam("id") Long id) {
    logMethod("fail");
    taskEngine.failTask(privilegeEvaluator.getCurrentUsername(), id);
    return list(model, locale);
  }
  
  /**
   * Generates the task list.
   * @param model 
   * 
   * @param locale The current Locale.
   * @return The list view
   */
  @RequestMapping(CRUDControllerConfig.STD_LIST_COMMAND)
  public String list(Model model, Locale locale) {
    logMethod("list");
    List<TaskListItem> rows = taskEngine.getTasksForUser(privilegeEvaluator.getCurrentUsername());
    model.addAttribute(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
    TableDecorator<TaskListItem> tableDecorator = createTableDecorator(locale, rows);
    model.addAttribute("tableDecorator", tableDecorator);
    return config.getFullViewName(config.getListView());
  }
  
  /**
   * Creates and initialize the table decorator for the generation of the list page.
   * @param locale The current locale.
   * @param rows The list of entities that will be displayed in the list page.
   * @return The new table decorator
   */
  protected TableDecorator<TaskListItem> createTableDecorator(Locale locale, List<TaskListItem> rows) {
    TaskListTableDecorator tableDecorator = new TaskListTableDecorator();
    tableDecorator.setTaskCommandFilters(taskCommandFilters);
    tableDecorator.setConfig(config);
    tableDecorator.setLocale(locale);
    tableDecorator.setMessageSource(messageSource);
    tableDecorator.setPrivilegeEvaluator(privilegeEvaluator);
    tableDecorator.setRows(rows);
    tableDecorator.setTable(listTable);
    tableDecorator.init();
    return tableDecorator;
  }
  
  /**
   * Log a descriptive message for the given metod name.
   * 
   * @param methodName The name of the method.
   */
  protected void logMethod(String methodName) {
    if (log.isDebugEnabled()) {
      Object[] args = new Object[] {methodName, getClass().getSimpleName(), FlowContextHolder.getContext().size() };
      log.debug("Entering {} - Controller = {} Context size = {}", args);
    }
  }
  
  /**
   * @param messageSource the messageSource to set
   */
  @Resource
  public void setMessageSource(MessageSource messageSource) {
    this.messageSource = messageSource;
  }
  
  /**
   * @param privilegeEvaluator the privilegeEvaluator to set
   */
  @Resource(name = "privilegeEvaluator")
  public void setPrivilegeEvaluator(PrivilegeEvaluator privilegeEvaluator) {
    this.privilegeEvaluator = privilegeEvaluator;
  }

  /**
   * @param taskCommandFilters the taskCommandFilters to set
   */
  @Resource(name = "taskCommandFilters")
  public void setTaskCommandFilters(Map<String, CommandFilter> taskCommandFilters) {
    this.taskCommandFilters = taskCommandFilters;
  }

  /**
   * @param taskEngine the taskEngine to set
   */
  @Resource(name = "taskEngine")
  public void setTaskEngine(TaskEngine taskEngine) {
    this.taskEngine = taskEngine;
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "taskTable")
  public void setListTable(Table listTable) {
    this.listTable = listTable;
  }
}
