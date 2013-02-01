package gov.nih.nci.calims2.domain.administration;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.common.Type;
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



import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* Collaboration is the process wherein groups work together to achieve outcomes for common goals.
**/

@Entity
@Table(name = "COLLABORATION")

public class Collaboration extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.CollaborationStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Collaboration.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.CollaborationStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.CollaborationStatus 
  status) {
  this.status = status;
  }
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.ContactInformation object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.ContactInformation> contactInformationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.ContactInformation>();
        /**
* Retrieves the value of the contactInformationCollection attribute.
* @return contactInformationCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "collaboration")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.administration.ContactInformation> getContactInformationCollection() {
        return contactInformationCollection;
        }

        /**
* Sets the value of contactInformationCollection attribute.
* @param contactInformationCollection .
**/
        public void setContactInformationCollection(Set<gov.nih.nci.calims2.domain.administration.ContactInformation> contactInformationCollection) {
        this.contactInformationCollection = contactInformationCollection;
        }
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.Laboratory object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Laboratory> laboratoryCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Laboratory>();
        /**
* Retrieves the value of the laboratoryCollection attribute.
* @return laboratoryCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "Collaboration_Laboratory",
joinColumns = @JoinColumn(name = "COLLABORATION_ID"),
inverseJoinColumns = @JoinColumn(name = "LABORATORY_ID"))
@org.hibernate.annotations.ForeignKey(name = "COLLABORATIO_LABORATORY_ID", inverseName = "LABORATORY_COLLABORATIO_ID")
        
        public Set<gov.nih.nci.calims2.domain.administration.Laboratory> getLaboratoryCollection() {
        return laboratoryCollection;
        }
    
        /**
* Sets the value of laboratoryCollection attribute.
* @param laboratoryCollection .
**/
        public void setLaboratoryCollection(Set<gov.nih.nci.calims2.domain.administration.Laboratory> laboratoryCollection) {
        this.laboratoryCollection = laboratoryCollection;
        }
    
   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Collaboration.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "COLLABTYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.administration.Organization object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Organization> organizationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Organization>();
        /**
* Retrieves the value of the organizationCollection attribute.
* @return organizationCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "COLLABORATION_FK")
@org.hibernate.annotations.ForeignKey(name = "ORGANICOLLAB_FK")

        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Collaboration.organizationCollection}")
       
        public Set<gov.nih.nci.calims2.domain.administration.Organization> getOrganizationCollection() {
        return organizationCollection;
        }

        /**
* Sets the value of organizationCollection attribute.
* @param organizationCollection .
**/
        public void setOrganizationCollection(Set<gov.nih.nci.calims2.domain.administration.Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
        }
    
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Role object.
**/
        private gov.nih.nci.calims2.domain.administration.Role role;
        /**
* Retrieves the value of the role attribute.
* @return role
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ROLE_FK")
@org.hibernate.annotations.ForeignKey(name = "COLLABROLE_FK")

        public gov.nih.nci.calims2.domain.administration.Role getRole() {
        return role;
        }
   
        /**
* Sets the value of role attribute.
* @param role .
**/
        public void setRole(gov.nih.nci.calims2.domain.administration.Role role) {
        this.role = role;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Person object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Person> personCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Person>();
        /**
* Retrieves the value of the personCollection attribute.
* @return personCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "Collaboration_Person",
joinColumns = @JoinColumn(name = "COLLABORATION_ID"),
inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
@org.hibernate.annotations.ForeignKey(name = "COLLABORATIO_PERSON_ID", inverseName = "PERSON_COLLABORATIO_ID")
        
        public Set<gov.nih.nci.calims2.domain.administration.Person> getPersonCollection() {
        return personCollection;
        }
    
        /**
* Sets the value of personCollection attribute.
* @param personCollection .
**/
        public void setPersonCollection(Set<gov.nih.nci.calims2.domain.administration.Person> personCollection) {
        this.personCollection = personCollection;
        }
    
    
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "collaboration")
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
    






}
