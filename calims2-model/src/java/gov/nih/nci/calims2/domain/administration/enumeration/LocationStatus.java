/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum LocationStatus  implements I18nEnumeration {



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
* PRIMARY status name.
*/
PRIMARY,
/**
* RECOMMENDED status name.
*/
RECOMMENDED,
/**
* SECONDARY status name.
*/
SECONDARY,
/**
* TEMPORARY status name.
*/
TEMPORARY;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.l10n.LocationStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
