/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.nanomaterial;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.ui.generic.crud.SubFlowReturnTester;

/**
 * @author connollym
 *
 */
public class NanomaterialControllerSubFlowTest extends SubFlowReturnTester<NanomaterialController> {

  /**
   * Constructor.
   * 
   * @param subFlowId The sub flow id
   * @param collection true if the property is a collection
   * @param propertyName The name of the property to test
   */
  public NanomaterialControllerSubFlowTest(int subFlowId, boolean collection, String propertyName) {
    super(subFlowId, collection, propertyName);
  }

 
  /**
   * Gets the parameterized test data.
   * 
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][] {{NanomaterialController.ORGANIZATION_SUBFLOW_ID, true, "organizationCollection" }, 
        {NanomaterialController.LOCATION_SUBFLOW_ID, true, "samplingLocationCollection" }, 
        {NanomaterialController.SPECIMEN_SUBFLOW_ID, false, "parentSpecimen" },
        {NanomaterialController.CHEMICALCOMPOUND_SUBFLOW_ID, false, "chemicalCompound" },
        {NanomaterialController.PERSON_SUBFLOW_ID, false, "contactPerson" },
        {NanomaterialController.CONTAINER_SUBFLOW_ID, false, "container" }};
    return Arrays.asList(data);
  }
}



