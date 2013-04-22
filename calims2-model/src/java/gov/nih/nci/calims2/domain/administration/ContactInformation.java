/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration;
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
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
/**
* NCI|Information regarding the means of contacting a person or group.
**/

@Entity
@Table(name = "CONTACTINFORMATION")

public class ContactInformation extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String emailAddress;
  /** 
* Retrieves the value of the emailAddress attribute.
* @return emailAddress
**/
  
  @Column(name = "EMAILADDRESS", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getEmailAddress() {
  return emailAddress;
  }
  /**
* Sets the value of emailAddress attribute.
* @param emailAddress .
**/
  public void setEmailAddress(String 
  emailAddress) {
  this.emailAddress = emailAddress;
  }
  /**
* 
**/
  private Integer rank;
  /**
* Retrieves the value of the rank attribute.
* @return rank
**/
  
  @Column(name = "RANK", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.ContactInformation.rank}")
  public Integer getRank() {
  return rank;
  }
  /**
* Sets the value of rank attribute.
* @param rank .
**/
  public void setRank(Integer 
  rank) {
  this.rank = rank;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.ContactInformationStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.ContactInformation.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.ContactInformationStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.ContactInformationStatus 
  status) {
  this.status = status;
  }
  /**
* 
**/
  private String URI;
  /**
* Retrieves the value of the URI attribute.
* @return URI
**/
  
  @Column(name = "URI", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getURI() {
  return URI;
  }
  /**
* Sets the value of URI attribute.
* @param URI .
**/
  public void setURI(String 
  URI) {
  this.URI = URI;
  }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Location object.
**/
        private gov.nih.nci.calims2.domain.administration.Location location;
        /**
* Retrieves the value of the location attribute.
* @return location
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LOCATION_FK")
@org.hibernate.annotations.ForeignKey(name = "CONTACLOCATI_FK")

        public gov.nih.nci.calims2.domain.administration.Location getLocation() {
        return location;
        }
   
        /**
* Sets the value of location attribute.
* @param location .
**/
        public void setLocation(gov.nih.nci.calims2.domain.administration.Location location) {
        this.location = location;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Collaboration object.
**/
        private gov.nih.nci.calims2.domain.administration.Collaboration collaboration;
        /**
* Retrieves the value of the collaboration attribute.
* @return collaboration
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "COLLABORATION_FK")
@org.hibernate.annotations.ForeignKey(name = "CONTACCOLLAB_FK")

        public gov.nih.nci.calims2.domain.administration.Collaboration getCollaboration() {
        return collaboration;
        }
   
        /**
* Sets the value of collaboration attribute.
* @param collaboration .
**/
        public void setCollaboration(gov.nih.nci.calims2.domain.administration.Collaboration collaboration) {
        this.collaboration = collaboration;
        }
   
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.PostalAddress object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.PostalAddress> postalAddressCollection = new HashSet<gov.nih.nci.calims2.domain.administration.PostalAddress>();
        /**
* Retrieves the value of the postalAddressCollection attribute.
* @return postalAddressCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "contactInformation")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.administration.PostalAddress> getPostalAddressCollection() {
        return postalAddressCollection;
        }

        /**
* Sets the value of postalAddressCollection attribute.
* @param postalAddressCollection .
**/
        public void setPostalAddressCollection(Set<gov.nih.nci.calims2.domain.administration.PostalAddress> postalAddressCollection) {
        this.postalAddressCollection = postalAddressCollection;
        }
    
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Laboratory object.
**/
        private gov.nih.nci.calims2.domain.administration.Laboratory laboratory;
        /**
* Retrieves the value of the laboratory attribute.
* @return laboratory
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LABORATORY_FK")
@org.hibernate.annotations.ForeignKey(name = "CONTACLABORA_FK")

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
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Organization object.
**/
        private gov.nih.nci.calims2.domain.administration.Organization organization;
        /**
* Retrieves the value of the organization attribute.
* @return organization
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ORGANIZATION_FK")
@org.hibernate.annotations.ForeignKey(name = "CONTACORGANI_FK")

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
* An associated gov.nih.nci.calims2.domain.administration.Person object.
**/
        private gov.nih.nci.calims2.domain.administration.Person person;
        /**
* Retrieves the value of the person attribute.
* @return person
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "CONTACPERSON_FK")

        public gov.nih.nci.calims2.domain.administration.Person getPerson() {
        return person;
        }
   
        /**
* Sets the value of person attribute.
* @param person .
**/
        public void setPerson(gov.nih.nci.calims2.domain.administration.Person person) {
        this.person = person;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.ContactInformation.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "CONTACTYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.administration.TelephoneNumber object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.TelephoneNumber> telephoneNumberCollection = new HashSet<gov.nih.nci.calims2.domain.administration.TelephoneNumber>();
        /**
* Retrieves the value of the telephoneNumberCollection attribute.
* @return telephoneNumberCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "contactInformation")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.administration.TelephoneNumber> getTelephoneNumberCollection() {
        return telephoneNumberCollection;
        }

        /**
* Sets the value of telephoneNumberCollection attribute.
* @param telephoneNumberCollection .
**/
        public void setTelephoneNumberCollection(Set<gov.nih.nci.calims2.domain.administration.TelephoneNumber> telephoneNumberCollection) {
        this.telephoneNumberCollection = telephoneNumberCollection;
        }
    
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_CONTACTINFORMATION",joinColumns=@JoinColumn(name="ID_NOTES_CONTACTINFORMATI"))
        @ForeignKey(name="FK_NOTES_CONTACTINFORMATI")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }







}
