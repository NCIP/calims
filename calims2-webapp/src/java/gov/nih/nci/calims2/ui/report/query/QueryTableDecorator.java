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

import java.util.List;

import gov.nih.nci.calims2.business.report.query.RootClauseSearch;
import gov.nih.nci.calims2.domain.report.Query;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Column;

/**
 * @author viseem
 *
 */
public class QueryTableDecorator extends CRUDTableDecorator<Query> {
  /**
   * {@inheritDoc}
   */
  public String getValue(Query query, Column column, Object value) {
    if ("mainEntity".equals(column.getName())) {
      return QueriedEntity.getByPersistentClass(query.getMainEntity()).getLocalizedValue(getLocale());
    }
    if ("whereClause".equals(column.getName())) {
      List<ClauseRow> clauses = QueryRowRenderer.renderClause(RootClauseSearch.getRootClause(query));
      return QueryRowRenderer.getWhereClauseAsString(clauses, getLocale());
    }
    return getDefaultValue(query, column, value);
  }
}
