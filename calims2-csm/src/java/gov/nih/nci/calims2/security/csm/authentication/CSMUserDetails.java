/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.security.csm.authentication;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author viseem
 * 
 */
public class CSMUserDetails implements UserDetails {
 
  private static final long serialVersionUID = -5620005115305114336L;

  private Collection<GrantedAuthority> authorities;

  private String password;

  private String username;

  /**
   * 
   * @param authorities The authorities of the user
   * @param password The password of the user
   * @param username The usernameof the user.
   */
  public CSMUserDetails(Collection<GrantedAuthority> authorities, String password, String username) {
    this.authorities = authorities;
    this.password = password;
    this.username = username;
  }

  /**
   * {@inheritDoc}
   */
  public Collection<GrantedAuthority> getAuthorities() {
    return authorities;
  }

  /**
   * {@inheritDoc}
   */
  public String getPassword() {
    return password;
  }

  /**
   * {@inheritDoc}
   */
  public String getUsername() {
    return username;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isAccountNonExpired() {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isAccountNonLocked() {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * {@inheritDoc}
   */
  public boolean isEnabled() {
    return true;
  }

}
