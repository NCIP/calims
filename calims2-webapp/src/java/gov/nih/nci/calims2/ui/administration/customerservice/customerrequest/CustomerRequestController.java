/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.customerrequest;

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

import gov.nih.nci.calims2.business.administration.customerservice.customerrequest.CustomerRequestService;
import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.CustomerRequestStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.util.interceptor.FlowContextInterceptor;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;
import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * @author katariap
 * 
 */
@Controller
@RequestMapping(CustomerRequestController.URL_PREFIX)
public class CustomerRequestController extends CRUDController<CustomerRequest> {
  
  private static Logger log = LoggerFactory.getLogger(CustomerRequestController.class);

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/customerservice/customerrequest";
  
  /** Create person sub flow. */
  static final int PERSON_SUBFLOW_ID = 0;
  
  /** Create account sub flow. */
  static final int ACCOUNT_SUBFLOW_ID = 2;
  
  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 3;
  
  /** standard approve command. */
  public static final String APPROVE_COMMAND = "/approve.do";
  
  /** standard disapprove command. */
  public static final String DISAPPROVE_COMMAND = "/disapprove.do";
  
  /** standard labrespond command. */
  public static final String LABRESPONSE_COMMAND = "/labresponse.do";
  
  /** standard customerrespond command. */
  public static final String CUSTOMERRESPONSE_COMMAND = "/customerresponse.do";
  
  /** standard details command. */
  public static final String SUBMIT_COMMAND = "/submit.do";
  
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";
  
  private GenericService<Account> accountService;
  private GenericService<Person> personService;
  private GenericService<Type> typeService;

  /**
   * Default constructor.
   */
  public CustomerRequestController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/person/create.do",
                                        "/administration/customerservice/service/enterList.do",
                                        "/administration/customerservice/account/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.CUSTOMERREQUEST,
                                        "/common/document/enterList.do",
                                        "/common/externalidentifier/enterList.do"});
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
  public ModelAndView call(@ModelAttribute("form") CustomerRequestForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }
  
  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    model.addObject("customerRequestStatuses", I18nEnumerationHelper.getLocalizedValues(CustomerRequestStatus.class, locale));
    
    List<Account> accounts = accountService.findAll(Account.class, "name");
    model.addObject("accounts", accounts);
    
    List<Person> persons = personService.findAll(Person.class, "familyName");
    model.addObject("persons", persons);
    
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.CUSTOMERREQUEST.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);
    
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public List<CustomerRequest> createList() {
    PrivilegeEvaluator privilegeEvaluator = getPrivilegeEvaluator();
    Long queryId = getCurrentQueryId();
    if (queryId != null) {
      List<CustomerRequest> requests = super.createAdvancedList(queryId);
      if (privilegeEvaluator.hasRole("ROLE_CUSTOMER_REQUEST_MANAGER_ACCESS")) {
        return requests;
      }
      if (privilegeEvaluator.hasRole("ROLE_CUSTOMER_REQUEST_CUSTOMER_ACCESS")) {
        List<CustomerRequest> result = new ArrayList<CustomerRequest>();
        String currentUsername = privilegeEvaluator.getCurrentUsername();
        for (CustomerRequest request : requests) {
          if (currentUsername.equals(request.getCreatedBy())) {
            result.add(request);
          }
        }
        return result;
      }
      return new ArrayList<CustomerRequest>();
    }
   
    if (privilegeEvaluator.hasRole("ROLE_CUSTOMER_REQUEST_MANAGER_ACCESS")) {
      return getMainService().findAll(CustomerRequest.class, getConfig().getOrderByClause());
    }
    if (privilegeEvaluator.hasRole("ROLE_CUSTOMER_REQUEST_CUSTOMER_ACCESS")) {
      Map<String, Object> params = new HashMap<String, Object>();
      params.put("creator", privilegeEvaluator.getCurrentUsername());
      return getMainService().findByNamedQuery(CustomerRequest.class.getName() + ".findByCreator", params);
    }
    return new ArrayList<CustomerRequest>();
  }
  
  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      CustomerRequest customerRequest = ((CustomerRequestForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case PERSON_SUBFLOW_ID: {
          customerRequest.setCustomerName(EntityWithIdHelper.createEntity(Person.class, entityId));
          break;
        }
        case ACCOUNT_SUBFLOW_ID: {
          customerRequest.setCustomerAccount(EntityWithIdHelper.createEntity(Account.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          customerRequest.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param id The id of the entity whose status is being set to approved.
   * @return The list type view.
   */
  @RequestMapping(APPROVE_COMMAND)
  public ModelAndView approve(@RequestParam("id") Long id) {
    ModelAndView model = new ModelAndView();
    model = updateStatus(id, CustomerRequestStatus.APPROVED);
    return model;
  }
  
  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param id The id of the entity whose status is being set to approved.
   * @return The list type view.
   */
  @RequestMapping(DISAPPROVE_COMMAND)
  public ModelAndView disapprove(@RequestParam("id") Long id) {
    ModelAndView model = new ModelAndView();
    model = updateStatus(id, CustomerRequestStatus.REJECTED);
    return model;
  }
  
  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param id The id of the entity whose status is being set to approved.
   * @return The list type view.
   */
  @RequestMapping(LABRESPONSE_COMMAND)
  public ModelAndView labResponse(@RequestParam("id") Long id) {
    ModelAndView model = new ModelAndView();
    model = updateStatus(id, CustomerRequestStatus.LABRESPONSE);
    return model;
  }
  
  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param id The id of the entity whose status is being set to approved.
   * @return The list type view.
   */
  @RequestMapping(CUSTOMERRESPONSE_COMMAND)
  public ModelAndView customerResponse(@RequestParam("id") Long id) {
    ModelAndView model = new ModelAndView();
    model = updateStatus(id, CustomerRequestStatus.CUSTOMERRESPONSE);
    return model;
  }
  
  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param id The id of the entity whose status is being set to completed.
   * @return The list type view.
   */
  @RequestMapping(SUBMIT_COMMAND)
  public ModelAndView submit(@RequestParam("id") Long id) {
    return updateStatus(id, CustomerRequestStatus.SUBMITTED);
  }
  

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param id The id of the entity whose status is being set to completed.
   * @param status The status to be set on this entity.
   * @return The list type view.
   */
  public ModelAndView updateStatus(Long id, CustomerRequestStatus status) {
    logMethod("updateStatus");
    try {
       ((CustomerRequestService) getMainService()).updateCustomerRequestStatus(id, status);
    } catch (ValidationException e) {
      log.error("This should not happen" + e);
    }
    ModelAndView model = new ModelAndView();
    CRUDControllerConfig config = getConfig();
    model.setViewName(config.getRedirectUrl(config.getListCommand()));
    model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.setPersistAttributeForClient(this));
    return model;
  }
  
  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @return The list type view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") CustomerRequestForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param customerRequestService the customerRequestService to set
   */
  @Resource(name = "customerRequestService")
  public void setCustomerRequestService(GenericService<CustomerRequest> customerRequestService) {
    super.setMainService(customerRequestService);
  }

  /**
   * @param person the personService to set
   */
  @Resource(name = "personService")
  public void setPersonService(GenericService<Person> person) {
    personService = person;
  }
  
  /**
   * @param accountService the accountService to set
   */
  @Resource(name = "accountService")
  public void setAccountService(GenericService<Account> accountService) {
    this.accountService = accountService;
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
  @Resource(name = "customerRequestFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "customerRequestTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}