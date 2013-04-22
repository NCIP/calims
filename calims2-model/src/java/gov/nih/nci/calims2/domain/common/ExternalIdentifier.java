/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.common;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI|Happening or arising or located outside or beyond some limits, or especially, some surface.;NCI|One
* or more characters used to identify, name, or characterize the nature, properties, or contents of
* a thing.
**/

@Entity
@Table(name = "EXTERNALIDENTIFIER")

public class ExternalIdentifier extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String source;
  /**
* Retrieves the value of the source attribute.
* @return source
**/
  
  @Column(name = "SOURCE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getSource() {
  return source;
  }
  /**
* Sets the value of source attribute.
* @param source .
**/
  public void setSource(String 
  source) {
  this.source = source;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.common.enumeration.ExternalIdentifierStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  @Enumerated(EnumType.STRING)
  @Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.common.enumeration.ExternalIdentifierStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.common.enumeration.ExternalIdentifierStatus 
  status) {
  this.status = status;
  }
  /**
* NCI|The information contained in a data field. It may represent a numeric quantity, a textual characterization,
* a date or time measurement, or some other state, depending on the nature of the attribute.
**/
  private String value;
  /**
* Retrieves the value of the value attribute.
* @return value
**/
  
  @Column(name = "VALUE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getValue() {
  return value;
  }
  /**
* Sets the value of value attribute.
* @param value .
**/
  public void setValue(String 
  value) {
  this.value = value;
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
@org.hibernate.annotations.ForeignKey(name = "EXTERNCUSTOM_FK")

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
* An associated gov.nih.nci.calims2.domain.administration.Person object.
**/
        private gov.nih.nci.calims2.domain.administration.Person person;
        /**
* Retrieves the value of the person attribute.
* @return person
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "EXTERNALIDE_PERSON_FK")

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
* An associated gov.nih.nci.calims2.domain.inventory.LabSupply object.
**/
        private gov.nih.nci.calims2.domain.inventory.LabSupply labSupply;
        /**
* Retrieves the value of the labSupply attribute.
* @return labSupply
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LABSUPPLY_FK")
@org.hibernate.annotations.ForeignKey(name = "EXTERNLABSUP_FK")

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
   
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Specimen object.
**/
        private gov.nih.nci.calims2.domain.inventory.Specimen specimen;
        /**
* Retrieves the value of the specimen attribute.
* @return specimen
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SPECIMEN_FK")
@org.hibernate.annotations.ForeignKey(name = "EXTERNSPECIM_FK")

        public gov.nih.nci.calims2.domain.inventory.Specimen getSpecimen() {
        return specimen;
        }
   
        /**
* Sets the value of specimen attribute.
* @param specimen .
**/
        public void setSpecimen(gov.nih.nci.calims2.domain.inventory.Specimen specimen) {
        this.specimen = specimen;
        }
   
   
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
@org.hibernate.annotations.ForeignKey(name = "EXTERNTYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.administration.customerservice.Account object.
**/
        private gov.nih.nci.calims2.domain.administration.customerservice.Account account;
        /**
* Retrieves the value of the account attribute.
* @return account
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ACCOUNT_FK")
@org.hibernate.annotations.ForeignKey(name = "EXTERNACCOUNT_FK")

        public gov.nih.nci.calims2.domain.administration.customerservice.Account getAccount() {
        return account;
        }
   
        /**
* Sets the value of account attribute.
* @param account .
**/
        public void setAccount(gov.nih.nci.calims2.domain.administration.customerservice.Account account) {
        this.account = account;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Sequence object.
**/
        private gov.nih.nci.calims2.domain.inventory.Sequence sequence;
        /**
* Retrieves the value of the sequence attribute.
* @return sequence
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SEQUENCE_FK")
@org.hibernate.annotations.ForeignKey(name = "EXTERNSEQUEN_FK")

        public gov.nih.nci.calims2.domain.inventory.Sequence getSequence() {
        return sequence;
        }
   
        /**
* Sets the value of sequence attribute.
* @param sequence .
**/
        public void setSequence(gov.nih.nci.calims2.domain.inventory.Sequence sequence) {
        this.sequence = sequence;
        }
   
   







}
