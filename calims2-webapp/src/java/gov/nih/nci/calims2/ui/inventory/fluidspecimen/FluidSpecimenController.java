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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.inventory.specimen.SpecimenService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationMessageHelper;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.FillPattern;
import gov.nih.nci.calims2.domain.inventory.FluidSpecimen;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelper;
import gov.nih.nci.calims2.ui.inventory.specimen.SpecimenTableDecorator;
import gov.nih.nci.calims2.ui.util.interceptor.FlowContextInterceptor;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;

/**
 * @author connollym
 * 
 */
@Controller
@RequestMapping(FluidSpecimenController.URL_PREFIX)
public class FluidSpecimenController extends CRUDController<FluidSpecimen> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/inventory/fluidspecimen";
 
  /** Create type subflow id. */
  static final int TYPE_SUBFLOW_ID = 0;
  
  /** Create taxon subflow id. */
  static final int TAXON_SUBFLOW_ID = 1;
  
  /** Create organization subflow id. */
  static final int ORGANIZATION_SUBFLOW_ID = 2;
  
  /** Create location subflow id. */
  static final int LOCATION_SUBFLOW_ID = 3;
  
  /** Create specimen subflow id. */
  static final int SPECIMEN_SUBFLOW_ID = 4;
  
  /** Create specimen subflow id. */
  static final int CONTAINER_SUBFLOW_ID = 5;
  
  /** Create standard unit subflow id. */
  static final int STANDARD_UNIT_SUBFLOW_ID = 6;
  
  /** Create person subflow id. */
  static final int PERSON_SUBFLOW_ID = 8;

  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";
  private static final String CONTAINER_FOR_CREATION_QUERY = Container.class.getName() + ".findContainersForSpecimenCreation";
  private static final String CONTAINER_FOR_UPDATE_QUERY = Container.class.getName() + ".findContainersForSpecimenUpdate";
  
  private GenericService<Container> containerService;
  private GenericService<Location> locationService;
  private GenericService<Organization> organizationService;
  private GenericService<Person> personService;
  private QuantityHelper quantityHelper;
  private GenericService<Taxon> taxonService;
  private GenericService<Type> typeService;
  private GenericService<StandardUnit> unitService;
  private GenericService<ContainerSubcategory> containerSubcategoryService;
  private GenericService<ContainerType> containerTypeService;
  private GenericService<FillPattern> fillPatternService;

  /**
   * Default constructor.
   */
  public FluidSpecimenController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/common/type/create.do?dataElementCollection=" + TypeEnumeration.FLUIDSPECIMEN,
        "/inventory/taxon/create.do", 
        "/administration/organization/create.do", 
        "/administration/location/create.do",
        "/inventory/fluidspecimen/create.do", 
        "/inventory/container/create.do", 
        "/administration/standardunit/create.do",
        "/common/externalidentifier/enterList.do",
        "/administration/person/create.do",
        "/inventory/specimen/transferForSpecimen.do",
        "/common/document/enterList.do"});
    config.setAdvancedSearch(true);
  }

  /**
   * Adds the category and subcategory to the model.
   * 
   * @param model The model to which the categories must be added.
   */
  void addCategories(ModelAndView model) {
    FluidSpecimen specimen = ((FluidSpecimenForm) model.getModel().get("form")).getEntity();
    if (specimen.getContainer() != null) {
      Container container = containerService.findById(Container.class, specimen.getContainer().getId());
      model.addObject("containerType", container.getContainerType());
      model.addObject("subCategory", container.getContainerType().getContainerSubcategory());
      model.addObject("category", container.getContainerType().getContainerSubcategory().getType());
    }
  }

  /**
   * 
   * @param model The model to which the quantities must be added.
   * @param createMissing True if quantities missing in the container class must be added.
   */
  void addQuantities(ModelAndView model, boolean createMissing) {
    Set<Quantity> quantities = ((FluidSpecimenForm) model.getModel().get("form")).getEntity().getQuantityCollection();
    model.addObject("quantities", quantityHelper.getQuantities(TypeEnumeration.SPECIMEN_QUANTITY, quantities, createMissing));
  }

  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") FluidSpecimenForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeDetailsModel(ModelAndView model, Locale locale) {
    addCategories(model);
    addQuantities(model, false);
    return model;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    FluidSpecimenForm form = (FluidSpecimenForm) model.getModel().get("form");
    List<Container> containers = null;
    Map<String, Object> params = new HashMap<String, Object>();
    if (form.isEditMode()) {
      params.put("containerId", form.getEntity().getContainer().getId());
      containers = containerService.findByNamedQuery(CONTAINER_FOR_UPDATE_QUERY, params);
    } else {
      containers = containerService.findByNamedQuery(CONTAINER_FOR_CREATION_QUERY, params);
    }
    model.addObject("containers", containers);

    params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.CONTAINER.name());
    List<Type> containerCategories = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("containerCategories", containerCategories);

    List<ContainerSubcategory> containerSubcategories = containerSubcategoryService.findAll(ContainerSubcategory.class, "name");
    model.addObject("containerSubcategories", containerSubcategories);

    List<ContainerType> containerTypes = containerTypeService.findAll(ContainerType.class, "name");
    model.addObject("containerTypes", containerTypes);

    List<FillPattern> fillPatterns = fillPatternService.findAll(FillPattern.class, "name");
    model.addObject("fillPatterns", fillPatterns);

    List<Location> locations = locationService.findAll(Location.class, "name");
    model.addObject("locations", locations);

    List<Organization> organizations = organizationService.findAll(Organization.class, "name");
    model.addObject("organizations", organizations);
    
    List<Person> persons = personService.findAll(Person.class, "familyName");
    model.addObject("persons", persons);

    List<Specimen> parentSpecimens = ((GenericService) super.getMainService()).findAll(Specimen.class, "name");
    model.addObject("specimens", filterDescendents(parentSpecimens, form.getEntity()));

    List<Taxon> taxons = taxonService.findAll(Taxon.class, "name");
    model.addObject("taxons", taxons);

    params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.FLUIDSPECIMEN.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);

    List<StandardUnit> units = unitService.findAll(StandardUnit.class, "name");
    model.addObject("standardUnits", units);

    addCategories(model);
    addQuantities(model, true);
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      FluidSpecimen fluidSpecimen = ((FluidSpecimenForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case TAXON_SUBFLOW_ID: {
          fluidSpecimen.setTaxon(EntityWithIdHelper.createEntity(Taxon.class, entityId));
          break;
        }
        case ORGANIZATION_SUBFLOW_ID: {
          fluidSpecimen.getOrganizationCollection().add(EntityWithIdHelper.createEntity(Organization.class, entityId));
          break;
        }
        case LOCATION_SUBFLOW_ID: {
          fluidSpecimen.getSamplingLocationCollection().add(EntityWithIdHelper.createEntity(Location.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          fluidSpecimen.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
          break;
        }
        case SPECIMEN_SUBFLOW_ID: {
          fluidSpecimen.setParentSpecimen(EntityWithIdHelper.createEntity(Specimen.class, entityId));
          break;
        }
        case CONTAINER_SUBFLOW_ID: {
          fluidSpecimen.setContainer(EntityWithIdHelper.createEntity(Container.class, entityId));
          break;
        }
        case PERSON_SUBFLOW_ID: {
          fluidSpecimen.setContactPerson(EntityWithIdHelper.createEntity(Person.class, entityId));
          break;
        }
        case STANDARD_UNIT_SUBFLOW_ID: {
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }

  /**
   * filters the descendants of the given location from the list of locations.
   * 
   * @param specimens The list of specimens to filter
   * @param specimen The specimen to filter from the list (with all its descendants)
   * @return The filtered list.
   */
  List<Specimen> filterDescendents(List<Specimen> specimens, Specimen specimen) {
    if (specimen.getId() == null) {
      return specimens;
    }
    List<Specimen> result = new ArrayList<Specimen>();
    for (Specimen candidate : specimens) {
      Specimen currentSpecimen = candidate;
      while (currentSpecimen != null && !currentSpecimen.getId().equals(specimen.getId())) {
        currentSpecimen = currentSpecimen.getParentSpecimen();
      }
      if (currentSpecimen == null) {
        result.add(candidate);
      }
    }
    return result;
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @return The list view.
   */
  @SuppressWarnings("unchecked")
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") FluidSpecimenForm form, Locale locale) {
    Container container = containerService.findById(Container.class, form.getContainerId());
    if (container.getContainerType().getComposition() == ContainerComposition.COMPOSITE) {
      CRUDControllerConfig config = getConfig();
      ModelAndView model = new ModelAndView();
      FluidSpecimen input = form.getSubmittedEntity();
      try {
        completeExtraction(form);
        GenericService specimenService = super.getMainService();
        ((SpecimenService) specimenService).createForCompositeContainer(input, form.getFillPatternId());
        model.setViewName(config.getRedirectUrl(config.getListCommand()));
        model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.setPersistAttributeForClient(this));
      } catch (ValidationException e) {
        model = createEditModel(input, form.getReturnView(), locale);
        model.addObject("messagekey", ValidationMessageHelper.getErrors(e));
        model.addObject("form", form);
        model.setViewName(config.getFullViewName(config.getEditView()));
        model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
      }
      return model;
    }
    return doSave(form, locale);
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  protected Class<? extends CRUDTableDecorator> getDefaultTableDecoratorClass() {
        return  SpecimenTableDecorator.class;
  }  
  
  /**
   * @param container the containerService to set
   */
  @Resource(name = "containerService")
  public void setContainerService(GenericService<Container> container) {
    containerService = container;
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
   * @param fillPattern the fillPatternService to set
   */
  @Resource(name = "fillPatternService")
  public void setFillPatternService(GenericService<FillPattern> fillPattern) {
    fillPatternService = fillPattern;
  }

  /**
   * @param location the locationService to set
   */
  @Resource(name = "locationService")
  public void setLocationService(GenericService<Location> location) {
    locationService = location;
  }

  /**
   * @param organization the organizationService to set
   */
  @Resource(name = "organizationService")
  public void setOrganizationService(GenericService<Organization> organization) {
    organizationService = organization;
  }
  
  /**
   * @param person the personService to set
   */
  @Resource(name = "personService")
  public void setPersonService(GenericService<Person> person) {
    personService = person;
  }

  /**
   * @param quantityHelper the quantityHelper to set
   */
  @Resource(name = "quantityHelper")
  public void setQuantityHelper(QuantityHelper quantityHelper) {
    this.quantityHelper = quantityHelper;
  }

  /**
   * @param specimenService the specimenService to set
   */
  @Resource(name = "specimenService")
  public void setSpecimenService(GenericService<FluidSpecimen> specimenService) {
    super.setMainService(specimenService);
  }

  /**
   * @param taxon the taxonService to set
   */
  @Resource(name = "taxonService")
  public void setTaxonService(GenericService<Taxon> taxon) {
    taxonService = taxon;
  }

  /**
   * @param type the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> type) {
    typeService = type;
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
  @Resource(name = "fluidSpecimenFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "fluidSpecimenTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}