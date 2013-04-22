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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * Default implementation of CRUDEventListener.
 * 
 * It does not do any special business logic.
 * 
 * @author viseem
 * @param <T> The type of Entity being processed.
 * 
 */
public class NullCRUDEventListener<T extends EntityWithId> extends CRUDEventListenerAdapter<T> {

  private static final String[] DEFAULT_EXCLUDED_PROPERTIES = new String[] {"id" };

  private String[] excludedProperties = DEFAULT_EXCLUDED_PROPERTIES;

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public T beforeCreate(T inputEntity) {
    try {
      T newEntity = (T) inputEntity.getClass().newInstance();
      BeanUtils.copyProperties(inputEntity, newEntity, excludedProperties);
      return newEntity;
    } catch (InstantiationException e) {
      throw new InternalError("Cannot happen - EntityWithId classes have a public contructor");
    } catch (IllegalAccessException e) {
      throw new InternalError("Cannot happen - EntityWithId classes have a public contructor");
    }
  }

  /**
   * {@inheritDoc}
   */
  public T beforeCopy(T inputEntity) {
    return beforeCreate(inputEntity);
  }

  /**
   * {@inheritDoc}
   */
  public T beforeUpdate(T inputEntity, T existingEntity) {
    BeanUtils.copyProperties(inputEntity, existingEntity, excludedProperties);
    return existingEntity;
  }

  /**
   * @return the excludedProperties
   */
  protected String[] getExcludedProperties() {
    return excludedProperties;
  }

  /**
   * @param excludedProperties the excludedProperties to set
   */
  public void setExcludedProperties(String[] excludedProperties) {
    this.excludedProperties = excludedProperties;
  }

  /**
   * Sets the AdditionalExcludedProperties.
   * 
   * @param properties The array of property names to add
   */
  public void setAdditionalExcludedProperties(String[] properties) {
    Set<String> propertySet = new HashSet<String>();
    propertySet.addAll(Arrays.asList(excludedProperties));
    propertySet.addAll(Arrays.asList(properties));
    excludedProperties = propertySet.toArray(new String[propertySet.size()]);
  }
}
