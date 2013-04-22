/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.security.csm;

import gov.nih.nci.security.AuthenticationManager;
import gov.nih.nci.security.AuthorizationManager;
import gov.nih.nci.security.SecurityServiceProvider;
import gov.nih.nci.security.exceptions.CSConfigurationException;
import gov.nih.nci.security.exceptions.CSException;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.util.Assert;

/**
 * Holder class for the CSM implementation objects.
 * 
 * @author viseem
 *
 */
public class CSMProvider implements InitializingBean {
  /**
   * The application context name for which this service is instantiated.
   */
  private String csmApplicationContext;

  private AuthenticationManager authenticationManager;
  private AuthorizationManager authorizationManager;
  
  /**
   * {@inheritDoc}
   */
  public void afterPropertiesSet() {
    Assert.notNull(csmApplicationContext, "A csm application context must be set");
    try {
      authenticationManager = SecurityServiceProvider.getAuthenticationManager(csmApplicationContext);
    } catch (CSConfigurationException e) {
      throw new DataRetrievalFailureException(e.getMessage(), e);
    } catch (CSException e) {
      throw new DataAccessResourceFailureException(e.getMessage(), e);
    }
    try {
      authorizationManager = SecurityServiceProvider.getAuthorizationManager(csmApplicationContext);
    } catch (CSConfigurationException e) {
      throw new DataRetrievalFailureException(e.getMessage(), e);
    } catch (CSException e) {
      throw new DataAccessResourceFailureException(e.getMessage(), e);
    }
  }
  
  /**
   * @return the authenticationManager
   */
  public AuthenticationManager getAuthenticationManager() {
    return authenticationManager;
  }

  /**
   * @return the authorizationManager
   */
  public AuthorizationManager getAuthorizationManager() {
    return authorizationManager;
  }
  
  /**
   * @param csmApplicationContext the csmApplicationContext to set
   */
  public void setCsmApplicationContext(String csmApplicationContext) {
    this.csmApplicationContext = csmApplicationContext;
  }

}
