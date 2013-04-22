/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.rate;

import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.ui.generic.crud.CRUDTableDecorator;
import gov.nih.nci.calims2.uic.descriptor.table.Column;

/**
 * @author connollym
 *
 */
public class RateTableDecorator extends CRUDTableDecorator<Rate> {

  /**
   * {@inheritDoc}
   */
  public String getValue(Rate row, Column column, Object value) {
    if ("quantity".equals(column.getName())) {
      Quantity cost = row.getQuantity();
      return cost.getStandardUnit().getDisplayName() + "" + cost.getValue();
    }
    return getDefaultValue(row, column, value);
  }
}
