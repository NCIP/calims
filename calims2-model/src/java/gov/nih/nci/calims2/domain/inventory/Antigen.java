/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.characteristics.BioCharacteristics;

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
* NCI|Any substance, generally a protein, that stimulates the immune system and elicits an immune response.
* Recognition by the immune system elicits either a T-lymphocyte response, recognizing processed antigens,or
* a B-lymphocyte response, producing antibodies that bind to unprocessed antigens.
**/

@Entity
@Table(name = "ANTIGEN")

public class Antigen extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private Long countOfRequests;
  /**
* Retrieves the value of the countOfRequests attribute.
* @return countOfRequests
**/
  
  @Column(name = "COUNTOFREQUESTS", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getCountOfRequests() {
  return countOfRequests;
  }
  /**
* Sets the value of countOfRequests attribute.
* @param countOfRequests .
**/
  public void setCountOfRequests(Long 
  countOfRequests) {
  this.countOfRequests = countOfRequests;
  }
  /**
* NCI|The purpose for or application or employment of something for functional or beneficial purposes.
**/
  private String use;
  /**
* Retrieves the value of the use attribute.
* @return use
**/
  
  @Column(name = "USE", length = EntityWithId.COLUMNLENGTH)
  @Index(name = "ANTIGENUSE_USE_IDX")
  
  public String getUse() {
  return use;
  }
  /**
* Sets the value of use attribute.
* @param use .
**/
  public void setUse(String 
  use) {
  this.use = use;
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
@org.hibernate.annotations.ForeignKey(name = "ANTIGETYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.inventory.Specimen object.
**/
        private gov.nih.nci.calims2.domain.inventory.Specimen specimen;
        /**
* Retrieves the value of the specimen attribute.
* @return specimen
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "SPECIMEN_FK")
@org.hibernate.annotations.ForeignKey(name = "ANTIGEN_SPECIMEN_FK")

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






}
