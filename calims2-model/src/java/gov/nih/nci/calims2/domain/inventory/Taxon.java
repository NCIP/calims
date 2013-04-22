/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory;
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
@Table(name = "TAXON")

public class Taxon extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* NCI|Widely known or encountered; standard._ NCI|The words or language units by which a thing is known.
**/
  private String commonName;
  /**
* Retrieves the value of the commonName attribute.
* @return commonName
**/
  
  @Column(name = "COMMONNAME", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getCommonName() {
  return commonName;
  }
  /**
* Sets the value of commonName attribute.
* @param commonName .
**/
  public void setCommonName(String 
  commonName) {
  this.commonName = commonName;
  }
  /**
* 
**/
  private String ethnicGroup;
  /**
* Retrieves the value of the ethnicGroup attribute.
* @return ethnicGroup
**/
  
  @Column(name = "ETHNICGROUP", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getEthnicGroup() {
  return ethnicGroup;
  }
  /**
* Sets the value of ethnicGroup attribute.
* @param ethnicGroup .
**/
  public void setEthnicGroup(String 
  ethnicGroup) {
  this.ethnicGroup = ethnicGroup;
  }
  /**
* NCI|A taxonomic category ranking below a family (or Subfamily) and above a species and generally consisting
* of a group of species exhibiting similar characteristics.
**/
  private String genus;
  /**
* Retrieves the value of the genus attribute.
* @return genus
**/
  
  @Column(name = "GENUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getGenus() {
  return genus;
  }
  /**
* Sets the value of genus attribute.
* @param genus .
**/
  public void setGenus(String 
  genus) {
  this.genus = genus;
  }
  /**
* 
**/
  private String ncbiTaxonomyID;
  /**
* Retrieves the value of the ncbiTaxonomyID attribute.
* @return ncbiTaxonomyID
**/
  
  @Column(name = "NCBITAXONOMYID", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getNcbiTaxonomyID() {
  return ncbiTaxonomyID;
  }
  /**
* Sets the value of ncbiTaxonomyID attribute.
* @param ncbiTaxonomyID .
**/
  public void setNcbiTaxonomyID(String 
  ncbiTaxonomyID) {
  this.ncbiTaxonomyID = ncbiTaxonomyID;
  }
  /**
* 
**/
  private String populationGroup;
  /**
* Retrieves the value of the populationGroup attribute.
* @return populationGroup
**/
  
  @Column(name = "POPULATIONGROUP", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getPopulationGroup() {
  return populationGroup;
  }
  /**
* Sets the value of populationGroup attribute.
* @param populationGroup .
**/
  public void setPopulationGroup(String 
  populationGroup) {
  this.populationGroup = populationGroup;
  }
  /**
* 
**/
  private String scientificName;
  /**
* Retrieves the value of the scientificName attribute.
* @return scientificName
**/
  
  @Column(name = "SCIENTIFICNAME", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getScientificName() {
  return scientificName;
  }
  /**
* Sets the value of scientificName attribute.
* @param scientificName .
**/
  public void setScientificName(String 
  scientificName) {
  this.scientificName = scientificName;
  }
  /**
* 
**/
  private String species;
  /**
* Retrieves the value of the species attribute.
* @return species
**/
  
  @Column(name = "SPECIES", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getSpecies() {
  return species;
  }
  /**
* Sets the value of species attribute.
* @param species .
**/
  public void setSpecies(String 
  species) {
  this.species = species;
  }
  /**
* 
**/
  private String speciesSubgroup;
  /**
* Retrieves the value of the speciesSubgroup attribute.
* @return speciesSubgroup
**/
  
  @Column(name = "SPECIESSUBGROUP", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getSpeciesSubgroup() {
  return speciesSubgroup;
  }
  /**
* Sets the value of speciesSubgroup attribute.
* @param speciesSubgroup .
**/
  public void setSpeciesSubgroup(String 
  speciesSubgroup) {
  this.speciesSubgroup = speciesSubgroup;
  }
  /**
* 
**/
  private gov.nih.nci.calims2.domain.inventory.enumeration.TaxonStatus status;
  /**
* Retrieves the value of the status attribute.
* @return status
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "STATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.inventory.enumeration.TaxonStatus getStatus() {
  return status;
  }
  /**
* Sets the value of status attribute.
* @param status .
**/
  public void setStatus(gov.nih.nci.calims2.domain.inventory.enumeration.TaxonStatus 
  status) {
  this.status = status;
  }
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_TAXON",joinColumns=@JoinColumn(name="ID_NOTES_TAXON"))
        @ForeignKey(name="FK_NOTES_TAXON")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }







}
