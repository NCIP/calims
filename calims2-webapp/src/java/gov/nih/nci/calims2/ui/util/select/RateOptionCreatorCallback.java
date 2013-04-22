/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.util.select;

import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.uic.select.OptionCreatorCallback;

/**
 * @author connollym
 * 
 */
public class RateOptionCreatorCallback implements OptionCreatorCallback<Rate> {

  /**
   * {@inheritDoc}
   */
  public String getId(Rate option) {
    return option.getId().toString();
  }

  /**
   * {@inheritDoc}
   */
  public String getLabel(Rate option) {
    Quantity quantity = option.getQuantity();
    String quantityString = (quantity != null) ? quantity.getValue() : "";
    String unit = (quantity != null && quantity.getStandardUnit() != null) ? quantity.getStandardUnit().getDisplayName() : "";
    //return quantityString + "--" + unit + "--" + option.getDisplayName();
    return option.getDisplayName();
  }
}
