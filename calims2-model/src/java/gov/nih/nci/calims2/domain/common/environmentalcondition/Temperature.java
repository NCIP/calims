/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

package gov.nih.nci.calims2.domain.common.environmentalcondition;

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

import gov.nih.nci.calims2.domain.common.visitor.EnvironmentalConditionVisitor;

import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@DiscriminatorValue("Temperature")

public class Temperature extends EnvironmentalCondition {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private Float maximumTemperature;
  /**
* Retrieves the value of the maximumTemperature attribute.
* @return maximumTemperature
**/
  
  @Column(name = "MAXIMUMTEMPERATURE", length = EntityWithId.COLUMNLENGTH)
  
  
  public Float getMaximumTemperature() {
  return maximumTemperature;
  }
  /**
* Sets the value of maximumTemperature attribute.
* @param maximumTemperature .
**/
  public void setMaximumTemperature(Float 
  maximumTemperature) {
  this.maximumTemperature = maximumTemperature;
  }
  /**
* 
**/
  private Float measuredTemperature;
  /**
* Retrieves the value of the measuredTemperature attribute.
* @return measuredTemperature
**/
  
  @Column(name = "MEASUREDTEMPERATURE", length = EntityWithId.COLUMNLENGTH)
  
  
  public Float getMeasuredTemperature() {
  return measuredTemperature;
  }
  /**
* Sets the value of measuredTemperature attribute.
* @param measuredTemperature .
**/
  public void setMeasuredTemperature(Float 
  measuredTemperature) {
  this.measuredTemperature = measuredTemperature;
  }
  /**
* 
**/
  private Float minimumTemperature;
  /**
* Retrieves the value of the minimumTemperature attribute.
* @return minimumTemperature
**/
  
  @Column(name = "MINIMUMTEMPERATURE", length = EntityWithId.COLUMNLENGTH)
  
  
  public Float getMinimumTemperature() {
  return minimumTemperature;
  }
  /**
* Sets the value of minimumTemperature attribute.
* @param minimumTemperature .
**/
  public void setMinimumTemperature(Float 
  minimumTemperature) {
  this.minimumTemperature = minimumTemperature;
  }
/** Accepts the EnvironmentalConditionVisitor.
 * @param environmentalConditionVisitor The EnvironmentalConditionVisitor to accept.
 **/ public void accept(EnvironmentalConditionVisitor environmentalConditionVisitor) {
       environmentalConditionVisitor.visitTemperature(this);
}






}
