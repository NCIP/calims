/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.generic.crud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import gov.nih.nci.calims2.uic.descriptor.CommandVisibility;
import gov.nih.nci.calims2.uic.descriptor.FieldVisibility;
import gov.nih.nci.calims2.uic.descriptor.command.Command;
import gov.nih.nci.calims2.uic.descriptor.form.BaseField;
import gov.nih.nci.calims2.uic.descriptor.form.FieldSeparator;
import gov.nih.nci.calims2.uic.descriptor.form.Form;
import gov.nih.nci.calims2.uic.descriptor.form.FormTab;
import gov.nih.nci.calims2.uic.descriptor.form.HiddenField;
import gov.nih.nci.calims2.uic.descriptor.form.StandaloneFormElement;
import gov.nih.nci.calims2.uic.descriptor.form.TextField;

/**
 * @author viseem
 * 
 */
public class CRUDFormDecoratorTest {
  private static final String SELECTOR1 = "selector1"; 
  private static final String SELECTOR2 = "selector2"; 
  
  /**
   * test the getVisibleHiddenFields method.
   */
  @Test
  public void testGetVisibleHiddenFields() {
    CRUDFormDecoratorListMockup formDecorator = initMockupForListTests();
    List<HiddenField> fields = formDecorator.getVisibleHiddenFields(SELECTOR1);
    assertNotNull("No result returned", fields);
    assertEquals("Wrong result size", 1, fields.size());
    assertEquals("Wrong hidden field returned", formDecorator.getForm().getHiddenFields().get(0), fields.get(0));
    assertEquals("Wrong fields tested", formDecorator.getForm().getHiddenFields(), formDecorator.getHiddenFields());
    List<String> expectedSelectors = Arrays.asList(new String[]{SELECTOR1, SELECTOR1});
    assertEquals("Wrong selectors tested", expectedSelectors, formDecorator.getHiddenSelectors());
  }
  
  /**
   * test the getVisibleFields method.
   */
  @Test
  public void testGetVisibleFields() {
    CRUDFormDecoratorListMockup formDecorator = initMockupForListTests();
    FormTab tab = (FormTab) formDecorator.getForm().getChildren().get(0);
    List<StandaloneFormElement> fields = formDecorator.getVisibleFields(tab, SELECTOR1);
    assertNotNull("No result returned", fields);
    assertEquals("Wrong result size", 1, fields.size());
    assertEquals("Wrong field returned", tab.getChildren().get(0), fields.get(0));
    assertEquals("Wrong fields tested", tab.getChildren(), formDecorator.getFields());
    List<String> expectedSelectors = Arrays.asList(new String[]{SELECTOR1, SELECTOR1});
    assertEquals("Wrong selectors tested", expectedSelectors, formDecorator.getSelectors());
  }
  
  /**
   * test the getActiveCommands method.
   */
  @Test
  public void testGetActiveCommands() {
    CRUDFormDecoratorListMockup formDecorator = initMockupForListTests();
    FormTab tab = (FormTab) formDecorator.getForm().getChildren().get(0);
    List<Command> commands = formDecorator.getActiveCommands(tab, SELECTOR1);
    assertNotNull("No result returned", commands);
    assertEquals("Wrong result size", 1, commands.size());
    assertEquals("Wrong command returned", formDecorator.getForm().getCommands().get(0), commands.get(0));
    assertEquals("Wrong commands tested", formDecorator.getForm().getCommands(), formDecorator.getCommands());
    List<String> expectedSelectors = Arrays.asList(new String[]{SELECTOR1, SELECTOR1});
    assertEquals("Wrong selectors tested", expectedSelectors, formDecorator.getCommandSelectors());
  }

  private CRUDFormDecoratorListMockup initMockupForListTests() {
    CRUDFormDecoratorListMockup mockup = new CRUDFormDecoratorListMockup();
    Form form = new Form();
    mockup.setForm(form);
    form.addHiddenField(new HiddenField());
    HiddenField h2 = form.addHiddenField(new HiddenField());
    h2.setSelector(SELECTOR2);
    FormTab tab = form.addChild(new FormTab());
    tab.addChild(new TextField());
    BaseField f2 = tab.addChild(new TextField());
    f2.setSelector(SELECTOR2);
    form.addCommand(new Command());
    Command c2 = form.addCommand(new Command());
    c2.setSelector(SELECTOR2);
    return mockup;
  }
  
  /**
   * test the getHiddenFieldVisibility method.
   */
  @Test
  public void testGetHiddenFieldVisibility() {
    CRUDFormDecoratorMockup mockup = initMockupForVisibilityTests();
    HiddenField hidden = new HiddenField();
    hidden.setSelector(SELECTOR1);
    FieldVisibility visibility = mockup.getHiddenFieldVisibility(hidden, SELECTOR1);
    assertEquals("Wrong result", FieldVisibility.VISIBLE, visibility);
    assertEquals("Wrong selector passed to default method", SELECTOR1, mockup.getFieldSelector());
    assertEquals("Wrong required selector passed to default method", SELECTOR1, mockup.getFieldrequiredSelector());
  }
  
  /**
   * test the getFieldVisibility method.
   */
  @Test
  public void testGetFieldVisibility() {
    CRUDFormDecoratorMockup mockup = initMockupForVisibilityTests();
    TextField field = new TextField();
    field.setSelector(SELECTOR1);
    FieldVisibility visibility = mockup.getFieldVisibility(field, SELECTOR1);
    assertEquals("Wrong result", FieldVisibility.VISIBLE, visibility);
    assertEquals("Wrong selector passed to default method", SELECTOR1, mockup.getFieldSelector());
    assertEquals("Wrong required selector passed to default method", SELECTOR1, mockup.getFieldrequiredSelector());
  }
  
  /**
   * test the getCommandVisibility method.
   */
  @Test
  public void testGetCommandVisibility() {
    CRUDFormDecoratorMockup mockup = initMockupForVisibilityTests();
    Command command = new Command();
    command.setSelector(SELECTOR1);
    CommandVisibility visibility = mockup.getCommandVisibility(command, SELECTOR1);
    assertEquals("Wrong result", CommandVisibility.ACTIVE, visibility);
    assertEquals("Wrong command passed to default method", command, mockup.getCommand());
    assertEquals("Wrong required selector passed to default method", SELECTOR1, mockup.getCommandRequiredSelector());
  }
  
  private CRUDFormDecoratorMockup initMockupForVisibilityTests() {
    CRUDFormDecoratorMockup mockup = new CRUDFormDecoratorMockup();
    return mockup;
  }
  
  /**
   * test the selectorMatch method for an element without selector.
   */
  @Test
  public void testSelectorMatchNoSelector() {
    testSelectorMatch(null, SELECTOR1, true);
  }
  
  /**
   * test the selectorMatch method for an element with a matching selector.
   */
  @Test
  public void testSelectorMatchMatchingSelector() {
    testSelectorMatch(SELECTOR1, SELECTOR1, true);
  }
  
  /**
   * test the selectorMatch method for an element with a non matching selector.
   */
  @Test
  public void testSelectorMatchNotMatchingSelector() {
    testSelectorMatch(SELECTOR1, SELECTOR2, false);
  }
  
  private void testSelectorMatch(String selector, String requiredSelector, boolean expectedResult) {
    CRUDFormDecorator formDecorator = new CRUDFormDecorator();
    boolean result = formDecorator.selectorMatch(selector, requiredSelector);
    assertEquals("Wrong result from selectorMatch", expectedResult, result);
  }

  /**
   * test the getDefaultCommandVisibility method when the selector does not match.
   */
  @Test
  public void testGetDefaultCommandVisibilityNoMatch() {
    Command command = new Command();
    command.setSelector(SELECTOR1);
    testGetDefaultCommandVisibilityAllowed(command, SELECTOR2, true, CommandVisibility.INVISIBLE);
  }

  /**
   * test the getDefaultCommandVisibility method when the url is forbidden.
   */
  @Test
  public void testGetDefaultCommandVisibilityForbidden() {
    Command command = new Command();
    command.setUrl("url");
    testGetDefaultCommandVisibilityAllowed(command, SELECTOR2, false, CommandVisibility.INVISIBLE);
  }

  /**
   * test the getDefaultCommandVisibility method when the url is allowed.
   */
  @Test
  public void testGetDefaultCommandVisibilityAllowed() {
    Command command = new Command();
    command.setUrl("url");
    testGetDefaultCommandVisibilityAllowed(command, SELECTOR2, true, CommandVisibility.ACTIVE);
  }

  private void testGetDefaultCommandVisibilityAllowed(Command command, String requiredSelector, boolean urlAllowed,
      CommandVisibility expedtedResult) {
    CRUDFormDecorator formDecorator = new CRUDFormDecorator();
    PrivilegeEvaluatorMockup privilegeEvaluator = new PrivilegeEvaluatorMockup(urlAllowed);
    formDecorator.setPrivilegeEvaluator(privilegeEvaluator);
    formDecorator.setConfig(new CRUDControllerConfig());
    CommandVisibility visibility = formDecorator.getCommandVisibility(command, requiredSelector);
    assertEquals("Wrong result from getDefaultCommandVisibility", expedtedResult, visibility);
  }
  
  /**
   * test the getSeparatorCount method.
   */
  @Test
  public void testGetSeparatorCount() {
    CRUDFormDecorator formDecorator = new CRUDFormDecorator();
    Form form = new Form();
    formDecorator.setForm(form);
    FormTab tab = form.addChild(new FormTab());
    tab.addChild(new TextField());
    tab.addChild(new FieldSeparator());
    int result = formDecorator.getSeparatorCount(tab);
    assertEquals("Wrong number of separator returned", 1, result);
  }
  
  /**
   * test the getTabCount method.
   */
  @Test
  public void testGetTabCount() {
    CRUDFormDecorator formDecorator = new CRUDFormDecorator();
    Form form = new Form();
    formDecorator.setForm(form);
    form.addChild(new FormTab());
    form.addChild(new FormTab());
    form.addChild(new TextField());
    form.addChild(new FieldSeparator());
    int result = formDecorator.getTabCount();
    assertEquals("Wrong number of tabs returned", 2, result);
  }

}
