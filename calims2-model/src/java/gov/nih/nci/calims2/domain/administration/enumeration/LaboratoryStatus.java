package gov.nih.nci.calims2.domain.administration.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum LaboratoryStatus  implements I18nEnumeration {



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
* NOTAPPROVED status name.
*/
NOTAPPROVED,
/**
* AVAILABLE status name.
*/
AVAILABLE,
/**
* DEFAULT status name.
*/
DEFAULT,
/**
* INACTIVE status name.
*/
INACTIVE,
/**
* PRIMARY status name.
*/
PRIMARY,
/**
* PRIVATE status name.
*/
PRIVATE,
/**
* PUBLIC status name.
*/
PUBLIC,
/**
* UNAVAILABLE status name.
*/
UNAVAILABLE,
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
VALIDATIONINPROGRESS,
/**
* LEAD status name.
*/
LEAD;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.l10n.LaboratoryStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
