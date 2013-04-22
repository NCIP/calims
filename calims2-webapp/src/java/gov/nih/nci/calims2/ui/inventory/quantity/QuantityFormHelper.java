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

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;

/**
 * Helper class for the input of an array of quantities in a form.
 * 
 * @author viseem
 * 
 */
public class QuantityFormHelper implements Serializable {

  private static final long serialVersionUID = 4109324856759174745L;
  
  private List<Long> typeIds;
  private List<String> values;
  private List<Long> unitIds;

  /**
   * Gets the quantities data as a collection of quantity objects.
   * 
   * @return the quantities data as a collection of quantity objects.
   */
  public Set<Quantity> getQuantities() {
    Set<Quantity> quantities = new HashSet<Quantity>();
    if (typeIds != null) {
      for (int i = 0; i < typeIds.size(); i++) {
        String value = values.get(i);
        if (StringUtils.isNotBlank(value)) {
          Quantity quantity = new Quantity();
          quantity.setType(EntityWithIdHelper.createEntity(Type.class, typeIds.get(i)));
          quantity.setValue(value);
          quantity.setStandardUnit(EntityWithIdHelper.createEntity(StandardUnit.class, unitIds.get(i)));
          quantities.add(quantity);
        }
      }
    }
    return quantities;
  }

  /**
   * @return the typeIds
   */
  public List<Long> getTypeIds() {
    return typeIds;
  }

  /**
   * @param typeIds the typeIds to set
   */
  public void setTypeIds(List<Long> typeIds) {
    this.typeIds = typeIds;
  }

  /**
   * @return the values
   */
  public List<String> getValues() {
    return values;
  }

  /**
   * @param values the values to set
   */
  public void setValues(List<String> values) {
    this.values = values;
  }

  /**
   * @return the unitIds
   */
  public List<Long> getUnitIds() {
    return unitIds;
  }

  /**
   * @param unitIds the unitIds to set
   */
  public void setUnitIds(List<Long> unitIds) {
    this.unitIds = unitIds;
  }

}
