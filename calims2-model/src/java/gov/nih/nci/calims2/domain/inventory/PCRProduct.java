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
* NCI|A method for amplifying a DNA base sequence using multiple rounds of heat denaturation of the DNA
* and annealing of oligonucleotide primers complementary to flanking regions in the presence of a heat-stable
* polymerase.This results in duplication of the targeted DNA region. Newly synthesized DNA strands can
* subsequently serve as additional templates for the same primer sequences,so that successive rounds
* of primer annealing, strand elongation, and dissociation produce rapid and highly specific amplification
* of the desired sequence. PCR also can be used to detect the existence of the defined sequence in a
* DNA sample.; NCI|The end result of a manufacturing process; anything that is produced.
**/

@Entity
@Table(name = "PCRPRODUCT")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_PCRPRODUCT_NUCLEICACID")

public class PCRProduct extends NucleicAcid {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private Long expectedSize;
  /**
* Retrieves the value of the expectedSize attribute.
* @return expectedSize
**/
  
  @Column(name = "EXPECTEDSIZE", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getExpectedSize() {
  return expectedSize;
  }
  /**
* Sets the value of expectedSize attribute.
* @param expectedSize .
**/
  public void setExpectedSize(Long 
  expectedSize) {
  this.expectedSize = expectedSize;
  }
  /**
* NCI|Ascertained or determined through monitoring or observation.;NCI|The physical magnitude of something.
**/
  private Long observedSize;
  /**
* Retrieves the value of the observedSize attribute.
* @return observedSize
**/
  
  @Column(name = "OBSERVEDSIZE", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getObservedSize() {
  return observedSize;
  }
  /**
* Sets the value of observedSize attribute.
* @param observedSize .
**/
  public void setObservedSize(Long 
  observedSize) {
  this.observedSize = observedSize;
  }

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Primer object.
**/
        private gov.nih.nci.calims2.domain.inventory.Primer forwardPrimer;
        /**
* Retrieves the value of the forwardPrimer attribute.
* @return forwardPrimer
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "FORWARDPRIMER_FK")
@org.hibernate.annotations.ForeignKey(name = "PCRPRODUCTB_PRIMER_FK")

        public gov.nih.nci.calims2.domain.inventory.Primer getForwardPrimer() {
        return forwardPrimer;
        }
   
        /**
* Sets the value of forwardPrimer attribute.
* @param forwardPrimer .
**/
        public void setForwardPrimer(gov.nih.nci.calims2.domain.inventory.Primer forwardPrimer) {
        this.forwardPrimer = forwardPrimer;
        }

        /**
* An associated gov.nih.nci.calims2.domain.inventory.Primer object.
**/
        private gov.nih.nci.calims2.domain.inventory.Primer reversePrimer;
        /**
* Retrieves the value of the reversePrimer attribute.
* @return reversePrimer
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "REVERSEPRIMER_FK")
@org.hibernate.annotations.ForeignKey(name = "PCRPRODUCTA_PRIMER_FK")

        public gov.nih.nci.calims2.domain.inventory.Primer getReversePrimer() {
        return reversePrimer;
        }
   
        /**
* Sets the value of reversePrimer attribute.
* @param reversePrimer .
**/
        public void setReversePrimer(gov.nih.nci.calims2.domain.inventory.Primer reversePrimer) {
        this.reversePrimer = reversePrimer;
        }

/** Accepts the SpecimenVisitor.
 * @param specimenVisitor The specimenVisitor to accept.
 **/ public void accept(SpecimenVisitor specimenVisitor) {
       specimenVisitor.visitPCRProduct(this);
}





}
