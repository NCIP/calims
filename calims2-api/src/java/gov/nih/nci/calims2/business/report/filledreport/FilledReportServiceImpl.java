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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.joda.time.DateTime;

import gov.nih.nci.calims2.business.generic.GenericServiceImpl;
import gov.nih.nci.calims2.business.report.query.QueryService;
import gov.nih.nci.calims2.business.storage.StorageService;
import gov.nih.nci.calims2.business.storage.StorageServiceException;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.common.enumeration.DocumentStatus;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.report.FilledReport;
import gov.nih.nci.calims2.domain.report.Report;
import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * @author connollym
 * 
 */
public class FilledReportServiceImpl extends GenericServiceImpl<FilledReport> implements FilledReportService {
  
  private PrivilegeEvaluator privilegeEvaluator;
  private QueryService queryService;
  private StorageService storageService;
  
  /**
   * {@inheritDoc}
   */

  public File generateJasperPrintFile(Long reportId, File dir) throws ReportingException {
    Report report = getGenericDao().findById(Report.class, reportId);
    try {
      File jrxmlFile = storageService.get(report.getReportDesign().getDocument(), dir);
      List<EntityWithId> list = queryService.findByQuery(report.getQuery());
      JRBeanCollectionDataSource dataSource;
      dataSource = new JRBeanCollectionDataSource(list);
      Map<String, Object> parameterMap = new HashMap<String, Object>();
      JasperReport jasperReportFile = JasperCompileManager.compileReport(jrxmlFile.getAbsolutePath());
      File jrprint = File.createTempFile("LPGPRINT", ".jrprint", dir);
      JasperFillManager.fillReportToFile(jasperReportFile, jrprint.getAbsolutePath(), parameterMap, dataSource);
      jrxmlFile.delete();
      return jrprint;
    } catch (StorageServiceException e) {
      throw new ReportingException("Problem saving file in Storage Service.", e);
    } catch (JRException e) {
      throw new ReportingException("Problem compiling Jasper JRXML file in FilledReportService.", e);
    } catch (IOException e) {
      throw new ReportingException("I/O Error in FilledReportService.", e);
    }
  }

  /**
   * {@inheritDoc}
   */
  public File exportJasperReport(Long filledReportId, File dir, FilledReportFormat format) throws ReportingException {

    FilledReport filledReport = findById(FilledReport.class, filledReportId);
    try {
      File jasperPrintFile = storageService.get(filledReport.getDocument(), dir);
      JasperPrint jasperPrint = (JasperPrint) JRLoader.loadObject(jasperPrintFile);
      JRExporter exporter = format.getExporter();
      exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
      File exportedFile = File.createTempFile("PRINTFILE", format.getExtention(), dir);
      exporter.setParameter(JRExporterParameter.OUTPUT_FILE, exportedFile);
      exporter.exportReport();
      return exportedFile;
    } catch (JRException e) {
      throw new ReportingException("Problem exporting JasperReport file in FilledReportService.", e);
    } catch (StorageServiceException e) {
      throw new ReportingException("Problem retrieving JasperReport from StorageService.", e);
    } catch (IOException e) {
      throw new ReportingException("Problem retrieving JasperReport from StorageService.", e);
    }
  }

  /**
   * {@inheritDoc}
   */
  public FilledReport createFilledReport(Long id, File dir) throws ReportingException {
    FilledReport filledReport = new FilledReport();
    Report report = getGenericDao().findById(Report.class, id);
    File jrprint = generateJasperPrintFile(id, dir);
    Document document = new Document();
    document.setStatus(DocumentStatus.CURRENT);
    document.setName(report.getName());
    document.setDisplayName(report.getDisplayName());
    document.setUniversalResourceLocator(jrprint.getAbsolutePath());
    filledReport.setName(report.getName());
    filledReport.setDisplayName(report.getDisplayName());
    filledReport.setDocument(document);
    filledReport.setExecutedBy(privilegeEvaluator.getCurrentUsername());
    filledReport.setExecutionTime(new DateTime());
    filledReport.setReport(report);
    try {
      create(filledReport);
    } catch (ValidationException e) {
      throw new InternalError("This is impossible.");
    }
    return filledReport;
  }

  /**
   * @param privilegeEvaluator the privilegeEvaluator to set
   */
  public void setPrivilegeEvaluator(PrivilegeEvaluator privilegeEvaluator) {
    this.privilegeEvaluator = privilegeEvaluator;
  }
  /**
   * @param queryService the queryService to set
   */
  public void setQueryService(QueryService queryService) {
    this.queryService = queryService;
  }

  /**
   * @param storageService the storageService to set
   */
  public void setStorageService(StorageService storageService) {
    this.storageService = storageService;
  }

}
