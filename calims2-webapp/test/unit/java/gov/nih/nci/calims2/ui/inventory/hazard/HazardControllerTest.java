/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.hazard;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Hazard;
import gov.nih.nci.calims2.domain.inventory.LabSupply;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author viseem
 * 
 */
public class HazardControllerTest {
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    HazardController controller = new HazardController();
    CRUDAssert.assertControllerConstructor(controller, HazardController.URL_PREFIX, "inventory.hazard.", "name", Hazard.class,
        HazardForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    HazardController controller = new HazardController();
    GenericServiceMockup<Container> containerService = new GenericServiceMockup<Container>();
    GenericServiceMockup<LabSupply> labSupplyService = new GenericServiceMockup<LabSupply>();
    GenericServiceMockup<Specimen> specimenService = new GenericServiceMockup<Specimen>();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();

    controller.setContainerService(containerService);
    controller.setLabSupplyService(labSupplyService);
    controller.setSpecimenService(specimenService);
    controller.setTypeService(typeService);

    ModelAndView model = new ModelAndView();
    HazardForm form = new HazardForm();
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);

    CRUDAssert.assertFindAll(containerService, Container.class, "name", "containers", result);
    CRUDAssert.assertFindAll(labSupplyService, LabSupply.class, "name", "labSupplies", result);
    CRUDAssert.assertFindAll(specimenService, Specimen.class, "name", "specimens", result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.HAZARD, "types", result);
  }

}
