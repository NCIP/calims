package gov.nih.nci.calims2.domain.administration.customerservice.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum AccountStatus  implements I18nEnumeration {



/**
* ACTIVE status name.
*/
ACTIVE,
/**
* ALTERNATE status name.
*/
ALTERNATE,
/**
* APPROVALPENDING status name.
*/
APPROVALPENDING,
/**
* APPROVED status name.
*/
APPROVED,
/**
* AVAILABLE status name.
*/
AVAILABLE,
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
* INACTIVE status name.
*/
INACTIVE,
/**
* NOTAPPROVED status name.
*/
NOTAPPROVED,
/**
* PENDING status name.
*/
PENDING,
/**
* REPLACED status name.
*/
REPLACED;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.customerservice.l10n.AccountStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
