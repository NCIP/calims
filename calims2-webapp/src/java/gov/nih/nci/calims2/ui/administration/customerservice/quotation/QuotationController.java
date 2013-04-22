/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.quotation;

import java.util.HashMap;
import java.util.HashSet;
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
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.administration.customerservice.Quotation;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.QuotationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelper;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
@Controller
@RequestMapping(QuotationController.URL_PREFIX)
public class QuotationController extends CRUDController<Quotation> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/customerservice/quotation";

  /** Create rate sub flow. */
  static final int RATE_SUBFLOW_ID = 0;
  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 1;
  
  private QuantityHelper quantityHelper;
  private GenericService<Type> typeService;
  private GenericService<Rate> rateService;
  private GenericService<StandardUnit> unitService;

  /**
   * Default constructor.
   */
  public QuotationController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/customerservice/rate/create.do",
                                        "/common/type/create.do?dataElementCollection=" + TypeEnumeration.QUOTATION,
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
  public ModelAndView call(@ModelAttribute("form") QuotationForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }
  
  /**
   * 
   * @param model The model to which the quantities must be added.
   * @param createMissing True if quantities missing in the container class must be added.
   */
  void addQuantities(ModelAndView model, boolean createMissing) {
    Set<Quantity> quantities = new HashSet<Quantity>();
    Object obj = ((QuotationForm) model.getModel().get("form")).getEntity().getQuantity();
    if (obj != null) {
      quantities.add(((QuotationForm) model.getModel().get("form")).getEntity().getQuantity());
    }
    model.addObject("quantities", quantityHelper.getQuantities(TypeEnumeration.QUOTATION_QUANTITY, quantities, createMissing));
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<Rate> rates = rateService.findAll(Rate.class, "name");
    model.addObject("rates", rates);
    Map<String, Object> params1 = new HashMap<String, Object>();
    params1.put("dataElementCollection", TypeEnumeration.QUOTATION.name());
    List<Type> types = typeService.findByNamedQuery("gov.nih.nci.calims2.domain.common.Type.findByDataElementCollection", params1);
    model.addObject("types", types);
    model.addObject("quotationStatuses", I18nEnumerationHelper.getLocalizedValues(QuotationStatus.class, locale));
    List<StandardUnit> units = unitService.findAll(StandardUnit.class, "name");
    model.addObject("standardUnits", units);
    addQuantities(model, true);
    
    return model;
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
      Quotation quotation = ((QuotationForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case RATE_SUBFLOW_ID: {
          quotation.setRate(EntityWithIdHelper.createEntity(Rate.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          quotation.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
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
  public ModelAndView save(@ModelAttribute("form") QuotationForm form, Locale locale) {
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
   * @param quotationService the quotationService to set
   */
  @Resource(name = "quotationService")
  public void setQuotationService(GenericService<Quotation> quotationService) {
    super.setMainService(quotationService);
  }

  /**
   * @param type the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> type) {
    typeService = type;
  }
  
  /**
   * @param rateService the rateService to set
   */
  @Resource(name = "rateService")
  public void setRateService(GenericService<Rate> rateService) {
    this.rateService = rateService;
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
  @Resource(name = "quotationFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "quotationTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}