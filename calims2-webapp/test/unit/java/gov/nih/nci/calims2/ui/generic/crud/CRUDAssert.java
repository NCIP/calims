/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.generic.crud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.ui.inventory.quantity.QuantityHelperMockup;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;
import gov.nih.nci.calims2.uic.select.OptionCreatorCallback;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * Helper class for common tests in CRUD controllers.
 * 
 * @author viseem
 * 
 */
public class CRUDAssert {

  /**
   * Check the working of the standard CRUDController constructor.
   * 
   * @param <T> The type of entity.
   * @param controller The controller to check
   * @param urlPrefix The expected url prefix.
   * @param viewPrefix The expected view prefix.
   * @param orderByClause The expected orderByClause
   * @param persistentClass The expected persistent class.
   * @param formClass the expected form class
   * @param tableDecoratorClass The expected table decorator class
   */
  public static <T extends EntityWithId> void assertControllerConstructor(CRUDController<T> controller, String urlPrefix,
      String viewPrefix, String orderByClause, Class<T> persistentClass, Class<? extends CRUDForm<T>> formClass, 
          Class<?> tableDecoratorClass) {
    CRUDControllerConfig config = controller.getConfig();
    assertEquals("Wrong url prefix in the config", urlPrefix, config.getUrlPrefix());
    assertEquals("Wrong view prefix in the config", viewPrefix, config.getViewPrefix());
    assertEquals("Wrong orderByClause in the config", orderByClause, config.getOrderByClause());
    assertEquals("Wrong persistent class", persistentClass, controller.getPersistentClass());
    assertEquals("Wrong form class", formClass, controller.getFormClass());
    assertEquals("Wrong list decorator class", tableDecoratorClass, controller.getTableDecoratorClass());
  }

  /**
   * Test a list returned by findAll in the given model.
   * 
   * @param <T> The type of entity.
   * @param service The service mockup
   * @param pClass The Class object of the persistent class
   * @param orderByClause The expected order by clause
   * @param listName The name of the result in the model.
   * @param model The model holding the result.
   */
  public static <T extends EntityWithId> void assertFindAll(GenericServiceMockup<T> service, Class<T> pClass, String orderByClause,
      String listName, ModelAndView model) {
    assertEquals("Wrong class passed to findAll", pClass, service.getFindAllClass());
    assertEquals("Wrong order by clause passed to findAll", orderByClause, service.getFindAllOrderByClause());
    assertEquals("Wrong list returned in the model", service.getFindAllResult(), model.getModel().get(listName));
  }

  /**
   * Test the results of a Type.findByDataElementCollection in the model.
   * 
   * @param typeService The typeServiceMockup.
   * @param typeType The type of type to retrieve.
   * @param listName The name of the result in the model.
   * @param model The model holding the result.
   */
  public static void assertTypes(GenericServiceMockup<Type> typeService, TypeEnumeration typeType, String listName,
      ModelAndView model) {
    Map<String, Object> params = typeService.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong number of paramters", 1, params.size());
    String queryName = Type.class.getName() + ".findByDataElementCollection";
    assertEquals("Wrong Query name passed to findAll", queryName, typeService.getFindByQueryName());
    assertEquals("Wrong parameter passed to findByNamedQuery", typeType.name(), params.get("dataElementCollection"));
    assertEquals("Wrong list returned in the model", typeService.getFindByQueryNameResult(), model.getModel().get(listName));
  }
  
  /**
   * Check a callback in the model.
   * 
   * @param model The model to check
   * @param callbackName The name of the callback in the model
   * @param callbackClass The expected class of the callback
   */
  public static void checkCallback(ModelAndView model, String callbackName, 
                                   Class<? extends OptionCreatorCallback<?>> callbackClass) {
    OptionCreatorCallback<?> callback = (OptionCreatorCallback<?>) model.getModel().get(callbackName);
    assertNotNull("Missing callback " + callbackName, callback);
    assertEquals("Wrong class for callback " + callbackName, callbackClass, callback.getClass());
  }
  
  /**
   * Test the result of an enumeration collection in the given model.
   * @param <T> The type of enumeration
   * @param model The model to check
   * @param collectionName The name of the collection in the model
   * @param enumClass The enumeration class
   */
  @SuppressWarnings("unchecked")
  public static <T extends Enum<T> & I18nEnumeration> void assertEnumerationCollection(ModelAndView model, String collectionName,
      Class<T> enumClass) {
    List<T> expected = I18nEnumerationHelper.getLocalizedValues(enumClass, Locale.US);
    List<T> result = (List<T>) model.getModel().get(collectionName);
    assertEquals("Wrong size of the returned collection", expected.size(), result.size());
    for (int i = 0; i < expected.size(); i++) {
      assertEquals("Wrong Element at position " + i, expected.get(i), result.get(i));
    }
  }
  
  /**
   * Check the results of a named query.
   * @param <T> The type of entity.
   * @param model The model to check
   * @param service The service
   * @param parameterNumber The number of query parameters
   * @param queryName The expected query name
   * @param resultName The name of the result in the model
   * @return The map of parameters
   */
  public static <T extends EntityWithId> Map<String, Object> assertNamedQuery(ModelAndView model, GenericServiceMockup<T> service, 
      int parameterNumber, String queryName, String resultName) {
    Map<String, Object> params = service.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong number of paramters", parameterNumber, params.size());
    assertEquals("Wrong Query name passed to findAll", queryName, service.getFindByQueryName());
    assertEquals("Wrong list returned in the model", service.getFindByQueryNameResult(), model.getModel().get(resultName));
    return params;
  }
  
  /**
   * Check the result entity of a return from subflow for a to-one relationship.
   * @param <T> The type of entity.
   * @param entity The entity to test
   * @param id The expected id
   */
  public static <T extends EntityWithId> void assertSubFlowEntity(T entity, Long id) {
    assertNotNull("No entity found", entity);
    assertEquals("Entity does not have the proper id", id, entity.getId());
  }
  
  /**
   * Check the result entity of a return from subflow for a to-many relationship.
   * @param <T> The type of entity.
   * @param entities The collection of entities to test
   * @param id The expected id
   */
  public static <T extends EntityWithId> void assertSubFlowEntities(Collection<T> entities, Long id) {
    assertNotNull("No entity found", entities);
    int found = 0;
    for (T entity : entities) {
      if (id.equals(entity.getId())) {
        found++;
      }
    }
    assertEquals("Wrong number of entity found", 1, found);
  }
  
  /**
   * Check the result of the quantity helper in the given model.
   * @param model The model to check
   * @param quantityHelper The quantity helper
   * @param expectedType The expected quantity types
   * @param expectedCreateMissing The expected create missing flag
   */
  public static void assertQuantities(ModelAndView model, QuantityHelperMockup quantityHelper, TypeEnumeration expectedType, 
      boolean expectedCreateMissing) {
    assertEquals("Wrong Type in quantityHelper call", expectedType, quantityHelper.getSavedQuantityType());
    assertEquals("Wrong value of the create missing flag", expectedCreateMissing, quantityHelper.getSaveCreateMissing());
    assertEquals("Wrong result for quantities", quantityHelper.getResult(), model.getModel().get("quantities"));
  }
}
