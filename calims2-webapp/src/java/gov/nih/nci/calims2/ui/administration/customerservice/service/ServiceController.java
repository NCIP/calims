/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.administration.customerservice.service.ServiceService;
import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.util.interceptor.FlowContextInterceptor;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
@Controller
@RequestMapping(ServiceController.URL_PREFIX)
public class ServiceController extends CRUDController<Service> {

  private static Logger log = LoggerFactory.getLogger(ServiceController.class);

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/customerservice/service";

  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 0;

  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";

  private GenericService<Type> typeService;

  /**
   * Default constructor.
   */
  public ServiceController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/common/type/create.do?dataElementCollection=" + TypeEnumeration.SERVICE,
        "/administration/customerservice/serviceitem/enterList.do", "/common/document/enterList.do" });
    config.setAdvancedSearch(true);
  }

  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") ServiceForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    
    model.addObject("serviceStatuses", I18nEnumerationHelper.getLocalizedValues(ServiceStatus.class, locale));

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.SERVICE.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);
    Boolean customerRequestCustomerMode = FlowContextHolder.getContext().peek().getAttribute("template") == null 
    && !getPrivilegeEvaluator().hasRole("ROLE_CUSTOMER_REQUEST_MANAGER_ACCESS");
    model.addObject("customerRequestCustomerMode", customerRequestCustomerMode);
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeManageModel(ModelAndView model, Locale locale) {
    StackFrame frame = FlowContextHolder.getContext().peek();
    frame.addAttribute("template", "true");
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Service service = ((ServiceForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        
        case TYPE_SUBFLOW_ID: {
          service.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  public List<Service> createList() {
    StackFrame frame = FlowContextHolder.getContext().peek();
    boolean template = frame.getAttribute("template") != null;
    if (template) {
      log.debug("inside createList() - Service is a template");
      return super.createList();
    }
    log.debug("inside createList() - Service is not a template");
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("customerRequestId", (FlowContextHolder.getContext().peek()).getAttribute("id"));
    return getMainService().findByNamedQuery(Service.class.getName() + ".findByCustomerRequestId", params);

  }
  
 

  /**
   * {@inheritDoc}
   */
  public List<Service> createAdvancedList(Long queryId) {
    List<Service> services = super.createAdvancedList(queryId);
    List<Service> result = new ArrayList<Service>();
    for (Service service : services) {
      if (service.getIsTemplate()) {
        result.add(service);
      }
    }
    return result;
  }
  
  /**
   * @param locale The current locale.
   * @return model The ModelAndView.
   */
  @RequestMapping("/selectService.do")
  public ModelAndView selectService(Locale locale) {
    logMethod("selectService");
    //if we want to add some customer request info to the page we would use the custeomerrequest service to retrieve 
    //the CR based on the id we get 
    //from the stack.
    ModelAndView model = new ModelAndView();
    model.addObject("config", getConfig());
    model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
    Map<String, Object> params = new HashMap<String, Object>();
    model.addObject("services", getMainService().findByNamedQuery(Service.class.getName() + ".findTemplates", params));
    model.setViewName(getConfig().getFullViewName("selectService"));
    return model;
  }
  
  /**
   * @param templateId The id of the template Service object.
   * @return listView The list view.
   */
  
  @RequestMapping("/cloneService.do")
  public ModelAndView cloneService(@RequestParam("templateId") Long templateId) {
    logMethod("cloneService");
    ModelAndView model = new ModelAndView();
    Long customerRequestId = (Long) (FlowContextHolder.getContext().peek()).getAttribute("id");
    try {
      ((ServiceService) getMainService()).createClone(customerRequestId, templateId);
      CRUDControllerConfig config = getConfig();
      model.setViewName(config.getRedirectUrl(config.getListCommand()));
      model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.setPersistAttributeForClient(this));
    } catch (ValidationException e) {
         log.error("This should not happen" + e);
    }
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public List<Service> createDefaultList() {
    Map<String, Object> params = new HashMap<String, Object>();
    return getMainService().findByNamedQuery(Service.class.getName() + ".findTemplates", params);
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @return The list type view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") ServiceForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param serviceService the serviceService to set
   */
  @Resource(name = "serviceService")
  public void setServiceService(GenericService<Service> serviceService) {
    super.setMainService(serviceService);
  }

 

  /**
   * @param typeService the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> typeService) {
    this.typeService = typeService;
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "serviceFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "serviceTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}