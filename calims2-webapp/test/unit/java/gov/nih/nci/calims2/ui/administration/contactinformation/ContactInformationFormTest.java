/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.contactinformation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.domain.administration.Collaboration;
import gov.nih.nci.calims2.domain.administration.ContactInformation;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.enumeration.ContactInformationStatus;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormTestHelper;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author katariap
 * 
 */
@RunWith(Parameterized.class)
public class ContactInformationFormTest {

  private Class<? extends EntityWithId> persistentClass;
  private String propertyName;
  
  /**
   * Constructor.
   * @param persistentClass The persistent class
   * @param propertyName The name of the property containing the result
   */
  public ContactInformationFormTest(Class<? extends EntityWithId> persistentClass, String propertyName) {
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
        {Organization.class, "organization"},
        {Laboratory.class, "laboratory"},
        {Location.class, "location"},
        {Collaboration.class, "collaboration"}
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
    ContactInformationForm form = new ContactInformationForm();
    CRUDFormTestHelper.setNotes(form);
    form.setStatus(ContactInformationStatus.ACTIVE.name());
    form.setTypeId(1L);
    Stack<StackFrame> context = FlowContextHolder.newContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame.addAttribute("persistentClass", persistentClass);
    frame.addAttribute("id", new Long(1));
    ContactInformation entity = form.getSubmittedEntity();
    assertNotNull("No submitted Entity", entity);
    CRUDFormTestHelper.assertNotes(entity);
    assertEquals("Wrong status in the entity", ContactInformationStatus.ACTIVE, entity.getStatus());
    CRUDFormAssert.assertEntity(Type.class, entity.getType(), 1L);
    EntityWithId result = (EntityWithId) PropertyUtils.getProperty(entity, propertyName);
    CRUDFormAssert.assertEntity((Class<EntityWithId>) persistentClass, result, 1L);
  }
}
