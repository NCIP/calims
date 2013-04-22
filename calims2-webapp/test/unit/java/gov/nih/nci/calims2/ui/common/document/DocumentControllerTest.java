/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.common.document;

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

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.common.enumeration.DocumentStatus;
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
public class DocumentControllerTest {
  
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
    DocumentController controller = new DocumentController();
    CRUDAssert.assertControllerConstructor(controller, DocumentController.URL_PREFIX, "common.document.",
        "name", Document.class, DocumentForm.class, CRUDTableDecorator.class);
  }
  
  /**
   * Test the controller createList method.
   */
  @Test
  
  public void testCreateList() {
    DocumentController controller = new DocumentController();
    GenericServiceMockup<Document> documentService = new GenericServiceMockup<Document>();
    controller.setMainService(documentService);
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    frame.addAttribute("persistentClass", Person.class);
    frame.addAttribute("id", new Long(1));
    context.push(frame);
    
    List<Document> result = controller.createList();
    
    String queryName = Document.class.getName() + ".findBy" + Person.class.getSimpleName() + "Id";
    
    assertEquals("Wrong Query name passed to findByNamedQuery", queryName, documentService.getFindByQueryName());
    Map<String, Object> params = documentService.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong persistentClass passed to findByNamedQuery", Person.class, frame.getAttribute("persistentClass"));
    assertEquals("Wrong id passed to findByNamedQuery", new Long(1), frame.getAttribute("id"));
    assertEquals("Wrong number of paramters", 1, params.size());
    assertEquals("Wrong result returned", documentService.getFindByQueryNameResult(), result);
  }
  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    DocumentController controller = new DocumentController();
    
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertEnumerationCollection(result, "documentStatuses", DocumentStatus.class);
   }
}
