/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.serviceitem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class ServiceItemControllerTest {
  
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
    ServiceItemController controller = new ServiceItemController();
    CRUDAssert.assertControllerConstructor(controller, ServiceItemController.URL_PREFIX,
        "administration.customerservice.serviceitem.", "name", ServiceItem.class, ServiceItemForm.class, 
        ServiceItemTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
 /* @Test
  public void testCompleteEditModel() {
    ServiceItemController controller = new ServiceItemController();
    GenericServiceMockup<AccountNumber> accountNumberService = new GenericServiceMockup<AccountNumber>();
    controller.setAccountNumberService(accountNumberService);
    GenericServiceMockup<Quotation> quotationService = new GenericServiceMockup<Quotation>();
    controller.setQuotationService(quotationService);
    GenericServiceMockup<Rate> rateService = new GenericServiceMockup<Rate>();
    controller.setRateService(rateService);
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    GenericServiceMockup<StandardUnit> standardUnitService = new GenericServiceMockup<StandardUnit>();
    controller.setUnitService(standardUnitService);
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);

    //CRUDAssert.assertFindAll(accountNumberService, AccountNumber.class, "name", "accountNumbers", result);
    //CRUDAssert.assertFindAll(quotationService, Quotation.class, "name", "quotations", result);
    //CRUDAssert.assertFindAll(rateService, Rate.class, "name", "rates", result);
    //CRUDAssert.assertTypes(typeService, TypeEnumeration.SERVICEITEM, "types", result);
    //CRUDAssert.assertEnumerationCollection(result, "serviceItemStatuses", ServiceItemStatus.class);
  }
  */
  /**
   * Test the controller createList method.
   */
  @Test
  
  public void testCreateList() {
    ServiceItemController controller = new ServiceItemController();
    GenericServiceMockup<ServiceItem> serviceItemService = new GenericServiceMockup<ServiceItem>();
    controller.setMainService(serviceItemService);
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    frame.addAttribute("serviceId", 1L);
    context.push(frame);
    
    List<ServiceItem> result = controller.createList();
    
    String queryName = ServiceItem.class.getName() + ".findByServiceId";
    
    assertEquals("Wrong Query name passed to findByNamedQuery", queryName, serviceItemService.getFindByQueryName());
    Map<String, Object> params = serviceItemService.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong id passed to findByNamedQuery", 1L, frame.getAttribute("serviceId"));
    assertEquals("Wrong number of paramters", 1, params.size());
    assertEquals("Wrong result returned", serviceItemService.getFindByQueryNameResult(), result);
  }

}
