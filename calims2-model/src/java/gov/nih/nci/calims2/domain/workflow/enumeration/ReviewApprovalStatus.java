package gov.nih.nci.calims2.domain.workflow.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum ReviewApprovalStatus  implements I18nEnumeration {



/**
* REVIEWEDAPPROVED status name.
*/
REVIEWEDAPPROVED,
/**
* REVIEWEDNOTAPPROVED status name.
*/
REVIEWEDNOTAPPROVED,
/**
* REVIEWEDPENDING status name.
*/
REVIEWEDPENDING,
/**
* REVIEWEDTOALTN status name.
*/
REVIEWEDTOALTN;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.workflow.l10n.ReviewApprovalStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}