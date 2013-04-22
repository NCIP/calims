/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import java.util.Collection;

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
* A workplace for the conduct of scientific research.
**/

@Entity
@Table(name = "LABORATORY")

public class Laboratory extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.LaboratoryStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Laboratory.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.LaboratoryStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.LaboratoryStatus 
  status) {
  this.status = status;
  }

        /**
* An associated gov.nih.nci.calims2.domain.administration.Location object.
**/
        private gov.nih.nci.calims2.domain.administration.Location location;
        /**
* Retrieves the value of the location attribute.
* @return location
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LOCATION_FK")
@org.hibernate.annotations.ForeignKey(name = "LABORATORY_LOCATION_FK")

        public gov.nih.nci.calims2.domain.administration.Location getLocation() {
        return location;
        }
   
        /**
* Sets the value of location attribute.
* @param location .
**/
        public void setLocation(gov.nih.nci.calims2.domain.administration.Location location) {
        this.location = location;
        }
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.ContactInformation object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.ContactInformation> contactInformationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.ContactInformation>();
        /**
* Retrieves the value of the contactInformationCollection attribute.
* @return contactInformationCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "laboratory")
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
* An associated gov.nih.nci.calims2.domain.administration.Person object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Person> personCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Person>();
        /**
* Retrieves the value of the personCollection attribute.
* @return personCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "Laboratory_Person",
joinColumns = @JoinColumn(name = "LABORATORY_ID"),
inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
@org.hibernate.annotations.ForeignKey(name = "LABORATORY_PERSON_ID", inverseName = "PERSON_LABORATORY_ID")
        
        public Set<gov.nih.nci.calims2.domain.administration.Person> getPersonCollection() {
        return personCollection;
        }
    
        /**
* Sets the value of personCollection attribute.
* @param personCollection .
**/
        public void setPersonCollection(Set<gov.nih.nci.calims2.domain.administration.Person> personCollection) {
        this.personCollection = personCollection;
        }
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.Organization object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Organization> organizationCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Organization>();
        /**
* Retrieves the value of the organizationCollection attribute.
* @return organizationCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "Laboratory_Organization",
joinColumns = @JoinColumn(name = "LABORATORY_ID"),
inverseJoinColumns = @JoinColumn(name = "ORGANIZATION_ID"))
@org.hibernate.annotations.ForeignKey(name = "LABORATORY_ORGANIZATION_ID", inverseName = "ORGANIZATION_LABORATORY_ID")
        
        public Set<gov.nih.nci.calims2.domain.administration.Organization> getOrganizationCollection() {
        return organizationCollection;
        }
    
        /**
* Sets the value of organizationCollection attribute.
* @param organizationCollection .
**/
        public void setOrganizationCollection(Set<gov.nih.nci.calims2.domain.administration.Organization> organizationCollection) {
        this.organizationCollection = organizationCollection;
        }
    
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.Role object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Role> roleCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Role>();
        /**
* Retrieves the value of the roleCollection attribute.
* @return roleCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "LABORATORY_FK")
@org.hibernate.annotations.ForeignKey(name = "ROLECOLABORA_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Role> getRoleCollection() {
        return roleCollection;
        }

        /**
* Sets the value of roleCollection attribute.
* @param roleCollection .
**/
        public void setRoleCollection(Set<gov.nih.nci.calims2.domain.administration.Role> roleCollection) {
        this.roleCollection = roleCollection;
        }
    






}
