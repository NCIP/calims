/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.dao.naming;


/**
 * NamingStrategy for the BPM database. All table names are prefixes with bpm_
 * 
 * @author viseem
 * 
 */
public class BPMNamingStrategy extends PrefixNamingStrategy {

  private static final long serialVersionUID = 1898398925673002904L;

  /**
   * Default constructor.
   */
  public BPMNamingStrategy() {
    super("bpm_");
  }
}
