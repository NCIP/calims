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

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * NamingStrategy that applies a given prefix to table names. This class is intended to be subclassed by naming strategies that give
 * the prefix in their default constructor.
 * 
 * @author viseem
 * 
 */
public class PrefixNamingStrategy extends DefaultNamingStrategy {

  private static final long serialVersionUID = 6532405581712416257L;

  private String tablePrefix;

  /**
   * Constructor.
   * 
   * @param tablePrefix The table name prefix to use.
   */
  public PrefixNamingStrategy(String tablePrefix) {
    this.tablePrefix = tablePrefix;
  }

  /**
   * {@inheritDoc}
   */
  public String classToTableName(String className) {
    return tablePrefix + super.classToTableName(className);
  }

  /**
   * {@inheritDoc}
   */
  public String collectionTableName(String ownerEntity, String ownerEntityTable, String associatedEntity,
      String associatedEntityTable, String propertyName) {
    return tablePrefix
        + super.collectionTableName(ownerEntity, ownerEntityTable, associatedEntity, associatedEntityTable, propertyName);
  }

  /**
   * {@inheritDoc}
   */
  public String logicalCollectionTableName(String tableName, String ownerEntityTable, String associatedEntityTable,
      String propertyName) {
    return tablePrefix + super.logicalCollectionTableName(tableName, ownerEntityTable, associatedEntityTable, propertyName);
  }

  /**
   * {@inheritDoc}
   */
  public String tableName(String tableName) {
    return tablePrefix + super.tableName(tableName);
  }

}
