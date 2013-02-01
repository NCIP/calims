package gov.nih.nci.calims2.domain.common.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum DocumentStatus  implements I18nEnumeration {



/**
* DRAFT status name.
*/
DRAFT,
/**
* PENDING status name.
*/
PENDING,
/**
* APPROVED status name.
*/
APPROVED,
/**
* APPROVALPENDING status name.
*/
APPROVALPENDING,
/**
* CURRENT status name.
*/
CURRENT,
/**
* OBSOLETE status name.
*/
OBSOLETE,
/**
* DEFAULT status name.
*/
DEFAULT,
/**
* EXPIRED status name.
*/
EXPIRED,
/**
* INPROGRESS status name.
*/
INPROGRESS,
/**
* FINAL status name.
*/
FINAL,
/**
* NOTAPPROVED status name.
*/
NOTAPPROVED,
/**
* PRELIMINARY status name.
*/
PRELIMINARY,
/**
* REVIEWED status name.
*/
REVIEWED,
/**
* TEMPORARY status name.
*/
TEMPORARY,
/**
* REQUIRESREVIEW status name.
*/
REQUIRESREVIEW,
/**
* SUPPLEMENTAL status name.
*/
SUPPLEMENTAL;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.common.l10n.DocumentStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
