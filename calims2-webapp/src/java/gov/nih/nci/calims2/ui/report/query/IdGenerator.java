/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.report.query;

/**
 * Id generator class used to assign generated ids to nodes of the entity tree.
 * 
 * @author viseem
 * 
 */
public class IdGenerator {
  private int id;

  /**
   * Get the next id value.
   * 
   * @return The next id value.
   */
  public int next() {
    return id++;
  }

}
