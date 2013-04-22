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

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Person;

/**
 * @author viseem
 * 
 */
public class NullCRUDEventListenerTest {

  /**
   * Test the constructor.
   */
  @Test
  public void testConstructor() {
    NullCRUDEventListener<Person> crudEventListener = new NullCRUDEventListener<Person>();
    String[] excludedProperties = crudEventListener.getExcludedProperties();
    assertNotNull("No excluded properties array", excludedProperties);
    assertEquals("Wrong number of excluded properties", 1, excludedProperties.length);
    assertEquals("Wrong excluded property", "id", excludedProperties[0]);
  }

  /**
   * Test the beforeCreate event.
   */
  @Test
  public void testBeforeCreate() {
    CRUDEventListener<Person> crudEventListener = new NullCRUDEventListener<Person>();
    Person person = new Person();
    person.setFamilyName("fn");
    Person result = crudEventListener.beforeCreate(person);
    assertNotNull("No person returned", result);
    assertEquals("Wrong person returned", person.getFamilyName(), result.getFamilyName());
  }

  /**
   * Test the beforeUpdate event.
   */
  @Test
  public void testBeforeUpdate() {
    CRUDEventListener<Person> crudEventListener = new NullCRUDEventListener<Person>();
    Person inputPerson = new Person();
    Person existingPerson = new Person();
    Person result = crudEventListener.beforeUpdate(inputPerson, existingPerson);
    assertEquals("Wrong person returned", existingPerson, result);
  }
}
