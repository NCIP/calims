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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
* NCI|The usual or expected function of something or someone; the part something plays in an action or
* event.
**/

@Entity
@Table(name = "ROLE")

public class Role extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.RoleStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Role.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.RoleStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.RoleStatus 
  status) {
  this.status = status;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.RoleType type;
  /**
* Retrieves the value of the type attribute.
* @return type
**/
  
  @Column(name = "TYPE", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Role.type}")
  public gov.nih.nci.calims2.domain.administration.enumeration.RoleType getType() {
  return type;
  }
  /**
* Sets the value of type attribute.
* @param type .
**/
  public void setType(gov.nih.nci.calims2.domain.administration.enumeration.RoleType 
  type) {
  this.type = type;
  }
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_ROLE",joinColumns=@JoinColumn(name="ID_NOTES_ROLE"))
        @ForeignKey(name="FK_NOTES_ROLE")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }







}
