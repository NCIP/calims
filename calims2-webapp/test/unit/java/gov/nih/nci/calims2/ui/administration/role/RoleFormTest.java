/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.role;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.RoleType;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author katariap
 *
 */
public class RoleFormTest {

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    RoleForm form = new RoleForm();
    CRUDFormTestHelper.setNotes(form);
    form.setStatus(RoleStatus.ACTIVE.name());
    form.setType(RoleType.PERSON.name());
    Role entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormTestHelper.assertNotes(entity);
    assertEquals("Wrong status in the entity", RoleStatus.ACTIVE, entity.getStatus());
    assertEquals("Wrong type in the entity", RoleType.PERSON, entity.getType());
  }
}
