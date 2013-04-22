/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.labsupply;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.LabSupply;
import gov.nih.nci.calims2.domain.inventory.enumeration.LabSupplyStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelperMockup;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author katariap
 * 
 */
public class LabSupplyControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    LabSupplyController controller = new LabSupplyController();
    CRUDAssert.assertControllerConstructor(controller, LabSupplyController.URL_PREFIX, "inventory.labsupply.", "name",
        LabSupply.class, LabSupplyForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeDetailsModel method.
   */
  @Test
  public void testCompleteDetailsModel() {
    LabSupplyController controller = new LabSupplyController();
    QuantityHelperMockup quantityHelper = new QuantityHelperMockup();
    controller.setQuantityHelper(quantityHelper);
    ModelAndView model = new ModelAndView();
    LabSupplyForm form = new LabSupplyForm();
    form.setEntity(new LabSupply());
    model.addObject("form", form);
    ModelAndView result = controller.completeDetailsModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertQuantities(model, quantityHelper, TypeEnumeration.LABSUPPLY_QUANTITY, false);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    LabSupplyController controller = new LabSupplyController();
    GenericServiceMockup<Container> containerService = new GenericServiceMockup<Container>();
    controller.setContainerService(containerService);
    GenericServiceMockup<Organization> organizationService = new GenericServiceMockup<Organization>();
    controller.setOrganizationService(organizationService);
    GenericServiceMockup<Person> personService = new GenericServiceMockup<Person>();
    controller.setPersonService(personService);
    QuantityHelperMockup quantityHelper = new QuantityHelperMockup();
    controller.setQuantityHelper(quantityHelper);
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    GenericServiceMockup<StandardUnit> unitService = new GenericServiceMockup<StandardUnit>();
    controller.setUnitService(unitService);

    ModelAndView model = new ModelAndView();
    LabSupplyForm form = new LabSupplyForm();
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    CRUDAssert.assertEnumerationCollection(result, "labSupplyStatuses", LabSupplyStatus.class);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertFindAll(organizationService, Organization.class, "name", "organizations", result);
    CRUDAssert.assertFindAll(personService, Person.class, "familyName", "persons", result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.LABSUPPLY, "types", result);
    CRUDAssert.assertQuantities(model, quantityHelper, TypeEnumeration.LABSUPPLY_QUANTITY, true);
  }

}