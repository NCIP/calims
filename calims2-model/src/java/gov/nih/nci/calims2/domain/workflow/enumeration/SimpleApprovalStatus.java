/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.workflow.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum SimpleApprovalStatus  implements I18nEnumeration {



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
PENDING;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.workflow.l10n.SimpleApprovalStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}