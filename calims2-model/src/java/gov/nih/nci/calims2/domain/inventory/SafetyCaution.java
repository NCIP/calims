package gov.nih.nci.calims2.domain.inventory;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
* NCI|The state of being certain that adverse effects will not be caused by some agent under defined conditions.;
* NCI|Cautionary advice about something.
**/

@Entity
@Table(name = "SAFETYCAUTION")

public class SafetyCaution extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_SAFETYCAUTION",joinColumns=@JoinColumn(name="ID_NOTES_SAFETYCAUTION"))
        @ForeignKey(name="FK_NOTES_SAFETYCAUTION")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }

        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "SafetyCaution_Document",
joinColumns = @JoinColumn(name = "SAFETYCAUTION_ID"),
inverseJoinColumns = @JoinColumn(name = "DOCUMENT_ID"))
@org.hibernate.annotations.ForeignKey(name = "SAFETYCAUTIO_DOCUMENT_ID", inverseName = "DOCUMENT_SAFETYCAUTIO_ID")
        
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
* An associated gov.nih.nci.calims2.domain.administration.Person object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Person> contactPersonCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Person>();
        /**
* Retrieves the value of the contactPersonCollection attribute.
* @return contactPersonCollection
**/
        @ManyToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinTable(name = "SafetyCaution_Person",
joinColumns = @JoinColumn(name = "SAFETYCAUTION_ID"),
inverseJoinColumns = @JoinColumn(name = "PERSON_ID"))
@org.hibernate.annotations.ForeignKey(name = "SAFETYCAUTIO_PERSON_ID", inverseName = "PERSON_SAFETYCAUTIO_ID")
        
        public Set<gov.nih.nci.calims2.domain.administration.Person> getContactPersonCollection() {
        return contactPersonCollection;
        }
    
        /**
* Sets the value of contactPersonCollection attribute.
* @param contactPersonCollection .
**/
        public void setContactPersonCollection(Set<gov.nih.nci.calims2.domain.administration.Person> contactPersonCollection) {
        this.contactPersonCollection = contactPersonCollection;
        }
    

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Hazard object.
**/
        private gov.nih.nci.calims2.domain.inventory.Hazard hazard;
        /**
* Retrieves the value of the hazard attribute.
* @return hazard
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "HAZARD_FK")
@org.hibernate.annotations.ForeignKey(name = "SAFETYCAUTI_HAZARD_FK")

        public gov.nih.nci.calims2.domain.inventory.Hazard getHazard() {
        return hazard;
        }
   
        /**
* Sets the value of hazard attribute.
* @param hazard .
**/
        public void setHazard(gov.nih.nci.calims2.domain.inventory.Hazard hazard) {
        this.hazard = hazard;
        }






}
