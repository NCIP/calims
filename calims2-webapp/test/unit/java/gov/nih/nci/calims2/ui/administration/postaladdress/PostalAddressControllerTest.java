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

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.PostalAddress;
import gov.nih.nci.calims2.domain.administration.enumeration.PostalAddressStatus;
import gov.nih.nci.calims2.domain.common.Type;
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
public class PostalAddressControllerTest {

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
    PostalAddressController controller = new PostalAddressController();
    CRUDAssert.assertControllerConstructor(controller, PostalAddressController.URL_PREFIX, "administration.postaladdress.", "name",
        PostalAddress.class, PostalAddressForm.class, CRUDTableDecorator.class);
  }

  /**
   * Test the controller completeEditModel method.
   */
  @Test
  public void testCompleteEditModel() {
    PostalAddressController controller = new PostalAddressController();
    GenericServiceMockup<Type> typeService = new GenericServiceMockup<Type>();
    controller.setTypeService(typeService);

    ModelAndView model = new ModelAndView();
    ModelAndView result = controller.completeEditModel(model, Locale.US);
    assertEquals("Wrong model returned", model, result);

    CRUDAssert.assertTypes(typeService, TypeEnumeration.POSTALADDRESS, "types", result);
    CRUDAssert.assertEnumerationCollection(result, "postalAddressStatuses", PostalAddressStatus.class);
  }

  /**
   * Test the controller createList method.
   */
  @Test
  public void testCreateList() {
    PostalAddressController controller = new PostalAddressController();
    GenericServiceMockup<PostalAddress> postalAddressService = new GenericServiceMockup<PostalAddress>();
    controller.setMainService(postalAddressService);
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    frame.addAttribute("persistentClass", Person.class);
    frame.addAttribute("id", new Long(1));
    context.push(frame);

    List<PostalAddress> result = controller.createList();

    String queryName = PostalAddress.class.getName() + ".findBy" + Person.class.getSimpleName() + "Id";

    assertEquals("Wrong Query name passed to findByNamedQuery", queryName, postalAddressService.getFindByQueryName());
    Map<String, Object> params = postalAddressService.getFindByQueryNameParameterValues();
    assertNotNull("No parameters passed to findByNamedQuery", params);
    assertEquals("Wrong persistentClass passed to findByNamedQuery", Person.class, frame.getAttribute("persistentClass"));
    assertEquals("Wrong id passed to findByNamedQuery", new Long(1), frame.getAttribute("id"));
    assertEquals("Wrong number of paramters", 1, params.size());
    assertEquals("Wrong result returned", postalAddressService.getFindByQueryNameResult(), result);
  }
}
