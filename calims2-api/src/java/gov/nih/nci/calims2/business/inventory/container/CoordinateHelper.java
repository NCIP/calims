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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.domain.inventory.Coordinate;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType;

/**
 * @author viseem
 * 
 */
public class CoordinateHelper {

  private static final int DIGIT_BASE = 10;
  private static final int LETTER_BASE = 26;

  /**
   * Converts a given integer into a coordinate label according to the label type.
   * 
   * @param labelType The label type
   * @param maximum The maximum number of values in the dimension
   * @param value The value to convert
   * @return The label corresponding to the given value
   */
  public static String getCoordinateString(LayoutLabelType labelType, int maximum, int value) {
    switch (labelType) {
      case DIGITS: {
        String result = Integer.toString(value + 1);
        while (result.length() < 2) {
          result = "0" + result;
        }
        return result;
      }
      case ALL_LOWER_CASE: {
        return convertValue('a', maximum, value);
      }
      case ALL_UPPER_CASE: {
        return convertValue('A', maximum, value);
      }
      default: {
        throw new InternalError("Can not happen");
      }
    }
  }

  private static String convertValue(char firstCharacter, int maximum, int value) {
    int length = (int) Math.floor(Math.log(maximum) / Math.log(LETTER_BASE)) + 1;
    if (value == 0) {
      return StringUtils.repeat(Character.toString(firstCharacter), length);
    }
    String result = "";
    int remaining = value;
    while (remaining > 0) {
      result = Character.toString((char) (firstCharacter + remaining % LETTER_BASE)) + result;
      remaining /= LETTER_BASE;
    }
    while (result.length() < length) {
      result = firstCharacter + result;
    }
    return result;
  }

  /**
   * Converts a given String into the integer coordinate according to the label type.
   * 
   * @param labelType The label type
   * @param value The string to convert
   * @return The coordinate corresponding to the given label.
   */
  public static int getCoordinateValue(LayoutLabelType labelType, String value) {
    if (StringUtils.isBlank(value)) {
      return 0;
    }
    switch (labelType) {
      case DIGITS: {
        return Integer.parseInt(value) - 1;
      }
      case ALL_LOWER_CASE: {
        return convertString('a', value);
      }
      case ALL_UPPER_CASE: {
        return convertString('A', value);
      }
      default: {
        throw new InternalError("Can not happen");
      }
    }
  }

  private static int convertString(char firstCharacter, String value) {
    int result = 0;
    for (int i = 0; i < value.length(); i++) {
      result = result * LETTER_BASE + value.charAt(i) - firstCharacter;
    }
    return result;
  }

  /**
   * Converts a given coordinate in the corresponding coordinate label string.
   * 
   * @param layout The layout
   * @param coordinate The coordinate to convert
   * @return The coordinate label string
   */
  public static String getCoordinateLabel(Layout layout, Coordinate coordinate) {
    String x = getCoordinateString(layout.getX_dimensionLabel(), layout.getX_dimension(), coordinate.getX());
    String y = getCoordinateString(layout.getY_dimensionLabel(), layout.getY_dimension(), coordinate.getY());
    return x + ", " + y;
  }

  /**
   * Converts a given coordinate in the corresponding coordinate suffix string.
   * 
   * @param layout The layout
   * @param coordinate The coordinate to convert
   * @return The coordinate suffix string.
   */
  public static String getCoordinateSuffix(Layout layout, Coordinate coordinate) {
    String x = getCoordinateString(layout.getX_dimensionLabel(), layout.getX_dimension(), coordinate.getX());
    String y = getCoordinateString(layout.getY_dimensionLabel(), layout.getY_dimension(), coordinate.getY());
    return "_" + x + y;
  }

  /**
   * Converts a given list of coordinates in the corresponding list of coordinate label string.
   * 
   * @param layout The layout
   * @param coordinates The coordinates to convert
   * @return The converted coordinates
   */
  public static List<String> getCoordinateLabels(Layout layout, List<Coordinate> coordinates) {
    List<String> labels = new ArrayList<String>();
    for (Coordinate coordinate : coordinates) {
      labels.add(getCoordinateLabel(layout, coordinate));
    }
    return labels;
  }

  /**
   * Calculates the maximum possible length of a suffix for the given layout.
   * 
   * @param layout The layout
   * @return The maximum possible length of a suffix for the given layout.
   */
  public static int getMaximumSuffixLength(Layout layout) {
    return 1 + getMaximumLength(layout.getX_dimensionLabel(), layout.getX_dimension())
        + getMaximumLength(layout.getY_dimensionLabel(), layout.getY_dimension());
  }

  private static int getMaximumLength(LayoutLabelType labelType, int maximum) {
    if (labelType == LayoutLabelType.DIGITS) {
      int length = (int) Math.floor(Math.log(maximum) / Math.log(DIGIT_BASE)) + 1;
      return (length > 1) ? length : 2;
    }
    return (int) Math.floor(Math.log(maximum) / Math.log(LETTER_BASE)) + 1;
  }
}
