/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.dao;

import java.util.List;
import java.util.Map;


/**
 * @author viseem@moxieinformatics.com
 */
public interface GenericDao {
  
  /**
   * save a new instance of the persistent class handled by the DAO.
   * 
   * @param <T> The type of the persistent object to retrieve.
   * @param entity the object to save.
   * @return the newly saved object.
   */
  <T> T create(T entity);

  /**
   * update a previously saved instance of the persistent class handled by the DAO.
   * 
   * @param <T> The type of the persistent object to retrieve.
   * @param entity the object to update. this should be an instance of the persistent class handled by the DAO.
   * @return the updated object.
   */
  <T> T update(T entity);

  /**
   * Deletes the given entity.
   * 
   * @param <T> The type of the persistent object to delete.
   * @param entity the entity to delete.
   * @return the deleted object.
   */
  <T> T delete(T entity);

  /**
   * Returns an instance of the persistence class managed by the DAO, given its id, without locking it.
   * 
   * @param <T> The type of the persistent object to retrieve.
   * @param clazz The actual class of the persistent object to retrieve.
   * @param id of the instance we are looking for.
   * @return the instance with that id or null if not found.
   */
  <T> T findById(Class<T> clazz, Long id);
  
  /**
   * Retrieves all the objects of a given persistent class, ordered according to the given orderByClause.
   * 
   * @param <T> The type of the persistent object to retrieve.
   * @param clazz The actual class of the persistent objects to retrieve.
   * @param orderByClause The optional order by clause for ordering the result.
   * @return All the objects of the given class ordered by the given orderByClause
   */
  <T> List<T> findAll(Class<T> clazz, String orderByClause);
  
  /**
   * Retrieves an object using a named query.
   * 
   * @param <T> The type of the persistent object to retrieve.
   * @param queryName The name of the query
   * @param parameterValues The map of parameter values. Keys are the parameter names
   * @return The List of objects found
   */
  <T> T findEntityByNamedQuery(String queryName, Map<String, Object> parameterValues);
  
  /**
   * Retrieves a collection of objects using a named query.
   * 
   * @param <T> The type of the persistent object to retrieve.
   * @param queryName The name of the query
   * @param parameterValues The map of parameter values. Keys are the parameter names
   * @return The List of objects found
   */
  <T> List<T> findByNamedQuery(String queryName, Map<String, Object> parameterValues);
  
  /**
   * Retrieves a collection of objects using a given HQL query.
   * @param <T> The type of the persistent object to retrieve.
   * @param query The HQL query to execute
   * @param parameterValues The map of parameter values. Keys are the parameter names
   * @return The List of objects found
   */
  <T> List<T> findByHQLQuery(String query, Map<String, Object> parameterValues);
  
  /**
   * Gets the next value of the given sequence.
   * @param sequenceName The name of the sequence
   * @return The next value of the sequence
   */
  long getNextValue(String sequenceName); 
}
