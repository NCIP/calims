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

public enum PersonStatus  implements I18nEnumeration {



/**
* ABSENT status name.
*/
ABSENT,
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
* AVAILABLE status name.
*/
AVAILABLE,
/**
* UNAVAILABLE status name.
*/
UNAVAILABLE,
/**
* CHILD status name.
*/
CHILD,
/**
* CURRENT status name.
*/
CURRENT,
/**
* DEFAULT status name.
*/
DEFAULT,
/**
* ONLEAVE status name.
*/
ONLEAVE,
/**
* ONSABBATICAL status name.
*/
ONSABBATICAL,
/**
* PARENT status name.
*/
PARENT,
/**
* PERMANENT status name.
*/
PERMANENT,
/**
* RETIRED status name.
*/
RETIRED,
/**
* TEMPORARY status name.
*/
TEMPORARY,
/**
* LEAD status name.
*/
LEAD,
/**
* SEPERATED status name.
*/
SEPERATED;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.l10n.PersonStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
