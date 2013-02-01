package gov.nih.nci.calims2.domain.inventory.characteristics;
import gov.nih.nci.calims2.domain.inventory.ChemicalCompound;
import gov.nih.nci.calims2.domain.inventory.NucleicAcid;
import gov.nih.nci.calims2.domain.inventory.Sequence;

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

import gov.nih.nci.calims2.domain.inventory.visitor.CharacteristicsVisitor;

import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* NCI|Having substance or material existence; concerned with material things; of or pertaining to the body
* as distinguished from the mind or spirit.; NCI|The distinguishing qualities or prominent aspect of
* a person, object, action, process, or substance.
**/

@Entity
@DiscriminatorValue("PhysicalCharacteristics")

public class PhysicalCharacteristics extends Characteristics {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.ChemicalCompound object.
**/
        private gov.nih.nci.calims2.domain.inventory.ChemicalCompound chemicalCompund;
        /**
* Retrieves the value of the chemicalCompund attribute.
* @return chemicalCompund
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CHEMICALCOMPOUND_FK")
@org.hibernate.annotations.ForeignKey(name = "PHYSICCHEMIC_FK")

        public gov.nih.nci.calims2.domain.inventory.ChemicalCompound getChemicalCompund() {
        return chemicalCompund;
        }
   
        /**
* Sets the value of chemicalCompund attribute.
* @param chemicalCompund .
**/
        public void setChemicalCompund(gov.nih.nci.calims2.domain.inventory.ChemicalCompound chemicalCompund) {
        this.chemicalCompund = chemicalCompund;
        }
   
   
        /**
* An associated gov.nih.nci.calims2.domain.inventory.NucleicAcid object.
**/
        private gov.nih.nci.calims2.domain.inventory.NucleicAcid nucleicAcid;
        /**
* Retrieves the value of the nucleicAcid attribute.
* @return nucleicAcid
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "NUCLEICACID_FK")
@org.hibernate.annotations.ForeignKey(name = "PHYSICNUCLEI_FK")

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
   




/** Accepts the CharacteristicsVisitor.
 * @param characteristicsVisitor The characteristicsVisitor to accept.
 **/ public void accept(CharacteristicsVisitor characteristicsVisitor) {
       characteristicsVisitor.visitPhysicalCharacteristics(this);
}


}
