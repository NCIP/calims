/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.namingconvention;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;
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
@RequestMapping(NamingConventionController.URL_PREFIX)
public class NamingConventionController extends CRUDController<NamingConvention> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/administration/namingconvention";

  /** Create laboratory sub flow. */
  static final int LABORATORY_SUBFLOW_ID = 0;
  
  /** Create person sub flow. */
  static final int PERSON_SUBFLOW_ID = 1;

  private GenericService<Laboratory> laboratoryService;
  private GenericService<Person> personService; 
 
  /**
   * Default constructor.
   */
  public NamingConventionController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/laboratory/create.do", 
                                         "/administration/person/create.do",
                                         "/administration/word/enterList.do",
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
  public ModelAndView call(@ModelAttribute("form") NamingConventionForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<Laboratory> laboratories = laboratoryService.findAll(Laboratory.class, "name");
    model.addObject("laboratories", laboratories);
    model.addObject("namingConventionStatuses", I18nEnumerationHelper.getLocalizedValues(NamingConventionStatus.class, locale));
    model.addObject("namingConventionTypes", I18nEnumerationHelper.getLocalizedValues(NamingConventionType.class, locale));
    List<Person> persons = personService.findAll(Person.class, "familyName");
    model.addObject("persons", persons);
    return model;
  }
  
  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      NamingConvention namingConvention = ((NamingConventionForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case LABORATORY_SUBFLOW_ID: {
          namingConvention.setLaboratory(EntityWithIdHelper.createEntity(Laboratory.class, entityId));
          break;
        }
        case PERSON_SUBFLOW_ID: {
          namingConvention.setContactPerson(EntityWithIdHelper.createEntity(Person.class, entityId));
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }

  /**
   * Makes a call to save a type object than returns a refreshed list type page.
   * 
   * 
   * @param form The object containing the values of the type entity to be saved.
   * @param locale The current locale.
   * @return The list type view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") NamingConventionForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param namingConventionService the namingConventionService to set
   */
  @Resource(name = "namingConventionService")
  public void setNamingConventionService(GenericService<NamingConvention> namingConventionService) {
    super.setMainService(namingConventionService);
  }

  /**
   * @param laboratoryService the laboratoryService to set
   */
  @Resource(name = "laboratoryService")
  public void setLaboratoryService(GenericService<Laboratory> laboratoryService) {
    this.laboratoryService = laboratoryService;
  }

  /**
   * @param personService the personService to set
   */
  @Resource(name = "personService")
  public void setPersonService(GenericService<Person> personService) {
    this.personService = personService;
  }
  
  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "namingConventionFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "namingConventionTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

}
