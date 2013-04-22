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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.edsdev.jconvert.domain.Conversion;
import com.edsdev.jconvert.domain.ConversionType;
import com.edsdev.jconvert.logic.ConversionGapBuilder;
import com.edsdev.jconvert.presentation.ConversionTypeData;

import gov.nih.nci.calims2.dao.GenericDao;
import gov.nih.nci.calims2.domain.administration.Quantity;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.common.Type;

/**
 * @author viseem
 * 
 */
public class JConvertAdapter implements UnitConverter {
  
  private GenericDao genericDao;

  /**
   * {@inheritDoc}
   */
  public void unitCreated(StandardUnit unit) {
    // Nothing to do
  }

  /**
   * {@inheritDoc}
   */
  public void unitDeleted(StandardUnit unit) {
    // Nothing to do
  }

  /**
   * {@inheritDoc}
   */
  public void unitUpdated(StandardUnit unit) {
    // Nothing to do
  }

  /**
   * {@inheritDoc}
   */
  public Quantity convert(Quantity from, StandardUnit toUnit) {
    checkInputs(from, toUnit);
    ConversionTypeData conversionTypeData = getConversionTypeData(from.getStandardUnit().getType());
    String fromUnitId = from.getStandardUnit().getId().toString();
    String toUnitId = toUnit.getId().toString();
    double value = conversionTypeData.convert(from.getValue(), fromUnitId, toUnitId);
    Quantity result = new Quantity();
    result.setStandardUnit(toUnit);
    result.setType(from.getType());
    result.setValue(Double.toString(value));
    return result;
  }

  private void checkInputs(Quantity from, StandardUnit toUnit) {
    if (from == null) {
      throw new UnitConversionException("Missing Quantity parameter");
    }
    if (StringUtils.isBlank(from.getValue())) {
      throw new UnitConversionException("Missing Quantity value");
    }
    checkUnit(from.getStandardUnit(), "from unit");
    checkUnit(toUnit, "to unit");
    if (!from.getStandardUnit().getType().getId().equals(toUnit.getType().getId())) {
      throw new UnitConversionException("Incompatible units");
    }
  }

  private void checkUnit(StandardUnit unit, String kind) {
    if (unit == null) {
      throw new UnitConversionException(kind + " missing");
    }
    if (unit.getId() == null) {
      throw new UnitConversionException(kind + " has no Id");
    }
    if (unit.getType() == null || unit.getType().getId() == null) {
      throw new UnitConversionException(kind + " type unknown");
    }
  }
  
  private ConversionTypeData getConversionTypeData(Type type) {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("typeId", type.getId());
    List<StandardUnit> units = genericDao.findByNamedQuery(StandardUnit.class.getName() + ".findByType", params);
    ConversionType conversionType = new ConversionType();
    conversionType.setTypeName(type.getId().toString());
    for (StandardUnit unit : units) {
      String fromUnitId = unit.getId().toString();
      String toUnitId = unit.getBaseUnit().getId().toString();
      String factor = unit.getConversionFactor().toPlainString();
      Conversion conversion = Conversion.createInstance(fromUnitId, fromUnitId, toUnitId, toUnitId, factor, 0.0);
      conversionType.addConversion(conversion);
    }
    ConversionGapBuilder.createOneToOneConversions(conversionType);
    ConversionGapBuilder.createMissingConversions(conversionType);
    return new ConversionTypeData(conversionType);
  }
  
  /**
   * @param genericDao the genericDao to set
   */
  public void setGenericDao(GenericDao genericDao) {
    this.genericDao = genericDao;
  }

}
