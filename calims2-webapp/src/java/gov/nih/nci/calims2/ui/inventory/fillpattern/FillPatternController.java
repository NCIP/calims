/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.fillpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.inventory.container.CoordinateHelper;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.FillPattern;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.inventory.layout.LayoutHelper;
import gov.nih.nci.calims2.uic.descriptor.table.Table;

/**
 * @author connollym
 *
 */
@Controller
@RequestMapping(FillPatternController.URL_PREFIX)
public class FillPatternController extends CRUDController<FillPattern> {

  /** Prefix of urls of this module. */
  public static final String URL_PREFIX = "/inventory/fillpattern";
  
  /** Create person sub flow. */
  static final int PERSON_SUBFLOW_ID = 0;
  
  /** Create layout sub flow. */
  static final int LAYOUT_SUBFLOW_ID = 1;
  
  private LayoutHelper layoutHelper;
  private GenericService<Layout> layoutService;
  private GenericService<Person> personService;

  /**
   * Default constructor.
   */
  public FillPatternController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/person/create.do",
                                        "/inventory/layout/create.do"});
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
  public ModelAndView call(@ModelAttribute("form") FillPatternForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }
  
  /**
   * {@inheritDoc}
   */
  public ModelAndView completeDetailsModel(ModelAndView model, Locale locale) {
    FillPattern fillPattern = ((FillPatternForm) model.getModel().get("form")).getEntity();
    Layout layout = fillPattern.getLayout();
    model.addObject("coordinates", layoutHelper.getCoordinates(fillPattern.getCoordinateCollection()));
    model.addObject("labels", CoordinateHelper.getCoordinateLabels(layout, fillPattern.getCoordinateCollection()));
    List<Layout> layouts = new ArrayList<Layout>();
    layouts.add(layout);
    model.addObject("layoutMap", layoutHelper.getLayoutMap(layouts));
    return model;
  }
  
  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    FillPattern fillPattern = ((FillPatternForm) model.getModel().get("form")).getEntity();
    model.addObject("coordinates", layoutHelper.getCoordinates(fillPattern.getCoordinateCollection()));
    List<Layout> layouts = layoutService.findAll(Layout.class, "name");
    model.addObject("layouts", layouts);
    model.addObject("layoutMap", layoutHelper.getLayoutMap(layouts));
    List<Person> persons = personService.findAll(Person.class, "familyName");
    model.addObject("persons", persons);
    return model;
  }
  
  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      FillPattern fillPattern = ((FillPatternForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case PERSON_SUBFLOW_ID: {
          fillPattern.setContactPerson(EntityWithIdHelper.createEntity(Person.class, entityId));
          break;
        }
        case LAYOUT_SUBFLOW_ID: {
          fillPattern.setLayout(EntityWithIdHelper.createEntity(Layout.class, entityId));
          fillPattern.setCoordinateCollection(new ArrayList<Coordinate>());
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
  public ModelAndView save(@ModelAttribute("form") FillPatternForm form, Locale locale) {
    return doSave(form, locale);
  }
  
  /**
   * @param fillPatternService the fillPatternService to set
   */
  @Resource(name = "fillPatternService")
  public void setMainService(GenericService<FillPattern> fillPatternService) {
    super.setMainService(fillPatternService);
  }
  
  /**
   * @param layoutHelper the layoutHelper to set
   */
  @Resource(name = "layoutHelper")
  public void setLayoutHelper(LayoutHelper layoutHelper) {
    this.layoutHelper = layoutHelper;
  }
  
  /**
   * @param layoutService the layoutService to set
   */
  @Resource(name = "layoutService")
  public void setLayoutService(GenericService<Layout> layoutService) {
    this.layoutService = layoutService;
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
  @Resource(name = "fillPatternFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "fillPatternTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

}

