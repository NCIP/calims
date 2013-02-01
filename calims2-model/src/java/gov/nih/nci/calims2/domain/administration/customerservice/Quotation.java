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
@Table(name = "QUOTATION")

public class Quotation extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private DateTime approvalDate;
  /**
* Retrieves the value of the approvalDate attribute.
* @return approvalDate
**/
  
  @Column(name = "APPROVALDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public DateTime getApprovalDate() {
  return approvalDate;
  }
  /**
* Sets the value of approvalDate attribute.
* @param approvalDate .
**/
  public void setApprovalDate(DateTime 
  approvalDate) {
  this.approvalDate = approvalDate;
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
  private gov.nih.nci.calims2.domain.administration.customerservice.enumeration.QuotationStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.Quotation.status}")
  public gov.nih.nci.calims2.domain.administration.customerservice.enumeration.QuotationStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.customerservice.enumeration.QuotationStatus 
  status) {
  this.status = status;
  }
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_QUOTATION",joinColumns=@JoinColumn(name="ID_NOTES_QUOTATION"))
        @ForeignKey(name="FK_NOTES_QUOTATION")
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
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "quotation")
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

   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.Quotation.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "QUOTATTYPE_FK")

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
        private gov.nih.nci.calims2.domain.administration.customerservice.Rate rate;
        /**
* Retrieves the value of the rate attribute.
* @return rate
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "RATE_FK")
@org.hibernate.annotations.ForeignKey(name = "QUOTATION_RATE_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.Rate getRate() {
        return rate;
        }
   
        /**
* Sets the value of rate attribute.
* @param rate .
**/
        public void setRate(gov.nih.nci.calims2.domain.administration.customerservice.Rate rate) {
        this.rate = rate;
        }






}