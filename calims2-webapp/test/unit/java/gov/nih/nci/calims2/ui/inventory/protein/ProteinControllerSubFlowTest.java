/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.protein;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.ui.generic.crud.SubFlowReturnTester;

/**
 * @author connollym
 *
 */
public class ProteinControllerSubFlowTest extends SubFlowReturnTester<ProteinController> {

  /**
   * Constructor.
   * 
   * @param subFlowId The sub flow id
   * @param collection true if the property is a collection
   * @param propertyName The name of the property to test
   */
  public ProteinControllerSubFlowTest(int subFlowId, boolean collection, String propertyName) {
    super(subFlowId, collection, propertyName);
  }

 
  /**
   * Gets the parameterized test data.
   * 
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][] {{ProteinController.ORGANIZATION_SUBFLOW_ID, true, "organizationCollection" }, 
        {ProteinController.LOCATION_SUBFLOW_ID, true, "samplingLocationCollection" }, 
        {ProteinController.TAXON_SUBFLOW_ID, false, "taxon" },
        {ProteinController.PERSON_SUBFLOW_ID, false, "contactPerson" },
        {ProteinController.CONTAINER_SUBFLOW_ID, false, "container" },
        {ProteinController.SPECIMEN_SUBFLOW_ID, false, "parentSpecimen" },
        {ProteinController.TYPE_SUBFLOW_ID, false, "type" }};
    return Arrays.asList(data);
  }
}


