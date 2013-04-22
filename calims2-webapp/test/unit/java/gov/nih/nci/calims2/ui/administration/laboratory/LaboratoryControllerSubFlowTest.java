/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.laboratory;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.ui.generic.crud.SubFlowReturnTester;

/**
 * @author katariap
 * 
 */
public class LaboratoryControllerSubFlowTest extends SubFlowReturnTester<LaboratoryController> {

  /**
   * Constructor.
   * 
   * @param subFlowId The sub flow id
   * @param collection true if the property is a collection
   * @param propertyName The name of the property to test
   */
  public LaboratoryControllerSubFlowTest(int subFlowId, boolean collection, String propertyName) {
    super(subFlowId, collection, propertyName);
  }

  /**
   * Gets the parameterized test data.
   * 
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][] {{LaboratoryController.PERSON_SUBFLOW_ID, true, "personCollection" },
        {LaboratoryController.LOCATION_SUBFLOW_ID, false, "location" }, 
        {LaboratoryController.ORGANIZATION_SUBFLOW_ID, true, "organizationCollection" },
        {LaboratoryController.ROLE_SUBFLOW_ID, true, "roleCollection" } };
    return Arrays.asList(data);
  }
}
