/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.contract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.customerservice.Contract;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ContractStatus;

/**
 * @author katariap
 *
 */
public class ContractFormTest {


  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    ContractForm form = new ContractForm();
    form.setStatus(ContractStatus.DEFAULT.name());
    Contract entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    assertEquals("Wrong status in the entity", ContractStatus.DEFAULT, entity.getStatus());
  }
}
