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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "STRAIN")

public class Strain extends DisplayableEntity implements  EntityWithNotes {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String ethnicity;
  /**
* Retrieves the value of the ethnicity attribute.
* @return ethnicity
**/
  
  @Column(name = "ETHNICITY", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getEthnicity() {
  return ethnicity;
  }
  /**
* Sets the value of ethnicity attribute.
* @param ethnicity .
**/
  public void setEthnicity(String 
  ethnicity) {
  this.ethnicity = ethnicity;
  }
  /**
* 
**/
  private String isolate;
  /**
* Retrieves the value of the isolate attribute.
* @return isolate
**/
  
  @Column(name = "ISOLATE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getIsolate() {
  return isolate;
  }
  /**
* Sets the value of isolate attribute.
* @param isolate .
**/
  public void setIsolate(String 
  isolate) {
  this.isolate = isolate;
  }
  /**
* 
**/
  private String line;
  /**
* Retrieves the value of the line attribute.
* @return line
**/
  
  @Column(name = "LINE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getLine() {
  return line;
  }
  /**
* Sets the value of line attribute.
* @param line .
**/
  public void setLine(String 
  line) {
  this.line = line;
  }
  /**
* 
**/
  private String strainSubgroup;
  /**
* Retrieves the value of the strainSubgroup attribute.
* @return strainSubgroup
**/
  
  @Column(name = "STRAINSUBGROUP", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getStrainSubgroup() {
  return strainSubgroup;
  }
  /**
* Sets the value of strainSubgroup attribute.
* @param strainSubgroup .
**/
  public void setStrainSubgroup(String 
  strainSubgroup) {
  this.strainSubgroup = strainSubgroup;
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
@org.hibernate.annotations.ForeignKey(name = "STRAINTYPE_FK")

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
* An associated gov.nih.nci.calims2.domain.inventory.Taxon object.
**/
        private gov.nih.nci.calims2.domain.inventory.Taxon taxon;
        /**
* Retrieves the value of the taxon attribute.
* @return taxon
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TAXON_FK")
@org.hibernate.annotations.ForeignKey(name = "ORGANISMSTR_TAXON_FK")

        public gov.nih.nci.calims2.domain.inventory.Taxon getTaxon() {
        return taxon;
        }
   
        /**
* Sets the value of taxon attribute.
* @param taxon .
**/
        public void setTaxon(gov.nih.nci.calims2.domain.inventory.Taxon taxon) {
        this.taxon = taxon;
        }
        private Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection = new HashSet<gov.nih.nci.calims2.domain.common.Notes>();
        @SuppressWarnings("deprecation")
@IndexColumn(name="LIST_INDEX")
        @CollectionOfElements(fetch=FetchType.LAZY)
        @JoinTable(name="NOTES_STRAIN",joinColumns=@JoinColumn(name="ID_NOTES_STRAIN"))
        @ForeignKey(name="FK_NOTES_STRAIN")
        @Fetch(FetchMode.SUBSELECT)
        public Set<gov.nih.nci.calims2.domain.common.Notes> getNotesCollection() {
        return notesCollection;
        }
        public void setNotesCollection(Set<gov.nih.nci.calims2.domain.common.Notes> notesCollection) {
             this.notesCollection = notesCollection;
        }







}
