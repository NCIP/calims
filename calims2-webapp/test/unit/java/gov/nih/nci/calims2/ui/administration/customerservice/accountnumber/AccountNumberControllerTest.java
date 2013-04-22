/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.accountnumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountNumberStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class AccountNumberControllerTest {

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
    AccountNumberController controller = new AccountNumberController();
    CRUDAssert.assertControllerConstructor(controller, AccountNumberController.URL_PREFIX,
        "administration.customerservice.accountnumber.", "name", AccountNumber.class, AccountNumberForm.class,
        CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    AccountNumberController controller = new AccountNumberController();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.ACCOUNTNUMBER, "types", result);
    CRUDAssert.assertEnumerationCollection(result, "accountNumberStatuses", AccountNumberStatus.class);
  }
  
  /**
   * Test the controller createList method.
   */
  @Test
  
  public void testCreateList() {
    AccountNumberController controller = new AccountNumberController();
    GenericServiceMockup<AccountNumber> accountNumberService = new GenericServiceMockup<AccountNumber>();
    controller.setMainService(accountNumberService);
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    frame.addAttribute("accountId", 1L);
    context.push(frame);
    
    List<AccountNumber> result = controller.createList();
    
    String queryName = AccountNumber.class.getName() + ".findByAccountId";
    
    assertEquals("Wrong Query name passed to findByNamedQuery", queryName, accountNumberService.getFindByQueryName());
    Map<String, Object> params = accountNumberService.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong id passed to findByNamedQuery", 1L, frame.getAttribute("accountId"));
    assertEquals("Wrong number of paramters", 1, params.size());
    assertEquals("Wrong result returned", accountNumberService.getFindByQueryNameResult(), result);
  }
}
