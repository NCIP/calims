/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The calims2
 * Software was developed in conjunction with the National Cancer Institute 
 * (NCI) by NCI employees and Moxie Informatics. To the extent 
 * government employees are authors, any rights in such works shall be subject 
 * to Title 17 of the United States Code, section 105. 
 *
 * This calims2 Software License (the License) is between NCI and You. You (or 
 * Your) shall mean a person or an entity, and all other entities that control, 
 * are controlled by, or are under common control with the entity. Control for 
 * purposes of this definition means (i) the direct or indirect power to cause 
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares, 
 * or (iii) beneficial ownership of such entity. 
 *
 * This License is granted provided that You agree to the conditions described 
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up, 
 * no-charge, irrevocable, transferable and royalty-free right and license in 
 * its rights in the calims2 Software to (i) use, install, access, operate, 
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the calims2 Software; (ii) distribute and 
 * have distributed to and by third parties the calims2 Software and any 
 * modifications and derivative works thereof; and (iii) sublicense the 
 * foregoing rights set out in (i) and (ii) to third parties, including the 
 * right to license such rights to further third parties. For sake of clarity, 
 * and not by way of limitation, NCI shall have no right of accounting or right 
 * of payment from You or Your sub-licensees for the rights granted under this 
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the 
 * above copyright notice, this list of conditions and the disclaimer and 
 * limitation of liability of Article 6, below. Your redistributions in object 
 * code form must reproduce the above copyright notice, this list of conditions 
 * and the disclaimer of Article 6 in the documentation and/or other materials 
 * provided with the distribution, if any. 
 *
 * Your end-user documentation included with the redistribution, if any, must 
 * include the following acknowledgment: This product includes software 
 * developed by Moxie Informatics and the National Cancer Institute. If You do not include 
 * such end-user documentation, You shall include this acknowledgment in the 
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "Moxie Informatics" 
 * to endorse or promote products derived from this Software. This License does 
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or Moxie Informatics, except as required to comply with the 
 * terms of this License. 
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this 
 * Software into Your proprietary programs and into any third party proprietary 
 * programs. However, if You incorporate the Software into third party 
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software 
 * into such third party proprietary programs and for informing Your 
 * sub-licensees, including without limitation Your end-users, of their 
 * obligation to secure any required permissions from such third parties before 
 * incorporating the Software into such third party proprietary software 
 * programs. In the event that You fail to obtain such permissions, You agree 
 * to indemnify NCI for any claims against NCI by such third parties, except to 
 * the extent prohibited by law, resulting from Your failure to obtain such 
 * permissions. 
 *
 * For sake of clarity, and not by way of limitation, You may add Your own 
 * copyright statement to Your modifications and to the derivative works, and 
 * You may provide additional or different license terms and conditions in Your 
 * sublicenses of modifications of the Software, or any derivative works of the 
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, 
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, 
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO 
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, MOXIE INFORMATICS OR THEIR 
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR 
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gov.nih.nci.calims2.ui.generic.crud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Locale;
import java.util.Stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.inventory.Container;
import gov.nih.nci.calims2.ui.administration.person.PersonForm;
import gov.nih.nci.calims2.ui.util.GenericServiceMockup;
import gov.nih.nci.calims2.ui.util.interceptor.FlowContextInterceptor;
import gov.nih.nci.calims2.uic.descriptor.table.Table;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author viseem
 * 
 */
public class CRUDControllerTest {
  private static final String URL_PREFIX = "/administration/person";
  private static final String VIEW_PREFIX = "administration.person.";

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
   * test the getDefaultTableDecoratorClassGeneric method in the generic case.
   */
  @Test
  public void testGetDefaultTableDecoratorClassGeneric() {
    CRUDController<Person> controller = new PersonControllerMockup();
    Class<?> tableDecoratorClass = controller.getDefaultTableDecoratorClass();
    assertEquals("Wrong default table decorator class", CRUDTableDecorator.class, tableDecoratorClass);
  }
  
  /**
   * test the getDefaultTableDecoratorClassGeneric method in the specific case.
   */
  @Test
  public void testGetDefaultTableDecoratorClassSpecific() {
    CRUDController<Container> controller = new ContainerControllerMockup();
    Class<?> tableDecoratorClass = controller.getDefaultTableDecoratorClass();
    assertEquals("Wrong default table decorator class", ContainerTableDecorator.class, tableDecoratorClass);
  }

  /**
   * Test the controller callFromList method.
   */
  @Test
  public void testCallFromList() {
    CRUDController<Person> controller = new PersonControllerMockup();
    CRUDControllerConfig config = controller.getConfig();
    ModelAndView result = controller.callFromList(1L, 0);
    assertNotNull("No model returned", result);
    // test the returned view
    assertNotNull("No view returned", result.getView());
    assertEquals("Wrong view class", InternalResourceView.class, result.getView().getClass());
    InternalResourceView view = (InternalResourceView) result.getView();
    assertEquals("Wrong url returned", controller.getConfig().getSubFlowUrls()[0], view.getUrl());
    // test the changes to the context
    Stack<StackFrame> context = FlowContextHolder.getContext();
    assertEquals("Wrong context size", 1, context.size());
    StackFrame frame = FlowContextHolder.getContext().peek();
    String expectedUrl = config.getForwardUrl(config.getListCommand());
    assertEquals("Wrong return url", expectedUrl, frame.getReturnUrl());
    assertEquals("Wrong id saved in the context", new Long(1), frame.getAttribute("id"));
    assertEquals("Wrong persistentClass saved in the context", Person.class, frame.getAttribute("persistentClass"));
    assertEquals("Wrong subFlowId saved in the context", new Integer(0), frame.getAttribute("subFlowId"));
  }

  /**
   * Test the controller cancelSave method for the standard case.
   */
  @Test
  public void testCancelSaveForStandardCase() {
    Stack<StackFrame> context = FlowContextHolder.getContext();
    context.push(new BaseStackFrame());
    CRUDController<Person> controller = new PersonControllerMockup();
    String returnView = "edit";
    ModelAndView result = controller.cancelSave(returnView);
    assertNotNull("No model returned", result);
    assertNotNull("No view returned", result.getView());
    assertEquals("Wrong view class", InternalResourceView.class, result.getView().getClass());
    InternalResourceView view = (InternalResourceView) result.getView();
    assertEquals("Wrong url returned", returnView, view.getUrl());
  }

  /**
   * Test the controller cancelSave method with a context specifying the return url.
   */
  @Test
  public void testCancelSaveForInclusion() {
    Stack<StackFrame> context = FlowContextHolder.getContext();
    String expectedUrl = "url";
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame = new BaseStackFrame();
    frame.setReturnUrl(expectedUrl);
    context.push(frame);
    CRUDController<Person> controller = new PersonControllerMockup();
    ModelAndView result = controller.cancelSave(null);
    assertNotNull("No model returned", result);
    assertNotNull("No view returned", result.getView());
    assertEquals("Wrong view class", InternalResourceView.class, result.getView().getClass());
    InternalResourceView view = (InternalResourceView) result.getView();
    assertEquals("Wrong url returned", expectedUrl, view.getUrl());
  }
  
  

  /**
   * Test the controller create method.
   */
  @Test
  public void testCreate() {
    CRUDControllerMockupForCreateAndEdit<Person> controller = new CRUDControllerMockupForCreateAndEdit<Person>(URL_PREFIX,
        VIEW_PREFIX, Person.class, PersonForm.class);
    GenericServiceMockup<Person> serviceMockup = new GenericServiceMockup<Person>();
    controller.setMainService(serviceMockup);
    String currentView = "currentView";
    ModelAndView result = controller.create(currentView, Locale.US);
    assertNotNull("No model returned", result);
    assertEquals("Wrong class passed to createDefault", Person.class, serviceMockup.getCreateDefaultClass());
    assertEquals("Wrong entity passed to createEditModel.", serviceMockup.getCreateDefaultResult(), controller.getEntityToEdit());
    assertEquals("Wrong current view passed to createEditModel", currentView, controller.getCurrentView());
    assertEquals("Wrong model returned", controller.getEditModel(), result);
  }

  /**
   * Test the controller createEditModel method.
   */
  @Test
  public void testCreateEditModel() {
    CRUDController<Person> controller = new PersonControllerMockup();
    CRUDControllerConfig config = controller.getConfig();
    Person editedEntity = new Person();
    String currentView = "currentView";
    ModelAndView result = controller.createEditModel(editedEntity, currentView, Locale.US);
    assertNotNull("No model returned", result);
    assertEquals("Wrong view edit type page", config.getViewPrefix() + config.getEditView(), result.getViewName());
    PersonForm form = (PersonForm) result.getModelMap().get("form");
    assertNotNull("No form returned in the model", form);
    assertEquals("Wrong entity in the form", editedEntity, form.getEntity());
    assertEquals("Wrong edit mode in the form.", false, form.isEditMode());
    assertEquals("Wrong currentView in the form", "edit", form.getCurrentView());
    assertEquals("Wrong returnView in the form", currentView, form.getReturnView());
    assertEquals("Wrong flowContext returned", FlowContextHolder.getSerializedContext(), 
                 result.getModelMap().get(FlowContextInterceptor.CONTEXT_PARAM));
  }

  /**
   * Test the controller delete method.
   */
  @Test
  public void testDelete() {
    CRUDController<Person> controller = new PersonControllerMockup();
    CRUDControllerConfig config = controller.getConfig();
    GenericServiceMockup<Person> serviceMockup = new GenericServiceMockup<Person>();
    controller.setMainService(serviceMockup);
    ModelAndView result = controller.delete(1L);
    assertNotNull("No model returned", result);
    String expectedUrl = config.getRedirectUrl(config.getListCommand());
    assertEquals("Wrong view list person page", expectedUrl, result.getViewName());
    assertEquals("Wrong class passed to the service", Person.class, serviceMockup.getDeleteClass());
    assertEquals("Wrong id passed to the service", new Long(1), serviceMockup.getDeleteId());
  }

  /**
   * Test the controller details method.
   */
  @Test
  public void testDetails() {
    CRUDController<Person> controller = new PersonControllerMockup();
    CRUDControllerConfig config = controller.getConfig();
    GenericServiceMockup<Person> serviceMockup = new GenericServiceMockup<Person>();
    controller.setMainService(serviceMockup);
    ModelAndView result = controller.details(1L, Locale.US);
    assertNotNull("No model returned", result);
    String expectedView = config.getViewPrefix() + config.getDetailsView();
    assertEquals("Wrong view list person page", expectedView, result.getViewName());
    PersonForm form = (PersonForm) result.getModelMap().get("form");
    assertNotNull("No form returned in the model", form);
    assertEquals("Wrong entity in the form", serviceMockup.getFindByIdResult(), form.getEntity());
    assertEquals("Wrong currentView in the form", config.getForwardUrl(config.getDetailsCommand()), form.getCurrentView());
    assertEquals("Wrong class passed to the findById", Person.class, serviceMockup.getFindByIdClass());
    assertEquals("Wrong id passed to the findById", new Long(1), serviceMockup.getFindByIdId());
    assertEquals("Wrong flowContext returned", FlowContextHolder.getSerializedContext(), result.getModel().get(
        FlowContextInterceptor.CONTEXT_PARAM));
    assertEquals("Wrong config object returned", controller.getConfig(), result.getModel().get("config"));
  }

  /**
   * Test the controller doCall method.
   */
  @Test
  public void testDoCall() {
    CRUDController<Person> controller = new PersonControllerMockup();
    CRUDControllerConfig config = controller.getConfig();
    GenericServiceMockup<Person> serviceMockup = new GenericServiceMockup<Person>();
    controller.setMainService(serviceMockup);
    CRUDFormMockup<Person> personForm = new CRUDFormMockup<Person>();
    ModelAndView result = controller.doCall(personForm, 0);
    assertNotNull("No model returned", result);
    // test the returned view
    assertNotNull("No view returned", result.getView());
    assertEquals("Wrong view class", InternalResourceView.class, result.getView().getClass());
    InternalResourceView view = (InternalResourceView) result.getView();
    assertEquals("Wrong url returned", controller.getConfig().getSubFlowUrls()[0], view.getUrl());
    // test the changes to the context
    Stack<StackFrame> context = FlowContextHolder.getContext();
    assertEquals("Wrong context size", 1, context.size());
    StackFrame frame = FlowContextHolder.getContext().peek();
    String expectedUrl = config.getForwardUrl(config.getReturnCommand());
    assertEquals("Wrong return url", expectedUrl, frame.getReturnUrl());
    assertEquals("Wrong form saved in the context", personForm, frame.getAttribute("form"));
    assertEquals("Wrong subFlowId saved in the context", new Integer(0), frame.getAttribute("subFlowId"));
    assertTrue("getSubmittedEntity was not called on the form", personForm.isSubmittedEntityCalled());
  }

  /**
   * Test the controller edit method.
   */
  @Test
  public void testEdit() {
    CRUDControllerMockupForCreateAndEdit<Person> controller = new CRUDControllerMockupForCreateAndEdit<Person>(URL_PREFIX,
        VIEW_PREFIX, Person.class, PersonForm.class);
    GenericServiceMockup<Person> serviceMockup = new GenericServiceMockup<Person>();
    controller.setMainService(serviceMockup);
    String currentView = "currentView";
    ModelAndView result = controller.edit(1L, currentView, Locale.US);
    assertNotNull("No call to findById", serviceMockup.getFindByIdResult());
    assertEquals("Wrong id passed to findById", new Long(1), serviceMockup.getFindByIdId());
    assertEquals("Wrong entity passed to createEditModel.", serviceMockup.getFindByIdResult(), controller.getEntityToEdit());
    assertEquals("Wrong current view passed to createEditModel", currentView, controller.getCurrentView());
    assertEquals("Wrong model returned", controller.getEditModel(), result);
  }

  /**
   * Test the controller enterList method.
   */
  @Test
  public void testEnterList() {
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    frame.addAttribute("id", 1L);
    frame.addAttribute("persistentClass", Person.class);
    context.push(frame);
    CRUDControllerMockupForSubFlow<Person> controller = new CRUDControllerMockupForSubFlow<Person>(URL_PREFIX, VIEW_PREFIX,
        Person.class, PersonForm.class);
    ModelAndView result = controller.enterList(Locale.US);
    assertNotNull("No model returned", result);
    assertEquals("Wrong model returned", controller.getListModel(), result);
    assertNull("Wrong queryId passed to list", controller.getListQueryId());
    assertEquals("wrong returnView passed to list", "call", controller.getListReturnView());
    // test the changes to the context
    assertEquals("Wrong context size", 2, context.size());
    frame = FlowContextHolder.getContext().peek();
    assertEquals("Wrong id saved in the context", new Long(1), frame.getAttribute("id"));
    assertEquals("Wrong persistentClass saved in the context", Person.class, frame.getAttribute("persistentClass"));
  }

  /**
   * Test the controller genericReturnFromSubFlow method.
   */
  @Test
  public void testGenericReturnFromSubFlow() {
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    String returnUrl = "returnUrl";
    frame.setReturnUrl(returnUrl);
    context.push(frame);
    context.push(new BaseStackFrame());
    CRUDController<Person> controller = new PersonControllerMockup();
    ModelAndView result = controller.genericReturnFromSubFlow();
    assertNotNull("No model returned", result);
    // test the returned view
    assertNotNull("No view returned", result.getView());
    assertEquals("Wrong view class", InternalResourceView.class, result.getView().getClass());
    InternalResourceView view = (InternalResourceView) result.getView();
    assertEquals("Wrong url returned", returnUrl, view.getUrl());
    // test the changes to the context
    assertEquals("Wrong context size", 0, context.size());
  }

  /**
   * Test the controller list method.
   * @throws Exception if an error occurs
   */
  @SuppressWarnings("unchecked")
  @Test
  public void testList() throws Exception {
    CRUDController<Person> controller = new PersonControllerMockup();
    CRUDControllerConfig config = controller.getConfig();
    GenericServiceMockup<Person> serviceMockup = new GenericServiceMockup<Person>();
    controller.setMainService(serviceMockup);
    controller.setTableDecoratorClass(CRUDTableDecorator.class);
    controller.setListTable(new Table());
    FlowContextHolder.getContext().push(new BaseStackFrame());
    ModelAndView result = controller.list(null, null, Locale.US);
    assertNotNull("No model returned", result);
    assertEquals("Wrong view list person page", config.getViewPrefix() + config.getListView(), result.getViewName());
    assertEquals("Wrong class passed to findAll", Person.class, serviceMockup.getFindAllClass());
    assertEquals("Wrong order by clause passed to findAll", config.getOrderByClause(), serviceMockup.getFindAllOrderByClause());
    CRUDTableDecorator<Person> tableDecorator = (CRUDTableDecorator<Person>) result.getModel().get("tableDecorator");
    assertNotNull("No table decorator returned", tableDecorator);
    assertEquals("Wrong list returned in the model", serviceMockup.getFindAllResult(), tableDecorator.getRows());
    assertEquals("Wrong flowContext returned", FlowContextHolder.getSerializedContext(), result.getModel().get(
        FlowContextInterceptor.CONTEXT_PARAM));
    assertEquals("Wrong return view", controller.getConfig().getForwardUrl(config.getListCommand()), result.getModel().get(
        "currentView"));
  }

  /**
   * Test the controller manage method.
   */
  @Test
  public void testManage() {
    CRUDController<Person> controller = new PersonControllerMockup();
    CRUDControllerConfig config = controller.getConfig();
    ModelAndView result = controller.manage(Locale.US);
    assertNotNull("No model returned", result);
    assertEquals("Wrong view name for manage person page", config.getViewPrefix() + config.getManageView(), result.getViewName());
    assertEquals("Wrong flowContext returned", FlowContextHolder.getSerializedContext(), result.getModel().get(
        FlowContextInterceptor.CONTEXT_PARAM));
    assertEquals("Wrong config object returned", controller.getConfig(), result.getModel().get("config"));
    assertEquals("Wrong return view", controller.getConfig().getForwardUrl(config.getManageCommand()), result.getModel().get(
        "currentView"));
    Stack<StackFrame> context = FlowContextHolder.getContext();
    assertEquals("Wrong context size", 1, context.size());
  }

  /**
   * Test the controller doSave method for the create case with valid data.
   */
  @Test
  public void testDoSaveCreate() {
    Stack<StackFrame> context = FlowContextHolder.getContext();
    context.push(new BaseStackFrame());
    CRUDController<Person> controller = new PersonControllerMockup();
    CRUDControllerConfig config = controller.getConfig();
    GenericServiceMockup<Person> serviceMockup = new GenericServiceMockup<Person>();
    controller.setMainService(serviceMockup);
    PersonForm personForm = new PersonForm();
    Person person = new Person();
    personForm.setEntity(person);
    ModelAndView result = controller.doSave(personForm, Locale.US);
    assertNotNull("No model returned", result);
    String expectedUrl = CRUDControllerConfig.REDIRECT_PREFIX + config.getUrlPrefix() + config.getListCommand();
    assertEquals("Wrong view url returned", expectedUrl, result.getViewName());
    assertEquals("Wrong object passed to service create method", person, serviceMockup.getCreateResult());
    String contextAttribute = (String) result.getModel().get(FlowContextInterceptor.CONTEXT_PARAM);
    assertNotNull("No flowContext returned", contextAttribute);
    assertTrue("Wrong flowContext returned", contextAttribute.startsWith(FlowContextHolder.ATTRIBUTE_PREFIX));
  }

  /**
   * Test the controller doSave method for the create case with valid data.
   */
  @Test
  public void testDoSaveUpdate() {
    Stack<StackFrame> context = FlowContextHolder.getContext();
    context.push(new BaseStackFrame());
    CRUDController<Person> controller = new PersonControllerMockup();
    CRUDControllerConfig config = controller.getConfig();
    GenericServiceMockup<Person> serviceMockup = new GenericServiceMockup<Person>();
    controller.setMainService(serviceMockup);
    PersonForm personForm = new PersonForm();
    personForm.setEditMode(true);
    Person person = new Person();
    personForm.setEntity(person);
    ModelAndView result = controller.doSave(personForm, Locale.US);
    assertNotNull("No model returned", result);
    String expectedUrl = CRUDControllerConfig.REDIRECT_PREFIX + config.getUrlPrefix() + config.getListCommand();
    assertEquals("Wrong view url returned", expectedUrl, result.getViewName());
    assertEquals("Wrong object passed to service update method", person, serviceMockup.getUpdateResult());
    String contextAttribute = (String) result.getModel().get(FlowContextInterceptor.CONTEXT_PARAM);
    assertNotNull("No flowContext returned", contextAttribute);
    assertTrue("Wrong flowContext returned", contextAttribute.startsWith(FlowContextHolder.ATTRIBUTE_PREFIX));
  }

  /**
   * Test the controller doSave method for the create case with valid data.
   */
  @Test
  public void testDoSaveCreateNested() {
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame = new BaseStackFrame();
    frame.setReturnUrl("url");
    context.push(frame);
    CRUDController<Person> controller = new PersonControllerMockup();
    GenericServiceMockup<Person> serviceMockup = new GenericServiceMockup<Person>();
    controller.setMainService(serviceMockup);
    PersonForm personForm = new PersonForm();
    Person person = new Person();
    person.setId(1L);
    personForm.setEntity(person);
    ModelAndView result = controller.doSave(personForm, Locale.US);
    assertNotNull("No model returned", result);
    String expectedUrl = CRUDControllerConfig.REDIRECT_PREFIX + "url";
    assertEquals("Wrong view url returned", expectedUrl, result.getViewName());
    assertEquals("Wrong object passed to service create method", person, serviceMockup.getCreateResult());
    String contextAttribute = (String) result.getModel().get(FlowContextInterceptor.CONTEXT_PARAM);
    assertNotNull("No flowContext returned", contextAttribute);
    assertTrue("Wrong flowContext returned", contextAttribute.startsWith(FlowContextHolder.ATTRIBUTE_PREFIX));
    context = FlowContextHolder.getContext();
    assertEquals("Wrong context size", 2, context.size());
    frame = FlowContextHolder.getContext().peek();
    assertEquals("Wrong id retuned in the model", new Long(1), frame.getReturnValue("id"));
  }

  /**
   * Test the controller returnFromSubFlow method.
   */
  @Test
  public void testReturnFromSubFlow() {
    Stack<StackFrame> context = FlowContextHolder.getContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    PersonForm personForm = new PersonForm();
    frame.addAttribute("form", personForm);
    frame.addAttribute("subFlowId", 0);
    frame.addReturnValue("id", 1L);
    CRUDControllerMockupForSubFlow<Person> controller = new CRUDControllerMockupForSubFlow<Person>(URL_PREFIX, VIEW_PREFIX,
        Person.class, PersonForm.class);
    GenericServiceMockup<Person> serviceMockup = new GenericServiceMockup<Person>();
    controller.setMainService(serviceMockup);
    ModelAndView result = controller.returnFromSubFlow(Locale.US);
    assertNotNull("No model returned", result);
    assertEquals("Wrong entity passed to createEditModel.", personForm.getEntity(), controller.getEntityToEdit());
    assertNull("Wrong current view passed to createEditModel", controller.getCurrentView());
    assertEquals("Wrong model returned", controller.getEditModel(), result);
    assertEquals("Wrong form in the model", personForm, result.getModel().get("form"));
    // Check the call to doReturnFromFlow
    assertTrue("doReturnFromFlow not called at all", controller.isDoReturnCalled());
    assertEquals("Wrong model passed to doReturnFromFlow", result, controller.getDoReturnModel());
    assertEquals("Wrong subFolwId passed to doReturnFromFlow", 0, controller.getDoReturnSubFlowId());
    assertEquals("Wrong entityId passed to doReturnFromFlow", new Long(1), controller.getDoReturnEntityId());
  }

}
