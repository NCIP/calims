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
@Table(name = "ANTIBODY")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_ANTIBODY_PROTEIN")

public class Antibody extends Protein {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
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
* wikipedia: In immunology, the "immunoglobulin isotype" refers to the type of chain.
**/
  private String isotype;
  /**
* Retrieves the value of the isotype attribute.
* @return isotype
**/
  
  @Column(name = "ISOTYPE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getIsotype() {
  return isotype;
  }
  /**
* Sets the value of isotype attribute.
* @param isotype .
**/
  public void setIsotype(String 
  isotype) {
  this.isotype = isotype;
  }
  /**
* [http://www.websters-online-dictionary.org/definition/recommended]  Mentioned as worthy of acceptance;
* [http://en.wiktionary.org/wiki/dilution] A solution that has had additional solvent, such as water,
* added to.
**/
  private String recommendedDilutionRange;
  /**
* Retrieves the value of the recommendedDilutionRange attribute.
* @return recommendedDilutionRange
**/
  
  @Column(name = "RECOMMENDEDDILUTIONRANGE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getRecommendedDilutionRange() {
  return recommendedDilutionRange;
  }
  /**
* Sets the value of recommendedDilutionRange attribute.
* @param recommendedDilutionRange .
**/
  public void setRecommendedDilutionRange(String 
  recommendedDilutionRange) {
  this.recommendedDilutionRange = recommendedDilutionRange;
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
@org.hibernate.annotations.ForeignKey(name = "ANTIBODY_ANTIGEN_FK")

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

/** Accepts the SpecimenVisitor.
 * @param specimenVisitor The specimenVisitor to accept.
 **/ public void accept(SpecimenVisitor specimenVisitor) {
       specimenVisitor.visitAntibody(this);
}





}
