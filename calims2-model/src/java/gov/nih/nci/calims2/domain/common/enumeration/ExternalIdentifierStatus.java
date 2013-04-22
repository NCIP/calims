/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.common.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum ExternalIdentifierStatus  implements I18nEnumeration {



/**
* ALTERNATE status name.
*/
ALTERNATE,
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
* INVALID status name.
*/
INVALID,
/**
* OBSOLETE status name.
*/
OBSOLETE,
/**
* PRIVATE status name.
*/
PRIVATE,
/**
* PUBLIC status name.
*/
PUBLIC,
/**
* REPLACED status name.
*/
REPLACED,
/**
* REQUIRED status name.
*/
REQUIRED,
/**
* UNAVAILABLE status name.
*/
UNAVAILABLE,
/**
* UNKNOWN status name.
*/
UNKNOWN,
/**
* VALIDATED status name.
*/
VALIDATED;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.common.l10n.ExternalIdentifierStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}