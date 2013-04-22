/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.namingconvention;

import gov.nih.nci.calims2.domain.administration.enumeration.NamingConventionType;

/**
 * Helper interface to get naming conventions for controllers that need naming convention validation in the UI.
 * 
 * @author viseem
 * 
 */
public interface NamingConventionHelper {
  /**
   * Get the naming conventions as a json string.
   * 
   * @param type The type of entity
   * @return The applicable naming conventions as a json object
   */
  String getNamingConventions(NamingConventionType type);
}
