/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.workflow;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
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
@Table(name = "APPROVALPOLL")

public class ApprovalPoll extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private gov.nih.nci.calims2.domain.workflow.enumeration.ApprovalPollStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.workflow.enumeration.ApprovalPollStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.workflow.enumeration.ApprovalPollStatus 
  status) {
  this.status = status;
  }

        /**
* An associated gov.nih.nci.calims2.domain.workflow.DigitalSignature object.
**/
        private gov.nih.nci.calims2.domain.workflow.DigitalSignature digitalSignature;
        /**
* Retrieves the value of the digitalSignature attribute.
* @return digitalSignature
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "DIGITALSIGNATURE_FK")
@org.hibernate.annotations.ForeignKey(name = "APPROVALPOLL_DIGITALSIGN_FK")

        public gov.nih.nci.calims2.domain.workflow.DigitalSignature getDigitalSignature() {
        return digitalSignature;
        }
   
        /**
* Sets the value of digitalSignature attribute.
* @param digitalSignature .
**/
        public void setDigitalSignature(gov.nih.nci.calims2.domain.workflow.DigitalSignature digitalSignature) {
        this.digitalSignature = digitalSignature;
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
@org.hibernate.annotations.ForeignKey(name = "APPROVALPOLL_PERSON_FK")

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
* An associated gov.nih.nci.calims2.domain.workflow.Approval object.
**/
        private gov.nih.nci.calims2.domain.workflow.Approval approval;
        /**
* Retrieves the value of the approval attribute.
* @return approval
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "APPROVAL_FK")
@org.hibernate.annotations.ForeignKey(name = "APPROVAPPROV_FK")

        public gov.nih.nci.calims2.domain.workflow.Approval getApproval() {
        return approval;
        }
   
        /**
* Sets the value of approval attribute.
* @param approval .
**/
        public void setApproval(gov.nih.nci.calims2.domain.workflow.Approval approval) {
        this.approval = approval;
        }
   
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_APPROVALPOLL",joinColumns=@JoinColumn(name="ID_NOTES_APPROVALPOLL"))
        @ForeignKey(name="FK_NOTES_APPROVALPOLL")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }







}
