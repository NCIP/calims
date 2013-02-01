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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.IndexColumn;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
/**
* NCI|A plan or design of something that is laid out.
**/

@Entity
@Table(name = "LAYOUT")

public class Layout extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* NCI|The magnitude of something in a horizontal direction.
**/
  private Integer x_dimension;
  /**
* Retrieves the value of the x_dimension attribute.
* @return x_dimension
**/
  
  @Column(name = "X_DIMENSION", length = EntityWithId.COLUMNLENGTH)
  
  
  public Integer getX_dimension() {
  return x_dimension;
  }
  /**
* Sets the value of x_dimension attribute.
* @param x_dimension .
**/
  public void setX_dimension(Integer 
  x_dimension) {
  this.x_dimension = x_dimension;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType x_dimensionLabel;
  /**
* Retrieves the value of the x_dimensionLabel attribute.
* @return x_dimensionLabel
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "X_DIMENSIONLABEL", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.inventory.Layout.x_dimensionLabel}")
  public gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType getX_dimensionLabel() {
  return x_dimensionLabel;
  }
  /**
* Sets the value of x_dimensionLabel attribute.
* @param x_dimensionLabel .
**/
  public void setX_dimensionLabel(gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType 
  x_dimensionLabel) {
  this.x_dimensionLabel = x_dimensionLabel;
  }
  /**
* NCI|The magnitude of something in a vertical direction.
**/
  private Integer y_dimension;
  /**
* Retrieves the value of the y_dimension attribute.
* @return y_dimension
**/
  
  @Column(name = "Y_DIMENSION", length = EntityWithId.COLUMNLENGTH)
  
  
  public Integer getY_dimension() {
  return y_dimension;
  }
  /**
* Sets the value of y_dimension attribute.
* @param y_dimension .
**/
  public void setY_dimension(Integer 
  y_dimension) {
  this.y_dimension = y_dimension;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType y_dimensionLabel;
  /**
* Retrieves the value of the y_dimensionLabel attribute.
* @return y_dimensionLabel
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "Y_DIMENSIONLABEL", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.inventory.Layout.y_dimensionLabel}")
  public gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType getY_dimensionLabel() {
  return y_dimensionLabel;
  }
  /**
* Sets the value of y_dimensionLabel attribute.
* @param y_dimensionLabel .
**/
  public void setY_dimensionLabel(gov.nih.nci.calims2.domain.inventory.enumeration.LayoutLabelType 
  y_dimensionLabel) {
  this.y_dimensionLabel = y_dimensionLabel;
  }
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_LAYOUT",joinColumns=@JoinColumn(name="ID_NOTES_LAYOUT"))
        @ForeignKey(name="FK_NOTES_LAYOUT")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }


        /**
* An associated gov.nih.nci.calims2.domain.administration.Person object.
**/
        private gov.nih.nci.calims2.domain.administration.Person person;
        /**
* Retrieves the value of the person attribute.
* @return person
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "LAYOUT_PERSON_FK")

        public gov.nih.nci.calims2.domain.administration.Person getPerson() {
        return person;
        }
   
        /**
* Sets the value of person attribute.
* @param person .
**/
        public void setPerson(gov.nih.nci.calims2.domain.administration.Person person) {
        this.person = person;
        }
        /**
* An associated gov.nih.nci.calims2.domain.inventory.ContainerType object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.inventory.ContainerType> containerTypeCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.ContainerType>();
        /**
* Retrieves the value of the containerTypeCollection attribute.
* @return containerTypeCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "ContainerType_Layout",
joinColumns = @JoinColumn(name = "LAYOUT_ID"),
inverseJoinColumns = @JoinColumn(name = "CONTAINERTYPE_ID"))
@org.hibernate.annotations.ForeignKey(name = "LAYOUT_CONTAINERTYP_ID", inverseName = "CONTAINERTYP_LAYOUT_ID")
        
       
        public Set<gov.nih.nci.calims2.domain.inventory.ContainerType> getContainerTypeCollection() {
        return containerTypeCollection;
        }
    
        /**
* Sets the value of containerTypeCollection attribute.
* @param containerTypeCollection .
**/
        public void setContainerTypeCollection(Set<gov.nih.nci.calims2.domain.inventory.ContainerType> containerTypeCollection) {
        this.containerTypeCollection = containerTypeCollection;
        }
    






}
