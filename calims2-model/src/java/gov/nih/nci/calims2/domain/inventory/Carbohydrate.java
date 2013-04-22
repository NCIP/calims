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
* 
**/

@Entity
@Table(name = "CARBOHYDRATE")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_CARBOHYDRATE_MOLECULARSPE")

public class Carbohydrate extends MolecularSpecimen {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String chemicalFormula;
  /**
* Retrieves the value of the chemicalFormula attribute.
* @return chemicalFormula
**/
  
  @Column(name = "CHEMICALFORMULA", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getChemicalFormula() {
  return chemicalFormula;
  }
  /**
* Sets the value of chemicalFormula attribute.
* @param chemicalFormula .
**/
  public void setChemicalFormula(String 
  chemicalFormula) {
  this.chemicalFormula = chemicalFormula;
  }
  /**
* 
**/
  private String orientation;
  /**
* Retrieves the value of the orientation attribute.
* @return orientation
**/
  
  @Column(name = "ORIENTATION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getOrientation() {
  return orientation;
  }
  /**
* Sets the value of orientation attribute.
* @param orientation .
**/
  public void setOrientation(String 
  orientation) {
  this.orientation = orientation;
  }
  /**
* 
**/
  private String polysaccharideRepeatPattern;
  /**
* Retrieves the value of the polysaccharideRepeatPattern attribute.
* @return polysaccharideRepeatPattern
**/
  
  @Column(name = "POLYSACCHARIDEREPEATPATTERN", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getPolysaccharideRepeatPattern() {
  return polysaccharideRepeatPattern;
  }
  /**
* Sets the value of polysaccharideRepeatPattern attribute.
* @param polysaccharideRepeatPattern .
**/
  public void setPolysaccharideRepeatPattern(String 
  polysaccharideRepeatPattern) {
  this.polysaccharideRepeatPattern = polysaccharideRepeatPattern;
  }
  /**
* 
**/
  private String polysaccharideUnit;
  /**
* Retrieves the value of the polysaccharideUnit attribute.
* @return polysaccharideUnit
**/
  
  @Column(name = "POLYSACCHARIDEUNIT", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getPolysaccharideUnit() {
  return polysaccharideUnit;
  }
  /**
* Sets the value of polysaccharideUnit attribute.
* @param polysaccharideUnit .
**/
  public void setPolysaccharideUnit(String 
  polysaccharideUnit) {
  this.polysaccharideUnit = polysaccharideUnit;
  }

/** Accepts the SpecimenVisitor.
 * @param specimenVisitor The specimenVisitor to accept.
 **/ public void accept(SpecimenVisitor specimenVisitor) {
       specimenVisitor.visitCarbohydrate(this);
}





}
