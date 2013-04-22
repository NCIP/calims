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

import java.util.ListResourceBundle;

/**
 * @author viseem
 *
 */
public class I18nTestEnumerationBundle extends ListResourceBundle {
  /** key suffix for test of additional keys. */
  public static final String TEST_KEY = ".testkey";
  
  private static final Object[][] CONTENTS = {
    {I18nTestEnumeration.VALUE1.name(), "cc Value1"},
    {I18nTestEnumeration.VALUE2.name(), "tt Value2"},
    {I18nTestEnumeration.VALUE3.name(), "aa Value3"},
    {I18nTestEnumeration.VALUE4.name(), "mm Value4"},
    {I18nTestEnumeration.VALUE5.name(), "ff Value5"},
    {I18nTestEnumeration.VALUE1.name() + TEST_KEY, "key Value1"},
    {I18nTestEnumeration.VALUE2.name() + TEST_KEY, "key Value2"},
    {I18nTestEnumeration.VALUE3.name() + TEST_KEY, "key Value3"},
    {I18nTestEnumeration.VALUE4.name() + TEST_KEY, "key Value4"},
    {I18nTestEnumeration.VALUE5.name() + TEST_KEY, "key Value5"}
    };

  /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }

}
