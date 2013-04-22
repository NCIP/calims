/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.generic;

import java.util.List;
import java.util.Map;

import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * A set of methods for operating on a GenericService.
 * 
 * @author connollym@moxieinformatics.com
 * @param <T> The type of Entity being processed.
 */

public interface GenericService<T extends EntityWithId> {

  /**
   * Creates a default entity.
   * 
   * @param clazz The class of the entity to create.
   * @return The newly created entity.
   */
  T createDefault(Class<T> clazz);

  /**
   * Creates a new entity.
   * 
   * @param entity Entity to create. This should be a non persistent object containing the data of the new Entity
   * @return The newly created entity.
   * @throws ValidationException if the data is not valid.
   */
  T create(T entity) throws ValidationException;
 
  /**
   * Copies an entity.
   * 
   * @param entity Entity to copy. This should be a non persistent object containing the data of the Entity being copied
   * @return The entity being copied.
   */
  T copy(T entity);

  /**
   * Updates the given entity.
   * 
   * @param entity Entity to update. This should be a non persistent object containing the data of the entity to update, including
   *          its Id.
   * @return The updated entity.
   * @throws ValidationException if the data is not valid.
   */
  T update(T entity) throws ValidationException;

  /**
   * 
   * Deletes an entity by id.
   * 
   * @param clazz The type of entity to delete.
   * @param id The id of the entity to delete.
   * @return The deleted entity.
   * @throws ValidationException if the data is not valid
   */
  T delete(Class<T> clazz, Long id) throws ValidationException;

  /**
   * Retrieves an entity by id.
   * 
   * @param clazz The type of entity to retrieve.
   * @param id The id of the entity to retrieve.
   * @return the instance with that id or null if not found.
   */
  T findById(Class<T> clazz, Long id);

  /**
   * Retrieves all the objects of a given persistent class, ordered according to the given orderByClause.
   * 
   * @param clazz The actual class of the persistent objects to retrieve.
   * @param orderByClause The optional order by clause for ordering the result.
   * @return All the objects of the given class ordered by the given orderByClause
   */
  List<T> findAll(Class<T> clazz, String orderByClause);

  /**
   * Retrieves an object using a named query.
   * 
   * @param queryName The name of the query
   * @param parameterValues The map of parameter values. Keys are the parameter names
   * @return The List of objects found
   */
  T findEntityByNamedQuery(String queryName, Map<String, Object> parameterValues);

  /**
   * Retrieves a collection of entities using a named query.
   * 
   * @param queryName The name of the query
   * @param parameterValues The map of parameter values. Keys are the parameter names
   * @return The List of entities found
   */
  List<T> findByNamedQuery(String queryName, Map<String, Object> parameterValues);

}
