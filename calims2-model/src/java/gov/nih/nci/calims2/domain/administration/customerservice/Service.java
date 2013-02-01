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
import org.joda.time.DateTime;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
/**
* 
**/

@SuppressWarnings("deprecation")
@Entity
@Table(name = "SERVICE")

public class Service extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private DateTime endDate;
  /**
* Retrieves the value of the endDate attribute.
* @return endDate
**/
  
  @Column(name = "ENDDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public DateTime getEndDate() {
  return endDate;
  }
  /**
* Sets the value of endDate attribute.
* @param endDate .
**/
  public void setEndDate(DateTime 
  endDate) {
  this.endDate = endDate;
  }
  /**
* 
**/
  private Boolean isTemplate;
  /**
* Retrieves the value of the isTemplate attribute.
* @return isTemplate
**/
  
  @Column(name = "ISTEMPLATE", length = EntityWithId.COLUMNLENGTH)
  
  
  public Boolean getIsTemplate() {
  return isTemplate;
  }
  /**
* Sets the value of isTemplate attribute.
* @param isTemplate .
**/
  public void setIsTemplate(Boolean 
  isTemplate) {
  this.isTemplate = isTemplate;
  }
  /**
* 
**/
  private DateTime startDate;
  /**
* Retrieves the value of the startDate attribute.
* @return startDate
**/
  
  @Column(name = "STARTDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public DateTime getStartDate() {
  return startDate;
  }
  /**
* Sets the value of startDate attribute.
* @param startDate .
**/
  public void setStartDate(DateTime 
  startDate) {
  this.startDate = startDate;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceStatus 
  status) {
  this.status = status;
  }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest customerRequest;
        /**
* Retrieves the value of the customerRequest attribute.
* @return customerRequest
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CUSTOMERREQUEST_FK")
@org.hibernate.annotations.ForeignKey(name = "SERVICCUSTOM_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest getCustomerRequest() {
        return customerRequest;
        }
   
        /**
* Sets the value of customerRequest attribute.
* @param customerRequest .
**/
        public void setCustomerRequest(gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest customerRequest) {
        this.customerRequest = customerRequest;
        }
   
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem> serviceItemCollection = new HashSet<gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem>();
        /**
* Retrieves the value of the serviceItemCollection attribute.
* @return serviceItemCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "service")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem> getServiceItemCollection() {
        return serviceItemCollection;
        }

        /**
* Sets the value of serviceItemCollection attribute.
* @param serviceItemCollection .
**/
        public void setServiceItemCollection(Set<gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem> serviceItemCollection) {
        this.serviceItemCollection = serviceItemCollection;
        }
    
    
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "service")
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
* An associated gov.nih.nci.calims2.domain.administration.Organization object.
**/
        private gov.nih.nci.calims2.domain.administration.Organization organization;
        /**
* Retrieves the value of the organization attribute.
* @return organization
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ORGANIZATION_FK")
@org.hibernate.annotations.ForeignKey(name = "SERVICORGANI_FK")

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
   
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_SERVICE",joinColumns=@JoinColumn(name="ID_NOTES_SERVICE"))
        @ForeignKey(name="FK_NOTES_SERVICE")
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
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.Service.type}")

       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "SERVICTYPE_FK")

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
   






}
