/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.report.query;

import java.util.Collection;

import gov.nih.nci.calims2.business.generic.AuditableCRUDEventListener;
import gov.nih.nci.calims2.dao.GenericDao;
import gov.nih.nci.calims2.domain.report.Clause;
import gov.nih.nci.calims2.domain.report.Query;

/**
 * @author viseem
 *
 */
public class QueryCRUDEventListener extends AuditableCRUDEventListener<Query> {
  
  private static final String[] EXCLUDED_PROPERTIES = new String[] {"clauseCollection" };

  private GenericDao genericDao;
  
  /**
   * Default constructor.
   */
  public QueryCRUDEventListener() {
    setAdditionalExcludedProperties(EXCLUDED_PROPERTIES);
  }
  
  /**
   * {@inheritDoc}
   */
  public Query beforeCopy(Query inputEntity) {
    Query copy = beforeCreate(inputEntity);
    Clause rootClause = RootClauseSearch.getRootClause(inputEntity);
    if (rootClause != null) {
      ClauseCopier copier = new ClauseCopier(copy);
      rootClause.accept(copier);
      copy.setClauseCollection(copier.getCopies());
    }
    return copy;
  }
  
  /**
   * {@inheritDoc}
   */
  public void afterCreate(Query inputEntity, Query savedEntity) {
    super.afterCreate(inputEntity, savedEntity);
    Clause rootClause = RootClauseSearch.getRootClause(inputEntity);
    if (rootClause != null) {
      ClauseSaver.saveClause(genericDao, savedEntity, rootClause);
    }
  }
  
  /**
   * {@inheritDoc}
   */
  public Query beforeUpdate(Query inputEntity, Query existingEntity) {
    Query entity = super.beforeUpdate(inputEntity, existingEntity);
    Clause rootClause = RootClauseSearch.getRootClause(entity);
    if (rootClause != null) {
      ClauseEraser.deleteClause(genericDao, rootClause);
    }
    rootClause = RootClauseSearch.getRootClause(inputEntity);
    if (rootClause != null) {
      ClauseSaver.saveClause(genericDao, existingEntity, rootClause);
    }
    entity.setClauseCollection(inputEntity.getClauseCollection());
    return entity;
  }
  
  /**
   * {@inheritDoc}
   */
  public void beforeDelete(Query existingEntity) {
    Collection<Clause> clauses = existingEntity.getClauseCollection();
    if (clauses != null) {
      for (Clause clause : clauses) {
        genericDao.delete(clause);
      }
    }
  }
  
  /**
   * @param genericDao the genericDao to set
   */
  public void setGenericDao(GenericDao genericDao) {
    this.genericDao = genericDao;
  }
  
}
