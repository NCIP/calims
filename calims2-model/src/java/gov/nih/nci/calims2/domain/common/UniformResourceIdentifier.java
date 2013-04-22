/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.common;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;

import org.joda.time.DateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.AttributeOverrides;
import javax.persistence.AssociationOverrides;
import javax.persistence.AttributeOverride;
import javax.persistence.AssociationOverride;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.IndexColumn;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;
import gov.nih.nci.calims2.domain.interfaces.EntityWithExternalId;
import java.util.ArrayList;
import java.io.Serializable;



import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@Table(name = "UNIFORMRESOURCEIDENTIFIER")

public class UniformResourceIdentifier extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String text;
  /**
* Retrieves the value of the text attribute.
* @return text
**/
  
  @Column(name = "TEXT", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getText() {
  return text;
  }
  /**
* Sets the value of text attribute.
* @param text .
**/
  public void setText(String 
  text) {
  this.text = text;
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
* An associated gov.nih.nci.calims2.domain.common.ElectronicDocument object.
**/
        private gov.nih.nci.calims2.domain.common.ElectronicDocument electronicDocument;
        /**
* Retrieves the value of the electronicDocument attribute.
* @return electronicDocument
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ELECTRONICDOCUMENT_FK")
@org.hibernate.annotations.ForeignKey(name = "UNIFORELECTR_FK")

        public gov.nih.nci.calims2.domain.common.ElectronicDocument getElectronicDocument() {
        return electronicDocument;
        }
   
        /**
* Sets the value of electronicDocument attribute.
* @param electronicDocument .
**/
        public void setElectronicDocument(gov.nih.nci.calims2.domain.common.ElectronicDocument electronicDocument) {
        this.electronicDocument = electronicDocument;
        }
   






}
