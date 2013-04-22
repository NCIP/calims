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

import org.springframework.security.core.Authentication;

import gov.nih.nci.calims2.util.springsecurity.PrivilegeEvaluator;

/**
 * @author viseem
 * 
 */
public class PrivilegeEvaluatorMockup implements PrivilegeEvaluator {

  /** The test username returned by getCurrentUserName. */
  public static final String TEST_USERNAME = "testuser";

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
    return false;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isAllowed(String uri, Authentication authentication) {
    return false;
  }

  /**
   * {@inheritDoc}
   */
  public boolean hasRole(String role) {
    return false;
  }
  
}
