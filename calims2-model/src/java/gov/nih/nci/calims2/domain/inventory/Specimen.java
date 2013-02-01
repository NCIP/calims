package gov.nih.nci.calims2.domain.inventory;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
import gov.nih.nci.calims2.domain.inventory.visitor.SpecimenVisitor;
/**
* 
**/

@Entity
@Table(name = "SPECIMEN")
@Inheritance(strategy = InheritanceType.JOINED)
public class Specimen extends DisplayableEntity implements  EntityWithExternalId,  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* NCI|An action taken in pursuit of an objective; the state of being active.; NCI|A condition or state
* at a particular time.
**/
  private String activityStatus;
  /**
* Retrieves the value of the activityStatus attribute.
* @return activityStatus
**/
  
  @Column(name = "ACTIVITYSTATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getActivityStatus() {
  return activityStatus;
  }
  /**
* Sets the value of activityStatus attribute.
* @param activityStatus .
**/
  public void setActivityStatus(String 
  activityStatus) {
  this.activityStatus = activityStatus;
  }
  /**
* NCI|A state of being, such as a state of health or physical being.
**/
  private String condition;
  /**
* Retrieves the value of the condition attribute.
* @return condition
**/
  
  @Column(name = "CONDITION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getCondition() {
  return condition;
  }
  /**
* Sets the value of condition attribute.
* @param condition .
**/
  public void setCondition(String 
  condition) {
  this.condition = condition;
  }
  /**
* NCI|An indicator that can be set or unset in order to signal whether a particular condition is true.;NCI|The
* quality of being obtainable or accessible and ready for use or service.
**/
  private Boolean isAvailable;
  /**
* Retrieves the value of the isAvailable attribute.
* @return isAvailable
**/
  
  @Column(name = "ISAVAILABLE", length = EntityWithId.COLUMNLENGTH)
  
  
  public Boolean getIsAvailable() {
  return isAvailable;
  }
  /**
* Sets the value of isAvailable attribute.
* @param isAvailable .
**/
  public void setIsAvailable(Boolean 
  isAvailable) {
  this.isAvailable = isAvailable;
  }
  /**
* 
**/
  private DateTime receivedDateTime;
  /**
* Retrieves the value of the receivedDateTime attribute.
* @return receivedDateTime
**/
  
  @Column(name = "RECEIVEDDATETIME")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public DateTime getReceivedDateTime() {
  return receivedDateTime;
  }
  /**
* Sets the value of receivedDateTime attribute.
* @param receivedDateTime .
**/
  public void setReceivedDateTime(DateTime 
  receivedDateTime) {
  this.receivedDateTime = receivedDateTime;
  }
  /**
* 
**/
  private String use;
  /**
* Retrieves the value of the use attribute.
* @return use
**/
  
  @Column(name = "USE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getUse() {
  return use;
  }
  /**
* Sets the value of use attribute.
* @param use .
**/
  public void setUse(String 
  use) {
  this.use = use;
  }
        /**
* An associated gov.nih.nci.calims2.domain.administration.Organization object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Organization> organizationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Organization>();
        /**
* Retrieves the value of the organizationCollection attribute.
* @return organizationCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "Specimen_Organization",
joinColumns = @JoinColumn(name = "SPECIMEN_ID"),
inverseJoinColumns = @JoinColumn(name = "ORGANIZATION_ID"))
@org.hibernate.annotations.ForeignKey(name = "SPECIMEN_ORGANIZATION_ID", inverseName = "ORGANIZATION_SPECIMEN_ID")
        
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
* An associated gov.nih.nci.calims2.domain.common.ExternalIdentifier object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> externalIdentifierCollection = new HashSet<gov.nih.nci.calims2.domain.common.ExternalIdentifier>();
        /**
* Retrieves the value of the externalIdentifierCollection attribute.
* @return externalIdentifierCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "specimen")
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
* An associated gov.nih.nci.calims2.domain.administration.Person object.
**/
        private gov.nih.nci.calims2.domain.administration.Person contactPerson;
        /**
* Retrieves the value of the contactPerson attribute.
* @return contactPerson
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "SPECIMPERSON_FK")

        public gov.nih.nci.calims2.domain.administration.Person getContactPerson() {
        return contactPerson;
        }
   
        /**
* Sets the value of contactPerson attribute.
* @param contactPerson .
**/
        public void setContactPerson(gov.nih.nci.calims2.domain.administration.Person contactPerson) {
        this.contactPerson = contactPerson;
        }
   

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Container object.
**/
        private gov.nih.nci.calims2.domain.inventory.Container container;
        /**
* Retrieves the value of the container attribute.
* @return container
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CONTAINER_FK")
@org.hibernate.annotations.ForeignKey(name = "SPECIMEN_CONTAINER_FK")

        public gov.nih.nci.calims2.domain.inventory.Container getContainer() {
        return container;
        }
   
        /**
* Sets the value of container attribute.
* @param container .
**/
        public void setContainer(gov.nih.nci.calims2.domain.inventory.Container container) {
        this.container = container;
        }
        private Set<gov.nih.nci.calims2.domain.administration.Quantity> quantityCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Quantity>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="QUANTITY_SPECIMEN",joinColumns=@JoinColumn(name="ID_QUANTITY_SPECIMEN"))
        @ForeignKey(name="FK_QUANTITY_SPECIMEN")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.administration.Quantity> getQuantityCollection() {
        return quantityCollection;
        }
        public void setQuantityCollection(Set<gov.nih.nci.calims2.domain.administration.Quantity> quantityCollection) {
             this.quantityCollection = quantityCollection;
        }

   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem serviceItem;
        /**
* Retrieves the value of the serviceItem attribute.
* @return serviceItem
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SERVICEITEM_FK")
@org.hibernate.annotations.ForeignKey(name = "SPECIMSERVIC_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem getServiceItem() {
        return serviceItem;
        }
   
        /**
* Sets the value of serviceItem attribute.
* @param serviceItem .
**/
        public void setServiceItem(gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem serviceItem) {
        this.serviceItem = serviceItem;
        }
   
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_SPECIMEN",joinColumns=@JoinColumn(name="ID_NOTES_SPECIMEN"))
        @ForeignKey(name="FK_NOTES_SPECIMEN")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }

    
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "specimen")
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
* An associated gov.nih.nci.calims2.domain.administration.Location object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Location> samplingLocationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Location>();
        /**
* Retrieves the value of the samplingLocationCollection attribute.
* @return samplingLocationCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "Specimen_Location",
joinColumns = @JoinColumn(name = "SPECIMEN_ID"),
inverseJoinColumns = @JoinColumn(name = "LOCATION_ID"))
@org.hibernate.annotations.ForeignKey(name = "SPECIMEN_LOCATION_ID", inverseName = "LOCATION_SPECIMEN_ID")
        
        public Set<gov.nih.nci.calims2.domain.administration.Location> getSamplingLocationCollection() {
        return samplingLocationCollection;
        }
    
        /**
* Sets the value of samplingLocationCollection attribute.
* @param samplingLocationCollection .
**/
        public void setSamplingLocationCollection(Set<gov.nih.nci.calims2.domain.administration.Location> samplingLocationCollection) {
        this.samplingLocationCollection = samplingLocationCollection;
        }
    
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Specimen object.
**/
        private gov.nih.nci.calims2.domain.inventory.Specimen parentSpecimen;
        /**
* Retrieves the value of the parentSpecimen attribute.
* @return parentSpecimen
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SPECIMEN_FK")
@org.hibernate.annotations.ForeignKey(name = "CHILDSSPECIM_FK")

        public gov.nih.nci.calims2.domain.inventory.Specimen getParentSpecimen() {
        return parentSpecimen;
        }
   
        /**
* Sets the value of parentSpecimen attribute.
* @param parentSpecimen .
**/
        public void setParentSpecimen(gov.nih.nci.calims2.domain.inventory.Specimen parentSpecimen) {
        this.parentSpecimen = parentSpecimen;
        }
   

/** Accepts the SpecimenVisitor.
 * @param specimenVisitor The specimenVisitor to accept.
 **/ public void accept(SpecimenVisitor specimenVisitor) {
       specimenVisitor.visitSpecimen(this);
}





}