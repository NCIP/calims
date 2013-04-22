/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration.customerservice;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
/**
* 
**/

@SuppressWarnings("deprecation")
@Entity
@Table(name = "SERVICEITEM")

public class ServiceItem extends DisplayableEntity implements  EntityWithNotes {
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
  private gov.nih.nci.calims2.domain.inventory.enumeration.SpecimenType specimenType;
  /**
* Retrieves the value of the specimenType attribute.
* @return specimenType
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "SPECIMENTYPE", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.inventory.enumeration.SpecimenType getSpecimenType() {
  return specimenType;
  }
  /**
* Sets the value of specimenType attribute.
* @param specimenType .
**/
  public void setSpecimenType(gov.nih.nci.calims2.domain.inventory.enumeration.SpecimenType 
  specimenType) {
  this.specimenType = specimenType;
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
  private gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceItemStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceItemStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceItemStatus 
  status) {
  this.status = status;
  }
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_SERVICEITEM",joinColumns=@JoinColumn(name="ID_NOTES_SERVICEITEM"))
        @ForeignKey(name="FK_NOTES_SERVICEITEM")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }

    
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Specimen object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.inventory.Specimen> specimenCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.Specimen>();
        /**
* Retrieves the value of the specimenCollection attribute.
* @return specimenCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "serviceItem")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.inventory.Specimen> getSpecimenCollection() {
        return specimenCollection;
        }

        /**
* Sets the value of specimenCollection attribute.
* @param specimenCollection .
**/
        public void setSpecimenCollection(Set<gov.nih.nci.calims2.domain.inventory.Specimen> specimenCollection) {
        this.specimenCollection = specimenCollection;
        }
    
   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem.type}")
       
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
   

        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.Rate object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.Rate serviceItemRate;
        /**
* Retrieves the value of the serviceItemRate attribute.
* @return serviceItemRate
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "RATE_FK")
@org.hibernate.annotations.ForeignKey(name = "SERVICEITEM_RATE_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.Rate getServiceItemRate() {
        return serviceItemRate;
        }
   
        /**
* Sets the value of serviceItemRate attribute.
* @param serviceItemRate .
**/
        public void setServiceItemRate(gov.nih.nci.calims2.domain.administration.customerservice.Rate serviceItemRate) {
        this.serviceItemRate = serviceItemRate;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.Service object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.Service service;
        /**
* Retrieves the value of the service attribute.
* @return service
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SERVICE_FK")
@org.hibernate.annotations.ForeignKey(name = "SERVICSERVICE_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.Service getService() {
        return service;
        }
   
        /**
* Sets the value of service attribute.
* @param service .
**/
        public void setService(gov.nih.nci.calims2.domain.administration.customerservice.Service service) {
        this.service = service;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber> accountNumberCollection = new HashSet<gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber>();
        /**
* Retrieves the value of the accountNumberCollection attribute.
* @return accountNumberCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "ServiceItem_AccountNumber",
joinColumns = @JoinColumn(name = "SERVICEITEM_ID"),
inverseJoinColumns = @JoinColumn(name = "ACCOUNTNUMBER_ID"))
@org.hibernate.annotations.ForeignKey(name = "SERVICEITEM_ACCOUNTNUMBE_ID", inverseName = "ACCOUNTNUMBE_SERVICEITEM_ID")
        
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
    
        private gov.nih.nci.calims2.domain.administration.Quantity quantity;
        @Embedded
        @AttributeOverrides({@AttributeOverride(name="value", column=@Column(name = "QUANTITY_VALUE", length = EntityWithId.COLUMNLENGTH))})
        @AssociationOverrides({ @AssociationOverride(name="type", joinColumns=@JoinColumn(name="QUANTITY_TYPE_FK")),@AssociationOverride(name="standardUnit", joinColumns=@JoinColumn(name="QUANTITY_STANDARDUNIT_FK"))})
        public gov.nih.nci.calims2.domain.administration.Quantity getQuantity() {
        return quantity;
        }
        public void setQuantity(gov.nih.nci.calims2.domain.administration.Quantity quantity) {
           this.quantity = quantity;
        }







}