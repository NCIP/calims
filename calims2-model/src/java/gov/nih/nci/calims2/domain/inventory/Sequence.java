/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory;
import gov.nih.nci.calims2.domain.interfaces.DisplayableEntity;
import gov.nih.nci.calims2.domain.inventory.characteristics.PhysicalCharacteristics;
import gov.nih.nci.calims2.domain.common.ExternalIdentifier;
import java.util.Collection;
import gov.nih.nci.calims2.domain.inventory.characteristics.ChemicalCharacteristics;

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
* NCI|A serial arrangement in which things follow in logical order or a recurrent pattern.
**/

@Entity
@Table(name = "SEQUENCE")

public class Sequence extends DisplayableEntity implements  EntityWithExternalId {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* NCI|The worldwide standard for the code numbers used by computers to represent all the uppercase and
* lowercase Latin letters, numbers, punctuation, and other symbols. There are 128 standard ASCII codes,.
**/
  private String asciiRepresentation;
  /**
* Retrieves the value of the asciiRepresentation attribute.
* @return asciiRepresentation
**/
  
  @Column(name = "ASCIIREPRESENTATION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getAsciiRepresentation() {
  return asciiRepresentation;
  }
  /**
* Sets the value of asciiRepresentation attribute.
* @param asciiRepresentation .
**/
  public void setAsciiRepresentation(String 
  asciiRepresentation) {
  this.asciiRepresentation = asciiRepresentation;
  }
  /**
* NCI|A mother or a father; an immediate progenitor; something from which one or more similar and separate
* things have developed, or to which they are attached.;.
**/
  private Long parentEndOffset;
  /**
* Retrieves the value of the parentEndOffset attribute.
* @return parentEndOffset
**/
  
  @Column(name = "PARENTENDOFFSET", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getParentEndOffset() {
  return parentEndOffset;
  }
  /**
* Sets the value of parentEndOffset attribute.
* @param parentEndOffset .
**/
  public void setParentEndOffset(Long 
  parentEndOffset) {
  this.parentEndOffset = parentEndOffset;
  }
  /**
* NCI|A mother or a father; an immediate progenitor; something from which one or more similar and separate
* things have developed, or to which they are attached.;.
**/
  private Long parentStartOffset;
  /**
* Retrieves the value of the parentStartOffset attribute.
* @return parentStartOffset
**/
  
  @Column(name = "PARENTSTARTOFFSET", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getParentStartOffset() {
  return parentStartOffset;
  }
  /**
* Sets the value of parentStartOffset attribute.
* @param parentStartOffset .
**/
  public void setParentStartOffset(Long 
  parentStartOffset) {
  this.parentStartOffset = parentStartOffset;
  }
  /**
* NCI|The orientation of a genomic element on the double stranded molecule.
**/
  private String strand;
  /**
* Retrieves the value of the strand attribute.
* @return strand
**/
  
  @Column(name = "STRAND", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getStrand() {
  return strand;
  }
  /**
* Sets the value of strand attribute.
* @param strand .
**/
  public void setStrand(String 
  strand) {
  this.strand = strand;
  }
  /**
* NCI|A character string that can identify any kind of resource on the Internet, including images, text,
* video, audio and programs.
**/
  private String URI;
  /**
* Retrieves the value of the URI attribute.
* @return URI
**/
  
  @Column(name = "URI", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getURI() {
  return URI;
  }
  /**
* Sets the value of URI attribute.
* @param URI .
**/
  public void setURI(String 
  URI) {
  this.URI = URI;
  }
    
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Feature object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.inventory.Feature> featureCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.Feature>();
        /**
* Retrieves the value of the featureCollection attribute.
* @return featureCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "FEATURECOLLECTION_FK")
@org.hibernate.annotations.ForeignKey(name = "FEATURSEQUEN_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.inventory.Feature> getFeatureCollection() {
        return featureCollection;
        }

        /**
* Sets the value of featureCollection attribute.
* @param featureCollection .
**/
        public void setFeatureCollection(Set<gov.nih.nci.calims2.domain.inventory.Feature> featureCollection) {
        this.featureCollection = featureCollection;
        }
    

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Antigen object.
**/
        private gov.nih.nci.calims2.domain.inventory.Antigen antigen;
        /**
* Retrieves the value of the antigen attribute.
* @return antigen
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ANTIGEN_FK")
@org.hibernate.annotations.ForeignKey(name = "SEQUENCE_ANTIGEN_FK")

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
* An associated gov.nih.nci.calims2.domain.common.ExternalIdentifier object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> externalIdentifierCollection = new HashSet<gov.nih.nci.calims2.domain.common.ExternalIdentifier>();
        /**
* Retrieves the value of the externalIdentifierCollection attribute.
* @return externalIdentifierCollection
**/
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "sequence")
@Fetch(FetchMode.SUBSELECT)

        
       
        public Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> getExternalIdentifierCollection() {
        return externalIdentifierCollection;
        }

        /**
* Sets the value of externalIdentifierCollection attribute.
* @param externalIdentifierCollection .
**/
        public void setExternalIdentifierCollection(Set<gov.nih.nci.calims2.domain.common.ExternalIdentifier> externalIdentifierCollection) {
        this.externalIdentifierCollection = externalIdentifierCollection;
        }
    

        /**
* An associated gov.nih.nci.calims2.domain.inventory.NucleicAcid object.
**/
        private gov.nih.nci.calims2.domain.inventory.NucleicAcid nucleicAcid;
        /**
* Retrieves the value of the nucleicAcid attribute.
* @return nucleicAcid
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "NUCLEICACID_FK")
@org.hibernate.annotations.ForeignKey(name = "SEQUENCE_NUCLEICACID_FK")

        public gov.nih.nci.calims2.domain.inventory.NucleicAcid getNucleicAcid() {
        return nucleicAcid;
        }
   
        /**
* Sets the value of nucleicAcid attribute.
* @param nucleicAcid .
**/
        public void setNucleicAcid(gov.nih.nci.calims2.domain.inventory.NucleicAcid nucleicAcid) {
        this.nucleicAcid = nucleicAcid;
        }

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Antibody object.
**/
        private gov.nih.nci.calims2.domain.inventory.Antibody antibody;
        /**
* Retrieves the value of the antibody attribute.
* @return antibody
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "ANTIBODY_FK")
@org.hibernate.annotations.ForeignKey(name = "ANTIBODYBIN_ANTIBODY_FK")

        public gov.nih.nci.calims2.domain.inventory.Antibody getAntibody() {
        return antibody;
        }
   
        /**
* Sets the value of antibody attribute.
* @param antibody .
**/
        public void setAntibody(gov.nih.nci.calims2.domain.inventory.Antibody antibody) {
        this.antibody = antibody;
        }

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Feature object.
**/
        private gov.nih.nci.calims2.domain.inventory.Feature cterminus;
        /**
* Retrieves the value of the cterminus attribute.
* @return cterminus
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CTERMINUS_FK")
@org.hibernate.annotations.ForeignKey(name = "SEQUENCEB_FEATURE_FK")

        public gov.nih.nci.calims2.domain.inventory.Feature getCterminus() {
        return cterminus;
        }
   
        /**
* Sets the value of cterminus attribute.
* @param cterminus .
**/
        public void setCterminus(gov.nih.nci.calims2.domain.inventory.Feature cterminus) {
        this.cterminus = cterminus;
        }

        /**
* An associated gov.nih.nci.calims2.domain.inventory.characteristics.PhysicalCharacteristics object.
**/
        private gov.nih.nci.calims2.domain.inventory.characteristics.PhysicalCharacteristics molecularMass;
        /**
* Retrieves the value of the molecularMass attribute.
* @return molecularMass
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PHYSICALCHARACTERISTICS_FK")
@org.hibernate.annotations.ForeignKey(name = "SEQUENCE_PHYSICALCHA_FK")

        public gov.nih.nci.calims2.domain.inventory.characteristics.PhysicalCharacteristics getMolecularMass() {
        return molecularMass;
        }
   
        /**
* Sets the value of molecularMass attribute.
* @param molecularMass .
**/
        public void setMolecularMass(gov.nih.nci.calims2.domain.inventory.characteristics.PhysicalCharacteristics molecularMass) {
        this.molecularMass = molecularMass;
        }
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.Protein object.
**/
        private gov.nih.nci.calims2.domain.inventory.Protein protein;
        /**
* Retrieves the value of the protein attribute.
* @return protein
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PROTEIN_FK")
@org.hibernate.annotations.ForeignKey(name = "SEQUENPROTEIN_FK")

        public gov.nih.nci.calims2.domain.inventory.Protein getProtein() {
        return protein;
        }
   
        /**
* Sets the value of protein attribute.
* @param protein .
**/
        public void setProtein(gov.nih.nci.calims2.domain.inventory.Protein protein) {
        this.protein = protein;
        }
   

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Feature object.
**/
        private gov.nih.nci.calims2.domain.inventory.Feature nterminus;
        /**
* Retrieves the value of the nterminus attribute.
* @return nterminus
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "NTERMINUS_FK")
@org.hibernate.annotations.ForeignKey(name = "SEQUENCEA_FEATURE_FK")

        public gov.nih.nci.calims2.domain.inventory.Feature getNterminus() {
        return nterminus;
        }
   
        /**
* Sets the value of nterminus attribute.
* @param nterminus .
**/
        public void setNterminus(gov.nih.nci.calims2.domain.inventory.Feature nterminus) {
        this.nterminus = nterminus;
        }






}
