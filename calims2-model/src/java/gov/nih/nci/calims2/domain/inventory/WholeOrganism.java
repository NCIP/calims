package gov.nih.nci.calims2.domain.inventory;
import gov.nih.nci.calims2.domain.inventory.event.Event;
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

import gov.nih.nci.calims2.domain.inventory.visitor.SpecimenVisitor;

import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@Table(name = "WHOLEORGANISM")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_WHOLEORGANISM_BIOSPECIMEN")

public class WholeOrganism extends BioSpecimen {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
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
  private String ethnicityStrain;
  /**
* Retrieves the value of the ethnicityStrain attribute.
* @return ethnicityStrain
**/
  
  @Column(name = "ETHNICITYSTRAIN", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getEthnicityStrain() {
  return ethnicityStrain;
  }
  /**
* Sets the value of ethnicityStrain attribute.
* @param ethnicityStrain .
**/
  public void setEthnicityStrain(String 
  ethnicityStrain) {
  this.ethnicityStrain = ethnicityStrain;
  }
    
        /**
* An associated gov.nih.nci.calims2.domain.inventory.AdditionalOrganismName object.'s collection.
**/
        private Set<gov.nih.nci.calims2.domain.inventory.AdditionalOrganismName> additionalOrganismNameCollection = new HashSet<gov.nih.nci.calims2.domain.inventory.AdditionalOrganismName>();
        /**
* Retrieves the value of the additionalOrganismNameCollection attribute.
* @return additionalOrganismNameCollection
**/
        @OneToMany(fetch = FetchType.LAZY)
@Fetch(FetchMode.SUBSELECT)
@JoinColumn(name = "WHOLEORGANISM_FK")
@org.hibernate.annotations.ForeignKey(name = "ADDITIWHOLEO_FK")

        
       
        public Set<gov.nih.nci.calims2.domain.inventory.AdditionalOrganismName> getAdditionalOrganismNameCollection() {
        return additionalOrganismNameCollection;
        }

        /**
* Sets the value of additionalOrganismNameCollection attribute.
* @param additionalOrganismNameCollection .
**/
        public void setAdditionalOrganismNameCollection(Set<gov.nih.nci.calims2.domain.inventory.AdditionalOrganismName> additionalOrganismNameCollection) {
        this.additionalOrganismNameCollection = additionalOrganismNameCollection;
        }
    

/** Accepts the SpecimenVisitor.
 * @param specimenVisitor The specimenVisitor to accept.
 **/ public void accept(SpecimenVisitor specimenVisitor) {
       specimenVisitor.visitWholeOrganism(this);
}





}
