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
package gov.nih.nci.calims2.ui.report.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.report.query.EntityDescriptor;
import gov.nih.nci.calims2.business.report.query.MetadataService;
import gov.nih.nci.calims2.business.report.query.PropertyDescriptor;
import gov.nih.nci.calims2.business.report.query.RelationshipDescriptor;
import gov.nih.nci.calims2.business.report.query.RootClauseSearch;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.domain.report.enumeration.Operator;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;
import gov.nih.nci.calims2.util.json.JsonSerializer;

/**
 * @author viseem
 * 
 */
@Controller
@RequestMapping(QueryController.URL_PREFIX)
public class QueryController extends CRUDController<Query> {
  /** Prefix of urls of this module. */
  static final String URL_PREFIX = "/report/query";

  /** Create type subflow id. */
  static final int TYPE_SUBFLOW_ID = 0;

  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";

  private MetadataService metadataService;
  private GenericService<Type> typeService;
  private JsonSerializer serializer = new JsonSerializer();
  private Map<QueriedEntity, EntityDescriptor> metadataCache;

  /**
   * Default constructor.
   */
  public QueryController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/common/type/create.do?dataElementCollection=" + TypeEnumeration.QUERY });
  }

  /**
   * Initialization method.
   */
  @PostConstruct
  public void init() {
    metadataCache = new HashMap<QueriedEntity, EntityDescriptor>();
    for (QueriedEntity queriedEntity : QueriedEntity.values()) {
      EntityDescriptor descriptor = metadataService.getEntityDescriptor(queriedEntity.getPersistentClass());
      metadataCache.put(queriedEntity, descriptor);
    }
  }
  
  /**
   * adds the mainEntity and rows data to the model.
   * @param model the current model
   */
  public void addEntityAndRows(ModelAndView model) {
    QueryForm form = (QueryForm) model.getModel().get("form");
    String className = form.getEntity().getMainEntity();
    if (className != null) {
      model.addObject("mainEntity", QueriedEntity.getByPersistentClass(className));
      model.addObject("rows", QueryRowRenderer.renderClause(RootClauseSearch.getRootClause(form.getEntity())));
    }
  }

  
  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") QueryForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }
  
  /**
   * {@inheritDoc}
   */
  public ModelAndView completeDetailsModel(ModelAndView model, Locale locale) {
    addEntityAndRows(model);
    return model;
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {
    
    addEntityAndRows(model);
    
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", TypeEnumeration.QUERY.name());
    List<Type> types = typeService.findByNamedQuery(TYPE_QUERY, params);
    model.addObject("types", types);
    
    model.addObject("connectors", getConnectors(locale));
    model.addObject("operators", getOperators(locale));
    model.addObject("tree", getEntityTree(locale));

    return model;
  }
  
  /**
   * Generates the json representation of the connectors dataset.
   * @param locale the current locale.
   * @return the json representation of the connectors dataset.
   */
  public String getConnectors(Locale locale) {
    Map<String, Object> store = new HashMap<String, Object>();
    store.put("identifier", "id");
    store.put("label", "label");
    List<Map<String, Object>> connectors = new ArrayList<Map<String, Object>>();
    store.put("items", connectors);
    for (LogicalConnector connector : LogicalConnector.values()) {
      Map<String, Object> op = new HashMap<String, Object>();
      op.put("id", connector.getName());
      op.put("label", connector.getLocalizedValue(locale));
      connectors.add(op);
    }
    return serializer.serializeObject(store);
  }
  
  /**
   * Generates the json representation of the operators dataset.
   * @param locale the current locale.
   * @return the json representation of the operators dataset.
   */
  public String getOperators(Locale locale) {
    Map<String, Object> store = new HashMap<String, Object>();
    store.put("identifier", "id");
    store.put("label", "label");
    List<Map<String, Object>> operators = new ArrayList<Map<String, Object>>();
    store.put("items", operators);
    for (Operator operator : Operator.values()) {
      Map<String, Object> op = new HashMap<String, Object>();
      op.put("id", operator.getName());
      op.put("label", operator.getLocalizedValue(locale));
      operators.add(op);
    }
    return serializer.serializeObject(store);
  }
  
  /**
   * Gets the json representation of the entity tree data.
   * 
   * @param locale The current locale
   * @return the json representation of the entity tree data.
   */
  public String getEntityTree(Locale locale) {
    IdGenerator idGenerator = new IdGenerator();
    Map<String, Object> tree = new HashMap<String, Object>();
    tree.put("identifier", "id");
    tree.put("label", "name");
    List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
    tree.put("items", items);
    Map<String, Object> root = new HashMap<String, Object>();
    items.add(root);
    MessageSource messageSource = getMessageSource();
    root.put("id", idGenerator.next());
    root.put("name", messageSource.getMessage("report.query.edit.package", null, locale));
    List<Map<String, Object>> packages = new ArrayList<Map<String, Object>>();
    root.put("children", packages);
    for (DomainPackage domainPackage : I18nEnumerationHelper.getLocalizedValues(DomainPackage.class, locale)) {
      Map<String, Object> pack = new HashMap<String, Object>();
      packages.add(pack);
      pack.put("id", idGenerator.next());
      pack.put("name", domainPackage.getLocalizedValue(locale));
      List<Map<String, Object>> entities = new ArrayList<Map<String, Object>>();
      pack.put("children", entities);
      List<QueriedEntity> queriedEntities = QueriedEntity.getByDomainPackage(domainPackage);
      for (QueriedEntity queriedEntity : I18nEnumerationHelper.sortByLocalizedValues(queriedEntities, locale)) {
        entities.add(getEntitySubTree(queriedEntity, idGenerator, locale));
      }
    }
    return serializer.serializeObject(tree);
  }

  /**
   * Gets the subtree for the given entity.
   * @param queriedEntity The entity for which the tree must be built
   * @param idGenerator The id generator
   * @param locale The current locale
   * @return the subtree for the given entity
   */
  public Map<String, Object> getEntitySubTree(QueriedEntity queriedEntity, IdGenerator idGenerator, Locale locale) {
    EntityDescriptor descriptor = metadataCache.get(queriedEntity);
    Map<String, Object> entity = new HashMap<String, Object>();
    entity.put("entity", queriedEntity.name());
    entity.put("id", idGenerator.next());
    entity.put("name", queriedEntity.getLocalizedValue(locale));
    List<Map<String, Object>> parts = new ArrayList<Map<String, Object>>();
    entity.put("children", parts);
    
    for (PropertyDescriptor pdesc : descriptor.getProperties()) {
      Map<String, Object> property = new HashMap<String, Object>();
      parts.add(property);
      property.put("id", idGenerator.next());
      property.put("name", pdesc.getName());
      property.put("type", pdesc.getType());
    }
    
    for (RelationshipDescriptor rdesc : descriptor.getRelationships()) {
      Map<String, Object> relationship = new HashMap<String, Object>();
      parts.add(relationship);
      relationship.put("id", idGenerator.next());
      relationship.put("name", rdesc.getName());
      List<Map<String, Object>> relProperties = new ArrayList<Map<String, Object>>();
      relationship.put("children", relProperties);
      for (PropertyDescriptor pdesc : rdesc.getProperties()) {
        Map<String, Object> property = new HashMap<String, Object>();
        relProperties.add(property);
        property.put("id", idGenerator.next());
        property.put("name", pdesc.getName());
        property.put("relationship", rdesc.getName());
        property.put("type", pdesc.getType());
      }
    }
    return entity;
  }
  
  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Query query = ((QueryForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case TYPE_SUBFLOW_ID: {
          query.setType(EntityWithIdHelper.createEntity(Type.class, entityId));
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
  public ModelAndView save(@ModelAttribute("form") QueryForm form, Locale locale) {
    return doSave(form, locale);
  }
  
  /**
   * @param metadataService the metadataService to set
   */
  @Resource(name = "metadataService")
  public void setMetadataService(MetadataService metadataService) {
    this.metadataService = metadataService;
  }

  /**
   * @param queryService the queryService to set
   */
  @Resource(name = "queryService")
  public void setMainService(GenericService<Query> queryService) {
    super.setMainService(queryService);
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
  @Resource(name = "queryFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "queryTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

}
