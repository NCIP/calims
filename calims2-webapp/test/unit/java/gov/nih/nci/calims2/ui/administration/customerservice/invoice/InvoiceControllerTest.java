/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.invoice;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.Invoice;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.InvoiceStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class InvoiceControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    InvoiceController controller = new InvoiceController();
    CRUDAssert.assertControllerConstructor(controller, InvoiceController.URL_PREFIX, "administration.customerservice.invoice.",
        "name", Invoice.class, InvoiceForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    InvoiceController controller = new InvoiceController();
    GenericServiceMockup<CustomerRequest> customerRequestService = new GenericServiceMockup<CustomerRequest>();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setCustomerRequestService(customerRequestService);
    controller.setTypeService(typeService);
    ModelAndView model = new ModelAndView();

    ModelAndView result = controller.completeEditModel(model, Locale.US);

    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertFindAll(customerRequestService, CustomerRequest.class, "name", "customerRequests", result);
    CRUDAssert.assertEnumerationCollection(result, "invoiceStatuses", InvoiceStatus.class);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.INVOICE, "types", result);

  }

}
