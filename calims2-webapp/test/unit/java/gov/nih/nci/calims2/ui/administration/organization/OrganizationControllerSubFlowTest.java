/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.organization;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.ui.generic.crud.SubFlowReturnTester;

/**
 * @author katariap
 *
 */
public class OrganizationControllerSubFlowTest extends SubFlowReturnTester<OrganizationController> {

  /**
   * Constructor.
   * 
   * @param subFlowId The sub flow id
   * @param collection true if the property is a collection
   * @param propertyName The name of the property to test
   */
  public OrganizationControllerSubFlowTest(int subFlowId, boolean collection, String propertyName) {
    super(subFlowId, collection, propertyName);
  }

  /**
   * Gets the parameterized test data.
   * 
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][] {{OrganizationController.LOCATION_SUBFLOW_ID, false, "location" },
        {OrganizationController.ROLE_SUBFLOW_ID, true, "roleCollection" },
        {OrganizationController.ORGANIZATION_SUBFLOW_ID, false, "parentOrganization" }, 
        {OrganizationController.TYPE_SUBFLOW_ID, false, "type" }};
    return Arrays.asList(data);
  }
}
