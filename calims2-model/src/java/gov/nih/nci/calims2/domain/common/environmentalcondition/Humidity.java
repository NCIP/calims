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
@DiscriminatorValue("Humidity")

public class Humidity extends EnvironmentalCondition {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private String maximumHumidity;
  /**
* Retrieves the value of the maximumHumidity attribute.
* @return maximumHumidity
**/
  
  @Column(name = "MAXIMUMHUMIDITY", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getMaximumHumidity() {
  return maximumHumidity;
  }
  /**
* Sets the value of maximumHumidity attribute.
* @param maximumHumidity .
**/
  public void setMaximumHumidity(String 
  maximumHumidity) {
  this.maximumHumidity = maximumHumidity;
  }
  /**
* 
**/
  private String measuredHumidity;
  /**
* Retrieves the value of the measuredHumidity attribute.
* @return measuredHumidity
**/
  
  @Column(name = "MEASUREDHUMIDITY", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getMeasuredHumidity() {
  return measuredHumidity;
  }
  /**
* Sets the value of measuredHumidity attribute.
* @param measuredHumidity .
**/
  public void setMeasuredHumidity(String 
  measuredHumidity) {
  this.measuredHumidity = measuredHumidity;
  }
  /**
* 
**/
  private String minimumHumidity;
  /**
* Retrieves the value of the minimumHumidity attribute.
* @return minimumHumidity
**/
  
  @Column(name = "MINIMUMHUMIDITY", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getMinimumHumidity() {
  return minimumHumidity;
  }
  /**
* Sets the value of minimumHumidity attribute.
* @param minimumHumidity .
**/
  public void setMinimumHumidity(String 
  minimumHumidity) {
  this.minimumHumidity = minimumHumidity;
  }
/** Accepts the EnvironmentalConditionVisitor.
 * @param environmentalConditionVisitor The EnvironmentalConditionVisitor to accept.
 **/ public void accept(EnvironmentalConditionVisitor environmentalConditionVisitor) {
       environmentalConditionVisitor.visitHumidity(this);
}






}
