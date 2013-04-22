/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.taglib.form;

import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.EvaluationException;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * Helper class for implementation of single select tags.
 * 
 * @author viseem
 * 
 */
public class SingleSelectHelper {
  /**
   * Interprets the properties String and returns a map of property name to expressions.
   * 
   * @param propertyString The string to interpret
   * @return The properties expression map
   */
  static Map<String, Expression> getPropertyMap(String propertyString) {
    ExpressionParser expressionParser = new SpelExpressionParser();
    Map<String, Expression> map = new TreeMap<String, Expression>();
    if (propertyString != null) {
      for (String propertySpec : propertyString.split(",")) {
        String[] propertyElements = propertySpec.split(":");
        if (propertyElements == null || propertyElements.length != 2) {
          throw new IllegalArgumentException("Invalid property specification: " + propertySpec);
        }
        String name = StringUtils.stripToNull(propertyElements[0]);
        if (name == null) {
          throw new IllegalArgumentException("Invalid property name");
        }
        String value = StringUtils.stripToNull(propertyElements[1]);
        if (value == null) {
          throw new IllegalArgumentException("Invalid property value");
        }
        map.put(name, expressionParser.parseExpression(value));
      }

    }
    return map;
  }

  /**
   * Evaluate the given expression in the given context.
   * 
   * @param expression The expression to evaluate
   * @param context The evaluation context
   * @return The value of the expression as a string.
   */
  static String evaluateExpression(Expression expression, EvaluationContext context) {
    try {
      Object value = expression.getValue(context);
      return (value != null) ? value.toString() : "";
    } catch (EvaluationException e) {
      return "";
    }
  }
}
