/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.labsupply;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.domain.inventory.LabSupply;
import gov.nih.nci.calims2.domain.inventory.enumeration.LabSupplyStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author katariap
 *
 */
public class LabSupplyFormTest {
  private static final Long[] IDS = new Long[] {1L, 2L };

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    LabSupplyForm form = new LabSupplyForm();
    form.setContainerId(1L);
    CRUDFormTestHelper.setNotes(form);
    form.setOrganizationIds(IDS);
    form.setPersonIds(IDS);
    form.setStatus(LabSupplyStatus.DEFAULT.name());
    form.setTypeId(1L);
    LabSupply entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Container.class, entity.getContainer(), 1L);
    CRUDFormTestHelper.assertNotes(entity);
    CRUDFormAssert.assertEntities(Organization.class, entity.getOrganizationCollection(), IDS);
    CRUDFormAssert.assertEntities(Person.class, entity.getPersonCollection(), IDS);
    assertEquals("Wrong status in the entity", LabSupplyStatus.DEFAULT, entity.getStatus());
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
  }
}
