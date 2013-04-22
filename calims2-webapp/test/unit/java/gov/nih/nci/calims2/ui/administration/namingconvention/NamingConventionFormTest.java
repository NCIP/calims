/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.namingconvention;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionStatus;
import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;

/**
 * @author katariap
 *
 */
public class NamingConventionFormTest {
  
  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    NamingConventionForm form = new NamingConventionForm();
    form.setPersonId(1L);
    form.setLaboratoryId(1L);
    form.setType(NamingConventionType.EQUIPMENTNAME.name());
    form.setStatus(NamingConventionStatus.ACTIVE.name());
    NamingConvention entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Person.class, entity.getContactPerson(), 1L);
    CRUDFormAssert.assertEntity(Laboratory.class, entity.getLaboratory(), 1L);
    assertEquals("Wrong status in the entity", NamingConventionStatus.ACTIVE, entity.getStatus());
    assertEquals("Wrong type in the entity", NamingConventionType.EQUIPMENTNAME, entity.getType());
  }
}
