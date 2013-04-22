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

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.apache.commons.beanutils.PropertyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.web.servlet.ModelAndView;

import gov.nih.nci.calims2.domain.interfaces.EntityWithId;

/**
 * @author viseem
 * parent class for unit test of subflow return.
 * @param <T> The type of Controller to test
 */
@RunWith(Parameterized.class)
public class SubFlowReturnTester<T extends CRUDController<?>> {
  
  private int subFlowId;
  private boolean collection;
  private String propertyName;

  /**
   * Constructor.
   * 
   * @param subFlowId The sub flow id
   * @param collection true if the property is a collection
   * @param propertyName The name of the property to test
   */
  public SubFlowReturnTester(int subFlowId, boolean collection, String propertyName) {
    this.subFlowId = subFlowId;
    this.collection = collection;
    this.propertyName = propertyName;
  }
  
  /**
   * Test the controller doReturnFromFlow method.
   * 
   * @throws Exception if an exception occurs
   */
  @SuppressWarnings("unchecked")
  @Test
  public void testDoReturnFromFlow() throws Exception {
    Class<T> controllerClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    T controller = controllerClass.newInstance();
    ModelAndView model = new ModelAndView();
    model.addObject("form", controller.createForm());
    controller.doReturnFromFlow(model, subFlowId, 1L);
    Object property = PropertyUtils.getProperty(((CRUDForm) model.getModel().get("form")).getEntity(), propertyName);
    if (collection) {
      CRUDAssert.assertSubFlowEntities((Collection<EntityWithId>) property, 1L);
    } else {
      CRUDAssert.assertSubFlowEntity((EntityWithId) property, 1L);
    }
  }
}
