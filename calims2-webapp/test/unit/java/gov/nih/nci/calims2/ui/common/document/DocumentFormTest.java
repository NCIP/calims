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

import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import gov.nih.nci.calims2.domain.administration.Collaboration;
import gov.nih.nci.calims2.domain.administration.Equipment;
import gov.nih.nci.calims2.domain.administration.Location;
import gov.nih.nci.calims2.domain.administration.NamingConvention;
import gov.nih.nci.calims2.domain.administration.Organization;
import gov.nih.nci.calims2.domain.administration.Person;
import gov.nih.nci.calims2.domain.administration.StorageDevice;
import gov.nih.nci.calims2.domain.administration.customerservice.Account;
import gov.nih.nci.calims2.domain.administration.customerservice.Contract;
import gov.nih.nci.calims2.domain.administration.customerservice.CustomerRequest;
import gov.nih.nci.calims2.domain.administration.customerservice.Invoice;
import gov.nih.nci.calims2.domain.administration.customerservice.Quotation;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.common.Document;
import gov.nih.nci.calims2.domain.common.enumeration.DocumentStatus;
import gov.nih.nci.calims2.domain.interfaces.EntityWithId;
import gov.nih.nci.calims2.ui.generic.crud.CRUDFormAssert;
import gov.nih.nci.calims2.uic.flow.BaseStackFrame;
import gov.nih.nci.calims2.uic.flow.FlowContextHolder;
import gov.nih.nci.calims2.uic.flow.StackFrame;

/**
 * @author katariap
 *
 */
@RunWith(Parameterized.class)
public class DocumentFormTest {

  private Class<? extends EntityWithId> persistentClass;
  private String propertyName;
  
  /**
   * Constructor.
   * @param persistentClass The persistent class
   * @param propertyName The name of the property containing the result
   */
  public DocumentFormTest(Class<? extends EntityWithId> persistentClass, String propertyName) {
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
        {Account.class, "account"},
        {Collaboration.class, "collaboration"},
        {Contract.class, "contract"},
        {CustomerRequest.class, "customerRequest"},
        {Equipment.class, "equipment"},
        {StorageDevice.class, "equipment"},
        {Invoice.class, "invoice"},
        {Location.class, "location"},
        {NamingConvention.class, "namingConvention"},
        {Organization.class, "organization"},
        {Quotation.class, "quotation"},
        {Service.class, "service"}
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
    DocumentForm form = new DocumentForm();
    form.setStatus(DocumentStatus.DEFAULT.name());
    Stack<StackFrame> context = FlowContextHolder.newContext();
    StackFrame frame = new BaseStackFrame();
    context.push(frame);
    frame.addAttribute("persistentClass", persistentClass);
    frame.addAttribute("id", new Long(1));
    Document entity = form.getSubmittedEntity();
    assertEquals("Wrong status in the entity", DocumentStatus.DEFAULT, entity.getStatus());
    EntityWithId result = (EntityWithId) PropertyUtils.getProperty(entity, propertyName);
    CRUDFormAssert.assertEntity((Class<EntityWithId>) persistentClass, result, 1L);
  }
}
