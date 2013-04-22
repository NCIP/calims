/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.common.document;

/**
 * @author connollym
 *
 */

import org.springframework.web.multipart.MultipartFile;

import gov.nih.nci.calims2.domain.administration.Collaboration;
import gov.nih.nci.calims2.domain.administration.Equipment;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.StorageDevice;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.Contract;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.Invoice;
import gov.nih.nci.calims2.domain.administration.customerservice.Quotation;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.common.enumeration.DocumentStatus;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.domain.workflow.Project;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author katariap
 * 
 */
public class DocumentForm extends CRUDForm<Document> {

  private static final long serialVersionUID = -931916159562506663L;

  private MultipartFile fileData;
  private String status;

  /**
   * Default constructor.
   */
  public DocumentForm() {
    setEntity(new Document());
  }

  /**
   * {@inheritDoc}
   */
  @SuppressWarnings("unchecked")
  public Document getSubmittedEntity() {
    Document document = getEntity();
    StackFrame frame = FlowContextHolder.getContext().peek();
    Class<? extends EntityWithId> persistentClass = (Class<? extends EntityWithId>) frame.getAttribute("persistentClass");
    Long id = (Long) frame.getAttribute("id");
    if (Specimen.class.isAssignableFrom(persistentClass)) {
      document.setSpecimen(EntityWithIdHelper.createEntity((Class<? extends Specimen>)persistentClass, id));
    }
    if (persistentClass == Account.class) {
      document.setAccount(EntityWithIdHelper.createEntity(Account.class, id));
    }
    if (persistentClass == Collaboration.class) {
      document.setCollaboration(EntityWithIdHelper.createEntity(Collaboration.class, id));
    }
    if (persistentClass == Contract.class) {
      document.setContract(EntityWithIdHelper.createEntity(Contract.class, id));
    }
    if (persistentClass == CustomerRequest.class) {
      document.setCustomerRequest(EntityWithIdHelper.createEntity(CustomerRequest.class, id));
    }
    if (persistentClass == Equipment.class) {
      document.setEquipment(EntityWithIdHelper.createEntity(Equipment.class, id));
    }
    if (persistentClass == StorageDevice.class) {
      document.setEquipment(EntityWithIdHelper.createEntity(StorageDevice.class, id));
    }
    if (persistentClass == Invoice.class) {
      document.setInvoice(EntityWithIdHelper.createEntity(Invoice.class, id));
    }
    if (persistentClass == Location.class) {
      document.setLocation(EntityWithIdHelper.createEntity(Location.class, id));
    }
    if (persistentClass == NamingConvention.class) {
      document.setNamingConvention(EntityWithIdHelper.createEntity(NamingConvention.class, id));
    }
    if (persistentClass == Organization.class) {
      document.setOrganization(EntityWithIdHelper.createEntity(Organization.class, id));
    }
    if (persistentClass == Person.class) {
      document.setPerson(EntityWithIdHelper.createEntity(Person.class, id));
    }
    if (persistentClass == Project.class) {
      document.setProject(EntityWithIdHelper.createEntity(Project.class, id));
    }
    if (persistentClass == Quotation.class) {
      document.setQuotation(EntityWithIdHelper.createEntity(Quotation.class, id));
    }
    if (persistentClass == Service.class) {
      document.setService(EntityWithIdHelper.createEntity(Service.class, id));
    }
    document.setStatus(I18nEnumerationHelper.getByName(DocumentStatus.class, status));
    return document;
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
