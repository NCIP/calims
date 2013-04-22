/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.inventory.characteristics;
import gov.nih.nci.calims2.domain.administration.Person;

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
* 
**/

@Entity
@DiscriminatorValue("FamilyHistory")

public class FamilyHistory extends BioCharacteristics {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String affectedPerson;
  /**
* Retrieves the value of the affectedPerson attribute.
* @return affectedPerson
**/
  
  @Column(name = "AFFECTEDPERSON", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getAffectedPerson() {
  return affectedPerson;
  }
  /**
* Sets the value of affectedPerson attribute.
* @param affectedPerson .
**/
  public void setAffectedPerson(String 
  affectedPerson) {
  this.affectedPerson = affectedPerson;
  }

        /**
* An associated gov.nih.nci.calims2.domain.administration.Person object.
**/
        private gov.nih.nci.calims2.domain.administration.Person prodband;
        /**
* Retrieves the value of the prodband attribute.
* @return prodband
**/
        
       
        @OneToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "PERSON_FK")
@org.hibernate.annotations.ForeignKey(name = "FAMILYHISTO_PERSON_FK")

        public gov.nih.nci.calims2.domain.administration.Person getProdband() {
        return prodband;
        }
   
        /**
* Sets the value of prodband attribute.
* @param prodband .
**/
        public void setProdband(gov.nih.nci.calims2.domain.administration.Person prodband) {
        this.prodband = prodband;
        }




/** Accepts the CharacteristicsVisitor.
 * @param characteristicsVisitor The characteristicsVisitor to accept.
 **/ public void accept(CharacteristicsVisitor characteristicsVisitor) {
       characteristicsVisitor.visitFamilyHistory(this);
}


}
