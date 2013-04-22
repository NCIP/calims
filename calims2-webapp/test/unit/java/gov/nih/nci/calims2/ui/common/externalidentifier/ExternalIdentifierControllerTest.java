/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.common.externalidentifier;

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

import gov.nih.nci.calims2.domain.common.ExternalIdentifier;
import gov.nih.nci.calims2.domain.common.enumeration.ExternalIdentifierStatus;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author connollym
 * 
 */
public class ExternalIdentifierControllerTest {

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
    ExternalIdentifierController controller = new ExternalIdentifierController();
    CRUDAssert.assertControllerConstructor(controller, ExternalIdentifierController.URL_PREFIX, "common.externalidentifier.",
        "name", ExternalIdentifier.class, ExternalIdentifierForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller createList method.
   */
  @Test
  public void testCreateList() {
    ExternalIdentifierController controller = new ExternalIdentifierController();
    GenericServiceMockup<ExternalIdentifier> externalIdentifierService = new GenericServiceMockup<ExternalIdentifier>();
    controller.setMainService(externalIdentifierService);
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    frame.addAttribute("persistentClass", Specimen.class);
    frame.addAttribute("id", new Long(1));
    context.push(frame);

    List<ExternalIdentifier> result = controller.createList();

    String queryName = ExternalIdentifier.class.getName() + ".findBy" + Specimen.class.getSimpleName() + "Id";
    assertEquals("Wrong Query name passed to findByNamedQuery", queryName, externalIdentifierService.getFindByQueryName());
    Map<String, Object> params = externalIdentifierService.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong persistentClass passed to findByNamedQuery", Specimen.class, frame.getAttribute("persistentClass"));
    assertEquals("Wrong id passed to findByNamedQuery", new Long(1), frame.getAttribute("id"));
    assertEquals("Wrong number of paramters", 1, params.size());
    assertEquals("Wrong result returned", externalIdentifierService.getFindByQueryNameResult(), result);
  }
  
  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    ExternalIdentifierController controller = new ExternalIdentifierController();
    
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertEnumerationCollection(result, "externalIdentifierStatuses", ExternalIdentifierStatus.class);
   }
}
