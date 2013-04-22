/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.filledreport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import gov.nih.nci.calims2.business.report.filledreport.FilledReportFormat;
import gov.nih.nci.calims2.business.report.filledreport.FilledReportService;
import gov.nih.nci.calims2.business.report.filledreport.ReportingException;
import gov.nih.nci.calims2.domain.report.FilledReport;
import gov.nih.nci.calims2.domain.report.Report;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.util.interceptor.FlowContextInterceptor;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym
 * 
 */
@Controller
@RequestMapping(FilledReportController.URL_PREFIX)
public class FilledReportController extends CRUDController<FilledReport> {

  /** Prefix of urls of this module. */
  public static final String URL_PREFIX = "/report/filledreport";
  private File tempfiledir;

  /**
   * Default constructor.
   */
  public FilledReportController() {
    super(URL_PREFIX, "name");
  }

  /**
   * {@inheritDoc}
   */
  public List<FilledReport> createList() {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("reportId", (FlowContextHolder.getContext().peek()).getAttribute("id"));
    return getMainService().findByNamedQuery(FilledReport.class.getName() + ".findByReportId", params);
  }

  /**
   * 
   * @param response The servlet response.
   * @param id The id of the filledreport to view.
   * @param formatName The format of the pdf file.
   */
  @RequestMapping("/exportReport.do")
  public void exportReport(HttpServletResponse response, @RequestParam("id") Long id, @RequestParam("format") String formatName) {

    FilledReport filledReport = getMainService().findById(FilledReport.class, id);
    Report report = filledReport.getReport();
    FilledReportFormat format = FilledReportFormat.valueOf(formatName);
    try {
      ServletOutputStream servletOutputStream = response.getOutputStream();
      File exportedFile = ((FilledReportService) getMainService()).exportJasperReport(id, tempfiledir, format);
      response.setContentType(format.getContentType());
      DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd-HHmmss");
      String filename = report.getName() + fmt.print(filledReport.getExecutionTime()) + format.getExtention();
      response.setHeader("Content-Disposition", "attachment;filename=" + filename);
      FileInputStream fileInputStream = new FileInputStream(exportedFile);
      IOUtils.copyLarge(fileInputStream, servletOutputStream);
      IOUtils.closeQuietly(fileInputStream);
      servletOutputStream.flush();
      servletOutputStream.close();
      exportedFile.delete();
    } catch (IOException e1) {
      throw new RuntimeException("IOException in exportReport", e1);
    } catch (ReportingException e) {
      throw new RuntimeException("ReportingException in exportReport", e);
    }
  }

  /**
   * @return model The ModelAndView returned.
   */
  @RequestMapping("/runReport.do")
  public ModelAndView runReport() {
    Long id = (Long) (FlowContextHolder.getContext().peek()).getAttribute("id");
    try {
      ((FilledReportService) getMainService()).createFilledReport(id, tempfiledir);
    } catch (ReportingException e) {
      throw new RuntimeException("Reporting exception", e);
    }
    ModelAndView model = new ModelAndView();
    CRUDControllerConfig config = getConfig();
    model.setView(new RedirectView(config.getForwardUrl(config.getListCommand()), true));
    model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.setPersistAttributeForClient(this));
    return model;
  }

  /**
   * 
   * @param id The id of report.
   * @param locale The current locale.
   * @return model The ModelAndView.
   */
  @RequestMapping("/selectFormatToViewReport.do")
  public ModelAndView selectFormatToViewReport(@RequestParam("id") Long id, Locale locale) {
    ModelAndView model = new ModelAndView();
    model.addObject("config", getConfig());
    model.addObject("id", id);
    model.addObject(FlowContextInterceptor.CONTEXT_PARAM, FlowContextHolder.getSerializedContext());
    model.addObject("formats", I18nEnumerationHelper.getLocalizedValues(FilledReportFormat.class, locale));
    model.setViewName(getConfig().getFullViewName("selectFormat"));
    return model;
  }

  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "filledReportTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

  /**
   * @param tempfiledir the tempfiledir to set
   */
  @Resource(name = "tempfiledir")
  public void setTempfiledir(String tempfiledir) {
    this.tempfiledir = new File(tempfiledir);
  }

  /**
   * @param filledReportService the filledReportService to set
   */
  @Resource(name = "filledReportService")
  public void setFilledReportService(FilledReportService filledReportService) {
    setMainService(filledReportService);
  }
}
