/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.namingconvention;

import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
public class NamingConventionForm extends CRUDForm<NamingConvention> {

  private static final long serialVersionUID = -7729752436452756003L;

  private Long laboratoryId;
  private Long personId;
  private String status;
  private String type;

  /**
   * Default constructor.
   */
  public NamingConventionForm() {
    setEntity(new NamingConvention());
  }

  /**
   * @return the namingConvention
   */
  public NamingConvention getSubmittedEntity() {
    NamingConvention namingConvention = getEntity();
    namingConvention.setLaboratory(EntityWithIdHelper.createEntity(Laboratory.class, laboratoryId));
    namingConvention.setContactPerson(EntityWithIdHelper.createEntity(Person.class, personId));
    namingConvention.setType(I18nEnumerationHelper.getByName(NamingConventionType.class, type));
    namingConvention.setStatus(I18nEnumerationHelper.getByName(NamingConventionStatus.class, status));
    return namingConvention;
  }

  /**
   * @return the laboratoryId
   */
  public Long getLaboratoryId() {
    return laboratoryId;
  }

  /**
   * @param laboratoryId the laboratoryId to set
   */
  public void setLaboratoryId(Long laboratoryId) {
    this.laboratoryId = laboratoryId;
  }

  /**
   * @return the personId
   */
  public Long getPersonId() {
    return personId;
  }

  /**
   * @param personId the personId to set
   */
  public void setPersonId(Long personId) {
    this.personId = personId;
  }

  /**
   * @return the status   */
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
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }
}
