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
@Table(name = "ACCOUNTNUMBER")

public class AccountNumber extends DisplayableEntity implements  EntityWithNotes {
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
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber.endDate}")
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
  private DateTime startDate;
  /**
* Retrieves the value of the startDate attribute.
* @return startDate
**/
  
  @Column(name = "STARTDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber.startDate}")
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
  private gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountNumberStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber.status}")
  public gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountNumberStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountNumberStatus 
  status) {
  this.status = status;
  }
  /**
* 
**/
  private Long value;
  /**
* Retrieves the value of the value attribute.
* @return value
**/
  
  @Column(name = "VALUE", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull
  public Long getValue() {
  return value;
  }
  /**
* Sets the value of value attribute.
* @param value .
**/
  public void setValue(Long 
  value) {
  this.value = value;
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
@org.hibernate.annotations.ForeignKey(name = "ACCOUNACCOUNT_FK")

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
   
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_ACCOUNTNUMBER",joinColumns=@JoinColumn(name="ID_NOTES_ACCOUNTNUMBER"))
        @ForeignKey(name="FK_NOTES_ACCOUNTNUMBER")
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
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "ACCOUNTYPE_FK")

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
