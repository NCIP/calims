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

/**
 * @author viseem
 * 
 */
public class LaboratoryCSMListener2 extends CRUDEventListenerAdapter<Laboratory> {
  private static Logger log = LoggerFactory.getLogger(LaboratoryCSMListener2.class);

  /**
   * {@inheritDoc}
   */
  public void afterCreate(Laboratory input, Laboratory laboratory) {
    log.debug("******************************");
    log.debug("in LaboratoryCSMListener2");
    log.debug("******************************");
    throw new RuntimeException("Test for transaction management");
  }

}
