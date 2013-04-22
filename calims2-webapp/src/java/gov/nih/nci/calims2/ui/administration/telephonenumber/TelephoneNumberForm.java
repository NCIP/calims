/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.telephonenumber;

import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.TelephoneNumber;
import gov.nih.nci.calims2.domain.administration.enumeration.TelephoneNumberStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap@moxieinformatics.com
 * 
 */
public class TelephoneNumberForm extends CRUDForm<TelephoneNumber> {

  private static final long serialVersionUID = 933172884902733080L;

  private Long typeId;
  private String status;

  /**
   * Default constructor.
   */
  public TelephoneNumberForm() {
    setEntity(new TelephoneNumber());
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public TelephoneNumber getSubmittedEntity() {
    TelephoneNumber telephoneNumber = getEntity();
    StackFrame frame = FlowContextHolder.getContext().peek();
    Class<? extends EntityWithId> persistentClass = (Class<? extends EntityWithId>) frame.getAttribute("persistentClass");
    Long id = (Long) frame.getAttribute("id");
    if (persistentClass == ContactInformation.class) {
      telephoneNumber.setContactInformation(EntityWithIdHelper.createEntity(ContactInformation.class, id));
    }
    telephoneNumber.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    telephoneNumber.setStatus(I18nEnumerationHelper.getByName(TelephoneNumberStatus.class, status));
    return telephoneNumber;
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
