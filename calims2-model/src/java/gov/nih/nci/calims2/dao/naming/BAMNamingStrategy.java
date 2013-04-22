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
 * NamingStrategy for the BAM database. All table names are prefixes with bam_
 * 
 * @author viseem
 * 
 */
public class BAMNamingStrategy extends PrefixNamingStrategy {

  private static final long serialVersionUID = 541861099222606392L;

  /**
   * Default constructor.
   */
  public BAMNamingStrategy() {
    super("bam_");
  }
}
