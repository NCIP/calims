/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.layout;

import java.util.List;

import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.Layout;

/**
 * @author viseem
 * 
 */
public interface LayoutHelper {
  /**
   * Gets the json representation of a collection of layouts.
   * 
   * @param layouts The layouts
   * @return the json representation of a collection of layouts
   */
  String getLayoutMap(List<Layout> layouts);

  /**
   * Gets the json representation of the container layout relationship as a container id to layout id map.
   * 
   * @param containers The list of containers to put in the map
   * @return the json representation of the container layout relationship as a container id to layout id map.
   */
  String getContainerLayoutMap(List<Container> containers);

  /**
   * Gets the json representation of a collection of coordinates.
   * 
   * @param coordinates The list of coordinates to render
   * @return the json representation of a collection of coordinates.
   */
  String getCoordinates(List<Coordinate> coordinates);
}
