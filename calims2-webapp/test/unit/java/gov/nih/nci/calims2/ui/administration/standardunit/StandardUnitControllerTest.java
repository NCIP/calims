/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.standardunit;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.BaseUnit;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author katariap
 * 
 */
public class StandardUnitControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    StandardUnitController controller = new StandardUnitController();
    CRUDAssert.assertControllerConstructor(controller, StandardUnitController.URL_PREFIX, "administration.standardunit.", "name",
        StandardUnit.class, StandardUnitForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @SuppressWarnings("unchecked")
  @Test
  public void testCompleteEditModel() {
    StandardUnitController controller = new StandardUnitController();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    GenericServiceMockup<BaseUnit> unitService = new GenericServiceMockup<BaseUnit>();
    controller.setMainService((GenericServiceMockup) unitService);
    ModelAndView model = new ModelAndView();
    StandardUnitForm form = new StandardUnitForm();
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.UNIT, "types", result);
    CRUDAssert.assertFindAll(unitService, BaseUnit.class, "name", "baseunits", result);
  }
}
