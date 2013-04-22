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
public class LayoutHelperMockup implements LayoutHelper {

  private List<Container> containers;
  private List<Coordinate> coordinates;
  private List<Layout> layouts;

  /**
   * {@inheritDoc}
   */
  public String getContainerLayoutMap(List<Container> pcontainers) {
    containers = pcontainers;
    return "getContainerLayoutMap";
  }

  /**
   * {@inheritDoc}
   */
  public String getCoordinates(List<Coordinate> pcoordinates) {
    coordinates = pcoordinates;
    return "getCoordinates";
  }

  /**
   * {@inheritDoc}
   */
  public String getLayoutMap(List<Layout> playouts) {
    layouts = playouts;
    return "getLayoutMap";
  }

  /**
   * @return the containers
   */
  public List<Container> getContainers() {
    return containers;
  }

  /**
   * @return the coordinates
   */
  public List<Coordinate> getCoordinates() {
    return coordinates;
  }

  /**
   * @return the layouts
   */
  public List<Layout> getLayouts() {
    return layouts;
  }

}
