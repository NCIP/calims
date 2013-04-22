/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.characteristics;

import java.util.Locale;

import gov.nih.nci.calims2.ui.inventory.l10n.CharacteristicsCategoryBundle;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * Enumeration of Characteristics categories.
 * 
 * @author viseem
 * 
 */
public enum CharacteristicsCategory implements I18nEnumeration {
  /** Bio Characteristics. */
  BIO,
  
  /** Chemical Characteristics. */
  CHEMICAL,
  
  /** Physical Characteristics. */
  PHYSICAL;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(CharacteristicsCategoryBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {
    return name();
  }
}
