package gov.nih.nci.calims2.domain.inventory.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum LayoutLabelType  implements I18nEnumeration {



/**
* ALL_LOWER_CASE status name.
*/
ALL_LOWER_CASE,
/**
* ALL_UPPER_CASE status name.
*/
ALL_UPPER_CASE,
/**
* DIGITS status name.
*/
DIGITS;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.inventory.l10n.LayoutLabelTypeBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}