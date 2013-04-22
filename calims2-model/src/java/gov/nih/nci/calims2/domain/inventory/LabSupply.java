/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory;
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

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.IndexColumn;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithExternalId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
/**
* 
**/

@Entity
@Table(name = "LABSUPPLY")

public class LabSupply extends DisplayableEntity implements  EntityWithNotes, EntityWithExternalId {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private org.joda.time.DateTime expirationDate;
  /**
* Retrieves the value of the expirationDate attribute.
* @return expirationDate
**/
  
  @Column(name = "EXPIRATIONDATE")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public org.joda.time.DateTime getExpirationDate() {
  return expirationDate;
  }
  /**
* Sets the value of expirationDate attribute.
* @param expirationDate .
**/
  public void setExpirationDate(org.joda.time.DateTime 
  expirationDate) {
  this.expirationDate = expirationDate;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.inventory.enumeration.LabSupplyStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.inventory.enumeration.LabSupplyStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.inventory.enumeration.LabSupplyStatus 
  status) {
  this.status = status;
  }
        private Set<gov.nih.nci.calims2.domain.administration.Quantity> quantityCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Quantity>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="QUANTITY_LABSUPPLY",joinColumns=@JoinColumn(name="ID_QUANTITY_LABSUPPLY"))
        @ForeignKey(name="FK_QUANTITY_LABSUPPLY")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.administration.Quantity> getQuantityCollection() {
        return quantityCollection;
        }
        public void setQuantityCollection(Set<gov.nih.nci.calims2.domain.administration.Quantity> quantityCollection) {
             this.quantityCollection = quantityCollection;
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
@org.hibernate.annotations.ForeignKey(name = "LABSUPTYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.common.ExternalIdentifier object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> externalIdentifierCollection = new HashSet<gov.nih.nci.calims2.domain.common.ExternalIdentifier>();
        /**
* Retrieves the value of the externalIdentifierCollection attribute.
* @return externalIdentifierCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "labSupply")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> getExternalIdentifierCollection() {
        return externalIdentifierCollection;
        }

        /**
* Sets the value of externalIdentifierCollection attribute.
* @param externalIdentifierCollection .
**/
        public void setExternalIdentifierCollection(Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> externalIdentifierCollection) {
        this.externalIdentifierCollection = externalIdentifierCollection;
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
@JoinTable(name = "LabSupply_Organization",
joinColumns = @JoinColumn(name = "LABSUPPLY_ID"),
inverseJoinColumns = @JoinColumn(name = "ORGANIZATION_ID"))
@org.hibernate.annotations.ForeignKey(name = "LABSUPPLY_ORGANIZATION_ID", inverseName = "ORGANIZATION_LABSUPPLY_ID")
        
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
* An associated gov.nih.nci.calims2.domain.inventory.Container object.
**/
        private gov.nih.nci.calims2.domain.inventory.Container container;
        /**
* Retrieves the value of the container attribute.
* @return container
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CONTAINER_FK")
@org.hibernate.annotations.ForeignKey(name = "LABSUPCONTAI_FK")

        public gov.nih.nci.calims2.domain.inventory.Container getContainer() {
        return container;
        }
   
        /**
* Sets the value of container attribute.
* @param container .
**/
        public void setContainer(gov.nih.nci.calims2.domain.inventory.Container container) {
        this.container = container;
        }
   
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_LABSUPPLY",joinColumns=@JoinColumn(name="ID_NOTES_LABSUPPLY"))
        @ForeignKey(name="FK_NOTES_LABSUPPLY")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }

    
        /**
* An associated gov.nih.nci.calims2.domain.administration.Person object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Person> personCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Person>();
        /**
* Retrieves the value of the personCollection attribute.
* @return personCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "LABSUPPLY_FK")
@org.hibernate.annotations.ForeignKey(name = "PERSONLABSUP_FK")

        
       
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
    






}
