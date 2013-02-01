package gov.nih.nci.calims2.domain.workflow.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum ApprovalPollStatus  implements I18nEnumeration {



/**
* APPROVED status name.
*/
APPROVED,
/**
* NOTAPPROVED status name.
*/
NOTAPPROVED,
/**
* APPROVEDTOALTN status name.
*/
APPROVEDTOALTN,
/**
* PENDING status name.
*/
PENDING,
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
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.workflow.l10n.ApprovalPollStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}