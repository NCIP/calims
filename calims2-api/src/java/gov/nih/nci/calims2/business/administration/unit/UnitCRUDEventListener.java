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

import java.math.BigDecimal;

import gov.nih.nci.calims2.business.generic.CRUDEventListenerAdapter;
import gov.nih.nci.calims2.business.generic.GenericService;
import gov.nih.nci.calims2.business.util.validation.ValidationException;
import gov.nih.nci.calims2.domain.administration.BaseUnit;
import gov.nih.nci.calims2.domain.administration.StandardUnit;
import gov.nih.nci.calims2.domain.administration.Unit;

/**
 * @author connollym
 * 
 */
public class UnitCRUDEventListener extends CRUDEventListenerAdapter<Unit> {

  private GenericService<StandardUnit> unitService;
  private UnitConverter unitConverter;

  /**
   * {@inheritDoc}
   */
  public void afterCreate(Unit input, Unit savedEntity) {
    if (unitConverter != null && savedEntity instanceof StandardUnit) {
      unitConverter.unitCreated((StandardUnit) savedEntity);
    }
    
    if (savedEntity instanceof BaseUnit) {
      StandardUnit standardUnit = new StandardUnit();
      standardUnit.setName(savedEntity.getName());
      standardUnit.setDisplayName(savedEntity.getDisplayName());
      standardUnit.setDescription(savedEntity.getDescription());
      standardUnit.setType(savedEntity.getType());
      standardUnit.setBaseUnit((BaseUnit) savedEntity);
      standardUnit.setConversionFactor(BigDecimal.ONE);
      try {
        unitService.create(standardUnit);
      } catch (ValidationException e) {
        throw new InternalError("This cannot happen");
      }
    }
  }

  /**
   * {@inheritDoc}
   */
  public void afterUpdate(Unit updatedEntity) {
    if (unitConverter != null && updatedEntity instanceof StandardUnit) {
      unitConverter.unitUpdated((StandardUnit) updatedEntity);
    }
  }

  /**
   * {@inheritDoc}
   */
  public void afterDelete(Unit deletedEntity) {
    if (unitConverter != null && deletedEntity instanceof StandardUnit) {
      unitConverter.unitDeleted((StandardUnit) deletedEntity);
    }
  }

  /**
   * @param unitConverter the unitConverter to set
   */
  public void setUnitConverter(UnitConverter unitConverter) {
    this.unitConverter = unitConverter;
  }

  /**
   * @param unitService the unitService to set.
   */
  public void setUnitService(GenericService<StandardUnit> unitService) {
    this.unitService = unitService;
  }

}
