/*L
 * Copyright Moxie Informatics.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/calims/LICENSE.txt for details.
 */

/**
 *
 */
package gov.nih.nci.calims2.ui.administration.baseunit;

import gov.nih.nci.calims2.domain.administration.BaseUnit;
import gov.nih.nci.calims2.domain.common.Type;
import gov.nih.nci.calims2.domain.interfaces.EntityWithIdHelper;
import gov.nih.nci.calims2.ui.generic.crud.CRUDForm;

/**
 * @author katariap
 *
 */
public class BaseUnitForm extends CRUDForm<BaseUnit> {

  private static final long serialVersionUID = -6010765931860899363L;

  private Long typeId;
  private Long unitId;
  

  /**
   * Default constructor.
   */
  public BaseUnitForm() {
    setEntity(new BaseUnit());
  }

  /**
   * {@inheritDoc}
   */
  public BaseUnit getSubmittedEntity() {
    
    BaseUnit baseUnit = getEntity();
    baseUnit.setType(EntityWithIdHelper.createEntity(Type.class, typeId));
    return baseUnit;
  }

  /**
   * @return the typeId
   */
  public Long getTypeId() {
    return typeId;
  }

  /**
   * @param typeId the typeId to set
   */
  public void setTypeId(Long typeId) {
    this.typeId = typeId;
  }

 
  /**
   * @return the unitId
   */
  public Long getUnitId() {
    return unitId;
  }

  /**
   * @param unitId the unitId to set
   */
  public void setUnitId(Long unitId) {
    this.unitId = unitId;
  }
}