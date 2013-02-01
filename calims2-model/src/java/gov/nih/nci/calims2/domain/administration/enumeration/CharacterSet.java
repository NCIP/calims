package gov.nih.nci.calims2.domain.administration.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum CharacterSet  implements I18nEnumeration {



/**
* ALL_LOWER_CASE status name.
*/
ALL_LOWER_CASE,
/**
* ALL_UPPER_CASE status name.
*/
ALL_UPPER_CASE,
/**
* MIXED_CASE status name.
*/
MIXED_CASE,
/**
* DIGITS status name.
*/
DIGITS;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.l10n.CharacterSetBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
