/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
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
* 
**/

@Entity
@Table(name = "CONTAINERTYPE")

public class ContainerType extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition composition;
  /**
* Retrieves the value of the composition attribute.
* @return composition
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "COMPOSITION", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition getComposition() {
  return composition;
  }
  /**
* Sets the value of composition attribute.
* @param composition .
**/
  public void setComposition(gov.nih.nci.calims2.domain.inventory.enumeration.ContainerComposition 
  composition) {
  this.composition = composition;
  }

        /**
* An associated gov.nih.nci.calims2.domain.inventory.ContainerType object.
**/
        private gov.nih.nci.calims2.domain.inventory.ContainerType childContainerType;
        /**
* Retrieves the value of the childContainerType attribute.
* @return childContainerType
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CONTAINERTYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "_CONTAINERTY_FK")

        public gov.nih.nci.calims2.domain.inventory.ContainerType getChildContainerType() {
        return childContainerType;
        }
   
        /**
* Sets the value of childContainerType attribute.
* @param childContainerType .
**/
        public void setChildContainerType(gov.nih.nci.calims2.domain.inventory.ContainerType childContainerType) {
        this.childContainerType = childContainerType;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Layout object.
**/
        private gov.nih.nci.calims2.domain.inventory.Layout defaultLayout;
        /**
* Retrieves the value of the defaultLayout attribute.
* @return defaultLayout
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LAYOUT_FK")
@org.hibernate.annotations.ForeignKey(name = "RELATELAYOUT_FK")

        public gov.nih.nci.calims2.domain.inventory.Layout getDefaultLayout() {
        return defaultLayout;
        }
   
        /**
* Sets the value of defaultLayout attribute.
* @param defaultLayout .
**/
        public void setDefaultLayout(gov.nih.nci.calims2.domain.inventory.Layout defaultLayout) {
        this.defaultLayout = defaultLayout;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.ContainerSubcategory object.
**/
        private gov.nih.nci.calims2.domain.inventory.ContainerSubcategory containerSubcategory;
        /**
* Retrieves the value of the containerSubcategory attribute.
* @return containerSubcategory
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CONTAINERSUBCATEGORY_FK")
@org.hibernate.annotations.ForeignKey(name = "CONTAICONTAI_FK")

        public gov.nih.nci.calims2.domain.inventory.ContainerSubcategory getContainerSubcategory() {
        return containerSubcategory;
        }
   
        /**
* Sets the value of containerSubcategory attribute.
* @param containerSubcategory .
**/
        public void setContainerSubcategory(gov.nih.nci.calims2.domain.inventory.ContainerSubcategory containerSubcategory) {
        this.containerSubcategory = containerSubcategory;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Layout object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.inventory.Layout> layoutCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.Layout>();
        /**
* Retrieves the value of the layoutCollection attribute.
* @return layoutCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "ContainerType_Layout",
joinColumns = @JoinColumn(name = "CONTAINERTYPE_ID"),
inverseJoinColumns = @JoinColumn(name = "LAYOUT_ID"))
@org.hibernate.annotations.ForeignKey(name = "CONTAINERTYP_LAYOUT_ID", inverseName = "LAYOUT_CONTAINERTYP_ID")
        
       
        public Set<gov.nih.nci.calims2.domain.inventory.Layout> getLayoutCollection() {
        return layoutCollection;
        }
    
        /**
* Sets the value of layoutCollection attribute.
* @param layoutCollection .
**/
        public void setLayoutCollection(Set<gov.nih.nci.calims2.domain.inventory.Layout> layoutCollection) {
        this.layoutCollection = layoutCollection;
        }
    






}
