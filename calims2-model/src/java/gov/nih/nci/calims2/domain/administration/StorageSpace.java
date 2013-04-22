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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI|The act of safekeeping goods in a depository.;NCI|An empty area; an area set apart or available for
* use.
**/

@Entity
@Table(name = "STORAGESPACE")

public class StorageSpace extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.StorageSpaceStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.StorageSpace.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.StorageSpaceStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.StorageSpaceStatus 
  status) {
  this.status = status;
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
@JoinTable(name = "StorageSpace_Organization",
joinColumns = @JoinColumn(name = "STORAGESPACE_ID"),
inverseJoinColumns = @JoinColumn(name = "ORGANIZATION_ID"))
@org.hibernate.annotations.ForeignKey(name = "STORAGESPACE_ORGANIZATION_ID", inverseName = "ORGANIZATION_STORAGESPACE_ID")
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.StorageSpace.organizationCollection}")
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
* An associated gov.nih.nci.calims2.domain.administration.Person object.
**/
        private gov.nih.nci.calims2.domain.administration.Person contactPerson;
        /**
* Retrieves the value of the contactPerson attribute.
* @return contactPerson
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.StorageSpace.contactPerson}")
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "STORAGESPACE_PERSON_FK")

        public gov.nih.nci.calims2.domain.administration.Person getContactPerson() {
        return contactPerson;
        }
   
        /**
* Sets the value of contactPerson attribute.
* @param contactPerson .
**/
        public void setContactPerson(gov.nih.nci.calims2.domain.administration.Person contactPerson) {
        this.contactPerson = contactPerson;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type type;
        /**
* Retrieves the value of the type attribute.
* @return type
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.StorageSpace.type}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "STORAGTYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.administration.Location object.
**/
        private gov.nih.nci.calims2.domain.administration.Location internalLocation;
        /**
* Retrieves the value of the internalLocation attribute.
* @return internalLocation
**/
        @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.StorageSpace.internalLocationCollection}")
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LOCATION_FK")
@org.hibernate.annotations.ForeignKey(name = "STORAGLOCATI_FK")

        public gov.nih.nci.calims2.domain.administration.Location getInternalLocation() {
        return internalLocation;
        }
   
        /**
* Sets the value of internalLocation attribute.
* @param internalLocation .
**/
        public void setInternalLocation(gov.nih.nci.calims2.domain.administration.Location internalLocation) {
        this.internalLocation = internalLocation;
        }
   

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Layout object.
**/
        private gov.nih.nci.calims2.domain.inventory.Layout layout;
        /**
* Retrieves the value of the layout attribute.
* @return layout
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LAYOUT_FK")
@org.hibernate.annotations.ForeignKey(name = "STORAGESPACE_LAYOUT_FK")

        public gov.nih.nci.calims2.domain.inventory.Layout getLayout() {
        return layout;
        }
   
        /**
* Sets the value of layout attribute.
* @param layout .
**/
        public void setLayout(gov.nih.nci.calims2.domain.inventory.Layout layout) {
        this.layout = layout;
        }
    
        /**
* An associated gov.nih.nci.calims2.domain.common.ElectronicDocument object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.ElectronicDocument> manualCollection = new HashSet<gov.nih.nci.calims2.domain.common.ElectronicDocument>();
        /**
* Retrieves the value of the manualCollection attribute.
* @return manualCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "STORAGESPACE_FK")
@org.hibernate.annotations.ForeignKey(name = "MANUALSTORAG_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.common.ElectronicDocument> getManualCollection() {
        return manualCollection;
        }

        /**
* Sets the value of manualCollection attribute.
* @param manualCollection .
**/
        public void setManualCollection(Set<gov.nih.nci.calims2.domain.common.ElectronicDocument> manualCollection) {
        this.manualCollection = manualCollection;
        }
    






}