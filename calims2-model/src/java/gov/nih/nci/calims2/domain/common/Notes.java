/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.common;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI|A brief written record;.
**/

@Embeddable
public class Notes  implements  Serializable {
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
  private String createdBy;
  /**
* Retrieves the value of the createdBy attribute.
* @return createdBy
**/
  
  @Column(name = "CREATEDBY", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getCreatedBy() {
  return createdBy;
  }
  /**
* Sets the value of createdBy attribute.
* @param createdBy .
**/
  public void setCreatedBy(String 
  createdBy) {
  this.createdBy = createdBy;
  }
  /**
* 
**/
  private org.joda.time.DateTime dateCreated;
  /**
* Retrieves the value of the dateCreated attribute.
* @return dateCreated
**/
  
  @Column(name = "DATECREATED")
@org.hibernate.annotations.Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  
  
  public org.joda.time.DateTime getDateCreated() {
  return dateCreated;
  }
  /**
* Sets the value of dateCreated attribute.
* @param dateCreated .
**/
  public void setDateCreated(org.joda.time.DateTime 
  dateCreated) {
  this.dateCreated = dateCreated;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.common.enumeration.NotesStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.common.enumeration.NotesStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.common.enumeration.NotesStatus 
  status) {
  this.status = status;
  }






}