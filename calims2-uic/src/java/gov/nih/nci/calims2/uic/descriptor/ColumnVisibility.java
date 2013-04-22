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
 * @author viseem
 *
 */
public enum ColumnVisibility {
  /** Column that can be toggled and that is initially visible. */
  INITIALLY_VISIBLE,
  /** Column that can be toggled and that is initially invisible. */
  INITIALLY_INVISIBLE,
  /** Column that is always visible. */
  ALWAYS_VISIBLE,
  /** Column that is always invisible. */
  ALWAYS_INVISIBLE;
}
