/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.workflow.project;

import gov.nih.nci.calims2.domain.workflow.Project;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;

/**
 * @author connollym
 *
 */
public class ProjectForm extends CRUDForm<Project> {

  private static final long serialVersionUID = -5040776685758770632L;
  
  private Long[] approvalIds;
  private Long[] collaborationIds;
  private Long[] equipmentIds;
  private Long[] laboratoryIds;
  private Long[] labSupplyIds;
  private Long[] methodIds;
  private Long[] organizationIds;
  private Long[] personIds;
  private Long[] reportIds;
  private Long[] softwareIds;
  private Long[] specimenIds;
  private Long[] worksheetIds;
  
  private Long typeId;
  
  
  private String status;

  /**
   * Default constructor.
   */
  public ProjectForm() {
    setEntity(new Project());
  }

  /**
   * {@inheritDoc}
   */
  public Project getSubmittedEntity() {
    Project project = getEntity();
//    project.setApprovalCollection(EntityWithIdHelper.createEntities(Approval.class, approvalIds));
//    project.setCollaborationCollection(EntityWithIdHelper.createEntities(Collaboration.class, collaborationIds));
//    project.setEquipmentCollection(EntityWithIdHelper.createEntities(Equipment.class, equipmentIds));
//    project.setLaboratoryCollection(EntityWithIdHelper.createEntities(Laboratory.class, laboratoryIds));
//    project.setLabSupplyCollection(EntityWithIdHelper.createEntities(LabSupply.class, labSupplyIds));
//    project.setMethodCollection(EntityWithIdHelper.createEntities(Method.class, methodIds));
//    project.setOrganizationCollection(EntityWithIdHelper.createEntities(Organization.class, organizationIds));
//    project.setPersonCollection(EntityWithIdHelper.createEntities(Person.class, personIds));
//    project.setReportCollection(EntityWithIdHelper.createEntities(Report.class, reportIds));
//    project.setSoftwareCollection(EntityWithIdHelper.createEntities(Software.class, softwareIds));
//    project.setSpecimenCollection(EntityWithIdHelper.createEntities(Specimen.class, specimenIds));  
//    project.setWorksheetCollection(EntityWithIdHelper.createEntities(Worksheet.class, worksheetIds)); 
//    project.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
//    project.setStatus(I18nEnumerationHelper.getByName(ProjectStatus.class, status));
    return project;
  }

  /**
   * @return the approvalIds
   */
  public Long[] getApprovalIds() {
    return approvalIds;
  }

  /**
   * @param approvalIds the approvalIds to set
   */
  public void setApprovalIds(Long[] approvalIds) {
    this.approvalIds = approvalIds;
  }

  /**
   * @return the equipmentIds
   */
  public Long[] getEquipmentIds() {
    return equipmentIds;
  }

  /**
   * @param equipmentIds the equipmentIds to set
   */
  public void setEquipmentIds(Long[] equipmentIds) {
    this.equipmentIds = equipmentIds;
  }

  /**
   * @return the laboratoryIds
   */
  public Long[] getLaboratoryIds() {
    return laboratoryIds;
  }

  /**
   * @param laboratoryIds the laboratoryIds to set
   */
  public void setLaboratoryIds(Long[] laboratoryIds) {
    this.laboratoryIds = laboratoryIds;
  }

  /**
   * @return the methodIds
   */
  public Long[] getMethodIds() {
    return methodIds;
  }

  /**
   * @param methodIds the methodIds to set
   */
  public void setMethodIds(Long[] methodIds) {
    this.methodIds = methodIds;
  }

  /**
   * @return the reportIds
   */
  public Long[] getReportIds() {
    return reportIds;
  }

  /**
   * @param reportIds the reportIds to set
   */
  public void setReportIds(Long[] reportIds) {
    this.reportIds = reportIds;
  }

  /**
   * @return the softwareIds
   */
  public Long[] getSoftwareIds() {
    return softwareIds;
  }

  /**
   * @param softwareIds the softwareIds to set
   */
  public void setSoftwareIds(Long[] softwareIds) {
    this.softwareIds = softwareIds;
  }

  /**
   * @return the specimenIds
   */
  public Long[] getSpecimenIds() {
    return specimenIds;
  }

  /**
   * @param specimenIds the specimenIds to set
   */
  public void setSpecimenIds(Long[] specimenIds) {
    this.specimenIds = specimenIds;
  }

  /**
   * @return the typeId
   */
  public Long getTypeId() {
    return typeId;
  }

  /**
   * @param typeId the typeId to set
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * @return the collaborationIds
   */
  public Long[] getCollaborationIds() {
    return collaborationIds;
  }

  /**
   * @param collaborationIds the collaborationIds to set
   */
  public void setCollaborationIds(Long[] collaborationIds) {
    this.collaborationIds = collaborationIds;
  }

  /**
   * @param worksheetIds the worksheetIds to set
   */
  public void setWorksheetIds(Long[] worksheetIds) {
    this.worksheetIds = worksheetIds;
  }

  /**
   * @return the personIds
   */
  public Long[] getPersonIds() {
    return personIds;
  }

  /**
   * @param personIds the personIds to set
   */
  public void setPersonIds(Long[] personIds) {
    this.personIds = personIds;
  }

  /**
   * @return the labSupplyIds
   */
  public Long[] getLabSupplyIds() {
    return labSupplyIds;
  }

  /**
   * @param labSupplyIds the labSupplyIds to set
   */
  public void setLabSupplyIds(Long[] labSupplyIds) {
    this.labSupplyIds = labSupplyIds;
  }

  /**
   * @return the organizationIds
   */
  public Long[] getOrganizationIds() {
    return organizationIds;
  }

  /**
   * @param organizationIds the organizationIds to set
   */
  public void setOrganizationIds(Long[] organizationIds) {
    this.organizationIds = organizationIds;
  }
}
