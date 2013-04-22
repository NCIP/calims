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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.Quantity;

/**
 * @author viseem
 * 
 */
public class QuantityFormHelperTest {

  private static final Long[] TYPE_IDS = new Long[] {1L, 2L, 3L };
  private static final String[] VALUES = new String[] {"1.0", "2.0", " " };
  private static final Long[] UNIT_IDS = new Long[] {1L, 2L, 3L };

  /**
   * test the getQuantities method.
   */
  @Test
  public void testGetQuantities() {
    QuantityFormHelper formHelper = new QuantityFormHelper();
    formHelper.setTypeIds(Arrays.asList(TYPE_IDS));
    formHelper.setValues(Arrays.asList(VALUES));
    formHelper.setUnitIds(Arrays.asList(UNIT_IDS));
    Set<Quantity> quantities = formHelper.getQuantities();
    assertNotNull("No result returned", quantities);
    assertEquals("Wrong result size", 2, quantities.size());
    Map<Long, Quantity> result = new HashMap<Long, Quantity>();
    for (Quantity quantity : quantities) {
      result.put(quantity.getType().getId(), quantity);
    }
    for (int i = 0; i < 2; i++) {
      Quantity quantity = result.get(TYPE_IDS[i]);
      assertEquals("Wrong value in quntity[" + i + "]", VALUES[i], quantity.getValue());
      assertNotNull("No unit in quntity[" + i + "]", quantity.getStandardUnit());
      assertEquals("Wrong unit id in quntity[" + i + "]", UNIT_IDS[i], quantity.getStandardUnit().getId());
    }
  }

}
