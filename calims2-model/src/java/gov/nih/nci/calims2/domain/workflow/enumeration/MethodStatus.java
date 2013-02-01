package gov.nih.nci.calims2.domain.workflow.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum MethodStatus  implements I18nEnumeration {



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
* INPROGRESS status name.
*/
INPROGRESS,
/**
* COMPLETED status name.
*/
COMPLETED,
/**
* INREVIEW status name.
*/
INREVIEW,
/**
* REVIEWED status name.
*/
REVIEWED,
/**
* PUBLISHED status name.
*/
PUBLISHED;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.workflow.l10n.MethodStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}