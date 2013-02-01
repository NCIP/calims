/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The calims2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This calims2 Software License (the License) is between NCI and You. You (or 
 * Your) shall mean a person or an entity, and all other entities that control, 
 * are controlled by, or are under common control with the entity. Control for 
 * purposes of this definition means (i) the direct or indirect power to cause 
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares, 
 * or (iii) beneficial ownership of such entity. 
 *
 * This License is granted provided that You agree to the conditions described 
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up, 
 * no-charge, irrevocable, transferable and royalty-free right and license in 
 * its rights in the calims2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the calims2 Software; (ii) distribute and 
 * have distributed to and by third parties the calims2 Software and any 
 * modifications and derivative works thereof; and (iii) sublicense the 
 * foregoing rights set out in (i) and (ii) to third parties, including the 
 * right to license such rights to further third parties. For sake of clarity, 
 * and not by way of limitation, NCI shall have no right of accounting or right 
 * of payment from You or Your sub-licensees for the rights granted under this 
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the 
 * above copyright notice, this list of conditions and the disclaimer and 
 * limitation of liability of Article 6, below. Your redistributions in object 
 * code form must reproduce the above copyright notice, this list of conditions 
 * and the disclaimer of Article 6 in the documentation and/or other materials 
 * provided with the distribution, if any. 
 *
 * Your end-user documentation included with the redistribution, if any, must 
 * include the following acknowledgment: This product includes software 
 * developed by Moxie Informatics and the National Cancer Institute. If You do not include 
 * such end-user documentation, You shall include this acknowledgment in the 
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "Moxie Informatics" 
 * to endorse or promote products derived from this Software. This License does 
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or Moxie Informatics, except as required to comply with the 
 * terms of this License. 
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this 
 * Software into Your proprietary programs and into any third party proprietary 
 * programs. However, if You incorporate the Software into third party 
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software 
 * into such third party proprietary programs and for informing Your 
 * sub-licensees, including without limitation Your end-users, of their 
 * obligation to secure any required permissions from such third parties before 
 * incorporating the Software into such third party proprietary software 
 * programs. In the event that You fail to obtain such permissions, You agree 
 * to indemnify NCI for any claims against NCI by such third parties, except to 
 * the extent prohibited by law, resulting from Your failure to obtain such 
 * permissions. 
 *
 * For sake of clarity, and not by way of limitation, You may add Your own 
 * copyright statement to Your modifications and to the derivative works, and 
 * You may provide additional or different license terms and conditions in Your 
 * sublicenses of modifications of the Software, or any derivative works of the 
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, 
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, 
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO 
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, MOXIE INFORMATICS OR THEIR 
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gov.nih.nci.calims2.ui.inventory.wholeorganism;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.inventory.specimen.SpecimenService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.business.util.validation.ValidationMessageHelper;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.AdditionalOrganismName;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.FillPattern;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.inventory.Taxon;
import gov.nih.nci.calims2.domain.inventory.WholeOrganism;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelper;
import gov.nih.nci.calims2.ui.inventory.specimen.SpecimenTableDecorator;
import gov.nih.nci.calims2.ui.util.interceptor.FlowContextInterceptor;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;

/**
 * @author connollym
 *
 */
@Controller
@RequestMapping(WholeOrganismController.URL_PREFIX)
public class WholeOrganismController extends CRUDController<WholeOrganism> {

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/inventory/wholeorganism";
  
  /** Create type subflow id.*/ 
  static final int TYPE_SUBFLOW_ID = 0;
  
  /** Create taxon subflow id.*/ 
  static final int TAXON_SUBFLOW_ID = 1;
  
  /** Create organization subflow id.*/ 
  static final int ORGANIZATION_SUBFLOW_ID = 2;
  
  /** Create location subflow id.*/ 
  static final int LOCATION_SUBFLOW_ID = 3;
  
  /** Create specimen subflow id.*/ 
  static final int SPECIMEN_SUBFLOW_ID = 4;
  
  /** Create specimen subflow id.*/ 
  static final int CONTAINER_SUBFLOW_ID = 5;
  
  /** Create standard unit subflow id.*/ 
  static final int STANDARD_UNIT_SUBFLOW_ID = 6;
  
  /** Create standard unit subflow id.*/ 
  static final int ADDITIONALORGANISMNAME_SUBFLOW_ID = 7;
  
  /** Create person subflow id. */
  static final int PERSON_SUBFLOW_ID = 9;
  
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";
  private static final String CONTAINER_FOR_CREATION_QUERY = Container.class.getName() + ".findContainersForSpecimenCreation";
  private static final String CONTAINER_FOR_UPDATE_QUERY = Container.class.getName() + ".findContainersForSpecimenUpdate";
  
  private GenericService<Container> containerService;
  private GenericService<Location> locationService;
  private GenericService<Organization> organizationService;
  private GenericService<Person> personService;
  private QuantityHelper quantityHelper;
  private GenericService<Taxon> taxonService;
  private GenericService<Type> typeService;
  private GenericService<StandardUnit> unitService;
  private GenericService<AdditionalOrganismName> additionalOrganismNameService;
  private GenericService<ContainerSubcategory> containerSubcategoryService;
  private GenericService<ContainerType> containerTypeService;
  private GenericService<FillPattern> fillPatternService;
  
  /**
   * Default constructor.
   */
  public WholeOrganismController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/common/type/create.do?dataElementCollection=" + TypeEnumeration.WHOLEORGANISM,
                                        "/inventory/taxon/create.do", 
                                        "/administration/organization/create.do",
                                        "/administration/location/create.do",
                                        "/inventory/wholeorganism/create.do",
                                        "/inventory/container/create.do",
                                        "/administration/standardunit/create.do",
                                        "/inventory/additionalorganismname/create.do",
                                        "/common/externalidentifier/enterList.do",
                                        "/administration/person/create.do",
                                        "/inventory/specimen/transferForSpecimen.do",
                                        "/common/document/enterList.do"});
    config.setAdvancedSearch(true);
  }

  /**
   * Adds the category and subcategory to the model.
   * 
   * @param model The model to which the categories must be added.
   */
  void addCategories(ModelAndView model) {
    WholeOrganism specimen = ((WholeOrganismForm) model.getModel().get("form")).getEntity();
    if (specimen.getContainer() != null) {
      Container container = containerService.findById(Container.class, specimen.getContainer().getId());
      model.addObject("containerType", container.getContainerType());
      model.addObject("subCategory", container.getContainerType().getContainerSubcategory());
      model.addObject("category", container.getContainerType().getContainerSubcategory().getType());
    }
  }
  
  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    List<AdditionalOrganismName> additionalOrganismNames = additionalOrganismNameService.findAll(AdditionalOrganismName.class,
        "name");
    model.addObject("additionalOrganismNames", additionalOrganismNames);
    
    WholeOrganismForm form = (WholeOrganismForm) model.getModel().get("form");
    List<Container> containers = null;
    Map<String, Object> params = new HashMap<String, Object>();
    if (form.isEditMode()) {
      params.put("containerId", form.getEntity().getContainer().getId());
      containers = containerService.findByNamedQuery(CONTAINER_FOR_UPDATE_QUERY, params);
    } else {
      containers = containerService.findByNamedQuery(CONTAINER_FOR_CREATION_QUERY, params);
    }
    model.addObject("containers", containers);

    params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.CONTAINER.name());
    List<Type> containerCategories = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("containerCategories", containerCategories);

    List<ContainerSubcategory> containerSubcategories = containerSubcategoryService.findAll(ContainerSubcategory.class, "name");
    model.addObject("containerSubcategories", containerSubcategories);

    List<ContainerType> containerTypes = containerTypeService.findAll(ContainerType.class, "name");
    model.addObject("containerTypes", containerTypes);

    List<FillPattern> fillPatterns = fillPatternService.findAll(FillPattern.class, "name");
    model.addObject("fillPatterns", fillPatterns);
    
    List<Location> locations = locationService.findAll(Location.class, "name");
    model.addObject("locations", locations);

    List<Organization> organizations = organizationService.findAll(Organization.class, "name");
    model.addObject("organizations", organizations);
    
    List<Person> persons = personService.findAll(Person.class, "familyName");
    model.addObject("persons", persons);

    List<Specimen> parentSpecimens = ((GenericService) super.getMainService()).findAll(Specimen.class, "name");
    Specimen specimen = ((WholeOrganismForm) model.getModel().get("form")).getEntity();
    model.addObject("specimens", filterDescendents(parentSpecimens, specimen));
    
    List<Taxon> taxons = taxonService.findAll(Taxon.class, "name");
    model.addObject("taxons", taxons);

    params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.WHOLEORGANISM.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);

    List<StandardUnit> units = unitService.findAll(StandardUnit.class, "name");
    model.addObject("standardUnits", units);

    addCategories(model);
    addQuantities(model, true);
    return model;
  }

  /**
   * 
   * @param model The model to which the quantities must be added.
   * @param createMissing True if quantities missing in the container class must be added.
   */
   void addQuantities(ModelAndView model, boolean createMissing) {
    Set<Quantity> quantities = ((WholeOrganismForm) model.getModel().get("form")).getEntity().getQuantityCollection();
    model.addObject("quantities", quantityHelper.getQuantities(TypeEnumeration.SPECIMEN_QUANTITY, quantities, createMissing));
  }

  /**
   * filters the descendants of the given location from the list of locations.
   * 
   * @param specimens The list of specimens to filter
   * @param specimen The specimen to filter from the list (with all its descendants)
   * @return The filtered list.
   */
  List<Specimen> filterDescendents(List<Specimen> specimens, Specimen specimen) {
    if (specimen.getId() == null) {
      return specimens;
    }
    List<Specimen> result = new ArrayList<Specimen>();
    for (Specimen candidate : specimens) {
      Specimen currentSpecimen = candidate;
      while (currentSpecimen != null && !currentSpecimen.getId().equals(specimen.getId())) {
        currentSpecimen = currentSpecimen.getParentSpecimen();
      }
      if (currentSpecimen == null) {
        result.add(candidate);
      }
    }
    return result;
  }

  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") WholeOrganismForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      WholeOrganism wholeOrganism = ((WholeOrganismForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case TAXON_SUBFLOW_ID: {
          wholeOrganism.setTaxon(EntityWithIdHelper.createEntity(Taxon.class, entityId));
          break;
        }
        case ORGANIZATION_SUBFLOW_ID: {
          wholeOrganism.getOrganizationCollection().add(EntityWithIdHelper.createEntity(Organization.class, entityId));
          break;
        }
        case LOCATION_SUBFLOW_ID: {
          wholeOrganism.getSamplingLocationCollection().add(EntityWithIdHelper.createEntity(Location.class, entityId));
          break;
        }
        case TYPE_SUBFLOW_ID: {
          wholeOrganism.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
          break;
        }
        case SPECIMEN_SUBFLOW_ID: {
          wholeOrganism.setParentSpecimen(EntityWithIdHelper.createEntity(Specimen.class, entityId));
          break;
        }
        case CONTAINER_SUBFLOW_ID: {
          wholeOrganism.setContainer(EntityWithIdHelper.createEntity(Container.class, entityId));
          break;
        }
        case STANDARD_UNIT_SUBFLOW_ID: {
          break;
        }
        case ADDITIONALORGANISMNAME_SUBFLOW_ID : {
 wholeOrganism.getAdditionalOrganismNameCollection().add(EntityWithIdHelper.createEntity(AdditionalOrganismName.class, entityId));
          break;
        }
        case PERSON_SUBFLOW_ID: {
          wholeOrganism.setContactPerson(EntityWithIdHelper.createEntity(Person.class, entityId));
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeDetailsModel(ModelAndView model, Locale locale) {
    addQuantities(model, false);
    addCategories(model);
    return model;
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @return The list view.
   */
  @SuppressWarnings("unchecked")
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") WholeOrganismForm form, Locale locale) {
    
    Container container = containerService.findById(Container.class, form.getContainerId());
    if (container.getContainerType().getComposition() == ContainerComposition.COMPOSITE) {
      CRUDControllerConfig config = getConfig();
      ModelAndView model = new ModelAndView();
      WholeOrganism input = form.getSubmittedEntity();
      try {
        completeExtraction(form);
        GenericService specimenService = super.getMainService();
        ((SpecimenService) specimenService).createForCompositeContainer(input, form.getFillPatternId());
        model.setViewName(config.getRedirectUrl(config.getListCommand()));
        model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.setPersistAttributeForClient(this));
      } catch (ValidationException e) {
        model = createEditModel(input, form.getReturnView(), locale);
        model.addObject("messagekey", ValidationMessageHelper.getErrors(e));
        model.addObject("form", form);
        model.setViewName(config.getFullViewName(config.getEditView()));
        model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
      }
      return model;
    }
    return doSave(form, locale);
  }
  
  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  protected Class<? extends CRUDTableDecorator> getDefaultTableDecoratorClass() {
        return  SpecimenTableDecorator.class;
  }  

  /**
   * @param container the containerService to set
   */
  @Resource(name = "containerService")
  public void setContainerService(GenericService<Container> container) {
    containerService = container;
  }

  /**
   * @param containerSubcategoryService the containerSubcategoryService to set
   */
  @Resource(name = "containerSubcategoryService")
  public void setContainerSubcategoryService(GenericService<ContainerSubcategory> containerSubcategoryService) {
    this.containerSubcategoryService = containerSubcategoryService;
  }

  /**
   * @param containerTypeService the containerTypeService to set
   */
  @Resource(name = "containerTypeService")
  public void setContainerTypeService(GenericService<ContainerType> containerTypeService) {
    this.containerTypeService = containerTypeService;
  }

  /**
   * @param fillPattern the fillPatternService to set
   */
  @Resource(name = "fillPatternService")
  public void setFillPatternService(GenericService<FillPattern> fillPattern) {
    fillPatternService = fillPattern;
  }

  /**
   * @param location the locationService to set
   */
  @Resource(name = "locationService")
  public void setLocationService(GenericService<Location> location) {
    locationService = location;
  }

  /**
   * @param organization the organizationService to set
   */
  @Resource(name = "organizationService")
  public void setOrganizationService(GenericService<Organization> organization) {
    organizationService = organization;
  }

  /**
   * @param person the personService to set
   */
  @Resource(name = "personService")
  public void setPersonService(GenericService<Person> person) {
    personService = person;
  }
  /**
   * @param quantityHelper the quantityHelper to set
   */
  @Resource(name = "quantityHelper")
  public void setQuantityHelper(QuantityHelper quantityHelper) {
    this.quantityHelper = quantityHelper;
  }

  /**
   * @param specimenService the specimenService to set
   */
  @Resource(name = "specimenService")
  public void setSpecimenService(GenericService<WholeOrganism> specimenService) {
    super.setMainService(specimenService);
  }

  /**
   * @param taxon the taxonService to set
   */
  @Resource(name = "taxonService")
  public void setTaxonService(GenericService<Taxon> taxon) {
    taxonService = taxon;
  }

  /**
   * @param additionalOrganismName the additionalOrganismNameService to set
   */
  @Resource(name = "additionalOrganismNameService")
  public void setAdditionalOrganismNameService(GenericService<AdditionalOrganismName> additionalOrganismName) {
    additionalOrganismNameService = additionalOrganismName;
  }
  
  /**
   * @param type the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> type) {
    typeService = type;
  }

  /**
   * @param unitService the unitService to set
   */
  @Resource(name = "unitService")
  public void setUnitService(GenericService<StandardUnit> unitService) {
    this.unitService = unitService;
  }

  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "wholeOrganismFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "wholeOrganismTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
}