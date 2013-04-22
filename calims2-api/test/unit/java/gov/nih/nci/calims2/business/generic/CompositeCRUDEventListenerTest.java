/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.generic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import gov.nih.nci.calims2.domain.interfaces.AuditableEntity;

/**
 * @author viseem
 * 
 */
public class CompositeCRUDEventListenerTest {

  private CompositeCRUDEventListener<AuditableEntityMockup> listener;
  private CRUDEventListenerMockup<AuditableEntityMockup> component0;
  private CRUDEventListenerMockup<AuditableEntityMockup> component1;

  /**
   * Test the afterCreateDefault method.
   */
  @Test
  public void testAfterCreateDefault() {
    init();
    AuditableEntityMockup input = new AuditableEntityMockup();
    AuditableEntityMockup result = listener.afterCreateDefault(input);
    assertNotNull("No result from afterCreateDefault", result);
    assertEquals("Wrong input passed to component 0", input, component0.getAfterCreateDefaultEntity());
    assertEquals("Wrong input passed to component 1", component0.getCreateDefaultResult(), 
                 component1.getAfterCreateDefaultEntity());
    assertEquals("Wrong result returned", component1.getCreateDefaultResult(), result);
  }

  /**
   * Test the beforeCreate method.
   */
  @Test
  public void testBeforeCreate() {
    init();
    AuditableEntityMockup input = new AuditableEntityMockup();
    AuditableEntityMockup result = listener.beforeCreate(input);
    assertNotNull("No result from beforeCreate", result);
    assertEquals("Wrong input passed to component 0", input, component0.getInputEntity());
    assertEquals("Wrong input passed to component 1", component0.getCreateResult(), component1.getInputEntity());
    assertEquals("Wrong result returned", component1.getCreateResult(), result);
  }

  /**
   * Test the testBeforeCopy method.
   */
  @Test
  public void testBeforeCopy() {
    init();
    AuditableEntityMockup input = new AuditableEntityMockup();
    AuditableEntityMockup result = listener.beforeCopy(input);
    assertNotNull("No result from beforeCopy", result);
    assertEquals("Wrong input passed to component 0", input, component0.getInputEntity());
    assertEquals("Wrong input passed to component 1", component0.getCopyResult(), component1.getInputEntity());
    assertEquals("Wrong result returned", component1.getCopyResult(), result);
  }

  /**
   * Test the afterCreate method.
   */
  @Test
  public void testAfterCreate() {
    init();
    AuditableEntityMockup input = new AuditableEntityMockup();
    listener.afterCreate(input, input);
    assertEquals("Wrong input passed to component 0", input, component0.getAfterCreateEntity());
    assertEquals("Wrong input passed to component 1", input, component1.getAfterCreateEntity());
  }

  /**
   * Test the beforeUpdate method.
   */
  @Test
  public void testBeforeUpdate() {
    init();
    AuditableEntityMockup input = new AuditableEntityMockup();
    AuditableEntityMockup existing = new AuditableEntityMockup();
    AuditableEntityMockup result = listener.beforeUpdate(input, existing);
    assertEquals("Wrong input passed to component 0", input, component0.getInputEntity());
    assertEquals("Wrong input passed to component 1", input, component1.getInputEntity());
    assertNotNull("No result from beforeUpdate", result);
    assertEquals("Wrong existing entity passed to component 0", existing, component0.getExistingEntity());
    assertEquals("Wrong existing entity passed to component 1", component0.getUpdateResult(), component1.getExistingEntity());
    assertEquals("Wrong result returned", component1.getUpdateResult(), result);
  }

  /**
   * Test the afterUpdate method.
   */
  @Test
  public void testAfterUpdate() {
    init();
    AuditableEntityMockup input = new AuditableEntityMockup();
    listener.afterUpdate(input);
    assertEquals("Wrong input passed to component 0", input, component0.getAfterUpdateEntity());
    assertEquals("Wrong input passed to component 1", input, component1.getAfterUpdateEntity());

  }

  /**
   * Test the beforeDelete method.
   */
  @Test
  public void testBeforeDelete() {
    init();
    AuditableEntityMockup input = new AuditableEntityMockup();
    listener.beforeDelete(input);
    assertEquals("Wrong input passed to component 0", input, component0.getExistingEntity());
    assertEquals("Wrong input passed to component 1", input, component1.getExistingEntity());
  }

  /**
   * Test the afterDelete method.
   */
  @Test
  public void testAfterDelete() {
    init();
    AuditableEntityMockup input = new AuditableEntityMockup();
    listener.afterDelete(input);
    assertEquals("Wrong input passed to component 0", input, component0.getAfterDeleteEntity());
    assertEquals("Wrong input passed to component 1", input, component1.getAfterDeleteEntity());
  }

  private void init() {
    listener = new CompositeCRUDEventListener<AuditableEntityMockup>();
    component0 = new CRUDEventListenerMockup<AuditableEntityMockup>();
    component1 = new CRUDEventListenerMockup<AuditableEntityMockup>();
    List<CRUDEventListener<AuditableEntityMockup>> components = new ArrayList<CRUDEventListener<AuditableEntityMockup>>();
    components.add(component0);
    components.add(component1);
    listener.setListeners(components);
  }

  /** Auditable subclass for testing. */
  static class AuditableEntityMockup extends AuditableEntity {

    private static final long serialVersionUID = -1683773425533021117L;
    // Nothing to add
  }

}
