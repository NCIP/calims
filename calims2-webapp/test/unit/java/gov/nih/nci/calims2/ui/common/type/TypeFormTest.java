/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.common.type;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.common.enumeration.TypeStatus;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author katariap
 *
 */
public class TypeFormTest {
  
  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    TypeForm form = new TypeForm();
    form.setStatus(TypeStatus.DEFAULT.name());
    Stack<StackFrame> context = FlowContextHolder.newContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame.addAttribute("persistentClass", ContactInformation.class);
    frame.addAttribute("id", new Long(1));
    Type entity = form.getSubmittedEntity();
    assertEquals("Wrong status in the entity", TypeStatus.DEFAULT, entity.getStatus());
  }
}
