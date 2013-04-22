/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.filledreport;

import java.io.File;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.report.FilledReport;

/**
 * @author connollym
 *
 */
public interface FilledReportService extends GenericService<FilledReport> {
  /**
   * 
   * @param reportId The id of the report.  
   * @param dir The location of the report.
   * @return file The executed report.
   * @throws ReportingException In case of error.
   */
  File generateJasperPrintFile(Long reportId, File dir) throws ReportingException;
  /**
   * 
   * @param filledReportId The id of the filled report.
   * @param dir The temporary folder of the file.
   * @param format The format for exporting to.
   * @return file The exported jasper report.
   * @throws ReportingException In case of error.
   */
  File exportJasperReport(Long filledReportId, File dir, FilledReportFormat format) throws ReportingException;

  /**
   * 
   * @param reportId The id of the report.
   * @param dir The temporary folder of the file.
   * @return filledReport The newly created FilledReport
   * @throws ReportingException In case of error.
   */
  FilledReport createFilledReport(Long reportId, File dir) throws ReportingException;
}
