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

import java.util.Locale;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;

import gov.nih.nci.calims2.business.report.filledreport.l10n.FilledReportFormatBundle;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration;

/**
 * @author connollym
 *
 */
public enum FilledReportFormat implements I18nEnumeration {
  /** HTML Format. */
  CSV("text/plain", JRCsvExporter.class, ".csv"),
  
  /** HTML Format. */
  HTML("text/html", JRHtmlExporter.class, ".html"),
  
  /** PDF Format. */
  ODT("application/vnd.oasis.opendocument.text", JROdtExporter.class, ".ods"),
  
  /** PDF Format. */
  PDF("application/pdf", JRPdfExporter.class, ".pdf"),
  
  /** RTF Format. */
  RTF("application/rtf", JRRtfExporter.class, ".rtf");
  
  private String contentType;
  
  private Class<? extends JRExporter> exporterClass;
  
  private String extention;
  
  private FilledReportFormat(String contentType, Class<? extends JRExporter> exporterClass, String extention) {
    this.contentType = contentType;
    this.exporterClass = exporterClass;
    this.extention = extention;
  }
  
  /**
   * {@inheritDoc}
   */
 
  public String getLocalizedValue(Locale locale) {
    return I18nEnumerationHelper.getLocalizedValue(FilledReportFormatBundle.class, locale, this);
  }

  /**
   * {@inheritDoc}
   */
  public String getName() {
    return name();
  }

  /**
   * @return the contentType
   */
  public String getContentType() {
    return contentType;
  }

  /**
   * @return the exporterClass
   */
  public Class<? extends JRExporter> getExporterClass() {
    return exporterClass;
  }
  /**
   * 
   * @return new Exporter for this format.
   */
  public JRExporter getExporter() {
    try {
      return exporterClass.newInstance();
    } catch (InstantiationException e) {
      throw new InternalError("Cannot happen.");
    } catch (IllegalAccessException e) {
      throw new InternalError("Cannot happen.");
    }
  }

  /**
   * @return the extention
   */
  public String getExtention() {
    return extention;
  }

}
