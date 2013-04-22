/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.container;

import java.util.List;
import java.util.Map;

import gov.nih.nci.calims2.dao.GenericDao;
import gov.nih.nci.calims2.domain.inventory.ContainerType;

/**
 * @author viseem
 *
 */
public class ContainerDaoMockup implements GenericDao {

  /**
   * {@inheritDoc}
   */
  public <T> T create(T entity) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T delete(T entity) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T> List<T> findAll(Class<T> clazz, String orderByClause) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public <T> T findById(Class<T> clazz, Long id) {
    ContainerType containerType = new ContainerType();
    containerType.setId(id);
   // containerType.setIsComposite(id.equals(1L));
    return (T) containerType;
  }

  /**
   * {@inheritDoc}
   */
  public <T> List<T> findByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T findEntityByNamedQuery(String queryName, Map<String, Object> parameterValues) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T update(T entity) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public long getNextValue(String sequenceName) {
    return 0;
  }

  /**
   * {@inheritDoc}
   */
  public <T> List<T> findByHQLQuery(String query, Map<String, Object> parameterValues) {
    return null;
  }

}
