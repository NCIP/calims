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

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;
import org.springframework.web.context.ContextLoader;

/**
 * @author viseem
 * 
 */
public class PrivilegeEvaluatorImpl implements PrivilegeEvaluator {

  /**
   * {@inheritDoc}
   */
  public Authentication getCurrentUser() {
    return SecurityContextHolder.getContext().getAuthentication();
  }

  /**
   * {@inheritDoc}
   */
  public String getCurrentUsername() {
    Object principal = getCurrentUser().getPrincipal();
    return (principal instanceof UserDetails) ? ((UserDetails) principal).getUsername() : principal.toString();
  }

  /**
   * {@inheritDoc}
   */
  public boolean isAllowed(String uri) {
    return isAllowed(uri, getCurrentUser());
  }

  /**
   * {@inheritDoc}
   */
  public boolean isAllowed(String uri, Authentication authentication) {
    ApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
    Map<String, WebInvocationPrivilegeEvaluator> wipes = applicationContext.getBeansOfType(WebInvocationPrivilegeEvaluator.class);
    if (wipes.isEmpty()) {
      throw new IllegalStateException("No WebInvocationPrivilegeEvaluator has been registered in the application context");
    }
    WebInvocationPrivilegeEvaluator webInvocationPrivilegeEvaluator = wipes.values().iterator().next();
    return webInvocationPrivilegeEvaluator.isAllowed(uri, authentication);
  }

  /**
   * {@inheritDoc}
   */
  public boolean hasRole(String role) {
    for (GrantedAuthority auth : getCurrentUser().getAuthorities()) {
      if (auth.getAuthority().equals(role)) {
        return true;
      }
    }
    return false;
  }

}
