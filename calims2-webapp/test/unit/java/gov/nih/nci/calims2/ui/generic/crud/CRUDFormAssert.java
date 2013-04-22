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
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * Helper class for common tests in CRUD controllers.
 * 
 * @author viseem
 * 
 */
public class CRUDFormAssert {

  /**
   * Test the result of a collection for a given entity.
   * 
   * @param <T> The type of entity
   * @param eClass The Class object of the entity class
   * @param entities The name of the collection
   * @param ids The id in the collection
   */
  public static <T extends EntityWithId> void assertEntities(Class<T> eClass, Collection<T> entities, Long[] ids) {
    assertNotNull("Entities collection is null", entities);
    assertEquals("Wrong size of the returned collection", ids.length, entities.size());
    Set<Long> idSet = new HashSet<Long>(Arrays.asList(ids));
    for (T entity : entities) {
      assertEquals("Wrong class in the collection", eClass, entity.getClass());
      assertTrue("Wrong id in the collection", idSet.contains(entity.getId()));
      idSet.remove(entity.getId());
    }
  }

  /**
   * Test the result of a id in the given entity.
   * 
   * @param <T> The type of entity
   * @param eClass The Class object of the entity class
   * @param entity The name of the entity
   * @param id The id in the entity
   */
  public static <T extends EntityWithId> void assertEntity(Class<T> eClass, T entity, Long id) {
    assertNotNull("Entity is null", entity);
    assertEquals("Wrong class in the collection", eClass, entity.getClass());
    assertEquals("Wrong id in the entity", id, entity.getId());
  }
}
