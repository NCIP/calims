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

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.domain.report.Report;
import gov.nih.nci.calims2.domain.report.ReportDesign;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;
import gov.nih.nci.calims2.ui.util.QueryServiceMockup;

/**
 * @author connollym
 *
 */
public class ReportControllerTest {
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    ReportController controller = new ReportController();
    CRUDAssert.assertControllerConstructor(controller, ReportController.URL_PREFIX, "report.report.", "name", Report.class,
        ReportForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    ReportController controller = new ReportController();  
    GenericServiceMockup<ReportDesign> reportDesignService = new GenericServiceMockup<ReportDesign>();
    QueryServiceMockup queryService = new QueryServiceMockup();
    controller.setQueryService(queryService);
    controller.setReportDesignService(reportDesignService);
    ModelAndView model = new ModelAndView();
    ReportForm form = new ReportForm();
    model.addObject("form", form);
    ModelAndView result = controller.completeEditModel(model, Locale.US); 
    CRUDAssert.assertFindAll(reportDesignService, ReportDesign.class, "name", "reportDesigns", result);
    CRUDAssert.assertFindAll(queryService, Query.class, "name", "queries", result);
    assertEquals("Wrong model returned", model, result);
  }
}
