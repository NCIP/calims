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

import java.util.Collections;

import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.ComponentType;
import org.hibernate.type.Type;

/**
 * @author viseem
 *
 */
public class MetadataServiceImpl implements MetadataService {
  
  private SessionFactory sessionFactory;

  /**
   * {@inheritDoc}
   */
  public EntityDescriptor getEntityDescriptor(Class<?> persistentClass) {
    return getEntityDescriptor(persistentClass, false);
  }
  
  /**
   * Get the entity descriptor for the given persistent class.
   * @param persistentClass The persistent class
   * @param excludeRelationship true if relationship must not be extracted
   * @return the entity descriptor for the given persistent class.
   */
  EntityDescriptor getEntityDescriptor(Class<?> persistentClass, boolean excludeRelationship) {
    EntityDescriptor descriptor = new EntityDescriptor();
    descriptor.setPersistentClass(persistentClass);
    ClassMetadata metadata = sessionFactory.getClassMetadata(persistentClass.getName());
    descriptor.setSubClasses(metadata.hasSubclasses());
    for (String name : metadata.getPropertyNames()) {
      Type type = metadata.getPropertyType(name);
      processProperty(descriptor, "", name, type, excludeRelationship);
    }
    Collections.sort(descriptor.getProperties());
    Collections.sort(descriptor.getRelationships());
    return descriptor;
  }
  
  /**
   * Process a given property for the descriptor construction. 
   * @param descriptor The descriptor under construction
   * @param prefix The property prefix (in case of component properties)
   * @param name The property name
   * @param type The property type
   * @param excludeRelationship true if relationship must not be extracted
   */
  void processProperty(EntityDescriptor descriptor, String prefix, String name, Type type, boolean excludeRelationship) {
    if (type.isAssociationType()) {
      if (excludeRelationship) {
        return;
      }
      if (!type.isCollectionType()) {
        RelationshipDescriptor rd = new RelationshipDescriptor();
        rd.setName(name);
        Class<?> relatedClass;
        try {
          relatedClass = Class.forName(type.getName());
        } catch (ClassNotFoundException e) {
          throw new InternalError("Should not happern. Hibernate is initialized correctly at this point");
        }
        rd.setPersistentClass(relatedClass);
        EntityDescriptor relatedClassDescriptor = getEntityDescriptor(relatedClass, true);
        rd.setProperties(relatedClassDescriptor.getProperties());
        Collections.sort(rd.getProperties());
        descriptor.addRelationship(rd);
      }
    } else {
      if (type.isComponentType()) {
        ComponentType componentType = (ComponentType) type;
        String[] propertyNames = componentType.getPropertyNames();
        Type[] types = componentType.getSubtypes();
        String newPrefix = prefix + name + ".";
        for (int i = 0; i < propertyNames.length; i++) {
          processProperty(descriptor, newPrefix, propertyNames[i], types[i], false);
        }
      } else {
        if (!type.isCollectionType()) {
          PropertyDescriptor property = new PropertyDescriptor();
          property.setName(prefix + name);
          property.setType(type.getName());
          property.setReturnedClass(type.getReturnedClass());
          descriptor.addProperty(property);
        }
      }
    }
  }

  /**
   * @param sessionFactory the sessionFactory to set
   */
  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

}
