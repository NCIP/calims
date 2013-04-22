/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.specimen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.inventory.container.ContainerService;
import gov.nih.nci.calims2.business.inventory.specimen.SpecimenService;
import gov.nih.nci.calims2.business.inventory.specimen.SpecimenTransfer;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.util.interceptor.FlowContextInterceptor;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.json.JsonSerializer;

/**
 * @author viseem
 * 
 */
@Controller
@RequestMapping(TransferController.URL_PREFIX)
public class TransferController {

  private static Logger log = LoggerFactory.getLogger(TransferController.class);

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/inventory/specimen";

  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";
  private static final String TARGET_QUERY = Container.class.getName() + ".findTargetContainers";
  private static final String COMPOSITE_SPECIMEN_QUERY = Specimen.class.getName() + ".findByCompositeContainerId";
  private static final String SIMPLE_SPECIMEN_QUERY = Specimen.class.getName() + ".findBySimpleContainerId";

  private CRUDControllerConfig config = new CRUDControllerConfig();
  private ContainerService containerService;
  private GenericService<ContainerSubcategory> containerSubcategoryService;
  private GenericService<ContainerType> containerTypeService;
  private SpecimenService specimenService;
  private GenericService<Type> typeService;

  private JsonSerializer serializer = new JsonSerializer();

  /**
   * Constructor.
   */
  public TransferController() {
    config.setUrlAndViewPrefixes(URL_PREFIX);
  }

  /**
   * Cancels the transfer.
   * 
   * @return The list view
   */
  @RequestMapping("cancelTransfer.do")
  public ModelAndView cancelTransfer() {
    logMethod("cancelTransfer");
    ModelAndView model = new ModelAndView();
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = context.pop();
    model.setView(new InternalResourceView(frame.getReturnUrl()));
    return model;
  }

  /**
   * Creates the transfer page model.
   * 
   * @param form The form for which the model must be created
   * @return the transfer page model.
   */
  public ModelAndView createTransferModel(TransferForm form) {
    ModelAndView model = new ModelAndView();

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.CONTAINER.name());
    List<Type> containerCategories = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("containerCategories", containerCategories);
    if (form.getTargetCategoryId() != null) {
      model.addObject("category", typeService.findById(Type.class, form.getTargetCategoryId()));
    }

    List<ContainerSubcategory> containerSubcategories = containerSubcategoryService.findAll(ContainerSubcategory.class, "name");
    model.addObject("containerSubcategories", containerSubcategories);
    if (form.getTargetSubcategoryId() != null) {
      model.addObject("subCategory", containerSubcategoryService
          .findById(ContainerSubcategory.class, form.getTargetSubcategoryId()));
    }

    List<ContainerType> containerTypes = containerTypeService.findAll(ContainerType.class, "name");
    model.addObject("containerTypes", containerTypes);
    if (form.getTargetTypeId() != null) {
      model.addObject("containerType", containerTypeService.findById(ContainerType.class, form.getTargetTypeId()));
    }

    Container source = containerService.findById(Container.class, form.getSourceId());
    model.addObject("source", source);
    model.addObject("sourceSpecimens", getSpecimenForContainer(source));

    params = new HashMap<String, Object>();
    List<Container> targets = containerService.findByNamedQuery(TARGET_QUERY, params);
    model.addObject("targets", targets);
    if (form.getTargetId() != null) {
      Container target = containerService.findById(Container.class, form.getTargetId());
      model.addObject("target", target);
      model.addObject("targetSpecimens", getSpecimenForContainer(target));
      model.addObject("targetContainerIds", getTargetContainerIds(target));
    }

    model.addObject("form", form);
    model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
    model.setViewName(config.getFullViewName("transfer"));
    return model;
  }

  /**
   * Gets the json representation of the specimens in the given container. (process the case of simple as well as composite
   * containers)
   * 
   * @param container The container
   * @return The json representation of the specimens in the given container.
   */
  public String getSpecimenForContainer(Container container) {
    Map<Coordinate, Specimen> specimenMap = new HashMap<Coordinate, Specimen>();
    switch (container.getContainerType().getComposition()) {
      case COMPOSITE: {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("containerId", container.getId());
        List<Specimen> specimens = specimenService.findByNamedQuery(COMPOSITE_SPECIMEN_QUERY, params);
        for (Specimen specimen : specimens) {
          specimenMap.put(specimen.getContainer().getCoordinate(), specimen);
        }
        break;
      }
      case SIMPLE: {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("containerId", container.getId());
        List<Specimen> specimens = specimenService.findByNamedQuery(SIMPLE_SPECIMEN_QUERY, params);
        for (Specimen specimen : specimens) {
          Coordinate coordinate = new Coordinate();
          coordinate.setX(0);
          coordinate.setY(0);
          specimenMap.put(coordinate, specimen);
        }
        break;
      }
      default: {
        break;
      }
    }
    Map<String, Object> jsonObject = new TreeMap<String, Object>();
    for (Map.Entry<Coordinate, Specimen> entry : specimenMap.entrySet()) {
      Coordinate coordinate = entry.getKey();
      Specimen specimen = entry.getValue();
      String key = coordinate.getX() + "_" + coordinate.getY();
      Map<String, Object> properties = new TreeMap<String, Object>();
      jsonObject.put(key, properties);
      properties.put("id", specimen.getId());
      properties.put("name", specimen.getName());
    }
    return serializer.serializeObject(jsonObject);
  }

  /**
   * Gets the json representation of the target container children.
   * 
   * @param container The target container
   * @return The json representation of the target container children.
   */
  public String getTargetContainerIds(Container container) {
    Map<Coordinate, Container> containerMap = new HashMap<Coordinate, Container>();
    switch (container.getContainerType().getComposition()) {
      case COMPOSITE: {
        for (Container child : container.getChildContainerCollection()) {
          containerMap.put(child.getCoordinate(), child);
        }
        break;
      }
      case SIMPLE: {
        Coordinate coordinate = new Coordinate();
        coordinate.setX(0);
        coordinate.setY(0);
        containerMap.put(coordinate, container);
        break;
      }
      default: {
        break;
      }
    }
    Map<String, Object> jsonObject = new TreeMap<String, Object>();
    for (Map.Entry<Coordinate, Container> entry : containerMap.entrySet()) {
      Coordinate coordinate = entry.getKey();
      String key = coordinate.getX() + "_" + coordinate.getY();
      jsonObject.put(key, entry.getValue().getId());
    }
    return serializer.serializeObject(jsonObject);
  }

  /**
   * select the target container.
   * 
   * @param form The submitted form
   * @return the transfer page model.
   */
  @RequestMapping("selectTarget.do")
  public ModelAndView selectTarget(TransferForm form) {
    logMethod("selectTarget");
    return createTransferModel(form);
  }

  /**
   * Save the submitted transfers.
   * 
   * @param form The current form
   * @return The Model of the next view
   */
  @RequestMapping("transfer.do")
  public ModelAndView transfer(TransferForm form) {
    logMethod("selectTarget");
    try {
      List<SpecimenTransfer> transfers = form.getTransfers();
      specimenService.createTransfers(transfers);
      ModelAndView model = new ModelAndView();
      Stack<StackFrame> context = FlowContextHolder.getContext();
      StackFrame frame = context.pop();
      model.setView(new RedirectView(frame.getReturnUrl(), true));
      model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.setPersistAttributeForClient(this));
      return model;
    } catch (ValidationException e) {
      return createTransferModel(form);
    }
  }

  /**
   * Go to the transfer page for a given container.
   * 
   * @param containerId The id of the container.
   * @return The transfer page model.
   */
  @RequestMapping("transferForContainer.do")
  public ModelAndView transferForContainer(@RequestParam("id") Long containerId) {
    TransferForm form = new TransferForm();
    return createTransferModel(form);
  }

  /**
   * Go to the transfer page for a given specimen.
   * 
   * @param specimenId The id of the specimen.
   * @return The transfer page model.
   */
  @RequestMapping("transferForSpecimen.do")
  public ModelAndView transferForSpecimen(@RequestParam("id") Long specimenId) {
    logMethod("transferForSpecimen");
    log.debug("specimen id = {}", specimenId);
    TransferForm form = new TransferForm();
    Specimen specimen = specimenService.findById(Specimen.class, specimenId);
    form.setSourceId(specimen.getContainer().getId());
    return createTransferModel(form);
  }

  /**
   * Log a descriptive message for the given metod name.
   * 
   * @param methodName The name of the method.
   */
  protected void logMethod(String methodName) {
    if (log.isDebugEnabled()) {
      Object[] args = new Object[] {methodName, getClass().getSimpleName(), FlowContextHolder.getContext().size() };
      log.debug("Entering {} - Controller = {} Context size = {}", args);
    }
  }

  /**
   * @param containerService the containerService to set
   */
  @Resource(name = "containerService")
  public void setContainerService(ContainerService containerService) {
    this.containerService = containerService;
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
   * @param specimenService the specimenService to set
   */
  @Resource(name = "specimenService")
  public void setSpecimenService(SpecimenService specimenService) {
    this.specimenService = specimenService;
  }

  /**
   * @param type the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> type) {
    typeService = type;
  }

}
