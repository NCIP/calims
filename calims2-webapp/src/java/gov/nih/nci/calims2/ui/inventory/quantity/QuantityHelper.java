/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.inventory.quantity;

import java.util.Collection;
import java.util.List;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Quantity;

/**
 * Helper class for the input/output of quantities.
 * 
 * @author viseem
 * 
 */
public interface QuantityHelper {
  /**
   * Creates a list of quantities objects for display/input.
   * 
   * @param quantityType The type of quantities to return
   * @param quantities The quantities already associated to the containing class
   * @param createMissing True if quantities missing in the container class must be added.
   * @return a list of quantities objects for display/input.
   */
  List<Quantity> getQuantities(TypeEnumeration quantityType, Collection<Quantity> quantities, boolean createMissing);

}
