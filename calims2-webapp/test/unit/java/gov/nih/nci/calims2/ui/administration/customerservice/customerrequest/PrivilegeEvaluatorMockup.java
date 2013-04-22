/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.customerrequest;

import org.springframework.security.core.Authentication;

import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * @author katariap
 *
 */
public class PrivilegeEvaluatorMockup implements PrivilegeEvaluator {
  
  private String role;
  
  
  /**
   * @param role The role to test
   */
  public PrivilegeEvaluatorMockup(String role) {
    this.role = role;
  }

  /**
   * Return the Authentication object representing the current user.
   * @return the Authentication object representing the current user.
   */
  public Authentication getCurrentUser() {
    return null;
  }

  /**
   * Return the username of the current user.
   * @return the username of the current user.
   */
  public String getCurrentUsername() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * Test if the current user has the given role.
   * @param role1 The role to test 
   * @return true if the current user has the specified role;
   */
  public boolean hasRole(String role1) {
    return this.role != null && this.role.equals(role1);
  }

  /**
   * Test if the current user can access the given uri.
   * @param uri The uri to test
   * @return true if the uri can be accessed.
   */
  public boolean isAllowed(String uri) {
    return false;
  }

  /**
   * Test if the given user can access the given uri.
   * @param uri The uri to test
   * @param authentication The authentication object of the user to test
   * @return true if the uri can be accessed.
   */
  public boolean isAllowed(String uri, Authentication authentication) {
    return false;
  }

}
