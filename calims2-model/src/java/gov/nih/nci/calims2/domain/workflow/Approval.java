package gov.nih.nci.calims2.domain.workflow;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.IndexColumn;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
/**
* 
**/

@Entity
@Table(name = "APPROVAL")
@Inheritance(strategy = InheritanceType.JOINED)
public class Approval extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "APPROVTYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.administration.customerservice.Invoice object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.Invoice invoice;
        /**
* Retrieves the value of the invoice attribute.
* @return invoice
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "INVOICE_FK")
@org.hibernate.annotations.ForeignKey(name = "APPROVINVOICE_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.Invoice getInvoice() {
        return invoice;
        }
   
        /**
* Sets the value of invoice attribute.
* @param invoice .
**/
        public void setInvoice(gov.nih.nci.calims2.domain.administration.customerservice.Invoice invoice) {
        this.invoice = invoice;
        }
   
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_APPROVAL",joinColumns=@JoinColumn(name="ID_NOTES_APPROVAL"))
        @ForeignKey(name="FK_NOTES_APPROVAL")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }

    
        /**
* An associated gov.nih.nci.calims2.domain.workflow.ApprovalPoll object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.workflow.ApprovalPoll> approvalPollCollection = new HashSet<gov.nih.nci.calims2.domain.workflow.ApprovalPoll>();
        /**
* Retrieves the value of the approvalPollCollection attribute.
* @return approvalPollCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "approval")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.workflow.ApprovalPoll> getApprovalPollCollection() {
        return approvalPollCollection;
        }

        /**
* Sets the value of approvalPollCollection attribute.
* @param approvalPollCollection .
**/
        public void setApprovalPollCollection(Set<gov.nih.nci.calims2.domain.workflow.ApprovalPoll> approvalPollCollection) {
        this.approvalPollCollection = approvalPollCollection;
        }
    
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation billingInformation;
        /**
* Retrieves the value of the billingInformation attribute.
* @return billingInformation
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "BILLINGINFORMATION_FK")
@org.hibernate.annotations.ForeignKey(name = "APPROVBILLIN_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation getBillingInformation() {
        return billingInformation;
        }
   
        /**
* Sets the value of billingInformation attribute.
* @param billingInformation .
**/
        public void setBillingInformation(gov.nih.nci.calims2.domain.administration.customerservice.BillingInformation billingInformation) {
        this.billingInformation = billingInformation;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.LabSupply object.
**/
        private gov.nih.nci.calims2.domain.inventory.LabSupply labSupply;
        /**
* Retrieves the value of the labSupply attribute.
* @return labSupply
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LABSUPPLY_FK")
@org.hibernate.annotations.ForeignKey(name = "APPROVLABSUP_FK")

        public gov.nih.nci.calims2.domain.inventory.LabSupply getLabSupply() {
        return labSupply;
        }
   
        /**
* Sets the value of labSupply attribute.
* @param labSupply .
**/
        public void setLabSupply(gov.nih.nci.calims2.domain.inventory.LabSupply labSupply) {
        this.labSupply = labSupply;
        }
   
  /*  
        *//**
* An associated gov.nih.nci.calims2.domain.common.ExternalIdentifier object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> externalIdentifierCollection = new HashSet<gov.nih.nci.calims2.domain.common.ExternalIdentifier>();
        *//**
* Retrieves the value of the externalIdentifierCollection attribute.
* @return externalIdentifierCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "APPROVAL_FK")
@org.hibernate.annotations.ForeignKey(name = "EXTERNAPPROV_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> getExternalIdentifierCollection() {
        return externalIdentifierCollection;
        }

        *//**
* Sets the value of externalIdentifierCollection attribute.
* @param externalIdentifierCollection .
**//*
        public void setExternalIdentifierCollection(Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> externalIdentifierCollection) {
        this.externalIdentifierCollection = externalIdentifierCollection;
        }
    
    */
      /*  *//**
* An associated gov.nih.nci.calims2.domain.administration.Organization object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.administration.Organization> organizationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Organization>();
        *//**
* Retrieves the value of the organizationCollection attribute.
* @return organizationCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "APPROVAL_FK")
@org.hibernate.annotations.ForeignKey(name = "ORGANIAPPROV_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Organization> getOrganizationCollection() {
        return organizationCollection;
        }

        *//**
* Sets the value of organizationCollection attribute.
* @param organizationCollection .
**//*
        public void setOrganizationCollection(Set<gov.nih.nci.calims2.domain.administration.Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
        }
    */
   
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
@org.hibernate.annotations.ForeignKey(name = "APPROVCUSTOM_FK")

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
* An associated gov.nih.nci.calims2.domain.workflow.ExperimentalResult object.
**/
        private gov.nih.nci.calims2.domain.workflow.ExperimentalResult experimentalResult;
        /**
* Retrieves the value of the experimentalResult attribute.
* @return experimentalResult
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "EXPERIMENTALRESULT_FK")
@org.hibernate.annotations.ForeignKey(name = "APPROVEXPERI_FK")

        public gov.nih.nci.calims2.domain.workflow.ExperimentalResult getExperimentalResult() {
        return experimentalResult;
        }
   
        /**
* Sets the value of experimentalResult attribute.
* @param experimentalResult .
**/
        public void setExperimentalResult(gov.nih.nci.calims2.domain.workflow.ExperimentalResult experimentalResult) {
        this.experimentalResult = experimentalResult;
        }
   
 /*   
        *//**
* An associated gov.nih.nci.calims2.domain.administration.Person object.'s collection.
**//*
        private Set<gov.nih.nci.calims2.domain.administration.Person> personCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Person>();
        *//**
* Retrieves the value of the personCollection attribute.
* @return personCollection
**//*
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "APPROVAL_FK")
@org.hibernate.annotations.ForeignKey(name = "PERSONAPPROV_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Person> getPersonCollection() {
        return personCollection;
        }

        *//**
* Sets the value of personCollection attribute.
* @param personCollection .
**//*
        public void setPersonCollection(Set<gov.nih.nci.calims2.domain.administration.Person> personCollection) {
        this.personCollection = personCollection;
        }
    */
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.customerservice.Quotation object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.Quotation quotation;
        /**
* Retrieves the value of the quotation attribute.
* @return quotation
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "QUOTATION_FK")
@org.hibernate.annotations.ForeignKey(name = "APPROVQUOTAT_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.Quotation getQuotation() {
        return quotation;
        }
   
        /**
* Sets the value of quotation attribute.
* @param quotation .
**/
        public void setQuotation(gov.nih.nci.calims2.domain.administration.customerservice.Quotation quotation) {
        this.quotation = quotation;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.workflow.Finding object.
**/
        private gov.nih.nci.calims2.domain.workflow.Finding finding;
        /**
* Retrieves the value of the finding attribute.
* @return finding
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "FINDING_FK")
@org.hibernate.annotations.ForeignKey(name = "APPROVFINDING_FK")

        public gov.nih.nci.calims2.domain.workflow.Finding getFinding() {
        return finding;
        }
   
        /**
* Sets the value of finding attribute.
* @param finding .
**/
        public void setFinding(gov.nih.nci.calims2.domain.workflow.Finding finding) {
        this.finding = finding;
        }
   






}
