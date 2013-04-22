/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.reportdesign;

import org.springframework.web.multipart.MultipartFile;

import gov.nih.nci.calims2.domain.report.ReportDesign;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.ui.report.query.QueriedEntity;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym
 *
 */
public class ReportDesignForm extends CRUDForm<ReportDesign> {

  private static final long serialVersionUID = -6010765931860899363L;

  private String mainEntity;
  private QueriedEntity queriedEntity;
  private MultipartFile fileData;
 
 
  /**
   * Default constructor.
   */
  public ReportDesignForm() {
    setEntity(new ReportDesign());
  }

  /**
   * {@inheritDoc}
   */
  public ReportDesign getSubmittedEntity() {
    ReportDesign reportDesign = getEntity();
    reportDesign.setMainEntity(I18nEnumerationHelper.getByName(QueriedEntity.class, mainEntity).getPersistentClass().getName());
    return reportDesign;
  }

  /**
   * @return the mainEntity
   */
  public String getMainEntity() {
    return mainEntity;
  }

  /**
   * @param mainEntity the mainEntity to set
   */
  public void setMainEntity(String mainEntity) {
    this.mainEntity = mainEntity;
  }

  /**
   * @return the queriedEntity
   */
  public QueriedEntity getQueriedEntity() {
    return queriedEntity;
  }

  /**
   * @param queriedEntity the queriedEntity to set
   */
  public void setQueriedEntity(QueriedEntity queriedEntity) {
    this.queriedEntity = queriedEntity;
  }

  /**
   * @return the fileData
   */
  public MultipartFile getFileData() {
    return fileData;
  }

  /**
   * @param fileData the fileData to set
   */
  public void setFileData(MultipartFile fileData) {
    this.fileData = fileData;
  }

}
