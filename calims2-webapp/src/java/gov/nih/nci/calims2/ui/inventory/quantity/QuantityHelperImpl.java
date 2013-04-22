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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.common.Type;

/**
 * @author viseem
 *
 */
public class QuantityHelperImpl implements QuantityHelper {
  
  private static final String TYPE_QUERY = Type.class.getName() + ".findByDataElementCollection";
  
  private GenericService<Type> typeService;
  
  /**
   * {@inheritDoc}
   */
  public List<Quantity> getQuantities(TypeEnumeration quantityType, Collection<Quantity> quantities, boolean createMissing) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("dataElementCollection", quantityType.name());
    List<Type> quantityTypes = typeService.findByNamedQuery(TYPE_QUERY, params);
    Map<Long, Quantity> map = new HashMap<Long, Quantity>();
    if (quantities != null) {
      for (Quantity quantity : quantities) {
        map.put(quantity.getType().getId(), quantity);
      }
    }
    List<Quantity> result = new ArrayList<Quantity>();
    for (Type type : quantityTypes) {
      if (map.containsKey(type.getId())) {
        Quantity quantity = map.get(type.getId());
        quantity.setType(type);
        result.add(quantity);
      } else {
        if (createMissing) {
          Quantity newQuantity = new Quantity();
          newQuantity.setType(type);
          result.add(newQuantity);
        }
      }
    }
    return result;
  }

  /**
   * @return the typeService
   */
  public GenericService<Type> getTypeService() {
    return typeService;
  }

  /**
   * @param typeService the typeService to set
   */
  public void setTypeService(GenericService<Type> typeService) {
    this.typeService = typeService;
  }

}
