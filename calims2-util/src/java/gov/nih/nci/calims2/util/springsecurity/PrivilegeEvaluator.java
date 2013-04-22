/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.util.springsecurity;

import org.springframework.security.core.Authentication;

/**
 * Wrapper for spring security authorization testing.
 * 
 * @author viseem
 *
 */
public interface PrivilegeEvaluator {
  /**
   * Return the Authentication object representing the current user.
   * @return the Authentication object representing the current user.
   */
  Authentication getCurrentUser();
  
  /**
   * Return the username of the current user.
   * @return the username of the current user.
   */
  String getCurrentUsername();
  
  /**
   * Test if the current user can access the given uri.
   * @param uri The uri to test
   * @return true if the uri can be accessed.
   */
  boolean isAllowed(String uri);
  
  /**
   * Test if the given user can access the given uri.
   * @param uri The uri to test
   * @param authentication The authentication object of the user to test
   * @return true if the uri can be accessed.
   */
  boolean isAllowed(String uri, Authentication authentication);
  
  /**
   * Test if the current user has the given role.
   * @param role The role to test 
   * @return true if the current user has the specified role;
   */
  boolean hasRole(String role);

}
