/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.IndexColumn;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
/**
* A source of danger. http://www.merriam-webster.com/dictionary/hazard.
**/

@Entity
@Table(name = "HAZARD")
@Inheritance(strategy = InheritanceType.JOINED)
public class Hazard extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_HAZARD",joinColumns=@JoinColumn(name="ID_NOTES_HAZARD"))
        @ForeignKey(name="FK_NOTES_HAZARD")
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
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "HAZARDTYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.inventory.LabSupply object.
**/
        private gov.nih.nci.calims2.domain.inventory.LabSupply labSupply;
        /**
* Retrieves the value of the labSupply attribute.
* @return labSupply
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LABSUPPLY_FK")
@org.hibernate.annotations.ForeignKey(name = "HAZARDLABSUP_FK")

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
* An associated gov.nih.nci.calims2.domain.inventory.Specimen object.
**/
        private gov.nih.nci.calims2.domain.inventory.Specimen specimen;
        /**
* Retrieves the value of the specimen attribute.
* @return specimen
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SPECIMEN_FK")
@org.hibernate.annotations.ForeignKey(name = "HAZARDSPECIM_FK")

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
   

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Container object.
**/
        private gov.nih.nci.calims2.domain.inventory.Container container;
        /**
* Retrieves the value of the container attribute.
* @return container
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CONTAINER_FK")
@org.hibernate.annotations.ForeignKey(name = "HAZARD_CONTAINER_FK")

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






}
