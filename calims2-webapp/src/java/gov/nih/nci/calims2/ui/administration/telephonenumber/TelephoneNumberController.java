/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.telephonenumber;

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
import gov.nih.nci.calims2.domain.administration.TelephoneNumber;
import gov.nih.nci.calims2.domain.administration.enumeration.TelephoneNumberStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
@Controller
@RequestMapping(TelephoneNumberController.URL_PREFIX)
public class TelephoneNumberController extends CRUDController<TelephoneNumber> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/telephonenumber";

  /** Create type sub flow. */
  static final int TYPE_SUBFLOW_ID = 0;
  
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";

  private GenericService<Type> typeService;

  /**
   * Default constructor.
   */
  public TelephoneNumberController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/common/type/create.do?dataElementCollection=" + TypeEnumeration.TELEPHONENUMBER });
  }
  
  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") TelephoneNumberForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }
  
  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    model.addObject("telephoneNumberStatuses", I18nEnumerationHelper.getLocalizedValues(TelephoneNumberStatus.class, locale));
    
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.TELEPHONENUMBER.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);
    
    return model;
  }
  
  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public List<TelephoneNumber> createList() {
    StackFrame frame = FlowContextHolder.getContext().peek();
    Class<? extends EntityWithId> persistentClass = (Class<? extends EntityWithId>) frame.getAttribute("persistentClass");
    String queryName = TelephoneNumber.class.getName() + ".findBy" + persistentClass.getSimpleName() + "Id";
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", frame.getAttribute("id"));
    return getMainService().findByNamedQuery(queryName, params);
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      TelephoneNumber telephoneNumber = ((TelephoneNumberForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case TYPE_SUBFLOW_ID: {
          telephoneNumber.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
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
   * @return The list view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") TelephoneNumberForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param telephoneNumberService the telephoneNumberService to set
   */

  @Resource(name = "telephoneNumberService")
  public void setTelephoneNumberService(GenericService<TelephoneNumber> telephoneNumberService) {
    super.setMainService(telephoneNumberService);
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
  @Resource(name = "telephoneNumberFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "telephoneNumberTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
