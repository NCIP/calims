/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.billinginformation;

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
import gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.BillingInformationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
@Controller
@RequestMapping(BillingInformationController.URL_PREFIX)
public class BillingInformationController extends CRUDController<BillingInformation> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/customerservice/billinginformation";

  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 0;

  private GenericService<Type> typeService;

  /**
   * Default constructor.
   */
  public BillingInformationController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/common/type/create.do?dataElementCollection=" + TypeEnumeration.BILLINGINFORMATION });
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
  public ModelAndView call(@ModelAttribute("form") BillingInformationForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }
  
  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    Map<String, Object> params1 = new HashMap<String, Object>();
    params1.put("dataElementCollection", TypeEnumeration.BILLINGINFORMATION.name());
    List<Type> types = typeService.findByNamedQuery("gov.nih.nci.calims2.domain.common.Type.findByDataElementCollection", params1);
    model.addObject("types", types);
    model.addObject("billingInformationStatuses", I18nEnumerationHelper.getLocalizedValues(BillingInformationStatus.class, locale));
    return model;
  }
  

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      BillingInformation billingInformation = ((BillingInformationForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case TYPE_SUBFLOW_ID: {
          billingInformation.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
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
  public ModelAndView save(@ModelAttribute("form") BillingInformationForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param billingInformationService the billingInformationService to set
   */
  @Resource(name = "billingInformationService")
  public void setBillingInformationService(GenericService<BillingInformation> billingInformationService) {
    super.setMainService(billingInformationService);
  }

  /**
   * @param type the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> type) {
    typeService = type;
  }
  
  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "billingInformationFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "billingInformationTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}