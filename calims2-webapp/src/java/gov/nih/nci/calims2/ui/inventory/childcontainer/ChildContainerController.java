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
package gov.nih.nci.calims2.ui.inventory.childcontainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.inventory.container.ChildrenSpecification;
import gov.nih.nci.calims2.business.inventory.container.ContainerService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.ContainerSubcategory;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerStatus;
import gov.nih.nci.calims2.ui.administration.namingconvention.NamingConventionHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.inventory.container.ContainerTableDecorator;
import gov.nih.nci.calims2.ui.inventory.container.LayoutOption;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelper;
import gov.nih.nci.calims2.ui.util.interceptor.FlowContextInterceptor;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym
 *
 */
@Controller
@RequestMapping(ChildContainerController.URL_PREFIX)
public class ChildContainerController extends CRUDController<Container> {
  
  private static Logger log = LoggerFactory.getLogger(ChildContainerController.class);

  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/inventory/childcontainer";
 
  /** Create layout subflow id.*/ 
  static final int LAYOUT_SUBFLOW_ID = 0;
  
  /** Create standard unit subflow id.*/ 
  static final int STANDARD_UNIT_SUBFLOW_ID = 1;
  
  /** Create container sub flow. */
  static final int CONTAINER_SUBFLOW_ID = 2;
  
  /** Create containerType sub flow. */
  static final int CONTAINERTYPE_SUBFLOW_ID = 3;
  
  //private static final String PARENT_QUERY = Container.class.getName() + ".findParentContainers";
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";
  
  private GenericService<ContainerSubcategory> containerSubcategoryService;
  private GenericService<ContainerType> containerTypeService;
  private GenericService<Layout> layoutService;
  private NamingConventionHelper namingConventionHelper;
  private QuantityHelper quantityHelper;
  private GenericService<Type> typeService;
  private GenericService<StandardUnit> unitService;
  
  /**
   * Default constructor.
   */
  public ChildContainerController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/administration/location/create.do",
                                        "/inventory/layout/create.do",
                                        "/administration/standardunit/create.do",
                                        "/inventory/container/create.do",
                                        "/inventory/containertype/create.do"});
  }
  
  /**
   * {@inheritDoc}
   */
  protected Class<? extends CRUDTableDecorator<Container>> getDefaultTableDecoratorClass() {
    return ContainerTableDecorator.class;
  }
  
  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") ContainerForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }
  

  /**
   * Generates the create new type page.
   * 
   * @param currentView The view in which the edit command was issued.
   * @param locale The current locale.
   * @param id The id of the parent Container.
   * @return The new type view.
   */
  @RequestMapping("/createChild.do")
  public ModelAndView createChild(@RequestParam("id") Long id, @RequestParam(value = "currentView", defaultValue = "call") 
      String currentView, Locale locale) {
    logMethod("createChildren");
    ModelAndView model = createEditModel(new Container(), currentView, locale);
    model.addObject("parentContainerId", id);
    model.addObject("createForAll", false);
    return model;
  }
  
  /**
   * Generates the create new type page.
   * 
   * @param currentView The view in which the edit command was issued.
   * @param locale The current locale.
   * @param parentContainerId The id of the parent Container.
   * @return The new type view.
   */
  @RequestMapping("/createChildrenForAll.do")
  public ModelAndView createChildrenForAll(@RequestParam("parentContainerId") Long parentContainerId, 
      @RequestParam(value = "currentView", defaultValue = "call") 
    String currentView, Locale locale) {
    logMethod("createChildrenForAll"); 
    ModelAndView model = createEditModel(new Container(), currentView, locale);
    model.addObject("parentContainerId", parentContainerId);
    model.addObject("createForAll", true);
    return model;
  }
  

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Container container = ((ContainerForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case CONTAINER_SUBFLOW_ID: {
          container.setParentContainer(EntityWithIdHelper.createEntity(Container.class, entityId));
          break;
        }
        case LAYOUT_SUBFLOW_ID: {
          container.setLayout(EntityWithIdHelper.createEntity(Layout.class, entityId));
          break;
        }
        case STANDARD_UNIT_SUBFLOW_ID : {
          break;
        }
        case CONTAINERTYPE_SUBFLOW_ID: {
          container.setContainerType(EntityWithIdHelper.createEntity(ContainerType.class, entityId));
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
  public List<Container> createList() {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("parentId", (FlowContextHolder.getContext().peek()).getAttribute("id"));
    return getMainService().findByNamedQuery(Container.class.getName() + ".findByParentContainer", params);
  }
  
  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @return The list view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView saveChildren(@ModelAttribute("form") ContainerForm form, Locale locale) {
    ChildrenSpecification specification = form.getSubmittedSpecification();
    if (form.isCreateForAll()) {
      Container parentContainer = super.getMainService().findById(Container.class, form.getParentContainerId());
      for (Container container : parentContainer.getChildContainerCollection()) {
        if (container.getChildContainerCollection() == null || container.getChildContainerCollection().size() == 0) {
          specification.addParentContainerId(container.getId());
        }
      }
    } else {
      specification.addParentContainerId(form.getParentContainerId());
    }
    ModelAndView model = new ModelAndView();
    try {
      ((ContainerService) getMainService()).createChildren(specification);
      Stack<StackFrame> context = FlowContextHolder.getContext();
      StackFrame newFrame = new BaseStackFrame();
      newFrame.addAttribute("id", form.getParentContainerId());
      context.push(newFrame);
      model.setViewName(CRUDControllerConfig.REDIRECT_PREFIX + getConfig().getUrlPrefix() + getConfig().getListCommand());
      model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.setPersistAttributeForClient(this));
    } catch (ValidationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return model;
  }
  
  /**
   * Return to the return url from a subflow.
   * @param locale The current locale.
   * @return The list view
   */
  @RequestMapping("/returnToParent.do")
  public ModelAndView returnToParent(Locale locale) {
    logMethod("returnToParent");
    ModelAndView model = new ModelAndView();
    Stack<StackFrame> context = FlowContextHolder.getContext();
    context.pop();
    StackFrame frame = context.peek();
    if (frame.getReturnUrl() != null) {
      context.pop();
      model.setView(new InternalResourceView(frame.getReturnUrl()));
    } else {
      model = list("call", null, locale);
    }
    return model;
  }
 
  
  /**
   * Return to the return url from a subflow.
   * @return The list view.
   * @param id The id of the parent Container.
   * @param locale The current locale.
   */
  @RequestMapping("/drillDown.do")
  public ModelAndView drillDown(@RequestParam("id") Long id, Locale locale) {
    logMethod("drillDown");
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame newFrame = new BaseStackFrame();
    newFrame.addAttribute("id", id);
    context.push(newFrame);
    return list("call", null, locale);
  }
  
  /**
   * Complete the standard model for the list view.
   * 
   * @param model The standard model for the list view.
   * @param locale The current locale.
   * @return The completed model for the list view.
   */
  public ModelAndView completeListModel(ModelAndView model, Locale locale) {
    model.addObject("parentContainerId", (FlowContextHolder.getContext().peek()).getAttribute("id"));
    return model;
  }
  
  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.CONTAINER.name());
    
    List<Type> containerCategories = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("containerCategories", containerCategories);
    
    List<ContainerSubcategory> containerSubcategories = containerSubcategoryService.findAll(ContainerSubcategory.class, "name");
    model.addObject("containerSubcategories", containerSubcategories);
    
    List<ContainerType> containerTypes = containerTypeService.findAll(ContainerType.class, "name");
    model.addObject("containerTypes", containerTypes);
    model.addObject("containerStatuses", I18nEnumerationHelper.getLocalizedValues(ContainerStatus.class, locale));
    
    List<Layout> layouts = layoutService.findAll(Layout.class, "name");
    model.addObject("layoutOptions", getLayoutOptions(layouts));
    model.addObject("namingConventions", namingConventionHelper.getNamingConventions(NamingConventionType.CONTAINERNAME));
    
    List<StandardUnit> units = unitService.findAll(StandardUnit.class, "name");
    model.addObject("standardUnits", units);
    addQuantities(model, true);
    addCategories(model);
    return model;
    
  }
  
  /**
   * 
   * @param model The model to which the quantities must be added.
   * @param createMissing True if quantities missing in the container class must be added.
   */
  void addQuantities(ModelAndView model, boolean createMissing) {
    Set<Quantity> quantities = ((ContainerForm) model.getModel().get("form")).getEntity().getCapacityCollection();
    model.addObject("quantities", quantityHelper.getQuantities(TypeEnumeration.CONTAINER_QUANTITY, quantities, createMissing));
  }

  /**
   * Adds the category and subcategory to the model.
   * @param model The model to which the categories must be added.
   */
  void addCategories(ModelAndView model) {
    Container container = ((ContainerForm) model.getModel().get("form")).getEntity();
    if (container.getContainerType() != null) {
      ContainerType containerType = containerTypeService.findById(ContainerType.class, container.getContainerType().getId());
      model.addObject("subCategory", containerType.getContainerSubcategory());
      model.addObject("category", containerType.getContainerSubcategory().getType());
    } 
  }
  
  /**
   * Gets the options for the layout-container types select box.
   * @param layouts the layouts to use to set the options
   * @return The list of options for the layout select box
   */
  List<LayoutOption> getLayoutOptions(List<Layout> layouts) {
    List<LayoutOption> options = new ArrayList<LayoutOption>();
    for (Layout layout : layouts) {
      for (ContainerType type : layout.getContainerTypeCollection()) {
        log.debug("layout - container : {} - {}", layout.getId(), type.getName());
        LayoutOption option = new LayoutOption(layout.getId().toString() + "-" + type.getId().toString(), layout.getName(), type
            .getId().toString());
        options.add(option);
      }
    }
    return options;
  }
  
  /**
   * @param containerService the containerService to set
   */
  @Resource(name = "containerService")
  public void setContainerService(GenericService<Container> containerService) {
    super.setMainService(containerService);
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
   * @param layoutService the layoutService to set
   */
  @Resource(name = "layoutService")
  public void setLayoutService(GenericService<Layout> layoutService) {
    this.layoutService = layoutService;
  }
  
  /**
   * @param namingConventionHelper the namingConventionHelper to set
   */
  @Resource(name = "namingConventionHelper")
  public void setNamingConventionHelper(NamingConventionHelper namingConventionHelper) {
    this.namingConventionHelper = namingConventionHelper;
  }
  
  /**
   * @param quantityHelper the quantityHelper to set
   */
  @Resource(name = "quantityHelper")
  public void setQuantityHelper(QuantityHelper quantityHelper) {
    this.quantityHelper = quantityHelper;
  }
  
  /**
   * @param typeService the typeService to set
   */
  @Resource(name = "typeService")
  public void setTypeService(GenericService<Type> typeService) {
    this.typeService = typeService;
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
  @Resource(name = "childContainerFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "childContainerTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }
  
}