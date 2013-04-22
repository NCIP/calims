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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.OrganizationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;

/**
 * @author katariap
 *
 */
public class OrganizationFormTest {
  
  private static final Long[] IDS = new Long[] {1L, 2L };
  
  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    OrganizationForm form = new OrganizationForm();
    form.setRoleIds(IDS);
    form.setLocationId(1L);
    form.setTypeId(1L);
    form.setParentOrganizationId(1L);
    form.setStatus(OrganizationStatus.ACTIVE.name());
    Organization entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntities(Role.class, entity.getRoleCollection(), IDS);
    CRUDFormAssert.assertEntity(Location.class, entity.getLocation(), 1L);
    CRUDFormAssert.assertEntity(Organization.class, entity.getParentOrganization(), 1L);
    assertEquals("Wrong status in the entity", OrganizationStatus.ACTIVE, entity.getStatus());
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
  }
}
