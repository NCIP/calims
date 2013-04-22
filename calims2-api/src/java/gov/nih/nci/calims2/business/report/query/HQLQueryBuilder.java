/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.query;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import gov.nih.nci.calims2.domain.report.Clause;
import gov.nih.nci.calims2.domain.report.Conjunction;
import gov.nih.nci.calims2.domain.report.Disjunction;
import gov.nih.nci.calims2.domain.report.Negation;
import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.domain.report.Restriction;
import gov.nih.nci.calims2.domain.report.enumeration.Operator;
import gov.nih.nci.calims2.domain.report.visitor.ClauseVisitor;

/**
 * @author viseem
 * 
 */
public class HQLQueryBuilder implements ClauseVisitor {

  private static final Map<Operator, String> OPERATOR_MAP = createOperatorMap();
  private static final Set<Operator> UNARY = createUnaryOperatorSet();

  private Query query;
  private EntityDescriptor descriptor;
  private StringBuilder builder = new StringBuilder();
  private Map<String, Object> parameterMap = new HashMap<String, Object>();

  private static Map<Operator, String> createOperatorMap() {
    Map<Operator, String> map = new HashMap<Operator, String>();
    map.put(Operator.LESS_THAN, " < ");
    map.put(Operator.GREATER_THAN, " > ");
    map.put(Operator.LESS_THAN_OR_EQUAL, " <= ");
    map.put(Operator.GREATER_THAN_OR_EQUAL, " >= ");
    map.put(Operator.EQUAL_TO, " = ");
    map.put(Operator.NOT_EQUAL_TO, " <> ");
    map.put(Operator.IS_NULL, " IS NULL");
    map.put(Operator.IS_NOT_NULL, " IS NOT NULL");
    map.put(Operator.IS_LIKE, " LIKE ");
    map.put(Operator.IS_NOT_LIKE, " NOT LIKE ");
    return map;
  }

  private static Set<Operator> createUnaryOperatorSet() {
    Set<Operator> operators = new HashSet<Operator>();
    operators.add(Operator.IS_NULL);
    operators.add(Operator.IS_NOT_NULL);
    return operators;
  }

  /**
   * Constructor.
   * 
   * @param query The query for which HQL will be constructed.
   * @param descriptor Indicates if the query main entity has 
   */
  
  // rome subclasses and add a descriptor to the constructor.
  public HQLQueryBuilder(Query query, EntityDescriptor descriptor) {
    this.query = query;
    this.descriptor = descriptor;
  }

  /**
   * {@inheritDoc}
   */
  public void visitClause(Clause clause) {
    // Nothing to do
  }

  /**
   * generates a composite clause.
   * 
   * @param subClauses Its sub clauses
   * @param connector The connector to use in the clause
   */
  public void visitCompositeClause(Collection<Clause> subClauses, String connector) {
    builder.append("(");
    boolean connect = false;
    for (Clause subClause : subClauses) {
      if (connect) {
        builder.append(connector);
      } else {
        connect = true;
      }
      subClause.accept(this);
    }
    builder.append(")");
  }

  /**
   * {@inheritDoc}
   */
  public void visitConjunction(Conjunction conjunction) {
    visitCompositeClause(conjunction.getClauseCollection(), " AND ");
  }

  /**
   * {@inheritDoc}
   */
  public void visitDisjunction(Disjunction disjunction) {
    visitCompositeClause(disjunction.getClauseCollection(), " OR ");
  }

  /**
   * {@inheritDoc}
   */
  public void visitNegation(Negation negation) {
    builder.append("NOT(");
    negation.getClause().accept(this);
    builder.append(")");
  }

  /**
   * {@inheritDoc}
   */

  public void visitRestriction(Restriction restriction) {
    builder.append(restriction.getPropertyName());
    builder.append(OPERATOR_MAP.get(restriction.getOperator()));
    if (!UNARY.contains(restriction.getOperator())) {
      PropertyDescriptor propertyDescriptor = descriptor.getPropertyDescriptor(restriction.getPropertyName());
      String type = propertyDescriptor.getType();
      String paramName = "param" + restriction.getId();
      builder.append(":");
      builder.append(paramName);
      builder.append(" ");
      if (type.equals("org.hibernate.type.EnumType")) {
        parameterMap.put(paramName, getParameterValueForEnum(restriction, propertyDescriptor));
      } else  {
           if  (type.equals("boolean")) {
             parameterMap.put(paramName, getParameterValueForBoolean(restriction));
          } else {
             parameterMap.put(paramName, restriction.getValue());
          }
       }
    }
  }
  
/**
 * 
 * @param restriction The Restriction.
 * @param propertyDescriptor The PropertyDescriptor
 * @return value The value of the restriction.
 */
  @SuppressWarnings("unchecked")
  public Object getParameterValueForEnum(Restriction restriction, PropertyDescriptor propertyDescriptor) {
    Object value;
    try {
        Class enumClazz = propertyDescriptor.getReturnedClass();
        value = Enum.valueOf(enumClazz, restriction.getValue().toUpperCase());
      return value;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
  
  /**
   * 
   * @param restriction The restriction.
   * @return value The value of the restriction.
   */

    public Object getParameterValueForBoolean(Restriction restriction) {
      Object value = Boolean.valueOf(restriction.getValue().toLowerCase());
      return value;
    }
  
  /**
   * Gets the HQL query corresponding to this builder Query.
   * 
   * @return the HQL query corresponding to this builder Query
   */
  public String getHQLQuery() {
    builder.append("from ");
    builder.append(query.getMainEntity());
    String alias = " alias" + query.hashCode();
    builder.append(alias);
    Clause rootClause = RootClauseSearch.getRootClause(query);
    boolean hasRootClause = rootClause != null;
    if (hasRootClause || descriptor.getSubClasses()) {
      builder.append(" where ");
    }
    if (descriptor.getSubClasses()) {
      builder.append(alias);
      builder.append(".class = ");
      builder.append(query.getMainEntity());
      builder.append(" ");
      if (hasRootClause) {
        builder.append("AND ");
      }
    }
    if (rootClause != null) {
      rootClause.accept(this);
    }
    return builder.toString();
  }

  /**
   * Gets the map of parameters for the generated query. This method must be called after getHQLQuery
   * 
   * @return The map of parameters for the generated query.
   */
  public Map<String, Object> getParameters() {
    return parameterMap;
  }

}
