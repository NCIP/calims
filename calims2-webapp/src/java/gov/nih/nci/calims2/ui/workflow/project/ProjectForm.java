/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The calims2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This calims2 Software License (the License) is between NCI and You. You (or 
 * Your) shall mean a person or an entity, and all other entities that control, 
 * are controlled by, or are under common control with the entity. Control for 
 * purposes of this definition means (i) the direct or indirect power to cause 
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares, 
 * or (iii) beneficial ownership of such entity. 
 *
 * This License is granted provided that You agree to the conditions described 
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up, 
 * no-charge, irrevocable, transferable and royalty-free right and license in 
 * its rights in the calims2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the calims2 Software; (ii) distribute and 
 * have distributed to and by third parties the calims2 Software and any 
 * modifications and derivative works thereof; and (iii) sublicense the 
 * foregoing rights set out in (i) and (ii) to third parties, including the 
 * right to license such rights to further third parties. For sake of clarity, 
 * and not by way of limitation, NCI shall have no right of accounting or right 
 * of payment from You or Your sub-licensees for the rights granted under this 
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the 
 * above copyright notice, this list of conditions and the disclaimer and 
 * limitation of liability of Article 6, below. Your redistributions in object 
 * code form must reproduce the above copyright notice, this list of conditions 
 * and the disclaimer of Article 6 in the documentation and/or other materials 
 * provided with the distribution, if any. 
 *
 * Your end-user documentation included with the redistribution, if any, must 
 * include the following acknowledgment: This product includes software 
 * developed by Moxie Informatics and the National Cancer Institute. If You do not include 
 * such end-user documentation, You shall include this acknowledgment in the 
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "Moxie Informatics" 
 * to endorse or promote products derived from this Software. This License does 
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or Moxie Informatics, except as required to comply with the 
 * terms of this License. 
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this 
 * Software into Your proprietary programs and into any third party proprietary 
 * programs. However, if You incorporate the Software into third party 
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software 
 * into such third party proprietary programs and for informing Your 
 * sub-licensees, including without limitation Your end-users, of their 
 * obligation to secure any required permissions from such third parties before 
 * incorporating the Software into such third party proprietary software 
 * programs. In the event that You fail to obtain such permissions, You agree 
 * to indemnify NCI for any claims against NCI by such third parties, except to 
 * the extent prohibited by law, resulting from Your failure to obtain such 
 * permissions. 
 *
 * For sake of clarity, and not by way of limitation, You may add Your own 
 * copyright statement to Your modifications and to the derivative works, and 
 * You may provide additional or different license terms and conditions in Your 
 * sublicenses of modifications of the Software, or any derivative works of the 
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, 
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, 
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO 
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, MOXIE INFORMATICS OR THEIR 
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
