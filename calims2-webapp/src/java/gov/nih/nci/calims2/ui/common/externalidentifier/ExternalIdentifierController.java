/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.common.externalidentifier;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.common.ExternalIdentifier;
import gov.nih.nci.calims2.domain.common.enumeration.ExternalIdentifierStatus;
import gov.nih.nci.calims2.domain.interfaces.EntityWithExternalId;
import gov.nih.nci.calims2.domain.inventory.Specimen;
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
@RequestMapping(ExternalIdentifierController.URL_PREFIX)
public class ExternalIdentifierController extends CRUDController<ExternalIdentifier> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/common/externalidentifier";

  /**
   * Default constructor.
   */
  public ExternalIdentifierController() {
    super(URL_PREFIX, "name");
  }
  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    model.addObject("externalIdentifierStatuses", I18nEnumerationHelper.getLocalizedValues(ExternalIdentifierStatus.class, locale));
    return model;
  }
  
 

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public List<ExternalIdentifier> createList() {
    StackFrame frame = FlowContextHolder.getContext().peek();
    Class<? extends EntityWithExternalId> persistentClass = (Class<? extends EntityWithExternalId>) 
    frame.getAttribute("persistentClass");
    if (Specimen.class.isAssignableFrom(persistentClass)) {
      persistentClass = Specimen.class;
    }
    String queryName = ExternalIdentifier.class.getName() + ".findBy" + persistentClass.getSimpleName() + "Id";
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("id", frame.getAttribute("id"));
    return getMainService().findByNamedQuery(queryName, params);
  }

  /**
   * Saves an entity and returns a refreshed list page.
   * 
   * @param form The object containing the values of the type entity to be saved.
   * @param locale The current locale.
   * @return The list view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") ExternalIdentifierForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param externalIdentifierService the externalIdentifierService to set
   */
  @Resource(name = "externalIdentifierService")
  public void setMainService(GenericService<ExternalIdentifier> externalIdentifierService) {
    super.setMainService(externalIdentifierService);
  }
  
  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "externalIdentifierFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "externalIdentifierTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}