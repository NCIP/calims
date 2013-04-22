/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.query;

import java.io.Serializable;

import gov.nih.nci.calims2.domain.report.Restriction;
import gov.nih.nci.calims2.domain.report.enumeration.Operator;

/**
 * @author viseem
 * 
 */
public class ClauseRow implements Serializable {

  private static final long serialVersionUID = 8763437598302740303L;
  
  private String propertyName;
  private String propertyType;
  private Operator operator;
  private String value;
  private LogicalConnector connector;
  private int clauseIndex;

  /**
   * @return the propertyName
   */
  public String getPropertyName() {
    return propertyName;
  }

  /**
   * @param propertyName the propertyName to set
   */
  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

  /**
   * @return the propertyType
   */
  public String getPropertyType() {
    return propertyType;
  }

  /**
   * @param propertyType the propertyType to set
   */
  public void setPropertyType(String propertyType) {
    this.propertyType = propertyType;
  }

  /**
   * @return the operator
   */
  public Operator getOperator() {
    return operator;
  }

  /**
   * @param operator the operator to set
   */
  public void setOperator(Operator operator) {
    this.operator = operator;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * @return the connector
   */
  public LogicalConnector getConnector() {
    return connector;
  }

  /**
   * @param connector the connector to set
   */
  public void setConnector(LogicalConnector connector) {
    this.connector = connector;
  }

  /**
   * @return the clauseIndex
   */
  public int getClauseIndex() {
    return clauseIndex;
  }

  /**
   * @param clauseIndex the clauseIndex to set
   */
  public void setClauseIndex(int clauseIndex) {
    this.clauseIndex = clauseIndex;
  }

  /**
   * Create a Restriction object for this clause row.
   * 
   * @return a Restriction object for this clause row.
   */
  public Restriction createRestriction() {
    Restriction restriction = new Restriction();
    restriction.setPropertyName(propertyName);
    restriction.setPropertyType(propertyType);
    restriction.setOperator(operator);
    restriction.setValue(value);
    restriction.setClauseIndex(clauseIndex);
    return restriction;
  }

}
