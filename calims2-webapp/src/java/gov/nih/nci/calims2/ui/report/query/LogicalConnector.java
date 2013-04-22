/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.query;

import java.util.Locale;

import gov.nih.nci.calims2.ui.report.l10n.LogicalConnectorBundle;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author viseem
 *
 */
public enum LogicalConnector implements I18nEnumeration {
  /** AND operator. */
  AND,
  /** OR operator. */
  OR;

  /**
   * {@inheritDoc}
   */
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(LogicalConnectorBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {
    return name();
  }

}
