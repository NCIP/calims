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

import gov.nih.nci.calims2.business.generic.AuditableCRUDEventListener;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Coordinate;

/**
 * @author viseem
 * 
 */
public class ContainerCRUDEventListener extends AuditableCRUDEventListener<Container> {

  private static final String[] DEFAULT_EXCLUDED_PROPERTIES = new String[] {"childContainerCollection" };
  
  /**
   * Default Constructor
   */
  
  public ContainerCRUDEventListener() {
    setAdditionalExcludedProperties(DEFAULT_EXCLUDED_PROPERTIES);
  }
  
  /**
   * {@inheritDoc}
   */
  public Container afterCreateDefault(Container inputEntity) {
    Coordinate coordinate = new Coordinate();
    coordinate.setX(0);
    coordinate.setY(0);
    inputEntity.setCoordinate(coordinate);
    return inputEntity;
  }

}
