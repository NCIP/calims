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

import java.util.Locale;

import org.junit.Test;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author viseem
 *
 */
public class I18nEnumerationOptionCreatorCallbackTest {
  
  /**
   * Test the getId method.
   */
  @Test
  public void testGetId() {
    OptionCreatorCallback<I18nEnumeration> callback = new  I18nEnumerationOptionCreatorCallback(Locale.US);
    String result = callback.getId(TestI18nEnum.VALUE1);
    assertEquals("Wrong id returned by the callback", TestI18nEnum.VALUE1.getName(), result);
  }
  
  /**
   * Test the getLabel method.
   */
  @Test
  public void testGetLabel() {
    OptionCreatorCallback<I18nEnumeration> callback = new  I18nEnumerationOptionCreatorCallback(Locale.US);
    String result = callback.getLabel(TestI18nEnum.VALUE1);
    assertEquals("Wrong id returned by the callback", "Value 1", result);
  }

}
