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

import org.junit.Test;

import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;

/**
 * @author viseem
 * 
 */
public class QueryControllerTest {
  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    QueryController controller = new QueryController();
    CRUDAssert.assertControllerConstructor(controller, QueryController.URL_PREFIX, "report.query.", "name", Query.class,
        QueryForm.class, QueryTableDecorator.class);
  }
}
