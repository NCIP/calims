/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.strain;

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
import gov.nih.nci.calims2.domain.inventory.Strain;
import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;

/**
 * @author connollym
 *
 */
@Controller
@RequestMapping(StrainController.URL_PREFIX)
public class StrainController extends CRUDController<Strain> {

  /** Prefix of urls of this module. */
  public static final String URL_PREFIX = "/inventory/strain";
  
  /** Create type subflow id.   */
  static final int TYPE_SUBFLOW_ID = 0;
  
  /** Create taxon subflow id.   */
  static final int TAXON_SUBFLOW_ID = 1;
  
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";
  
  private GenericService<Taxon> taxonService; 
  private GenericService<Type> typeService;

  /**
   * Default constructor.
   */
  public StrainController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/common/type/create.do?dataElementCollection=" + TypeEnumeration.STRAIN,
        "/inventory/taxon/create.do", });
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
  public ModelAndView call(@ModelAttribute("form") StrainForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<Taxon> taxons = taxonService.findAll(Taxon.class, "name");
    model.addObject("taxons", taxons);

    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.STRAIN.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);

    return model;
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Strain strain = ((StrainForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case TAXON_SUBFLOW_ID: {
          strain.setTaxon(EntityWithIdHelper.createEntity(Taxon.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          strain.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
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
  public ModelAndView save(@ModelAttribute("form") StrainForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * @param strainService the strainService to set
   */
  @Resource(name = "strainService")
  public void setMainService(GenericService<Strain> strainService) {
    super.setMainService(strainService);
  }

  /**
   * @param taxon the taxonService to set
   */
  @Resource(name = "taxonService")
  public void setTaxonService(GenericService<Taxon> taxon) {
    taxonService = taxon;
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
  @Resource(name = "strainFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "strainTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

}
