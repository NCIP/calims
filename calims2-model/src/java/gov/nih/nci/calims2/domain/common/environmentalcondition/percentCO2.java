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
@DiscriminatorValue("percentCO2")

public class percentCO2 extends EnvironmentalCondition {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private Float maximumPercentCO2;
  /**
* Retrieves the value of the maximumPercentCO2 attribute.
* @return maximumPercentCO2
**/
  
  @Column(name = "MAXIMUMPERCENTCO2", length = EntityWithId.COLUMNLENGTH)
  
  
  public Float getMaximumPercentCO2() {
  return maximumPercentCO2;
  }
  /**
* Sets the value of maximumPercentCO2 attribute.
* @param maximumPercentCO2 .
**/
  public void setMaximumPercentCO2(Float 
  maximumPercentCO2) {
  this.maximumPercentCO2 = maximumPercentCO2;
  }
  /**
* 
**/
  private Float measuredPercentCO2;
  /**
* Retrieves the value of the measuredPercentCO2 attribute.
* @return measuredPercentCO2
**/
  
  @Column(name = "MEASUREDPERCENTCO2", length = EntityWithId.COLUMNLENGTH)
  
  
  public Float getMeasuredPercentCO2() {
  return measuredPercentCO2;
  }
  /**
* Sets the value of measuredPercentCO2 attribute.
* @param measuredPercentCO2 .
**/
  public void setMeasuredPercentCO2(Float 
  measuredPercentCO2) {
  this.measuredPercentCO2 = measuredPercentCO2;
  }
  /**
* 
**/
  private Float minimumPercentCO2;
  /**
* Retrieves the value of the minimumPercentCO2 attribute.
* @return minimumPercentCO2
**/
  
  @Column(name = "MINIMUMPERCENTCO2", length = EntityWithId.COLUMNLENGTH)
  
  
  public Float getMinimumPercentCO2() {
  return minimumPercentCO2;
  }
  /**
* Sets the value of minimumPercentCO2 attribute.
* @param minimumPercentCO2 .
**/
  public void setMinimumPercentCO2(Float 
  minimumPercentCO2) {
  this.minimumPercentCO2 = minimumPercentCO2;
  }
/** Accepts the EnvironmentalConditionVisitor.
 * @param environmentalConditionVisitor The EnvironmentalConditionVisitor to accept.
 **/ public void accept(EnvironmentalConditionVisitor environmentalConditionVisitor) {
       environmentalConditionVisitor.visitpercentCO2(this);
}






}
