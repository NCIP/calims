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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.inventory.container.ContainerService;
import gov.nih.nci.calims2.business.inventory.container.CoordinateHelper;
import gov.nih.nci.calims2.business.inventory.container.CopySpecification;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerStatus;
import gov.nih.nci.calims2.ui.administration.namingconvention.NamingConventionHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.inventory.layout.LayoutHelper;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelper;
import gov.nih.nci.calims2.ui.util.interceptor.FlowContextInterceptor;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym
 *
 */
@Controller
@RequestMapping(ContainerController.URL_PREFIX)
public class ContainerController extends CRUDController<Container> {
  
  private static Logger log = LoggerFactory.getLogger(ContainerController.class);

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/inventory/container";
 
  /** Create location subflow id.*/ 
  static final int LOCATION_SUBFLOW_ID = 0;
  
  /** Create layout subflow id.*/ 
  static final int LAYOUT_SUBFLOW_ID = 1;
  
  /** Create standard unit subflow id.*/ 
  static final int STANDARD_UNIT_SUBFLOW_ID = 2;
  
  /** Create container sub flow. */
  static final int CONTAINER_SUBFLOW_ID = 3;
  
  /** Create containerType sub flow. */
  static final int CONTAINERTYPE_SUBFLOW_ID = 4;
  
  private static final String PARENT_QUERY = Container.class.getName() + ".findByComposition";
  private static final String PARENT_FOR_COPY_QUERY = Container.class.getName() + ".findByCompositionAndTemplate";
  private static final String CONTAINER_WITHOUTPARENTS_QUERY = Container.class.getName() + ".findContainersWithoutParents";
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";
  
  private GenericService<ContainerSubcategory> containerSubcategoryService;
  private GenericService<ContainerType> containerTypeService;
  private GenericService<Layout> layoutService;
  private GenericService<Location> locationService;
  private LayoutHelper layoutHelper;
  private NamingConventionHelper namingConventionHelper;
  private QuantityHelper quantityHelper;
  private GenericService<Type> typeService;
  private GenericService<StandardUnit> unitService;
  private CRUDFormDecorator copyFormDecorator;
  
  /**
   * Default constructor.
   */
  public ContainerController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/location/create.do",
                                        "/inventory/layout/create.do",
                                        "/administration/standardunit/create.do",
                                        "/inventory/container/create.do",
                                        "/inventory/containertype/create.do",
                                        "/inventory/childcontainer/enterList.do",
                                        "/inventory/childcontainer/createChild.do"});
    config.setAdvancedSearch(true);
  }
  
  /**
   * Adds the category and subcategory to the model.
   * 
   * @param model The model to which the categories must be added.
   */
  void addCategories(ModelAndView model) {
    Container container = ((ContainerForm) model.getModel().get("form")).getEntity();
    if (container.getContainerType() != null) {
      ContainerType containerType = containerTypeService.findById(ContainerType.class, container.getContainerType().getId());
      model.addObject("subCategory", containerType.getContainerSubcategory());
      model.addObject("category", containerType.getContainerSubcategory().getType());
    }
  }

  /**
   * 
   * @param model The model to which the quantities must be added.
   * @param createMissing True if quantities missing in the container class must be added.
   */
  void addQuantities(ModelAndView model, boolean createMissing) {
    Set<Quantity> quantities = ((ContainerForm) model.getModel().get("form")).getEntity().getCapacityCollection();
    model.addObject("quantities", quantityHelper.getQuantities(TypeEnumeration.CONTAINER_QUANTITY, quantities, createMissing));
  }

  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") ContainerForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeDetailsModel(ModelAndView model, Locale locale) {
    ContainerForm containerForm = (ContainerForm) model.getModel().get("form");
    completeEditForm(containerForm, containerForm.getEntity());
    addQuantities(model, false);
    addCategories(model);
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void completeEditForm(CRUDForm<Container> form, Container entity) {
    ContainerForm containerForm = (ContainerForm) form;
    containerForm.setUpdatable(true);
    if (entity.getParentContainer() != null) {
      Layout layout = entity.getParentContainer().getLayout();
      containerForm.setCoordinateX(CoordinateHelper.getCoordinateString(layout.getX_dimensionLabel(), layout.getX_dimension(),
          entity.getCoordinate().getX()));
      containerForm.setCoordinateY(CoordinateHelper.getCoordinateString(layout.getY_dimensionLabel(), layout.getY_dimension(),
          entity.getCoordinate().getY()));
      if (entity.getParentContainer().getContainerType().getComposition() == ContainerComposition.COMPOSITE) {
        containerForm.setUpdatable(false);
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  public void completeExtraction(CRUDForm<Container> form) {
    Coordinate coordinate = new Coordinate();
    Container container = form.getEntity();
    if (container.getParentContainer() != null) {
      Container parent = super.getMainService().findById(Container.class, container.getParentContainer().getId());
      Layout layout = parent.getLayout();
      ContainerForm containerForm = (ContainerForm) form;
      coordinate.setX(CoordinateHelper.getCoordinateValue(layout.getX_dimensionLabel(), containerForm.getCoordinateX()));
      coordinate.setY(CoordinateHelper.getCoordinateValue(layout.getY_dimensionLabel(), containerForm.getCoordinateY()));
    } else {
      coordinate.setX(0);
      coordinate.setY(0);
    }
    container.setCoordinate(coordinate);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.CONTAINER.name());
    List<Type> containerCategories = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("containerCategories", containerCategories);

    model.addObject("containerStatuses", I18nEnumerationHelper.getLocalizedValues(ContainerStatus.class, locale));

    List<ContainerSubcategory> containerSubcategories = containerSubcategoryService.findAll(ContainerSubcategory.class, "name");
    model.addObject("containerSubcategories", containerSubcategories);

    List<ContainerType> containerTypes = containerTypeService.findAll(ContainerType.class, "name");
    model.addObject("containerTypes", containerTypes);

    List<Layout> layouts = layoutService.findAll(Layout.class, "name");
    model.addObject("layouts", layouts);
    model.addObject("layoutMap", layoutHelper.getLayoutMap(layouts));
    model.addObject("layoutOptions", getLayoutOptions(layouts));

    List<Location> locations = locationService.findAll(Location.class, "name");
    model.addObject("locations", locations);

    model.addObject("namingConventions", namingConventionHelper.getNamingConventions(NamingConventionType.CONTAINERNAME));

    List<Container> parentContainers = getParentContainers((ContainerForm) model.getModel().get("form"));
    model.addObject("parentContainers", parentContainers);
    model.addObject("parentLayouts", layoutHelper.getContainerLayoutMap(parentContainers));

    List<StandardUnit> units = unitService.findAll(StandardUnit.class, "name");
    model.addObject("standardUnits", units);

    addQuantities(model, true);
    addCategories(model);
    return model;
  }

  /**
   * Copy a template.
   * 
   * @param form The copy container form
   * @param locale The current locale.
   * @return The next view.
   */
  @RequestMapping("copy.do")
  public ModelAndView copy(ContainerCopyForm form, Locale locale) {
    logMethod("copy");
    try {
      CopySpecification specification = form.getSpecification();
      Coordinate coordinate = new Coordinate();
      if (specification.getParentContainerId() != null) {
        Container parent = super.getMainService().findById(Container.class, specification.getParentContainerId());
        Layout layout = parent.getLayout();
        coordinate.setX(CoordinateHelper.getCoordinateValue(layout.getX_dimensionLabel(), form.getCoordinateX()));
        coordinate.setY(CoordinateHelper.getCoordinateValue(layout.getY_dimensionLabel(), form.getCoordinateY()));
      } else {
        coordinate.setX(0);
        coordinate.setY(0);
      }
      specification.setCoordinate(coordinate);
      log.debug("specification created");
      ((ContainerService) getMainService()).createCopy(specification);
      ModelAndView model = new ModelAndView();
      model.setView(new RedirectView(form.getCurrentView(), true));
      model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.setPersistAttributeForClient(this));
      return model;
    } catch (ValidationException e) {
      log.debug("Exception in copy", e);
      return createCopyModel(form);
    }
  }

  /**
   * {@inheritDoc}
   */
  public List<Container> createDefaultList() {
    Map<String, Object> params = new HashMap<String, Object>();
    return super.getMainService().findByNamedQuery(CONTAINER_WITHOUTPARENTS_QUERY, params);
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Container container = ((ContainerForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case CONTAINER_SUBFLOW_ID: {
          container.setParentContainer(EntityWithIdHelper.createEntity(Container.class, entityId));
          break;
        }
        case LOCATION_SUBFLOW_ID: {
          container.setLocation(EntityWithIdHelper.createEntity(Location.class, entityId));
          break;
        }
        case LAYOUT_SUBFLOW_ID: {
          container.setLayout(EntityWithIdHelper.createEntity(Layout.class, entityId));
          break;
        }
        case STANDARD_UNIT_SUBFLOW_ID: {
          break;
        }
        case CONTAINERTYPE_SUBFLOW_ID: {
          container.setContainerType(EntityWithIdHelper.createEntity(ContainerType.class, entityId));
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }

  /**
   * Gets the options for the layout-container types select box.
   * 
   * @param layouts the layouts to use to set the options
   * @return The list of options for the layout select box
   */
  List<LayoutOption> getLayoutOptions(List<Layout> layouts) {
    List<LayoutOption> options = new ArrayList<LayoutOption>();
    for (Layout layout : layouts) {
      for (ContainerType type : layout.getContainerTypeCollection()) {
        LayoutOption option = new LayoutOption(layout.getId().toString() + "-" + type.getId().toString(), layout.getName(), type
            .getId().toString());
        options.add(option);
      }
    }
    return options;
  }

  /**
   * Get the parent containers to allow in the select parent container box.
   * 
   * @param form The current form
   * @return the parent containers to allow in the select parent container box
   */
  List<Container> getParentContainers(ContainerForm form) {
    if (form.isUpdatable()) {
      Map<String, Object> params = new HashMap<String, Object>();
      params.put("composition", ContainerComposition.COMPLEX);
      List<Container> parentContainers = super.getMainService().findByNamedQuery(PARENT_QUERY, params);
      return filterDescendents(parentContainers, form.getEntity());
    }
    List<Container> parentContainers = new ArrayList<Container>();
    parentContainers.add(form.getEntity().getParentContainer());
    return parentContainers;
  }

  /**
   * Go to the copy container page.
   * 
   * @param currentView The view in which the list command was issued.
   * @param id The id of the container to copy
   * @return The model for the copy container page.
   */
  @RequestMapping("goToCopy.do")
  public ModelAndView goToCopy(@RequestParam(value = "currentView", defaultValue = "call") String currentView,
      @RequestParam("id") Long id) {
    ContainerCopyForm form = new ContainerCopyForm();
    form.setCurrentView(currentView);
    form.setId(id);
    return createCopyModel(form);
  }

  /**
   * Creates the copy view model with the given form.
   * 
   * @param form The form
   * @return The copy view model
   */
  public ModelAndView createCopyModel(ContainerCopyForm form) {
    ModelAndView model = new ModelAndView();

    model.addObject("form", form);
    Container template = getMainService().findById(Container.class, form.getId());
    model.addObject("template", template);
    model.addObject("depth", getTemplateDepth(template));

    List<Layout> layouts = layoutService.findAll(Layout.class, "name");
    model.addObject("layoutMap", layoutHelper.getLayoutMap(layouts));

    List<Location> locations = locationService.findAll(Location.class, "name");
    model.addObject("locations", locations);

    model.addObject("namingConventions", namingConventionHelper.getNamingConventions(NamingConventionType.CONTAINERNAME));

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("composition", ContainerComposition.COMPLEX);
    params.put("isTemplate", false);
    List<Container> parentContainers = super.getMainService().findByNamedQuery(PARENT_FOR_COPY_QUERY, params);
    model.addObject("parentContainers", parentContainers);
    model.addObject("parentLayouts", layoutHelper.getContainerLayoutMap(parentContainers));

    model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
    CRUDControllerConfig config = getConfig();
    model.addObject("config", config);
    model.addObject("formDecorator", copyFormDecorator);
    model.setViewName(config.getFullViewName("copy"));
    return model;
  }

  /**
   * filters the descendants of the given container from the list of containers.
   * 
   * @param containers The list of containers to filter
   * @param container The container to filter from the list (with all its descendants)
   * @return The filtered list.
   */
  List<Container> filterDescendents(List<Container> containers, Container container) {
    if (container.getId() == null) {
      return containers;
    }
    List<Container> result = new ArrayList<Container>();
    for (Container candidate : containers) {
      Container currentContainer = candidate;
      while (currentContainer != null && !currentContainer.getId().equals(container.getId())) {
        currentContainer = currentContainer.getParentContainer();
      }
      if (currentContainer == null) {
        result.add(candidate);
      }
    }
    return result;
  }

  /**
   * Gets the depth of the template tree.
   * 
   * @param template The template
   * @return the depth of the template tree.
   */
  public int getTemplateDepth(Container template) {
    if (template.getContainerType().getComposition() != ContainerComposition.COMPLEX) {
      return 1;
    }
    int max = 1;
    for (Container child : template.getChildContainerCollection()) {
      int childDepth = getTemplateDepth(child) + 1;
      if (childDepth > max) {
        max = childDepth;
      }
    }
    return max;
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @return The list view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") ContainerForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param containerService the containerService to set
   */
  @Resource(name = "containerService")
  public void setContainerService(GenericService<Container> containerService) {
    super.setMainService(containerService);
  }

  /**
   * @param containerSubcategoryService the containerSubcategoryService to set
   */
  @Resource(name = "containerSubcategoryService")
  public void setContainerSubcategoryService(GenericService<ContainerSubcategory> containerSubcategoryService) {
    this.containerSubcategoryService = containerSubcategoryService;
  }

  /**
   * @param containerTypeService the containerTypeService to set
   */
  @Resource(name = "containerTypeService")
  public void setContainerTypeService(GenericService<ContainerType> containerTypeService) {
    this.containerTypeService = containerTypeService;
  }

  /**
   * @param layoutHelper the layoutHelper to set
   */
  @Resource(name = "layoutHelper")
  public void setLayoutHelper(LayoutHelper layoutHelper) {
    this.layoutHelper = layoutHelper;
  }

  /**
   * @param layoutService the layoutService to set
   */
  @Resource(name = "layoutService")
  public void setLayoutService(GenericService<Layout> layoutService) {
    this.layoutService = layoutService;
  }

  /**
   * @param locationService the locationService to set
   */
  @Resource(name = "locationService")
  public void setLocationService(GenericService<Location> locationService) {
    this.locationService = locationService;
  }

  /**
   * @param namingConventionHelper the namingConventionHelper to set
   */
  @Resource(name = "namingConventionHelper")
  public void setNamingConventionHelper(NamingConventionHelper namingConventionHelper) {
    this.namingConventionHelper = namingConventionHelper;
  }

  /**
   * @param quantityHelper the quantityHelper to set
   */
  @Resource(name = "quantityHelper")
  public void setQuantityHelper(QuantityHelper quantityHelper) {
    this.quantityHelper = quantityHelper;
  }

  /**
   * @param typeService the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> typeService) {
    this.typeService = typeService;
  }

  /**
   * @param unitService the unitService to set
   */
  @Resource(name = "unitService")
  public void setUnitService(GenericService<StandardUnit> unitService) {
    this.unitService = unitService;
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "containerFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "containerTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

  /**
   * @param copyFormDecorator the copyFormDecorator to set
   */
  @Resource(name = "containerCopyFormDecorator")
  public void setCopyFormDecorator(CRUDFormDecorator copyFormDecorator) {
    this.copyFormDecorator = copyFormDecorator;
    copyFormDecorator.setConfig(getConfig());
  }

}
