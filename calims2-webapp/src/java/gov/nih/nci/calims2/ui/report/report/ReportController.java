/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.report;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.report.query.QueryService;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.domain.report.Report;
import gov.nih.nci.calims2.domain.report.ReportDesign;
import gov.nih.nci.calims2.ui.generic.crud.CRUDController;
import gov.nih.nci.calims2.ui.generic.crud.CRUDControllerConfig;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Table;

/**
 * @author connollym
 *
 */
@Controller
@RequestMapping(ReportController.URL_PREFIX)
public class ReportController extends CRUDController<Report> {
  
  /** Prefix of urls of this module. */
  public static final String URL_PREFIX = "/report/report";
  /** Create query subflow id.   */
  static final int QUERY_SUBFLOW_ID = 0;
  /** Create reportDesign subflow id.   */
  static final int REPORTDESIGN_SUBFLOW_ID = 1;
  
  private QueryService queryService;
  private GenericService<ReportDesign> reportDesignService;
 

  /**
   * Default constructor.
   */
  public ReportController() {
    super(URL_PREFIX, "name");
    CRUDControllerConfig config = getConfig();
    config.setSubFlowUrls(new String[] {"/report/query/create.do",
                                        "/report/reportdesign/create.do",
                                        "/report/filledreport/enterList.do"});
  }

  /**
   * {@inheritDoc}
   */
  public ModelAndView completeEditModel(ModelAndView model, Locale locale) {

    List<Query> queries = queryService.findAll(Query.class, "name");
    model.addObject("queries", queries);
    List<ReportDesign> reportDesigns = reportDesignService.findAll(ReportDesign.class, "name");
    model.addObject("reportDesigns", reportDesigns);
    return model;
  }

  /**
   * Saves an entity and returns a refreshed list type page.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param locale The current locale.
   * @return The list view.
   */
  @RequestMapping(CRUDControllerConfig.STD_SAVE_COMMAND)
  public ModelAndView save(@ModelAttribute("form") ReportForm form, Locale locale) {
    return doSave(form, locale);
  }
  
  /**
   * Calls a subflow.
   * 
   * @param form The object containing the values of the entity to be saved.
   * @param subFlowId The id of the flow to call in the subFlowUrls array.
   * @return The next view to go to. It is a forward to the entry action of the subflow.
   */
  @RequestMapping(CRUDControllerConfig.STD_CALL_COMMAND)
  public ModelAndView call(@ModelAttribute("form") ReportForm form, @RequestParam("subFlowId") int subFlowId) {
    return super.doCall(form, subFlowId);
  }

  /**
   * {@inheritDoc}
   */
  public void doReturnFromFlow(ModelAndView model, int subFlowId, Long entityId) {
    if (entityId != null) {
      Report report = ((ReportForm) model.getModel().get("form")).getEntity();
      switch (subFlowId) {
        case QUERY_SUBFLOW_ID: {
          report.setQuery(EntityWithIdHelper.createEntity(Query.class, entityId));
          break;
        }
        case REPORTDESIGN_SUBFLOW_ID: {
          report.setReportDesign(EntityWithIdHelper.createEntity(ReportDesign.class, entityId));
          break;
        }
        default: {
          throw new IllegalArgumentException("Wrong subFlowId");
        }
      }
    }
  }
 
  /**
   * @param reportService the reportService to set
   */
  @Resource(name = "reportService")
  public void setMainService(GenericService<Report> reportService) {
    super.setMainService(reportService);
  }
  
  /**
   * @param queryService the queryService to set
   */
  @Resource(name = "queryService")
  public void setQueryService(QueryService queryService) {
    this.queryService = queryService;
  }
  /**
   * @param reportDesign the reportDesignService to set
   */
  @Resource(name = "reportDesignService")
  public void setReportDesignService(GenericService<ReportDesign> reportDesign) {
    reportDesignService = reportDesign;
  }
  
  /**
   * @param formDecorator the formDecorator to set
   */
  @Resource(name = "reportFormDecorator")
  public void setFormDecorator(CRUDFormDecorator formDecorator) {
    super.setFormDecorator(formDecorator);
  }
  
  /**
   * @param listTable the listTable to set
   */
  @Resource(name = "reportTable")
  public void setListTable(Table listTable) {
    super.setListTable(listTable);
  }

}
