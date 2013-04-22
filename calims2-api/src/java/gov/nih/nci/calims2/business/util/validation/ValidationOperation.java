/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.util.validation;

/**
 * @author connollym@moxieinformatics.com
 *
 */


public enum ValidationOperation {
  /**
   * Validating the CREATE operation.
   */
  CREATE,
  /**
   * Validating the DELETE operation.
   */
  DELETE,
  /**
   * Validating the UPDATE operation.
   */
  UPDATE;
}
