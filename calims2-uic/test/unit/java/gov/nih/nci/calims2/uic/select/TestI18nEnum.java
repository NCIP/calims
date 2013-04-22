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

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author viseem
 *
 */
public enum TestI18nEnum implements I18nEnumeration {
  /** TEST VALUE 1. */
  VALUE1,
  /** TEST VALUE 2. */
  VALUE2,
  /** TEST VALUE 3. */
  VALUE3;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(TestI18nEnumBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {
    return name();
  }

}
