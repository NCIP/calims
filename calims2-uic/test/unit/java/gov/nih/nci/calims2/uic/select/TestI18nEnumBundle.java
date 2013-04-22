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

import java.util.ListResourceBundle;

/**
 * @author viseem
 *
 */
public class TestI18nEnumBundle extends ListResourceBundle {
  private static final Object[][] CONTENTS = {
    {TestI18nEnum.VALUE1.name(), "Value 1"},
    {TestI18nEnum.VALUE2.name(), "Value 2"},
    {TestI18nEnum.VALUE3.name(), "Value 3"}
    };

  /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }

}
