/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.storagedevice;
import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.metadata.BeanDescriptor;

import gov.nih.nci.calims2.business.util.validation.ConstraintViolationImpl;
import gov.nih.nci.calims2.domain.administration.StorageDevice;

/**
 * @author connollym@moxieinformatics.com
 *
 */
public class StorageDeviceValidatorMockup implements Validator {
  private StorageDevice testEntity;

  /**
   * @return testEntity The entity to return.
   */
  public StorageDevice getEntity() {
    return testEntity;
  }

  /**
   * {@inheritDoc}
   */
  public BeanDescriptor getConstraintsForClass(Class<?> clazz) {

    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T> T unwrap(Class<T> storageDevice) {

    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T> Set<ConstraintViolation<T>> validate(T object, Class<?>... groups) {
    testEntity = (StorageDevice) object;
    Set<ConstraintViolation<T>> violations = new HashSet<ConstraintViolation<T>>();
    if (testEntity.getName() == null) {
      ConstraintViolationImpl<T> violation = new ConstraintViolationImpl<T>();
      violation.setMessage("Name required.");
      violations.add(violation);
    }
    return violations;
  }

  /**
   * {@inheritDoc}
   */
  public <T> Set<ConstraintViolation<T>> validateProperty(T object, String propertyName, Class<?>... groups) {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public <T> Set<ConstraintViolation<T>> validateValue(Class<T> beanType, String propertyName, Object value, Class<?>... groups) {
    return null;
  }
}

