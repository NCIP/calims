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

public enum RoleStatus  implements I18nEnumeration {



/**
* ACTIVE status name.
*/
ACTIVE,
/**
* INACTIVE status name.
*/
INACTIVE,
/**
* ALTERNATE status name.
*/
ALTERNATE,
/**
* CURRENT status name.
*/
CURRENT,
/**
* EXPIRED status name.
*/
EXPIRED,
/**
* DEFAULT status name.
*/
DEFAULT,
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
* PRIMARY status name.
*/
PRIMARY,
/**
* SECONDARY status name.
*/
SECONDARY,
/**
* SUPPLEMENTAL status name.
*/
SUPPLEMENTAL;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.l10n.RoleStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
