/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.util.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.metadata.ConstraintDescriptor;

import gov.nih.nci.calims2.business.generic.GenericViolation;

/**
 * @author connollym@moxieinformatics.com
 *
 */

/**
 * @param <T> The ConstraintViolation
 * 
 */
public class ConstraintViolationImpl<T> implements ConstraintViolation<T> {
  
    private String message;
    private Class<T> beanClass;
    private GenericViolation violation;
  
   
    /**
     * 
     */
    public ConstraintViolationImpl() {
      super();
    }

    /**
     * @param beanClass The class failing validation.
     * @param violation The violation the class generated when validated.
     */
    public ConstraintViolationImpl(Class<T> beanClass, GenericViolation violation) {
      super();
      this.beanClass = beanClass;
      this.violation = GenericViolation.ORIGINAL_NOT_FOUND;
    }
    
    /**
     * @return the beanClass
     */
    public Class<T> getBeanClass() {
      return beanClass;
    }

    /**
     * @param beanClass the beanClass to set
     */
    public void setBeanClass(Class<T> beanClass) {
      this.beanClass = beanClass;
    }

    /**
     * @return the violation
     */
    public GenericViolation getViolation() {
      return violation;
    }

    /**
     * @param violation the violation to set
     */
    public void setViolation(GenericViolation violation) {
      this.violation = violation;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
      this.message = message;
    }
    
  /**
   * {@inheritDoc}
   */
    
  public ConstraintDescriptor<?> getConstraintDescriptor() {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public Object getInvalidValue() {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public Object getLeafBean() {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public String getMessage() {
    return message;
  }
  
  /**
   * {@inheritDoc}
   */
  public String getMessageTemplate() {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public Path getPropertyPath() {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public T getRootBean() {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public Class<T> getRootBeanClass() {
    return beanClass;
  }

}
