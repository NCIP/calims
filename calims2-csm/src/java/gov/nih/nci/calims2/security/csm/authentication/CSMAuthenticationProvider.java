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
import gov.nih.nci.security.exceptions.CSConfigurationException;
import gov.nih.nci.security.exceptions.CSException;
import gov.nih.nci.security.exceptions.CSInputException;
import gov.nih.nci.security.exceptions.CSInsufficientAttributesException;
import gov.nih.nci.security.exceptions.CSLoginException;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author viseem
 *
 */
public class CSMAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
  
  private CSMProvider csmProvider;
  private CSMUserDetailsService csmUserDetailsService;

  /**
   * {@inheritDoc}
   */
  protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) {
    try {
      csmProvider.getAuthenticationManager().authenticate(userDetails.getUsername(), authentication.getCredentials().toString());
    } catch (CSLoginException e) {
      badCredentials(e);
    } catch (CSInputException e) {
      badCredentials(e);
    } catch (CSConfigurationException e) {
      badCredentials(e);
    } catch (CSInsufficientAttributesException e) {
      badCredentials(e);
    } catch (CSException e) {
      badCredentials(e);
    }
  }

  private void badCredentials(CSException e) {
    throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials",
                                                          "Bad credentials"), e);
  }

  /**
   * {@inheritDoc}
   */
  protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) {
    UserDetails user = csmUserDetailsService.loadUserByUsername(username);
    if (user == null) {
      throw new AuthenticationServiceException("UserDetailsService returned null, which is an interface contract violation");
    }
    return user;
  }

  /**
   * @param csmProvider the csmProvider to set
   */
  public void setCsmProvider(CSMProvider csmProvider) {
    this.csmProvider = csmProvider;
  }

  /**
   * @param csmUserDetailsService the csmUserDetailsService to set
   */
  public void setCsmUserDetailsService(CSMUserDetailsService csmUserDetailsService) {
    this.csmUserDetailsService = csmUserDetailsService;
  }

}
