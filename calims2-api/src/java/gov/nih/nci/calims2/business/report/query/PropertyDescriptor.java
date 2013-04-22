/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.query;

import java.io.Serializable;

/**
 * @author viseem
 * 
 */
public class PropertyDescriptor implements Cloneable, Comparable<PropertyDescriptor>, Serializable {

  private static final long serialVersionUID = -8400004977928719969L;
  
  private String name;
  private String type;
  private Class <?>returnedClass;

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * {@inheritDoc}
   */
  public int compareTo(PropertyDescriptor other) {
    return getName().compareTo(other.getName());
  }

  /**
   * {@inheritDoc}
   */
  public PropertyDescriptor clone() {
    try {
      return (PropertyDescriptor) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new InternalError("Can not happen. Clone is supported");
    }
  }

  /**
   * @return the returnedClass
   */
  public Class<?> getReturnedClass() {
    return returnedClass;
  }

  /**
   * @param returnedClass the returnedClass to set
   */
  public void setReturnedClass(Class<?> returnedClass) {
    this.returnedClass = returnedClass;
  }
}
