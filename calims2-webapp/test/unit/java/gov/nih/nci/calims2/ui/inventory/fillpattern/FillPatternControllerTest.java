/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.fillpattern;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.FillPattern;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.inventory.layout.LayoutHelperMockup;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym
 * 
 */
public class FillPatternControllerTest {
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    FillPatternController controller = new FillPatternController();
    CRUDAssert.assertControllerConstructor(controller, FillPatternController.URL_PREFIX, "inventory.fillpattern.", "name",
        FillPattern.class, FillPatternForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeDetailsModel method.
   */
  @Test
  public void testCompleteDetailsModel() {
    FillPatternController controller = new FillPatternController();
    LayoutHelperMockup layoutHelper = new LayoutHelperMockup();
    controller.setLayoutHelper(layoutHelper);
    ModelAndView model = new ModelAndView();
    FillPatternForm form = new FillPatternForm();
    FillPattern fillPattern = new FillPattern();
    form.setEntity(fillPattern);
    List<Coordinate> coordinates = new ArrayList<Coordinate>();
    fillPattern.setCoordinateCollection(coordinates);
    Layout layout = new Layout();
    fillPattern.setLayout(layout);
    model.addObject("form", form);
    ModelAndView result = controller.completeDetailsModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    assertEquals("Wrong collection passed to getCoordinates", coordinates, layoutHelper.getCoordinates());
    assertEquals("Wrong result for coordinates", "getCoordinates", result.getModel().get("coordinates"));
    assertEquals("Wrong collection passed to getLayoutMap", layout, layoutHelper.getLayouts().get(0));
    assertEquals("Wrong result for LayoutMap", "getLayoutMap", result.getModel().get("layoutMap"));
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    FillPatternController controller = new FillPatternController();
    LayoutHelperMockup layoutHelper = new LayoutHelperMockup();
    controller.setLayoutHelper(layoutHelper);
    GenericServiceMockup<Layout> layoutService = new GenericServiceMockup<Layout>();
    controller.setLayoutService(layoutService);
    GenericServiceMockup<Person> personService = new GenericServiceMockup<Person>();
    controller.setPersonService(personService);
    ModelAndView model = new ModelAndView();
    FillPatternForm form = new FillPatternForm();
    FillPattern fillPattern = new FillPattern();
    form.setEntity(fillPattern);
    List<Coordinate> coordinates = new ArrayList<Coordinate>();
    fillPattern.setCoordinateCollection(coordinates);
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    assertEquals("Wrong collection passed to getCoordinates", coordinates, layoutHelper.getCoordinates());
    assertEquals("Wrong result for coordinates", "getCoordinates", result.getModel().get("coordinates"));
    CRUDAssert.assertFindAll(layoutService, Layout.class, "name", "layouts", result);
    assertEquals("Wrong collection passed to getLayoutMap", layoutService.getFindAllResult(), layoutHelper.getLayouts());
    assertEquals("Wrong result for LayoutMap", "getLayoutMap", result.getModel().get("layoutMap"));
    CRUDAssert.assertFindAll(personService, Person.class, "familyName", "persons", result);
  }

}
