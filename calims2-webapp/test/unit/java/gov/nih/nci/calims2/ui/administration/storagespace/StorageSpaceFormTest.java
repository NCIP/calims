/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.storagespace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.StorageSpace;
import gov.nih.nci.calims2.domain.administration.enumeration.StorageDeviceStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.StorageSpaceStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.inventory.Layout;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;

/**
 * @author katariap
 *
 */
public class StorageSpaceFormTest {
  private static final Long[] IDS = new Long[] {1L, 2L };

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    StorageSpaceForm form = new StorageSpaceForm();
    form.setPersonId(1L);
    form.setOrganizationIds(IDS);
    form.setLocationId(1L);
    form.setTypeId(1L);
    form.setLayoutId(1L);
    form.setStatus(StorageDeviceStatus.DEFAULT.name());
    StorageSpace entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Person.class, entity.getContactPerson(), 1L);
    CRUDFormAssert.assertEntities(Organization.class, entity.getOrganizationCollection(), IDS);
    CRUDFormAssert.assertEntity(Location.class, entity.getInternalLocation(), 1L);
    CRUDFormAssert.assertEntity(Layout.class, entity.getLayout(), 1L);
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
    assertEquals("Wrong status in the entity", StorageSpaceStatus.DEFAULT, entity.getStatus());
  }
}
