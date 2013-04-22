/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.telephonenumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Stack;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.TelephoneNumber;
import gov.nih.nci.calims2.domain.administration.enumeration.TelephoneNumberStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author katariap
 *
 */
public class TelephoneNumberFormTest {

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    TelephoneNumberForm form = new TelephoneNumberForm();
    form.setStatus(TelephoneNumberStatus.DEFAULT.name());
    form.setTypeId(1L);
    Stack<StackFrame> context = FlowContextHolder.newContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame.addAttribute("persistentClass", ContactInformation.class);
    frame.addAttribute("id", new Long(1));
    TelephoneNumber entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    assertEquals("Wrong status in the entity", TelephoneNumberStatus.DEFAULT, entity.getStatus());
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
    CRUDFormAssert.assertEntity(ContactInformation.class, entity.getContactInformation(), 1L);
  }
}
