/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.container;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Location;
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
import gov.nih.nci.calims2.ui.inventory.layout.LayoutHelperMockup;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelperMockup;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;
import gov.nih.nci.calims2.ui.util.GenericServiceMockupWithData;

/**
 * @author connollym
 *
 */
public class ContainerControllerTest {
  
  private static final Long[] CONTAINER_IDS = new Long[] {1L, 5L, 6L };
  private static final int MAX_DIMENSION = 10;
  
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    ContainerController controller = new ContainerController();
    CRUDAssert.assertControllerConstructor(controller, ContainerController.URL_PREFIX, "inventory.container.", "name",
        Container.class, ContainerForm.class, ContainerTableDecorator.class);
  }

  /**
   * Test the controller completeDetailsModel method.
   */
  @Test
  public void testCompleteDetailsModel() {
    ContainerController controller = new ContainerController();
    QuantityHelperMockup quantityHelper = new QuantityHelperMockup();
    controller.setQuantityHelper(quantityHelper);
    ModelAndView model = new ModelAndView();
    ContainerForm form = new ContainerForm();
    form.setEntity(new Container());
    model.addObject("form", form);
    ModelAndView result = controller.completeDetailsModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertQuantities(model, quantityHelper, TypeEnumeration.CONTAINER_QUANTITY, false);
  }
  
  /**
   * Test the controller completeEditForm method.
   */
  @Test
  public void testCompleteEditForm() {
    ContainerController controller = new ContainerController();
    ContainerForm form = new ContainerForm();
    Container container = new Container();
    Coordinate coordinate = new Coordinate();
    coordinate.setX(1);
    coordinate.setY(2);
    container.setCoordinate(coordinate);
    container.setParentContainer(makeParentContainer());
    controller.completeEditForm(form, container);
    assertEquals("Wrong X coordinate", "02", form.getCoordinateX());
    assertEquals("Wrong Y coordinate", "03", form.getCoordinateY());
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
    ContainerType containerType = new ContainerType();
    parent.setContainerType(containerType);
    return parent;
  }
  
  /**
   * Test the controller completeEditModel method.
   */
  @SuppressWarnings("unchecked")
  @Test
  public void testCompleteEditModel() {
    ContainerController controller = new ContainerController();
    GenericServiceMockup<Container> containerService = new GenericServiceMockup<Container>();
    controller.setMainService(containerService);
    GenericServiceMockup<ContainerSubcategory> containerSubcategoryService = new GenericServiceMockup<ContainerSubcategory>();
    controller.setContainerSubcategoryService(containerSubcategoryService);
    GenericServiceMockup<ContainerType> containerTypeService = new GenericServiceMockup<ContainerType>();
    controller.setContainerTypeService(containerTypeService);
    LayoutHelperMockup layoutHelper = new LayoutHelperMockup();
    controller.setLayoutHelper(layoutHelper);
    GenericServiceMockup<Layout> layoutService = new GenericServiceMockup<Layout>();
    controller.setLayoutService(layoutService);
    GenericServiceMockup<Location> locationService = new GenericServiceMockup<Location>();
    controller.setLocationService(locationService);
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
    form.setUpdatable(true);
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertTypes(typeService, TypeEnumeration.CONTAINER, "containerCategories", result);
    CRUDAssert.assertEnumerationCollection(result, "containerStatuses", ContainerStatus.class);
    CRUDAssert.assertFindAll(containerSubcategoryService, ContainerSubcategory.class, "name", "containerSubcategories", result);
    CRUDAssert.assertFindAll(containerTypeService, ContainerType.class, "name", "containerTypes", result);
   // CRUDAssert.assertFindAll(layoutService, Layout.class, "name", "layouts", result);
    assertEquals("Wrong collection passed to getLayoutMap", layoutService.getFindAllResult(), layoutHelper.getLayouts());
    assertEquals("Wrong result for LayoutMap", "getLayoutMap", result.getModel().get("layoutMap"));
    CRUDAssert.assertFindAll(locationService, Location.class, "name", "locations", result);
    assertEquals("Wrong type passed to naming convention helper", NamingConventionType.CONTAINERNAME, 
        namingConventionHelper.getTypeParam());
    assertEquals("Wrong naming conventions returned in the model", "NamingConvention", result.getModel().get("namingConventions"));
    String queryName = Container.class.getName() + ".findByComposition";
    CRUDAssert.assertNamedQuery(model, containerService, 1, queryName, "parentContainers");
    List<Container> containers = (List<Container>) result.getModel().get("parentContainers");
    assertEquals("Wrong collection passed to getContainerLayoutMap", containers, layoutHelper.getContainers());
    assertEquals("Wrong result for parentLayouts", "getContainerLayoutMap", result.getModel().get("parentLayouts"));
    CRUDAssert.assertFindAll(unitService, StandardUnit.class, "name", "standardUnits", result);
    CRUDAssert.assertQuantities(model, quantityHelper, TypeEnumeration.CONTAINER_QUANTITY, true);
  }
  
  /**
   * Test the controller completeExtraction method with coordinate object.
   */
  @Test
  public void testCompleteExtractionWithCoordinate() {
    ContainerController controller = new ContainerController();
    GenericServiceMockupWithData<Container> containerService = new GenericServiceMockupWithData<Container>();
    controller.setMainService(containerService);
    Container parentContainer = makeParentContainer();
    containerService.setFindByIdResult(parentContainer);
    ContainerForm form = new ContainerForm();
    form.setCoordinateX("2");
    form.setCoordinateY("3");
    Container container = new Container();
    container.setParentContainer(parentContainer);
    form.setEntity(container);
    controller.completeExtraction(form);
    Coordinate coordinate = form.getEntity().getCoordinate();
    assertEquals("Wrong class passed to container service", Container.class, containerService.getFindByIdClass());
    assertEquals("Wrong id passed to container service", new Long(1), containerService.getFindByIdId());
    assertNotNull("No coordinate object created in the container", coordinate);
    assertEquals("Wrong X coordinate", 1, coordinate.getX().intValue());
    assertEquals("Wrong Y coordinate", 2, coordinate.getY().intValue());
  }
  
  /**
   * Test the controller completeExtraction method without coordinate object.
   */
  @Test
  public void testCompleteExtractionWithoutCoordinate() {
    ContainerController controller = new ContainerController();
    ContainerForm form = new ContainerForm();
    Container container = new Container();
    form.setEntity(container);
    controller.completeExtraction(form);
    Coordinate coordinate = form.getEntity().getCoordinate();
    assertNotNull("No coordinate object created in the container", coordinate);
    assertEquals("Wrong X coordinate", 0, coordinate.getX().intValue());
    assertEquals("Wrong Y coordinate", 0, coordinate.getY().intValue());
  }
  
  /**
   * Test the controller createDefaultList method.
   */
  @Test
  public void testCreateDefaultList() {
    ContainerController controller = new ContainerController();
    GenericServiceMockup<Container> containerService = new GenericServiceMockup<Container>();
    controller.setMainService(containerService);
    List<Container> result = controller.createDefaultList();
    String queryName = Container.class.getName() + ".findContainersWithoutParents";
    assertEquals("Wrong Query name passed to findByNamedQuery", queryName, containerService.getFindByQueryName());
    Map<String, Object> params = containerService.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong number of paramters", 0, params.size());
    assertEquals("Wrong result returned", containerService.getFindByQueryNameResult(), result);
  }
  
  /**
   * Test the controller filterDescendants method.
   */
  @Test
  public void tesFilterDescendants() {
    int[] parent = new int[] {-1, 0, 1, 1, 0, -1 };
    List<Container> containers = new ArrayList<Container>();
    for (int i = 1; i <= parent.length; i++) {
      Container container = new Container();
      container.setId(new Long(i));
      containers.add(container);
    }
    for (int i = 0; i < containers.size(); i++) {
      if (parent[i] >= 0) {
        containers.get(i).setParentContainer(containers.get(parent[i]));
      }
    }
    ContainerController controller = new ContainerController();
    List<Container> result = controller.filterDescendents(containers, containers.get(1));
    assertNotNull("No result returned", result);
    assertEquals("Result has the wrong size", CONTAINER_IDS.length, result.size());
    for (int i = 0; i < result.size(); i++) {
      assertEquals("Wrong location returned", CONTAINER_IDS[i], result.get(i).getId());
    }
  }
 
}


