/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum ContainerStatus  implements I18nEnumeration {



/**
* ACTIVE status name.
*/
ACTIVE,
/**
* AVAILABLE status name.
*/
AVAILABLE,
/**
* INACTIVE status name.
*/
INACTIVE,
/**
* UNAVAILABLE status name.
*/
UNAVAILABLE,
/**
* CURRENT status name.
*/
CURRENT,
/**
* DAMAGED status name.
*/
DAMAGED,
/**
* DEFAULT status name.
*/
DEFAULT,
/**
* DISCARDED status name.
*/
DISCARDED,
/**
* FAILED status name.
*/
FAILED,
/**
* INSTOCK status name.
*/
INSTOCK,
/**
* OBSOLETE status name.
*/
OBSOLETE,
/**
* OUTOFSTOCK status name.
*/
OUTOFSTOCK,
/**
* PENDING status name.
*/
PENDING,
/**
* RECEIVED status name.
*/
RECEIVED,
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
* SCHEDULED status name.
*/
SCHEDULED,
/**
* SECONDARY status name.
*/
SECONDARY;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.inventory.l10n.ContainerStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
