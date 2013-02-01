package gov.nih.nci.calims2.domain.report;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.report.visitor.ClauseVisitor;
/**
* 
**/

@Entity
@Table(name = "RESTRICTION")
@PrimaryKeyJoinColumn(name = "ID")
@org.hibernate.annotations.ForeignKey(name = "FK_RESTRICTION_CLAUSE")

public class Restriction extends Clause {
/**
* An attribute to allow serialization of the domain objects.
*/
private static final long serialVersionUID = 1234567890L;
  /**
* 
**/
  private gov.nih.nci.calims2.domain.report.enumeration.Operator operator;
  /**
* Retrieves the value of the operator attribute.
* @return operator
**/
  
  @Enumerated(EnumType.STRING)
@Column(name = "OPERATOR", length = EntityWithId.COLUMNLENGTH)
  
  
  public gov.nih.nci.calims2.domain.report.enumeration.Operator getOperator() {
  return operator;
  }
  /**
* Sets the value of operator attribute.
* @param operator .
**/
  public void setOperator(gov.nih.nci.calims2.domain.report.enumeration.Operator 
  operator) {
  this.operator = operator;
  }
  /**
* 
**/
  private String propertyName;
  /**
* Retrieves the value of the propertyName attribute.
* @return propertyName
**/
  
  @Column(name = "PROPERTYNAME", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getPropertyName() {
  return propertyName;
  }
  /**
* Sets the value of propertyName attribute.
* @param propertyName .
**/
  public void setPropertyName(String 
  propertyName) {
  this.propertyName = propertyName;
  }
  /**
* 
**/
  private String propertyType;
  /**
* Retrieves the value of the propertyType attribute.
* @return propertyType
**/
  
  @Column(name = "PROPERTYTYPE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getPropertyType() {
  return propertyType;
  }
  /**
* Sets the value of propertyType attribute.
* @param propertyType .
**/
  public void setPropertyType(String 
  propertyType) {
  this.propertyType = propertyType;
  }
  /**
* 
**/
  private String value;
  /**
* Retrieves the value of the value attribute.
* @return value
**/
  
  @Column(name = "VALUE", length = EntityWithId.COLUMNLENGTH)
  
  
  public String getValue() {
  return value;
  }
  /**
* Sets the value of value attribute.
* @param value .
**/
  public void setValue(String 
  value) {
  this.value = value;
  }


/** Accepts the ClauseVisitor.
 * @param clauseVisitor The clauseVisitor to accept.
 **/ public void accept(ClauseVisitor clauseVisitor) {
       clauseVisitor.visitRestriction(this);
}




}
