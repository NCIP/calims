/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.filledreport.l10n;

import java.util.ListResourceBundle;

import gov.nih.nci.calims2.business.report.filledreport.FilledReportFormat;



/**
 * @author connollym
 *
 */
public class FilledReportFormatBundle extends ListResourceBundle {

  private static final Object[][] CONTENTS = {
    {FilledReportFormat.CSV.name(), "Comma Seperated File (CSV)"},
    {FilledReportFormat.HTML.name(), "Hypertext Markup Language (HTML)"},
    {FilledReportFormat.ODT.name(), "Open Docucument (ODT)"},
    {FilledReportFormat.PDF.name(), "Portable Document Format (PDF)"},
    {FilledReportFormat.RTF.name(), "Rich Text Format (RTF)"}
  };

  /**
   * {@inheritDoc}
   */
  protected Object[][] getContents() {
    return CONTENTS;
  }

}
