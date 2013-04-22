/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.domain.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Helper class for manipulation of Entity with Id
 * 
 * @author viseem
 * 
 */
public class EntityWithIdHelper {

  /**
   * Creates an empty entity with the given id.
   * 
   * @param <T> The type of entity processed.
   * @param clazz The Class of entity to create
   * @param id The selected id to set on the new entity.
   * @return The new entity with the given id set or null if no id was given or if the id was not positive.
   */
  public static <T extends EntityWithId> T createEntity(Class<T> clazz, Long id) {
    if (id != null && id > 0) {
      try {
        T newEntity = clazz.newInstance();
        newEntity.setId(id);
        return newEntity;
      } catch (InstantiationException e) {
        throw new InternalError("Can not happen - EntityWithId classes are concrete classes");
      } catch (IllegalAccessException e) {
        throw new InternalError("Can not happen - EntityWithId classes have a public contructor");
      }
    }
    return null;
  }

  /**
   * Creates a set of empty entities with the given ids.
   * 
   * @param <T> The type of entity processed.
   * @param clazz The Class of entities to creates
   * @param ids The array of ids to set on the new entities.
   * @return The set of new entities with the given ids (Non positive ids are ignored).
   */
  public static <T extends EntityWithId> Set<T> createEntities(Class<T> clazz, Long[] ids) {
    Set<T> result = new HashSet<T>();
    if (ids != null) {
      for (Long id : ids) {
        if (id > 0) {
          result.add(EntityWithIdHelper.createEntity(clazz, id));
        }
      }
    }
    return result;
  }

  /**
   * Generates a List of Ids from a collection of entities.
   * 
   * @param <T> The type of entities in the collection
   * @param entities The collection of readable entities from which the ids are extracted
   * @return A List of the ids in the given collection in the same order as the given collection if ordering is relevant
   */
  public static <T extends EntityWithId> List<Long> toEntityIdsList(Collection<T> entities) {
    List<Long> ids = new ArrayList<Long>(entities.size());
    for (T e : entities) {
      ids.add(e.getId());
    }
    return ids;
  }

  /**
   * Generates a Set of Ids from a collection of entities.
   * 
   * @param <T> The type of entities in the collection
   * @param entities The collection of readable entities from which the ids are extracted
   * @return A Set of the ids in the given collection
   */
  public static <T extends EntityWithId> Set<Long> toEntityIdsSet(Collection<T> entities) {
    Set<Long> ids = new HashSet<Long>(entities.size());
    for (T e : entities) {
      ids.add(e.getId());
    }
    return ids;
  }

  /**
   * Generates an array of Ids from a collection of entities.
   * 
   * @param <T> The type of entities in the collection
   * @param entities The collection of readable entities from which the ids are extracted
   * @return An array of the ids in the given collection in the same order as the given collection if ordering is relevant
   */
  public static <T extends EntityWithId> Long[] toEntityIdsArray(Collection<T> entities) {
    Long[] ids = new Long[entities.size()];
    int i = 0;
    for (T e : entities) {
      ids[i++] = e.getId();
    }
    return ids;
  }
  
  /**
   * Converts a collection of entities to a map where the keys are the entity ids.
   * 
   * @param <T> The type of entities in the collection
   * @param entities The collection of readable entities from which the ids are extracted
   * @return A Map containing all the given entities and where the keys are the entity ids.
   */
  public static <T extends EntityWithId> Map<Long, T> toEntityMap(Collection<T> entities) {
    Map<Long, T> map = new HashMap<Long, T>();
    for (T entity : entities) {
      map.put(entity.getId(), entity);
    }
    return map;
  }

}
