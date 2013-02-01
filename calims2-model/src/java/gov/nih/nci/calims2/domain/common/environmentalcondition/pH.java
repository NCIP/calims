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
@DiscriminatorValue("pH")

public class pH extends EnvironmentalCondition {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private Long maximumPH;
  /**
* Retrieves the value of the maximumPH attribute.
* @return maximumPH
**/
  
  @Column(name = "MAXIMUMPH", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getMaximumPH() {
  return maximumPH;
  }
  /**
* Sets the value of maximumPH attribute.
* @param maximumPH .
**/
  public void setMaximumPH(Long 
  maximumPH) {
  this.maximumPH = maximumPH;
  }
  /**
* 
**/
  private Long measuredPH;
  /**
* Retrieves the value of the measuredPH attribute.
* @return measuredPH
**/
  
  @Column(name = "MEASUREDPH", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getMeasuredPH() {
  return measuredPH;
  }
  /**
* Sets the value of measuredPH attribute.
* @param measuredPH .
**/
  public void setMeasuredPH(Long 
  measuredPH) {
  this.measuredPH = measuredPH;
  }
  /**
* 
**/
  private Long minimumPH;
  /**
* Retrieves the value of the minimumPH attribute.
* @return minimumPH
**/
  
  @Column(name = "MINIMUMPH", length = EntityWithId.COLUMNLENGTH)
  
  
  public Long getMinimumPH() {
  return minimumPH;
  }
  /**
* Sets the value of minimumPH attribute.
* @param minimumPH .
**/
  public void setMinimumPH(Long 
  minimumPH) {
  this.minimumPH = minimumPH;
  }
/** Accepts the EnvironmentalConditionVisitor.
 * @param environmentalConditionVisitor The EnvironmentalConditionVisitor to accept.
 **/ public void accept(EnvironmentalConditionVisitor environmentalConditionVisitor) {
       environmentalConditionVisitor.visitpH(this);
}






}
