/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.layout;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym
 * 
 */
public class LayoutControllerTest {
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    LayoutController controller = new LayoutController();
    CRUDAssert.assertControllerConstructor(controller, LayoutController.URL_PREFIX, "inventory.layout.", "name", Layout.class,
        LayoutForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    LayoutController controller = new LayoutController();
    GenericServiceMockup<Person> personService = new GenericServiceMockup<Person>();
    controller.setPersonService(personService);
    ModelAndView model = new ModelAndView();
    LayoutForm form = new LayoutForm();
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertEnumerationCollection(result, "layoutLabelTypes", LayoutLabelType.class);
    CRUDAssert.assertFindAll(personService, Person.class, "familyName", "persons", result);
  }

}
