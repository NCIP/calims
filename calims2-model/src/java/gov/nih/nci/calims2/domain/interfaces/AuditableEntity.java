/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.domain.interfaces;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * Default implementation of Auditable interface.
 * To be extended by all auditable persistent classes.
 * 
 * @author viseem
 * 
 */
@MappedSuperclass
public abstract class AuditableEntity extends SimpleEntity implements Auditable {

  private static final long serialVersionUID = 4361085195126434809L;
  
  private DateTime dateCreated;
  private String createdBy;
  private DateTime dateModified;
  private String modifiedBy;

  /**
   * @return the dateCreated
   */
  @Column(name = "DATECREATED")
  @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  public DateTime getDateCreated() {
    return dateCreated;
  }

  /**
   * @param dateCreated the dateCreated to set
   */
  public void setDateCreated(DateTime dateCreated) {
    this.dateCreated = dateCreated;
  }

  /**
   * @return the createdBy
   */
  @Column(name = "CREATEDBY", length = EntityWithId.COLUMNLENGTH)
  public String getCreatedBy() {
    return createdBy;
  }

  /**
   * @param createdBy the createdBy to set
   */
  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  /**
   * @return the dateModified
   */
  @Column(name = "DATEMODIFIED")
  @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
  public DateTime getDateModified() {
    return dateModified;
  }

  /**
   * @param dateModified the dateModified to set
   */
  public void setDateModified(DateTime dateModified) {
    this.dateModified = dateModified;
  }

  /**
   * @return the modifiedBy
   */
  @Column(name = "MODIFIEDBY", length = EntityWithId.COLUMNLENGTH)
  public String getModifiedBy() {
    return modifiedBy;
  }

  /**
   * @param modifiedBy the modifiedBy to set
   */
  public void setModifiedBy(String modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

}
