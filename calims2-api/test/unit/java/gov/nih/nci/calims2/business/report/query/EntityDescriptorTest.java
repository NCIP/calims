/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author viseem
 * 
 */
public class EntityDescriptorTest {
  private static final int LIST_LENGTH = 5;
  private static final String PROPERTY = "property";
  private static final String RELATIONSHIP = "relationship";

  /**
   * Test the getPropertyDescriptor method for success with a main property.
   */
  @Test
  public void testGetPropertyDescriptorMainSuccess() {
    String expectedName = PROPERTY + "2";
    PropertyDescriptor result = testGetPropertyDescriptor(expectedName);
    assertNotNull("No result returned", result);
    assertEquals("Wrong descriptor returned", expectedName, result.getName());
  }

  /**
   * Test the getPropertyDescriptor method for failure with a main property.
   */
  @Test
  public void testGetPropertyDescriptorMainFailure() {
    try {
      testGetPropertyDescriptor("xyz");
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Nothing to do
    }
  }

  /**
   * Test the getPropertyDescriptor method for success with a dependent property.
   */
  @Test
  public void testGetPropertyDescriptorDependentSuccess() {
    String expectedName = RELATIONSHIP + "2." + RELATIONSHIP + "2" + PROPERTY + "2";
    PropertyDescriptor result = testGetPropertyDescriptor(expectedName);
    assertNotNull("No result returned", result);
    assertEquals("Wrong descriptor returned", RELATIONSHIP + "2" + PROPERTY + "2", result.getName());
  }

  /**
   * Test the getPropertyDescriptor method for failure with a dependent property.
   */
  @Test
  public void testGetPropertyDescriptorDependentFailure() {
    try {
      testGetPropertyDescriptor(RELATIONSHIP + "2.xyz");
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Nothing to do
    }
  }

  private PropertyDescriptor testGetPropertyDescriptor(String propertyName) {
    EntityDescriptor descriptor = new EntityDescriptor();
    descriptor.setProperties(createPropertyList(PROPERTY));
    descriptor.setRelationships(createRelationshipList());
    for (RelationshipDescriptor rd : descriptor.getRelationships()) {
      rd.setProperties(createPropertyList(rd.getName() + PROPERTY));
    }
    return descriptor.getPropertyDescriptor(propertyName);
  }

  /**
   * Test the getPropertyDescriptorInList method for success.
   */
  @Test
  public void testGetPropertyDescriptorInListSuccess() {
    String expectedName = PROPERTY + "2";
    PropertyDescriptor result = testGetPropertyDescriptorInList(expectedName);
    assertNotNull("No result returned", result);
    assertEquals("Wrong descriptor returned", expectedName, result.getName());
  }

  /**
   * Test the getPropertyDescriptorInList method for failure.
   */
  @Test
  public void testGetPropertyDescriptorInListFailure() {
    try {
      testGetPropertyDescriptorInList("xyz");
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Nothing to do
    }

  }

  private PropertyDescriptor testGetPropertyDescriptorInList(String propertyName) {
    EntityDescriptor descriptor = new EntityDescriptor();
    List<PropertyDescriptor> properties = createPropertyList(PROPERTY);
    return descriptor.getPropertyDescriptorInList(properties, propertyName);
  }

  /**
   * test the getRelationshipDescriptor method for success.
   */
  @Test
  public void testgetRelationshipDescriptorSuccess() {
    String expectedName = RELATIONSHIP + "2";
    RelationshipDescriptor result = testGetRelationshipDescriptor(expectedName);
    assertNotNull("No result returned", result);
    assertEquals("Wrong descriptor returned", expectedName, result.getName());
  }

  /**
   * test the getRelationshipDescriptor method for failure.
   */
  @Test
  public void testgetRelationshipDescriptorFailure() {
    try {
      testGetRelationshipDescriptor("xyz");
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException e) {
      // Nothing to do
    }
  }

  private RelationshipDescriptor testGetRelationshipDescriptor(String relationshipName) {
    EntityDescriptor descriptor = new EntityDescriptor();
    descriptor.setRelationships(createRelationshipList());
    return descriptor.getRelationshipDescriptor(relationshipName);
  }

  /**
   * Create a list of property descriptors.
   * @param name The property names prefix
   * 
   * @return The created list
   */
  List<PropertyDescriptor> createPropertyList(String name) {
    List<PropertyDescriptor> list = new ArrayList<PropertyDescriptor>();
    for (int i = 0; i < LIST_LENGTH; i++) {
      PropertyDescriptor p = new PropertyDescriptor();
      p.setName(name + i);
      list.add(p);
    }
    return list;
  }

  /**
   * Create a list of relationship descriptors.
   * 
   * @return The created list
   */
  List<RelationshipDescriptor> createRelationshipList() {
    List<RelationshipDescriptor> list = new ArrayList<RelationshipDescriptor>();
    for (int i = 0; i < LIST_LENGTH; i++) {
      RelationshipDescriptor r = new RelationshipDescriptor();
      r.setName(RELATIONSHIP + i);
      list.add(r);
    }
    return list;
  }

}
