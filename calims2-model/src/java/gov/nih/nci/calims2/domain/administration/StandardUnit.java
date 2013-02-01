package gov.nih.nci.calims2.domain.administration;

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

import gov.nih.nci.calims2.domain.administration.visitor.UnitVisitor;

import java.util.Set;
import java.util.List;
import java.util.HashSet;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
/**
* 
**/

@Entity
@Table(name = "STANDARDUNIT")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_STANDARDUNIT_UNIT")

public class StandardUnit extends Unit {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private java.math.BigDecimal conversionFactor;
  /**
* Retrieves the value of the conversionFactor attribute.
* @return conversionFactor
**/
  
  @Column(name = "CONVERSIONFACTOR", length = EntityWithId.COLUMNLENGTH)
  
  
  public java.math.BigDecimal getConversionFactor() {
  return conversionFactor;
  }
  /**
* Sets the value of conversionFactor attribute.
* @param conversionFactor .
**/
  public void setConversionFactor(java.math.BigDecimal 
  conversionFactor) {
  this.conversionFactor = conversionFactor;
  }
  /**
* 
**/
  private String dataSource;
  /**
* Retrieves the value of the dataSource attribute.
* @return dataSource
**/
  
  @Column(name = "DATASOURCE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getDataSource() {
  return dataSource;
  }
  /**
* Sets the value of dataSource attribute.
* @param dataSource .
**/
  public void setDataSource(String 
  dataSource) {
  this.dataSource = dataSource;
  }
  /**
* 
**/
  private String dataTarget;
  /**
* Retrieves the value of the dataTarget attribute.
* @return dataTarget
**/
  
  @Column(name = "DATATARGET", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getDataTarget() {
  return dataTarget;
  }
  /**
* Sets the value of dataTarget attribute.
* @param dataTarget .
**/
  public void setDataTarget(String 
  dataTarget) {
  this.dataTarget = dataTarget;
  }
  /**
* 
**/
  private java.math.BigDecimal offsetValue;
  /**
* Retrieves the value of the offsetValue attribute.
* @return offsetValue
**/
  
  @Column(name = "OFFSETVALUE", length = EntityWithId.COLUMNLENGTH)
  
  
  public java.math.BigDecimal getOffsetValue() {
  return offsetValue;
  }
  /**
* Sets the value of offsetValue attribute.
* @param offsetValue .
**/
  public void setOffsetValue(java.math.BigDecimal 
  offsetValue) {
  this.offsetValue = offsetValue;
  }
   
        /**
* An associated gov.nih.nci.calims2.domain.administration.BaseUnit object.
**/
        private gov.nih.nci.calims2.domain.administration.BaseUnit baseUnit;
        /**
* Retrieves the value of the baseUnit attribute.
* @return baseUnit
**/
        
       
        @ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "BASEUNIT_FK")
@org.hibernate.annotations.ForeignKey(name = "STANDABASEUN_FK")

        public gov.nih.nci.calims2.domain.administration.BaseUnit getBaseUnit() {
        return baseUnit;
        }
   
        /**
* Sets the value of baseUnit attribute.
* @param baseUnit .
**/
        public void setBaseUnit(gov.nih.nci.calims2.domain.administration.BaseUnit baseUnit) {
        this.baseUnit = baseUnit;
        }
   



/** Accepts the UnitVisitor.
 * @param unitVisitor The unitVisitor to accept.
 **/ public void accept(UnitVisitor unitVisitor) {
       unitVisitor.visitStandardUnit(this);
}



}
