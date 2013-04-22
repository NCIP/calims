/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.common.externalidentifier;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.common.ExternalIdentifier;
import gov.nih.nci.calims2.domain.common.enumeration.ExternalIdentifierStatus;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.LabSupply;
import gov.nih.nci.calims2.domain.inventory.Sequence;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 *
 */
public class ExternalIdentifierForm extends CRUDForm<ExternalIdentifier> {

  private static final long serialVersionUID = 8325671899179660244L;

  private String source;
  private String value;
  private String status;

  /**
   * Default constructor.
   */
  public ExternalIdentifierForm() {
    setEntity(new ExternalIdentifier());
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public ExternalIdentifier getSubmittedEntity() {
    ExternalIdentifier externalIdentifier = getEntity();
    StackFrame frame = FlowContextHolder.getContext().peek();
    Class<? extends EntityWithId> persistentClass = (Class<? extends EntityWithId>) 
                                                                 frame.getAttribute("persistentClass");
    Long id = (Long) frame.getAttribute("id");
    if (persistentClass == Person.class) {
      externalIdentifier.setPerson(EntityWithIdHelper.createEntity(Person.class, id));
    }
    if (persistentClass == LabSupply.class) {
      externalIdentifier.setLabSupply(EntityWithIdHelper.createEntity(LabSupply.class, id));
    }
    if (persistentClass == Account.class) {
      externalIdentifier.setAccount(EntityWithIdHelper.createEntity(Account.class, id));
    }
    if (persistentClass == CustomerRequest.class) {
      externalIdentifier.setCustomerRequest(EntityWithIdHelper.createEntity(CustomerRequest.class, id));
    }
    if (persistentClass == Sequence.class) {
      externalIdentifier.setSequence(EntityWithIdHelper.createEntity(Sequence.class, id));
    }
    if (Specimen.class.isAssignableFrom(persistentClass)) {
      externalIdentifier.setSpecimen(EntityWithIdHelper.createEntity(Specimen.class, id));
    }
    externalIdentifier.setStatus(I18nEnumerationHelper.getByName(ExternalIdentifierStatus.class, status));
    return externalIdentifier;
  }

  /**
   * @param source the source to set
   */
  public void setSource(String source) {
    this.source = source;
  }

  /**
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * @param value the value to set
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return value;
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