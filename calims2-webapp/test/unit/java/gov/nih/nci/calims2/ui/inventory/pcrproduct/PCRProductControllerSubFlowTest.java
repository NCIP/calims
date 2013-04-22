/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.pcrproduct;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.ui.generic.crud.SubFlowReturnTester;

/**
 * @author connollym
 *
 */
public class PCRProductControllerSubFlowTest extends SubFlowReturnTester<PCRProductController> {

  /**
   * Constructor.
   * 
   * @param subFlowId The sub flow id
   * @param collection true if the property is a collection
   * @param propertyName The name of the property to test
   */
  public PCRProductControllerSubFlowTest(int subFlowId, boolean collection, String propertyName) {
    super(subFlowId, collection, propertyName);
  }

 
  /**
   * Gets the parameterized test data.
   * 
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][] {{PCRProductController.TYPE_SUBFLOW_ID, false, "type" },
        {PCRProductController.TAXON_SUBFLOW_ID, false, "taxon" },
        {PCRProductController.ORGANIZATION_SUBFLOW_ID, true, "organizationCollection" }, 
        {PCRProductController.LOCATION_SUBFLOW_ID, true, "samplingLocationCollection" }, 
        {PCRProductController.CONTAINER_SUBFLOW_ID, false, "container" },
        {PCRProductController.PERSON_SUBFLOW_ID, false, "contactPerson" },
        {PCRProductController.PCRPRODUCT_SUBFLOW_ID, false, "parentSpecimen" },
        {PCRProductController.REVERSEPRIMER_SUBFLOW_ID, false, "reversePrimer"},
        {PCRProductController.FORWARDPRIMER_SUBLFLOW_ID, false, "forwardPrimer"}};
    return Arrays.asList(data);
  }
}


