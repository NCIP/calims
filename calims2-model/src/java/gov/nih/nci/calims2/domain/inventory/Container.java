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
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI|An object that can be used to hold things.
**/

@Entity
@Table(name = "CONTAINER")

public class Container extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* NCI|An indicator that can be set or unset in order to signal whether a particular condition is true.;To
* use again, especially after salvaging or special treatment or processing.
**/
  private Boolean isReusable;
  /**
* Retrieves the value of the isReusable attribute.
* @return isReusable
**/
  
  @Column(name = "ISREUSABLE", length = EntityWithId.COLUMNLENGTH)
  
  
  public Boolean getIsReusable() {
  return isReusable;
  }
  /**
* Sets the value of isReusable attribute.
* @param isReusable .
**/
  public void setIsReusable(Boolean 
  isReusable) {
  this.isReusable = isReusable;
  }
  /**
* 
**/
  private Boolean isTemplate;
  /**
* Retrieves the value of the isTemplate attribute.
* @return isTemplate
**/
  
  @Column(name = "ISTEMPLATE", length = EntityWithId.COLUMNLENGTH)
  
  
  public Boolean getIsTemplate() {
  return isTemplate;
  }
  /**
* Sets the value of isTemplate attribute.
* @param isTemplate .
**/
  public void setIsTemplate(Boolean 
  isTemplate) {
  this.isTemplate = isTemplate;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.inventory.enumeration.ContainerStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.inventory.enumeration.ContainerStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.inventory.enumeration.ContainerStatus 
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
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LOCATION_FK")
@org.hibernate.annotations.ForeignKey(name = "CONTAILOCATI_FK")

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
* An associated gov.nih.nci.calims2.domain.inventory.Layout object.
**/
        private gov.nih.nci.calims2.domain.inventory.Layout layout;
        /**
* Retrieves the value of the layout attribute.
* @return layout
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LAYOUT_FK")
@org.hibernate.annotations.ForeignKey(name = "CONTAILAYOUT_FK")

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
* An associated gov.nih.nci.calims2.domain.inventory.Container object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.inventory.Container> childContainerCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.Container>();
        /**
* Retrieves the value of the childContainerCollection attribute.
* @return childContainerCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "CONTAINER_FK")
@org.hibernate.annotations.ForeignKey(name = "CHILDCCONTAI_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.inventory.Container> getChildContainerCollection() {
        return childContainerCollection;
        }

        /**
* Sets the value of childContainerCollection attribute.
* @param childContainerCollection .
**/
        public void setChildContainerCollection(Set<gov.nih.nci.calims2.domain.inventory.Container> childContainerCollection) {
        this.childContainerCollection = childContainerCollection;
        }
    
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.FillPattern object.
**/
        private gov.nih.nci.calims2.domain.inventory.FillPattern fillPattern;
        /**
* Retrieves the value of the fillPattern attribute.
* @return fillPattern
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "FILLPATTERN_FK")
@org.hibernate.annotations.ForeignKey(name = "CONTAIFILLPA_FK")

        public gov.nih.nci.calims2.domain.inventory.FillPattern getFillPattern() {
        return fillPattern;
        }
   
        /**
* Sets the value of fillPattern attribute.
* @param fillPattern .
**/
        public void setFillPattern(gov.nih.nci.calims2.domain.inventory.FillPattern fillPattern) {
        this.fillPattern = fillPattern;
        }
   
        private Set<gov.nih.nci.calims2.domain.administration.Quantity> capacityCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Quantity>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="QUANTITY_CONTAINER",joinColumns=@JoinColumn(name="ID_QUANTITY_CONTAINER"))
        @ForeignKey(name="FK_QUANTITY_CONTAINER")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.administration.Quantity> getCapacityCollection() {
        return capacityCollection;
        }
        public void setCapacityCollection(Set<gov.nih.nci.calims2.domain.administration.Quantity> capacityCollection) {
             this.capacityCollection = capacityCollection;
        }

        private gov.nih.nci.calims2.domain.inventory.Coordinate coordinate;
        @Embedded
        public gov.nih.nci.calims2.domain.inventory.Coordinate getCoordinate() {
        return coordinate;
        }
        public void setCoordinate(gov.nih.nci.calims2.domain.inventory.Coordinate coordinate) {
           this.coordinate = coordinate;
        }

   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Container object.
**/
        private gov.nih.nci.calims2.domain.inventory.Container parentContainer;
        /**
* Retrieves the value of the parentContainer attribute.
* @return parentContainer
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CONTAINER_FK")
@org.hibernate.annotations.ForeignKey(name = "CHILDCCONTAI_FK")

        public gov.nih.nci.calims2.domain.inventory.Container getParentContainer() {
        return parentContainer;
        }
   
        /**
* Sets the value of parentContainer attribute.
* @param parentContainer .
**/
        public void setParentContainer(gov.nih.nci.calims2.domain.inventory.Container parentContainer) {
        this.parentContainer = parentContainer;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.ContainerType object.
**/
        private gov.nih.nci.calims2.domain.inventory.ContainerType containerType;
        /**
* Retrieves the value of the containerType attribute.
* @return containerType
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CONTAINERTYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "CONTAICONTAI_FK")

        public gov.nih.nci.calims2.domain.inventory.ContainerType getContainerType() {
        return containerType;
        }
   
        /**
* Sets the value of containerType attribute.
* @param containerType .
**/
        public void setContainerType(gov.nih.nci.calims2.domain.inventory.ContainerType containerType) {
        this.containerType = containerType;
        }
   






}
