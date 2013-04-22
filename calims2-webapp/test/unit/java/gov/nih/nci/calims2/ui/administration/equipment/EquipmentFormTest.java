/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.equipment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Equipment;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Software;
import gov.nih.nci.calims2.domain.administration.enumeration.EquipmentStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;

/**
 * @author katariap
 *
 */
public class EquipmentFormTest {
  
  private static final Long[] IDS = new Long[] {1L, 2L };

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    EquipmentForm form = new EquipmentForm();
    form.setLaboratoryId(1L);
    form.setLocationId(1L);
    form.setPersonIds(IDS);
    form.setOrganizationIds(IDS);
    form.setSoftwareIds(IDS);
    form.setTypeId(1L);
    form.setStatus(EquipmentStatus.ACTIVE.name());
    Equipment entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Laboratory.class, entity.getLaboratory(), 1L);
    CRUDFormAssert.assertEntity(Location.class, entity.getLocation(), 1L);
    CRUDFormAssert.assertEntities(Person.class, entity.getPersonCollection(), IDS);
    CRUDFormAssert.assertEntities(Organization.class, entity.getOrganizationCollection(), IDS);
    CRUDFormAssert.assertEntities(Software.class, entity.getSoftwareCollection(), IDS);
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
    assertEquals("Wrong status in the entity", EquipmentStatus.ACTIVE, entity.getStatus());
  }
}
