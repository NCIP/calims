/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.generic;

import gov.nih.nci.calims2.business.generic.l10n.GenericViolationBundle;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

import java.util.Locale;

/**
 * Enum of Validation violations for a Generic bean service.
 * 
 * @author connollym@moxieinformatics.com
 */

public enum GenericViolation implements I18nEnumeration {

  /**
   * Original Record was not found.
   */
  ORIGINAL_NOT_FOUND;
  /**
   * {@inheritDoc}
   */
  public String getName() {
    return name();
  }

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(GenericViolationBundle.class, locale, this);
  }
}
