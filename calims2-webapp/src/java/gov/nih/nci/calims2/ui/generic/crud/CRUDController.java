/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.generic.crud;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.report.query.QueryService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationMessageHelper;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.ui.util.interceptor.FlowContextInterceptor;
import gov.nih.nci.calims2.uic.descriptor.TableDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * The Base controller class that implements the standard crud page flow.
 * 
 * @author viseem
 * @param <T> The type of Entity processed with the form.
 * 
 */
public abstract class CRUDController<T extends EntityWithId> {

  private static Logger log = LoggerFactory.getLogger(CRUDController.class);
  private static final String QUERY_BY_PERSISTENT_CLASS_QUERY = Query.class.getName() + ".findQueriesByPersistentClassName";
  private Class<T> persistentClass;
  private Class<? extends CRUDForm<T>> formClass;
  @SuppressWarnings("unchecked")
  private Class<? extends CRUDTableDecorator> tableDecoratorClass;
  private CRUDControllerConfig config = new CRUDControllerConfig();
  private GenericService<T> mainService;
  private MessageSource messageSource;
  private PrivilegeEvaluator privilegeEvaluator;
  private CRUDFormDecorator formDecorator;
  private Table listTable;
  private QueryService queryService;
  private NotesHelper notesHelper;

  /**
   * Default constructor.
   */
  public CRUDController() {
    // Nothing to do
  }

  /**
   * Convenience constructor for the most common subclasses.
   * 
   * @param urlPrefix The url prefix.
   * @param orderByClause The orderByClause.
   */
  @SuppressWarnings("unchecked")
  public CRUDController(String urlPrefix, String orderByClause) {
    config.setUrlAndViewPrefixes(urlPrefix);
    config.setOrderByClause(orderByClause);
    setPersistentClass((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    String formClassName = getClass().getPackage().getName() + "." + getPersistentClass().getSimpleName() + "Form";
    try {
      setFormClass((Class<? extends CRUDForm<T>>) Class.forName(formClassName));
    } catch (ClassNotFoundException e) {
      throw new InternalError("Class " + formClassName + " not found");
    }
    tableDecoratorClass = getDefaultTableDecoratorClass();
  }
  
  /**
   * Gets the TableDecorator class that will be used By default by this controller.
   * This method implements the default naming convention that follows : If a Class named <T>TableDecorator exists in the same
   * package, it will be used. If not, it returns the default CRUDTableDecorator class.
   * Subclasses should overwrite this method if the naming convention above is not appropriate.
   * 
   * @return The TableDecorator class to use
   */
  @SuppressWarnings("unchecked")
  protected Class<? extends CRUDTableDecorator> getDefaultTableDecoratorClass() {
    String tdClassName = getClass().getPackage().getName() + "." + getPersistentClass().getSimpleName() + "TableDecorator";
    try {
      return  (Class<? extends CRUDTableDecorator>) Class.forName(tdClassName);
    } catch (ClassNotFoundException e) {
      return CRUDTableDecorator.class;
    }
  }

  /**
   * Calls a subflow from the list page.
   * 
   * @param id The id of the entity for which then subflow is called
   * @param subFlowId The id of the subflow
   * @return The Model and view that forward to the subflow
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_FROM_LIST_COMMAND)
  public ModelAndView callFromList(@RequestParam("id") Long id, @RequestParam("subFlowId") int subFlowId) {
    logMethod("callFromList");
    ModelAndView model = new ModelAndView();
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame.setReturnUrl(config.getForwardUrl(config.getListCommand()));
    frame.addAttribute("id", id);
    frame.addAttribute("persistentClass", getPersistentClass());
    frame.addAttribute("subFlowId", subFlowId);
    model.setView(new InternalResourceView(config.getSubFlowUrls()[subFlowId]));
    return model;
  }

  /**
   * Cancel the save action.
   * 
   * @param returnView The view to return to
   * 
   * @return The next view to go to.
   */
  @RequestMapping(CRUDControllerConfig.STD_CANCEL_SAVE_COMMAND)
  public ModelAndView cancelSave(@RequestParam("returnView") String returnView) {
    logMethod("cancelSave");
    ModelAndView model = new ModelAndView();
    Stack<StackFrame> context = FlowContextHolder.getContext();
    String returnUrl = context.peek().getReturnUrl();
    if (returnUrl == null) {
      returnUrl = returnView;
    }
    model.setView(new InternalResourceView(returnUrl));
    return model;
  }
  
  /**
   * Makes a call to the service layer retrieving a type based on an id then displays the type in an edit page.
   * 
   * @param id The id of the identity to display in the view.
   * @param currentView The view in which the edit command was issued.
   * @param locale The current locale.
   * @return The edit view.
   */
  @RequestMapping(CRUDControllerConfig.STD_COPY_COMMAND)
  public ModelAndView copy(@RequestParam("id") Long id,
                           @RequestParam(value = "currentView", defaultValue = "call") String currentView, Locale locale) {
    logMethod("copy");
    T entity = mainService.findById(persistentClass, id);
    return createEditModel(mainService.copy(entity), currentView, locale);
  }

  /**
   * Generates the create new type page.
   * 
   * @param currentView The view in which the edit command was issued.
   * @param locale The current locale.
   * @return The new type view.
   */
  @RequestMapping(CRUDControllerConfig.STD_CREATE_COMMAND)
  public ModelAndView create(@RequestParam(value = "currentView", defaultValue = "call") String currentView, Locale locale) {
    logMethod("create");
    return createEditModel(mainService.createDefault(persistentClass), currentView, locale);
  }

  /**
   * Complete the standard model for the details view.
   * 
   * @param model The standard model for the details view.
   * @param locale The current locale.
   * @return The completed model for the details view.
   */
  public ModelAndView completeDetailsModel(ModelAndView model, Locale locale) {
    return model;
  }
  
  /**
   * Complete the standard edit form.
   * The purpose of this method is to provide a hook for subclasses that need to set additional fields in the form
   * before rendering it.
   * @param form The edit form
   * @param entity The entity to edit
   */
  public void completeEditForm(CRUDForm<T> form, T entity) {
    // Nothing to do.
  }
  
  /**
   * Completes the data extraction for the edit form.
   * The purpose of this method is to provide a hook for subclasses that need to convert additional fields in the form
   * before saving the data.
   * @param form The edit form
   */
  public void completeExtraction(CRUDForm<T> form) {
   // Nothing to do.
  }
  
  /**
   * Complete the standard model for the edit view.
   * 
   * @param model The standard model for the edit view.
   * @param locale The current locale.
   * @return The completed model for the edit view.
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    return model;
  }
  
  /**
   * Complete the standard model for the list view.
   * 
   * @param model The standard model for the list view.
   * @param locale The current locale.
   * @return The completed model for the list view.
   */
  public ModelAndView completeListModel(ModelAndView model, Locale locale) {
    return model;
  }
  
  /**
   * Complete the standard model for the manage view.
   * 
   * @param model The standard model for the manage view.
   * @param locale The current locale.
   * @return The completed model for the manage view.
   */
  public ModelAndView completeManageModel(ModelAndView model, Locale locale) {
    return model;
  }

  /**
   * Builds the model for the edit view with the given entity and returnView.
   * 
   * @param entity The type entity to be put into the PersonForm object being added to the ModelAndView
   * @param returnView The view to which cancel should go back.
   * @param locale The current locale.
   * @return ModelAndView The ModelAndView object for editing or creating a new Person. The returned model should contain the form,
   *         the flowContext and the view name. The form is not created if no entity is given.
   */
  @SuppressWarnings("unchecked")
  public ModelAndView createEditModel(T entity, String returnView, Locale locale) {
    ModelAndView model = new ModelAndView();
    if (entity != null) {
      CRUDForm<T> form = createForm();
      form.setEntity(entity);
      form.setEditMode(entity.getId() != null);
      form.setCurrentView("edit");
      form.setReturnView(returnView);
      completeEditForm(form, entity);
      model.addObject("form", form);
    }
    model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
    model.addObject("config", config);
    model.addObject("formDecorator", formDecorator);
    model.setViewName(config.getFullViewName(config.getEditView()));
    if (EntityWithNotes.class.isAssignableFrom(persistentClass)) {
      log.debug("notesHelper.completeEditModel");
      notesHelper.completeEditModel(model, locale, (GenericService<EntityWithNotes>) mainService,
          (Class<EntityWithNotes>) persistentClass);
    }
    model = completeEditModel(model, locale);
    return model;
  }

  /**
   * Creates an instance of the appropriate form.
   * @return A new instance of the appropriate form
   */
  public CRUDForm<T> createForm() {
    try {
      return formClass.newInstance();
    } catch (InstantiationException e) {
      throw new InternalError("Can not happen - form classes are concrete classes");
    } catch (IllegalAccessException e) {
      throw new InternalError("Can not happen - form classes have a public contructor");
    }
  }

  /**
   * Makes a call to delete a type object than returns a refreshed list type page.
   * 
   * @return The list view.
   * @param id The id of the object being deleted.
   */
  @RequestMapping(CRUDControllerConfig.STD_DELETE_COMMAND)
  public ModelAndView delete(@RequestParam("id") Long id) {
    logMethod("delete");
    ModelAndView model = new ModelAndView();
    try {
      mainService.delete(persistentClass, id);
      model.setViewName(config.getRedirectUrl(config.getListCommand()));
      model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.setPersistAttributeForClient(this));
    } catch (ValidationException e) {
      model.addObject("messagekey", "administration.person.create.validationerror");
      model.setViewName(config.getFullViewName(config.getListView()));
      model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
    }
    return model;
  }

  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  public ModelAndView doCall(CRUDForm<T> form, int subFlowId) {
    logMethod("doCall");
    ModelAndView model = new ModelAndView();
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame.setReturnUrl(config.getForwardUrl(config.getReturnCommand()));
    form.getSubmittedEntity();
    frame.addAttribute("form", form);
    frame.addAttribute("subFlowId", subFlowId);
    model.setView(new InternalResourceView(config.getSubFlowUrls()[subFlowId]));
    return model;
  }

  /**
   * Makes a call to the database to retrieve a type object based on an id then returns a detail type page.
   * 
   * 
   * @param id The id of the entity to be displayed in detail.
   * @param locale The current locale.
   * @return The detail view.
   */
  @RequestMapping(CRUDControllerConfig.STD_DETAILS_COMMAND)
  public ModelAndView details(@RequestParam("id") Long id, Locale locale) {
    logMethod("details");
    ModelAndView model = new ModelAndView();
    CRUDForm<T> form = createForm();
    form.setEntity(mainService.findById(persistentClass, id));
    form.setCurrentView(config.getForwardUrl(config.getDetailsCommand()));
    form.setViewMode(true);
    model.addObject("form", form);
    model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
    model.addObject("config", config);
    model.addObject("formDecorator", formDecorator);
    model.setViewName(config.getFullViewName(config.getDetailsView()));
    if (EntityWithNotes.class.isAssignableFrom(persistentClass)) {
      log.debug("notesHelper.completeDetailsModel");
      notesHelper.completeDetailsModel(model);
    }
    model = completeDetailsModel(model, locale);
    return model;
  }

  /**
   * Makes a call to the service layer retrieving a type based on an id then displays the type in an edit page.
   * 
   * @param id The id of the identity to display in the view.
   * @param currentView The view in which the edit command was issued.
   * @param locale The current locale.
   * @return The edit view.
   */
  @RequestMapping(CRUDControllerConfig.STD_EDIT_COMMAND)
  public ModelAndView edit(@RequestParam("id") Long id,
      @RequestParam(value = "currentView", defaultValue = "call") String currentView, Locale locale) {
    logMethod("edit");
    return createEditModel(mainService.findById(persistentClass, id), currentView, locale);
  }

  /**
   * Enter this subflow.
   * 
   * @param locale The current Locale.
   * @return The list view
   */
  @RequestMapping("/enterList.do")
  public ModelAndView enterList(Locale locale) {
    logMethod("enterList");
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = context.peek();
    StackFrame newFrame = new BaseStackFrame();
    newFrame.addAttribute("id", frame.getAttribute("id"));
    newFrame.addAttribute("persistentClass", frame.getAttribute("persistentClass"));
    context.push(newFrame);
    return list("call", null, locale);
  }

  /**
   * Return to the return url from a subflow.
   * 
   * @return The list view
   */
  @RequestMapping(CRUDControllerConfig.STD_RETURN_GENERIC_COMMAND)
  public ModelAndView genericReturnFromSubFlow() {
    logMethod("genericReturnFromSubFlow");
    ModelAndView model = new ModelAndView();
    Stack<StackFrame> context = FlowContextHolder.getContext();
    context.pop();
    StackFrame frame = context.pop();
    model.setView(new InternalResourceView(frame.getReturnUrl()));
    return model;
  }

  /**
   * Makes a call to the database retrieving all entities and returns the list page.
   * 
   * @param currentView The view in which the list command was issued.
   * @param locale The current Locale.
   * @param queryId The id of the query to be listed.
   * @return The list view
   */
  @RequestMapping(CRUDControllerConfig.STD_LIST_COMMAND)
  public ModelAndView list(@RequestParam(value = "currentView", defaultValue = "call") String currentView, 
      @RequestParam(value = "queryId", required = false) Long queryId, Locale locale) {
    logMethod("list");
    ModelAndView model = new ModelAndView();
    if (queryId != null) {
      StackFrame frame = FlowContextHolder.getContext().peek();
      frame.addAttribute("queryId", queryId);
    }
    List<T> rows = createList();
    model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
    model.addObject("currentView", config.getForwardUrl(config.getListCommand()));
    TableDecorator<T> tableDecorator = createTableDecorator(locale, rows);
    model.addObject("tableDecorator", tableDecorator);
    model.setViewName(config.getFullViewName(config.getListView()));
    model = completeListModel(model, locale);
    if (tableDecorator instanceof CRUDTableDecorator<?>) {
      ((CRUDTableDecorator<T>) tableDecorator).init();
    }
    return model;
  }

  /**
   * Creates the list of entities that will be displayed in the list page. By default, it is all the entities of type T that the
   * user can see. If a query has been chosen in the manage page, it is the result of that query
   * 
   * @return The list of entities that will be displayed in the list page.
   */
  public List<T> createList() {
    Long queryId = getCurrentQueryId();
    if (queryId != null) {
      return createAdvancedList(queryId);
    }
    return createDefaultList();
  }

  /**
   * create the list of entities returned by the advanced query with the given id.
   * 
   * @param queryId The id of the query
   * @return The list of entities returned by the advanced query with the given id
   */
  public List<T> createAdvancedList(Long queryId) {
    Query query = queryService.findById(Query.class, queryId);
    return queryService.findByQuery(query);
  }

  /**
   * Creates the default list of entities.
   * 
   * @return the default list of entities.
   */
  public List<T> createDefaultList() {
    return mainService.findAll(persistentClass, config.getOrderByClause());
  }

  /**
   * Creates and initialize the table decorator for the generation of the list page.
   * @param locale The current locale.
   * @param rows The list of entities that will be displayed in the list page.
   * @return The new table decorator
   */
  @SuppressWarnings("unchecked")
  protected TableDecorator<T> createTableDecorator(Locale locale, List<T> rows) {
    CRUDTableDecorator<T> tableDecorator = null;
    try {
      tableDecorator = tableDecoratorClass.newInstance();
    } catch (InstantiationException e) {
      throw new InternalError("Can not happen - table decorator classes are concrete classes");
    } catch (IllegalAccessException e) {
      throw new InternalError("Can not happen - table decorator classes have a public contructor");
    }
    tableDecorator.setConfig(config);
    tableDecorator.setLocale(locale);
    tableDecorator.setMessageSource(messageSource);
    tableDecorator.setPrivilegeEvaluator(privilegeEvaluator);
    tableDecorator.setRows(rows);
    tableDecorator.setTable(createTable());
    return tableDecorator;
  }
  
  /**
   * Return the table descriptor to use in the contruction of the table decorator. 
   * The default implementation just returns the table descriptor that is injected by Spring.
   * The intent is to override this method in Sub-classes that would pre-process the table descriptor in order to provide
   * a more dynamic table.
   * 
   * @return the table descriptor to use in the contruction of the table decorator. 
   */
  protected Table createTable() {
    return listTable;
  }
  
  /**
   * Gets the id of the Current advanced search query.
   * @return The id of the Current advanced search query or null if no query was chosen.
   */
  public Long getCurrentQueryId() {
    StackFrame frame = FlowContextHolder.getContext().peek();
    return (Long) frame.getAttribute("queryId");
  }

  /**
   * Generates the manage page.
   * 
   * @param locale The current Locale.
   * 
   * @return The name of the manage view
   */
  @RequestMapping(CRUDControllerConfig.STD_MANAGE_COMMAND)
  public ModelAndView manage(Locale locale) {
    logMethod("manage");
    ModelAndView model = new ModelAndView();
    Stack<StackFrame> context = FlowContextHolder.newContext();
    context.push(new BaseStackFrame());
    model.addObject("config", config);
    model.addObject("currentView", config.getForwardUrl(config.getManageCommand()));
    model.setViewName(config.getFullViewName(config.getManageView()));
    if (config.isAdvancedSearch()) {
      Map<String, Object> params = new HashMap<String, Object>();
      params.put("mainEntity", persistentClass.getName());
      List<Query> queries = queryService.findByNamedQuery(QUERY_BY_PERSISTENT_CLASS_QUERY, params);
      model.addObject("queries", queries);
    }
    model = completeManageModel(model, locale);
    model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
    return model;
  }

  /**
   * Return from a sub-flow call.
   * 
   * @param locale The current locale.
   * @return The next view to go to.
   */
  @SuppressWarnings("unchecked")
  @RequestMapping(CRUDControllerConfig.STD_RETURN_COMMAND)
  public ModelAndView returnFromSubFlow(Locale locale) {
    logMethod("returnFromSubFlow");
    StackFrame frame = FlowContextHolder.getContext().pop();
    CRUDForm<T> form = (CRUDForm<T>) frame.getAttribute("form");
    int subFlowId = (Integer) frame.getAttribute("subFlowId");
    ModelAndView model = createEditModel(form.getEntity(), form.getReturnView(), locale);
    model.addObject("form", form);
    doReturnFromFlow(model, subFlowId, (Long) frame.getReturnValue("id"));
    return model;
  }

  /**
   * Updates the model after return from a subflow.
   * 
   * @param model The model for the edit page.
   * @param subFlowId The subflow id of the subflow from which we return.
   * @param entityId The id of the entity just created.
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    // Nothing to do
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @return The list type view.
   * @param locale The current locale.
   * @param form The object containing the values of the entity to be saved.
   */
  public ModelAndView doSave(@ModelAttribute("form") CRUDForm<T> form, Locale locale) {
    logMethod("doSave");
    ModelAndView model = new ModelAndView();
    T input = form.getSubmittedEntity();
    try {
      completeExtraction(form);
      T output = (form.isEditMode()) ? mainService.update(input) : mainService.create(input);
      StackFrame frame = FlowContextHolder.getContext().peek();
      if (frame.getReturnUrl() == null) {
        model.setViewName(config.getRedirectUrl(config.getListCommand()));
      } else {
        frame.addReturnValue("id", output.getId());
        model.setViewName(CRUDControllerConfig.REDIRECT_PREFIX + frame.getReturnUrl());
      }
      model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.setPersistAttributeForClient(this));
    } catch (ValidationException e) {
      model = createEditModel(input, form.getReturnView(), locale);
      model.addObject("messagekey", ValidationMessageHelper.getErrors(e));
      model.addObject("form", form);
      model.setViewName(config.getFullViewName(config.getEditView()));
      model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
    }
    return model;
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
   * @return the persistentClass
   */
  public Class<T> getPersistentClass() {
    return persistentClass;
  }

  /**
   * @param persistentClass the persistentClass to set
   */
  public void setPersistentClass(Class<T> persistentClass) {
    this.persistentClass = persistentClass;
  }

  /**
   * @return the formClass
   */
  public Class<? extends CRUDForm<T>> getFormClass() {
    return formClass;
  }

  /**
   * @param formClass the formClass to set
   */
  public void setFormClass(Class<? extends CRUDForm<T>> formClass) {
    this.formClass = formClass;
  }

  /**
   * @return the tableDecoratorClass
   */
  @SuppressWarnings("unchecked")
  public Class<? extends CRUDTableDecorator> getTableDecoratorClass() {
    return tableDecoratorClass;
  }

  /**
   * @param tableDecoratorClass the tableDecoratorClass to set
   */
  @SuppressWarnings("unchecked")
  public void setTableDecoratorClass(Class<? extends CRUDTableDecorator> tableDecoratorClass) {
    this.tableDecoratorClass = tableDecoratorClass;
  }

  /**
   * @return the config
   */
  public CRUDControllerConfig getConfig() {
    return config;
  }

  /**
   * @param config the config to set
   */
  public void setConfig(CRUDControllerConfig config) {
    this.config = config;
  }

  /**
   * @return the mainService
   */
  public GenericService<T> getMainService() {
    return mainService;
  }

  /**
   * @param mainService the mainService to set
   */
  public void setMainService(GenericService<T> mainService) {
    this.mainService = mainService;
  }

  /**
   * @return the messageSource
   */
  public MessageSource getMessageSource() {
    return messageSource;
  }

  /**
   * @param messageSource the messageSource to set
   */
  @Resource
  public void setMessageSource(MessageSource messageSource) {
    this.messageSource = messageSource;
  }
  
  /**
   * @param notesHelper the notesHelper to set
   */
  @Resource(name = "notesHelper")
  public void setNotesHelper(NotesHelper notesHelper) {
    this.notesHelper = notesHelper;
  }
  
  /**
   * @return the privilegeEvaluator
   */
  public PrivilegeEvaluator getPrivilegeEvaluator() {
    return privilegeEvaluator;
  }

  /**
   * @param privilegeEvaluator the privilegeEvaluator to set
   */
  @Resource
  public void setPrivilegeEvaluator(PrivilegeEvaluator privilegeEvaluator) {
    this.privilegeEvaluator = privilegeEvaluator;
  }
  
  /**
   * @param queryService the queryService to set
   */
  @Resource(name = "queryService")
  public void setQueryService(QueryService queryService) {
    this.queryService = queryService;
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    this.formDecorator = formDecorator;
    formDecorator.setConfig(config);
  }

  /**
   * @return the listTable
   */
  protected Table getListTable() {
    return listTable;
  }

  /**
   * @param listTable the listTable to set
   */
  protected void setListTable(Table listTable) {
    this.listTable = listTable;
  }

}
