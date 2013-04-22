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
public interface HelloWorld {
  /**
   * Returns the greeting for the given person. 
   * @param person The person name
   * @return The greeting for the given person
   */
  String sayHelloToSomebody(String person);

}
