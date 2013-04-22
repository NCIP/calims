/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.inventory.layout;

import gov.nih.nci.calims2.business.generic.AuditableCRUDEventListener;
import gov.nih.nci.calims2.domain.inventory.Layout;

/**
 * @author viseem
 * 
 */
public class LayoutCRUDEventListener extends AuditableCRUDEventListener<Layout> {

  private static final String[] EXCLUDED_PROPERTIES = new String[] {"containerTypeCollection" };

  /**
   * Default constructor.
   */
  public LayoutCRUDEventListener() {
    setAdditionalExcludedProperties(EXCLUDED_PROPERTIES);
  }
}
