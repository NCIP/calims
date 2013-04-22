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

import static org.junit.Assert.assertArrayEquals;
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

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.common.enumeration.TypeStatus;
import gov.nih.nci.calims2.ui.generic.crud.CRUDAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;
import gov.nih.nci.calims2.util.enumeration.I18nEnumeration.I18nEnumerationHelper;

/**
 * @author connollym@moxieinformatics.com
 * 
 */
public class TypeControllerTest {

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
    TypeController controller = new TypeController();
    CRUDAssert.assertControllerConstructor(controller, TypeController.URL_PREFIX, "common.type.", "name", Type.class,
        TypeForm.class, CRUDTableDecorator.class);
    assertEquals("Wrong manage view name", "manage", controller.getConfig().getManageView());
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    TypeController controller = new TypeController();
    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);
    CRUDAssert.assertEnumerationCollection(result, "typeStatuses", TypeStatus.class);
  }
  
  /**
   * Test the type controller createList method.
   */
  @Test
  public void testCreateList() {
    Stack<StackFrame> context = FlowContextHolder.newContext();
    StackFrame frame = new BaseStackFrame();
    frame.addAttribute("dataElementCollection", "dataElementCollection");
    context.push(frame);
    TypeController controller = new TypeController();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);
    List<Type> types = controller.createList();
    Map<String, Object> params = typeService.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong number of paramters", 1, params.size());
    assertEquals("Wrong parameter passed to findByNamedQuery", "dataElementCollection", params.get("dataElementCollection"));
    String queryName = Type.class.getName() + ".findByDataElementCollection";
    assertEquals("Wrong Query name passed to findAll", queryName, typeService.getFindByQueryName());
    assertEquals("Wrong list of types returned", typeService.getFindByQueryNameResult(), types);
  }

  /**
   * Test the type controller manage method.
   */
  @SuppressWarnings("unchecked")
  @Test
  public void testManage() {
    FlowContextHolder.newContext();
    TypeController controller = new TypeController();
    GenericServiceMockup<Type> serviceMockup = new GenericServiceMockup<Type>();
    controller.setTypeService(serviceMockup);
    ModelAndView result = controller.manage(Locale.US);
    assertNotNull("No model returned", result);
    TypeEnumeration[] types = ((List<TypeEnumeration>) result.getModel().get("types")).toArray(new TypeEnumeration[0]);
    TypeEnumeration[] expectedTypes = I18nEnumerationHelper.getLocalizedValues(TypeEnumeration.class, Locale.US).toArray(
        new TypeEnumeration[0]);
    assertArrayEquals("Wrong collection of types", expectedTypes, types);
  }
}
