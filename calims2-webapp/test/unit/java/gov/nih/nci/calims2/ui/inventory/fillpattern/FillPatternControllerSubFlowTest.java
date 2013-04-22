/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.fillpattern;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.ui.generic.crud.SubFlowReturnTester;

/**
 * @author connollym
 *
 */
public class FillPatternControllerSubFlowTest extends SubFlowReturnTester<FillPatternController> {

  /**
   * Constructor.
   * 
   * @param subFlowId The sub flow id
   * @param collection true if the property is a collection
   * @param propertyName The name of the property to test
   */
  public FillPatternControllerSubFlowTest(int subFlowId, boolean collection, String propertyName) {
    super(subFlowId, collection, propertyName);
  }

 
  /**
   * Gets the parameterized test data.
   * 
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][] {{FillPatternController.PERSON_SUBFLOW_ID, false, "contactPerson" },
        {FillPatternController.LAYOUT_SUBFLOW_ID, false, "layout" }};
    return Arrays.asList(data);
  }
}
