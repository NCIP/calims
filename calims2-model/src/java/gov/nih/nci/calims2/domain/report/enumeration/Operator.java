package gov.nih.nci.calims2.domain.report.enumeration;

import java.util.Locale;

import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;
/**
 * @author connollym@moxieinformatics.com
 *
 */

public enum Operator  implements I18nEnumeration {



/**
* LESS_THAN status name.
*/
LESS_THAN,
/**
* GREATER_THAN status name.
*/
GREATER_THAN,
/**
* LESS_THAN_OR_EQUAL status name.
*/
LESS_THAN_OR_EQUAL,
/**
* GREATER_THAN_OR_EQUAL status name.
*/
GREATER_THAN_OR_EQUAL,
/**
* EQUAL_TO status name.
*/
EQUAL_TO,
/**
* NOT_EQUAL_TO status name.
*/
NOT_EQUAL_TO,
/**
* IS_NULL status name.
*/
IS_NULL,
/**
* IS_NOT_NULL status name.
*/
IS_NOT_NULL,
/**
* IS_LIKE status name.
*/
IS_LIKE,
/**
* IS_NOT_LIKE status name.
*/
IS_NOT_LIKE;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.report.l10n.OperatorBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}