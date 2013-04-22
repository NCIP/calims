/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.common.type;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.common.enumeration.TypeStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
@Controller
@RequestMapping(TypeController.URL_PREFIX)
public class TypeController extends CRUDController<Type> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/common/type";

  /**
   * Default constructor.
   */
  public TypeController() {
    super(URL_PREFIX, "name");
    getConfig().setManageView("manage");
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    model.addObject("typeStatuses", I18nEnumerationHelper.getLocalizedValues(TypeStatus.class, locale));
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public List<Type> createList() {
    StackFrame frame = FlowContextHolder.getContext().peek();
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", frame.getAttribute("dataElementCollection"));
    return getMainService().findByNamedQuery("gov.nih.nci.calims2.domain.common.Type.findByDataElementCollection", params);
  }

  /**
   * Calls a direct method.
   * 
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping("/directCall.do")
  public ModelAndView directCall() {
    logMethod("doCall");
    ModelAndView model = new ModelAndView();
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    model.setView(new InternalResourceView("/common/type/create.do?dataElementCollection=" + TypeEnumeration.CONTAINER
        + "&currentView=/common/type/manage.do"));
    return model;
  }

  /**
   * Initialize the dataElementCollection attribute of the FlowCpntext based on the select box in the manage page.
   * 
   * @param dataElementCollection The value of the dataElementCollection parameter.
   */
  @InitBinder
  public void initFlowContext(@RequestParam(value = "dataElementCollection", required = false) String dataElementCollection) {
    if (dataElementCollection != null) {
      StackFrame frame = FlowContextHolder.getContext().peek();
      frame.addAttribute("dataElementCollection", dataElementCollection);
    }
  }

  /**
   * {@inheritDoc}
   */
  @RequestMapping(CRUDControllerConfig.STD_MANAGE_COMMAND)
  public ModelAndView manage(Locale locale) {
    ModelAndView model = super.manage(locale);
    model.addObject("types", I18nEnumerationHelper.getLocalizedValues(TypeEnumeration.class, locale));
    return model;
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param locale The current locale.
   * @param form The object containing the values of the entity to be saved.
   * @return The list view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") TypeForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param typeService the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> typeService) {
    super.setMainService(typeService);
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "typeFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "typeTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
