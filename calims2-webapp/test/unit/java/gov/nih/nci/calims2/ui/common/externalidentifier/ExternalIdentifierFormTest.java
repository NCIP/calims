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

import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.common.ExternalIdentifier;
import gov.nih.nci.calims2.domain.common.enumeration.ExternalIdentifierStatus;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.domain.inventory.LabSupply;
import gov.nih.nci.calims2.domain.inventory.Sequence;
import gov.nih.nci.calims2.domain.inventory.Specimen;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author connollym
 *
 */
@RunWith(Parameterized.class)
public class ExternalIdentifierFormTest {

  private Class<? extends EntityWithId> persistentClass;
  private String propertyName;
  
  /**
   * Constructor.
   * @param persistentClass The persistent class
   * @param propertyName The name of the property containing the result
   */
  public ExternalIdentifierFormTest(Class<? extends EntityWithId> persistentClass, String propertyName) {
    this.persistentClass = persistentClass;
    this.propertyName = propertyName;
  }
  
  /**
   * Gets the parameterized test data.
   * @return The parameters of the test
   */
  @Parameters
  public static Collection<? extends Object> data() {
    Object[][] data = new Object[][]{{Person.class, "person"}, 
        {LabSupply.class, "labSupply"},
        {Account.class, "account"},
        {CustomerRequest.class, "customerRequest"},
        {Sequence.class, "sequence"},
        {Specimen.class, "specimen"},
       };
    return Arrays.asList(data);
  }
  
  /**
   * Test the controller getSubmittedEntity method.
   * @throws Exception 
   */
  @SuppressWarnings("unchecked")
  @Test
  public void testGetSubmittedEntity() throws Exception {
    ExternalIdentifierForm form = new ExternalIdentifierForm();
    form.setStatus(ExternalIdentifierStatus.DEFAULT.getName());
    Stack<StackFrame> context = FlowContextHolder.newContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame.addAttribute("persistentClass", persistentClass);
    frame.addAttribute("id", new Long(1));
    ExternalIdentifier entity = form.getSubmittedEntity();
    EntityWithId result = (EntityWithId) PropertyUtils.getProperty(entity, propertyName);
    CRUDFormAssert.assertEntity((Class<EntityWithId>) persistentClass, result, 1L);
    assertEquals("Wrong status in the entity", ExternalIdentifierStatus.DEFAULT, entity.getStatus());
  }
}

