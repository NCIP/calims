/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
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
