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

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.domain.report.Report;
import gov.nih.nci.calims2.domain.report.ReportDesign;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;

/**
 * @author connollym
 *
 */
public class ReportFormTest {

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    ReportForm form = new ReportForm();

    form.setQueryId(1L);
    form.setReportDesignId(1L);
    

    Report entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Query.class, entity.getQuery(), 1L);
    CRUDFormAssert.assertEntity(ReportDesign.class, entity.getReportDesign(), 1L);
    
  }
  }
