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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType;

/**
 * @author viseem
 *
 */
public class CoordinateHelperTest {
  private static final int MAX_DIMENSION = 10;
  private static final int EXPECTED_LENGTH = 5;
  
  /**
   * test the getCoordinateLabel method.
   */
  @Test
  public void testGetCoordinateLabel() {
    Layout layout = createLayout();
    Coordinate coordinate = createCoordinate();
    String label = CoordinateHelper.getCoordinateLabel(layout, coordinate);
    assertEquals("Wrong label returned", "01, 02", label);
  }
  
  /**
   * test the getCoordinateSuffix method.
   */
  @Test
  public void testGetCoordinateSuffix() {
    Layout layout = createLayout();
    Coordinate coordinate = createCoordinate();
    String suffix = CoordinateHelper.getCoordinateSuffix(layout, coordinate);
    assertEquals("Wrong suffix returned", "_0102", suffix);
  }
  
  /**
   * test the getMaximumSuffixLength method.
   */
  @Test
  public void testGetMaximumSuffixLength() {
    Layout layout = createLayout();
    int length = CoordinateHelper.getMaximumSuffixLength(layout);
    assertEquals("Wrong length returned", EXPECTED_LENGTH, length);
  }
  
  private Layout createLayout() {
    Layout layout = new Layout();
    layout.setX_dimension(MAX_DIMENSION);
    layout.setY_dimension(MAX_DIMENSION);
    layout.setX_dimensionLabel(LayoutLabelType.DIGITS);
    layout.setY_dimensionLabel(LayoutLabelType.DIGITS);
    return layout;
  }
  
  private Coordinate createCoordinate() {
    Coordinate coordinate = new Coordinate();
    coordinate.setX(0);
    coordinate.setY(1);
    return coordinate;
  }

}
