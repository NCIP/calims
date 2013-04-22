/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.strain;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.Strain;
import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym
 * 
 */
public class StrainControllerTest {
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    StrainController controller = new StrainController();
    CRUDAssert.assertControllerConstructor(controller, StrainController.URL_PREFIX, "inventory.strain.", "name", Strain.class,
        StrainForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    StrainController controller = new StrainController();
    GenericServiceMockup<Taxon> taxonService = new GenericServiceMockup<Taxon>();
    controller.setTaxonService(taxonService);
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);

    ModelAndView model = new ModelAndView();
    StrainForm form = new StrainForm();
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertFindAll(taxonService, Taxon.class, "name", "taxons", result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.STRAIN, "types", result);
  }

}
