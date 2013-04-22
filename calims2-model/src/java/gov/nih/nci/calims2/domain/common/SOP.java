/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.common;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.interfaces.EntityWithNotes;
/**
* NCI|An established procedure to be followed in carrying out a given operation or in a given situation.
**/

@Entity
@Table(name = "SOP")

public class SOP extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String content;
  /**
* Retrieves the value of the content attribute.
* @return content
**/
  
  @Column(name = "CONTENT", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getContent() {
  return content;
  }
  /**
* Sets the value of content attribute.
* @param content .
**/
  public void setContent(String 
  content) {
  this.content = content;
  }
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
* An associated gov.nih.nci.calims2.domain.common.Document object.
**/
        private gov.nih.nci.calims2.domain.common.Document document;
        /**
* Retrieves the value of the document attribute.
* @return document
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "DOCUMENT_FK")
@org.hibernate.annotations.ForeignKey(name = "SOP_DOCUMENT_FK")

        public gov.nih.nci.calims2.domain.common.Document getDocument() {
        return document;
        }
   
        /**
* Sets the value of document attribute.
* @param document .
**/
        public void setDocument(gov.nih.nci.calims2.domain.common.Document document) {
        this.document = document;
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
@org.hibernate.annotations.ForeignKey(name = "SOP_PERSON_FK")

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
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_SOP",joinColumns=@JoinColumn(name="ID_NOTES_SOP"))
        @ForeignKey(name="FK_NOTES_SOP")
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
@org.hibernate.annotations.ForeignKey(name = "SOPCOLTYPE_FK")

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
   






}
