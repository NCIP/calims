/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.administration;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import java.util.Collection;

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
* NCI|The words or language units by which a thing is known.;NCI|Something regarded as a normative example.
**/

@Entity
@Table(name = "NAMINGCONVENTION")

public class NamingConvention extends DisplayableEntity {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String example;
  /**
* Retrieves the value of the example attribute.
* @return example
**/
  
  @Column(name = "EXAMPLE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getExample() {
  return example;
  }
  /**
* Sets the value of example attribute.
* @param example .
**/
  public void setExample(String 
  example) {
  this.example = example;
  }
  /**
* 
**/
  private String grouping;
  /**
* Retrieves the value of the grouping attribute.
* @return grouping
**/
  
  @Column(name = "GROUPING", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getGrouping() {
  return grouping;
  }
  /**
* Sets the value of grouping attribute.
* @param grouping .
**/
  public void setGrouping(String 
  grouping) {
  this.grouping = grouping;
  }
  /**
* 
**/
  private Boolean isMandatory;
  /**
* Retrieves the value of the isMandatory attribute.
* @return isMandatory
**/
  
  @Column(name = "ISMANDATORY", length = EntityWithId.COLUMNLENGTH)
  
  
  public Boolean getIsMandatory() {
  return isMandatory;
  }
  /**
* Sets the value of isMandatory attribute.
* @param isMandatory .
**/
  public void setIsMandatory(Boolean 
  isMandatory) {
  this.isMandatory = isMandatory;
  }
  /**
* 
**/
  private Boolean isSuggested;
  /**
* Retrieves the value of the isSuggested attribute.
* @return isSuggested
**/
  
  @Column(name = "ISSUGGESTED", length = EntityWithId.COLUMNLENGTH)
  
  
  public Boolean getIsSuggested() {
  return isSuggested;
  }
  /**
* Sets the value of isSuggested attribute.
* @param isSuggested .
**/
  public void setIsSuggested(Boolean 
  isSuggested) {
  this.isSuggested = isSuggested;
  }
  /**
* 
**/
  private Boolean isUnique;
  /**
* Retrieves the value of the isUnique attribute.
* @return isUnique
**/
  
  @Column(name = "ISUNIQUE", length = EntityWithId.COLUMNLENGTH)
  
  
  public Boolean getIsUnique() {
  return isUnique;
  }
  /**
* Sets the value of isUnique attribute.
* @param isUnique .
**/
  public void setIsUnique(Boolean 
  isUnique) {
  this.isUnique = isUnique;
  }
  /**
* 
**/
  private Long maximumLength;
  /**
* Retrieves the value of the maximumLength attribute.
* @return maximumLength
**/
  
  @Column(name = "MAXIMUMLENGTH", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getMaximumLength() {
  return maximumLength;
  }
  /**
* Sets the value of maximumLength attribute.
* @param maximumLength .
**/
  public void setMaximumLength(Long 
  maximumLength) {
  this.maximumLength = maximumLength;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.NamingConvention.status}")
  public gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionStatus 
  status) {
  this.status = status;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType type;
  /**
* Retrieves the value of the type attribute.
* @return type
**/
  
  @Column(name = "TYPE", length = EntityWithId.COLUMNLENGTH)
  
  @NotNull(message = "{NotNull.gov.nih.nci.calims2.domain.administration.NamingConvention.type}")
  public gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType getType() {
  return type;
  }
  /**
* Sets the value of type attribute.
* @param type .
**/
  public void setType(gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType 
  type) {
  this.type = type;
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
@org.hibernate.annotations.ForeignKey(name = "NAMINGCONVE_PERSON_FK")

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
    
        /**
* An associated gov.nih.nci.calims2.domain.common.Document object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.Document> documentCollection = new HashSet<gov.nih.nci.calims2.domain.common.Document>();
        /**
* Retrieves the value of the documentCollection attribute.
* @return documentCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "namingConvention")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.common.Document> getDocumentCollection() {
        return documentCollection;
        }

        /**
* Sets the value of documentCollection attribute.
* @param documentCollection .
**/
        public void setDocumentCollection(Set<gov.nih.nci.calims2.domain.common.Document> documentCollection) {
        this.documentCollection = documentCollection;
        }
    
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.Laboratory object.
**/
        private gov.nih.nci.calims2.domain.administration.Laboratory laboratory;
        /**
* Retrieves the value of the laboratory attribute.
* @return laboratory
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "LABORATORY_FK")
@org.hibernate.annotations.ForeignKey(name = "NAMINGLABORA_FK")

        public gov.nih.nci.calims2.domain.administration.Laboratory getLaboratory() {
        return laboratory;
        }
   
        /**
* Sets the value of laboratory attribute.
* @param laboratory .
**/
        public void setLaboratory(gov.nih.nci.calims2.domain.administration.Laboratory laboratory) {
        this.laboratory = laboratory;
        }
   
    
        /**
* An associated gov.nih.nci.calims2.domain.administration.Word object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.administration.Word> wordCollection = new HashSet<gov.nih.nci.calims2.domain.administration.Word>();
        /**
* Retrieves the value of the wordCollection attribute.
* @return wordCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "namingConvention")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.administration.Word> getWordCollection() {
        return wordCollection;
        }

        /**
* Sets the value of wordCollection attribute.
* @param wordCollection .
**/
        public void setWordCollection(Set<gov.nih.nci.calims2.domain.administration.Word> wordCollection) {
        this.wordCollection = wordCollection;
        }
    






}
