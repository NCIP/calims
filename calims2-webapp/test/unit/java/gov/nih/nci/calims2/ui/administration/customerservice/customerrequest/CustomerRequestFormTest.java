/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.customerrequest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.CustomerRequestStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author katariap
 *
 */
public class CustomerRequestFormTest {

  private static final Long[] IDS = new Long[] {1L, 2L };

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    CustomerRequestForm form = new CustomerRequestForm();
    form.setAccountId(1L);
    CRUDFormTestHelper.setNotes(form);
    form.setPersonId(1L);
    form.setServiceIds(IDS);
    form.setStatus(CustomerRequestStatus.APPROVED.name());
    form.setTypeId(1L);
    CustomerRequest entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Account.class, entity.getCustomerAccount(), 1L);
    CRUDFormAssert.assertEntity(Person.class, entity.getCustomerName(), 1L);
    CRUDFormTestHelper.assertNotes(entity);
    CRUDFormAssert.assertEntities(Service.class, entity.getServiceCollection(), IDS);
    assertEquals("Wrong status in the entity", CustomerRequestStatus.APPROVED, entity.getStatus());
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
  }
}
