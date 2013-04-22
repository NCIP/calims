/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.antibody;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.ui.generic.crud.SubFlowReturnTester;

/**
 * @author connollym
 *
 */
public class AntibodyControllerSubFlowTest extends SubFlowReturnTester<AntibodyController> {

  /**
   * Constructor.
   * 
   * @param subFlowId The sub flow id
   * @param collection true if the property is a collection
   * @param propertyName The name of the property to test
   */
  public AntibodyControllerSubFlowTest(int subFlowId, boolean collection, String propertyName) {
    super(subFlowId, collection, propertyName);
  }

 
  /**
   * Gets the parameterized test data.
   * 
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][] {{AntibodyController.ORGANIZATION_SUBFLOW_ID, true, "organizationCollection" }, 
        {AntibodyController.LOCATION_SUBFLOW_ID, true, "samplingLocationCollection" }, 
        {AntibodyController.TAXON_SUBFLOW_ID, false, "taxon" },
        {AntibodyController.PERSON_SUBFLOW_ID, false, "contactPerson" },
        {AntibodyController.ANTIGEN_SUBFLOW_ID, false, "antigen" },
        {AntibodyController.CONTAINER_SUBFLOW_ID, false, "container" },
        {AntibodyController.SPECIMEN_SUBFLOW_ID, false, "parentSpecimen" },
        {AntibodyController.TYPE_SUBFLOW_ID, false, "type" }};
    return Arrays.asList(data);
  }
}


