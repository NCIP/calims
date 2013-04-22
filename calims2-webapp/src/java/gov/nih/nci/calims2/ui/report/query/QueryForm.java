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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.domain.report.Clause;
import gov.nih.nci.calims2.domain.report.Conjunction;
import gov.nih.nci.calims2.domain.report.Disjunction;
import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.domain.report.Restriction;
import gov.nih.nci.calims2.domain.report.enumeration.Operator;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;

/**
 * @author viseem
 * 
 */
public class QueryForm extends CRUDForm<Query> {
  
  
  private static final long serialVersionUID = -3809377350430606788L;
  
  private Long typeId;
  private String entityNameInput;
  private List<String> property;
  private List<String> propertyType;
  private List<String> operator;
  private List<String> value;
  private List<String> connector;

  /**
   * Default constructor.
   */
  public QueryForm() {
    setEntity(new Query());
  }

  /**
   * {@inheritDoc}
   */
  public Query getSubmittedEntity() {
    Query query = getEntity();
    query.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    query.setMainEntity(QueriedEntity.valueOf(entityNameInput).getPersistentClass().getName());
    query.setClauseCollection(getClauses(getClauseRows()));
    return query;
  }
  
  /**
   * Gets the clause rows from the request.
   * 
   * @return The list of clause rows
   */
  public List<ClauseRow> getClauseRows() {
    List<ClauseRow> rows = new ArrayList<ClauseRow>();
    if (property != null) {
      for (int i = 0; i < property.size(); i++) {
        String propertyName = StringUtils.trimToEmpty(property.get(i));
        if (StringUtils.isNotEmpty(propertyName)) {
          ClauseRow row = new ClauseRow();
          row.setPropertyName(propertyName);
          row.setPropertyType(StringUtils.stripToEmpty(propertyType.get(i)));
          row.setOperator(Operator.valueOf(operator.get(i)));
          row.setValue(StringUtils.stripToEmpty(value.get(i)));
          if (connector != null && i < connector.size()) {
            String connectorName = StringUtils.stripToNull(connector.get(i));
            if (connectorName != null) {
              row.setConnector(LogicalConnector.valueOf(connectorName));
            }
          }
          row.setClauseIndex(i);
          rows.add(row);
        }
      }
    }
    return rows;
  }

  /**
   * Creates the clauses from the clauseRow list.
   * @param rows the clause rows
   * @return the clauses to put in the query
   */
  public Set<Clause> getClauses(List<ClauseRow> rows) {
    Set<Clause> clauses = new HashSet<Clause>();
    switch (rows.size()) {
      case 0: {
        break;
      }
      case 1: {
        clauses.add(rows.get(0).createRestriction());
        break;
      }
      default: {
        List<Integer> orIndices = new ArrayList<Integer>();
        int i = 0;
        for (ClauseRow row : rows) {
          if (row.getConnector() != LogicalConnector.AND) {
            orIndices.add(i); 
          }
          i++;
        }
        List<Clause> subClauses = new ArrayList<Clause>();
        int start = 0;
        for (int end : orIndices) {
          if (start < end) {
            Conjunction conjunction = new Conjunction();
            clauses.add(conjunction);
            Set<Clause> andOperands = new HashSet<Clause>();
            for (i = start; i <= end; i++) {
              Restriction andOperand = rows.get(i).createRestriction();
              andOperands.add(andOperand);
              clauses.add(andOperand);
            }
            conjunction.setClauseCollection(andOperands);
            conjunction.setClauseIndex(end);
            subClauses.add(conjunction);
          } else {
            Restriction restriction = rows.get(start).createRestriction();
            subClauses.add(restriction);
            clauses.add(restriction);
          }
          start = end + 1;
        }
        if (subClauses.size() > 1) {
          Disjunction disjunction = new Disjunction();
          disjunction.setClauseCollection(new HashSet<Clause>(subClauses));
          disjunction.setClauseIndex(subClauses.size());
          clauses.add(disjunction);
        }
        break;
      }
    }
    return clauses;
  }

  /**
   * @return the typeId
   */
  public Long getTypeId() {
    return typeId;
  }

  /**
   * @param typeId the typeId to set
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

  /**
   * @return the entityNameInput
   */
  public String getEntityNameInput() {
    return entityNameInput;
  }

  /**
   * @param entityNameInput the entityNameInput to set
   */
  public void setEntityNameInput(String entityNameInput) {
    this.entityNameInput = entityNameInput;
  }

  /**
   * @return the property
   */
  public List<String> getProperty() {
    return property;
  }

  /**
   * @param property the property to set
   */
  public void setProperty(List<String> property) {
    this.property = property;
  }

  /**
   * @return the propertyType
   */
  public List<String> getPropertyType() {
    return propertyType;
  }

  /**
   * @param propertyType the propertyType to set
   */
  public void setPropertyType(List<String> propertyType) {
    this.propertyType = propertyType;
  }

  /**
   * @return the operator
   */
  public List<String> getOperator() {
    return operator;
  }

  /**
   * @param operator the operator to set
   */
  public void setOperator(List<String> operator) {
    this.operator = operator;
  }

  /**
   * @return the value
   */
  public List<String> getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(List<String> value) {
    this.value = value;
  }

  /**
   * @return the connector
   */
  public List<String> getConnector() {
    return connector;
  }

  /**
   * @param connector the connector to set
   */
  public void setConnector(List<String> connector) {
    this.connector = connector;
  }

}
