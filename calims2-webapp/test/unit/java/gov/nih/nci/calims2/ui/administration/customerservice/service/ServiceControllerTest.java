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

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class ServiceControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    ServiceController controller = new ServiceController();
    CRUDAssert.assertControllerConstructor(controller, ServiceController.URL_PREFIX, "administration.customerservice.service.",
        "name", Service.class, ServiceForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    ServiceController controller = new ServiceController();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    ModelAndView model = new ModelAndView();

    ModelAndView result = controller.completeEditModel(model, Locale.US);

    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertEnumerationCollection(result, "serviceStatuses", ServiceStatus.class);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.SERVICE, "types", result);
  }

}
