/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author katariap
 *
 */
public class AccountFormTest {

  private static final Long[] IDS = new Long[] {1L, 2L };

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    AccountForm form = new AccountForm();
    form.setTypeId(1L);
    form.setAccountNumberIds(IDS);
    form.setLaboratoryId(1L);
    CRUDFormTestHelper.setNotes(form);
    form.setOrganizationId(1L);
    form.setStatus(AccountStatus.ACTIVE.name());
    Account entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
    CRUDFormAssert.assertEntities(AccountNumber.class, entity.getAccountNumberCollection(), IDS);
    CRUDFormAssert.assertEntity(Laboratory.class, entity.getLaboratory(), 1L);
    CRUDFormTestHelper.assertNotes(entity);
    CRUDFormAssert.assertEntity(Organization.class, entity.getOrganization(), 1L);
    assertEquals("Wrong status in the entity", AccountStatus.ACTIVE, entity.getStatus());
  }
}
