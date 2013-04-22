/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import gov.nih.nci.calims2.domain.inventory.visitor.SpecimenVisitor;
/**
* 
**/

@Entity
@Table(name = "BIOSPECIMEN")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_BIOSPECIMEN_SPECIMEN")

public class BioSpecimen extends Specimen {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
   
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
@org.hibernate.annotations.ForeignKey(name = "BIOSPETYPE_FK")

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
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TAXON_FK")
@org.hibernate.annotations.ForeignKey(name = "BIOSPETAXON_FK")

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
   

/** Accepts the SpecimenVisitor.
 * @param specimenVisitor The specimenVisitor to accept.
 **/ public void accept(SpecimenVisitor specimenVisitor) {
       specimenVisitor.visitBioSpecimen(this);
}





}
