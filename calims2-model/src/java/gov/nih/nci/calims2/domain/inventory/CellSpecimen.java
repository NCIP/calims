/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory;

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

import gov.nih.nci.calims2.domain.inventory.visitor.SpecimenVisitor;

import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI-GLOSS|The individual unit that makes up all of the tissues of the body. All living things are made
* up of one or more cells.; NCI|A part of a thing, or of several things, taken to demonstrate or to
* determine the character of the whole,e.g. a substance, or portion of material obtained for use in
* testing, examination, or study; particularly, a preparation of tissue or bodily fluid taken for examination
* or diagnosis.
**/

@Entity
@Table(name = "CELLSPECIMEN")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_CELLSPECIMEN_BIOSPECIMEN")

public class CellSpecimen extends BioSpecimen {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* NCI|General term referring to the maintenance of cell strains or lines in the laboratory.|On-line Medical
* Dictionary.;   NCI|A process of becoming larger or longer or more numerous.; NCI|A substance holding
* another substance in solution or suspension.
**/
  private String cellCultureGrowthMedium;
  /**
* Retrieves the value of the cellCultureGrowthMedium attribute.
* @return cellCultureGrowthMedium
**/
  
  @Column(name = "CELLCULTUREGROWTHMEDIUM", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getCellCultureGrowthMedium() {
  return cellCultureGrowthMedium;
  }
  /**
* Sets the value of cellCultureGrowthMedium attribute.
* @param cellCultureGrowthMedium .
**/
  public void setCellCultureGrowthMedium(String 
  cellCultureGrowthMedium) {
  this.cellCultureGrowthMedium = cellCultureGrowthMedium;
  }
  /**
* NCI|General term referring to the maintenance of cell strains or lines in the laboratory.|On-line Medical
* Dictionary.; NCI|A process of becoming larger or longer or more numerous.; NCI|A substance holding
* another substance in solution or suspension.;.
**/
  private String cellCultureGrowthMediumSupplement;
  /**
* Retrieves the value of the cellCultureGrowthMediumSupplement attribute.
* @return cellCultureGrowthMediumSupplement
**/
  
  @Column(name = "CELLCULTUREGROWTHMEDIUMSUPPLE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getCellCultureGrowthMediumSupplement() {
  return cellCultureGrowthMediumSupplement;
  }
  /**
* Sets the value of cellCultureGrowthMediumSupplement attribute.
* @param cellCultureGrowthMediumSupplement .
**/
  public void setCellCultureGrowthMediumSupplement(String 
  cellCultureGrowthMediumSupplement) {
  this.cellCultureGrowthMediumSupplement = cellCultureGrowthMediumSupplement;
  }
  /**
* NCI|To determine the number or amount of something; the result of this activity.; NCI|Express the need
* or desire for; ask for.
**/
  private Integer countOfRequests;
  /**
* Retrieves the value of the countOfRequests attribute.
* @return countOfRequests
**/
  
  @Column(name = "COUNTOFREQUESTS", length = EntityWithId.COLUMNLENGTH)
  
  
  public Integer getCountOfRequests() {
  return countOfRequests;
  }
  /**
* Sets the value of countOfRequests attribute.
* @param countOfRequests .
**/
  public void setCountOfRequests(Integer 
  countOfRequests) {
  this.countOfRequests = countOfRequests;
  }
  /**
* NEW[http://en.wikipedia.org/wiki/Mycoplasma] a genus of bacteria that lack a cell wall.; NCI|A condition
* or state at a particular time.
**/
  private String mycoplasmaStatus;
  /**
* Retrieves the value of the mycoplasmaStatus attribute.
* @return mycoplasmaStatus
**/
  
  @Column(name = "MYCOPLASMASTATUS", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getMycoplasmaStatus() {
  return mycoplasmaStatus;
  }
  /**
* Sets the value of mycoplasmaStatus attribute.
* @param mycoplasmaStatus .
**/
  public void setMycoplasmaStatus(String 
  mycoplasmaStatus) {
  this.mycoplasmaStatus = mycoplasmaStatus;
  }
  /**
* NCI|Removal of a cell culture from the culture vessel with a subculture (passage) process, in order to
* keep the cells at a sufficiently low density to stimulate further growth.;.
**/
  private Integer passageNumber;
  /**
* Retrieves the value of the passageNumber attribute.
* @return passageNumber
**/
  
  @Column(name = "PASSAGENUMBER", length = EntityWithId.COLUMNLENGTH)
  
  
  public Integer getPassageNumber() {
  return passageNumber;
  }
  /**
* Sets the value of passageNumber attribute.
* @param passageNumber .
**/
  public void setPassageNumber(Integer 
  passageNumber) {
  this.passageNumber = passageNumber;
  }
  /**
* NCI|A mutation created in a gene at a specific location.
**/
  private String targetedMutation;
  /**
* Retrieves the value of the targetedMutation attribute.
* @return targetedMutation
**/
  
  @Column(name = "TARGETEDMUTATION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getTargetedMutation() {
  return targetedMutation;
  }
  /**
* Sets the value of targetedMutation attribute.
* @param targetedMutation .
**/
  public void setTargetedMutation(String 
  targetedMutation) {
  this.targetedMutation = targetedMutation;
  }

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Container object.
**/
        private gov.nih.nci.calims2.domain.inventory.Container growthContainer;
        /**
* Retrieves the value of the growthContainer attribute.
* @return growthContainer
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CONTAINER_FK")
@org.hibernate.annotations.ForeignKey(name = "CELLSPECIMEN_CONTAINER_FK")

        public gov.nih.nci.calims2.domain.inventory.Container getGrowthContainer() {
        return growthContainer;
        }
   
        /**
* Sets the value of growthContainer attribute.
* @param growthContainer .
**/
        public void setGrowthContainer(gov.nih.nci.calims2.domain.inventory.Container growthContainer) {
        this.growthContainer = growthContainer;
        }

/** Accepts the SpecimenVisitor.
 * @param specimenVisitor The specimenVisitor to accept.
 **/ public void accept(SpecimenVisitor specimenVisitor) {
       specimenVisitor.visitCellSpecimen(this);
}





}
