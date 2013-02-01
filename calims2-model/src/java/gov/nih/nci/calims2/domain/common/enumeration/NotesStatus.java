package gov.nih.nci.calims2.domain.common.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum NotesStatus  implements I18nEnumeration {



/**
* DEFAULT status name.
*/
DEFAULT,
/**
* WARNING status name.
*/
WARNING,
/**
* REQUIRED status name.
*/
REQUIRED,
/**
* OBSOLETE status name.
*/
OBSOLETE,
/**
* REPLACED status name.
*/
REPLACED;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.common.l10n.NotesStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}
