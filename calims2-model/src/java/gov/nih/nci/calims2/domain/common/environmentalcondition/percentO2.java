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
@DiscriminatorValue("percentO2")

public class percentO2 extends EnvironmentalCondition {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private Float maximumPercentO2;
  /**
* Retrieves the value of the maximumPercentO2 attribute.
* @return maximumPercentO2
**/
  
  @Column(name = "MAXIMUMPERCENTO2", length = EntityWithId.COLUMNLENGTH)
  
  
  public Float getMaximumPercentO2() {
  return maximumPercentO2;
  }
  /**
* Sets the value of maximumPercentO2 attribute.
* @param maximumPercentO2 .
**/
  public void setMaximumPercentO2(Float 
  maximumPercentO2) {
  this.maximumPercentO2 = maximumPercentO2;
  }
  /**
* 
**/
  private Float measuredPercentO2;
  /**
* Retrieves the value of the measuredPercentO2 attribute.
* @return measuredPercentO2
**/
  
  @Column(name = "MEASUREDPERCENTO2", length = EntityWithId.COLUMNLENGTH)
  
  
  public Float getMeasuredPercentO2() {
  return measuredPercentO2;
  }
  /**
* Sets the value of measuredPercentO2 attribute.
* @param measuredPercentO2 .
**/
  public void setMeasuredPercentO2(Float 
  measuredPercentO2) {
  this.measuredPercentO2 = measuredPercentO2;
  }
  /**
* 
**/
  private Float minimumPercentO2;
  /**
* Retrieves the value of the minimumPercentO2 attribute.
* @return minimumPercentO2
**/
  
  @Column(name = "MINIMUMPERCENTO2", length = EntityWithId.COLUMNLENGTH)
  
  
  public Float getMinimumPercentO2() {
  return minimumPercentO2;
  }
  /**
* Sets the value of minimumPercentO2 attribute.
* @param minimumPercentO2 .
**/
  public void setMinimumPercentO2(Float 
  minimumPercentO2) {
  this.minimumPercentO2 = minimumPercentO2;
  }
/** Accepts the EnvironmentalConditionVisitor.
 * @param environmentalConditionVisitor The EnvironmentalConditionVisitor to accept.
 **/ public void accept(EnvironmentalConditionVisitor environmentalConditionVisitor) {
       environmentalConditionVisitor.visitpercentO2(this);
}






}
