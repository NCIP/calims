/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.role;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
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
@RequestMapping(RoleController.URL_PREFIX)
public class RoleController extends CRUDController<Role> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/role";


  /**
   * Default constructor.
   */
  public RoleController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setAdvancedSearch(true);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    model.addObject("roleStatuses", I18nEnumerationHelper.getLocalizedValues(RoleStatus.class, locale));
    model.addObject("roleTypes", I18nEnumerationHelper.getLocalizedValues(RoleType.class, locale));
    return model;
  }
  
  /**
   * Initialize the roleType attribute of the FlowContext based on the select box in the manage page.
   * 
   * @param roleType The value of the roleType parameter.
   */
  @InitBinder
  public void initFlowContext(@RequestParam(value = "roleType", required = false) String roleType) {
    if (roleType != null) {
      StackFrame frame = FlowContextHolder.getContext().peek();
      frame.addAttribute("roleType", roleType);
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
  public ModelAndView save(@ModelAttribute("form") RoleForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param roleService the roleService to set
   */

  @Resource(name = "roleService")
  public void setRoleService(GenericService<Role> roleService) {
    super.setMainService(roleService);
  }
  
  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "roleFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "roleTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
