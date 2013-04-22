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

import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.domain.report.Report;
import gov.nih.nci.calims2.domain.report.ReportDesign;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;

/**
 * @author connollym
 *
 */
public class ReportForm extends CRUDForm<Report> {

  private static final long serialVersionUID = -6010765931860899363L;

  private Long reportDesignId;
  private Long queryId;
  /**
   * Default constructor.
   */
  public ReportForm() {
    setEntity(new Report());
  }

  /**
   * {@inheritDoc}
   */
  public Report getSubmittedEntity() {
    Report report = getEntity();
    report.setReportDesign(EntityWithIdHelper.createEntity(ReportDesign.class, reportDesignId));
    report.setQuery(EntityWithIdHelper.createEntity(Query.class, queryId));
    return report;
  }

  /**
   * @return the reportDesignId
   */
  public Long getReportDesignId() {
    return reportDesignId;
  }

  /**
   * @param reportDesignId the reportDesignId to set
   */
  public void setReportDesignId(Long reportDesignId) {
    this.reportDesignId = reportDesignId;
  }

  /**
   * @return the queryId
   */
  public Long getQueryId() {
    return queryId;
  }

  /**
   * @param queryId the queryId to set
   */
  public void setQueryId(Long queryId) {
    this.queryId = queryId;
  }

}
