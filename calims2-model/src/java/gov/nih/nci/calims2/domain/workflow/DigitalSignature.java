package gov.nih.nci.calims2.domain.workflow;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.common.Notes;
import java.util.Collection;

import org.joda.time.DateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.AttributeOverrides;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AssociationOverride;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.IndexColumn;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;
import gov.nih.nci.calims2.domain.interfaces.EntityWithExternalId;
import java.util.ArrayList;
import java.io.Serializable;
import gov.nih.nci.calims2.domain.report.visitor.ClauseVisitor;



import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@Table(name = "DIGITALSIGNATURE")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_DIGITALSIGNATURE_")

public class DigitalSignature  {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String createdBy;
  /**
* Retrieves the value of the createdBy attribute.
* @return createdBy
**/
  
  @Column(name = "CREATEDBY", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getCreatedBy() {
  return createdBy;
  }
  /**
* Sets the value of createdBy attribute.
* @param createdBy .
**/
  public void setCreatedBy(String 
  createdBy) {
  this.createdBy = createdBy;
  }
  /**
* 
**/
  private org.joda.time.DateTime dateCreated;
  /**
* Retrieves the value of the dateCreated attribute.
* @return dateCreated
**/
  
  @Column(name = "DATECREATED")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public org.joda.time.DateTime getDateCreated() {
  return dateCreated;
  }
  /**
* Sets the value of dateCreated attribute.
* @param dateCreated .
**/
  public void setDateCreated(org.joda.time.DateTime 
  dateCreated) {
  this.dateCreated = dateCreated;
  }
  /**
* 
**/
  private Long id;
  /**
* Retrieves the value of the id attribute.
* @return id
**/
  
  @Id
@GeneratedValue(strategy = GenerationType.AUTO)
  
  
  public Long getId() {
  return id;
  }
  /**
* Sets the value of id attribute.
* @param id .
**/
  public void setId(Long 
  id) {
  this.id = id;
  }
  /**
* 
**/
  private String signature;
  /**
* Retrieves the value of the signature attribute.
* @return signature
**/
  
  @Column(name = "SIGNATURE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getSignature() {
  return signature;
  }
  /**
* Sets the value of signature attribute.
* @param signature .
**/
  public void setSignature(String 
  signature) {
  this.signature = signature;
  }

        /**
* An associated gov.nih.nci.calims2.domain.administration.Person object.
**/
        private gov.nih.nci.calims2.domain.administration.Person person;
        /**
* Retrieves the value of the person attribute.
* @return person
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "DIGITALSIGN_PERSON_FK")

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
* An associated gov.nih.nci.calims2.domain.workflow.ApprovalPoll object.
**/
        private gov.nih.nci.calims2.domain.workflow.ApprovalPoll approvalPoll;
        /**
* Retrieves the value of the approvalPoll attribute.
* @return approvalPoll
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "APPROVALPOLL_FK")
@org.hibernate.annotations.ForeignKey(name = "DIGITALSIGN_APPROVALPOLL_FK")

        public gov.nih.nci.calims2.domain.workflow.ApprovalPoll getApprovalPoll() {
        return approvalPoll;
        }
   
        /**
* Sets the value of approvalPoll attribute.
* @param approvalPoll .
**/
        public void setApprovalPoll(gov.nih.nci.calims2.domain.workflow.ApprovalPoll approvalPoll) {
        this.approvalPoll = approvalPoll;
        }
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_DIGITALSIGNATURE",joinColumns=@JoinColumn(name="ID_NOTES_DIGITALSIGNATURE"))
        @ForeignKey(name="FK_NOTES_DIGITALSIGNATURE")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }


        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.
**/
        private gov.nih.nci.calims2.domain.common.Document imageFile;
        /**
* Retrieves the value of the imageFile attribute.
* @return imageFile
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "DOCUMENT_FK")
@org.hibernate.annotations.ForeignKey(name = "DIGITALSIGN_DOCUMENT_FK")

        public gov.nih.nci.calims2.domain.common.Document getImageFile() {
        return imageFile;
        }
   
        /**
* Sets the value of imageFile attribute.
* @param imageFile .
**/
        public void setImageFile(gov.nih.nci.calims2.domain.common.Document imageFile) {
        this.imageFile = imageFile;
        }






}
