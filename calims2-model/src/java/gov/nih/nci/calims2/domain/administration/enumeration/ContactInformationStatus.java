package gov.nih.nci.calims2.domain.administration.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum ContactInformationStatus  implements I18nEnumeration {



/**
* ACTIVE status name.
*/
ACTIVE,
/**
* ALTERNATE status name.
*/
ALTERNATE,
/**
* INACTIVE status name.
*/
INACTIVE,
/**
* ADDITIONAL status name.
*/
ADDITIONAL,
/**
* CURRENT status name.
*/
CURRENT,
/**
* DEFAULT status name.
*/
DEFAULT,
/**
* EXPIRED status name.
*/
EXPIRED,
/**
* INVALID status name.
*/
INVALID,
/**
* PERMANENT status name.
*/
PERMANENT,
/**
* PRIMARY status name.
*/
PRIMARY,
/**
* SECONDARY status name.
*/
SECONDARY,
/**
* REQUIRED status name.
*/
REQUIRED,
/**
* TEMPORARY status name.
*/
TEMPORARY,
/**
* UNPUBLISHED status name.
*/
UNPUBLISHED;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.l10n.ContactInformationStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
