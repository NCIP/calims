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

import gov.nih.nci.calims2.security.csm.CSMProvider;
import gov.nih.nci.security.authorization.domainobjects.Privilege;
import gov.nih.nci.security.authorization.domainobjects.ProtectionElementPrivilegeContext;
import gov.nih.nci.security.authorization.domainobjects.User;
import gov.nih.nci.security.exceptions.CSObjectNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author viseem
 * 
 */
public class CSMUserDetailsService implements UserDetailsService {

  
  private CSMProvider csmProvider;

  /**
   * {@inheritDoc}
   */
  public UserDetails loadUserByUsername(String username) {
    User csmUser = csmProvider.getAuthorizationManager().getUser(username);
    if (csmUser == null) {
      throw new UsernameNotFoundException("Unable to find user by the given user name");
    }
    Collection<GrantedAuthority> grantedAuthorities = getAuthorityCollection(csmUser.getUserId().toString());
    UserDetails userDetails = new CSMUserDetails(grantedAuthorities, csmUser.getPassword(), csmUser.getLoginName());
    return userDetails;
  }

  /**
   * Get All GrantedAuthorities from CSM.
   * 
   * @param csmUserId The user id
   * @return The collection of granted authorities for that user.
   */
  @SuppressWarnings("unchecked")
  private Collection<GrantedAuthority> getAuthorityCollection(String csmUserId) {
    Set<ProtectionElementPrivilegeContext> pePrivContextSet = null;
    try {
      pePrivContextSet = csmProvider.getAuthorizationManager().getProtectionElementPrivilegeContextForUser(csmUserId);
    } catch (CSObjectNotFoundException e) {
      throw new DataRetrievalFailureException("Could not retrieve Granted Authorities for user.");
    }
    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
    for (ProtectionElementPrivilegeContext pepc : pePrivContextSet) {
      String peName = pepc.getProtectionElement().getProtectionElementName();
      for (Privilege priv : (Set<Privilege>) pepc.getPrivileges()) {
        grantedAuthorities.add(new GrantedAuthorityImpl(peName + "_" + priv.getName().toUpperCase()));
      }
    }
    return grantedAuthorities;
  }

  /**
   * @param csmProvider the csmProvider to set
   */
  public void setCsmProvider(CSMProvider csmProvider) {
    this.csmProvider = csmProvider;
  }

}
