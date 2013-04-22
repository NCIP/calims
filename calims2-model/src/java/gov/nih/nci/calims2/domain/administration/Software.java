/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
* NCI|A set of coded instructions, which a computer follows in processing data, performing an operation,
* or solving a logical problem, upon execution of the program.
**/

@Entity
@Table(name = "SOFTWARE")

public class Software extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
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
  private Integer numberOfUsers;
  /**
* Retrieves the value of the numberOfUsers attribute.
* @return numberOfUsers
**/
  
  @Column(name = "NUMBEROFUSERS", length = EntityWithId.COLUMNLENGTH)
  
  
  public Integer getNumberOfUsers() {
  return numberOfUsers;
  }
  /**
* Sets the value of numberOfUsers attribute.
* @param numberOfUsers .
**/
  public void setNumberOfUsers(Integer 
  numberOfUsers) {
  this.numberOfUsers = numberOfUsers;
  }
  /**
* 
**/
  private String operatingSystem;
  /**
* Retrieves the value of the operatingSystem attribute.
* @return operatingSystem
**/
  
  @Column(name = "OPERATINGSYSTEM", length = EntityWithId.COLUMNLENGTH)
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.Software.operatingSystem}")
  public String getOperatingSystem() {
  return operatingSystem;
  }
  /**
* Sets the value of operatingSystem attribute.
* @param operatingSystem .
**/
  public void setOperatingSystem(String 
  operatingSystem) {
  this.operatingSystem = operatingSystem;
  }
  /**
* 
**/
  private String serialNumber;
  /**
* Retrieves the value of the serialNumber attribute.
* @return serialNumber
**/
  
  @Column(name = "SERIALNUMBER", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getSerialNumber() {
  return serialNumber;
  }
  /**
* Sets the value of serialNumber attribute.
* @param serialNumber .
**/
  public void setSerialNumber(String 
  serialNumber) {
  this.serialNumber = serialNumber;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.SoftwareStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Software.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.SoftwareStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.SoftwareStatus 
  status) {
  this.status = status;
  }
  /**
* 
**/
  private String version;
  /**
* Retrieves the value of the version attribute.
* @return version
**/
  
  @Column(name = "VERSION", length = EntityWithId.COLUMNLENGTH)
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.Software.version}")
  public String getVersion() {
  return version;
  }
  /**
* Sets the value of version attribute.
* @param version .
**/
  public void setVersion(String 
  version) {
  this.version = version;
  }
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_SOFTWARE",joinColumns=@JoinColumn(name="ID_NOTES_SOFTWARE"))
        @ForeignKey(name="FK_NOTES_SOFTWARE")
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
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Software.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "SOFTWATYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.common.Parameter object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Parameter> parameterCollection = new HashSet<gov.nih.nci.calims2.domain.common.Parameter>();
        /**
* Retrieves the value of the parameterCollection attribute.
* @return parameterCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "SOFTWARE_FK")
@org.hibernate.annotations.ForeignKey(name = "PARAMESOFTWA_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.common.Parameter> getParameterCollection() {
        return parameterCollection;
        }

        /**
* Sets the value of parameterCollection attribute.
* @param parameterCollection .
**/
        public void setParameterCollection(Set<gov.nih.nci.calims2.domain.common.Parameter> parameterCollection) {
        this.parameterCollection = parameterCollection;
        }
    






}
