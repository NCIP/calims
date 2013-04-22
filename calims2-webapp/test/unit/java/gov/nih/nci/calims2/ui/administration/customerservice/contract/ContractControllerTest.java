/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.contract;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.administration.customerservice.Contract;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ContractStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;

/**
 * @author connollym
 *
 */
public class ContractControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    ContractController controller = new ContractController();
    CRUDAssert.assertControllerConstructor(controller, ContractController.URL_PREFIX, "administration.customerservice.contract.",
        "name", Contract.class, ContractForm.class, CRUDTableDecorator.class);
    
  }
  
  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    ContractController controller = new ContractController();
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertEnumerationCollection(result, "contractStatuses", ContractStatus.class);
  }
}