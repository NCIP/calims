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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Quantity;

/**
 * @author viseem
 *
 */
public class QuantityHelperMockup implements QuantityHelper {
  
  private TypeEnumeration savedQuantityType;
  private Collection<Quantity> savedQuantities;
  private boolean saveCreateMissing;
  private List<Quantity> result;

  /**
   * {@inheritDoc}
   */
  public List<Quantity> getQuantities(TypeEnumeration quantityType, Collection<Quantity> quantities, boolean createMissing) {
    savedQuantityType = quantityType;
    savedQuantities = quantities;
    saveCreateMissing = createMissing;
    result = new ArrayList<Quantity>();
    return result;
  }

  /**
   * @return the savedQuantityType
   */
  public TypeEnumeration getSavedQuantityType() {
    return savedQuantityType;
  }

  /**
   * @return the savedQuantities
   */
  public Collection<Quantity> getSavedQuantities() {
    return savedQuantities;
  }

  /**
   * @return the saveCreateMissing
   */
  public boolean getSaveCreateMissing() {
    return saveCreateMissing;
  }

  /**
   * @return the result
   */
  public List<Quantity> getResult() {
    return result;
  }

}
