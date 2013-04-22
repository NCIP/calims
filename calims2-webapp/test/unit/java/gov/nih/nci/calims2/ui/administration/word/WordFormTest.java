/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.word;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Stack;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.Word;
import gov.nih.nci.calims2.domain.administration.enumeration.CharacterSet;
import gov.nih.nci.calims2.domain.administration.enumeration.WordStatus;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author katariap
 *
 */
public class WordFormTest {

  /**
   * Test the controller getSubmittedEntity method.
   */
  @Test
  public void testGetSubmittedEntity() {
    WordForm form = new WordForm();
    form.setStatus(WordStatus.DEFAULT.name());
    form.setCharacterSet(CharacterSet.ALL_LOWER_CASE.name());
    Stack<StackFrame> context = FlowContextHolder.newContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame.addAttribute("persistentClass", NamingConvention.class);
    frame.addAttribute("id", new Long(1));
    Word entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    assertEquals("Wrong status in the entity", WordStatus.DEFAULT, entity.getStatus());
    assertEquals("Wrong character set in the entity", CharacterSet.ALL_LOWER_CASE, entity.getCharacterSet());
  }
}
