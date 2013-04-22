/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.fluidspecimen;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.FillPattern;
import gov.nih.nci.calims2.domain.inventory.FluidSpecimen;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelperMockup;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym
 * 
 */
public class FluidSpecimenControllerTest {
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    FluidSpecimenController controller = new FluidSpecimenController();
    CRUDAssert.assertControllerConstructor(controller, FluidSpecimenController.URL_PREFIX, "inventory.fluidspecimen.", "name",
        FluidSpecimen.class, FluidSpecimenForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeDetailsModel method.
   */
  @Test
  public void testCompleteDetailsModel() {
    FluidSpecimenController controller = new FluidSpecimenController();
    QuantityHelperMockup quantityHelper = new QuantityHelperMockup();
    controller.setQuantityHelper(quantityHelper);
    ModelAndView model = new ModelAndView();
    FluidSpecimenForm form = new FluidSpecimenForm();
    form.setEntity(new FluidSpecimen());
    model.addObject("form", form);
    ModelAndView result = controller.completeDetailsModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertQuantities(model, quantityHelper, TypeEnumeration.SPECIMEN_QUANTITY, false);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @SuppressWarnings("unchecked")
  @Test
  public void testCompleteEditModel() {
    FluidSpecimenController controller = new FluidSpecimenController();
    GenericServiceMockup<Container> containerService = new GenericServiceMockup<Container>();
    controller.setContainerService(containerService);
    GenericServiceMockup<ContainerSubcategory> containerSubcategoryService = new GenericServiceMockup<ContainerSubcategory>();
    controller.setContainerSubcategoryService(containerSubcategoryService);
    GenericServiceMockup<ContainerType> containerTypeService = new GenericServiceMockup<ContainerType>();
    controller.setContainerTypeService(containerTypeService);
    GenericServiceMockup<FillPattern> fillPatternService = new GenericServiceMockup<FillPattern>();
    controller.setFillPatternService(fillPatternService);
    GenericServiceMockup<Location> locationService = new GenericServiceMockup<Location>();
    controller.setLocationService(locationService);
    GenericServiceMockup<Organization> organizationService = new GenericServiceMockup<Organization>();
    controller.setOrganizationService(organizationService);
    GenericServiceMockup<Person> personService = new GenericServiceMockup<Person>();
    controller.setPersonService(personService);
    QuantityHelperMockup quantityHelper = new QuantityHelperMockup();
    controller.setQuantityHelper(quantityHelper);
    GenericServiceMockup<Specimen> specimenService = new GenericServiceMockup<Specimen>();
    controller.setMainService((GenericServiceMockup) specimenService);
    GenericServiceMockup<Taxon> taxonService = new GenericServiceMockup<Taxon>();
    controller.setTaxonService(taxonService);
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    GenericServiceMockup<StandardUnit> unitService = new GenericServiceMockup<StandardUnit>();
    controller.setUnitService(unitService);
    ModelAndView model = new ModelAndView();
    FluidSpecimenForm form = new FluidSpecimenForm();
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    String containerQueryName = Container.class.getName() + ".findContainersForSpecimenCreation";
    CRUDAssert.assertNamedQuery(result, containerService, 0, containerQueryName, "containers");
    CRUDAssert.assertFindAll(containerSubcategoryService, ContainerSubcategory.class, "name", "containerSubcategories", result);
    CRUDAssert.assertFindAll(containerTypeService, ContainerType.class, "name", "containerTypes", result);
    CRUDAssert.assertFindAll(fillPatternService, FillPattern.class, "name", "fillPatterns", result);
    CRUDAssert.assertFindAll(locationService, Location.class, "name", "locations", result);
    CRUDAssert.assertFindAll(organizationService, Organization.class, "name", "organizations", result);
    CRUDAssert.assertFindAll(personService, Person.class, "familyName", "persons", result);
    CRUDAssert.assertFindAll(specimenService, Specimen.class, "name", "specimens", result);
    CRUDAssert.assertFindAll(taxonService, Taxon.class, "name", "taxons", result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.FLUIDSPECIMEN, "types", result);
    CRUDAssert.assertFindAll(unitService, StandardUnit.class, "name", "standardUnits", result);
    CRUDAssert.assertQuantities(model, quantityHelper, TypeEnumeration.SPECIMEN_QUANTITY, true);
  }

}
