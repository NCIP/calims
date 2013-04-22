/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.common.Type;

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
@Table(name = "FEATURE")

public class Feature extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* NCI|A serial arrangement in which things follow in logical order or a recurrent pattern.; NCI|The point
* or place at which something terminates in time, space, or extent.
**/
  private Long sequenceEnd;
  /**
* Retrieves the value of the sequenceEnd attribute.
* @return sequenceEnd
**/
  
  @Column(name = "SEQUENCEEND", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getSequenceEnd() {
  return sequenceEnd;
  }
  /**
* Sets the value of sequenceEnd attribute.
* @param sequenceEnd .
**/
  public void setSequenceEnd(Long 
  sequenceEnd) {
  this.sequenceEnd = sequenceEnd;
  }
  /**
* NCI|A serial arrangement in which things follow in logical order or a recurrent pattern.; NCI|Have a
* beginning, in a temporal, spatial, or evaluative sense; the point in space or time where something
* begins.
**/
  private Long sequenceStart;
  /**
* Retrieves the value of the sequenceStart attribute.
* @return sequenceStart
**/
  
  @Column(name = "SEQUENCESTART", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getSequenceStart() {
  return sequenceStart;
  }
  /**
* Sets the value of sequenceStart attribute.
* @param sequenceStart .
**/
  public void setSequenceStart(Long 
  sequenceStart) {
  this.sequenceStart = sequenceStart;
  }
  /**
* NCI|A position in relation to its surroundings.
**/
  private String site;
  /**
* Retrieves the value of the site attribute.
* @return site
**/
  
  @Column(name = "SITE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getSite() {
  return site;
  }
  /**
* Sets the value of site attribute.
* @param site .
**/
  public void setSite(String 
  site) {
  this.site = site;
  }
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Antigen object.
**/
        private gov.nih.nci.calims2.domain.inventory.Antigen antigen;
        /**
* Retrieves the value of the antigen attribute.
* @return antigen
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ANTIGEN_FK")
@org.hibernate.annotations.ForeignKey(name = "EPITOPANTIGEN_FK")

        public gov.nih.nci.calims2.domain.inventory.Antigen getAntigen() {
        return antigen;
        }
   
        /**
* Sets the value of antigen attribute.
* @param antigen .
**/
        public void setAntigen(gov.nih.nci.calims2.domain.inventory.Antigen antigen) {
        this.antigen = antigen;
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
@org.hibernate.annotations.ForeignKey(name = "FEATURSPECIM_FK")

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
* An associated gov.nih.nci.calims2.domain.common.Type object.
**/
        private gov.nih.nci.calims2.domain.common.Type role;
        /**
* Retrieves the value of the role attribute.
* @return role
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TYPE_FK")
@org.hibernate.annotations.ForeignKey(name = "FEATURTYPE_FK")

        public gov.nih.nci.calims2.domain.common.Type getRole() {
        return role;
        }
   
        /**
* Sets the value of role attribute.
* @param role .
**/
        public void setRole(gov.nih.nci.calims2.domain.common.Type role) {
        this.role = role;
        }
   






}
