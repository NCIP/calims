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

/**
 * @author viseem
 * 
 */
public class HelloWorldImpl implements HelloWorld {

  /**
   * {@inheritDoc}
   */
  public String sayHelloToSomebody(String person) {
    return "Hello " + person;
  }

}
