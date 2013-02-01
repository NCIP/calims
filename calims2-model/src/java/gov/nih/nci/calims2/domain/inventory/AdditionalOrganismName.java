package gov.nih.nci.calims2.domain.inventory;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
@Table(name = "ADDITIONALORGANISMNAME")

public class AdditionalOrganismName extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String comment;
  /**
* Retrieves the value of the comment attribute.
* @return comment
**/
  
  @Column(name = "COMMENT", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getComment() {
  return comment;
  }
  /**
* Sets the value of comment attribute.
* @param comment .
**/
  public void setComment(String 
  comment) {
  this.comment = comment;
  }
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
  private org.joda.time.DateTime dateAssigned;
  /**
* Retrieves the value of the dateAssigned attribute.
* @return dateAssigned
**/
  
  @Column(name = "DATEASSIGNED")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public org.joda.time.DateTime getDateAssigned() {
  return dateAssigned;
  }
  /**
* Sets the value of dateAssigned attribute.
* @param dateAssigned .
**/
  public void setDateAssigned(org.joda.time.DateTime 
  dateAssigned) {
  this.dateAssigned = dateAssigned;
  }
  /**
* 
**/
  private Boolean isCurrentName;
  /**
* Retrieves the value of the isCurrentName attribute.
* @return isCurrentName
**/
  
  @Column(name = "ISCURRENTNAME", length = EntityWithId.COLUMNLENGTH)
  
  
  public Boolean getIsCurrentName() {
  return isCurrentName;
  }
  /**
* Sets the value of isCurrentName attribute.
* @param isCurrentName .
**/
  public void setIsCurrentName(Boolean 
  isCurrentName) {
  this.isCurrentName = isCurrentName;
  }
  /**
* 
**/
  private String source;
  /**
* Retrieves the value of the source attribute.
* @return source
**/
  
  @Column(name = "SOURCE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getSource() {
  return source;
  }
  /**
* Sets the value of source attribute.
* @param source .
**/
  public void setSource(String 
  source) {
  this.source = source;
  }
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_ADDITIONALORGANISMN",joinColumns=@JoinColumn(name="ID_NOTES_ADDITIONALORGANI"))
        @ForeignKey(name="FK_NOTES_ADDITIONALORGANI")
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
@org.hibernate.annotations.ForeignKey(name = "ADDITITYPE_FK")

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
