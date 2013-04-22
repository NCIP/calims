/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.business.administration.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import gov.nih.nci.calims2.domain.administration.BaseUnit;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.common.Type;

/**
 * @author viseem
 *
 */
public class JConvertAdapterTest {
  
  private static final long METER_ID = 2L;
  private static final BigDecimal METER_FACTOR = new BigDecimal(1);
  private static final long KILOMETER_ID = 3L;
  private static final BigDecimal KILOMETER_FACTOR = new BigDecimal(1000);
  
  private JConvertAdapter adapter;
  private UnitDaoMockup dao;
  private List<StandardUnit> units;
  
  /**
   * Test the convert method.
   */
  @Test
  public void testConvertSuccess() {
    initMockup();
    Quantity from = new Quantity();
    from.setValue("1");
    from.setStandardUnit(units.get(0));
    Quantity result = adapter.convert(from, units.get(1));
    assertNotNull(result);
    assertEquals("Wrong converted value", new Double("0.001"), new Double(result.getValue()));
    assertEquals("Wrong result unit", units.get(1), result.getStandardUnit());
    assertEquals("Wrong query name passed to the dao", StandardUnit.class.getName() + ".findByType", dao.getQueryName());
    Map<String, Object> params = dao.getParameterValues();
    assertNotNull("No parameter passed to the dao", params);
    assertEquals("Wrong number of parameters passed to the dao", 1, params.size());
    assertEquals("Wrong type id parameter", new Long(1), params.get("typeId"));
  }
  
  private void initMockup() {
    adapter = new JConvertAdapter();
    dao = new UnitDaoMockup();
    units = createUnits();
    dao.setResult(units);
    adapter.setGenericDao(dao);
  }
  
  private List<StandardUnit> createUnits() {
    List<StandardUnit> list = new ArrayList<StandardUnit>();
    Type type = new Type();
    type.setId(1L);
    type.setName("length");
    BaseUnit baseUnit = new BaseUnit();
    baseUnit.setId(1L);
    baseUnit.setType(type);
    baseUnit.setName("meter");
    StandardUnit meter = new StandardUnit();
    meter.setId(METER_ID);
    meter.setType(type);
    meter.setName("meter");
    meter.setBaseUnit(baseUnit);
    meter.setConversionFactor(METER_FACTOR);
    list.add(meter);
    StandardUnit kilometer = new StandardUnit();
    kilometer.setId(KILOMETER_ID);
    kilometer.setType(type);
    kilometer.setName("kilometer");
    kilometer.setBaseUnit(baseUnit);
    kilometer.setConversionFactor(KILOMETER_FACTOR);
    list.add(kilometer);
    return list;
  }

}
