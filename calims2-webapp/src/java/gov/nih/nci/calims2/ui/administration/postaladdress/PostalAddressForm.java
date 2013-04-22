/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.postaladdress;

import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.PostalAddress;
import gov.nih.nci.calims2.domain.administration.enumeration.PostalAddressStatus;
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
public class PostalAddressForm extends CRUDForm<PostalAddress> {

  private static final long serialVersionUID = -7308069303305309888L;

  private String status;
  private Long typeId;

  /**
   * Default constructor.
   */
  public PostalAddressForm() {
    setEntity(new PostalAddress());
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public PostalAddress getSubmittedEntity() {
    PostalAddress postalAddress = getEntity();
    StackFrame frame = FlowContextHolder.getContext().peek();
    Class<? extends EntityWithId> persistentClass = (Class<? extends EntityWithId>) frame.getAttribute("persistentClass");
    Long id = (Long) frame.getAttribute("id");
    if (persistentClass == ContactInformation.class) {
      postalAddress.setContactInformation(EntityWithIdHelper.createEntity(ContactInformation.class, id));
    }
    postalAddress.setNotesCollection(getNotesCollection());
    postalAddress.setStatus(I18nEnumerationHelper.getByName(PostalAddressStatus.class, status));
    postalAddress.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return postalAddress;
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
