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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.junit.Test;

import gov.nih.nci.calims2.domain.interfaces.AuditableEntity;

/**
 * @author viseem
 * 
 */
public class AuditableCRUDEventListenerTest {
  
  /**
   * Test the constructor.
   */
  @Test
  public void testConstructor() {
    AuditableCRUDEventListener<AuditableEntityMockup> listener = new AuditableCRUDEventListener<AuditableEntityMockup>();
    String[] excludedProperties = listener.getExcludedProperties();
    assertNotNull("No excluded properties array", excludedProperties);
    Set<String> properties = new HashSet<String>(Arrays.asList(excludedProperties));
    String[] expected = new String[] {"id", "dateCreated", "createdBy", "dateModified", "modifiedBy" };
    assertEquals("Wrong number of excluded properties", expected.length, properties.size());
    for (String expectedProperty : expected) {
      assertTrue("Wrong ecluded property", properties.contains(expectedProperty));
    }
  }

  /**
   * Test the beforeCreate event.
   */
  @Test
  public void testBeforeCreate() {
    AuditableCRUDEventListener<AuditableEntityMockup> listener = init();
    AuditableEntityMockup entity = new AuditableEntityMockup();
    DateTime before = new DateTime();
    AuditableEntityMockup result = listener.beforeCreate(entity);
    DateTime after = new DateTime();
    assertNotNull("No person returned", result);
    assertNotNull("No dateCreated set", result.getDateCreated());
    assertTrue("dateCreated too early", before.compareTo(result.getDateCreated()) <= 0);
    assertTrue("dateCreated too late", after.compareTo(result.getDateCreated()) >= 0);
    assertEquals("Wrong username in createdBy", PrivilegeEvaluatorMockup.TEST_USERNAME, result.getCreatedBy());
    assertNull("dateModified should not be set", result.getDateModified());
    assertNull("modifiedBy should not be set", result.getDateModified());
  }

  /**
   * Test the beforeUpdate event.
   */
  @Test
  public void testBeforeUpdate() {
    AuditableCRUDEventListener<AuditableEntityMockup> listener = init();
    AuditableEntityMockup inputEntity = new AuditableEntityMockup();
    AuditableEntityMockup existingEntity = new AuditableEntityMockup();
    existingEntity.setDateCreated(new DateTime().minusDays(1));
    existingEntity.setCreatedBy("creator");
    DateTime before = new DateTime();
    AuditableEntityMockup result = listener.beforeUpdate(inputEntity, existingEntity);
    DateTime after = new DateTime();
    assertNotNull("No person returned", result);
    assertEquals("dateCreated has been changed", existingEntity.getDateCreated(), result.getDateCreated());
    assertEquals("createdBy has been changed", existingEntity.getCreatedBy(), result.getCreatedBy());
    assertNotNull("No dateModified set", result.getDateModified());
    assertTrue("dateModified too early", before.compareTo(result.getDateModified()) <= 0);
    assertTrue("dateModified too late", after.compareTo(result.getDateModified()) >= 0);
    assertEquals("Wrong username in modifiedBy", PrivilegeEvaluatorMockup.TEST_USERNAME, result.getModifiedBy());
  }

  private AuditableCRUDEventListener<AuditableEntityMockup> init() {
    AuditableCRUDEventListener<AuditableEntityMockup> listener = new AuditableCRUDEventListener<AuditableEntityMockup>();
    listener.setPrivilegeEvaluator(new PrivilegeEvaluatorMockup());
    return listener;
  }

  /** Auditable subclass for testing. */
  static class AuditableEntityMockup extends AuditableEntity {

    private static final long serialVersionUID = 7559672371269694866L;
    // Nothing to add
  }

}
