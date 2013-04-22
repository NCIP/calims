/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.taxon;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.domain.inventory.enumeration.TaxonStatus;
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
@RequestMapping(TaxonController.URL_PREFIX)
public class TaxonController extends CRUDController<Taxon> {

  /** Prefix of urls of this module. */
  public static final String URL_PREFIX = "/inventory/taxon";

  /**
   * Default constructor.
   */
  public TaxonController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setAdvancedSearch(true);
  }
  
  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    
    model.addObject("taxonStatuses", I18nEnumerationHelper.getLocalizedValues(TaxonStatus.class, locale));
    return model;
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @return The list view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") TaxonForm form, Locale locale) {
    return doSave(form, locale);
  }
  
  /**
   * @param taxonService the taxonService to set
   */
  @Resource(name = "taxonService")
  public void setMainService(GenericService<Taxon> taxonService) {
    super.setMainService(taxonService);
  }
  
  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "taxonFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "taxonTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

}
