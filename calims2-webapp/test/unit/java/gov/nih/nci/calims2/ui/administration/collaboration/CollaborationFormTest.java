/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.collaboration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Collaboration;
import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.Role;
import gov.nih.nci.calims2.domain.administration.enumeration.CollaborationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;

/**
 * @author katariap
 * 
 */
public class CollaborationFormTest {

  private static final Long[] IDS = new Long[] {1L, 2L };

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    CollaborationForm form = new CollaborationForm();
    form.setContactInformationIds(IDS);
    form.setLaboratoryIds(IDS);
    form.setOrganizationIds(IDS);
    form.setPersonIds(IDS);
    form.setRoleId(1L);
    form.setTypeId(1L);
    form.setStatus(CollaborationStatus.ACTIVE.name());
    Collaboration entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntities(ContactInformation.class, entity.getContactInformationCollection(), IDS);
    CRUDFormAssert.assertEntities(Laboratory.class, entity.getLaboratoryCollection(), IDS);
    CRUDFormAssert.assertEntities(Organization.class, entity.getOrganizationCollection(), IDS);
    CRUDFormAssert.assertEntities(Person.class, entity.getPersonCollection(), IDS);
    CRUDFormAssert.assertEntity(Role.class, entity.getRole(), 1L);
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
    assertEquals("Wrong status in the entity", CollaborationStatus.ACTIVE, entity.getStatus());
  }
}
