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
* NCI|A continuous amorphous substance that tends to flow and to conform to the outline of its container
* (i.e., a liquid or a gas). Also used as an adjective to describe something with properties like that
* of a fluid.; NCI|A part of a thing,or of several things, taken to demonstrate or to determine the
* character of the whole, e.g. a substance, or portion of material obtained for use in testing, examination,
* or study; particularly, a preparation of tissue or bodily fluid taken for examination.
**/

@Entity
@Table(name = "FLUIDSPECIMEN")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_FLUIDSPECIMEN_BIOSPECIMEN")

public class FluidSpecimen extends BioSpecimen {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* NCI|The act or process of making something ready; also an anatomic or pathologic specimen made ready
* and preserved for study.
**/
  private String preparation;
  /**
* Retrieves the value of the preparation attribute.
* @return preparation
**/
  
  @Column(name = "PREPARATION", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getPreparation() {
  return preparation;
  }
  /**
* Sets the value of preparation attribute.
* @param preparation .
**/
  public void setPreparation(String 
  preparation) {
  this.preparation = preparation;
  }

/** Accepts the SpecimenVisitor.
 * @param specimenVisitor The specimenVisitor to accept.
 **/ public void accept(SpecimenVisitor specimenVisitor) {
       specimenVisitor.visitFluidSpecimen(this);
}





}
