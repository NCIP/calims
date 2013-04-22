/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.invoice;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.Invoice;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.InvoiceStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap@moxieinformatics.com
 * 
 */
@Controller
@RequestMapping(InvoiceController.URL_PREFIX)
public class InvoiceController extends CRUDController<Invoice> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/customerservice/invoice";

  /** Name of the edit form of this module. */
  static final String EDIT_FORM_NAME = "administrationForms.invoiceForm";
  
  /** Create customer request sub flow. */
  static final int CUSTOMERREQUEST_SUBFLOW_ID = 0;
  
  /** Create customer request sub flow. */
  static final int TYPE_SUBFLOW_ID = 1;
   
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";
  
  private GenericService<CustomerRequest> customerRequestService;
  private GenericService<Type> typeService;

  /**
   * Default constructor.
   */
  public InvoiceController() {
    super(URL_PREFIX, "name");
        CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/customerservice/customerrequest/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.INVOICE,
                                        "/common/document/enterList.do"});
    config.setAdvancedSearch(true);
  }
  
  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") InvoiceForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }
  
  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<CustomerRequest> customerRequests = customerRequestService.findAll(CustomerRequest.class, "name");
    model.addObject("customerRequests", customerRequests);
    model.addObject("invoiceStatuses", I18nEnumerationHelper.getLocalizedValues(InvoiceStatus.class, locale));
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.INVOICE.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);
   
    return model;
  }
  
  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Invoice invoice = ((InvoiceForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case CUSTOMERREQUEST_SUBFLOW_ID: {
          invoice.getCustomerRequestCollection().add(EntityWithIdHelper.createEntity(CustomerRequest.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          invoice.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
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
   * @param locale The current locale.
   * @return The list type view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") InvoiceForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param invoiceService the invoiceService to set
   */
  @Resource(name = "invoiceService")
  public void setInvoiceService(GenericService<Invoice> invoiceService) {
    super.setMainService(invoiceService);
  }

  /**
   * @param typeService the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> typeService) {
    this.typeService = typeService;
  }
  /**
   * @param customerRequestService the customerRequestService to set
   */
  @Resource(name = "customerRequestService")
  public void setCustomerRequestService(GenericService<CustomerRequest> customerRequestService) {
    this.customerRequestService = customerRequestService;
  }
  
  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "invoiceFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "invoiceTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
