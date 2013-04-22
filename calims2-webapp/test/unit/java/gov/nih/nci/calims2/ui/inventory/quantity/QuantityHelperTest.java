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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import gov.nih.nci.calims2.business.common.type.TypeEnumeration;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.ui.util.GenericServiceMockupWithData;

/**
 * @author viseem
 * 
 */
public class QuantityHelperTest {
  private static final int TOTAL_TYPES = 3;
  private static final int LIMIT = 2;

  /**
   * test the getQuantities method with createMissing = true.
   */
  @Test
  public void testGetQuantitiesWithMissingTypes() {
    List<Type> types = createTypes();
    QuantityHelperImpl quantityHelper = new QuantityHelperImpl();
    GenericServiceMockupWithData<Type> typeService = new GenericServiceMockupWithData<Type>();
    typeService.setFindByNamedQueryResult(types);
    quantityHelper.setTypeService(typeService);
    Set<Quantity> quantities = createQuantities(types, LIMIT);
    List<Quantity> result = quantityHelper.getQuantities(TypeEnumeration.CONTAINER_QUANTITY, quantities, true);
    assertNotNull("No result returned", result);
    assertEquals("Wrong result size", types.size(), result.size());
    for (int i = 0; i < types.size(); i++) {
      Type type = types.get(i);
      Quantity quantity = result.get(i);
      assertEquals("Wrong type in quantity " + i, type, quantity.getType());
      String expectedValue = (i < LIMIT) ? Integer.toString(i) : null;
      assertEquals("Wrong value in quantity " + i, expectedValue, quantity.getValue());
      if (i < LIMIT) {
        assertEquals("Wrong unit in quantity " + i, new Long(i), quantity.getStandardUnit().getId());
      } else {
        assertNull("Wrong unit in quantity " + i, quantity.getStandardUnit());
      }
    }
  }

  /**
   * test the getQuantities method with createMissing = true.
   */
  @Test
  public void testGetQuantitiesWithoutMissingTypes() {
    List<Type> types = createTypes();
    QuantityHelperImpl quantityHelper = new QuantityHelperImpl();
    GenericServiceMockupWithData<Type> typeService = new GenericServiceMockupWithData<Type>();
    typeService.setFindByNamedQueryResult(types);
    quantityHelper.setTypeService(typeService);
    Set<Quantity> quantities = createQuantities(types, LIMIT);
    List<Quantity> result = quantityHelper.getQuantities(TypeEnumeration.CONTAINER_QUANTITY, quantities, false);
    assertNotNull("No result returned", result);
    assertEquals("Wrong result size", LIMIT, result.size());
    for (int i = 0; i < LIMIT; i++) {
      Type type = types.get(i);
      Quantity quantity = result.get(i);
      assertEquals("Wrong type in quantity " + i, type, quantity.getType());
      assertEquals("Wrong value in quantity " + i, Integer.toString(i), quantity.getValue());
      assertEquals("Wrong unit in quantity " + i, new Long(i), quantity.getStandardUnit().getId());
    }
  }

  private List<Type> createTypes() {
    List<Type> types = new ArrayList<Type>();
    for (int i = 0; i < TOTAL_TYPES; i++) {
      Type type = new Type();
      type.setId((long) i);
      types.add(type);
    }
    return types;
  }

  private Set<Quantity> createQuantities(List<Type> types, int limit) {
    Set<Quantity> quantities = new HashSet<Quantity>();
    for (int i = 0; i < limit; i++) {
      Quantity quantity = new Quantity();
      quantity.setType(types.get(i));
      quantity.setValue(Integer.toString(i));
      StandardUnit unit = new StandardUnit();
      unit.setId((long) i);
      quantity.setStandardUnit(unit);
      quantities.add(quantity);
    }
    return quantities;
  }

}
