/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.PersonStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;

/**
 * @author katariap
 *
 */
public class PersonFormTest {


  private static final Long[] IDS = new Long[] {1L, 2L };
  
  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    PersonForm form = new PersonForm();
    form.setContactInformationIds(IDS);
    form.setRoleIds(IDS);
    form.setOrganizationIds(IDS);
    form.setStatus(PersonStatus.ACTIVE.name());
    Person entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntities(ContactInformation.class, entity.getContactInformationCollection(), IDS);
    CRUDFormAssert.assertEntities(Role.class, entity.getRoleCollection(), IDS);
    CRUDFormAssert.assertEntities(Organization.class, entity.getOrganizationCollection(), IDS);
    assertEquals("Wrong status in the entity", PersonStatus.ACTIVE, entity.getStatus());
  }
  
}
