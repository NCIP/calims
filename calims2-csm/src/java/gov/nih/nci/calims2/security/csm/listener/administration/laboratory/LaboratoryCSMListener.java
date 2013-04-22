/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.security.csm.listener.administration.laboratory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.nih.nci.calims2.business.generic.CRUDEventListenerAdapter;
import gov.nih.nci.calims2.domain.administration.Laboratory;
import gov.nih.nci.calims2.security.csm.CSMProvider;
import gov.nih.nci.security.AuthorizationManager;
import gov.nih.nci.security.authorization.domainobjects.Application;
import gov.nih.nci.security.authorization.domainobjects.ProtectionElement;
import gov.nih.nci.security.exceptions.CSObjectNotFoundException;
import gov.nih.nci.security.exceptions.CSTransactionException;

/**
 * @author viseem
 *
 */
public class LaboratoryCSMListener extends CRUDEventListenerAdapter<Laboratory> {
  
  private static Logger log = LoggerFactory.getLogger(LaboratoryCSMListener.class);
  
  private CSMProvider csmProvider;
  
  /**
   * {@inheritDoc}
   */
  public void afterCreate(Laboratory input, Laboratory laboratory) {
    log.debug("******************************");
    log.debug("in LaboratoryCSMListener");
    log.debug("******************************");
    AuthorizationManager manager = csmProvider.getAuthorizationManager();
    Application application = getApplication();
    ProtectionElement protectionElement = new ProtectionElement();
    protectionElement.setApplication(application);
    protectionElement.setProtectionElementName(Laboratory.class.getSimpleName() + " " + laboratory.getId());
    protectionElement.setProtectionElementDescription(laboratory.getName());
    protectionElement.setProtectionElementType(Laboratory.class.getName());
    protectionElement.setObjectId(laboratory.getId().toString());
    try {
      manager.createProtectionElement(protectionElement);
    } catch (CSTransactionException e) {
      throw new RuntimeException("Exception in CSMListener", e);
    }
  }
  
  /**
   * Gets the current application.
   * @return The current Application.
   */
  public Application getApplication() {
    AuthorizationManager manager = csmProvider.getAuthorizationManager();
    try {
      return  manager.getApplication(manager.getApplicationContext().getApplicationName());
    } catch (CSObjectNotFoundException e) {
      throw new IllegalArgumentException("Bad application context name");
    }
  }

  /**
   * @return the csmProvider
   */
  public CSMProvider getCsmProvider() {
    return csmProvider;
  }

  /**
   * @param csmProvider the csmProvider to set
   */
  public void setCsmProvider(CSMProvider csmProvider) {
    this.csmProvider = csmProvider;
  }

}
