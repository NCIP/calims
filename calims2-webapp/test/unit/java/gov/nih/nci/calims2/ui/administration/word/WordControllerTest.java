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

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.administration.Word;
import gov.nih.nci.calims2.domain.administration.enumeration.CharacterSet;
import gov.nih.nci.calims2.domain.administration.enumeration.WordStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class WordControllerTest {
  
  /**
   * Initialize a blank flow context.
   */
  @Before
  public void newContext() {
    FlowContextHolder.newContext();
  }

  /**
   * Removes the flow context.
   */
  @After
  public void removeContext() {
    FlowContextHolder.removeContext();
  }

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    WordController controller = new WordController();
    CRUDAssert.assertControllerConstructor(controller, WordController.URL_PREFIX, "administration.word.",
        "name", Word.class, WordForm.class, CRUDTableDecorator.class);
  }
  
  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    WordController controller = new WordController();
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertEnumerationCollection(result, "wordStatuses", WordStatus.class);
    CRUDAssert.assertEnumerationCollection(result, "characterSets", CharacterSet.class);
    
  }
  
  /**
   * Test the controller createList method.
   */
  @Test
  
  public void testCreateList() {
    WordController controller = new WordController();
    GenericServiceMockup<Word> wordService = new GenericServiceMockup<Word>();
    controller.setMainService(wordService);
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    frame.addAttribute("namingConventionId", new Long(1));
    context.push(frame);
    
    List<Word> result = controller.createList();
    
    String queryName = Word.class.getName() + ".findByNamingConventionId";
    
    assertEquals("Wrong Query name passed to findByNamedQuery", queryName, wordService.getFindByQueryName());
    Map<String, Object> params = wordService.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong id passed to findByNamedQuery", new Long(1), frame.getAttribute("namingConventionId"));
    assertEquals("Wrong number of paramters", 1, params.size());
    assertEquals("Wrong result returned", wordService.getFindByQueryNameResult(), result);
  }
}
