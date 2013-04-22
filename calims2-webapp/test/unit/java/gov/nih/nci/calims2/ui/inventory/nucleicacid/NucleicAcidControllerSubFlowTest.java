/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.nucleicacid;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.ui.generic.crud.SubFlowReturnTester;

/**
 * @author katariap
 *
 */
public class NucleicAcidControllerSubFlowTest extends SubFlowReturnTester<NucleicAcidController> {

  /**
   * Constructor.
   * 
   * @param subFlowId The sub flow id
   * @param collection true if the property is a collection
   * @param propertyName The name of the property to test
   */
  public NucleicAcidControllerSubFlowTest(int subFlowId, boolean collection, String propertyName) {
    super(subFlowId, collection, propertyName);
  }

 
  /**
   * Gets the parameterized test data.
   * 
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][] {{NucleicAcidController.ORGANIZATION_SUBFLOW_ID, true, "organizationCollection" }, 
        {NucleicAcidController.LOCATION_SUBFLOW_ID, true, "samplingLocationCollection" }, 
        {NucleicAcidController.TAXON_SUBFLOW_ID, false, "taxon" },
        {NucleicAcidController.PERSON_SUBFLOW_ID, false, "contactPerson" },
        {NucleicAcidController.CONTAINER_SUBFLOW_ID, false, "container" },
        {NucleicAcidController.SPECIMEN_SUBFLOW_ID, false, "parentSpecimen" },
        {NucleicAcidController.TYPE_SUBFLOW_ID, false, "type" }};
    return Arrays.asList(data);
  }
}
