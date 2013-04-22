/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.contactinformation;

import gov.nih.nci.calims2.domain.administration.Collaboration;
import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.enumeration.ContactInformationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class ContactInformationForm extends CRUDForm<ContactInformation> {

  private static final long serialVersionUID = -1340498604499121189L;

  private Long typeId;
  private String status;

  /**
   * Default constructor.
   */
  public ContactInformationForm() {
    setEntity(new ContactInformation());
  }

  /**
   * @return the contactInforamtion
   */
  @SuppressWarnings("unchecked")
  public ContactInformation getSubmittedEntity() {
    ContactInformation contactInformation = getEntity();
    StackFrame frame = FlowContextHolder.getContext().peek();
    Class<? extends EntityWithId> persistentClass = (Class<? extends EntityWithId>) frame.getAttribute("persistentClass");
    Long id = (Long) frame.getAttribute("id");

    if (persistentClass == Person.class) {
      contactInformation.setPerson(EntityWithIdHelper.createEntity(Person.class, id));
    }
    if (persistentClass == Organization.class) {
      contactInformation.setOrganization(EntityWithIdHelper.createEntity(Organization.class, id));
    }
    if (persistentClass == Laboratory.class) {
      contactInformation.setLaboratory(EntityWithIdHelper.createEntity(Laboratory.class, id));
    }
    if (persistentClass == Location.class) {
      contactInformation.setLocation(EntityWithIdHelper.createEntity(Location.class, id));
    }
    if (persistentClass == Collaboration.class) {
      contactInformation.setCollaboration(EntityWithIdHelper.createEntity(Collaboration.class, id));
    }
    contactInformation.setNotesCollection(getNotesCollection());
    contactInformation.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    contactInformation.setStatus(I18nEnumerationHelper.getByName(ContactInformationStatus.class, status));
    return contactInformation;
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
}
