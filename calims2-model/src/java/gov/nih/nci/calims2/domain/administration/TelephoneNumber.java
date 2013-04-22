/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.common.Type;

import org.joda.time.DateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.AttributeOverrides;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AssociationOverride;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.IndexColumn;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;
import gov.nih.nci.calims2.domain.interfaces.EntityWithExternalId;
import java.util.ArrayList;
import java.io.Serializable;



import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@Table(name = "TELEPHONENUMBER")

public class TelephoneNumber extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String rank;
  /**
* Retrieves the value of the rank attribute.
* @return rank
**/
  
  @Column(name = "RANK", length = EntityWithId.COLUMNLENGTH)
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.TelephoneNumber.rank}")
  public String getRank() {
  return rank;
  }
  /**
* Sets the value of rank attribute.
* @param rank .
**/
  public void setRank(String 
  rank) {
  this.rank = rank;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.TelephoneNumberStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.TelephoneNumber.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.TelephoneNumberStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.TelephoneNumberStatus 
  status) {
  this.status = status;
  }
  /**
* 
**/
  private String telephoneNumberExtension;
  /**
* Retrieves the value of the telephoneNumberExtension attribute.
* @return telephoneNumberExtension
**/
  
  @Column(name = "TELEPHONENUMBEREXTENSION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getTelephoneNumberExtension() {
  return telephoneNumberExtension;
  }
  /**
* Sets the value of telephoneNumberExtension attribute.
* @param telephoneNumberExtension .
**/
  public void setTelephoneNumberExtension(String 
  telephoneNumberExtension) {
  this.telephoneNumberExtension = telephoneNumberExtension;
  }
  /**
* 
**/
  private String value;
  /**
* Retrieves the value of the value attribute.
* @return value
**/
  
  @Column(name = "VALUE", length = EntityWithId.COLUMNLENGTH)
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.TelephoneNumber.value}")
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
* An associated gov.nih.nci.calims2.domain.administration.ContactInformation object.
**/
        private gov.nih.nci.calims2.domain.administration.ContactInformation contactInformation;
        /**
* Retrieves the value of the contactInformation attribute.
* @return contactInformation
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CONTACTINFORMATION_FK")
@org.hibernate.annotations.ForeignKey(name = "TELEPHCONTAC_FK")

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
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "TELEPHTYPE_FK")

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
