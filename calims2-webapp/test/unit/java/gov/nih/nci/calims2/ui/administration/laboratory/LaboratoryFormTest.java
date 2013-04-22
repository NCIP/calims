/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.laboratory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.LaboratoryStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;

/**
 * @author katariap
 * 
 */
public class LaboratoryFormTest {
  private static final Long[] IDS = new Long[] {1L, 2L };

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    LaboratoryForm form = new LaboratoryForm();
    form.setPersonIds(IDS);
    form.setOrganizationIds(IDS);
    form.setContactInformationIds(IDS);
    form.setRoleIds(IDS);
    form.setLocationId(1L);
    form.setStatus(LaboratoryStatus.ACTIVE.name());
    Laboratory entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntities(Person.class, entity.getPersonCollection(), IDS);
    CRUDFormAssert.assertEntities(Organization.class, entity.getOrganizationCollection(), IDS);
    CRUDFormAssert.assertEntities(ContactInformation.class, entity.getContactInformationCollection(), IDS);
    CRUDFormAssert.assertEntities(Role.class, entity.getRoleCollection(), IDS);
    CRUDFormAssert.assertEntity(Location.class, entity.getLocation(), 1L);
    assertEquals("Wrong status in the entity", LaboratoryStatus.ACTIVE, entity.getStatus());
  }

}
