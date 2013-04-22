/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.chemicalcompound;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.ChemicalCompound;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Nanomaterial;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;

/**
 * @author connollym
 * 
 */
@Controller
@RequestMapping(ChemicalCompoundController.URL_PREFIX)
public class ChemicalCompoundController extends CRUDController<ChemicalCompound> {

  /** Prefix of urls of this module. */
  public static final String URL_PREFIX = "/inventory/chemicalcompound";
  
  /** Create container subflow id. */
  static final int CONTAINER_SUBFLOW_ID = 0;
  
  /** Create nanomatieral subflow id. */
  static final int NANOMATERIAL_SUBFLOW_ID = 1;

  private GenericService<Nanomaterial> specimenService;
  private GenericService<Container> containerService;

  /**
   * Default constructor.
   */
  public ChemicalCompoundController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/inventory/container/create.do", "/inventory/nanomaterial/create.do" });
    config.setAdvancedSearch(true);
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {

    List<Container> containers = containerService.findAll(Container.class, "name");
    model.addObject("containers", containers);

    List<Nanomaterial> nanomaterials = specimenService.findAll(Nanomaterial.class, "name");
    model.addObject("nanomaterials", nanomaterials);

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
  public ModelAndView save(@ModelAttribute("form") ChemicalCompoundForm form, Locale locale) {
    return doSave(form, locale);
  }

  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") ChemicalCompoundForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      ChemicalCompound chemicalcompound = ((ChemicalCompoundForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case CONTAINER_SUBFLOW_ID: {
          chemicalcompound.setContainer(EntityWithIdHelper.createEntity(Container.class, entityId));
          break;
        }
        case NANOMATERIAL_SUBFLOW_ID: {
          chemicalcompound.setNanomaterial(EntityWithIdHelper.createEntity(Nanomaterial.class, entityId));
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }

  /**
   * @param chemicalCompoundService the chemicalCompoundService to set
   */
  @Resource(name = "chemicalCompoundService")
  public void setMainService(GenericService<ChemicalCompound> chemicalCompoundService) {
    super.setMainService(chemicalCompoundService);
  }

  /**
   * @param nanomaterial the specimenService to set
   */
  @Resource(name = "specimenService")
  public void setSpecimenService(GenericService<Nanomaterial> nanomaterial) {
    specimenService = nanomaterial;
  }

  /**
   * @param container the containerService to set
   */
  @Resource(name = "containerService")
  public void setContainerService(GenericService<Container> container) {
    containerService = container;
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "chemicalCompoundFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "chemicalCompoundTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

}
