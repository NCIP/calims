/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.util.enumeration;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;
/**
 * @author viseem
 *
 */
public class I18nEnumerationHelperTest {
  
  /**
   * Test the getNamesOf method.
   */
  @Test
  public void testGetNamesOf() {
    List<I18nTestEnumeration> enums = Arrays.asList(new I18nTestEnumeration[] {I18nTestEnumeration.VALUE1,
        I18nTestEnumeration.VALUE2, I18nTestEnumeration.VALUE4 });
    String[] names = I18nEnumerationHelper.getNamesOf(enums);
    assertNotNull("No array returned", names);
    assertEquals("Returned array has a wrong size", enums.size(), names.length);
    for (int i = 0; i < enums.size(); i++) {
      assertEquals("Wrong result in position " + i, enums.get(i).name(), names[i]);
    }
  }
  
  /**
   * Test the getByName method for an existing value.
   */
  @Test
  public void testGetByNameForExistingValue() {
    I18nTestEnumeration value = I18nEnumerationHelper.getByName(I18nTestEnumeration.class, "VALUE3");
    assertEquals("Wrong value returned by getByName", I18nTestEnumeration.VALUE3, value);
  }
  
  /**
   * Test the getByName method for an non existing value.
   */
  @Test
  public void testGetByNameForNonExistingValue() {
    I18nTestEnumeration value = I18nEnumerationHelper.getByName(I18nTestEnumeration.class, "XXXXXXXX");
    assertNull("Wrong value returned by getByName", value);
  }

  /**
   * Test the getByNames method.
   */
  @Test
  public void testGetByNames() {
    String[] names = new String[] {"VALUE3", "VALUE5", "VALUE1" };
    List<I18nTestEnumeration> enums = I18nEnumerationHelper.getByNames(I18nTestEnumeration.class, names);
    assertNotNull("No List returned", enums);
    assertEquals("Returned list has a wrong size", names.length, enums.size());
    for (String name : names) {
      assertTrue("Enumeration value not present for name " + name, enums.indexOf(I18nTestEnumeration.valueOf(name)) != -1);
    }
  }

  /**
   * Test the getLocalizedValue method.
   */
  @Test
  public void testGetLocalizedValue() {
    String res = I18nEnumerationHelper.getLocalizedValue(I18nTestEnumerationBundle.class, Locale.US, I18nTestEnumeration.VALUE1);
    assertEquals("Wrong value returned", "cc Value1", res);
  }

  /**
   * Test the getLocalizedDependantValue method.
   */
  @Test
  public void testGetLocalizedDependantValue() {
    String res = I18nEnumerationHelper.getLocalizedDependantValue(I18nTestEnumerationBundle.class, Locale.US,
                                                                  I18nTestEnumeration.VALUE1, I18nTestEnumerationBundle.TEST_KEY);
    assertEquals("Wrong value returned", "key Value1", res);
  }

  /**
   * Test the getLocalizedValuesAsStrings method.
   */
  @Test
  public void testGetLocalizedValuesAsStrings() {
    List<I18nTestEnumeration> enums = Arrays.asList(new I18nTestEnumeration[] {I18nTestEnumeration.VALUE1,
        I18nTestEnumeration.VALUE2, I18nTestEnumeration.VALUE4 });
    String[] expected = new String[] {"cc Value1", "mm Value4", "tt Value2" };
    List<String> values = I18nEnumerationHelper.getLocalizedValuesAsStrings(enums, Locale.US);
    assertNotNull("No List returned", values);
    assertArrayEquals("Wrong List returned", expected, values.toArray(new String[enums.size()]));
  }

  /**
   * Test the getLocalizedValues method.
   */
  @Test
  public void testgetLocalizedValues() {
    I18nTestEnumeration[] expected = new I18nTestEnumeration[] {I18nTestEnumeration.VALUE3, I18nTestEnumeration.VALUE1,
        I18nTestEnumeration.VALUE5, I18nTestEnumeration.VALUE4, I18nTestEnumeration.VALUE2 };
    List<I18nTestEnumeration> enums = I18nEnumerationHelper.getLocalizedValues(I18nTestEnumeration.class, Locale.US);
    assertNotNull("No List returned", enums);
    assertArrayEquals("Wrong List returned", expected, enums.toArray(new I18nTestEnumeration[enums.size()]));
  }
  
  /**
   * Test the sortByLocalizedValues method.
   */
  @Test
  public void testSortByLocalizedValues() {
    List<I18nTestEnumeration> enums = Arrays.asList(new I18nTestEnumeration[] {I18nTestEnumeration.VALUE1,
        I18nTestEnumeration.VALUE2, I18nTestEnumeration.VALUE4 });
    I18nTestEnumeration[] expected = new I18nTestEnumeration[] {I18nTestEnumeration.VALUE1, I18nTestEnumeration.VALUE4,
        I18nTestEnumeration.VALUE2 };
    List<I18nTestEnumeration> result = I18nEnumerationHelper.sortByLocalizedValues(enums, Locale.US);
    assertNotNull("No List returned", enums);
    assertArrayEquals("Wrong List returned", expected, result.toArray(new I18nTestEnumeration[result.size()]));
  }
}
