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
@Table(name = "LIPID")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_LIPID_MOLECULARSPECIMEN")

public class Lipid extends MolecularSpecimen {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String category;
  /**
* Retrieves the value of the category attribute.
* @return category
**/
  
  @Column(name = "CATEGORY", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getCategory() {
  return category;
  }
  /**
* Sets the value of category attribute.
* @param category .
**/
  public void setCategory(String 
  category) {
  this.category = category;
  }
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
  private String deltaxNomenclature;
  /**
* Retrieves the value of the deltaxNomenclature attribute.
* @return deltaxNomenclature
**/
  
  @Column(name = "DELTAXNOMENCLATURE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getDeltaxNomenclature() {
  return deltaxNomenclature;
  }
  /**
* Sets the value of deltaxNomenclature attribute.
* @param deltaxNomenclature .
**/
  public void setDeltaxNomenclature(String 
  deltaxNomenclature) {
  this.deltaxNomenclature = deltaxNomenclature;
  }
  /**
* 
**/
  private String function;
  /**
* Retrieves the value of the function attribute.
* @return function
**/
  
  @Column(name = "FUNCTION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getFunction() {
  return function;
  }
  /**
* Sets the value of function attribute.
* @param function .
**/
  public void setFunction(String 
  function) {
  this.function = function;
  }
  /**
* 
**/
  private String nxNomenclature;
  /**
* Retrieves the value of the nxNomenclature attribute.
* @return nxNomenclature
**/
  
  @Column(name = "NXNOMENCLATURE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getNxNomenclature() {
  return nxNomenclature;
  }
  /**
* Sets the value of nxNomenclature attribute.
* @param nxNomenclature .
**/
  public void setNxNomenclature(String 
  nxNomenclature) {
  this.nxNomenclature = nxNomenclature;
  }
  /**
* 
**/
  private String saturation;
  /**
* Retrieves the value of the saturation attribute.
* @return saturation
**/
  
  @Column(name = "SATURATION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getSaturation() {
  return saturation;
  }
  /**
* Sets the value of saturation attribute.
* @param saturation .
**/
  public void setSaturation(String 
  saturation) {
  this.saturation = saturation;
  }

/** Accepts the SpecimenVisitor.
 * @param specimenVisitor The specimenVisitor to accept.
 **/ public void accept(SpecimenVisitor specimenVisitor) {
       specimenVisitor.visitLipid(this);
}





}
