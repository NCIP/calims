/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.quotation;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.customerservice.Quotation;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.QuotationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class QuotationControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    QuotationController controller = new QuotationController();
    CRUDAssert.assertControllerConstructor(controller, QuotationController.URL_PREFIX, "administration.customerservice.quotation.", 
        "name", Quotation.class, QuotationForm.class, CRUDTableDecorator.class);
  }
  
  /**
   * Test the controller completeDetailsModel method.
   */
  @Test
  public void testCompleteDetailsModel() {
    QuotationController controller = new QuotationController();
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeDetailsModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModell() {
    QuotationController controller = new QuotationController();
    GenericServiceMockup<Rate> rateService = new GenericServiceMockup<Rate>();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    controller.setRateService(rateService);
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.QUOTATION, "types", result);
    CRUDAssert.assertFindAll(rateService, Rate.class, "name", "rates", result);
    CRUDAssert.assertEnumerationCollection(result, "quotationStatuses", QuotationStatus.class);
  }
}
