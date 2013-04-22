/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration;
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
* An expression used for some particular thing.
**/

@Entity
@Table(name = "WORD")

public class Word extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.CharacterSet characterSet;
  /**
* Retrieves the value of the characterSet attribute.
* @return characterSet
**/
  
  @Column(name = "CHARACTERSET", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Word.characterSet}")
  public gov.nih.nci.calims2.domain.administration.enumeration.CharacterSet getCharacterSet() {
  return characterSet;
  }
  /**
* Sets the value of characterSet attribute.
* @param characterSet .
**/
  public void setCharacterSet(gov.nih.nci.calims2.domain.administration.enumeration.CharacterSet 
  characterSet) {
  this.characterSet = characterSet;
  }
  /**
* 
**/
  private String delimiter;
  /**
* Retrieves the value of the delimiter attribute.
* @return delimiter
**/
  
  @Column(name = "DELIMITER", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getDelimiter() {
  return delimiter;
  }
  /**
* Sets the value of delimiter attribute.
* @param delimiter .
**/
  public void setDelimiter(String 
  delimiter) {
  this.delimiter = delimiter;
  }
  /**
* 
**/
  private Boolean isIncremented;
  /**
* Retrieves the value of the isIncremented attribute.
* @return isIncremented
**/
  
  @Column(name = "ISINCREMENTED", length = EntityWithId.COLUMNLENGTH)
  
  
  public Boolean getIsIncremented() {
  return isIncremented;
  }
  /**
* Sets the value of isIncremented attribute.
* @param isIncremented .
**/
  public void setIsIncremented(Boolean 
  isIncremented) {
  this.isIncremented = isIncremented;
  }
  /**
* 
**/
  private Integer maximumLength;
  /**
* Retrieves the value of the maximumLength attribute.
* @return maximumLength
**/
  
  @Column(name = "MAXIMUMLENGTH", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Word.maximumLength}")
  public Integer getMaximumLength() {
  return maximumLength;
  }
  /**
* Sets the value of maximumLength attribute.
* @param maximumLength .
**/
  public void setMaximumLength(Integer 
  maximumLength) {
  this.maximumLength = maximumLength;
  }
  /**
* 
**/
  private Integer minimumLength;
  /**
* Retrieves the value of the minimumLength attribute.
* @return minimumLength
**/
  
  @Column(name = "MINIMUMLENGTH", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Word.minimumLength}")
  public Integer getMinimumLength() {
  return minimumLength;
  }
  /**
* Sets the value of minimumLength attribute.
* @param minimumLength .
**/
  public void setMinimumLength(Integer 
  minimumLength) {
  this.minimumLength = minimumLength;
  }
  /**
* 
**/
  private String padCharacter;
  /**
* Retrieves the value of the padCharacter attribute.
* @return padCharacter
**/
  
  @Column(name = "PADCHARACTER", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getPadCharacter() {
  return padCharacter;
  }
  /**
* Sets the value of padCharacter attribute.
* @param padCharacter .
**/
  public void setPadCharacter(String 
  padCharacter) {
  this.padCharacter = padCharacter;
  }
  /**
* 
**/
  private Integer rank;
  /**
* Retrieves the value of the rank attribute.
* @return rank
**/
  
  @Column(name = "RANK", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Word.rank}")
  public Integer getRank() {
  return rank;
  }
  /**
* Sets the value of rank attribute.
* @param rank .
**/
  public void setRank(Integer 
  rank) {
  this.rank = rank;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.WordStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.Word.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.WordStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.WordStatus 
  status) {
  this.status = status;
  }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.NamingConvention object.
**/
        private gov.nih.nci.calims2.domain.administration.NamingConvention namingConvention;
        /**
* Retrieves the value of the namingConvention attribute.
* @return namingConvention
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "NAMINGCONVENTION_FK")
@org.hibernate.annotations.ForeignKey(name = "WORDCONAMING_FK")

        public gov.nih.nci.calims2.domain.administration.NamingConvention getNamingConvention() {
        return namingConvention;
        }
   
        /**
* Sets the value of namingConvention attribute.
* @param namingConvention .
**/
        public void setNamingConvention(gov.nih.nci.calims2.domain.administration.NamingConvention namingConvention) {
        this.namingConvention = namingConvention;
        }
   






}
