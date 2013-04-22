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

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType;

/**
 * @author viseem
 * 
 */
@RunWith(Parameterized.class)
public class CoordinateHelperConversionTest {
  
  private static final int SMALL_MAX = 20;
  private static final int BIG_MAX = 30;
  private static final int TEN_VALUE = 9;
  private static final int Z_VALUE = 25;
  private static final int ZA_VALUE = 26;

  private LayoutLabelType labelType;
  private int maximum;
  private String label;
  private int value;

  /**
   * Constructor.
   * @param labelType The type of label
   * @param maximum The maximum number of values of the dimension
   * @param label The label
   * @param value The coordinate value
   */
  public CoordinateHelperConversionTest(LayoutLabelType labelType, int maximum, String label, int value) {
    this.labelType = labelType;
    this.maximum = maximum;
    this.label = label;
    this.value = value;
  }

  /**
   * Gets the parameterized test data.
   * 
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][] {{LayoutLabelType.DIGITS, BIG_MAX, "01", 0 }, 
        {LayoutLabelType.DIGITS, BIG_MAX, "10", TEN_VALUE },
        {LayoutLabelType.ALL_UPPER_CASE, BIG_MAX, "AA", 0 }, 
        {LayoutLabelType.ALL_UPPER_CASE, BIG_MAX, "AZ", Z_VALUE }, 
        {LayoutLabelType.ALL_UPPER_CASE, BIG_MAX, "BA", ZA_VALUE },
        {LayoutLabelType.ALL_LOWER_CASE, BIG_MAX, "aa", 0 }, 
        {LayoutLabelType.ALL_LOWER_CASE, BIG_MAX, "az", Z_VALUE }, 
        {LayoutLabelType.ALL_LOWER_CASE, BIG_MAX, "ba", ZA_VALUE },
        {LayoutLabelType.ALL_UPPER_CASE, SMALL_MAX, "A", 0 } };
    return Arrays.asList(data);
  }

  /**
   * test the getCoordinateString method.
   */
  @Test
  public void testGetCoordinateString() {
    String result = CoordinateHelper.getCoordinateString(labelType, maximum, value);
    assertEquals("Wrong result of conversion to label for value " + value, label, result);
  }

  /**
   * test the getCoordinateValue method.
   */
  @Test
  public void testgetCoordinateValue() {
    int result = CoordinateHelper.getCoordinateValue(labelType, label);
    assertEquals("Wrong result of conversion to coordinate for label " + label, value, result);
  }
}
