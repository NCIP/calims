/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.software;

import gov.nih.nci.calims2.domain.administration.Software;
import gov.nih.nci.calims2.domain.administration.enumeration.SoftwareStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class SoftwareForm extends CRUDForm<Software> {

  private static final long serialVersionUID = 344126907101698843L;

  private String status;
  private Long typeId;

  /**
   * Default constructor.
   */
  public SoftwareForm() {
    setEntity(new Software());
  }

  /**
   * {@inheritDoc}
   */
  public Software getSubmittedEntity() {
    Software software = getEntity();
    software.setNotesCollection(getNotesCollection());
    software.setStatus(I18nEnumerationHelper.getByName(SoftwareStatus.class, status));
    software.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return software;
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

}
