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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI|A position, site, or point in space where something can be found.
**/

@Entity
@Table(name = "LOCATION") 

public class Location extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.LocationStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Location.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.LocationStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.LocationStatus 
  status) {
  this.status = status;
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
  
  @Pattern(regexp = ".*[\\S].*", message = "{Pattern.gov.nih.nci.calims2.domain.administration.Location.value}")
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
* An associated gov.nih.nci.calims2.domain.administration.ContactInformation object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.ContactInformation> contactInformationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.ContactInformation>();
        /**
* Retrieves the value of the contactInformationCollection attribute.
* @return contactInformationCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.administration.ContactInformation> getContactInformationCollection() {
        return contactInformationCollection;
        }

        /**
* Sets the value of contactInformationCollection attribute.
* @param contactInformationCollection .
**/
        public void setContactInformationCollection(Set<gov.nih.nci.calims2.domain.administration.ContactInformation> contactInformationCollection) {
        this.contactInformationCollection = contactInformationCollection;
        }
    
    
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "location")
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
* An associated gov.nih.nci.calims2.domain.administration.Location object.
**/
        private gov.nih.nci.calims2.domain.administration.Location parentLocation;
        /**
* Retrieves the value of the parentLocation attribute.
* @return parentLocation
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LOCATION_FK")
@org.hibernate.annotations.ForeignKey(name = "CHILDLLOCATI_FK")

        public gov.nih.nci.calims2.domain.administration.Location getParentLocation() {
        return parentLocation;
        }
   
        /**
* Sets the value of parentLocation attribute.
* @param parentLocation .
**/
        public void setParentLocation(gov.nih.nci.calims2.domain.administration.Location parentLocation) {
        this.parentLocation = parentLocation;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Location.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "LOCATITYPE_FK")

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