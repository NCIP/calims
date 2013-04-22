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
import java.util.ArrayList;
import java.util.List;

/**
 * @author viseem
 * 
 */
public class RelationshipDescriptor implements Cloneable, Comparable<RelationshipDescriptor>, Serializable {

  private static final long serialVersionUID = 3849853579323313297L;
  
  private String name;
  private Class<?> persistentClass;
  private List<PropertyDescriptor> properties = new ArrayList<PropertyDescriptor>();

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
   * @return the persistentClass
   */
  public Class<?> getPersistentClass() {
    return persistentClass;
  }

  /**
   * @param persistentClass the persistentClass to set
   */
  public void setPersistentClass(Class<?> persistentClass) {
    this.persistentClass = persistentClass;
  }

  /**
   * @return the properties
   */
  public List<PropertyDescriptor> getProperties() {
    return properties;
  }

  /**
   * @param properties the properties to set
   */
  public void setProperties(List<PropertyDescriptor> properties) {
    this.properties = properties;
  }

  /**
   * {@inheritDoc}
   */
  public int compareTo(RelationshipDescriptor other) {
    return getName().compareTo(other.getName());
  }

  /**
   * {@inheritDoc}
   */
  public RelationshipDescriptor clone() {
    try {
      RelationshipDescriptor clone = (RelationshipDescriptor) super.clone();
      clone.properties = new ArrayList<PropertyDescriptor>();
      for (PropertyDescriptor pdesc : properties) {
        clone.properties.add(pdesc.clone());
      }

      return clone;
    } catch (CloneNotSupportedException e) {
      throw new InternalError("Can not happen. Clone is supported");
    }
  }
}
