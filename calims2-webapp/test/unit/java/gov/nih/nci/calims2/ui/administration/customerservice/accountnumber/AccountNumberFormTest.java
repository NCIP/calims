/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.accountnumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Stack;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.AccountNumberStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author katariap
 *
 */
public class AccountNumberFormTest {

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    AccountNumberForm form = new AccountNumberForm();
    CRUDFormTestHelper.setNotes(form);
    form.setStatus(AccountNumberStatus.DEFAULT.name());
    form.setTypeId(1L);
    Stack<StackFrame> context = FlowContextHolder.newContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame.addAttribute("persistentClass", ContactInformation.class);
    frame.addAttribute("id", new Long(1));
    AccountNumber entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormTestHelper.assertNotes(entity);
    assertEquals("Wrong status in the entity", AccountNumberStatus.DEFAULT, entity.getStatus());
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
  }
}
