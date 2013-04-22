/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.word;

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
import gov.nih.nci.calims2.domain.administration.Word;
import gov.nih.nci.calims2.domain.administration.enumeration.CharacterSet;
import gov.nih.nci.calims2.domain.administration.enumeration.WordStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
@Controller
@RequestMapping(WordController.URL_PREFIX)
public class WordController extends CRUDController<Word> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/word";

  /**
   * Default constructor.
   */
  public WordController() {
    super(URL_PREFIX, "name");
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    model.addObject("wordStatuses", I18nEnumerationHelper.getLocalizedValues(WordStatus.class, locale));
    model.addObject("characterSets", I18nEnumerationHelper.getLocalizedValues(CharacterSet.class, locale));
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public List<Word> createList() {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("namingConventionId", (FlowContextHolder.getContext().peek()).getAttribute("id"));
    return getMainService().findByNamedQuery(Word.class.getName() + ".findByNamingConventionId", params);
  }

  /**
   * Saves an entity and returns a refreshed list page.
   * 
   * @param form The object containing the values of the type entity to be saved.
   * @param locale The current locale.
   * @return The list view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") WordForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param wordService the wordService to set
   */
  @Resource(name = "wordService")
  public void setMainService(GenericService<Word> wordService) {
    super.setMainService(wordService);
  }
  
  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "wordFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "wordTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}
