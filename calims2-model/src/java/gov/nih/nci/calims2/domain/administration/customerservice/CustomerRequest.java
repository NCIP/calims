/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.customerservice;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.IndexColumn;
import org.joda.time.DateTime;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithExternalId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
/**
* 
**/

@SuppressWarnings("deprecation")
@Entity
@Table(name = "CUSTOMERREQUEST")

public class CustomerRequest extends DisplayableEntity implements  EntityWithExternalId, EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private DateTime completedDate;
  /**
* Retrieves the value of the completedDate attribute.
* @return completedDate
**/
  
  @Column(name = "COMPLETEDDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public DateTime getCompletedDate() {
  return completedDate;
  }
  /**
* Sets the value of completedDate attribute.
* @param completedDate .
**/
  public void setCompletedDate(DateTime 
  completedDate) {
  this.completedDate = completedDate;
  }
  /**
* 
**/
  private DateTime expirationDate;
  /**
* Retrieves the value of the expirationDate attribute.
* @return expirationDate
**/
  
  @Column(name = "EXPIRATIONDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public DateTime getExpirationDate() {
  return expirationDate;
  }
  /**
* Sets the value of expirationDate attribute.
* @param expirationDate .
**/
  public void setExpirationDate(DateTime 
  expirationDate) {
  this.expirationDate = expirationDate;
  }
  /**
* 
**/
  private DateTime laboratoryFinalApproveDate;
  /**
* Retrieves the value of the laboratoryFinalApproveDate attribute.
* @return laboratoryFinalApproveDate
**/
  
  @Column(name = "LABORATORYFINALAPPROVEDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public DateTime getLaboratoryFinalApproveDate() {
  return laboratoryFinalApproveDate;
  }
  /**
* Sets the value of laboratoryFinalApproveDate attribute.
* @param laboratoryFinalApproveDate .
**/
  public void setLaboratoryFinalApproveDate(DateTime 
  laboratoryFinalApproveDate) {
  this.laboratoryFinalApproveDate = laboratoryFinalApproveDate;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.customerservice.enumeration.CustomerRequestStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest.status}")
  public gov.nih.nci.calims2.domain.administration.customerservice.enumeration.CustomerRequestStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.customerservice.enumeration.CustomerRequestStatus 
  status) {
  this.status = status;
  }
  /**
* 
**/
  private DateTime submissionDate;
  /**
* Retrieves the value of the submissionDate attribute.
* @return submissionDate
**/
  
  @Column(name = "SUBMISSIONDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public DateTime getSubmissionDate() {
  return submissionDate;
  }
  /**
* Sets the value of submissionDate attribute.
* @param submissionDate .
**/
  public void setSubmissionDate(DateTime 
  submissionDate) {
  this.submissionDate = submissionDate;
  }
    
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerRequest")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.common.Document> getDocumentCollection() {
        return documentCollection;
        }

        /**
* Sets the value of documentCollection attribute.
* @param documentCollection .
**/
        public void setDocumentCollection(Set<gov.nih.nci.calims2.domain.common.Document> documentCollection) {
        this.documentCollection = documentCollection;
        }
    
    
        /**
* An associated gov.nih.nci.calims2.domain.common.ExternalIdentifier object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> externalIdentifierCollection = new HashSet<gov.nih.nci.calims2.domain.common.ExternalIdentifier>();
        /**
* Retrieves the value of the externalIdentifierCollection attribute.
* @return externalIdentifierCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerRequest")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> getExternalIdentifierCollection() {
        return externalIdentifierCollection;
        }

        /**
* Sets the value of externalIdentifierCollection attribute.
* @param externalIdentifierCollection .
**/
        public void setExternalIdentifierCollection(Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> externalIdentifierCollection) {
        this.externalIdentifierCollection = externalIdentifierCollection;
        }
    
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_CUSTOMERREQUEST",joinColumns=@JoinColumn(name="ID_NOTES_CUSTOMERREQUEST"))
        @ForeignKey(name="FK_NOTES_CUSTOMERREQUEST")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }

   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "CUSTOMTYPE_FK")

        public gov.nih.nci.calims2.domain.common.Type getType() {
        return type;
        }
   
        /**
* Sets the value of type attribute.
* @param type .
**/
        public void setType(gov.nih.nci.calims2.domain.common.Type type) {
        this.type = type;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.Account object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.Account customerAccount;
        /**
* Retrieves the value of the customerAccount attribute.
* @return customerAccount
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ACCOUNT_FK")
@org.hibernate.annotations.ForeignKey(name = "CUSTOMACCOUNT_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.Account getCustomerAccount() {
        return customerAccount;
        }
   
        /**
* Sets the value of customerAccount attribute.
* @param customerAccount .
**/
        public void setCustomerAccount(gov.nih.nci.calims2.domain.administration.customerservice.Account customerAccount) {
        this.customerAccount = customerAccount;
        }
   
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.Service object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.customerservice.Service> serviceCollection = new HashSet<gov.nih.nci.calims2.domain.administration.customerservice.Service>();
        /**
* Retrieves the value of the serviceCollection attribute.
* @return serviceCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerRequest")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.administration.customerservice.Service> getServiceCollection() {
        return serviceCollection;
        }

        /**
* Sets the value of serviceCollection attribute.
* @param serviceCollection .
**/
        public void setServiceCollection(Set<gov.nih.nci.calims2.domain.administration.customerservice.Service> serviceCollection) {
        this.serviceCollection = serviceCollection;
        }
    

        /**
* An associated gov.nih.nci.calims2.domain.administration.Person object.
**/
        private gov.nih.nci.calims2.domain.administration.Person customerName;
        /**
* Retrieves the value of the customerName attribute.
* @return customerName
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "CUSTOMERREQ_PERSON_FK")

        public gov.nih.nci.calims2.domain.administration.Person getCustomerName() {
        return customerName;
        }
   
        /**
* Sets the value of customerName attribute.
* @param customerName .
**/
        public void setCustomerName(gov.nih.nci.calims2.domain.administration.Person customerName) {
        this.customerName = customerName;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation billingInformation;
        /**
* Retrieves the value of the billingInformation attribute.
* @return billingInformation
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "BILLINGINFORMATION_FK")
@org.hibernate.annotations.ForeignKey(name = "CUSTOMBILLIN_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation getBillingInformation() {
        return billingInformation;
        }
   
        /**
* Sets the value of billingInformation attribute.
* @param billingInformation .
**/
        public void setBillingInformation(gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation billingInformation) {
        this.billingInformation = billingInformation;
        }
   






}