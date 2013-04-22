/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.junit.Test;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author viseem
 * 
 */
public class SelectHelperImplTest {

  private List<TestI18nEnum> enumValues = Arrays.asList(TestI18nEnum.values());
  private SelectHelper selectHelper = new SelectHelperImpl();
  private OptionCreatorCallback<I18nEnumeration> callback = new I18nEnumerationOptionCreatorCallback(Locale.US);

  /**
   * Test the getOptions method without a message.
   */
  @Test
  public void testGetOptionsWithoutMessage() {
    List<Option> options = selectHelper.getOptions(enumValues, callback, null);
    assertNotNull("No list of options returned", options);
    assertEquals("Wrong number of options returned", enumValues.size(), options.size());
    int i = 0;
    for (Option option : options) {
      TestI18nEnum enumValue = enumValues.get(i);
      assertEquals("Wrong option id for option " + i, enumValue.getName(), option.getId());
      assertEquals("Wrong option label for option " + i, enumValue.getLocalizedValue(Locale.US), option.getLabel());
      i++;
    }
  }

  /**
   * Test the getOptions method with a message.
   */
  @Test
  public void testGetOptionsWithMessage() {
    String selectKey = "Select";
    List<Option> options = selectHelper.getOptions(enumValues, callback, selectKey);
    assertNotNull("No list of options returned", options);
    assertEquals("Wrong number of options returned", enumValues.size() + 1, options.size());
    int i = -1;
    for (Option option : options) {
      if (i < 0) {
        assertEquals("Wrong option id for option " + i, "-1", option.getId());
        assertNull("Wrong option label for option " + i, option.getLabel());
        assertEquals("Wrong option labelKey for option " + i, selectKey, option.getLabelKey());
      } else {
        TestI18nEnum enumValue = enumValues.get(i);
        assertEquals("Wrong option id for option " + i, enumValue.getName(), option.getId());
        assertEquals("Wrong option label for option " + i, enumValue.getLocalizedValue(Locale.US), option.getLabel());
      }
      i++;
    }
  }

}
