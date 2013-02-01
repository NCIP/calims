package gov.nih.nci.calims2.domain.administration.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum EquipmentStatus  implements I18nEnumeration {



/**
* MALFUNCTION status name.
*/
MALFUNCTION,
/**
* ONLINE status name.
*/
ONLINE,
/**
* ACTIVE status name.
*/
ACTIVE,
/**
* ALTERNATE status name.
*/
ALTERNATE,
/**
* AVAILABLE status name.
*/
AVAILABLE,
/**
* DAMAGED status name.
*/
DAMAGED,
/**
* DEFAULT status name.
*/
DEFAULT,
/**
* DELIVERED status name.
*/
DELIVERED,
/**
* DISCARDED status name.
*/
DISCARDED,
/**
* DONATED status name.
*/
DONATED,
/**
* INACTIVE status name.
*/
INACTIVE,
/**
* INMAINTENANCE status name.
*/
INMAINTENANCE,
/**
* INREPAIR status name.
*/
INREPAIR,
/**
* INSTALLED status name.
*/
INSTALLED,
/**
* NOTAPPROVED status name.
*/
NOTAPPROVED,
/**
* OBSOLETE status name.
*/
OBSOLETE,
/**
* OFFLINE status name.
*/
OFFLINE,
/**
* ORDERED status name.
*/
ORDERED,
/**
* REPLACED status name.
*/
REPLACED,
/**
* SURPLUSED status name.
*/
SURPLUSED,
/**
* UNAVAILABLE status name.
*/
UNAVAILABLE,
/**
* UNVALIDATED status name.
*/
UNVALIDATED,
/**
* VALIDATED status name.
*/
VALIDATED,
/**
* VALIDATIONINPROGRESS status name.
*/
VALIDATIONINPROGRESS,
/**
* WARNING status name.
*/
WARNING,
/**
* RESERVED status name.
*/
RESERVED;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.l10n.EquipmentStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
