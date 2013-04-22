/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.uic.descriptor;

/**
 * Representation of a command visibility for form and table decorators.
 * 
 * @author viseem
 *
 */
public enum CommandVisibility {
  /** active command. */
  ACTIVE,
  /** inactive command. */
  INACTIVE,
  /** invisible and inactive command. */
  INVISIBLE;
}
