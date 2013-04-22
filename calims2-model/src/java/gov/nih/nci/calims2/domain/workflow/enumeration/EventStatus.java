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

public enum EventStatus  implements I18nEnumeration {



/**
* AVAILABLE status name.
*/
AVAILABLE,
/**
* UNAVAILABLE status name.
*/
UNAVAILABLE,
/**
* ACTIVE status name.
*/
ACTIVE,
/**
* INACTIVE status name.
*/
INACTIVE,
/**
* VALIDATED status name.
*/
VALIDATED,
/**
* UNVALIDATED status name.
*/
UNVALIDATED,
/**
* DEFAULT status name.
*/
DEFAULT,
/**
* ALTERNATE status name.
*/
ALTERNATE,
/**
* RECOMMENDED status name.
*/
RECOMMENDED,
/**
* REQUIRED status name.
*/
REQUIRED,
/**
* RETIRED status name.
*/
RETIRED,
/**
* REPLACED status name.
*/
REPLACED,
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
* DELIVERED status name.
*/
DELIVERED,
/**
* ORDERED status name.
*/
ORDERED,
/**
* RECEIVED status name.
*/
RECEIVED,
/**
* OUTOFSTOCK status name.
*/
OUTOFSTOCK,
/**
* INTERNAL status name.
*/
INTERNAL,
/**
* DISCARDED status name.
*/
DISCARDED,
/**
* EXPIRED status name.
*/
EXPIRED,
/**
* WARNING status name.
*/
WARNING,
/**
* CURRENT status name.
*/
CURRENT,
/**
* PRIVATE status name.
*/
PRIVATE,
/**
* PUBLIC status name.
*/
PUBLIC,
/**
* VALIDATIONINPROGRESS status name.
*/
VALIDATIONINPROGRESS;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.workflow.l10n.EventStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}