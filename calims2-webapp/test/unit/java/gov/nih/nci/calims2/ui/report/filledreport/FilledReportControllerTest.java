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

import org.junit.Test;

import gov.nih.nci.calims2.domain.report.FilledReport;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;

/**
 * @author connollym
 *
 */
public class FilledReportControllerTest {
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    FilledReportController controller = new FilledReportController();
    CRUDAssert.assertControllerConstructor(controller, FilledReportController.URL_PREFIX, "report.filledreport.", "name", 
        FilledReport.class, FilledReportForm.class, CRUDTableDecorator.class);
  }
}

