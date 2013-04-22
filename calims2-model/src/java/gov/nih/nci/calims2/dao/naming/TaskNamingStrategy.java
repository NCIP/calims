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
 * NamingStrategy for the Task database. All table names are prefixes with task_
 * 
 * @author viseem
 * 
 */
public class TaskNamingStrategy extends PrefixNamingStrategy {

  private static final long serialVersionUID = 5906612020383038687L;

  /**
   * Default constructor.
   */
  public TaskNamingStrategy() {
    super("task_");
  }
}
