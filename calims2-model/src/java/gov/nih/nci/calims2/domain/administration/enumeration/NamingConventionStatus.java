package gov.nih.nci.calims2.domain.administration.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum NamingConventionStatus  implements I18nEnumeration {



/**
* DEFAULT status name.
*/
DEFAULT,
/**
* ACTIVE status name.
*/
ACTIVE,
/**
* APPROVED status name.
*/
APPROVED,
/**
* RECOMMENDED status name.
*/
RECOMMENDED,
/**
* OBSOLETE status name.
*/
OBSOLETE,
/**
* APPROVALPENDING status name.
*/
APPROVALPENDING,
/**
* REQUIRED status name.
*/
REQUIRED,
/**
* REPLACED status name.
*/
REPLACED,
/**
* ALTERNATE status name.
*/
ALTERNATE,
/**
* NOTAPPROVED status name.
*/
NOTAPPROVED,
/**
* WARNING status name.
*/
WARNING;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.l10n.NamingConventionStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
