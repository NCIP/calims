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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import gov.nih.nci.calims2.domain.report.enumeration.Operator;

/**
 * @author viseem
 *
 */
public class QueryFormTest {
  
  private static final int NUMBER_OF_ROWS = 4;
  private static final String[] PROPERTY_RESULT = {"p0", "p1", "p2", "p4"};
  private static final String[] TYPE_RESULT = {"t0", "t1", "t2", "t4"};
  private static final Operator[] OPERATOR_RESULT = {Operator.EQUAL_TO, Operator.EQUAL_TO, Operator.EQUAL_TO, 
                                                     Operator.NOT_EQUAL_TO};
  private static final String[] VALUE_RESULT = {"v0", "v1", "v2", "v4"};
  private static final LogicalConnector[] CONNECTOR_RESULT = {LogicalConnector.AND, LogicalConnector.OR, LogicalConnector.AND,
                                                              null};
  
  /**
   * test the getClauseRows method.
   */
  @Test
  public void testgetClauseRows() {
    QueryForm form = new QueryForm();
    createFields(form);
    List<ClauseRow> rows = form.getClauseRows();
    assertNotNull("No rows returned");
    assertEquals("Wrong number of rows", NUMBER_OF_ROWS, rows.size());
    for (int i = 0; i < NUMBER_OF_ROWS; i++) {
      ClauseRow row = rows.get(i);
      assertEquals("Wrong property name in row " + i, PROPERTY_RESULT[i], row.getPropertyName());
      assertEquals("Wrong property type in row " + i, TYPE_RESULT[i], row.getPropertyType());
      assertEquals("Wrong operator in row " + i, OPERATOR_RESULT[i], row.getOperator());
      assertEquals("Wrong value in row " + i, VALUE_RESULT[i], row.getValue());
      assertEquals("Wrong connector in row " + i, CONNECTOR_RESULT[i], row.getConnector());
    }
  }

  private void createFields(QueryForm form) {
    form.setProperty(Arrays.asList("p0", "p1", "p2", null, "p4"));
    form.setPropertyType(Arrays.asList("t0", "t1", "t2", null, "t4"));
    form.setOperator(Arrays.asList(Operator.EQUAL_TO.name(), Operator.EQUAL_TO.name(), Operator.EQUAL_TO.name(), null,
        Operator.NOT_EQUAL_TO.name()));
    form.setValue(Arrays.asList("v0", "v1", "v2", null, "v4"));
    form.setConnector(Arrays.asList(LogicalConnector.AND.name(), LogicalConnector.OR.name(), LogicalConnector.AND.name()));
  }

}
