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

import org.springframework.security.core.Authentication;

import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * @author viseem
 * 
 */
public class PrivilegeEvaluatorMockup implements PrivilegeEvaluator {

  /** The test username returned by getCurrentUserName. */
  public static final String TEST_USERNAME = "testuser";
  
  private boolean uriallowed;
  
  /**
   * Constructor.
   * @param uriallowed The result of the isAllowed method
   */
  public PrivilegeEvaluatorMockup(boolean uriallowed) {
    this.uriallowed = uriallowed;
  }

  /**
   * {@inheritDoc}
   */
  public Authentication getCurrentUser() {
    return null;
  }

  /**
   * {@inheritDoc}
   */
  public String getCurrentUsername() {
    return TEST_USERNAME;
  }
  
  /**
   * {@inheritDoc}
   */
  public boolean isAllowed(String uri) {
    return uriallowed;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isAllowed(String uri, Authentication authentication) {
    return uriallowed;
  }

  /**
   * {@inheritDoc}
   */
  public boolean hasRole(String role) {
    return false;
  }
  
}
