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
public class EntityDescriptor implements Cloneable, Serializable {

  private static final long serialVersionUID = 4737833995298962980L;

  private Class<?> persistentClass;
  private boolean subClasses;
  private List<PropertyDescriptor> properties = new ArrayList<PropertyDescriptor>();
  private List<RelationshipDescriptor> relationships = new ArrayList<RelationshipDescriptor>();

  /**
   * @return the persistentClass
   */
  public Class<?> getPersistentClass() {
    return persistentClass;
  }

  /**
   * 
   * @param propertyName The propertyName.
   * @return descriptor The PropertyDescriptor matching the propertyName.
   */
  public PropertyDescriptor getPropertyDescriptor(String propertyName) {
    int dotPosition = propertyName.indexOf('.');
    if (dotPosition < 0) {
      return getPropertyDescriptorInList(properties, propertyName);
    }
    String relationshipName = propertyName.substring(0, dotPosition);
    RelationshipDescriptor relationshipDescriptor = getRelationshipDescriptor(relationshipName);
    return getPropertyDescriptorInList(relationshipDescriptor.getProperties(), propertyName.substring(dotPosition + 1));
  }

  /**
   * Search for the Relationship descriptor for the given relationship name.
   * 
   * @param relationshipName The relationshipName.
   * @return The RelationshipDescriptor found
   */

  public RelationshipDescriptor getRelationshipDescriptor(String relationshipName) {
    for (RelationshipDescriptor rd : relationships) {
      if (rd.getName().equals(relationshipName)) {
        return rd;
      }
    }
    throw new IllegalArgumentException("Relationship: '" + relationshipName + "' does not exist");
  }

  /**
   * Search for the property descriptor for the given property name in the given descriptor list.
   * 
   * @param descriptors The list of descriptors to search in
   * @param propertyName The name of the property to search for
   * @return The descriptor found
   */
  PropertyDescriptor getPropertyDescriptorInList(List<PropertyDescriptor> descriptors, String propertyName) {
    for (PropertyDescriptor descriptor : descriptors) {
      if (descriptor.getName().equals(propertyName)) {
        return descriptor;
      }
    }
    throw new IllegalArgumentException("Property: '" + propertyName + "' does not exist");
  }

  /**
   * @param persistentClass the persistentClass to set
   */
  public void setPersistentClass(Class<?> persistentClass) {
    this.persistentClass = persistentClass;
  }

  /**
   * @return the subClasses
   */
  public boolean getSubClasses() {
    return subClasses;
  }

  /**
   * @param subClasses the subClasses to set
   */
  public void setSubClasses(boolean subClasses) {
    this.subClasses = subClasses;
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
   * Adds a property descriptor.
   * 
   * @param property The property descriptor to add
   * @return The property descriptor just added
   */
  public PropertyDescriptor addProperty(PropertyDescriptor property) {
    properties.add(property);
    return property;
  }

  /**
   * @return the relationships
   */
  public List<RelationshipDescriptor> getRelationships() {
    return relationships;
  }

  /**
   * @param relationships the relationships to set
   */
  public void setRelationships(List<RelationshipDescriptor> relationships) {
    this.relationships = relationships;
  }

  /**
   * Adds a relationship descriptor.
   * 
   * @param relationship The relationship descriptor to add
   * @return The relationship descriptor just added
   */
  public RelationshipDescriptor addRelationship(RelationshipDescriptor relationship) {
    relationships.add(relationship);
    return relationship;
  }

  /**
   * {@inheritDoc}
   */
  public EntityDescriptor clone() {
    try {
      EntityDescriptor clone = (EntityDescriptor) super.clone();
      clone.properties = new ArrayList<PropertyDescriptor>();
      for (PropertyDescriptor pdesc : properties) {
        clone.properties.add(pdesc.clone());
      }
      clone.relationships = new ArrayList<RelationshipDescriptor>();
      for (RelationshipDescriptor rdesc : relationships) {
        clone.relationships.add(rdesc.clone());
      }
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new InternalError("Can not happen. Clone is supported");
    }
  }
}
