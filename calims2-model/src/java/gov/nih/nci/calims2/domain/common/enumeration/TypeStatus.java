package gov.nih.nci.calims2.domain.common.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum TypeStatus  implements I18nEnumeration {



/**
* ALTERNATE status name.
*/
ALTERNATE,
/**
* CURRENT status name.
*/
CURRENT,
/**
* DEFAULT status name.
*/
DEFAULT,
/**
* OBSOLETE status name.
*/
OBSOLETE,
/**
* OPTIONAL status name.
*/
OPTIONAL,
/**
* RECOMMENDED status name.
*/
RECOMMENDED,
/**
* REPLACED status name.
*/
REPLACED,
/**
* REQUIRED status name.
*/
REQUIRED;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.common.l10n.TypeStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
