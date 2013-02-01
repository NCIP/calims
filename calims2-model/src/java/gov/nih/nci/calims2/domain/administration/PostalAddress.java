package gov.nih.nci.calims2.domain.administration;
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
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.IndexColumn;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
/**
* 
**/

@Entity
@Table(name = "POSTALADDRESS")

public class PostalAddress extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String addressStreetPostDirectionalType;
  /**
* Retrieves the value of the addressStreetPostDirectionalType attribute.
* @return addressStreetPostDirectionalType
**/
  
  @Column(name = "ADDRESSSTREETPOSTDIRECTIONALT", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getAddressStreetPostDirectionalType() {
  return addressStreetPostDirectionalType;
  }
  /**
* Sets the value of addressStreetPostDirectionalType attribute.
* @param addressStreetPostDirectionalType .
**/
  public void setAddressStreetPostDirectionalType(String 
  addressStreetPostDirectionalType) {
  this.addressStreetPostDirectionalType = addressStreetPostDirectionalType;
  }
  /**
* 
**/
  private String addressStreetPreDirectionalType;
  /**
* Retrieves the value of the addressStreetPreDirectionalType attribute.
* @return addressStreetPreDirectionalType
**/
  
  @Column(name = "ADDRESSSTREETPREDIRECTIONALTY", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getAddressStreetPreDirectionalType() {
  return addressStreetPreDirectionalType;
  }
  /**
* Sets the value of addressStreetPreDirectionalType attribute.
* @param addressStreetPreDirectionalType .
**/
  public void setAddressStreetPreDirectionalType(String 
  addressStreetPreDirectionalType) {
  this.addressStreetPreDirectionalType = addressStreetPreDirectionalType;
  }
  /**
* 
**/
  private String city;
  /**
* Retrieves the value of the city attribute.
* @return city
**/
  
  @Column(name = "CITY", length = EntityWithId.COLUMNLENGTH)
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.PostalAddress.city}")
  public String getCity() {
  return city;
  }
  /**
* Sets the value of city attribute.
* @param city .
**/
  public void setCity(String 
  city) {
  this.city = city;
  }
  /**
* 
**/
  private String country;
  /**
* Retrieves the value of the country attribute.
* @return country
**/
  
  @Column(name = "COUNTRY", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getCountry() {
  return country;
  }
  /**
* Sets the value of country attribute.
* @param country .
**/
  public void setCountry(String 
  country) {
  this.country = country;
  }
  /**
* 
**/
  private String county;
  /**
* Retrieves the value of the county attribute.
* @return county
**/
  
  @Column(name = "COUNTY", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getCounty() {
  return county;
  }
  /**
* Sets the value of county attribute.
* @param county .
**/
  public void setCounty(String 
  county) {
  this.county = county;
  }
  /**
* 
**/
  private String firstAddressLine;
  /**
* Retrieves the value of the firstAddressLine attribute.
* @return firstAddressLine
**/
  
  @Column(name = "FIRSTADDRESSLINE", length = EntityWithId.COLUMNLENGTH)
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.PostalAddress.firstAddressLine}")
  public String getFirstAddressLine() {
  return firstAddressLine;
  }
  /**
* Sets the value of firstAddressLine attribute.
* @param firstAddressLine .
**/
  public void setFirstAddressLine(String 
  firstAddressLine) {
  this.firstAddressLine = firstAddressLine;
  }
  /**
* 
**/
  private String mailStopCode;
  /**
* Retrieves the value of the mailStopCode attribute.
* @return mailStopCode
**/
  
  @Column(name = "MAILSTOPCODE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getMailStopCode() {
  return mailStopCode;
  }
  /**
* Sets the value of mailStopCode attribute.
* @param mailStopCode .
**/
  public void setMailStopCode(String 
  mailStopCode) {
  this.mailStopCode = mailStopCode;
  }
  /**
* 
**/
  private String postalCode;
  /**
* Retrieves the value of the postalCode attribute.
* @return postalCode
**/
  
  @Column(name = "POSTALCODE", length = EntityWithId.COLUMNLENGTH)
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.PostalAddress.postalCode}")
  public String getPostalCode() {
  return postalCode;
  }
  /**
* Sets the value of postalCode attribute.
* @param postalCode .
**/
  public void setPostalCode(String 
  postalCode) {
  this.postalCode = postalCode;
  }
  /**
* 
**/
  private String postOfficeBoxNumber;
  /**
* Retrieves the value of the postOfficeBoxNumber attribute.
* @return postOfficeBoxNumber
**/
  
  @Column(name = "POSTOFFICEBOXNUMBER", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getPostOfficeBoxNumber() {
  return postOfficeBoxNumber;
  }
  /**
* Sets the value of postOfficeBoxNumber attribute.
* @param postOfficeBoxNumber .
**/
  public void setPostOfficeBoxNumber(String 
  postOfficeBoxNumber) {
  this.postOfficeBoxNumber = postOfficeBoxNumber;
  }
  /**
* 
**/
  private String secondAddressLine;
  /**
* Retrieves the value of the secondAddressLine attribute.
* @return secondAddressLine
**/
  
  @Column(name = "SECONDADDRESSLINE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getSecondAddressLine() {
  return secondAddressLine;
  }
  /**
* Sets the value of secondAddressLine attribute.
* @param secondAddressLine .
**/
  public void setSecondAddressLine(String 
  secondAddressLine) {
  this.secondAddressLine = secondAddressLine;
  }
  /**
* 
**/
  private String state;
  /**
* Retrieves the value of the state attribute.
* @return state
**/
  
  @Column(name = "STATE", length = EntityWithId.COLUMNLENGTH)
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.PostalAddress.state}")
  public String getState() {
  return state;
  }
  /**
* Sets the value of state attribute.
* @param state .
**/
  public void setState(String 
  state) {
  this.state = state;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.PostalAddressStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.PostalAddress.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.PostalAddressStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.PostalAddressStatus 
  status) {
  this.status = status;
  }
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_POSTALADDRESS",joinColumns=@JoinColumn(name="ID_NOTES_POSTALADDRESS"))
        @ForeignKey(name="FK_NOTES_POSTALADDRESS")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }

   
        /**
* An associated gov.nih.nci.calims2.domain.administration.ContactInformation object.
**/
        private gov.nih.nci.calims2.domain.administration.ContactInformation contactInformation;
        /**
* Retrieves the value of the contactInformation attribute.
* @return contactInformation
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CONTACTINFORMATION_FK")
@org.hibernate.annotations.ForeignKey(name = "POSTALCONTAC_FK")

        public gov.nih.nci.calims2.domain.administration.ContactInformation getContactInformation() {
        return contactInformation;
        }
   
        /**
* Sets the value of contactInformation attribute.
* @param contactInformation .
**/
        public void setContactInformation(gov.nih.nci.calims2.domain.administration.ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.PostalAddress.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "POSTALTYPE_FK")

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
