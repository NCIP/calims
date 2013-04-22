/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.chemicalcompound;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.inventory.ChemicalCompound;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Nanomaterial;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym
 * 
 */
public class ChemicalCompoundControllerTest {
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    ChemicalCompoundController controller = new ChemicalCompoundController();
    CRUDAssert.assertControllerConstructor(controller, ChemicalCompoundController.URL_PREFIX, "inventory.chemicalcompound.",
        "name", ChemicalCompound.class, ChemicalCompoundForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    ChemicalCompoundController controller = new ChemicalCompoundController();
    GenericServiceMockup<Container> containerService = new GenericServiceMockup<Container>();
    controller.setContainerService(containerService);
    GenericServiceMockup<Nanomaterial> specimenService = new GenericServiceMockup<Nanomaterial>();
    controller.setSpecimenService(specimenService);

    ModelAndView model = new ModelAndView();
    ChemicalCompoundForm form = new ChemicalCompoundForm();
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertFindAll(containerService, Container.class, "name", "containers", result);
    CRUDAssert.assertFindAll(specimenService, Nanomaterial.class, "name", "nanomaterials", result);
  }

}
