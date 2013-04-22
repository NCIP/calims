/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory.event;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.IndexColumn;

import gov.nih.nci.calims2.domain.interfaces.AuditableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
import gov.nih.nci.calims2.domain.inventory.visitor.EventVisitor;
/**
* 
**/

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="entitytype",     discriminatorType=DiscriminatorType.STRING, length=30)
@DiscriminatorValue("Event")

public class Event extends AuditableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String description;
  /**
* Retrieves the value of the description attribute.
* @return description
**/
  
  @Column(name = "DESCRIPTION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getDescription() {
  return description;
  }
  /**
* Sets the value of description attribute.
* @param description .
**/
  public void setDescription(String 
  description) {
  this.description = description;
  }
  /**
* 
**/
  private String displayName;
  /**
* Retrieves the value of the displayName attribute.
* @return displayName
**/
  
  @Column(name = "DISPLAYNAME", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getDisplayName() {
  return displayName;
  }
  /**
* Sets the value of displayName attribute.
* @param displayName .
**/
  public void setDisplayName(String 
  displayName) {
  this.displayName = displayName;
  }
  /**
* 
**/
  private String name;
  /**
* Retrieves the value of the name attribute.
* @return name
**/
  
  @Column(name = "NAME", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getName() {
  return name;
  }
  /**
* Sets the value of name attribute.
* @param name .
**/
  public void setName(String 
  name) {
  this.name = name;
  }
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.WholeOrganism object.
**/
        private gov.nih.nci.calims2.domain.inventory.WholeOrganism wholeOrganism;
        /**
* Retrieves the value of the wholeOrganism attribute.
* @return wholeOrganism
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "WHOLEORGANISM_FK")
@org.hibernate.annotations.ForeignKey(name = "EVENTCWHOLEO_FK")

        public gov.nih.nci.calims2.domain.inventory.WholeOrganism getWholeOrganism() {
        return wholeOrganism;
        }
   
        /**
* Sets the value of wholeOrganism attribute.
* @param wholeOrganism .
**/
        public void setWholeOrganism(gov.nih.nci.calims2.domain.inventory.WholeOrganism wholeOrganism) {
        this.wholeOrganism = wholeOrganism;
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
@org.hibernate.annotations.ForeignKey(name = "EVENTCCONTAI_FK")

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
   
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.LabSupply object.
**/
        private gov.nih.nci.calims2.domain.inventory.LabSupply labSupply;
        /**
* Retrieves the value of the labSupply attribute.
* @return labSupply
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LABSUPPLY_FK")
@org.hibernate.annotations.ForeignKey(name = "EVENTCLABSUP_FK")

        public gov.nih.nci.calims2.domain.inventory.LabSupply getLabSupply() {
        return labSupply;
        }
   
        /**
* Sets the value of labSupply attribute.
* @param labSupply .
**/
        public void setLabSupply(gov.nih.nci.calims2.domain.inventory.LabSupply labSupply) {
        this.labSupply = labSupply;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Person object.
**/
        private gov.nih.nci.calims2.domain.administration.Person operator;
        /**
* Retrieves the value of the operator attribute.
* @return operator
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "EVENTCPERSON_FK")

        public gov.nih.nci.calims2.domain.administration.Person getOperator() {
        return operator;
        }
   
        /**
* Sets the value of operator attribute.
* @param operator .
**/
        public void setOperator(gov.nih.nci.calims2.domain.administration.Person operator) {
        this.operator = operator;
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
@org.hibernate.annotations.ForeignKey(name = "EVENTCTYPE_FK")

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
        private gov.nih.nci.calims2.domain.administration.Location location;
        /**
* Retrieves the value of the location attribute.
* @return location
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LOCATION_FK")
@org.hibernate.annotations.ForeignKey(name = "EVENTCLOCATI_FK")

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
   
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_EVENT",joinColumns=@JoinColumn(name="ID_NOTES_EVENT"))
        @ForeignKey(name="FK_NOTES_EVENT")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }

   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Specimen object.
**/
        private gov.nih.nci.calims2.domain.inventory.Specimen specimen;
        /**
* Retrieves the value of the specimen attribute.
* @return specimen
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SPECIMEN_FK")
@org.hibernate.annotations.ForeignKey(name = "EVENTCSPECIM_FK")

        public gov.nih.nci.calims2.domain.inventory.Specimen getSpecimen() {
        return specimen;
        }
   
        /**
* Sets the value of specimen attribute.
* @param specimen .
**/
        public void setSpecimen(gov.nih.nci.calims2.domain.inventory.Specimen specimen) {
        this.specimen = specimen;
        }
   





/** Accepts the EventVisitor.
 * @param eventVisitor The EventVisitor to accept.
 **/ public void accept(EventVisitor eventVisitor) {
       eventVisitor.visitEvent(this);
}

}
