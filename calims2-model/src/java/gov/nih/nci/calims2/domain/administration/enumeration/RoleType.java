package gov.nih.nci.calims2.domain.administration.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum RoleType  implements I18nEnumeration {



/**
* PERSON status name.
*/
PERSON,
/**
* ORGANIZATION status name.
*/
ORGANIZATION,
/**
* COLLABORATION status name.
*/
COLLABORATION,
/**
* LABORATORY status name.
*/
LABORATORY;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.administration.l10n.RoleTypeBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}