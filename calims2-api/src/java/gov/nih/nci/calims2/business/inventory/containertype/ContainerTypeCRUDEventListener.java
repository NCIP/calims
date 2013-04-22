/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.containertype;

import java.util.HashSet;
import java.util.Set;

import gov.nih.nci.calims2.business.generic.AuditableCRUDEventListener;
import gov.nih.nci.calims2.domain.inventory.ContainerType;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition;

/**
 * @author viseem
 * 
 */
public class ContainerTypeCRUDEventListener extends AuditableCRUDEventListener<ContainerType> {
  /**
   * {@inheritDoc}
   */
  public ContainerType beforeCreate(ContainerType inputEntity) {
    ContainerType containerType = super.beforeCreate(inputEntity);
    associateDefaultLayout(containerType);
    resetChildContainerType(containerType);
    return containerType;
  }

  /**
   * {@inheritDoc}
   */
  public ContainerType beforeUpdate(ContainerType inputEntity, ContainerType existingEntity) {
    ContainerType containerType = super.beforeUpdate(inputEntity, existingEntity);
    associateDefaultLayout(containerType);
    resetChildContainerType(containerType);
    return containerType;
  }

  /**
   * Adds the default Layout to the collection of associated layouts.
   * 
   * @param inputEntity The container type to process.
   */
  void associateDefaultLayout(ContainerType inputEntity) {
    Layout defaultLayout = inputEntity.getDefaultLayout();
    if (inputEntity.getLayoutCollection() == null) {
      Set<Layout> layouts = new HashSet<Layout>();
      layouts.add(defaultLayout);
      inputEntity.setLayoutCollection(layouts);
      return;
    }
    for (Layout layout : inputEntity.getLayoutCollection()) {
      if (defaultLayout.getId().equals(layout.getId())) {
        return;
      }
    }
    inputEntity.getLayoutCollection().add(defaultLayout);
    return;
  }

  /**
   * Removes any child container type for simple container types.
   * 
   * @param inputEntity The container type to process.
   */
  void resetChildContainerType(ContainerType inputEntity) {
    if (inputEntity.getComposition() == ContainerComposition.SIMPLE) {
      inputEntity.setChildContainerType(null);
    }
  }
}
