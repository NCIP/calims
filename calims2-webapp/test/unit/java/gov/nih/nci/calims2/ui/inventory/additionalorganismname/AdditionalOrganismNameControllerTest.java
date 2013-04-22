/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.additionalorganismname;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.AdditionalOrganismName;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym
 *
 */
public class AdditionalOrganismNameControllerTest {
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    AdditionalOrganismNameController controller = new AdditionalOrganismNameController();
    CRUDAssert.assertControllerConstructor(controller, AdditionalOrganismNameController.URL_PREFIX, 
        "inventory.additionalorganismname.", "name",
        AdditionalOrganismName.class, AdditionalOrganismNameForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    AdditionalOrganismNameController controller = new AdditionalOrganismNameController();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    ModelAndView model = new ModelAndView();
    AdditionalOrganismNameForm form = new AdditionalOrganismNameForm();
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.ADDITIONLORGANISMNAME, "types", result);
  }
  
}

