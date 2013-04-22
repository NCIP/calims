/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.l10n;

import java.util.ListResourceBundle;

import gov.nih.nci.calims2.ui.report.query.LogicalConnector;

/**
 * @author viseem
 *
 */
public class LogicalConnectorBundle extends ListResourceBundle {

  private static final Object[][] CONTENTS = {
    {LogicalConnector.AND.name(), "And"},
    {LogicalConnector.OR.name(), "Or"}
  };

  /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }
}
