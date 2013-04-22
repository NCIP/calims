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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.IndexColumn;

import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
/**
* 
**/

@Entity
@Table(name = "ADAPTER")

public class Adapter extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String version;
  /**
* Retrieves the value of the version attribute.
* @return version
**/
  
  @Column(name = "VERSION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getVersion() {
  return version;
  }
  /**
* Sets the value of version attribute.
* @param version .
**/
  public void setVersion(String 
  version) {
  this.version = version;
  }

        /**
* An associated gov.nih.nci.calims2.domain.administration.FileFormatSpecification object.
**/
        private gov.nih.nci.calims2.domain.administration.FileFormatSpecification fileFormatSpecification;
        /**
* Retrieves the value of the fileFormatSpecification attribute.
* @return fileFormatSpecification
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "FILEFORMATSPECIFICATION_FK")
@org.hibernate.annotations.ForeignKey(name = "ADAPTER_FILEFORMATS_FK")

        public gov.nih.nci.calims2.domain.administration.FileFormatSpecification getFileFormatSpecification() {
        return fileFormatSpecification;
        }
   
        /**
* Sets the value of fileFormatSpecification attribute.
* @param fileFormatSpecification .
**/
        public void setFileFormatSpecification(gov.nih.nci.calims2.domain.administration.FileFormatSpecification fileFormatSpecification) {
        this.fileFormatSpecification = fileFormatSpecification;
        }
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_ADAPTER",joinColumns=@JoinColumn(name="ID_NOTES_ADAPTER"))
        @ForeignKey(name="FK_NOTES_ADAPTER")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }


        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.
**/
        private gov.nih.nci.calims2.domain.common.Document reference;
        /**
* Retrieves the value of the reference attribute.
* @return reference
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "DOCUMENT_FK")
@org.hibernate.annotations.ForeignKey(name = "ADAPTER_DOCUMENT_FK")

        public gov.nih.nci.calims2.domain.common.Document getReference() {
        return reference;
        }
   
        /**
* Sets the value of reference attribute.
* @param reference .
**/
        public void setReference(gov.nih.nci.calims2.domain.common.Document reference) {
        this.reference = reference;
        }

        /**
* An associated gov.nih.nci.calims2.domain.administration.Person object.
**/
        private gov.nih.nci.calims2.domain.administration.Person contactPerson;
        /**
* Retrieves the value of the contactPerson attribute.
* @return contactPerson
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "ADAPTER_PERSON_FK")

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






}
