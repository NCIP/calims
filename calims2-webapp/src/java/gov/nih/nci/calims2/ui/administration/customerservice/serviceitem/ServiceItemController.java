/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.serviceitem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceItemStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.inventory.enumeration.SpecimenType;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelper;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
@Controller
@RequestMapping(ServiceItemController.URL_PREFIX)
public class ServiceItemController extends CRUDController<ServiceItem> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/customerservice/serviceitem";

  /** Create rate sub flow. */
  static final int RATE_SUBFLOW_ID = 0;

  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 1;

  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";

  private GenericService<AccountNumber> accountNumberService;
  private GenericService<Rate> rateService;
  private GenericService<Service> serviceService;
  private GenericService<Type> typeService;
 
  private QuantityHelper quantityHelper;

  /**
   * Default constructor.
   */
  public ServiceItemController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/customerservice/rate/create.do",
        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.SERVICEITEM });
  }

  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") ServiceItemForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<AccountNumber> accountNumbers = accountNumberService.findAll(AccountNumber.class, "name");
    model.addObject("accountNumbers", accountNumbers);

    List<Rate> rates = rateService.findAll(Rate.class, "name");
    model.addObject("rates", rates);

    model.addObject("serviceItemStatuses", I18nEnumerationHelper.getLocalizedValues(ServiceItemStatus.class, locale));
    model.addObject("specimenTypes", I18nEnumerationHelper.getLocalizedValues(SpecimenType.class, locale));

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.SERVICEITEM.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);

    Boolean customerRequestCustomerMode = FlowContextHolder.getContext().peek().getAttribute("template") == null
        && !getPrivilegeEvaluator().hasRole("ROLE_CUSTOMER_REQUEST_MANAGER_ACCESS");
    model.addObject("customerRequestCustomerMode", customerRequestCustomerMode);

    return model;
  }

  /**
   * 
   * @param model The model to which the quantities must be added.
   * @param createMissing True if quantities missing in the container class must be added.
   */
  void addQuantities(ModelAndView model, boolean createMissing) {
    Set<Quantity> quantities = new HashSet<Quantity>();
    Object obj = ((ServiceItemForm) model.getModel().get("form")).getEntity().getQuantity();
    if (obj != null) {
      quantities.add(((ServiceItemForm) model.getModel().get("form")).getEntity().getQuantity());
    }
    model.addObject("quantities", quantityHelper.getQuantities(TypeEnumeration.SERVICEITEM_QUANTITY, quantities, createMissing));
  }

  /**
   * {@inheritDoc}
   */
  public List<ServiceItem> createList() {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("serviceId", (FlowContextHolder.getContext().peek()).getAttribute("id"));
    return getMainService().findByNamedQuery(ServiceItem.class.getName() + ".findByServiceId", params);
  }

  /**
   * 
   * {@inheritDoc}
   */

  public ModelAndView completeListModel(ModelAndView model, Locale locale) {
    Long serviceId = (Long) (FlowContextHolder.getContext().peek()).getAttribute("id");
    Service service = serviceService.findById(Service.class, serviceId);
    ServiceItemTableDecorator tableDecorator = (ServiceItemTableDecorator) model.getModel().get("tableDecorator");
    tableDecorator.setService(service);
    return model;
  }

  /**
   * Go to the appropriate creatre specimen subflow to create a new specimen for this service.
   * 
   * @param id The serviceItem id
   * @return The next view.
   */
  @RequestMapping("/addSpecimen.do")
  public ModelAndView addSpecimen(@RequestParam("id") Long id) {
    logMethod("addSpecimen");
    ServiceItem serviceItem = getMainService().findById(ServiceItem.class, id);
    Class<? extends Specimen> specimenClass = serviceItem.getSpecimenType().getSpecimenClass();
    String url = "/inventory/" + specimenClass.getSimpleName().toLowerCase() + "/create.do";
    ModelAndView model = new ModelAndView();
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    CRUDControllerConfig config = getConfig();
    frame.setReturnUrl(config.getForwardUrl("/returnFromAddSpecimen.do"));
    frame.addAttribute("id", id);
    frame.addAttribute("persistentClass", getPersistentClass());
    model.setView(new InternalResourceView(url));
    return model;
  }

  /**
   * Return from a create specimen subflow.
   * 
   * @param locale The current locale.
   * @return listView The serviceItem list vie.
   */
  @RequestMapping("/returnFromAddSpecimen.do")
  public ModelAndView returnFromAddSpecimen(Locale locale) {
    logMethod("returnFromAddSpecimen");
    FlowContextHolder.getContext().pop();
    return list("call", null, locale);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeDetailsModel(ModelAndView model, Locale locale) {
    addQuantities(model, false);
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      ServiceItem serviceItem = ((ServiceItemForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case RATE_SUBFLOW_ID: {
          serviceItem.setServiceItemRate(EntityWithIdHelper.createEntity(Rate.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          serviceItem.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current Locale.
   * @return The list type view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") ServiceItemForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param quantityHelper the quantityHelper to set
   */
  @Resource(name = "quantityHelper")
  public void setQuantityHelper(QuantityHelper quantityHelper) {
    this.quantityHelper = quantityHelper;
  }

  /**
   * @param accountNumberService the accountNumberService to set
   */
  @Resource(name = "accountNumberService")
  public void setAccountNumberService(GenericService<AccountNumber> accountNumberService) {
    this.accountNumberService = accountNumberService;
  }

  /**
   * @param rateService the rateService to set
   */
  @Resource(name = "rateService")
  public void setRateService(GenericService<Rate> rateService) {
    this.rateService = rateService;
  }

  /**
   * @param serviceService the serviceService to set
   */
  @Resource(name = "serviceService")
  public void setServiceService(GenericService<Service> serviceService) {
    this.serviceService = serviceService;
  }

  /**
   * @param serviceItemService the serviceItemService to set
   */
  @Resource(name = "serviceItemService")
  public void setServiceItemService(GenericService<ServiceItem> serviceItemService) {
    super.setMainService(serviceItemService);
  }

  /**
   * @param typeService the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> typeService) {
    this.typeService = typeService;
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "serviceItemFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "serviceItemTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}