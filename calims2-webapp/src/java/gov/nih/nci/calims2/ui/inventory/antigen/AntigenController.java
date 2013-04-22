/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.antigen;

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
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Antigen;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;

/**
 * @author connollym
 * 
 */
@Controller
@RequestMapping(AntigenController.URL_PREFIX)
public class AntigenController extends CRUDController<Antigen> {

  /** Prefix of urls of this module. */
  public static final String URL_PREFIX = "/inventory/antigen";

  /** Create specimen subflow id. */
  static final int SPECIMEN_SUBFLOW_ID = 1;
  /** Create type subflow id. */
  static final int TYPE_SUBFLOW_ID = 0;

  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";

  private GenericService<Type> typeService;
  private GenericService<Specimen> specimenService;

  /**
   * Default constructor.
   */
  public AntigenController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/common/type/create.do?dataElementCollection=" + TypeEnumeration.ANTIGEN,
        "/inventory/specimen/create.do", });
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
  public ModelAndView call(@ModelAttribute("form") AntigenForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<Specimen> specimens = specimenService.findAll(Specimen.class, "name");
    model.addObject("specimens", specimens);

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.ANTIGEN.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);

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
  public ModelAndView save(@ModelAttribute("form") AntigenForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Antigen antigen = ((AntigenForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case SPECIMEN_SUBFLOW_ID: {
          antigen.setSpecimen(EntityWithIdHelper.createEntity(Specimen.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          antigen.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }

  /**
   * @param antigenService the antigenService to set
   */
  @Resource(name = "antigenService")
  public void setMainService(GenericService<Antigen> antigenService) {
    super.setMainService(antigenService);
  }

  /**
   * @param type the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> type) {
    typeService = type;
  }

  /**
   * @param specimen the specimenService to set
   */
  @Resource(name = "specimenService")
  public void setSpecimenService(GenericService<Specimen> specimen) {
    specimenService = specimen;
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "antigenFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "antigenTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

}
