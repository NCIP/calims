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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.IndexColumn;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithExternalId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
/**
* 
**/

@SuppressWarnings("deprecation")
@Entity
@Table(name = "ACCOUNT")

public class Account extends DisplayableEntity implements  EntityWithExternalId, EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private org.joda.time.DateTime endDate;
  /**
* Retrieves the value of the endDate attribute.
* @return endDate
**/
  
  @Column(name = "ENDDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.Account.endDate}")
  public org.joda.time.DateTime getEndDate() {
  return endDate;
  }
  /**
* Sets the value of endDate attribute.
* @param endDate .
**/
  public void setEndDate(org.joda.time.DateTime 
  endDate) {
  this.endDate = endDate;
  }
  /**
* 
**/
  private org.joda.time.DateTime startDate;
  /**
* Retrieves the value of the startDate attribute.
* @return startDate
**/
  
  @Column(name = "STARTDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.Account.startDate}")
  public org.joda.time.DateTime getStartDate() {
  return startDate;
  }
  /**
* Sets the value of startDate attribute.
* @param startDate .
**/
  public void setStartDate(org.joda.time.DateTime 
  startDate) {
  this.startDate = startDate;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.Account.status}")
  public gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountStatus 
  status) {
  this.status = status;
  }
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_ACCOUNT",joinColumns=@JoinColumn(name="ID_NOTES_ACCOUNT"))
        @ForeignKey(name="FK_NOTES_ACCOUNT")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }

    
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber> accountNumberCollection = new HashSet<gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber>();
        /**
* Retrieves the value of the accountNumberCollection attribute.
* @return accountNumberCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber> getAccountNumberCollection() {
        return accountNumberCollection;
        }

        /**
* Sets the value of accountNumberCollection attribute.
* @param accountNumberCollection .
**/
        public void setAccountNumberCollection(Set<gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber> accountNumberCollection) {
        this.accountNumberCollection = accountNumberCollection;
        }
    
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Organization object.
**/
        private gov.nih.nci.calims2.domain.administration.Organization organization;
        /**
* Retrieves the value of the organization attribute.
* @return organization
**/
        @NotNull(message = "{Pattern.gov.nih.nci.calims2.domain.administration.customerservice.Account.organization}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ORGANIZATION_FK")
@org.hibernate.annotations.ForeignKey(name = "ACCOUNORGANI_FK")

        public gov.nih.nci.calims2.domain.administration.Organization getOrganization() {
        return organization;
        }
   
        /**
* Sets the value of organization attribute.
* @param organization .
**/
        public void setOrganization(gov.nih.nci.calims2.domain.administration.Organization organization) {
        this.organization = organization;
        }
   
    
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
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
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.Account.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "ACCOUNTYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.common.ExternalIdentifier object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> externalIdentifierCollection = new HashSet<gov.nih.nci.calims2.domain.common.ExternalIdentifier>();
        /**
* Retrieves the value of the externalIdentifierCollection attribute.
* @return externalIdentifierCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
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
    
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Laboratory object.
**/
        private gov.nih.nci.calims2.domain.administration.Laboratory laboratory;
        /**
* Retrieves the value of the laboratory attribute.
* @return laboratory
**/
        @NotNull(message = "{Pattern.gov.nih.nci.calims2.domain.administration.customerservice.Account.laboratory}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LABORATORY_FK")
@org.hibernate.annotations.ForeignKey(name = "ACCOUNLABORA_FK")

        public gov.nih.nci.calims2.domain.administration.Laboratory getLaboratory() {
        return laboratory;
        }
   
        /**
* Sets the value of laboratory attribute.
* @param laboratory .
**/
        public void setLaboratory(gov.nih.nci.calims2.domain.administration.Laboratory laboratory) {
        this.laboratory = laboratory;
        }
   






}
