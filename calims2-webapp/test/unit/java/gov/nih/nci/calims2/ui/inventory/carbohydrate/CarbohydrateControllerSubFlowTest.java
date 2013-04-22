/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.carbohydrate;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.ui.generic.crud.SubFlowReturnTester;

/**
 * @author connollym
 *
 */
public class CarbohydrateControllerSubFlowTest extends SubFlowReturnTester<CarbohydrateController> {

  /**
   * Constructor.
   * 
   * @param subFlowId The sub flow id
   * @param collection true if the property is a collection
   * @param propertyName The name of the property to test
   */
  public CarbohydrateControllerSubFlowTest(int subFlowId, boolean collection, String propertyName) {
    super(subFlowId, collection, propertyName);
  }

 
  /**
   * Gets the parameterized test data.
   * 
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][] {{CarbohydrateController.ORGANIZATION_SUBFLOW_ID, true, "organizationCollection" }, 
        {CarbohydrateController.LOCATION_SUBFLOW_ID, true, "samplingLocationCollection" }, 
        {CarbohydrateController.TAXON_SUBFLOW_ID, false, "taxon" },
        {CarbohydrateController.PERSON_SUBFLOW_ID, false, "contactPerson" },
        {CarbohydrateController.CONTAINER_SUBFLOW_ID, false, "container" },
        {CarbohydrateController.SPECIMEN_SUBFLOW_ID, false, "parentSpecimen" },
        {CarbohydrateController.TYPE_SUBFLOW_ID, false, "type" }};
    return Arrays.asList(data);
  }
}


