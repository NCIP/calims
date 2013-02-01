package gov.nih.nci.calims2.domain.workflow.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum BiochemicalReactionMixtureStatus  implements I18nEnumeration {



/**
* AVAILABLE status name.
*/
AVAILABLE,
/**
* UNAVAILABLE status name.
*/
UNAVAILABLE,
/**
* APPROVED status name.
*/
APPROVED,
/**
* NOTAPPROVED status name.
*/
NOTAPPROVED,
/**
* APPROVALPENDING status name.
*/
APPROVALPENDING,
/**
* INTERNAL status name.
*/
INTERNAL,
/**
* CURRENT status name.
*/
CURRENT,
/**
* VALIDATIONINPROGRESS status name.
*/
VALIDATIONINPROGRESS,
/**
* COMPLETED status name.
*/
COMPLETED,
/**
* CANCELLED status name.
*/
CANCELLED;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.workflow.l10n.BiochemicalReactionMixtureStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}