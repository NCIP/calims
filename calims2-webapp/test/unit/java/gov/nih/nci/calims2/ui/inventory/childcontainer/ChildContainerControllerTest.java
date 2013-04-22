/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.childcontainer;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerStatus;
import gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType;
import gov.nih.nci.calims2.ui.administration.namingconvention.NamingConventionHelperMockup;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.inventory.container.ContainerTableDecorator;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelperMockup;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;

/**
 * @author connollym
 *
 */
public class ChildContainerControllerTest {
  
 
  private static final int MAX_DIMENSION = 10;
  
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    ChildContainerController controller = new ChildContainerController();
    CRUDAssert.assertControllerConstructor(controller, ChildContainerController.URL_PREFIX, "inventory.childcontainer.", "name",
        Container.class, ContainerForm.class, ContainerTableDecorator.class);
  }
  
  /**
   * Test the controller completeEditForm method.
   */
  @Test
  public void testCompleteEditForm() {
    ChildContainerController controller = new ChildContainerController();
    ContainerForm form = new ContainerForm();
    Container container = new Container();
    Coordinate coordinate = new Coordinate();
    coordinate.setX(1);
    coordinate.setY(2);
    container.setCoordinate(coordinate);
    container.setParentContainer(makeParentContainer());
    controller.completeEditForm(form, container);
  }

   private Container makeParentContainer() {
    Container parent = new Container();
    parent.setId(1L);
    Layout layout = new Layout();
    layout.setX_dimension(MAX_DIMENSION);
    layout.setX_dimensionLabel(LayoutLabelType.DIGITS);
    layout.setY_dimension(MAX_DIMENSION);
    layout.setY_dimensionLabel(LayoutLabelType.DIGITS);
    parent.setLayout(layout);
    return parent;
  }
  
  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    ChildContainerController controller = new ChildContainerController();
    GenericServiceMockup<Container> containerService = new GenericServiceMockup<Container>();
    controller.setMainService(containerService);
    GenericServiceMockup<ContainerSubcategory> containerSubcategoryService = new GenericServiceMockup<ContainerSubcategory>();
    controller.setContainerSubcategoryService(containerSubcategoryService);
    GenericServiceMockup<ContainerType> containerTypeService = new GenericServiceMockup<ContainerType>();
    controller.setContainerTypeService(containerTypeService);
    GenericServiceMockup<Layout> layoutService = new GenericServiceMockup<Layout>();
    controller.setLayoutService(layoutService);
    NamingConventionHelperMockup namingConventionHelper = new NamingConventionHelperMockup();
    controller.setNamingConventionHelper(namingConventionHelper);
    QuantityHelperMockup quantityHelper = new QuantityHelperMockup();
    controller.setQuantityHelper(quantityHelper);
    GenericServiceMockup<StandardUnit> unitService = new GenericServiceMockup<StandardUnit>();
    controller.setUnitService(unitService);
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    ModelAndView model = new ModelAndView();
    ContainerForm form = new ContainerForm();
    form.setEntity(new Container());
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.CONTAINER, "containerCategories", result);
    CRUDAssert.assertEnumerationCollection(result, "containerStatuses", ContainerStatus.class);
    CRUDAssert.assertFindAll(containerSubcategoryService, ContainerSubcategory.class, "name", "containerSubcategories", result);
    CRUDAssert.assertFindAll(containerTypeService, ContainerType.class, "name", "containerTypes", result);
    assertEquals("Wrong type passed to naming convention helper", NamingConventionType.CONTAINERNAME, 
        namingConventionHelper.getTypeParam());
    assertEquals("Wrong naming conventions returned in the model", "NamingConvention", result.getModel().get("namingConventions"));
    CRUDAssert.assertFindAll(unitService, StandardUnit.class, "name", "standardUnits", result);
    CRUDAssert.assertQuantities(model, quantityHelper, TypeEnumeration.CONTAINER_QUANTITY, true);
  }
 
}
