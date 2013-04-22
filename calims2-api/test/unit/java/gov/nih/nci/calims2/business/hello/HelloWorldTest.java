/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author viseem
 * 
 */
public class HelloWorldTest {

  private HelloWorld helloWorld = new HelloWorldImpl();

  /**
   * Test the happy path of sayHelloToSomebody.
   */
  @Test
  public void testSayHelloToSomebody1() {
    String result = helloWorld.sayHelloToSomebody("Michael");
    assertEquals("Wrong return value", "Hello Michael", result);
  }

  /**
   * Test that fails to validate the junit BDA tasks.
   */
  //@Test
  public void testSayHelloToSomebody2() {
    String result = helloWorld.sayHelloToSomebody("Michael");
    assertEquals("Wrong return value", "sHello Michael", result);
  }
  
  /**
   * Test that has errors to validate the junit BDA tasks.
   */
  //@Test
  public void testSayHelloToSomebody3() {
    throw new NullPointerException();
  }
}
