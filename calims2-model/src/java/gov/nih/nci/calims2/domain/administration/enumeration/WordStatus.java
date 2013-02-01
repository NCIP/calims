package gov.nih.nci.calims2.domain.administration.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum WordStatus  implements I18nEnumeration {



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
REQUIRED,
/**
* UNVALIDATED status name.
*/
UNVALIDATED,
/**
* VALIDATED status name.
*/
VALIDATED,
/**
* VALIDATIONINPROGRESS status name.
*/
VALIDATIONINPROGRESS;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.l10n.WordStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
