package gov.nih.nci.calims2.domain.administration.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum OrganizationStatus  implements I18nEnumeration {



/**
* ACTIVE status name.
*/
ACTIVE,
/**
* INACTIVE status name.
*/
INACTIVE,
/**
* ALTERNATE status name.
*/
ALTERNATE,
/**
* INTERNAL status name.
*/
INTERNAL,
/**
* EXTERNAL status name.
*/
EXTERNAL,
/**
* PRIVATE status name.
*/
PRIVATE,
/**
* PUBLIC status name.
*/
PUBLIC,
/**
* RETIRED status name.
*/
RETIRED,
/**
* LEAD status name.
*/
LEAD,
/**
* RECOMMENDED status name.
*/
RECOMMENDED;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.l10n.OrganizationStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
