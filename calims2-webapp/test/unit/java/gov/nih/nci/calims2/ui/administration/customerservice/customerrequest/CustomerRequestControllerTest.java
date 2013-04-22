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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.CustomerRequestStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class CustomerRequestControllerTest {
  
  /**
   * Initialize a blank flow context.
   */
  @Before
  public void newContext() {
    FlowContextHolder.newContext();
  }

  /**
   * Removes the flow context.
   */
  @After
  public void removeContext() {
    FlowContextHolder.removeContext();
  }

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    CustomerRequestController controller = new CustomerRequestController();
    CRUDAssert.assertControllerConstructor(controller, CustomerRequestController.URL_PREFIX,
        "administration.customerservice.customerrequest.", "name", CustomerRequest.class, CustomerRequestForm.class,
        CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    CustomerRequestController controller = new CustomerRequestController();
    GenericServiceMockup<Person> personService = new GenericServiceMockup<Person>();
    GenericServiceMockup<Account> accountService = new GenericServiceMockup<Account>();
    GenericServiceMockup<Service> serviceService = new GenericServiceMockup<Service>();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    //GenericServiceMockup<ExternalIdentifier> externalIdentifierService = new GenericServiceMockup<ExternalIdentifier>();
    
    controller.setAccountService(accountService);
    controller.setTypeService(typeService);
    //controller.setExternalIdentifierService(externalIdentifierService);
    
    controller.setPersonService(personService);

    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);

    CRUDAssert.assertFindAll(personService, Person.class, "familyName", "persons", result);
    CRUDAssert.assertFindAll(accountService, Account.class, "name", "accounts", result);
    CRUDAssert.assertFindAll(serviceService, Service.class, "name", "services", result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.CUSTOMERREQUEST, "types", result);
    CRUDAssert.assertEnumerationCollection(result, "customerRequestStatuses", CustomerRequestStatus.class);
  }

  /**
   * Test the controller createList method for Manager Access.
   */
  @Test
  
  public void testCreateListForManagerAccess() {
    FlowContextHolder.getContext().push(new BaseStackFrame());
    CustomerRequestController controller = initController("ROLE_CUSTOMER_REQUEST_MANAGER_ACCESS");
    GenericServiceMockup<CustomerRequest> customerRequestService = new GenericServiceMockup<CustomerRequest>();
    controller.setMainService(customerRequestService);
    List<CustomerRequest> result = controller.createList();
    
    String queryName = CustomerRequest.class.getName() + ".findAll";
    assertEquals("Wrong Query name passed to findByNamedQuery", queryName, customerRequestService.getFindByQueryName());
    Map<String, Object> params = customerRequestService.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong number of paramters", 0, params.size());
    assertEquals("Wrong result returned", customerRequestService.getFindByQueryNameResult(), result);
  }
  
  /**
   * Test the controller createList method for Customer Access.
   */
  @Test
  public void testCreateListForCustomerAccess() {
    FlowContextHolder.getContext().push(new BaseStackFrame());
    CustomerRequestController controller = initController("ROLE_CUSTOMER_REQUEST_CUSTOMER_ACCESS");
    GenericServiceMockup<CustomerRequest> customerRequestService = new GenericServiceMockup<CustomerRequest>();
    controller.setMainService(customerRequestService);
    
    List<CustomerRequest> result = controller.createList();
    
    String queryName = CustomerRequest.class.getName() + ".findByCreator";
    assertEquals("Wrong Query name passed to findByNamedQuery", queryName, customerRequestService.getFindByQueryName());
    Map<String, Object> params = customerRequestService.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong number of paramters", 1, params.size());
    assertEquals("Wrong result returned", customerRequestService.getFindByQueryNameResult(), result);
  }
  
  /**
   * Test the controller createList method for No Access.
   */
  @Test
  public void testCreateListForNoAccess() {
    FlowContextHolder.getContext().push(new BaseStackFrame());
    CustomerRequestController controller = initController("");
    List<CustomerRequest> result = controller.createList();
    assertNotNull("No result returned", result);
    assertEquals("Result is not empty", 0, result.size());
  }
  
  private CustomerRequestController initController(String role) {
    CustomerRequestController controller = new CustomerRequestController();
    PrivilegeEvaluator privilegeEvaluator = new PrivilegeEvaluatorMockup(role);
    controller.setPrivilegeEvaluator(privilegeEvaluator);
    return controller;
  }
}
