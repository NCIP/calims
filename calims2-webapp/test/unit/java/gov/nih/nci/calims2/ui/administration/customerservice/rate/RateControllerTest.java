/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.rate;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.RateStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class RateControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    RateController controller = new RateController();
    CRUDAssert.assertControllerConstructor(controller, RateController.URL_PREFIX, "administration.customerservice.rate.",
        "name", Rate.class, RateForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    RateController controller = new RateController();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    GenericServiceMockup<Person> personService = new GenericServiceMockup<Person>();
    controller.setTypeService(typeService);
    controller.setPersonService(personService);
    ModelAndView model = new ModelAndView();
    
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertFindAll(personService, Person.class, "familyName", "persons", result);
    CRUDAssert.assertEnumerationCollection(result, "rateStatuses", RateStatus.class);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.RATE, "types", result);
  }
  
}
