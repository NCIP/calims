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
import javax.persistence.ManyToMany;
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
@Table(name = "INVOICE")

public class Invoice extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private DateTime invoiceDate;
  /**
* Retrieves the value of the invoiceDate attribute.
* @return invoiceDate
**/
  
  @Column(name = "INVOICEDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public DateTime getInvoiceDate() {
  return invoiceDate;
  }
  /**
* Sets the value of invoiceDate attribute.
* @param invoiceDate .
**/
  public void setInvoiceDate(DateTime 
  invoiceDate) {
  this.invoiceDate = invoiceDate;
  }
  /**
* 
**/
  private DateTime invoicePaymentDate;
  /**
* Retrieves the value of the invoicePaymentDate attribute.
* @return invoicePaymentDate
**/
  
  @Column(name = "INVOICEPAYMENTDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public DateTime getInvoicePaymentDate() {
  return invoicePaymentDate;
  }
  /**
* Sets the value of invoicePaymentDate attribute.
* @param invoicePaymentDate .
**/
  public void setInvoicePaymentDate(DateTime 
  invoicePaymentDate) {
  this.invoicePaymentDate = invoicePaymentDate;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.customerservice.enumeration.InvoiceStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.Invoice.status}")
  public gov.nih.nci.calims2.domain.administration.customerservice.enumeration.InvoiceStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.customerservice.enumeration.InvoiceStatus 
  status) {
  this.status = status;
  }
   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.Invoice.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "INVOICTYPE_FK")

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
   
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_INVOICE",joinColumns=@JoinColumn(name="ID_NOTES_INVOICE"))
        @ForeignKey(name="FK_NOTES_INVOICE")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }

        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest> customerRequestCollection = new HashSet<gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest>();
        /**
* Retrieves the value of the customerRequestCollection attribute.
* @return customerRequestCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "Invoice_CustomerRequest",
joinColumns = @JoinColumn(name = "INVOICE_ID"),
inverseJoinColumns = @JoinColumn(name = "CUSTOMERREQUEST_ID"))
@org.hibernate.annotations.ForeignKey(name = "INVOICE_CUSTOMERREQU_ID", inverseName = "CUSTOMERREQU_INVOICE_ID")
        
        public Set<gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest> getCustomerRequestCollection() {
        return customerRequestCollection;
        }
    
        /**
* Sets the value of customerRequestCollection attribute.
* @param customerRequestCollection .
**/
        public void setCustomerRequestCollection(Set<gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest> customerRequestCollection) {
        this.customerRequestCollection = customerRequestCollection;
        }
    
    
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice")
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
