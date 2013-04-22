/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.rate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.RateStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author katariap
 * 
 */
public class RateFormTest {

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    RateForm form = new RateForm();
    form.setPersonId(1L);
    form.setTypeId(1L);
    CRUDFormTestHelper.setNotes(form);
    form.setStatus(RateStatus.DEFAULT.name());
    Rate entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
    CRUDFormAssert.assertEntity(Person.class, entity.getContactPerson(), 1L);
    assertEquals("Wrong status in the entity", RateStatus.DEFAULT, entity.getStatus());
    CRUDFormTestHelper.assertNotes(entity);
  }
}
