/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.postaladdress;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Stack;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.PostalAddress;
import gov.nih.nci.calims2.domain.administration.enumeration.PostalAddressStatus;
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
public class PostalAddressFormTest {

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    PostalAddressForm form = new PostalAddressForm();
    CRUDFormTestHelper.setNotes(form);
    form.setStatus(PostalAddressStatus.DEFAULT.name());
    form.setTypeId(1L);
    Stack<StackFrame> context = FlowContextHolder.newContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame.addAttribute("persistentClass", ContactInformation.class);
    frame.addAttribute("id", new Long(1));
    PostalAddress entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormAssert.assertEntity(ContactInformation.class, entity.getContactInformation(), 1L);
    CRUDFormTestHelper.assertNotes(entity);
    assertEquals("Wrong status in the entity", PostalAddressStatus.DEFAULT, entity.getStatus());
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
  }
  
}
