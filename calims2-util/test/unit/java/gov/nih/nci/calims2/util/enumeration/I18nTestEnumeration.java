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

import java.util.Locale;

/**
 * @author viseem
 *
 */
public enum I18nTestEnumeration implements I18nEnumeration {
  /** Test value 1. */
  VALUE1,
  /** Test value 2. */
  VALUE2,
  /** Test value 3. */
  VALUE3,
  /** Test value 4. */
  VALUE4,
  /** Test value 5. */
  VALUE5;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(I18nTestEnumerationBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {
    return name();
  }

}
