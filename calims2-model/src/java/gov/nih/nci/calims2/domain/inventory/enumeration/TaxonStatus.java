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

public enum TaxonStatus  implements I18nEnumeration {



/**
* REQUIRESREPORT status name.
*/
REQUIRESREPORT,
/**
* PRELIMINARY status name.
*/
PRELIMINARY,
/**
* FINAL status name.
*/
FINAL,
/**
* REPLACED status name.
*/
REPLACED;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(gov.nih.nci.calims2.domain.inventory.l10n.TaxonStatusBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {

    return name();
  }
}