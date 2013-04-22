/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.customerservice.serviceitem;

import java.math.BigDecimal;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.customerservice.Rate;
import gov.nih.nci.calims2.domain.administration.customerservice.Service;
import gov.nih.nci.calims2.domain.administration.customerservice.ServiceItem;

/**
 * Helper class for service item sub total calculations.
 * 
 * @author viseem
 * 
 */
public class ServiceItemHelper {

  /**
   * Give the sub total value from quantity and rate.
   * 
   * @param row The ServiceItem type
   * @return The sub total corresponding to the given value. Returns null if the subtotal can not be calculated
   */
  public static BigDecimal getsubTotalValue(ServiceItem row) {
    Quantity quantity = row.getQuantity();
    Rate rate = row.getServiceItemRate();
    if (quantity == null || StringUtils.isBlank(quantity.getValue()) || rate == null || rate.getQuantity() == null
        || StringUtils.isBlank(rate.getQuantity().getValue())) {
      return null;
    }
    BigDecimal bigDecQty = new BigDecimal(quantity.getValue());
    BigDecimal bigDecRate = new BigDecimal(rate.getQuantity().getValue());
    BigDecimal subtotal = bigDecQty.multiply(bigDecRate);
    return subtotal;
  }

  /**
   * Gets the total for the given service.
   * 
   * @param service The service for which the calculation must be done
   * @return the total for the given service. or null if any serviceItem is not computable
   */
  public static BigDecimal getServiceTotal(Service service) {
    BigDecimal subtotal = new BigDecimal("0");
    Set<ServiceItem> serviceItems = service.getServiceItemCollection();
    if (serviceItems != null) {
      for (ServiceItem serviceItem : serviceItems) {
        BigDecimal itemSubTotal = getsubTotalValue(serviceItem);
        if (itemSubTotal == null) {
          return null;
        }
        subtotal = subtotal.add(ServiceItemHelper.getsubTotalValue(serviceItem));
      }

    }
    return subtotal;
  }

}
