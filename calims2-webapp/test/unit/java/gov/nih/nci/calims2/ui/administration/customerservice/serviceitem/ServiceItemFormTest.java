/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.serviceitem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Stack;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.customerservice.AccountNumber;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem;
import gov.nih.nci.calims2.domain.administration.customerservice.enumeration.ServiceItemStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;

/**
 * @author katariap
 *
 */
public class ServiceItemFormTest {

  private static final Long[] IDS = new Long[] {1L, 2L };

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    ServiceItemForm form = new ServiceItemForm();
    form.setTypeId(1L);
    form.setAccountNumberIds(IDS);
    form.setRateId(1L);
    CRUDFormTestHelper.setNotes(form);
    form.setStatus(ServiceItemStatus.DEFAULT.name());
    Stack<StackFrame> context = FlowContextHolder.newContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame.addAttribute("persistentClass", ContactInformation.class);
    frame.addAttribute("id", new Long(1));
    ServiceItem entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
    CRUDFormAssert.assertEntities(AccountNumber.class, entity.getAccountNumberCollection(), IDS);
    CRUDFormAssert.assertEntity(Rate.class, entity.getServiceItemRate(), 1L);
    assertEquals("Wrong status in the entity", ServiceItemStatus.DEFAULT, entity.getStatus());
    CRUDFormTestHelper.assertNotes(entity);
  }
}
